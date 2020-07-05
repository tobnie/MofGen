/**
 * generated by Xtext 2.20.0
 */
package org.mofgen.scoping;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.mofgen.mGLang.Assignment;
import org.mofgen.mGLang.MGLangPackage;
import org.mofgen.mGLang.MethodCall;
import org.mofgen.mGLang.MofgenFile;
import org.mofgen.mGLang.Node;
import org.mofgen.mGLang.NodeAttributeCall;
import org.mofgen.mGLang.NodeOrParameterOrCollection;
import org.mofgen.mGLang.Parameter;
import org.mofgen.mGLang.ParameterNode;
import org.mofgen.mGLang.ParameterRef;
import org.mofgen.mGLang.Pattern;
import org.mofgen.mGLang.PatternNodeReference;
import org.mofgen.scoping.AbstractMGLangScopeProvider;
import org.mofgen.utils.MofgenModelUtils;

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
@SuppressWarnings("all")
public class MGLangScopeProvider extends AbstractMGLangScopeProvider {
  @Override
  public IScope getScope(final EObject context, final EReference reference) {
    boolean _isNodeCreation = this.isNodeCreation(context, reference);
    if (_isNodeCreation) {
      return this.getScopeForNodeCreationType(((Node) context));
    }
    boolean _isReferenceType = this.isReferenceType(context, reference);
    if (_isReferenceType) {
      return this.getScopeForReferenceType(((PatternNodeReference) context));
    }
    boolean _isReferenceTarget = this.isReferenceTarget(context, reference);
    if (_isReferenceTarget) {
      return this.getScopeForReferenceTarget(((PatternNodeReference) context));
    }
    boolean _isNodeAttributeCallObject = this.isNodeAttributeCallObject(context, reference);
    if (_isNodeAttributeCallObject) {
      return this.getScopeForNodeAttributeCallObject(((NodeAttributeCall) context));
    }
    boolean _isNodeAttributeCallAttribute = this.isNodeAttributeCallAttribute(context, reference);
    if (_isNodeAttributeCallAttribute) {
      return this.getScopeForNodeAttributeCallAttribute(((NodeAttributeCall) context));
    }
    boolean _isNodeAttributeAssignmentType = this.isNodeAttributeAssignmentType(context, reference);
    if (_isNodeAttributeAssignmentType) {
      return this.getScopeForNodeAssignmentType(((Assignment) context));
    }
    boolean _isParameterRef = this.isParameterRef(context, reference);
    if (_isParameterRef) {
      return this.getScopeForParameterRef(((ParameterRef) context));
    }
    boolean _isMethodCallNode = this.isMethodCallNode(context, reference);
    if (_isMethodCallNode) {
      return this.getScopeForMethodCallNode(((MethodCall) context));
    }
    boolean _isMethodCallMethod = this.isMethodCallMethod(context, reference);
    if (_isMethodCallMethod) {
      return this.getScopeForMethodCallMethod(((MethodCall) context));
    }
    return super.getScope(context, reference);
  }
  
  public IScope getScopeForNodeCreationType(final Node n) {
    final MofgenFile file = this.getRootFile(n);
    final ArrayList<EClass> classes = MofgenModelUtils.getClasses(file);
    return Scopes.scopeFor(classes);
  }
  
  public IScope getScopeForReferenceType(final PatternNodeReference ref) {
    final MofgenFile file = this.getRootFile(ref);
    final Node src = EcoreUtil2.<Node>getContainerOfType(ref, Node.class);
    final ArrayList<EClass> classes = MofgenModelUtils.getClasses(file);
    final Function1<EClass, Boolean> _function = (EClass c) -> {
      EClass _type = src.getType();
      return Boolean.valueOf(Objects.equal(c, _type));
    };
    final Iterable<EClass> filteredClasses = IterableExtensions.<EClass>filter(classes, _function);
    boolean _isEmpty = IterableExtensions.isEmpty(filteredClasses);
    if (_isEmpty) {
      return IScope.NULLSCOPE;
    } else {
      return Scopes.scopeFor((((EClass[])Conversions.unwrapArray(filteredClasses, EClass.class))[0]).getEAllReferences());
    }
  }
  
  public IScope getScopeForAllNodes(final EObject context) {
    final MofgenFile root = this.getRootFile(context);
    final List<Node> allNodes = EcoreUtil2.<Node>getAllContentsOfType(root, Node.class);
    return Scopes.scopeFor(allNodes);
  }
  
  public IScope getScopeForReferenceTarget(final PatternNodeReference ref) {
    return this.getScopeForAllNodes(ref);
  }
  
  public IScope getScopeForNodeAttributeCallObject(final NodeAttributeCall call) {
    return this.getScopeForAllNodes(call);
  }
  
  public IScope getScopeForNodeAttributeCallAttribute(final NodeAttributeCall call) {
    final EClass objType = call.getNode().getType();
    final MofgenFile file = this.getRootFile(call);
    final Function1<EClass, Boolean> _function = (EClass c) -> {
      return Boolean.valueOf(Objects.equal(c, objType));
    };
    final Iterable<EClass> clazzez = IterableExtensions.<EClass>filter(MofgenModelUtils.getClasses(file), _function);
    boolean _isEmpty = IterableExtensions.isEmpty(clazzez);
    if (_isEmpty) {
      return IScope.NULLSCOPE;
    } else {
      return Scopes.scopeFor((((EClass[])Conversions.unwrapArray(clazzez, EClass.class))[0]).getEAllAttributes());
    }
  }
  
