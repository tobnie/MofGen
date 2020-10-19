/*
 * generated by Xtext 2.20.0
 */
package org.mofgen.validation

import com.google.inject.Inject
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.validation.Check
import org.mofgen.interpreter.Calculator
import org.mofgen.interpreter.MismatchingTypesException
import org.mofgen.interpreter.TypeCalculator
import org.mofgen.interpreter.TypeRegistry
import org.mofgen.mGLang.ArithmeticExpression
import org.mofgen.mGLang.ForBody
import org.mofgen.mGLang.GenCaseWithCast
import org.mofgen.mGLang.GenWhenCase
import org.mofgen.mGLang.Import
import org.mofgen.mGLang.List
import org.mofgen.mGLang.MGLangPackage
import org.mofgen.mGLang.Map
import org.mofgen.mGLang.Node
import org.mofgen.mGLang.NodeAttributeAssignment
import org.mofgen.mGLang.ParamManipulation
import org.mofgen.mGLang.Pattern
import org.mofgen.mGLang.PatternCall
import org.mofgen.mGLang.PatternCaseWithCast
import org.mofgen.mGLang.PatternNodeReference
import org.mofgen.mGLang.PatternWhenCase
import org.mofgen.mGLang.RangeForHead
import org.mofgen.mGLang.RefOrCall
import org.mofgen.mGLang.Variable
import org.mofgen.mGLang.VariableManipulation
import org.mofgen.typeModel.TypeModelPackage
import org.mofgen.utils.MofgenModelUtils
import org.mofgen.mGLang.Collection
import org.mofgen.mGLang.GenReturn
import org.mofgen.mGLang.Generator
import org.mofgen.mGLang.PatternCallParameters
import org.mofgen.mGLang.PatternCaseWithoutCast
import org.mofgen.mGLang.RefParams
import org.mofgen.mGLang.ForRange
import org.mofgen.mGLang.GenCaseWithoutCast
import org.mofgen.mGLang.ListAdHoc
import org.mofgen.mGLang.MapTupel

