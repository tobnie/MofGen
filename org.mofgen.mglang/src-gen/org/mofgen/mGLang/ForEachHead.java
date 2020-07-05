/**
 * generated by Xtext 2.20.0
 */
package org.mofgen.mGLang;

import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Each Head</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.mofgen.mGLang.ForEachHead#getSrc <em>Src</em>}</li>
 *   <li>{@link org.mofgen.mGLang.ForEachHead#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @see org.mofgen.mGLang.MGLangPackage#getForEachHead()
 * @model
 * @generated
 */
public interface ForEachHead extends ForHead
{
  /**
   * Returns the value of the '<em><b>Src</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Src</em>' reference.
   * @see #setSrc(NodeOrParameterOrCollection)
   * @see org.mofgen.mGLang.MGLangPackage#getForEachHead_Src()
   * @model
   * @generated
   */
  NodeOrParameterOrCollection getSrc();

  /**
   * Sets the value of the '{@link org.mofgen.mGLang.ForEachHead#getSrc <em>Src</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Src</em>' reference.
   * @see #getSrc()
   * @generated
   */
  void setSrc(NodeOrParameterOrCollection value);

  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(EReference)
   * @see org.mofgen.mGLang.MGLangPackage#getForEachHead_Ref()
   * @model
   * @generated
   */
  EReference getRef();

  /**
   * Sets the value of the '{@link org.mofgen.mGLang.ForEachHead#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(EReference value);

} // ForEachHead
