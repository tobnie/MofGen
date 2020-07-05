/**
 * generated by Xtext 2.20.0
 */
package org.mofgen.mGLang.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.mofgen.mGLang.ArithmeticExpression;
import org.mofgen.mGLang.GeneratorCommand;
import org.mofgen.mGLang.MGLangPackage;
import org.mofgen.mGLang.SingleLineIf;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Line If</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.mofgen.mGLang.impl.SingleLineIfImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.mofgen.mGLang.impl.SingleLineIfImpl#getCommand <em>Command</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SingleLineIfImpl extends IfStatementImpl implements SingleLineIf
{
  /**
   * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCondition()
   * @generated
   * @ordered
   */
  protected ArithmeticExpression condition;

  /**
   * The cached value of the '{@link #getCommand() <em>Command</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCommand()
   * @generated
   * @ordered
   */
  protected GeneratorCommand command;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SingleLineIfImpl()
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
    return MGLangPackage.Literals.SINGLE_LINE_IF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ArithmeticExpression getCondition()
  {
    return condition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCondition(ArithmeticExpression newCondition, NotificationChain msgs)
  {
    ArithmeticExpression oldCondition = condition;
    condition = newCondition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MGLangPackage.SINGLE_LINE_IF__CONDITION, oldCondition, newCondition);
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
  public void setCondition(ArithmeticExpression newCondition)
  {
    if (newCondition != condition)
    {
      NotificationChain msgs = null;
      if (condition != null)
        msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MGLangPackage.SINGLE_LINE_IF__CONDITION, null, msgs);
      if (newCondition != null)
        msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MGLangPackage.SINGLE_LINE_IF__CONDITION, null, msgs);
      msgs = basicSetCondition(newCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MGLangPackage.SINGLE_LINE_IF__CONDITION, newCondition, newCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public GeneratorCommand getCommand()
  {
    return command;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCommand(GeneratorCommand newCommand, NotificationChain msgs)
  {
    GeneratorCommand oldCommand = command;
    command = newCommand;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MGLangPackage.SINGLE_LINE_IF__COMMAND, oldCommand, newCommand);
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
  public void setCommand(GeneratorCommand newCommand)
  {
    if (newCommand != command)
    {
      NotificationChain msgs = null;
      if (command != null)
        msgs = ((InternalEObject)command).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MGLangPackage.SINGLE_LINE_IF__COMMAND, null, msgs);
      if (newCommand != null)
        msgs = ((InternalEObject)newCommand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MGLangPackage.SINGLE_LINE_IF__COMMAND, null, msgs);
      msgs = basicSetCommand(newCommand, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MGLangPackage.SINGLE_LINE_IF__COMMAND, newCommand, newCommand));
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
      case MGLangPackage.SINGLE_LINE_IF__CONDITION:
        return basicSetCondition(null, msgs);
      case MGLangPackage.SINGLE_LINE_IF__COMMAND:
        return basicSetCommand(null, msgs);
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
      case MGLangPackage.SINGLE_LINE_IF__CONDITION:
        return getCondition();
      case MGLangPackage.SINGLE_LINE_IF__COMMAND:
        return getCommand();
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
      case MGLangPackage.SINGLE_LINE_IF__CONDITION:
        setCondition((ArithmeticExpression)newValue);
        return;
      case MGLangPackage.SINGLE_LINE_IF__COMMAND:
        setCommand((GeneratorCommand)newValue);
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
      case MGLangPackage.SINGLE_LINE_IF__CONDITION:
        setCondition((ArithmeticExpression)null);
        return;
      case MGLangPackage.SINGLE_LINE_IF__COMMAND:
        setCommand((GeneratorCommand)null);
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
      case MGLangPackage.SINGLE_LINE_IF__CONDITION:
        return condition != null;
      case MGLangPackage.SINGLE_LINE_IF__COMMAND:
        return command != null;
    }
    return super.eIsSet(featureID);
  }

} //SingleLineIfImpl