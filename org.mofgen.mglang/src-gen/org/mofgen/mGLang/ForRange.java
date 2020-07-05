/**
 * generated by Xtext 2.20.0
 */
package org.mofgen.mGLang;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.mofgen.mGLang.ForRange#getStart <em>Start</em>}</li>
 *   <li>{@link org.mofgen.mGLang.ForRange#getEnd <em>End</em>}</li>
 * </ul>
 *
 * @see org.mofgen.mGLang.MGLangPackage#getForRange()
 * @model
 * @generated
 */
public interface ForRange extends EObject
{
  /**
   * Returns the value of the '<em><b>Start</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Start</em>' attribute.
   * @see #setStart(int)
   * @see org.mofgen.mGLang.MGLangPackage#getForRange_Start()
   * @model
   * @generated
   */
  int getStart();

  /**
   * Sets the value of the '{@link org.mofgen.mGLang.ForRange#getStart <em>Start</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Start</em>' attribute.
   * @see #getStart()
   * @generated
   */
  void setStart(int value);

  /**
   * Returns the value of the '<em><b>End</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>End</em>' attribute.
   * @see #setEnd(int)
   * @see org.mofgen.mGLang.MGLangPackage#getForRange_End()
   * @model
   * @generated
   */
  int getEnd();

  /**
   * Sets the value of the '{@link org.mofgen.mGLang.ForRange#getEnd <em>End</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>End</em>' attribute.
   * @see #getEnd()
   * @generated
   */
  void setEnd(int value);

} // ForRange