/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class MGLangValidator extends AbstractMGLangValidator {

	@Inject Calculator calc
	@Inject TypeCalculator typeChecker

	/**
	 * Checks for a valid for range.
	 */
	@Check
	def validForRange(RangeForHead head) {
		val forRange = head.range
		if (forRange !== null) {
			if (forRange.start !== null && forRange.end !== null) {
				val start = forRange.start
				val end = forRange.end
				val check1 = checkForNumber(forRange.start, forRange, MGLangPackage.Literals.FOR_RANGE__START)
				val check2 = checkForNumber(forRange.end, forRange, MGLangPackage.Literals.FOR_RANGE__END)
				if (check1 && check2) {
					val castStart = calc.evaluate(start) as Double
					val castEnd = calc.evaluate(end) as Double
					if (castStart > castEnd) {
						error("Limiting bound is less than starting value",
							MGLangPackage.Literals.RANGE_FOR_HEAD__RANGE)
					}
				}
			}
		}
	}

	/**
	 * Error at errorLoc if the given obj does not evaluate to a numerical value.
	 */
	def private checkForNumber(ArithmeticExpression expr, EObject obj, EReference errorLoc) {
		try {
			val eval = typeChecker.evaluate(expr)
			if (eval instanceof Pattern) {
				error("For-Range needs numerical bounds but was given type " + eval.name, obj, errorLoc)
				return false
			} else if (eval !== TypeModelPackage.Literals.NUMBER) {
				error("For-Range needs numerical bounds but was given type " + (eval as EClass).name, obj, errorLoc)
				return false
			} else {
				return true
			}
		} catch (MismatchingTypesException e) {
			error(e.message, obj, errorLoc)
		}
	}

	/**
	 * Warns for empty for-loops.
	 */
	@Check
	def warnEmptyForLoop(ForBody body) {
		if (body.commands.empty) {
			warning("empty for-loop", body.eContainer, MGLangPackage.Literals.FOR_STATEMENT__HEAD)
		}
	}

	/** 
	 * Checks whether the value given in a when-expression is boolean.
	 */
	@Check
	def checkBooleanWhenPattern(PatternWhenCase caze) {
		if (caze.when !== null) {
			try {
				val res = typeChecker.evaluate(caze.when)
				if (res !== TypeModelPackage.Literals.BOOLEAN) {
					error("Needs boolean value for conditional expression", caze,
						MGLangPackage.Literals.PATTERN_WHEN_CASE__WHEN)
				}
			} catch (MismatchingTypesException e) {
				error(e.message, caze, MGLangPackage.Literals.PATTERN_WHEN_CASE__WHEN)
			}
		}
	}

	/** 
	 * Checks whether the value given in a when-expression is boolean.
	 */
	@Check
	def checkBooleanWhenGen(GenWhenCase caze) {
		if (caze.when !== null) {
			try {
				val res = typeChecker.evaluate(caze.when)
				if (res !== TypeModelPackage.Literals.BOOLEAN) {
					error("Needs boolean value for conditional expression", caze,
						MGLangPackage.Literals.GEN_WHEN_CASE__WHEN)
				}
			} catch (MismatchingTypesException e) {
				error(e.message, caze, MGLangPackage.Literals.GEN_WHEN_CASE__WHEN)
			}
		}
	}

	/** 
	 * Checks whether the value given in a when-expression is boolean.
	 */
	@Check
	def checkBooleanWhenPatternWithCast(PatternCaseWithCast caze) {
		if (caze.when !== null) {
			try {
				val res = typeChecker.evaluate(caze.when)
				if (res !== TypeModelPackage.Literals.BOOLEAN) {
					error("Needs boolean value for conditional expression", caze,
						MGLangPackage.Literals.PATTERN_CASE_WITH_CAST__WHEN)
				}
			} catch (MismatchingTypesException e) {
				error(e.message, caze, MGLangPackage.Literals.PATTERN_CASE_WITH_CAST__WHEN)
			}
		}
	}

	/** 
	 * Checks whether the value given in a when-expression is boolean.
	 */
	@Check
	def checkBooleanWhenGenWithCast(GenCaseWithCast caze) {
		if (caze.when !== null) {
			try {
				val res = typeChecker.evaluate(caze.when)
				if (res !== TypeModelPackage.Literals.BOOLEAN) {
					error("Needs boolean value for conditional expression", caze,
						MGLangPackage.Literals.GEN_CASE_WITH_CAST__WHEN)
				}
			} catch (MismatchingTypesException e) {
				error(e.message, caze, MGLangPackage.Literals.GEN_CASE_WITH_CAST__WHEN)
			}
		}
	}

	@Check
	def exactlyOneReturn(Generator gen){
		val retCount = gen.commands.filter(GenReturn).length
		if(retCount > 1){
			error("Only one return per generator allowed", MGLangPackage.Literals.GENERATOR__COMMANDS)
		}
		if(retCount < 1){
			error("Generator block needs return with containment root", MGLangPackage.Literals.GENERATOR__COMMANDS)
		}
	}

	@Check
	def checkNoLinesAfterReturn(GenReturn ret) {
		val gen = EcoreUtil2.getContainerOfType(ret, Generator)
		val genCommands = gen.commands
		if(genCommands.indexOf(ret) !== genCommands.length - 1){
			warning("This return suppresses lines of code following afterwards", MGLangPackage.Literals.GEN_RETURN__RETURN_VALUE)
		}
	}

	/**
	 * Warns for imported models with conflicting class names.
	 */
	@Check
	def checkForImportConflicts(Import imp) {
		var imports = EcoreUtil2.getAllContentsOfType(MofgenModelUtils.getRootFile(imp), Import)
		imports.remove(imp)
		val duplicateClasses = checkImportsForDuplicates(imports, imp)
		if (!duplicateClasses.isEmpty) {
			warning("Import conflict for classes with names" + duplicateClasses.toString,
				MGLangPackage.Literals.IMPORT__URI)
		}
	}

	def checkImportsForDuplicates(java.util.List<Import> imps, Import otherImp) {
		var conflicts = newLinkedList()

		if(imps.isEmpty) return conflicts

		val classes = MofgenModelUtils.getClassesFromImportList(imps)
		val otherClasses = MofgenModelUtils.getClassesFromImport(otherImp)
		for (otherClass : otherClasses) {
			if (classes.contains(otherClass)) {
				conflicts.add(otherClass.name)
			}
		}
		return conflicts
	}

	/**
	 * Forbid attributes and references with multiplicity 1. Still allowed are additions to *-references by adding them to the collection.
	 */
	@Check
	def checkParamManipulation(ParamManipulation manip) {
		val refsAssigns = manip.content.refsAssigns
		for (refAssign : refsAssigns) {
			switch refAssign {
				NodeAttributeAssignment:
					error("No assignments to attributes of parameter node allowed.", refAssign,
						MGLangPackage.Literals.NODE_ATTRIBUTE_ASSIGNMENT__TARGET)
				PatternNodeReference: {
					if (refAssign.type.upperBound == 1) {
						error("No assignments to 1-edges/-references of parameter nodes allowed.", refAssign,
							MGLangPackage.Literals.PATTERN_NODE_REFERENCE__TYPE)
					}
				}
			}
		}
	}

	@Check
	def checkAttributeType(NodeAttributeAssignment ass) {
		val trg = ass.target
		if (trg instanceof EAttribute) {
			val attribute = trg as EAttribute
			val attributeType = MofgenModelUtils.getEClassForInternalModel(attribute.EAttributeType)

			try {
				val assignedValueEval = typeChecker.evaluate(ass.value)
				if (assignedValueEval instanceof EClass) {
					val assignedValue = MofgenModelUtils.getEClassForInternalModel(assignedValueEval)
					if (assignedValue != TypeModelPackage.Literals.ENUM_LITERAL &&
						attributeType == TypeModelPackage.Literals.ENUM) {
						error("Can only assign enum values to enum attribute " + attribute.name,
							MGLangPackage.Literals.NODE_ATTRIBUTE_ASSIGNMENT__VALUE)
					} else {
						if (assignedValue == TypeModelPackage.Literals.ENUM_LITERAL &&
							attributeType != TypeModelPackage.Literals.ENUM) {
							error("Cannot assign enum value to non-enum attribute " + attribute.name,
								MGLangPackage.Literals.NODE_ATTRIBUTE_ASSIGNMENT__VALUE)
						}
					}
				} else {
					throw new UnsupportedOperationException("Assigned value is a pattern") // Patterns can only return nodes and no primitive values, therefore this case should not occur...
				}
			} catch (MismatchingTypesException e) {
				error(e.message, ass, MGLangPackage.Literals.NODE_ATTRIBUTE_ASSIGNMENT__VALUE)
			}
		}
	}

	@Check
	def matchingParameters_pc(PatternCall pc) {
		// check parameter count
		var neededParams = 0
		var actualParams = 0

		if (pc.called.parameters !== null) {
			neededParams = pc.called.parameters.length
		}
		if (pc.params.params !== null) {
			actualParams = pc.params.params.length
		}

		if (neededParams != actualParams) {
			error("Pattern " + pc.called.name + " expects " + neededParams + " parameters but was given " +
				actualParams, MGLangPackage.Literals.PATTERN_CALL__PARAMS)
			return;
		}

		// check parameter types
		for (i : 0 ..< pc.params.params.length) {
			val givenParameterExpression = pc.params.params.get(i)
			val neededParameter = pc.called.parameters.get(i)

			val givenParameterType = typeChecker.evaluate(givenParameterExpression)
			if (givenParameterType === null) {
				return; // TODO ?
			}

			val neededParameterType = MofgenModelUtils.getInternalParameterType(neededParameter)

			if (givenParameterType instanceof EClass && neededParameterType instanceof EClass) {
				if (!((neededParameterType as EClass).isSuperTypeOf(givenParameterType as EClass))) {
					val givenParameterTypeEClass = givenParameterType as EClass
					// TODO Is it right that any object fits into an eobject parameter?
					if (neededParameterType !== EcorePackage.Literals.EOBJECT) {
						if (givenParameterType !== neededParameterType) {
							error("Given type " + givenParameterTypeEClass.name + " does not match needed type " +
								(neededParameterType as EClass).name, MGLangPackage.Literals.PATTERN_CALL__PARAMS)
						}
					}
				}
			} else if (givenParameterType instanceof Pattern && neededParameterType instanceof Pattern) {
				val givenParameterPattern = givenParameterType as Pattern
				val neededParameterPattern = neededParameterType as Pattern
				if (!givenParameterPattern.name.equals(neededParameterPattern.name)) {
					error("Given Pattern " + givenParameterPattern.name + " does not match needed Pattern " +
						neededParameterPattern.name, MGLangPackage.Literals.PATTERN_CALL__PARAMS)
				}
			} else {
				if (givenParameterType instanceof Pattern) {
					error("Given Pattern " + givenParameterType.name + " does not match needed type " +
						(neededParameterType as EClass).name, MGLangPackage.Literals.PATTERN_CALL__PARAMS)
				} else {
					val givenParameterTypeEClass = givenParameterType as EClass
					error("Given type " + givenParameterTypeEClass.name + " does not match needed Pattern " +
						(neededParameterType as Pattern).name, MGLangPackage.Literals.PATTERN_CALL__PARAMS)
				}
			}
		}
	}

	@Check
	def checkTypeForNodeCreationByPatternCall(Node node) {
		// TODO Is it right that anything fits into eobject?
		if (node.type !== EcorePackage.Literals.EOBJECT) {
			if (node.createdBy instanceof PatternCall) {
				val pc = node.createdBy as PatternCall
				val ret = pc.called.^return
				if (ret === null) {
					error("Pattern " + pc.called.name + " returns null but " + node.name + " expects " + node.type.name,
						MGLangPackage.Literals.NODE__CREATED_BY)
				} else {
					val retVal = ret.returnValue
					if (retVal === null) {
						error(
							"Pattern " + pc.called.name + " returns " + pc.called.name + " but " + node.name +
								" expects " + node.type.name, MGLangPackage.Literals.NODE__CREATED_BY)
					} else {
						if (retVal.type !== node.type) {
							error(
								"Pattern " + pc.called.name + " returns " + pc.called.^return.returnValue.type.name +
									" but " + node.name + " expects " + node.type.name,
								MGLangPackage.Literals.NODE__CREATED_BY)
						}
					}
				}
			}
		}

	}

	@Check
	def noVariableAccessBeforeDefinition(RefOrCall roc) {
		if (roc.target === null) {
			val ref = roc.ref
			if (ref instanceof Variable) {
				var rocNode = NodeModelUtils.getNode(roc)
				val varNode = NodeModelUtils.getNode(ref)
				if (rocNode.startLine < varNode.startLine) {
					error("Variable " + ref.name + " is not defined", MGLangPackage.Literals.REF_OR_CALL__REF)
				}
			}
			if (ref instanceof Collection) {
				var rocNode = NodeModelUtils.getNode(roc)
				val varNode = NodeModelUtils.getNode(ref)
				if (rocNode.startLine < varNode.startLine) {
					error("Collection " + ref.name + " is not defined", MGLangPackage.Literals.REF_OR_CALL__REF)
				}
			}
		}
	}

	@Check
	def noVariableWithNullReturningPattern(PatternCall pc) {
		if (pc.eContainer instanceof Variable) {
			if (pc.called.^return === null) {
				error("Cannot define variable by calling a pattern with no return", pc.eContainer as Variable,
					MGLangPackage.Literals.VARIABLE__VALUE);
			}
		}
	}
	
	@Check
	def illegalArithmeticExpressionVar(ArithmeticExpression ae) {
		try {
			typeChecker.evaluate(ae)
		} catch (MismatchingTypesException e) {
			val container = ae.eContainer
			switch container {
				Variable: error(e.message, container, MGLangPackage.Literals.VARIABLE__VALUE)
				PatternCallParameters: error(e.message, container, MGLangPackage.Literals.PATTERN_CALL_PARAMETERS__PARAMS)
				NodeAttributeAssignment: error(e.message, container, MGLangPackage.Literals.NODE_ATTRIBUTE_ASSIGNMENT__VALUE)
				PatternWhenCase: error(e.message, container, MGLangPackage.Literals.PATTERN_WHEN_CASE__WHEN)
				PatternCaseWithCast: error(e.message, container, MGLangPackage.Literals.PATTERN_CASE_WITH_CAST__WHEN)
				PatternCaseWithoutCast: error(e.message, container, MGLangPackage.Literals.PATTERN_CASE_WITHOUT_CAST__VAL)
				RefParams: error(e.message, container, MGLangPackage.Literals.REF_PARAMS__PARAMS)
				VariableManipulation: error(e.message, container, MGLangPackage.Literals.VARIABLE_MANIPULATION__VAL)
				ForRange: {
					if(ae === container.start){
						error(e.message, container, MGLangPackage.Literals.FOR_RANGE__START)
					}else{
						error(e.message, container, MGLangPackage.Literals.FOR_RANGE__END)
					}
				}
				GenWhenCase: error(e.message, container, MGLangPackage.Literals.GEN_WHEN_CASE__WHEN)
				GenCaseWithCast: error(e.message, container, MGLangPackage.Literals.GEN_CASE_WITH_CAST__WHEN)
				GenCaseWithoutCast: error(e.message, container, MGLangPackage.Literals.GEN_CASE_WITHOUT_CAST__VAL)
				ListAdHoc: error(e.message, container, MGLangPackage.Literals.LIST_AD_HOC__ELEMENTS)
				MapTupel: {
					if(ae === container.key){
						error(e.message, container, MGLangPackage.Literals.MAP_TUPEL__KEY)
					}else{
						error(e.message, container, MGLangPackage.Literals.MAP_TUPEL__VALUE)
					}
				}
			}
		}
	}

	@Check
	def noTypeChangeByVariableManipulation(VariableManipulation vm) {
		val variable = vm.^var
		val varType = TypeRegistry.getVarType(variable) as EObject
		try {
			val givenType = typeChecker.evaluate(vm.^val) as EObject

			var varTypeString = ""
			var givenTypeString = ""

			if (varType !== givenType) {
				if (varType instanceof Pattern) {
					varTypeString = varType.name
				}
				if (varType instanceof EClass) {
					varTypeString = varType.name
				}
				if (givenType instanceof Pattern) {
					givenTypeString = givenType.name
				}
				if (givenType instanceof EClass) {
					givenTypeString = givenType.name
				}

				error("Variable " + variable.name + " is of type " + varTypeString + ", not " + givenTypeString,
					MGLangPackage.Literals.VARIABLE_MANIPULATION__VAL)

			}
		} catch (MismatchingTypesException e) {
			error(e.message, MGLangPackage.Literals.VARIABLE_MANIPULATION__VAL)
		}

	}

	@Check
	def matchingParameters_roc(RefOrCall roc) {
		if (roc.ref instanceof EOperation) {
			if (!roc.bracesSet) {
				error("Missing parameter list", MGLangPackage.Literals.REF_OR_CALL__PARAMS)
				return;
			} else {
				val op = roc.ref as EOperation
				val givenParams = roc.params.params
				var neededParams = newLinkedList()

				if (op == TypeModelPackage.Literals.LIST___INDEX_OF__EOBJECT ||
					op == TypeModelPackage.Literals.LIST___ADD__EOBJECT ||
					op == TypeModelPackage.Literals.LIST___REMOVE__EOBJECT ||
					op == TypeModelPackage.Literals.LIST___CONTAINS__EOBJECT) {
					neededParams.add(TypeRegistry.getListType(roc.target.ref as List))
				} else if (op == TypeModelPackage.Literals.MAP___CONTAINS_KEY__EOBJECT ||
					op == TypeModelPackage.Literals.MAP___GET__EOBJECT) {
					neededParams.add(TypeRegistry.getMapKeyType(roc.target.ref as Map))
				} else if (op == TypeModelPackage.Literals.MAP___CONTAINS_VALUE__EOBJECT ||
					op == TypeModelPackage.Literals.MAP___GET_KEY_TO_ENTRY__EOBJECT) {
					neededParams.add(TypeRegistry.getMapEntryType(roc.target.ref as Map))
				} else if (op == TypeModelPackage.Literals.MAP___PUT__EOBJECT_EOBJECT) {
					neededParams.add(TypeRegistry.getMapKeyType(roc.target.ref as Map))
					neededParams.add(TypeRegistry.getMapEntryType(roc.target.ref as Map))
				} else {
					neededParams.addAll(op.EParameters.map [ x |
						if (x instanceof Pattern) {
							x as Pattern
						} else {
							x.EType
						}
					])
				}

				// Check parameter count
				if (givenParams.size != neededParams.size) {
					error("Method " + op.name + " expects " + neededParams.size + " parameters but was given " +
						givenParams.size, MGLangPackage.Literals.REF_OR_CALL__PARAMS)
					return;
				}

				// Check parameter types
				for (var i = 0; i < givenParams.size; i++) {
					try {
						val givenParameterEval = typeChecker.evaluate(givenParams.get(i))
						val neededParameterEval = neededParams.get(i)

						if (givenParameterEval instanceof EClassifier && neededParameterEval instanceof EClassifier) {

							val givenParameterType = MofgenModelUtils.getEClassForInternalModel(
								givenParameterEval as EClassifier)
							val neededParameterType = MofgenModelUtils.getEClassForInternalModel(
								neededParameterEval as EClassifier)

							if (!(givenParameterType instanceof EClass && neededParameterType instanceof EClass &&
								neededParameterType.isSuperTypeOf(givenParameterType))) {
								// TODO Is it right that any object fits into an eobject parameter?
								if (neededParameterType !== EcorePackage.Literals.EOBJECT) {
									if (givenParameterType !== neededParameterType) {
										error(
											"Given parameter type " + givenParameterType.name +
												" does not match needed parameter type " + neededParameterType.name,
											MGLangPackage.Literals.REF_OR_CALL__PARAMS)
									}
								}
							}

						} else if (givenParameterEval instanceof Pattern && neededParameterEval instanceof Pattern) {
							val givenParameterPattern = givenParameterEval as Pattern
							val neededParameterPattern = neededParameterEval as Pattern
							if (!givenParameterPattern.name.equals(neededParameterPattern.name)) {
								error("Needed Pattern " + neededParameterPattern.name + " but was given Pattern " +
									givenParameterPattern.name, MGLangPackage.Literals.REF_OR_CALL__PARAMS)
							}
						} else {
							if (givenParameterEval instanceof Pattern) {
								error("Was given Pattern " + givenParameterEval.name + " but needed EClass " +
									MofgenModelUtils.getEClassForInternalModel(neededParameterEval as EClassifier).name,
									MGLangPackage.Literals.REF_OR_CALL__PARAMS)
							} else {
								error(
									"Was given EClass " +
										MofgenModelUtils.getEClassForInternalModel(givenParameterEval as EClassifier).
											name + " but needed Pattern " + (neededParameterEval as Pattern).name,
									MGLangPackage.Literals.REF_OR_CALL__PARAMS)
							}
						}

					} catch (MismatchingTypesException e) {
						error(e.message, MGLangPackage.Literals.REF_OR_CALL__PARAMS)
					}
				}
			}
		} else {
			if (roc.bracesSet) {
				error(roc.ref + " is not a method", MGLangPackage.Literals.REF_OR_CALL__BRACES_SET) // TODO Correct highlighting?
				return;
			}
		}
	}

}
