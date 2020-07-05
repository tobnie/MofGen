/**
 * generated by Xtext 2.20.0
 */
package org.mofgen.mGLang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Command Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.mofgen.mGLang.GenCommandBlock#getCommands <em>Commands</em>}</li>
 * </ul>
 *
 * @see org.mofgen.mGLang.MGLangPackage#getGenCommandBlock()
 * @model
 * @generated
 */
public interface GenCommandBlock extends ForBody, CaseBody
{
  /**
   * Returns the value of the '<em><b>Commands</b></em>' containment reference list.
   * The list contents are of type {@link org.mofgen.mGLang.GeneratorCommand}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Commands</em>' containment reference list.
   * @see org.mofgen.mGLang.MGLangPackage#getGenCommandBlock_Commands()
   * @model containment="true"
   * @generated
   */
  EList<GeneratorCommand> getCommands();

} // GenCommandBlock
