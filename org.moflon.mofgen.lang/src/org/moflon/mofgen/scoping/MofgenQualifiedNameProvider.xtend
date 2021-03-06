package org.moflon.mofgen.scoping

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.moflon.mofgen.mGLang.ForStatement
import org.moflon.mofgen.mGLang.GenCase
import org.moflon.mofgen.mGLang.GenSwitchCase
import org.moflon.mofgen.mGLang.IteratorVariable
import org.moflon.mofgen.mGLang.Node
import org.moflon.mofgen.mGLang.Parameter
import org.moflon.mofgen.mGLang.PatternCase
import org.moflon.mofgen.mGLang.PatternSwitchCase
import org.moflon.mofgen.mGLang.Switch

class MofgenQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {

	public final static String SWITCH_PREFIX = "!switch"
	public final static String CASE__PREFIX = "!case"
	public final static String FOR_PREFIX = "!for"
	public final static String PARAMETER_SUFFIX = "_parameter"

	override QualifiedName computeFullyQualifiedNameFromNameAttribute(EObject obj) {
		return computeFullyQualifiedNameInternal(obj);
	}

	def dispatch QualifiedName computeFullyQualifiedNameInternal(ForStatement forStatement) {
		val qualifiedForName = deriveFullyQualifiedName(forStatement);

		var obj = forStatement as EObject
		var parentsQualifiedName = null as QualifiedName
		while (obj.eContainer !== null && parentsQualifiedName === null) {
			obj = obj.eContainer();
			parentsQualifiedName = getFullyQualifiedName(obj);
		}

		return parentsQualifiedName.append(qualifiedForName);
	}

	def dispatch QualifiedName computeFullyQualifiedNameInternal(IteratorVariable iteratorVar) {
		val qualifiedForName = QualifiedName.create(iteratorVar.name)

		var obj = iteratorVar as EObject
		var parentsQualifiedName = null as QualifiedName
		while (obj.eContainer !== null && parentsQualifiedName === null) {
			obj = obj.eContainer();
			parentsQualifiedName = getFullyQualifiedName(obj);
		}

		return parentsQualifiedName.append(qualifiedForName);
	}

	def private deriveFullyQualifiedName(ForStatement forStatement) {
		val line = NodeModelUtils.getNode(forStatement).startLine
		val qualifiedForName = QualifiedName.create(FOR_PREFIX + line)
		return qualifiedForName
	}

	def dispatch QualifiedName computeFullyQualifiedNameInternal(Parameter param) {
		val qualifiedForName = QualifiedName.create(param.name + PARAMETER_SUFFIX)

		var obj = param as EObject
		var parentsQualifiedName = null as QualifiedName
		while (obj.eContainer !== null && parentsQualifiedName === null) {
			obj = obj.eContainer();
			parentsQualifiedName = getFullyQualifiedName(obj);
		}

		return parentsQualifiedName.append(qualifiedForName);
	}

	def private getCaseNumber(PatternCase caze) {
		val switchContainer = caze.eContainer as PatternSwitchCase
		return switchContainer.cases.indexOf(caze)
	}

	def dispatch QualifiedName computeFullyQualifiedNameInternal(PatternCase caze) {
		val qualifiedForName = QualifiedName.create(CASE__PREFIX + getCaseNumber(caze))

		var obj = caze as EObject
		var parentsQualifiedName = null as QualifiedName
		while (obj.eContainer !== null && parentsQualifiedName === null) {
			obj = obj.eContainer();
			parentsQualifiedName = getFullyQualifiedName(obj);
		}

		return parentsQualifiedName.append(qualifiedForName);
	}

	def private getCaseNumber(GenCase caze) {
		val switchContainer = caze.eContainer as GenSwitchCase
		return switchContainer.cases.indexOf(caze)
	}

	def dispatch QualifiedName computeFullyQualifiedNameInternal(GenCase caze) {
		val qualifiedForName = QualifiedName.create(CASE__PREFIX + getCaseNumber(caze))

		var obj = caze as EObject
		var parentsQualifiedName = null as QualifiedName
		while (obj.eContainer !== null && parentsQualifiedName === null) {
			obj = obj.eContainer();
			parentsQualifiedName = getFullyQualifiedName(obj);
		}

		return parentsQualifiedName.append(qualifiedForName);
	}

	def dispatch QualifiedName computeFullyQualifiedNameInternal(Switch zwitch) {
		val line = NodeModelUtils.getNode(zwitch).startLine
		val qualifiedForName = QualifiedName.create(SWITCH_PREFIX + line)

		var obj = zwitch as EObject
		var parentsQualifiedName = null as QualifiedName
		while (obj.eContainer !== null && parentsQualifiedName === null) {
			obj = obj.eContainer();
			parentsQualifiedName = getFullyQualifiedName(obj);
		}

		return parentsQualifiedName.append(qualifiedForName);
	}

	def dispatch QualifiedName computeFullyQualifiedNameInternal(Node node) {
		val qualifiedNodeName = QualifiedName.create(node.name)

		var obj = node as EObject
		var parentsQualifiedName = null as QualifiedName
		while (obj.eContainer !== null && parentsQualifiedName === null) {
			obj = obj.eContainer();
			parentsQualifiedName = getFullyQualifiedName(obj);
		}

		return parentsQualifiedName.append(qualifiedNodeName);
	}

	def dispatch QualifiedName computeFullyQualifiedNameInternal(EObject obj) {
		return super.computeFullyQualifiedNameFromNameAttribute(obj);
	}

}
