package org.mofgen.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.mofgen.mGLang.Import;
import org.mofgen.mGLang.MofgenFile;
import org.mofgen.mGLang.Node;
import org.mofgen.mGLang.Parameter;
import org.mofgen.mGLang.ParameterNodeOrPattern;
import org.mofgen.mGLang.Pattern;
import org.mofgen.mGLang.PrimitiveParameter;
import org.mofgen.typeModel.TypeModelPackage;

import com.google.common.base.Function;

public class MofgenModelUtils {
	/**
	 * The set of meta-model resources loaded.
	 */
	private static Map<URI, Resource> metaModelResources = new HashMap<>();

	/**
	 * The resource set used for loading the meta-model resources.
	 */
	private static final ResourceSetImpl resourceSet = new ResourceSetImpl();

	/**
	 * Returns all EClasses imported into the given file.
	 * 
	 * @param file the Mofgen file
	 */
	public static ArrayList<EClass> getClasses(final MofgenFile file) {
		final ArrayList<EClass> classes = new ArrayList<>();
		file.getImports().forEach(i -> {
			loadEcoreModel(i.getUri()).ifPresent(m -> classes.addAll(getElements(m, EClass.class)));
		});

		return classes;
	}

	/**
	 * Returns all EClasses imported into the given file without name conflicts. If
	 * there are several classes with the same name in different imports, only the
	 * class imported first is considered.
	 * 
	 * @param file the Mofgen file
	 */
	public static ArrayList<EClass> getUniqueClasses(final MofgenFile file) {
		final ArrayList<EClass> classes = new ArrayList<>();
		file.getImports().forEach(i -> {
			loadEcoreModel(i.getUri()).ifPresent(m -> addIfClassNamesNotContained(m, classes));
		});

		return classes;
	}

