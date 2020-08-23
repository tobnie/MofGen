/**
 * generated by Xtext 2.20.0
 */
package org.mofgen.mGLang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Case With Cast</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.mofgen.mGLang.CaseWithCast#getNode <em>Node</em>}</li>
 *   <li>{@link org.mofgen.mGLang.CaseWithCast#getWhen <em>When</em>}</li>
 * </ul>
 *
 * @see org.mofgen.mGLang.MGLangPackage#getCaseWithCast()
 * @model
 * @generated
 */
public interface CaseWithCast extends Case
{
  /**
   * Returns the value of the '<em><b>Node</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Node</em>' containment reference.
   * @see #setNode(Node)
   * @see org.mofgen.mGLang.MGLangPackage#getCaseWithCast_Node()
   * @model containment="true"
   * @generated
   */
  Node getNode();

  /**
   * Sets the value of the '{@link org.mofgen.mGLang.CaseWithCast#getNode <em>Node</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Node</em>' containment reference.
   * @see #getNode()
   * @generated
   */
  void setNode(Node value);

  /**
   * Returns the value of the '<em><b>When</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>When</em>' containment reference.
   * @see #setWhen(ArithmeticExpression)
   * @see org.mofgen.mGLang.MGLangPackage#getCaseWithCast_When()
   * @model containment="true"
   * @generated
   */
  ArithmeticExpression getWhen();

  /**
   * Sets the value of the '{@link org.mofgen.mGLang.CaseWithCast#getWhen <em>When</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>When</em>' containment reference.
   * @see #getWhen()
   * @generated
   */
  void setWhen(ArithmeticExpression value);

} // CaseWithCast