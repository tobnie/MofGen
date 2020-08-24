/*
 * generated by Xtext 2.20.0
 */
package org.mofgen.scoping

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.mofgen.mGLang.MGLangPackage
import org.mofgen.utils.MofgenModelUtils
import org.eclipse.xtext.scoping.Scopes
import org.mofgen.mGLang.PatternNodeReference
import org.eclipse.xtext.scoping.IScope
import org.mofgen.mGLang.Node
import org.eclipse.xtext.EcoreUtil2
import org.mofgen.mGLang.Pattern
import org.mofgen.mGLang.RefOrCall
import org.mofgen.mGLang.CaseWithCast
import org.mofgen.mGLang.Map
import org.mofgen.mGLang.List
import org.mofgen.collectionModel.CollectionModelPackage
import java.util.ArrayList
import org.mofgen.mGLang.Collection
import org.mofgen.mGLang.Generator
import org.mofgen.mGLang.PatternVariable
import org.mofgen.mGLang.Import
import org.mofgen.mGLang.ParameterNode
import org.mofgen.mGLang.Variable
import org.mofgen.mGLang.Assignment
import org.eclipse.emf.ecore.EEnum

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
class MGLangScopeProvider extends AbstractMGLangScopeProvider {

	override getScope(EObject context, EReference reference) {
		if (isNodeCreation(context, reference)) {
			return getScopeForNodeCreationType(context as Node)
		}
		if (isReferenceType(context, reference)) {
			return getScopeForReferenceType(context as PatternNodeReference)
		}
		if (isReferenceTarget(context, reference)) {
			return getScopeForReferenceTarget(context as PatternNodeReference)
		}
		if (isNodeAttributeAssignmentType(context, reference)) {
			return getScopeForNodeAssignmentType(context as Assignment)
		}
		if (isRefOrCall(context)) {
			return getScopeForRefOrCall(context as RefOrCall)
		}
		if (isPatternVariableType(context, reference)) {
			return getScopeForPatternVariableType(context as PatternVariable)
		}
		if (isParameterNodeSrcModel(context, reference)) {
			return getScopeForParameterNodeSrcModel(context as ParameterNode)
		}
		if (isParameterNodeType(context, reference)) {
			return getScopeForParameterNodeType(context as ParameterNode)
		}
		if (isNodeType(context, reference)) {
			return getScopeForNodeType(context as Node)
		}
		if (isNodeSrcModel(context, reference)) {
			return getScopeForNodeSrcModel(context as Node)
		}

		return super.getScope(context, reference)
	}

	def getScopeForNodeSrcModel(Node node) {
		val imports = EcoreUtil2.getAllContentsOfType(getRootFile(node), Import)
		return Scopes.scopeFor(imports)
	}

	def getScopeForNodeType(Node node) {
		val imp = node.srcModel
		if (imp !== null) {
			val classes = MofgenModelUtils.getClassesFromImport(imp)
			return Scopes.scopeFor(classes)
		} else {
			return getScopeForAllImportedClasses(node)
		}
	}

	def getScopeForParameterNodeType(ParameterNode paramNode) {
		val imp = paramNode.srcModel
		if (imp !== null) {
			val classes = MofgenModelUtils.getClassesFromImport(imp)
			return Scopes.scopeFor(classes)
		} else {
			return getScopeForAllImportedClasses(paramNode)
		}
	}

	private def getScopeForAllImportedClasses(EObject obj) {
		// in case of naming conflicts only the first class with that name in the first mentioned import is loaded
		val classes = MofgenModelUtils.getUniqueClasses(MofgenModelUtils.getRootFile(obj))
		return Scopes.scopeFor(classes)
	}

	def getScopeForParameterNodeSrcModel(ParameterNode paramNode) {
		val imports = EcoreUtil2.getAllContentsOfType(getRootFile(paramNode), Import)
		return Scopes.scopeFor(imports)
	}

	def getScopeForPatternVariableType(PatternVariable pVar) {
		val patterns = EcoreUtil2.getAllContentsOfType(getRootFile(pVar), Pattern)
		return Scopes.scopeFor(patterns)
	}

	def getScopeForNodeCreationType(Node n) {
		val file = getRootFile(n)
		val classes = MofgenModelUtils.getClasses(file)
		return Scopes.scopeFor(classes)
	}

	def getScopeForReferenceType(PatternNodeReference ref) {
		val file = getRootFile(ref)
		val src = EcoreUtil2.getContainerOfType(ref, Node)
		val classes = MofgenModelUtils.getClasses(file)
		val filteredClasses = classes.filter[c|c == src.type]
		if (filteredClasses.empty) {
			return IScope.NULLSCOPE
		} else {
			return Scopes.scopeFor(filteredClasses.get(0).EAllReferences)
		}
	}

	def getScopeForAllNodes(EObject context) {
		val root = getRootFile(context)
		val allNodes = EcoreUtil2.getAllContentsOfType(root, Node)
		return Scopes.scopeFor(allNodes)
	}

	def getScopeForReferenceTarget(PatternNodeReference ref) {
		return getScopeForAllNodes(ref)
	}