	/**
	 * Adds the classes given by the resourece m to the given list
	 * 
	 * @param m       - the resource to load classes from
	 * @param classes - the list to add the classes to
	 * @return true if all operations succeeded, false otherwise
	 */
	private static boolean addIfClassNamesNotContained(Resource m, ArrayList<EClass> classes) {
		for (EClass clazz : getElements(m, EClass.class)) {
			if (!containsClass(classes, clazz)) {
				if (!classes.add(clazz)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * @return true if a class with the same name as the given class is contained in
	 *         the given list, false otherwise
	 */
	private static boolean containsClass(ArrayList<EClass> classes, EClass insertedClass) {
		for (EClass clazz : classes) {
			if (clazz.getName().equals(insertedClass.getName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns all EClasses imported by the given Import-Object
	 * 
	 * @param imp the import object
	 */
	public static ArrayList<EClass> getClassesFromImport(final Import imp) {
		final ArrayList<EClass> classes = new ArrayList<>();
		loadEcoreModel(imp.getUri()).ifPresent(m -> classes.addAll(getElements(m, EClass.class)));
		return classes;
	}

	/**
	 * Returns all EClasses imported by the imports in the given list
	 * 
	 * @param imps the import objects
	 */
	public static ArrayList<EClass> getClassesFromImportList(final List<Import> imps) {
		final ArrayList<EClass> classes = new ArrayList<>();
		imps.forEach(i -> {
			loadEcoreModel(i.getUri()).ifPresent(m -> classes.addAll(getElements(m, EClass.class)));
		});
		return classes;
	}

	/**
	 * Returns all EDataTypes imported into the given file.
	 * 
	 * @param file the Mofgen file
	 */
	public static ArrayList<EDataType> getDatatypes(final MofgenFile file) {
		final ArrayList<EDataType> types = new ArrayList<>();
		file.getImports().forEach(i -> {
			loadEcoreModel(i.getName()).ifPresent(m -> types.addAll(getElements(m, EDataType.class)));
		});
		return types;
	}

	/**
	 * Returns all EEnums imported into the given file.
	 * 
	 * @param file the Mofgen file
	 */
	public static ArrayList<EEnum> getEnums(final MofgenFile file) {
		final ArrayList<EEnum> enums = new ArrayList<>();
		file.getImports().forEach(i -> {
			loadEcoreModel(i.getUri()).ifPresent(m -> enums.addAll(getElements(m, EEnum.class)));
		});

		return enums;
	}

	/**
	 * Returns all EEnums imported into the given file without name conflicts. If
	 * there are several enums with the same name in different imports, only the
	 * enum imported first is considered.
	 * 
	 * @param file the Mofgen file
	 */
	public static ArrayList<EEnum> getUniqueEnums(final MofgenFile file) {
		final ArrayList<EEnum> enums = new ArrayList<>();
		file.getImports().forEach(i -> {
			loadEcoreModel(i.getUri()).ifPresent(m -> addIfEnumNamesNotContained(m, enums));
		});

		return enums;
	}

	/**
	 * Adds the enums given by the resource m to the given list
	 * 
	 * @param m     - the resource to load enums from
	 * @param enums - the list to add the enums to
	 * @return true if all operations succeeded, false otherwise
	 */
	private static boolean addIfEnumNamesNotContained(Resource m, ArrayList<EEnum> enums) {
		for (EEnum eenum : getElements(m, EEnum.class)) {
			if (!containsEnum(enums, eenum)) {
				if (!enums.add(eenum)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * @return true if an enum with the same name as the given enum is contained in
	 *         the given list, false otherwise
	 */
	private static boolean containsEnum(ArrayList<EEnum> enums, EEnum insertedEnum) {
		for (EEnum clazz : enums) {
			if (clazz.getName().equals(insertedEnum.getName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns all EEnums imported by the given Import-Object
	 * 
	 * @param imp the import object
	 */
	public static ArrayList<EEnum> getEnumsFromImport(final Import imp) {
		final ArrayList<EEnum> enums = new ArrayList<>();
		loadEcoreModel(imp.getUri()).ifPresent(m -> enums.addAll(getElements(m, EEnum.class)));
		return enums;
	}

	/**
	 * Returns all objects from the given resource.
	 * 
	 * @param resource the resource
	 * @param type     the type
	 * @return the elements with the given type in the resource
	 */
	public static <T extends EObject> List<T> getElements(final Resource resource, final Class<T> type) {
		return EcoreUtil2.getAllContentsOfType(resource.getContents().get(0), type);
	}

	/**
	 * @return the root container of the given EObject as MofgenFile
	 */
	public static MofgenFile getRootFile(final EObject obj) {
		return (MofgenFile) EcoreUtil2.getRootContainer(obj);
	}

	/**
	 * Returns an Optional for the Ecore model resource with the given URI.
	 * 
	 * @param uriString the URI of the resource to load
	 */
	public static Optional<Resource> loadEcoreModel(final String uriString) {
		final URI uri = URI.createURI(uriString);
		try {
			final Resource resource = new ResourceSetImpl().getResource(uri, true);
			resource.load(null);

			// Early return if the resource does not exist or is empty.
			if (resource.getContents().isEmpty()) {
				removeResource(uri);
				return Optional.empty();
			}

			// Add/update resource if necessary.
			if (!metaModelResources.containsKey(uri)
					|| metaModelResources.get(uri).getTimeStamp() < resource.getTimeStamp()) {
				updateResource(uri);
			}
			return Optional.of(metaModelResources.get(uri));
		} catch (final Exception e) {
			removeResource(uri);
			return Optional.empty();
		}
	}

	/**
	 * Removes the resource for the given URI from the resource set and the mapping
	 * between URIs and resources.
	 * 
	 * @param uri the URI to remove
	 * @return an empty optional
	 */
	private static void removeResource(final URI uri) {
		if (metaModelResources.containsKey(uri)) {
			final Resource resource = metaModelResources.get(uri);
			resource.unload();
			resourceSet.getResources().remove(resource);
			metaModelResources.remove(uri);
		}
	}

	/**
	 * Updates the resource for the given URI in the resource set and the mapping
	 * between URIs and resources.
	 * 
	 * @param uri the URI to update
	 * @throws IOException if the resource cannot be loaded
	 */
	private static void updateResource(final URI uri) throws IOException {
		// Remove resource if it was loaded before -> force reload.
		removeResource(uri);

		final Resource resource = resourceSet.getResource(uri, true);
		resource.load(null);
		EcoreUtil.resolveAll(resourceSet);
		metaModelResources.put(uri, resource);
	}

	/**
	 * @return the type of the given parameter in terms of the internal type system (see TypeModel)
	 */
	public static EClass getInternalParameterType(Parameter param) {
		if (param instanceof PrimitiveParameter) {
			PrimitiveParameter primPram = (PrimitiveParameter) param;
			switch (primPram.getType()) {
			case INT:
				return TypeModelPackage.Literals.NUMBER;
			case DOUBLE:
				return TypeModelPackage.Literals.NUMBER;
			case STRING:
				return TypeModelPackage.Literals.STRING;
			case CHAR:
				return TypeModelPackage.Literals.STRING;
			case BOOLEAN:
				return TypeModelPackage.Literals.BOOLEAN;
			default:
				throw new IllegalArgumentException(
						"Unexpected type " + primPram.getType() + " for parameter " + param.getName());
			}
		}else if (param instanceof ParameterNodeOrPattern) {
			ParameterNodeOrPattern nodeOrPattern = (ParameterNodeOrPattern) param;
			EObject parameterType = nodeOrPattern.getType();
			if (parameterType instanceof Node) {
				Node node = (Node) parameterType;
				return getEClassForInternalModel(node.getType());
			}else {
				return (EClass) parameterType;
			}
		}else {
			throw new IllegalArgumentException("Unknown parameter type for parameter " + param.getName());
		}
	}

	public static EClass getEClassForInternalModel(EClassifier classifier) {
		if (classifier != null && classifier instanceof EClass) {
			return (EClass) classifier;
		}
		if (classifier != null && classifier instanceof EEnum) {
			return TypeModelPackage.Literals.ENUM;
		}
		if (classifier != null && classifier instanceof EDataType) {
			EDataType datatype = (EDataType) classifier;
			if (datatype == EcorePackage.Literals.EBIG_DECIMAL)
				return TypeModelPackage.Literals.NUMBER;
			if (datatype == EcorePackage.Literals.EBIG_INTEGER)
				return TypeModelPackage.Literals.NUMBER;
			if (datatype == EcorePackage.Literals.EBYTE)
				return TypeModelPackage.Literals.NUMBER;
			if (datatype == EcorePackage.Literals.EDOUBLE)
				return TypeModelPackage.Literals.NUMBER;
			if (datatype == EcorePackage.Literals.EFLOAT)
				return TypeModelPackage.Literals.NUMBER;
			if (datatype == EcorePackage.Literals.EINT)
				return TypeModelPackage.Literals.NUMBER;
			if (datatype == EcorePackage.Literals.ELONG)
				return TypeModelPackage.Literals.NUMBER;

			// Enums
			if (datatype == EcorePackage.Literals.EENUM)
				return TypeModelPackage.Literals.ENUM;
			if (datatype == EcorePackage.Literals.EENUM_LITERAL)
				return TypeModelPackage.Literals.ENUM_LITERAL;

			// Booleans
			if (datatype == EcorePackage.Literals.EBOOLEAN)
				return TypeModelPackage.Literals.BOOLEAN;

			// Strings
			if (datatype == EcorePackage.Literals.ESTRING)
				return TypeModelPackage.Literals.STRING;
			if (datatype == EcorePackage.Literals.ECHAR)
				return TypeModelPackage.Literals.STRING;
		}
		throw new IllegalStateException("Could not convert eClassifier " + classifier.getName());
	}

	public static Function<EObject, QualifiedName> getFunctionForUpperCasePatternScopes() {
		return new Function<EObject, QualifiedName>() {
			@Override
			public QualifiedName apply(EObject o) {
				if (o instanceof Node) {
					return QualifiedName.create(((Node) o).getName());
				} else if (o instanceof Pattern) {
					return QualifiedName.create(firstToUpperCase(((Pattern) o).getName()));
				} else {
					return QualifiedName.create(SimpleAttributeResolver.NAME_RESOLVER.apply(o));
				}
			}
		};
	}

	public static String firstToUpperCase(String str) {
		if (str == null || str.equals("")) {
			return "";
		} else {
			return str.substring(0, 1).toUpperCase() + str.substring(1);
		}
	}
}