  public IScope getScopeForNodeAssignmentType(final Assignment ass) {
    final Node srcNode = EcoreUtil2.<Node>getContainerOfType(ass, Node.class);
    final MofgenFile file = this.getRootFile(ass);
    final ArrayList<EClass> clazzez = MofgenModelUtils.getClasses(file);
    try {
      final Function1<EClass, Boolean> _function = (EClass c) -> {
        EClass _type = srcNode.getType();
        return Boolean.valueOf(Objects.equal(c, _type));
      };
      final Iterable<EClass> filteredClazzez = IterableExtensions.<EClass>filter(clazzez, _function);
      boolean _isEmpty = IterableExtensions.isEmpty(filteredClazzez);
      if (_isEmpty) {
        return IScope.NULLSCOPE;
      } else {
        return Scopes.scopeFor((((EClass[])Conversions.unwrapArray(filteredClazzez, EClass.class))[0]).getEAllAttributes());
      }
    } catch (final Throwable _t) {
      if (_t instanceof NullPointerException) {
        return IScope.NULLSCOPE;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public IScope getScopeForParameterRef(final ParameterRef ref) {
    final Pattern pattern = EcoreUtil2.<Pattern>getContainerOfType(ref, Pattern.class);
    final EList<Parameter> params = pattern.getParameters();
    return Scopes.scopeFor(params);
  }
  
  public IScope getScopeForMethodCallNode(final MethodCall mc) {
    final Pattern pattern = EcoreUtil2.<Pattern>getContainerOfType(mc, Pattern.class);
    final Iterable<ParameterNode> params = Iterables.<ParameterNode>filter(pattern.getParameters(), ParameterNode.class);
    final EList<Node> nodes = pattern.getNodes();
    Iterable<NodeOrParameterOrCollection> _plus = Iterables.<NodeOrParameterOrCollection>concat(params, nodes);
    return Scopes.scopeFor(_plus);
  }
  
  public IScope getScopeForMethodCallMethod(final MethodCall mc) {
    final Node node = mc.getCalledNode();
    final MofgenFile file = this.getRootFile(mc);
    final Function1<EClass, Boolean> _function = (EClass c) -> {
      EClass _type = node.getType();
      return Boolean.valueOf(Objects.equal(c, _type));
    };
    final EClass calledClass = ((EClass[])Conversions.unwrapArray(IterableExtensions.<EClass>filter(MofgenModelUtils.getClasses(file), _function), EClass.class))[0];
    return Scopes.scopeFor(calledClass.getEAllOperations());
  }
  
  public boolean isReferenceType(final EObject context, final EReference reference) {
    return ((context instanceof PatternNodeReference) && 
      Objects.equal(reference, MGLangPackage.Literals.PATTERN_NODE_REFERENCE__TYPE));
  }
  
  public boolean isReferenceTarget(final EObject context, final EReference reference) {
    return ((context instanceof PatternNodeReference) && 
      Objects.equal(reference, MGLangPackage.Literals.PATTERN_NODE_REFERENCE__TARGET));
  }
  
  public boolean isNodeCreation(final EObject context, final EReference reference) {
    return ((context instanceof Node) && Objects.equal(reference, MGLangPackage.Literals.NODE__TYPE));
  }
  
  public boolean isNodeAttributeCallObject(final EObject context, final EReference reference) {
    return ((context instanceof NodeAttributeCall) && Objects.equal(reference, MGLangPackage.Literals.NODE_ATTRIBUTE_CALL__NODE));
  }
  
  public boolean isNodeAttributeCallAttribute(final EObject context, final EReference reference) {
    return ((context instanceof NodeAttributeCall) && 
      Objects.equal(reference, MGLangPackage.Literals.NODE_ATTRIBUTE_CALL__ATTRIBUTE));
  }
  
  public boolean isNodeAttributeAssignmentType(final EObject context, final EReference reference) {
    return ((context instanceof Assignment) && Objects.equal(reference, MGLangPackage.Literals.ASSIGNMENT__TARGET));
  }
  
  public boolean isParameterRef(final EObject context, final EReference reference) {
    return ((context instanceof ParameterRef) && Objects.equal(reference, MGLangPackage.Literals.PARAMETER_REF__REF));
  }
  
  public boolean isMethodCallNode(final EObject context, final EReference reference) {
    return ((context instanceof MethodCall) && Objects.equal(reference, MGLangPackage.Literals.METHOD_CALL__CALLED_NODE));
  }
  
  public boolean isMethodCallMethod(final EObject context, final EReference reference) {
    return ((context instanceof MethodCall) && Objects.equal(reference, MGLangPackage.Literals.METHOD_CALL__METHOD));
  }
  
  public MofgenFile getRootFile(final EObject context) {
    return EcoreUtil2.<MofgenFile>getContainerOfType(context, MofgenFile.class);
  }
}
