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
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.mofgen.services.MGLangGrammarAccess;

@SuppressWarnings("all")
public class MGLangSyntacticSequencer extends AbstractSyntacticSequencer {

	protected MGLangGrammarAccess grammarAccess;
	protected AbstractElementAlias match_GenPatternCall___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q;
	protected AbstractElementAlias match_LiteralExpression___FullStopKeyword_1_3_0_INTTerminalRuleCall_1_3_1__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (MGLangGrammarAccess) access;
		match_GenPatternCall___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getGenPatternCallAccess().getLeftParenthesisKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getGenPatternCallAccess().getRightParenthesisKeyword_1_2()));
		match_LiteralExpression___FullStopKeyword_1_3_0_INTTerminalRuleCall_1_3_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getLiteralExpressionAccess().getFullStopKeyword_1_3_0()), new TokenAlias(false, false, grammarAccess.getLiteralExpressionAccess().getINTTerminalRuleCall_1_3_1()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (ruleCall.getRule() == grammarAccess.getASSIGNMENT_OPRule())
			return getASSIGNMENT_OPToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getINTRule())
			return getINTToken(semanticObject, ruleCall, node);
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
	 * terminal INT returns ecore::EInt: ('0'..'9')+;
	 */
	protected String getINTToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_GenPatternCall___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q.equals(syntax))
				emit_GenPatternCall___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_LiteralExpression___FullStopKeyword_1_3_0_INTTerminalRuleCall_1_3_1__q.equals(syntax))
				emit_LiteralExpression___FullStopKeyword_1_3_0_INTTerminalRuleCall_1_3_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     ('(' ')')?
	 *
	 * This ambiguous syntax occurs at:
	 *     calledPattern=[Pattern|ID] (ambiguity) (rule end)
	 */
	protected void emit_GenPatternCall___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('.' INT)?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) INT (ambiguity) (rule start)
	 *     value='-' INT (ambiguity) (rule end)
	 */
	protected void emit_LiteralExpression___FullStopKeyword_1_3_0_INTTerminalRuleCall_1_3_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
