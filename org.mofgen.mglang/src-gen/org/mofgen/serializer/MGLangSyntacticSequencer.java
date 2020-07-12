/*
 * generated by Xtext 2.20.0
 */
package org.mofgen.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.mofgen.services.MGLangGrammarAccess;

@SuppressWarnings("all")
public class MGLangSyntacticSequencer extends AbstractSyntacticSequencer {

	protected MGLangGrammarAccess grammarAccess;
	protected AbstractElementAlias match_BaseExpr_LeftParenthesisKeyword_0_0_a;
	protected AbstractElementAlias match_BaseExpr_LeftParenthesisKeyword_0_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (MGLangGrammarAccess) access;
		match_BaseExpr_LeftParenthesisKeyword_0_0_a = new TokenAlias(true, true, grammarAccess.getBaseExprAccess().getLeftParenthesisKeyword_0_0());
		match_BaseExpr_LeftParenthesisKeyword_0_0_p = new TokenAlias(true, false, grammarAccess.getBaseExprAccess().getLeftParenthesisKeyword_0_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (ruleCall.getRule() == grammarAccess.getASSIGNMENT_OPRule())
			return getASSIGNMENT_OPToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getLiteralRule())
			return getLiteralToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getNEWLINERule())
			return getNEWLINEToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * terminal ASSIGNMENT_OP:
	 * 	'=';
	 */
	protected String getASSIGNMENT_OPToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "=";
	}
	
	/**
	 * Literal:
	 * 	BooleanLiteral | StringLiteral | NumberLiteral;
	 */
	protected String getLiteralToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "true";
	}
	
	/**
	 * terminal NEWLINE:
	 * 	'\n';
	 */
	protected String getNEWLINEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "\n";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_BaseExpr_LeftParenthesisKeyword_0_0_a.equals(syntax))
				emit_BaseExpr_LeftParenthesisKeyword_0_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_BaseExpr_LeftParenthesisKeyword_0_0_p.equals(syntax))
				emit_BaseExpr_LeftParenthesisKeyword_0_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '!' expr=BaseExpr
	 *     (rule start) (ambiguity) Literal (rule start)
	 *     (rule start) (ambiguity) func=MathFunc
	 *     (rule start) (ambiguity) ref=[RefType|ID]
	 *     (rule start) (ambiguity) {Primary.left=}
	 *     (rule start) (ambiguity) {RefOrCall.target=}
	 *     (rule start) (ambiguity) {Rel.left=}
	 *     (rule start) (ambiguity) {Secondary.left=}
	 *     (rule start) (ambiguity) {Tertiary.left=}
	 */
	protected void emit_BaseExpr_LeftParenthesisKeyword_0_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) {Primary.left=}
	 *     (rule start) (ambiguity) {Rel.left=}
	 *     (rule start) (ambiguity) {Secondary.left=}
	 *     (rule start) (ambiguity) {Tertiary.left=}
	 */
	protected void emit_BaseExpr_LeftParenthesisKeyword_0_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
