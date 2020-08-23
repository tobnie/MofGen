/**
 * generated by Xtext 2.20.0
 */
package org.mofgen.mGLang.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.mofgen.mGLang.MGLangPackage;
import org.mofgen.mGLang.RefOrCall;
import org.mofgen.mGLang.RefParams;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ref Or Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.mofgen.mGLang.impl.RefOrCallImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link org.mofgen.mGLang.impl.RefOrCallImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.mofgen.mGLang.impl.RefOrCallImpl#getParams <em>Params</em>}</li>
 *   <li>{@link org.mofgen.mGLang.impl.RefOrCallImpl#isBracesSet <em>Braces Set</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RefOrCallImpl extends ListAssignmentImpl implements RefOrCall
{
  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected EObject ref;

  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected RefOrCall target;

  /**
   * The cached value of the '{@link #getParams() <em>Params</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParams()
   * @generated
   * @ordered
   */
  protected RefParams params;

  /**
   * The default value of the '{@link #isBracesSet() <em>Braces Set</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isBracesSet()
   * @generated
   * @ordered
   */
  protected static final boolean BRACES_SET_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isBracesSet() <em>Braces Set</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isBracesSet()
   * @generated
   * @ordered
   */
  protected boolean bracesSet = BRACES_SET_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RefOrCallImpl()
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
    return MGLangPackage.Literals.REF_OR_CALL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject getRef()
  {
    if (ref != null && ref.eIsProxy())
    {
      InternalEObject oldRef = (InternalEObject)ref;
      ref = eResolveProxy(oldRef);
      if (ref != oldRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MGLangPackage.REF_OR_CALL__REF, oldRef, ref));
      }
    }
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject basicGetRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRef(EObject newRef)
  {
    EObject oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MGLangPackage.REF_OR_CALL__REF, oldRef, ref));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RefOrCall getTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTarget(RefOrCall newTarget, NotificationChain msgs)
  {
    RefOrCall oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MGLangPackage.REF_OR_CALL__TARGET, oldTarget, newTarget);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setTarget(RefOrCall newTarget)
  {
    if (newTarget != target)
    {
      NotificationChain msgs = null;
      if (target != null)
        msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MGLangPackage.REF_OR_CALL__TARGET, null, msgs);
      if (newTarget != null)
        msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MGLangPackage.REF_OR_CALL__TARGET, null, msgs);
      msgs = basicSetTarget(newTarget, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MGLangPackage.REF_OR_CALL__TARGET, newTarget, newTarget));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RefParams getParams()
  {
    return params;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParams(RefParams newParams, NotificationChain msgs)
  {
    RefParams oldParams = params;
    params = newParams;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MGLangPackage.REF_OR_CALL__PARAMS, oldParams, newParams);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setParams(RefParams newParams)
  {
    if (newParams != params)
    {
      NotificationChain msgs = null;
      if (params != null)
        msgs = ((InternalEObject)params).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MGLangPackage.REF_OR_CALL__PARAMS, null, msgs);
      if (newParams != null)
        msgs = ((InternalEObject)newParams).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MGLangPackage.REF_OR_CALL__PARAMS, null, msgs);
      msgs = basicSetParams(newParams, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MGLangPackage.REF_OR_CALL__PARAMS, newParams, newParams));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isBracesSet()
  {
    return bracesSet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setBracesSet(boolean newBracesSet)
  {
    boolean oldBracesSet = bracesSet;
    bracesSet = newBracesSet;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MGLangPackage.REF_OR_CALL__BRACES_SET, oldBracesSet, bracesSet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case MGLangPackage.REF_OR_CALL__TARGET:
        return basicSetTarget(null, msgs);
      case MGLangPackage.REF_OR_CALL__PARAMS:
        return basicSetParams(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case MGLangPackage.REF_OR_CALL__REF:
        if (resolve) return getRef();
        return basicGetRef();
      case MGLangPackage.REF_OR_CALL__TARGET:
        return getTarget();
      case MGLangPackage.REF_OR_CALL__PARAMS:
        return getParams();
      case MGLangPackage.REF_OR_CALL__BRACES_SET:
        return isBracesSet();
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
      case MGLangPackage.REF_OR_CALL__REF:
        setRef((EObject)newValue);
        return;
      case MGLangPackage.REF_OR_CALL__TARGET:
        setTarget((RefOrCall)newValue);
        return;
      case MGLangPackage.REF_OR_CALL__PARAMS:
        setParams((RefParams)newValue);
        return;
      case MGLangPackage.REF_OR_CALL__BRACES_SET:
        setBracesSet((Boolean)newValue);
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
      case MGLangPackage.REF_OR_CALL__REF:
        setRef((EObject)null);
        return;
      case MGLangPackage.REF_OR_CALL__TARGET:
        setTarget((RefOrCall)null);
        return;
      case MGLangPackage.REF_OR_CALL__PARAMS:
        setParams((RefParams)null);
        return;
      case MGLangPackage.REF_OR_CALL__BRACES_SET:
        setBracesSet(BRACES_SET_EDEFAULT);
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
      case MGLangPackage.REF_OR_CALL__REF:
        return ref != null;
      case MGLangPackage.REF_OR_CALL__TARGET:
        return target != null;
      case MGLangPackage.REF_OR_CALL__PARAMS:
        return params != null;
      case MGLangPackage.REF_OR_CALL__BRACES_SET:
        return bracesSet != BRACES_SET_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (bracesSet: ");
    result.append(bracesSet);
    result.append(')');
    return result.toString();
  }

} //RefOrCallImpl