	def getScopeForNodeAssignmentType(Assignment ass) {
		val srcNode = EcoreUtil2.getContainerOfType(ass, Node)
		val file = getRootFile(ass)
		val classes = MofgenModelUtils.getClasses(file)
		try {
			val filteredClasses = classes.filter[c|c == srcNode.type]
			val attrs = newArrayList()
			if (filteredClasses.isEmpty) {
				return IScope.NULLSCOPE
			} else {
				attrs.addAll(filteredClasses.get(0).EAllAttributes)
				return Scopes.scopeFor(attrs)
			}
		} catch (NullPointerException e) {
			return IScope.NULLSCOPE
		}

	}

	def getEventuallyShadowingNodes(EObject obj) {
		val parentCases = EcoreUtil2.getAllContainers(obj).filter(CaseWithCast)
		return parentCases.map[c|c.node]
	}

	def getScopeForRefOrCall(RefOrCall r) {
		if (r.target === null) {
			// get parameters of above Pattern
			val pattern = EcoreUtil2.getContainerOfType(r, Pattern)
			val gen = EcoreUtil2.getContainerOfType(r, Generator)
			// pattern and gen are xor non-null. Either we are in a pattern or a generator
			var params = new ArrayList<EObject>()
			var patternNodes = new ArrayList<Node>()

			val vars = new ArrayList<Variable>()
			var collections = new ArrayList<Collection>()

			if (pattern !== null) {
				params.addAll(pattern.parameters)
				// get nodes of pattern
				patternNodes.addAll(pattern.commands.filter(Node))

				collections.addAll(EcoreUtil2.getAllContentsOfType(pattern, Collection))
				vars.addAll(EcoreUtil2.getAllContentsOfType(pattern, Variable))
			} else {
				collections.addAll(EcoreUtil2.getAllContentsOfType(gen, Collection))
				vars.addAll(EcoreUtil2.getAllContentsOfType(gen, Variable))
			}

			// get nodes of casts in above case-heads (remove names from pattern-nodes eventually)
			val shadowingNodes = getEventuallyShadowingNodes(r)
			val indicesToRemove = newArrayList()

			// find shadowed Pattern nodes
			for (pNode : patternNodes) {
				for (node : shadowingNodes) {
					if (node.name.equals(pNode.name)) {
						indicesToRemove.add(patternNodes.indexOf(pNode))
					}
				}
			}
			for (index : indicesToRemove.reverse) {
				patternNodes.remove(index)
			}

			// collect enums
			val root = MofgenModelUtils.getRootFile(r)
			val enums = MofgenModelUtils.getEnums(root)
			// collect imports
			val imports = EcoreUtil2.getAllContentsOfType(root, Import)

			return Scopes.scopeFor(params + patternNodes + collections + vars + imports + enums)

		} else {
			val trg = r.target
			val ref = trg.ref
			val refClass = ref.eClass

			switch ref {
				Map: {
					val ops = CollectionModelPackage.Literals.MAP.EAllOperations
					return Scopes.scopeFor(ops)
				}
				List: {
					val ops = CollectionModelPackage.Literals.LIST.EAllOperations
					return Scopes.scopeFor(ops)
				}
				Import: {
					val enums = MofgenModelUtils.getEnumsFromImport(ref as Import)
					return Scopes.scopeFor(enums)
				}
				EEnum: {
					val enumLiterals = (ref as EEnum).ELiterals
					return Scopes.scopeFor(enumLiterals)
				}
				Variable: {
					return IScope.NULLSCOPE
				}
				Node,
				ParameterNode: {
					val attrs = refClass.EAllAttributes
					val refs = refClass.EAllReferences
					return Scopes.scopeFor(attrs + refs)
				}
				default: return IScope.NULLSCOPE
			}
		}
	}

	def isReferenceType(EObject context, EReference reference) {
		return context instanceof PatternNodeReference &&
			reference == MGLangPackage.Literals.PATTERN_NODE_REFERENCE__TYPE
	}

	def isReferenceTarget(EObject context, EReference reference) {
		return context instanceof PatternNodeReference &&
			reference == MGLangPackage.Literals.PATTERN_NODE_REFERENCE__TARGET
	}

	def isNodeCreation(EObject context, EReference reference) {
		return context instanceof Node && reference == MGLangPackage.Literals.NODE__TYPE
	}

	def isNodeAttributeAssignmentType(EObject context, EReference reference) {
		return context instanceof Assignment && reference == MGLangPackage.Literals.ASSIGNMENT__TARGET
	}

	def isRefOrCall(EObject context) {
		return context instanceof RefOrCall
	}

	def isRefOrCallRef(EObject context, EReference reference) {
		return context instanceof RefOrCall && reference == MGLangPackage.Literals.REF_OR_CALL__REF
	}

	def isPatternVariableType(EObject context, EReference reference) {
		return context instanceof PatternVariable && reference == MGLangPackage.Literals.PATTERN_VARIABLE__TYPE
	}

	def isParameterNodeSrcModel(EObject context, EReference reference) {
		return context instanceof ParameterNode && reference == MGLangPackage.Literals.PARAMETER_NODE__SRC_MODEL
	}

	def isParameterNodeType(EObject context, EReference reference) {
		return context instanceof ParameterNode && reference == MGLangPackage.Literals.PARAMETER_NODE__TYPE
	}

	def isNodeSrcModel(EObject context, EReference reference) {
		return context instanceof Node && reference == MGLangPackage.Literals.NODE__SRC_MODEL
	}

	def isNodeType(EObject context, EReference reference) {
		return context instanceof Node && reference == MGLangPackage.Literals.NODE__TYPE
	}

	def getRootFile(EObject context) {
		return MofgenModelUtils.getRootFile(context)
	}
}
