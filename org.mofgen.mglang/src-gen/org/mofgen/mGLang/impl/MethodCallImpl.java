/**
 * generated by Xtext 2.20.0
 */
package org.mofgen.mGLang.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.mofgen.mGLang.MGLangPackage;
import org.mofgen.mGLang.MethodCall;
import org.mofgen.mGLang.Node;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.mofgen.mGLang.impl.MethodCallImpl#getCalledNode <em>Called Node</em>}</li>
 *   <li>{@link org.mofgen.mGLang.impl.MethodCallImpl#getMethod <em>Method</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MethodCallImpl extends ParameterRefOrMethodCallImpl implements MethodCall
{
  /**
   * The cached value of the '{@link #getCalledNode() <em>Called Node</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCalledNode()
   * @generated
   * @ordered
   */
  protected Node calledNode;

  /**
   * The cached value of the '{@link #getMethod() <em>Method</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethod()
   * @generated
   * @ordered
   */
  protected EOperation method;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MethodCallImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MGLangPackage.Literals.METHOD_CALL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Node getCalledNode()
  {
    if (calledNode != null && calledNode.eIsProxy())
    {
      InternalEObject oldCalledNode = (InternalEObject)calledNode;
      calledNode = (Node)eResolveProxy(oldCalledNode);
      if (calledNode != oldCalledNode)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MGLangPackage.METHOD_CALL__CALLED_NODE, oldCalledNode, calledNode));
      }
    }
    return calledNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Node basicGetCalledNode()
  {
    return calledNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setCalledNode(Node newCalledNode)
  {
    Node oldCalledNode = calledNode;
    calledNode = newCalledNode;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MGLangPackage.METHOD_CALL__CALLED_NODE, oldCalledNode, calledNode));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getMethod()
  {
    if (method != null && method.eIsProxy())
    {
      InternalEObject oldMethod = (InternalEObject)method;
      method = (EOperation)eResolveProxy(oldMethod);
      if (method != oldMethod)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MGLangPackage.METHOD_CALL__METHOD, oldMethod, method));
      }
    }
    return method;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation basicGetMethod()
  {
    return method;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setMethod(EOperation newMethod)
  {
    EOperation oldMethod = method;
    method = newMethod;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MGLangPackage.METHOD_CALL__METHOD, oldMethod, method));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MGLangPackage.METHOD_CALL__CALLED_NODE:
        if (resolve) return getCalledNode();
        return basicGetCalledNode();
      case MGLangPackage.METHOD_CALL__METHOD:
        if (resolve) return getMethod();
        return basicGetMethod();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MGLangPackage.METHOD_CALL__CALLED_NODE:
        setCalledNode((Node)newValue);
        return;
      case MGLangPackage.METHOD_CALL__METHOD:
        setMethod((EOperation)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MGLangPackage.METHOD_CALL__CALLED_NODE:
        setCalledNode((Node)null);
        return;
      case MGLangPackage.METHOD_CALL__METHOD:
        setMethod((EOperation)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MGLangPackage.METHOD_CALL__CALLED_NODE:
        return calledNode != null;
      case MGLangPackage.METHOD_CALL__METHOD:
        return method != null;
    }
    return super.eIsSet(featureID);
  }

} //MethodCallImpl
