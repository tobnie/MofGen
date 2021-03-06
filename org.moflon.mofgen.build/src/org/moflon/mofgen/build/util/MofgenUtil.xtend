package org.moflon.mofgen.build.util

import java.io.IOException
import java.util.Map
import java.util.Optional
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.moflon.mofgen.build.MofgenBuilder
import org.moflon.mofgen.interpreter.TypeCalculator
import org.moflon.mofgen.mGLang.List
import org.moflon.mofgen.mGLang.Node
import org.moflon.mofgen.mGLang.Parameter
import org.moflon.mofgen.mGLang.ParameterNodeOrPattern
import org.moflon.mofgen.mGLang.Pattern
import org.moflon.mofgen.mGLang.PatternReturn
import org.moflon.mofgen.mGLang.PrimitiveParameter
import org.moflon.mofgen.mGLang.RefOrCall
import org.moflon.mofgen.typeModel.TypeModelPackage

class MofgenUtil {

	def static String getTextFromEditorFile(EObject obj) {
		return NodeModelUtils.getTokenText(NodeModelUtils.getNode(obj))
	}

	/**
	 * Scans all EPackages known by the build process for the given class
	 * @param eClass the eClass whose package should be retrieved
	 * @return the corresponding EPackage
	 */
	def static EPackage getEPackage(EClassifier EClassifier) {
		for (Object obj : MofgenBuilder.globalPackageRegistry.values) {
			val ePackage = obj as EPackage
			if (ePackage.EClassifiers.contains(EClassifier)) {
				return ePackage
			}
		}
		return null;
	}

	/**
	 * Returns the EPackage to the corresponding uri
	 * @param uriString the uri given as string
	 * @return the EPackage
	 */
	def static EPackage getEPackage(String uriString) {
		var opt = loadEcoreModel(uriString)
		if (opt.isPresent) {
			return getEPackageFromResource(opt.get);
		} else {
			return null;
		}
	}

	/**
	 * Extracts an EPackage from a given resource.
	 */
	def static EPackage getEPackageFromResource(Resource res) {
		return res.contents.get(0) as EPackage
	}

	def static getListType(List list) {
		val listType = TypeCalculator.getListType(list)
		return convertETypeToInternalType(listType)
	}

	/**
	 * Converts eTypes to the corresponding type of the internal type model
	 */
	def private static convertETypeToInternalType(EClassifier type) {
		switch type {
			case EcorePackage.Literals.ESTRING: TypeModelPackage.Literals.STRING
			case EcorePackage.Literals.EINT: TypeModelPackage.Literals.INTEGER
			case EcorePackage.Literals.EDOUBLE: TypeModelPackage.Literals.DOUBLE
			case EcorePackage.Literals.ECHAR: TypeModelPackage.Literals.STRING
			case EcorePackage.Literals.EBOOLEAN: TypeModelPackage.Literals.BOOLEAN
			default: type
		}
	}

	/**
	 * Returns the equivalent Java type as String for the given Parameter object.
	 */
	static def getJavaTypeAsString(Parameter parameter) {
		if (parameter instanceof PrimitiveParameter) {
			val type = parameter.type
			return type.literal
		}
		if (parameter instanceof ParameterNodeOrPattern) {
			val type = parameter.type
			if (type instanceof Node) {
				return type.type.instanceTypeName
			} else if (type instanceof Pattern) {
				return type.eClass.instanceTypeName
			} else {
				return new IllegalArgumentException(
					"Parameter that is not primitive must reference a node or a pattern");
			}
		}
	}

	/**
	 * return true if the given datatype is an eint, edouble, echar or eboolean
	 */
	def static boolean isDataTypePrimitive(EDataType dt) {
		return dt === EcorePackage.Literals.EINT || dt === EcorePackage.Literals.EDOUBLE ||
			dt === EcorePackage.Literals.EBOOLEAN || dt === EcorePackage.Literals.ECHAR
	}

