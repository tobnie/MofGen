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
 *   <li>{@link org.mofgen.mGLang.ForEachHead#getEref <em>Eref</em>}</li>
 * </ul>
 *
 * @see org.mofgen.mGLang.MGLangPackage#getForEachHead()
 * @model
 * @generated
 */
public interface ForEachHead extends ForHead
{
  /**
   * Returns the value of the '<em><b>Src</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Src</em>' containment reference.
   * @see #setSrc(RefOrCall)
   * @see org.mofgen.mGLang.MGLangPackage#getForEachHead_Src()
   * @model containment="true"
   * @generated
   */
  RefOrCall getSrc();

  /**
   * Sets the value of the '{@link org.mofgen.mGLang.ForEachHead#getSrc <em>Src</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Src</em>' containment reference.
   * @see #getSrc()
   * @generated
   */
  void setSrc(RefOrCall value);

  /**
   * Returns the value of the '<em><b>Eref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Eref</em>' reference.
   * @see #setEref(EReference)
   * @see org.mofgen.mGLang.MGLangPackage#getForEachHead_Eref()
   * @model
   * @generated
   */
  EReference getEref();

  /**
   * Sets the value of the '{@link org.mofgen.mGLang.ForEachHead#getEref <em>Eref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Eref</em>' reference.
   * @see #getEref()
   * @generated
   */
  void setEref(EReference value);

} // ForEachHead
