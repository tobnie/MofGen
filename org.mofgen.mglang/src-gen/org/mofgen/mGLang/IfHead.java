/**
 * generated by Xtext 2.20.0
 */
package org.mofgen.mGLang;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Head</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.mofgen.mGLang.IfHead#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see org.mofgen.mGLang.MGLangPackage#getIfHead()
 * @model
 * @generated
 */
public interface IfHead extends EObject
{
  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(ArithmeticExpression)
   * @see org.mofgen.mGLang.MGLangPackage#getIfHead_Condition()
   * @model containment="true"
   * @generated
   */
  ArithmeticExpression getCondition();

  /**
   * Sets the value of the '{@link org.mofgen.mGLang.IfHead#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(ArithmeticExpression value);

} // IfHead
