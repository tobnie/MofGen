/**
 * generated by Xtext 2.20.0
 */
package org.mofgen.mGLang.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.mofgen.mGLang.BlockIf;
import org.mofgen.mGLang.IfBody;
import org.mofgen.mGLang.IfHeadAndBody;
import org.mofgen.mGLang.MGLangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block If</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.mofgen.mGLang.impl.BlockIfImpl#getIf <em>If</em>}</li>
 *   <li>{@link org.mofgen.mGLang.impl.BlockIfImpl#getElseifs <em>Elseifs</em>}</li>
 *   <li>{@link org.mofgen.mGLang.impl.BlockIfImpl#getElse <em>Else</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BlockIfImpl extends MinimalEObjectImpl.Container implements BlockIf
{
  /**
   * The cached value of the '{@link #getIf() <em>If</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIf()
   * @generated
   * @ordered
   */
  protected IfHeadAndBody if_;

  /**
   * The cached value of the '{@link #getElseifs() <em>Elseifs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElseifs()
   * @generated
   * @ordered
   */
  protected EList<IfHeadAndBody> elseifs;

  /**
   * The cached value of the '{@link #getElse() <em>Else</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElse()
   * @generated
   * @ordered
   */
  protected IfBody else_;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BlockIfImpl()
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
    return MGLangPackage.Literals.BLOCK_IF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IfHeadAndBody getIf()
  {
    return if_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIf(IfHeadAndBody newIf, NotificationChain msgs)
  {
    IfHeadAndBody oldIf = if_;
    if_ = newIf;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MGLangPackage.BLOCK_IF__IF, oldIf, newIf);
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
  public void setIf(IfHeadAndBody newIf)
  {
    if (newIf != if_)
    {
      NotificationChain msgs = null;
      if (if_ != null)
        msgs = ((InternalEObject)if_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MGLangPackage.BLOCK_IF__IF, null, msgs);
      if (newIf != null)
        msgs = ((InternalEObject)newIf).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MGLangPackage.BLOCK_IF__IF, null, msgs);
      msgs = basicSetIf(newIf, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MGLangPackage.BLOCK_IF__IF, newIf, newIf));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<IfHeadAndBody> getElseifs()
  {
    if (elseifs == null)
    {
      elseifs = new EObjectContainmentEList<IfHeadAndBody>(IfHeadAndBody.class, this, MGLangPackage.BLOCK_IF__ELSEIFS);
    }
    return elseifs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IfBody getElse()
  {
    return else_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElse(IfBody newElse, NotificationChain msgs)
  {
    IfBody oldElse = else_;
    else_ = newElse;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MGLangPackage.BLOCK_IF__ELSE, oldElse, newElse);
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
  public void setElse(IfBody newElse)
  {
    if (newElse != else_)
    {
      NotificationChain msgs = null;
      if (else_ != null)
        msgs = ((InternalEObject)else_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MGLangPackage.BLOCK_IF__ELSE, null, msgs);
      if (newElse != null)
        msgs = ((InternalEObject)newElse).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MGLangPackage.BLOCK_IF__ELSE, null, msgs);
      msgs = basicSetElse(newElse, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MGLangPackage.BLOCK_IF__ELSE, newElse, newElse));
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
      case MGLangPackage.BLOCK_IF__IF:
        return basicSetIf(null, msgs);
      case MGLangPackage.BLOCK_IF__ELSEIFS:
        return ((InternalEList<?>)getElseifs()).basicRemove(otherEnd, msgs);
      case MGLangPackage.BLOCK_IF__ELSE:
        return basicSetElse(null, msgs);
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
      case MGLangPackage.BLOCK_IF__IF:
        return getIf();
      case MGLangPackage.BLOCK_IF__ELSEIFS:
        return getElseifs();
      case MGLangPackage.BLOCK_IF__ELSE:
        return getElse();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MGLangPackage.BLOCK_IF__IF:
        setIf((IfHeadAndBody)newValue);
        return;
      case MGLangPackage.BLOCK_IF__ELSEIFS:
        getElseifs().clear();
        getElseifs().addAll((Collection<? extends IfHeadAndBody>)newValue);
        return;
      case MGLangPackage.BLOCK_IF__ELSE:
        setElse((IfBody)newValue);
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
      case MGLangPackage.BLOCK_IF__IF:
        setIf((IfHeadAndBody)null);
        return;
      case MGLangPackage.BLOCK_IF__ELSEIFS:
        getElseifs().clear();
        return;
      case MGLangPackage.BLOCK_IF__ELSE:
        setElse((IfBody)null);
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
      case MGLangPackage.BLOCK_IF__IF:
        return if_ != null;
      case MGLangPackage.BLOCK_IF__ELSEIFS:
        return elseifs != null && !elseifs.isEmpty();
      case MGLangPackage.BLOCK_IF__ELSE:
        return else_ != null;
    }
    return super.eIsSet(featureID);
  }

} //BlockIfImpl
