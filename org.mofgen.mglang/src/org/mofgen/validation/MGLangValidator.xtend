/*
 * generated by Xtext 2.20.0
 */
package org.mofgen.validation

import com.google.inject.Inject
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.ENamedElement
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
import org.mofgen.mGLang.Collection
import org.mofgen.mGLang.CollectionManipulation
import org.mofgen.mGLang.ForRange
import org.mofgen.mGLang.GenCaseWithCast
import org.mofgen.mGLang.GenCaseWithoutCast
import org.mofgen.mGLang.GenForBody
import org.mofgen.mGLang.GenReturn
import org.mofgen.mGLang.GenWhenCase
import org.mofgen.mGLang.Generator
import org.mofgen.mGLang.Import
import org.mofgen.mGLang.List
import org.mofgen.mGLang.ListAdHoc
import org.mofgen.mGLang.MGLangPackage
import org.mofgen.mGLang.Map
import org.mofgen.mGLang.MapAdHoc
import org.mofgen.mGLang.MapTupel
import org.mofgen.mGLang.Node
import org.mofgen.mGLang.NodeAttributeAssignment
import org.mofgen.mGLang.NodeContent
import org.mofgen.mGLang.NullLiteral
import org.mofgen.mGLang.ParamManipulation
import org.mofgen.mGLang.Pattern
import org.mofgen.mGLang.PatternCall
import org.mofgen.mGLang.PatternCallParameters
import org.mofgen.mGLang.PatternCaseWithCast
import org.mofgen.mGLang.PatternCaseWithoutCast
import org.mofgen.mGLang.PatternForBody
import org.mofgen.mGLang.PatternNodeReference
import org.mofgen.mGLang.PatternWhenCase
import org.mofgen.mGLang.RangeForHead
import org.mofgen.mGLang.RefOrCall
import org.mofgen.mGLang.RefParams
import org.mofgen.mGLang.Rel
import org.mofgen.mGLang.RelationalOp
import org.mofgen.mGLang.Variable
import org.mofgen.mGLang.VariableManipulation
import org.mofgen.typeModel.TypeModelPackage
import org.mofgen.utils.MofgenModelUtils
import org.eclipse.emf.ecore.util.EcoreUtil

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
			if (forRange.start !== null && !forRange.start.eIsProxy && forRange.end !== null &&
				!forRange.end.eIsProxy) {
				val start = forRange.start
				val end = forRange.end
				val check1 = checkForInteger(forRange.start, forRange, MGLangPackage.Literals.FOR_RANGE__START)
				val check2 = checkForInteger(forRange.end, forRange, MGLangPackage.Literals.FOR_RANGE__END)
				if (check1 && check2) {
					val startEval = calc.evaluate(start)
					val endEval = calc.evaluate(end)
					if (startEval instanceof Integer && endEval instanceof Integer) {
						val startCast = startEval as Integer
						val endCast = endEval as Integer
						if (startCast > endCast) {
							error("Limiting bound is less than starting value",
								MGLangPackage.Literals.RANGE_FOR_HEAD__RANGE)
						}
					}
				}
			}
		}
	}

	@Check
	def checkThisInRefOrCall(RefOrCall roc) {
		var rocIt = roc
		while (rocIt.target !== null && !rocIt.target.eIsProxy) {
			rocIt = rocIt.target
		}
		if (rocIt.thisUsed) {
			if (EcoreUtil2.getContainerOfType(roc, Node) !== null &&
				rocIt.eContainingFeature !== MGLangPackage.Literals.REF_OR_CALL__TARGET) {
				error("This cannot stand alone", MGLangPackage.Literals.REF_OR_CALL__THIS_USED)
			}
			if (EcoreUtil2.getContainerOfType(roc, Pattern) === null) {
				error("Can only use keyword this in patterns", MGLangPackage.Literals.REF_OR_CALL__THIS_USED)
			}
		}
	}

	@Check
	def checkNoCollectionManipulationWithoutSideEffects(CollectionManipulation cm) {
		val op = cm.op
		if (op !== null && !op.eIsProxy) {
			if (cm.trg instanceof List) {
				if (op !== TypeModelPackage.Literals.LIST___ADD__EOBJECT &&
					op !== TypeModelPackage.Literals.LIST___ADD_ALL__LIST &&
					op !== TypeModelPackage.Literals.LIST___REMOVE__EOBJECT &&
					op !== TypeModelPackage.Literals.LIST___REMOVE_AT__INT) {
					warning("Stand-alone operation on collection without side-effect",
						MGLangPackage.Literals.COLLECTION_MANIPULATION__OP)
				}
			} else if (cm.trg instanceof Map) {
				if (op !== TypeModelPackage.Literals.MAP___PUT__EOBJECT_EOBJECT &&
					op !== TypeModelPackage.Literals.MAP___REMOVE__EOBJECT) {
					warning("Stand-alone operation on collection without side-effect",
						MGLangPackage.Literals.COLLECTION_MANIPULATION__OP)
				}
			} else {
				throw new IllegalArgumentException(
					"CollectionManipulations should only refer to Lists or Maps but got " + cm.trg)
			}
		}
	}

	/**
	 * Error at errorLoc if the given obj does not evaluate to a numerical value.
	 */
	def private checkForInteger(ArithmeticExpression expr, EObject obj, EReference errorLoc) {
		try {
			val eval = typeChecker.evaluate(expr)
			if (eval !== null) {
				if (eval instanceof Pattern) {
					error("Expected integer but was given type " + eval.name, obj, errorLoc)
					return false
				} else if (eval !== TypeModelPackage.Literals.INTEGER) {
					error("Expected integer but was given type " + (eval as EClass).name, obj, errorLoc)
					return false
				} else {
					return true
				}
			}
		} catch (MismatchingTypesException e) {
			error(e.message, obj, errorLoc)
		}
	}

	/**
	 * Warns for empty for-loops.
	 */
	@Check
	def warnEmptyForLoop(GenForBody body) {
		if (body.commands !== null && body.commands.empty) {
			warning("empty for-loop", body.eContainer, MGLangPackage.Literals.FOR_STATEMENT__HEAD)
		}
	}

	/**
	 * Warns for empty for-loops.
	 */
	@Check
	def warnEmptyForLoop(PatternForBody body) {
		if (body.commands !== null && body.commands.empty) {
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
				if (res !== null && res !== TypeModelPackage.Literals.BOOLEAN) {
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
				if (res !== null && res !== TypeModelPackage.Literals.BOOLEAN) {
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

	/** 
	 * Checks that there is exactly one return per generator block 
	 */
	@Check
	def checkExactlyOneReturn(Generator gen) {
		if (gen.commands !== null) {
			val retCount = gen.commands.filter(GenReturn).length
			if (retCount > 1) {
				error("Only one return per generator allowed", MGLangPackage.Literals.GENERATOR__COMMANDS)
			}
			if (retCount < 1) {
				error("Generator block needs return with containment root", MGLangPackage.Literals.GENERATOR__COMMANDS)
			}
		}
	}

	@Check
	/**
	 * Checks that the return type of a generator is valid, i.e. no patterns being returned but concrete nodes/EObjects 
	 */
	def checkValidReturnValue(GenReturn genRet) {
		val ret = genRet.returnValue

		if (ret instanceof RefOrCall) {
			val typeEval = typeChecker.evaluate(ret)
			if (typeEval instanceof EClass) {
				if (TypeModelPackage.Literals.PRIMITIVE.isSuperTypeOf(typeEval)) {
					error("Can not return primitive values or strings", MGLangPackage.Literals.GEN_RETURN__RETURN_VALUE)
				}
			}
		} else if (ret instanceof PatternCall) {
			val pattern = ret.called
			val patternReturn = pattern.^return
			if (patternReturn === null) {
				error("Can not return void pattern", MGLangPackage.Literals.GEN_RETURN__RETURN_VALUE)
			}
		} else {
			throw new IllegalArgumentException(
				"GenReturns should only be able to hold RefOrCall- or PatternCall-Objects")
		}
	// What is valid?: Variables containing EObjects(i.e. no strings or primitives), PatternCall with return value, Access of elements of a pattern variable, access of list/map with objects as elements
	}

	@Check
	def checkNoLinesAfterReturn(GenReturn ret) {
		val gen = EcoreUtil2.getContainerOfType(ret, Generator)
		val genCommands = gen.commands
		if (gen.commands !== null) {
			if (genCommands.indexOf(ret) !== genCommands.length - 1) {
				warning("This return suppresses lines of code following afterwards",
					MGLangPackage.Literals.GEN_RETURN__RETURN_VALUE)
			}
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
		if (refsAssigns !== null) {
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
	}

	@Check
	/**
	 * checks that in a for-loop within a pattern only assignments to *-references appear
	 */
	def checkPatternForOnlyRefsToMultiFeatures(PatternForBody body) {
		if (body.commands !== null) {
			for (expr : body.commands) {
				if (expr instanceof PatternNodeReference) {
					if (expr.type.upperBound == 1) {
						error("Only assignments to *-edges/-references allowed in for-loops.", expr,
							MGLangPackage.Literals.PATTERN_NODE_REFERENCE__TYPE)
					}
				}
			}
		}
	}

	@Check
	def checkAttributeType(NodeAttributeAssignment ass) {
		val trg = ass.target
		if (trg !== null && !trg.eIsProxy && trg instanceof EAttribute) {
			val attribute = trg as EAttribute
			val attributeType = MofgenModelUtils.getEClassForInternalModel(attribute.EAttributeType)

			try {
				if (ass.value !== null && !ass.value.eIsProxy) {
					val assValue = ass.value
					if (assValue instanceof RefOrCall) {
						if (assValue.thisUsed) {
							return;
						}
					}
					val assignedValueEval = typeChecker.evaluate(ass.value)
					if (assignedValueEval instanceof EClass) {
						val assignedValue = MofgenModelUtils.getEClassForInternalModel(assignedValueEval)
						if (assignedValue != TypeModelPackage.Literals.ENUM_LITERAL &&
							attributeType == TypeModelPackage.Literals.ENUM) {
							error("Can only assign enum values to enum attribute " + attribute.name, ass,
								MGLangPackage.Literals.NODE_ATTRIBUTE_ASSIGNMENT__VALUE)
						} else {
							if (assignedValue == TypeModelPackage.Literals.ENUM_LITERAL &&
								attributeType != TypeModelPackage.Literals.ENUM) {
								error("Cannot assign enum value to non-enum attribute " + attribute.name, ass,
									MGLangPackage.Literals.NODE_ATTRIBUTE_ASSIGNMENT__VALUE)
							}
						}
					} else {
						throw new UnsupportedOperationException("Assigned value is a pattern") // Patterns can only return nodes and no primitive values, therefore this case should not occur...
					}
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

		if (pc.called !== null && !pc.called.eIsProxy && pc.params !== null) {

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
			if (pc.params !== null && pc.params.params !== null && pc.called.parameters !== null) {

				for (i : 0 ..< pc.params.params.length) {
					val givenParameterExpression = pc.params.params.get(i)
					val neededParameter = pc.called.parameters.get(i)

					val givenParameterType = typeChecker.evaluate(givenParameterExpression)
					if (givenParameterType === null) {
						return;
					}

					val neededParameterType = MofgenModelUtils.getInternalParameterType(neededParameter)

					if (givenParameterType instanceof EClassifier && neededParameterType instanceof EClassifier) {
						if (!(MofgenModelUtils.getEClassForInternalModel(neededParameterType as EClassifier).
							isSuperTypeOf(
								MofgenModelUtils.getEClassForInternalModel(givenParameterType as EClassifier)))) {
							val givenParameterTypeEClassifier = MofgenModelUtils.getEClassForInternalModel(
								givenParameterType as EClassifier)
							if (neededParameterType !== EcorePackage.Literals.EOBJECT) {
								if (givenParameterType !== neededParameterType) {
									if (givenParameterTypeEClassifier instanceof EClass) {
										if (!(TypeModelPackage.Literals.NUMBER.isSuperTypeOf(
											givenParameterTypeEClassifier) &&
											neededParameterType === TypeModelPackage.Literals.STRING)) {
											error(
												"Given type " + givenParameterTypeEClassifier.name +
													" does not match needed type " +
													(neededParameterType as EClassifier).name,
												MGLangPackage.Literals.PATTERN_CALL__PARAMS)
										}
									}
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
								(neededParameterType as EClassifier).name, MGLangPackage.Literals.PATTERN_CALL__PARAMS)
						} else {
							val givenParameterTypeEClassifier = givenParameterType as EClassifier
							error(
								"Given type " + givenParameterTypeEClassifier.name + " does not match needed Pattern " +
									(neededParameterType as Pattern).name, MGLangPackage.Literals.PATTERN_CALL__PARAMS)
						}
					}
				}

			}
		}
	}

	@Check
	def checkTypeForNodeCreationByPatternCall(Node node) {
		if (node.type !== null) {
			if (node.type !== EcorePackage.Literals.EOBJECT) {
				if (node.createdBy !== null && !node.createdBy.eIsProxy && node.createdBy instanceof PatternCall) {
					val pc = node.createdBy as PatternCall
					if (pc.called !== null && !pc.called.eIsProxy) {
						val ret = pc.called.^return
						if (ret === null) {
							error("Pattern " + pc.called.name + " returns null but " + node.name + " expects " +
								node.type.name, MGLangPackage.Literals.NODE__CREATED_BY)
						} else {
							val retVal = ret.retValue
							if (retVal === null) {
								error(
									"Pattern " + pc.called.name + " returns " + pc.called.name + " but " + node.name +
										" expects " + node.type.name, MGLangPackage.Literals.NODE__CREATED_BY)
							} else {
								val retValType = typeChecker.evaluate(retVal)
								if (retValType !== null && retValType !== node.type) {
									error(
										"Pattern " + pc.called.name + " returns " + retValType + " but " + node.name +
											" expects " + node.type.name, MGLangPackage.Literals.NODE__CREATED_BY)
								}
							}
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
			if (ref !== null && !ref.eIsProxy) {
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
	}

	@Check
	def noVariableWithNullReturningPattern(PatternCall pc) {
		if (pc.eContainer instanceof Variable) {
			if (pc.called !== null && !pc.called.eIsProxy) {
				if (pc.called.^return === null) {
					error("Cannot define variable by calling a pattern with no return", pc.eContainer as Variable,
						MGLangPackage.Literals.VARIABLE__VALUE);
				}
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
				Variable:
					error(e.message, container, MGLangPackage.Literals.VARIABLE__VALUE)
				PatternCallParameters:
					error(e.message, container, MGLangPackage.Literals.PATTERN_CALL_PARAMETERS__PARAMS)
				NodeAttributeAssignment:
					error(e.message, container, MGLangPackage.Literals.NODE_ATTRIBUTE_ASSIGNMENT__VALUE)
				PatternWhenCase:
					error(e.message, container, MGLangPackage.Literals.PATTERN_WHEN_CASE__WHEN)
				PatternCaseWithCast:
					error(e.message, container, MGLangPackage.Literals.PATTERN_CASE_WITH_CAST__WHEN)
				PatternCaseWithoutCast:
					error(e.message, container, MGLangPackage.Literals.PATTERN_CASE_WITHOUT_CAST__VAL)
				RefParams:
					error(e.message, container, MGLangPackage.Literals.REF_PARAMS__PARAMS)
				VariableManipulation:
					error(e.message, container, MGLangPackage.Literals.VARIABLE_MANIPULATION__VAL)
				ForRange: {
					if (ae === container.start) {
						error(e.message, container, MGLangPackage.Literals.FOR_RANGE__START)
					} else {
						error(e.message, container, MGLangPackage.Literals.FOR_RANGE__END)
					}
				}
				GenWhenCase:
					error(e.message, container, MGLangPackage.Literals.GEN_WHEN_CASE__WHEN)
				GenCaseWithCast:
					error(e.message, container, MGLangPackage.Literals.GEN_CASE_WITH_CAST__WHEN)
				GenCaseWithoutCast:
					error(e.message, container, MGLangPackage.Literals.GEN_CASE_WITHOUT_CAST__VAL)
				ListAdHoc:
					error(e.message, container, MGLangPackage.Literals.LIST_AD_HOC__ELEMENTS)
				MapTupel: {
					if (ae === container.key) {
						error(e.message, container, MGLangPackage.Literals.MAP_TUPEL__KEY)
					} else {
						error(e.message, container, MGLangPackage.Literals.MAP_TUPEL__VALUE)
					}
				}
			}
		}
	}

	@Check
	def noTypeChangeByVariableManipulation(VariableManipulation vm) {
		val variable = vm.^var
		if (variable !== null && !variable.eIsProxy) {

			val varType = TypeRegistry.getVarType(variable) as EObject
			try {
				val givenType = typeChecker.evaluate(vm.^val) as EObject

				var varTypeString = ""
				var givenTypeString = ""

				if (varType !== null && givenType !== null && varType !== givenType) {
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
	}

// TODO cyclic dependencies when using switch expressions? --> Not possible to determine because of runtime dependence. Handle in Builder!
	/**
	 * Checks whether there emerges a cyclic dependency from that assignment
	 */
	@Check
	def checkCyclicDependencyInAssignment(NodeAttributeAssignment ass) {
		// the element which should receive the value
		val targetElement = ass.target
		val targetNode = EcoreUtil2.getContainerOfType(ass, Node)

		// the value to be assigned
		val value = ass.value

		if (targetElement !== null && !targetElement.eIsProxy && value !== null && !value.eIsProxy) {
			// retrieve all RefOrCalls and follow them
			val rocs = EcoreUtil2.getAllContentsOfType(value, RefOrCall)
			for (roc : rocs) {
				if (followingRocIsCyclic(targetNode, targetElement, roc, newLinkedList(ass))) {
					error("Evaluation of assignment leads to cyclic dependency", ass,
						MGLangPackage.Literals.NODE_ATTRIBUTE_ASSIGNMENT__VALUE)
					return true
				}
			}
		}
	}

	def private boolean followingRocIsCyclic(Node targetNode, ENamedElement targetElement, RefOrCall rocToFollow,
		java.util.List<NodeAttributeAssignment> visitedAssigns) {
		val nextAssignment = findAssignmentToRoc(rocToFollow)
		if (nextAssignment === null) {
			return false;
		}
		if (visitedAssigns.contains(nextAssignment)) {
			return true;
		}
		val nextNode = nextAssignment.eContainer.eContainer as Node
		val nextTarget = nextAssignment.target
		if (nextTarget !== null && !nextTarget.eIsProxy) {
			if (nextNode === targetNode && nextTarget === targetElement) {
				return true
			} else {
				val nextValue = nextAssignment.value
				val rocs = EcoreUtil2.getAllContentsOfType(nextValue, RefOrCall)
				val visitedAssignsNew = newLinkedList()
				visitedAssignsNew.addAll(visitedAssigns)
				visitedAssignsNew.add(nextAssignment)
				for (roc : rocs) {
					if (followingRocIsCyclic(targetNode, targetElement, roc, visitedAssignsNew)) {
						return true
					}
				}
			}
		}
		return false;
	}

	@Check
	/**
	 * checks whether an attribute used in an assignment is set when referencing a newly defined node
	 */
	def checkAttributeSet(NodeAttributeAssignment ass) {
		// the value to be assigned
		val value = ass.value

		if (value !== null && !value.eIsProxy) {
			val rocs = EcoreUtil2.getAllContentsOfType(value, RefOrCall)
			for (roc : rocs) {
				if (roc.ref !== null && !roc.ref.eIsProxy && roc.ref instanceof Node &&
					findAssignmentToRoc(roc) === null) {
					error(
						"Referenced value " + getTextFromEditorFile(getHighestRoc(roc)) + " to be assigned is not set",
						ass, MGLangPackage.Literals.NODE_ATTRIBUTE_ASSIGNMENT__VALUE)
				}
			}
		}
	}

	def private String getTextFromEditorFile(EObject obj) {
		return NodeModelUtils.getTokenText(NodeModelUtils.getNode(obj))
	}

	/**
	 * @returns the NodeAttributeAssignment to the attribute accessed within the given RefOrCall or the parameter it originated from. Null, if there is no attribute access.
	 */
	def private findAssignmentToRoc(RefOrCall roc) {
		var rocIt = getHighestRoc(roc)
		if (rocIt.ref !== null && !rocIt.ref.eIsProxy) {
			while (rocIt.target !== null && !rocIt.eIsProxy && rocIt.ref !== null &&
				!(rocIt.ref instanceof ENamedElement)) {
				rocIt = rocIt.target
			}

			if (rocIt.target !== null && !rocIt.eIsProxy) {
				val eNamedElement = rocIt.ref as ENamedElement
				val node = rocIt.target.ref
				if (eNamedElement !== null && node !== null && !node.eIsProxy && node instanceof Node) {
					val nodeContent = (node as Node).createdBy
					if (nodeContent instanceof NodeContent) {
						// find namedElement
						val assignments = nodeContent.refsAssigns.filter(NodeAttributeAssignment)
						for (ass : assignments) {
							if (ass.target.name == eNamedElement.name) {
								return ass;
							}
						}
					}
				}
			}
		}
	}

	def private getHighestRoc(RefOrCall roc) {
		var rocIt = roc
		while (rocIt.eContainer !== null && rocIt.eContainer instanceof RefOrCall) {
			rocIt = rocIt.eContainer as RefOrCall
		}
		return rocIt
	}

	@Check
	/**
	 * Checks whether all keys within an ad-hoc created map are unique
	 */
	def checkMapKeysUnique(MapAdHoc definition) {
		if (definition.entries !== null) {
			val keys = definition.entries.map[e|calc.evaluate(e.key)]
			val set = newHashSet()
			for (key : keys) {
				if (!set.add(key)) {
					error("Key \"" + key + "\" is not unique.", EcoreUtil2.getContainerOfType(definition, Map),
						MGLangPackage.Literals.MAP__DEF_OR_DECL)
				}
			}
		}
	}

	@Check
	def matchingParameters_collManipulation(CollectionManipulation cm) {
		if (cm.op !== null && cm.params !== null && cm.params.params !== null) {
			val op = cm.op
			var neededParameters = op.EParameters
			val givenParameters = cm.params.params

			// check number of parameters
			if (givenParameters.size != neededParameters.size) {
				error("Method \"" + op.name + "\" needs " + neededParameters.size + " parameters but was given " +
					givenParameters.size, MGLangPackage.Literals.COLLECTION_MANIPULATION__OP)
				return
			}

			// get needed parameters corresponding to the internal type system
			var neededParams = newLinkedList()
			switch op {
				case TypeModelPackage.Literals.LIST___INDEX_OF__EOBJECT,
				case TypeModelPackage.Literals.LIST___ADD__EOBJECT,
				case TypeModelPackage.Literals.LIST___REMOVE__EOBJECT,
				case TypeModelPackage.Literals.LIST___CONTAINS__EOBJECT: {
					neededParams.add(TypeRegistry.getListType(cm.trg as List))
				}
				case TypeModelPackage.Literals.MAP___CONTAINS_KEY__EOBJECT,
				case TypeModelPackage.Literals.MAP___GET__EOBJECT: {
					neededParams.add(TypeRegistry.getMapKeyType(cm.trg as Map))
				}
				case TypeModelPackage.Literals.MAP___CONTAINS_VALUE__EOBJECT,
				case TypeModelPackage.Literals.MAP___GET_KEY_TO_ENTRY__EOBJECT: {
					neededParams.add(TypeRegistry.getMapEntryType(cm.trg as Map))
				}
				case TypeModelPackage.Literals.MAP___PUT__EOBJECT_EOBJECT: {
					neededParams.add(TypeRegistry.getMapKeyType(cm.trg as Map))
					neededParams.add(TypeRegistry.getMapEntryType(cm.trg as Map))
				}
				case TypeModelPackage.Literals.LIST___ADD_ALL__LIST: {
					neededParams.add(MGLangPackage.Literals.LIST)
				}
				default: {
					neededParams.addAll(op.EParameters.map [ x |
						if (x instanceof Pattern) {
							x as Pattern
						} else {
							x.EType
						}
					])
				}
			}

			// Check parameter types
			checkMatchingParameterTypes(givenParameters, neededParams,
				MGLangPackage.Literals.COLLECTION_MANIPULATION__PARAMS)

			// check collection types for given collection
			if (op == TypeModelPackage.Literals.LIST___ADD_ALL__LIST) {
				val neededListType = TypeRegistry.getListType(cm.trg as List)
				for (givenParam : givenParameters) {
					val givenParamEval = typeChecker.evaluate(givenParam)
					if (givenParamEval == TypeModelPackage.Literals.LIST) {
						val givenListType = TypeRegistry.getListType((givenParam as RefOrCall).ref as List)
						if (!MofgenModelUtils.getEClassForInternalModel(neededListType).isSuperTypeOf(
							MofgenModelUtils.getEClassForInternalModel(givenListType))) {
							error("List " + cm.trg.name + " is of other type than given list " +
								((givenParam as RefOrCall).ref as List).name,
								MGLangPackage.Literals.COLLECTION_MANIPULATION__TRG)
						}
					}
				}
			}
		}
	}

	/**
	 * Checks the consistency of parameter types w.r.t. the internal type system and throws errors at the given errorLoc when encountering any violations
	 */
	def private checkMatchingParameterTypes(java.util.List<ArithmeticExpression> givenParams,
		java.util.List<EObject> neededParams, EReference errorLoc) {
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
						if (neededParameterType !== EcorePackage.Literals.EOBJECT) {
							if (givenParameterType !== neededParameterType) {
								error(
									"Given parameter type " + givenParameterType.name +
										" does not match needed parameter type " + neededParameterType.name, errorLoc)
							}
						}
					}
				} else if (givenParameterEval instanceof Pattern && neededParameterEval instanceof Pattern) {
					val givenParameterPattern = givenParameterEval as Pattern
					val neededParameterPattern = neededParameterEval as Pattern
					if (!givenParameterPattern.name.equals(neededParameterPattern.name)) {
						error("Needed Pattern " + neededParameterPattern.name + " but was given Pattern " +
							givenParameterPattern.name, errorLoc)
					}
				} else {
					if (givenParameterEval instanceof Pattern) {
						error("Was given Pattern " + givenParameterEval.name + " but needed EClass " +
							MofgenModelUtils.getEClassForInternalModel(neededParameterEval as EClassifier).name,
							errorLoc)
					} else {
						error(
							"Was given EClass " +
								MofgenModelUtils.getEClassForInternalModel(givenParameterEval as EClassifier).name +
								" but needed Pattern " + (neededParameterEval as Pattern).name, errorLoc)
					}
				}

			} catch (MismatchingTypesException e) {
				error(e.message, errorLoc)
			}
		}
	}

	@Check
	def matchingParameters_roc(RefOrCall roc) {
		if (roc.ref !== null && !roc.ref.eIsProxy && roc.ref instanceof EOperation) {
			if (!roc.bracesSet) {
				error("Missing parameter list", MGLangPackage.Literals.REF_OR_CALL__PARAMS)
				return;
			} else {
				val op = roc.ref as EOperation
				if (op !== null && !op.eIsProxy && roc.params !== null && roc.params.params !== null) {
					val givenParams = roc.params.params
					var neededParams = newLinkedList()
					switch op {
						case TypeModelPackage.Literals.LIST___INDEX_OF__EOBJECT,
						case TypeModelPackage.Literals.LIST___ADD__EOBJECT,
						case TypeModelPackage.Literals.LIST___REMOVE__EOBJECT,
						case TypeModelPackage.Literals.LIST___CONTAINS__EOBJECT: {
							neededParams.add(TypeRegistry.getListType(roc.target.ref as List))
						}
						case TypeModelPackage.Literals.MAP___CONTAINS_KEY__EOBJECT,
						case TypeModelPackage.Literals.MAP___GET__EOBJECT: {
							neededParams.add(TypeRegistry.getMapKeyType(roc.target.ref as Map))
						}
						case TypeModelPackage.Literals.MAP___CONTAINS_VALUE__EOBJECT,
						case TypeModelPackage.Literals.MAP___GET_KEY_TO_ENTRY__EOBJECT: {
							neededParams.add(TypeRegistry.getMapEntryType(roc.target.ref as Map))
						}
						case TypeModelPackage.Literals.MAP___PUT__EOBJECT_EOBJECT: {
							neededParams.add(TypeRegistry.getMapKeyType(roc.target.ref as Map))
							neededParams.add(TypeRegistry.getMapEntryType(roc.target.ref as Map))
						}
						case TypeModelPackage.Literals.LIST___ADD_ALL__LIST: {
							neededParams.add(MGLangPackage.Literals.LIST)
						}
						default: {
							neededParams.addAll(op.EParameters.map [ x |
								if (x instanceof Pattern) {
									x as Pattern
								} else {
									x.EType
								}
							])
						}
					}

					// Check parameter count
					if (givenParams.size != neededParams.size) {
						error("Method " + op.name + " expects " + neededParams.size + " parameters but was given " +
							givenParams.size, MGLangPackage.Literals.REF_OR_CALL__PARAMS)
						return;
					}

					// Check parameter types
					checkMatchingParameterTypes(givenParams, neededParams, MGLangPackage.Literals.REF_OR_CALL__PARAMS)
				}
			}
		} else {
			if (roc.bracesSet) {
				val ref = roc.ref
				if (ref instanceof EAttribute) {
					error(ref.name + " is not a method", MGLangPackage.Literals.REF_OR_CALL__REF)
				} else if (ref instanceof EReference) {
					error(ref.name + " is not a method", MGLangPackage.Literals.REF_OR_CALL__REF)
				} else {
					error(ref + " is not a method", MGLangPackage.Literals.REF_OR_CALL__REF)
				}

				return;
			}
		}
	}

	@Check
	// TODO testing
	def checkNullOnlyInComparisons(NullLiteral lit) {
		val container = lit.eContainer;
		if (container instanceof Rel) {
			if (container.relation === RelationalOp.EQUAL || container.relation === RelationalOp.UNEQUAL) {
				return
			}
		}
		error("Use of null is only allowed in relational operations", lit.eContainingFeature)
	}

}
