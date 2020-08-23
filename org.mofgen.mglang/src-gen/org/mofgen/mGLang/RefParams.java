/**
 * generated by Xtext 2.20.0
 */
package org.mofgen.mGLang;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ref Params</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.mofgen.mGLang.RefParams#getParams <em>Params</em>}</li>
 * </ul>
 *
 * @see org.mofgen.mGLang.MGLangPackage#getRefParams()
 * @model
 * @generated
 */
public interface RefParams extends EObject
{
  /**
   * Returns the value of the '<em><b>Params</b></em>' containment reference list.
   * The list contents are of type {@link org.mofgen.mGLang.ArithmeticExpression}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Params</em>' containment reference list.
   * @see org.mofgen.mGLang.MGLangPackage#getRefParams_Params()
   * @model containment="true"
   * @generated
   */
  EList<ArithmeticExpression> getParams();

} // RefParams