	def static getMapKeyType(org.moflon.mofgen.mGLang.Map map) {
		val keyType = TypeCalculator.getMapType(map, true)
		return convertETypeToInternalType(keyType)
	}

	def static getMapEntryType(org.moflon.mofgen.mGLang.Map map) {
		val entryType = TypeCalculator.getMapType(map, false)
		return convertETypeToInternalType(entryType)
	}

	/**
	 * The set of meta-model resources loaded.
	 */
	static Map<URI, Resource> metaModelResources = newHashMap();

	/**
	 * The resource set used for loading the meta-model resources.
	 */
	static final ResourceSetImpl resourceSet = new ResourceSetImpl();

	/**
	 * Returns an Optional for the Ecore model resource with the given URI.
	 * 
	 * @param uriString the URI of the resource to load
	 */
	def static loadEcoreModel(String uriString) {
		val uri = URI.createURI(uriString);
		try {
			val resource = new ResourceSetImpl().getResource(uri, true);
			resource.load(null);

			// Early return if the resource does not exist or is empty.
			if (resource.getContents().isEmpty()) {
				removeResource(uri);
				return Optional.empty();
			}

			// Add/update resource if necessary.
			if (!metaModelResources.containsKey(uri) ||
				metaModelResources.get(uri).getTimeStamp() < resource.getTimeStamp()) {
				updateResource(uri);
			}
			return Optional.of(metaModelResources.get(uri));
		} catch (Exception e) {
			removeResource(uri);
			return Optional.empty();
		}
	}

	/**
	 * Updates the resource for the given URI in the resource set and the mapping
	 * between URIs and resources.
	 * 
	 * @param uri the URI to update
	 * @throws IOException if the resource cannot be loaded
	 */
	def static updateResource(URI uri) throws IOException {
		// Remove resource if it was loaded before -> force reload.
		removeResource(uri);

		val resource = resourceSet.getResource(uri, true);
		resource.load(null);
		EcoreUtil.resolveAll(resourceSet);
		metaModelResources.put(uri, resource);
	}

	/**
	 * Removes the resource for the given URI from the resource set and the mapping
	 * between URIs and resources.
	 * 
	 * @param uri the URI to remove
	 * @return an empty optional
	 */
	def static removeResource(URI uri) {
		if (metaModelResources.containsKey(uri)) {
			val resource = metaModelResources.get(uri);
			resource.unload();
			resourceSet.getResources().remove(resource);
			metaModelResources.remove(uri);
		}
	}

	def dispatch static String getGetterMethod(Node node) {
		return '''«NameProvider.getGetterName(node)»()'''
	}

	def dispatch static String getGetterMethod(Parameter pNode) {
		return '''«NameProvider.getGetterName(pNode)»()'''
	}

	def dispatch static String getGetterMethod(EStructuralFeature structuralFeature) {
		return '''«NameProvider.getGetterName(structuralFeature)»()'''
	}

	def dispatch static String getGetterMethod(PatternReturn ret) {
		val retVal = ret.retValue
		if(retVal instanceof RefOrCall){
			return getGetterMethod(retVal)
		}
		
		val ref = retVal.ref
		if (ref instanceof Parameter) {
			return getGetterMethod(ref)
		} else {
			return getGetterMethod(ref)
		}
	}

	def dispatch static String getGetterMethod(RefOrCall roc) {
		val ref = roc.ref
		if (roc.target !== null && roc.target.ref !== null) {
			return getGetterMethod(roc.target) + "." + getGetterMethod(ref)
		} else {
			if(ref === null){
				return ""
			}else{
				return getGetterMethod(ref)
			}
		}
	}

	def static boolean isThisCall(RefOrCall roc) {
		var rocIt = roc
		while (rocIt.target !== null) {
			rocIt = rocIt.target
		}
		return rocIt.thisUsed
	}

	def dispatch static String getGetterMethod(EObject obj) {
		throw new UnsupportedOperationException("Cannot provide parameter name to given object type " + obj)
	}

}
