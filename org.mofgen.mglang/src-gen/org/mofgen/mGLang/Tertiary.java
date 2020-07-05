/**
 * generated by Xtext 2.20.0
 */
package org.mofgen.mGLang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tertiary</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.mofgen.mGLang.Tertiary#getLeft <em>Left</em>}</li>
 *   <li>{@link org.mofgen.mGLang.Tertiary#getOp <em>Op</em>}</li>
 *   <li>{@link org.mofgen.mGLang.Tertiary#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see org.mofgen.mGLang.MGLangPackage#getTertiary()
 * @model
 * @generated
 */
public interface Tertiary extends ArithmeticExpression
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(ArithmeticExpression)
   * @see org.mofgen.mGLang.MGLangPackage#getTertiary_Left()
   * @model containment="true"
   * @generated
   */
  ArithmeticExpression getLeft();

  /**
   * Sets the value of the '{@link org.mofgen.mGLang.Tertiary#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(ArithmeticExpression value);

  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * The literals are from the enumeration {@link org.mofgen.mGLang.TertiaryOp}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see org.mofgen.mGLang.TertiaryOp
   * @see #setOp(TertiaryOp)
   * @see org.mofgen.mGLang.MGLangPackage#getTertiary_Op()
   * @model
   * @generated
   */
  TertiaryOp getOp();

  /**
   * Sets the value of the '{@link org.mofgen.mGLang.Tertiary#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see org.mofgen.mGLang.TertiaryOp
   * @see #getOp()
   * @generated
   */
  void setOp(TertiaryOp value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(ArithmeticExpression)
   * @see org.mofgen.mGLang.MGLangPackage#getTertiary_Right()
   * @model containment="true"
   * @generated
   */
  ArithmeticExpression getRight();

  /**
   * Sets the value of the '{@link org.mofgen.mGLang.Tertiary#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(ArithmeticExpression value);

} // Tertiary
