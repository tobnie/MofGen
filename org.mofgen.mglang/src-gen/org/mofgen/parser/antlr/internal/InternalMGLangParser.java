package org.mofgen.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.mofgen.services.MGLangGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMGLangParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_ASSIGNMENT_OP", "RULE_NEWLINE", "RULE_TRUE", "RULE_FALSE", "RULE_DOUBLE", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'as'", "'config'", "'('", "')'", "'{'", "'}'", "'test'", "'pattern'", "','", "'return'", "'this'", "'.'", "'->'", "'gen'", "'var'", "'for'", "'in'", "'-'", "'switch'", "'case'", "':'", "'default'", "'when'", "'List'", "'['", "']'", "'Map'", "'!'", "'sqrt'", "'abs'", "'int'", "'char'", "'double'", "'String'", "'boolean'", "'>'", "'>='", "'=='", "'!='", "'<='", "'<'", "'+'", "'||'", "'%'", "'^'", "'*'", "'/'", "'&&'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=11;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=12;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int RULE_FALSE=9;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int RULE_NEWLINE=7;
    public static final int RULE_STRING=4;
    public static final int RULE_ASSIGNMENT_OP=6;
    public static final int RULE_SL_COMMENT=13;
    public static final int T__37=37;
    public static final int RULE_DOUBLE=10;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int RULE_TRUE=8;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=14;
    public static final int RULE_ANY_OTHER=15;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalMGLangParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMGLangParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMGLangParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMGLang.g"; }



     	private MGLangGrammarAccess grammarAccess;

        public InternalMGLangParser(TokenStream input, MGLangGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "MofgenFile";
       	}

       	@Override
       	protected MGLangGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleMofgenFile"
    // InternalMGLang.g:65:1: entryRuleMofgenFile returns [EObject current=null] : iv_ruleMofgenFile= ruleMofgenFile EOF ;
    public final EObject entryRuleMofgenFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMofgenFile = null;


        try {
            // InternalMGLang.g:65:51: (iv_ruleMofgenFile= ruleMofgenFile EOF )
            // InternalMGLang.g:66:2: iv_ruleMofgenFile= ruleMofgenFile EOF
            {
             newCompositeNode(grammarAccess.getMofgenFileRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMofgenFile=ruleMofgenFile();

            state._fsp--;

             current =iv_ruleMofgenFile; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMofgenFile"


    // $ANTLR start "ruleMofgenFile"
    // InternalMGLang.g:72:1: ruleMofgenFile returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_config_1_0= ruleConfig ) ) ( (lv_commands_2_0= ruleFileCommand ) )* ) ;
    public final EObject ruleMofgenFile() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_config_1_0 = null;

        EObject lv_commands_2_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:78:2: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_config_1_0= ruleConfig ) ) ( (lv_commands_2_0= ruleFileCommand ) )* ) )
            // InternalMGLang.g:79:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_config_1_0= ruleConfig ) ) ( (lv_commands_2_0= ruleFileCommand ) )* )
            {
            // InternalMGLang.g:79:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_config_1_0= ruleConfig ) ) ( (lv_commands_2_0= ruleFileCommand ) )* )
            // InternalMGLang.g:80:3: ( (lv_imports_0_0= ruleImport ) )* ( (lv_config_1_0= ruleConfig ) ) ( (lv_commands_2_0= ruleFileCommand ) )*
            {
            // InternalMGLang.g:80:3: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==16) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMGLang.g:81:4: (lv_imports_0_0= ruleImport )
            	    {
            	    // InternalMGLang.g:81:4: (lv_imports_0_0= ruleImport )
            	    // InternalMGLang.g:82:5: lv_imports_0_0= ruleImport
            	    {

            	    					newCompositeNode(grammarAccess.getMofgenFileAccess().getImportsImportParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_imports_0_0=ruleImport();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMofgenFileRule());
            	    					}
            	    					add(
            	    						current,
            	    						"imports",
            	    						lv_imports_0_0,
            	    						"org.mofgen.MGLang.Import");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalMGLang.g:99:3: ( (lv_config_1_0= ruleConfig ) )
            // InternalMGLang.g:100:4: (lv_config_1_0= ruleConfig )
            {
            // InternalMGLang.g:100:4: (lv_config_1_0= ruleConfig )
            // InternalMGLang.g:101:5: lv_config_1_0= ruleConfig
            {

            					newCompositeNode(grammarAccess.getMofgenFileAccess().getConfigConfigParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_config_1_0=ruleConfig();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMofgenFileRule());
            					}
            					set(
            						current,
            						"config",
            						lv_config_1_0,
            						"org.mofgen.MGLang.Config");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMGLang.g:118:3: ( (lv_commands_2_0= ruleFileCommand ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==24||LA2_0==30) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalMGLang.g:119:4: (lv_commands_2_0= ruleFileCommand )
            	    {
            	    // InternalMGLang.g:119:4: (lv_commands_2_0= ruleFileCommand )
            	    // InternalMGLang.g:120:5: lv_commands_2_0= ruleFileCommand
            	    {

            	    					newCompositeNode(grammarAccess.getMofgenFileAccess().getCommandsFileCommandParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_commands_2_0=ruleFileCommand();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMofgenFileRule());
            	    					}
            	    					add(
            	    						current,
            	    						"commands",
            	    						lv_commands_2_0,
            	    						"org.mofgen.MGLang.FileCommand");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMofgenFile"


    // $ANTLR start "entryRuleFileCommand"
    // InternalMGLang.g:141:1: entryRuleFileCommand returns [EObject current=null] : iv_ruleFileCommand= ruleFileCommand EOF ;
    public final EObject entryRuleFileCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFileCommand = null;


        try {
            // InternalMGLang.g:141:52: (iv_ruleFileCommand= ruleFileCommand EOF )
            // InternalMGLang.g:142:2: iv_ruleFileCommand= ruleFileCommand EOF
            {
             newCompositeNode(grammarAccess.getFileCommandRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFileCommand=ruleFileCommand();

            state._fsp--;

             current =iv_ruleFileCommand; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFileCommand"


    // $ANTLR start "ruleFileCommand"
    // InternalMGLang.g:148:1: ruleFileCommand returns [EObject current=null] : (this_Pattern_0= rulePattern | this_Generator_1= ruleGenerator ) ;
    public final EObject ruleFileCommand() throws RecognitionException {
        EObject current = null;

        EObject this_Pattern_0 = null;

        EObject this_Generator_1 = null;



        	enterRule();

        try {
            // InternalMGLang.g:154:2: ( (this_Pattern_0= rulePattern | this_Generator_1= ruleGenerator ) )
            // InternalMGLang.g:155:2: (this_Pattern_0= rulePattern | this_Generator_1= ruleGenerator )
            {
            // InternalMGLang.g:155:2: (this_Pattern_0= rulePattern | this_Generator_1= ruleGenerator )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==24) ) {
                alt3=1;
            }
            else if ( (LA3_0==30) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalMGLang.g:156:3: this_Pattern_0= rulePattern
                    {

                    			newCompositeNode(grammarAccess.getFileCommandAccess().getPatternParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Pattern_0=rulePattern();

                    state._fsp--;


                    			current = this_Pattern_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMGLang.g:165:3: this_Generator_1= ruleGenerator
                    {

                    			newCompositeNode(grammarAccess.getFileCommandAccess().getGeneratorParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Generator_1=ruleGenerator();

                    state._fsp--;


                    			current = this_Generator_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFileCommand"


    // $ANTLR start "entryRuleImport"
    // InternalMGLang.g:177:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalMGLang.g:177:47: (iv_ruleImport= ruleImport EOF )
            // InternalMGLang.g:178:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalMGLang.g:184:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_uri_1_0= RULE_STRING ) ) otherlv_2= 'as' ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_uri_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;


        	enterRule();

        try {
            // InternalMGLang.g:190:2: ( (otherlv_0= 'import' ( (lv_uri_1_0= RULE_STRING ) ) otherlv_2= 'as' ( (lv_name_3_0= RULE_ID ) ) ) )
            // InternalMGLang.g:191:2: (otherlv_0= 'import' ( (lv_uri_1_0= RULE_STRING ) ) otherlv_2= 'as' ( (lv_name_3_0= RULE_ID ) ) )
            {
            // InternalMGLang.g:191:2: (otherlv_0= 'import' ( (lv_uri_1_0= RULE_STRING ) ) otherlv_2= 'as' ( (lv_name_3_0= RULE_ID ) ) )
            // InternalMGLang.g:192:3: otherlv_0= 'import' ( (lv_uri_1_0= RULE_STRING ) ) otherlv_2= 'as' ( (lv_name_3_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalMGLang.g:196:3: ( (lv_uri_1_0= RULE_STRING ) )
            // InternalMGLang.g:197:4: (lv_uri_1_0= RULE_STRING )
            {
            // InternalMGLang.g:197:4: (lv_uri_1_0= RULE_STRING )
            // InternalMGLang.g:198:5: lv_uri_1_0= RULE_STRING
            {
            lv_uri_1_0=(Token)match(input,RULE_STRING,FOLLOW_6); 

            					newLeafNode(lv_uri_1_0, grammarAccess.getImportAccess().getUriSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportRule());
            					}
            					setWithLastConsumed(
            						current,
            						"uri",
            						lv_uri_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getImportAccess().getAsKeyword_2());
            		
            // InternalMGLang.g:218:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalMGLang.g:219:4: (lv_name_3_0= RULE_ID )
            {
            // InternalMGLang.g:219:4: (lv_name_3_0= RULE_ID )
            // InternalMGLang.g:220:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_3_0, grammarAccess.getImportAccess().getNameIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleConfig"
    // InternalMGLang.g:240:1: entryRuleConfig returns [EObject current=null] : iv_ruleConfig= ruleConfig EOF ;
    public final EObject entryRuleConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfig = null;


        try {
            // InternalMGLang.g:240:47: (iv_ruleConfig= ruleConfig EOF )
            // InternalMGLang.g:241:2: iv_ruleConfig= ruleConfig EOF
            {
             newCompositeNode(grammarAccess.getConfigRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConfig=ruleConfig();

            state._fsp--;

             current =iv_ruleConfig; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConfig"


    // $ANTLR start "ruleConfig"
    // InternalMGLang.g:247:1: ruleConfig returns [EObject current=null] : ( () otherlv_1= 'config' otherlv_2= '(' otherlv_3= ')' otherlv_4= '{' ( (lv_expressions_5_0= ruleConfigExpression ) )* otherlv_6= '}' ) ;
    public final EObject ruleConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_expressions_5_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:253:2: ( ( () otherlv_1= 'config' otherlv_2= '(' otherlv_3= ')' otherlv_4= '{' ( (lv_expressions_5_0= ruleConfigExpression ) )* otherlv_6= '}' ) )
            // InternalMGLang.g:254:2: ( () otherlv_1= 'config' otherlv_2= '(' otherlv_3= ')' otherlv_4= '{' ( (lv_expressions_5_0= ruleConfigExpression ) )* otherlv_6= '}' )
            {
            // InternalMGLang.g:254:2: ( () otherlv_1= 'config' otherlv_2= '(' otherlv_3= ')' otherlv_4= '{' ( (lv_expressions_5_0= ruleConfigExpression ) )* otherlv_6= '}' )
            // InternalMGLang.g:255:3: () otherlv_1= 'config' otherlv_2= '(' otherlv_3= ')' otherlv_4= '{' ( (lv_expressions_5_0= ruleConfigExpression ) )* otherlv_6= '}'
            {
            // InternalMGLang.g:255:3: ()
            // InternalMGLang.g:256:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getConfigAccess().getConfigAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,18,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getConfigAccess().getConfigKeyword_1());
            		
            otherlv_2=(Token)match(input,19,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getConfigAccess().getLeftParenthesisKeyword_2());
            		
            otherlv_3=(Token)match(input,20,FOLLOW_10); 

            			newLeafNode(otherlv_3, grammarAccess.getConfigAccess().getRightParenthesisKeyword_3());
            		
            otherlv_4=(Token)match(input,21,FOLLOW_11); 

            			newLeafNode(otherlv_4, grammarAccess.getConfigAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalMGLang.g:278:3: ( (lv_expressions_5_0= ruleConfigExpression ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==23) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalMGLang.g:279:4: (lv_expressions_5_0= ruleConfigExpression )
            	    {
            	    // InternalMGLang.g:279:4: (lv_expressions_5_0= ruleConfigExpression )
            	    // InternalMGLang.g:280:5: lv_expressions_5_0= ruleConfigExpression
            	    {

            	    					newCompositeNode(grammarAccess.getConfigAccess().getExpressionsConfigExpressionParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_11);
            	    lv_expressions_5_0=ruleConfigExpression();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConfigRule());
            	    					}
            	    					add(
            	    						current,
            	    						"expressions",
            	    						lv_expressions_5_0,
            	    						"org.mofgen.MGLang.ConfigExpression");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_6=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getConfigAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConfig"


    // $ANTLR start "entryRuleConfigExpression"
    // InternalMGLang.g:305:1: entryRuleConfigExpression returns [String current=null] : iv_ruleConfigExpression= ruleConfigExpression EOF ;
    public final String entryRuleConfigExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConfigExpression = null;


        try {
            // InternalMGLang.g:305:56: (iv_ruleConfigExpression= ruleConfigExpression EOF )
            // InternalMGLang.g:306:2: iv_ruleConfigExpression= ruleConfigExpression EOF
            {
             newCompositeNode(grammarAccess.getConfigExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConfigExpression=ruleConfigExpression();

            state._fsp--;

             current =iv_ruleConfigExpression.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConfigExpression"


    // $ANTLR start "ruleConfigExpression"
    // InternalMGLang.g:312:1: ruleConfigExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'test' ;
    public final AntlrDatatypeRuleToken ruleConfigExpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMGLang.g:318:2: (kw= 'test' )
            // InternalMGLang.g:319:2: kw= 'test'
            {
            kw=(Token)match(input,23,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getConfigExpressionAccess().getTestKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConfigExpression"


    // $ANTLR start "entryRulePattern"
    // InternalMGLang.g:327:1: entryRulePattern returns [EObject current=null] : iv_rulePattern= rulePattern EOF ;
    public final EObject entryRulePattern() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePattern = null;


        try {
            // InternalMGLang.g:327:48: (iv_rulePattern= rulePattern EOF )
            // InternalMGLang.g:328:2: iv_rulePattern= rulePattern EOF
            {
             newCompositeNode(grammarAccess.getPatternRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePattern=rulePattern();

            state._fsp--;

             current =iv_rulePattern; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePattern"


    // $ANTLR start "rulePattern"
    // InternalMGLang.g:334:1: rulePattern returns [EObject current=null] : (otherlv_0= 'pattern' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' ) otherlv_7= '{' ( (lv_commands_8_0= rulePatternCommand ) )* otherlv_9= '}' ( (lv_return_10_0= rulePatternReturn ) )? ) ;
    public final EObject rulePattern() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_parameters_3_0 = null;

        EObject lv_parameters_5_0 = null;

        EObject lv_commands_8_0 = null;

        EObject lv_return_10_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:340:2: ( (otherlv_0= 'pattern' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' ) otherlv_7= '{' ( (lv_commands_8_0= rulePatternCommand ) )* otherlv_9= '}' ( (lv_return_10_0= rulePatternReturn ) )? ) )
            // InternalMGLang.g:341:2: (otherlv_0= 'pattern' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' ) otherlv_7= '{' ( (lv_commands_8_0= rulePatternCommand ) )* otherlv_9= '}' ( (lv_return_10_0= rulePatternReturn ) )? )
            {
            // InternalMGLang.g:341:2: (otherlv_0= 'pattern' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' ) otherlv_7= '{' ( (lv_commands_8_0= rulePatternCommand ) )* otherlv_9= '}' ( (lv_return_10_0= rulePatternReturn ) )? )
            // InternalMGLang.g:342:3: otherlv_0= 'pattern' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' ) otherlv_7= '{' ( (lv_commands_8_0= rulePatternCommand ) )* otherlv_9= '}' ( (lv_return_10_0= rulePatternReturn ) )?
            {
            otherlv_0=(Token)match(input,24,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getPatternAccess().getPatternKeyword_0());
            		
            // InternalMGLang.g:346:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMGLang.g:347:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMGLang.g:347:4: (lv_name_1_0= RULE_ID )
            // InternalMGLang.g:348:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(lv_name_1_0, grammarAccess.getPatternAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPatternRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalMGLang.g:364:3: (otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' )
            // InternalMGLang.g:365:4: otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')'
            {
            otherlv_2=(Token)match(input,19,FOLLOW_12); 

            				newLeafNode(otherlv_2, grammarAccess.getPatternAccess().getLeftParenthesisKeyword_2_0());
            			
            // InternalMGLang.g:369:4: ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID||(LA6_0>=47 && LA6_0<=51)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalMGLang.g:370:5: ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )*
                    {
                    // InternalMGLang.g:370:5: ( (lv_parameters_3_0= ruleParameter ) )
                    // InternalMGLang.g:371:6: (lv_parameters_3_0= ruleParameter )
                    {
                    // InternalMGLang.g:371:6: (lv_parameters_3_0= ruleParameter )
                    // InternalMGLang.g:372:7: lv_parameters_3_0= ruleParameter
                    {

                    							newCompositeNode(grammarAccess.getPatternAccess().getParametersParameterParserRuleCall_2_1_0_0());
                    						
                    pushFollow(FOLLOW_13);
                    lv_parameters_3_0=ruleParameter();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getPatternRule());
                    							}
                    							add(
                    								current,
                    								"parameters",
                    								lv_parameters_3_0,
                    								"org.mofgen.MGLang.Parameter");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalMGLang.g:389:5: (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==25) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalMGLang.g:390:6: otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) )
                    	    {
                    	    otherlv_4=(Token)match(input,25,FOLLOW_14); 

                    	    						newLeafNode(otherlv_4, grammarAccess.getPatternAccess().getCommaKeyword_2_1_1_0());
                    	    					
                    	    // InternalMGLang.g:394:6: ( (lv_parameters_5_0= ruleParameter ) )
                    	    // InternalMGLang.g:395:7: (lv_parameters_5_0= ruleParameter )
                    	    {
                    	    // InternalMGLang.g:395:7: (lv_parameters_5_0= ruleParameter )
                    	    // InternalMGLang.g:396:8: lv_parameters_5_0= ruleParameter
                    	    {

                    	    								newCompositeNode(grammarAccess.getPatternAccess().getParametersParameterParserRuleCall_2_1_1_1_0());
                    	    							
                    	    pushFollow(FOLLOW_13);
                    	    lv_parameters_5_0=ruleParameter();

                    	    state._fsp--;


                    	    								if (current==null) {
                    	    									current = createModelElementForParent(grammarAccess.getPatternRule());
                    	    								}
                    	    								add(
                    	    									current,
                    	    									"parameters",
                    	    									lv_parameters_5_0,
                    	    									"org.mofgen.MGLang.Parameter");
                    	    								afterParserOrEnumRuleCall();
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,20,FOLLOW_10); 

            				newLeafNode(otherlv_6, grammarAccess.getPatternAccess().getRightParenthesisKeyword_2_2());
            			

            }

            otherlv_7=(Token)match(input,21,FOLLOW_15); 

            			newLeafNode(otherlv_7, grammarAccess.getPatternAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalMGLang.g:424:3: ( (lv_commands_8_0= rulePatternCommand ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID||LA7_0==35||LA7_0==40||LA7_0==43) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalMGLang.g:425:4: (lv_commands_8_0= rulePatternCommand )
            	    {
            	    // InternalMGLang.g:425:4: (lv_commands_8_0= rulePatternCommand )
            	    // InternalMGLang.g:426:5: lv_commands_8_0= rulePatternCommand
            	    {

            	    					newCompositeNode(grammarAccess.getPatternAccess().getCommandsPatternCommandParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_15);
            	    lv_commands_8_0=rulePatternCommand();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getPatternRule());
            	    					}
            	    					add(
            	    						current,
            	    						"commands",
            	    						lv_commands_8_0,
            	    						"org.mofgen.MGLang.PatternCommand");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_9=(Token)match(input,22,FOLLOW_16); 

            			newLeafNode(otherlv_9, grammarAccess.getPatternAccess().getRightCurlyBracketKeyword_5());
            		
            // InternalMGLang.g:447:3: ( (lv_return_10_0= rulePatternReturn ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==26) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalMGLang.g:448:4: (lv_return_10_0= rulePatternReturn )
                    {
                    // InternalMGLang.g:448:4: (lv_return_10_0= rulePatternReturn )
                    // InternalMGLang.g:449:5: lv_return_10_0= rulePatternReturn
                    {

                    					newCompositeNode(grammarAccess.getPatternAccess().getReturnPatternReturnParserRuleCall_6_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_return_10_0=rulePatternReturn();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPatternRule());
                    					}
                    					set(
                    						current,
                    						"return",
                    						lv_return_10_0,
                    						"org.mofgen.MGLang.PatternReturn");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePattern"


    // $ANTLR start "entryRulePatternCommand"
    // InternalMGLang.g:470:1: entryRulePatternCommand returns [EObject current=null] : iv_rulePatternCommand= rulePatternCommand EOF ;
    public final EObject entryRulePatternCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePatternCommand = null;


        try {
            // InternalMGLang.g:470:55: (iv_rulePatternCommand= rulePatternCommand EOF )
            // InternalMGLang.g:471:2: iv_rulePatternCommand= rulePatternCommand EOF
            {
             newCompositeNode(grammarAccess.getPatternCommandRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePatternCommand=rulePatternCommand();

            state._fsp--;

             current =iv_rulePatternCommand; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePatternCommand"


    // $ANTLR start "rulePatternCommand"
    // InternalMGLang.g:477:1: rulePatternCommand returns [EObject current=null] : (this_Collection_0= ruleCollection | this_Node_1= ruleNode | this_ParamManipulation_2= ruleParamManipulation | this_Switch_3= ruleSwitch ) ;
    public final EObject rulePatternCommand() throws RecognitionException {
        EObject current = null;

        EObject this_Collection_0 = null;

        EObject this_Node_1 = null;

        EObject this_ParamManipulation_2 = null;

        EObject this_Switch_3 = null;



        	enterRule();

        try {
            // InternalMGLang.g:483:2: ( (this_Collection_0= ruleCollection | this_Node_1= ruleNode | this_ParamManipulation_2= ruleParamManipulation | this_Switch_3= ruleSwitch ) )
            // InternalMGLang.g:484:2: (this_Collection_0= ruleCollection | this_Node_1= ruleNode | this_ParamManipulation_2= ruleParamManipulation | this_Switch_3= ruleSwitch )
            {
            // InternalMGLang.g:484:2: (this_Collection_0= ruleCollection | this_Node_1= ruleNode | this_ParamManipulation_2= ruleParamManipulation | this_Switch_3= ruleSwitch )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 40:
            case 43:
                {
                alt9=1;
                }
                break;
            case RULE_ID:
                {
                int LA9_2 = input.LA(2);

                if ( (LA9_2==21) ) {
                    alt9=3;
                }
                else if ( (LA9_2==RULE_ID||LA9_2==28) ) {
                    alt9=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 2, input);

                    throw nvae;
                }
                }
                break;
            case 35:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalMGLang.g:485:3: this_Collection_0= ruleCollection
                    {

                    			newCompositeNode(grammarAccess.getPatternCommandAccess().getCollectionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Collection_0=ruleCollection();

                    state._fsp--;


                    			current = this_Collection_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMGLang.g:494:3: this_Node_1= ruleNode
                    {

                    			newCompositeNode(grammarAccess.getPatternCommandAccess().getNodeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Node_1=ruleNode();

                    state._fsp--;


                    			current = this_Node_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMGLang.g:503:3: this_ParamManipulation_2= ruleParamManipulation
                    {

                    			newCompositeNode(grammarAccess.getPatternCommandAccess().getParamManipulationParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParamManipulation_2=ruleParamManipulation();

                    state._fsp--;


                    			current = this_ParamManipulation_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMGLang.g:512:3: this_Switch_3= ruleSwitch
                    {

                    			newCompositeNode(grammarAccess.getPatternCommandAccess().getSwitchParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Switch_3=ruleSwitch();

                    state._fsp--;


                    			current = this_Switch_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePatternCommand"


    // $ANTLR start "entryRulePatternReturn"
    // InternalMGLang.g:524:1: entryRulePatternReturn returns [EObject current=null] : iv_rulePatternReturn= rulePatternReturn EOF ;
    public final EObject entryRulePatternReturn() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePatternReturn = null;


        try {
            // InternalMGLang.g:524:54: (iv_rulePatternReturn= rulePatternReturn EOF )
            // InternalMGLang.g:525:2: iv_rulePatternReturn= rulePatternReturn EOF
            {
             newCompositeNode(grammarAccess.getPatternReturnRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePatternReturn=rulePatternReturn();

            state._fsp--;

             current =iv_rulePatternReturn; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePatternReturn"


    // $ANTLR start "rulePatternReturn"
    // InternalMGLang.g:531:1: rulePatternReturn returns [EObject current=null] : ( () otherlv_1= 'return' otherlv_2= 'this' (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject rulePatternReturn() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalMGLang.g:537:2: ( ( () otherlv_1= 'return' otherlv_2= 'this' (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalMGLang.g:538:2: ( () otherlv_1= 'return' otherlv_2= 'this' (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalMGLang.g:538:2: ( () otherlv_1= 'return' otherlv_2= 'this' (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? )
            // InternalMGLang.g:539:3: () otherlv_1= 'return' otherlv_2= 'this' (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )?
            {
            // InternalMGLang.g:539:3: ()
            // InternalMGLang.g:540:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPatternReturnAccess().getPatternReturnAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,26,FOLLOW_17); 

            			newLeafNode(otherlv_1, grammarAccess.getPatternReturnAccess().getReturnKeyword_1());
            		
            otherlv_2=(Token)match(input,27,FOLLOW_18); 

            			newLeafNode(otherlv_2, grammarAccess.getPatternReturnAccess().getThisKeyword_2());
            		
            // InternalMGLang.g:554:3: (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==28) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalMGLang.g:555:4: otherlv_3= '.' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,28,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getPatternReturnAccess().getFullStopKeyword_3_0());
                    			
                    // InternalMGLang.g:559:4: ( (otherlv_4= RULE_ID ) )
                    // InternalMGLang.g:560:5: (otherlv_4= RULE_ID )
                    {
                    // InternalMGLang.g:560:5: (otherlv_4= RULE_ID )
                    // InternalMGLang.g:561:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPatternReturnRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_4, grammarAccess.getPatternReturnAccess().getReturnValueNodeCrossReference_3_1_0());
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePatternReturn"


    // $ANTLR start "entryRuleParamManipulation"
    // InternalMGLang.g:577:1: entryRuleParamManipulation returns [EObject current=null] : iv_ruleParamManipulation= ruleParamManipulation EOF ;
    public final EObject entryRuleParamManipulation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParamManipulation = null;


        try {
            // InternalMGLang.g:577:58: (iv_ruleParamManipulation= ruleParamManipulation EOF )
            // InternalMGLang.g:578:2: iv_ruleParamManipulation= ruleParamManipulation EOF
            {
             newCompositeNode(grammarAccess.getParamManipulationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParamManipulation=ruleParamManipulation();

            state._fsp--;

             current =iv_ruleParamManipulation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParamManipulation"


    // $ANTLR start "ruleParamManipulation"
    // InternalMGLang.g:584:1: ruleParamManipulation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_content_1_0= ruleNodeContent ) ) ) ;
    public final EObject ruleParamManipulation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_content_1_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:590:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_content_1_0= ruleNodeContent ) ) ) )
            // InternalMGLang.g:591:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_content_1_0= ruleNodeContent ) ) )
            {
            // InternalMGLang.g:591:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_content_1_0= ruleNodeContent ) ) )
            // InternalMGLang.g:592:3: ( (otherlv_0= RULE_ID ) ) ( (lv_content_1_0= ruleNodeContent ) )
            {
            // InternalMGLang.g:592:3: ( (otherlv_0= RULE_ID ) )
            // InternalMGLang.g:593:4: (otherlv_0= RULE_ID )
            {
            // InternalMGLang.g:593:4: (otherlv_0= RULE_ID )
            // InternalMGLang.g:594:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParamManipulationRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(otherlv_0, grammarAccess.getParamManipulationAccess().getParamParameterNodeCrossReference_0_0());
            				

            }


            }

            // InternalMGLang.g:605:3: ( (lv_content_1_0= ruleNodeContent ) )
            // InternalMGLang.g:606:4: (lv_content_1_0= ruleNodeContent )
            {
            // InternalMGLang.g:606:4: (lv_content_1_0= ruleNodeContent )
            // InternalMGLang.g:607:5: lv_content_1_0= ruleNodeContent
            {

            					newCompositeNode(grammarAccess.getParamManipulationAccess().getContentNodeContentParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_content_1_0=ruleNodeContent();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParamManipulationRule());
            					}
            					set(
            						current,
            						"content",
            						lv_content_1_0,
            						"org.mofgen.MGLang.NodeContent");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParamManipulation"


    // $ANTLR start "entryRuleNode"
    // InternalMGLang.g:628:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // InternalMGLang.g:628:45: (iv_ruleNode= ruleNode EOF )
            // InternalMGLang.g:629:2: iv_ruleNode= ruleNode EOF
            {
             newCompositeNode(grammarAccess.getNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNode=ruleNode();

            state._fsp--;

             current =iv_ruleNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNode"


    // $ANTLR start "ruleNode"
    // InternalMGLang.g:635:1: ruleNode returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) ( (lv_name_3_0= RULE_ID ) ) ( ( (lv_createdBy_4_0= ruleNodeContent ) ) | (this_ASSIGNMENT_OP_5= RULE_ASSIGNMENT_OP ( (lv_createdBy_6_0= rulePatternCall ) ) ) )? ) ;
    public final EObject ruleNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token this_ASSIGNMENT_OP_5=null;
        EObject lv_createdBy_4_0 = null;

        EObject lv_createdBy_6_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:641:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) ( (lv_name_3_0= RULE_ID ) ) ( ( (lv_createdBy_4_0= ruleNodeContent ) ) | (this_ASSIGNMENT_OP_5= RULE_ASSIGNMENT_OP ( (lv_createdBy_6_0= rulePatternCall ) ) ) )? ) )
            // InternalMGLang.g:642:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) ( (lv_name_3_0= RULE_ID ) ) ( ( (lv_createdBy_4_0= ruleNodeContent ) ) | (this_ASSIGNMENT_OP_5= RULE_ASSIGNMENT_OP ( (lv_createdBy_6_0= rulePatternCall ) ) ) )? )
            {
            // InternalMGLang.g:642:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) ( (lv_name_3_0= RULE_ID ) ) ( ( (lv_createdBy_4_0= ruleNodeContent ) ) | (this_ASSIGNMENT_OP_5= RULE_ASSIGNMENT_OP ( (lv_createdBy_6_0= rulePatternCall ) ) ) )? )
            // InternalMGLang.g:643:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) ( (lv_name_3_0= RULE_ID ) ) ( ( (lv_createdBy_4_0= ruleNodeContent ) ) | (this_ASSIGNMENT_OP_5= RULE_ASSIGNMENT_OP ( (lv_createdBy_6_0= rulePatternCall ) ) ) )?
            {
            // InternalMGLang.g:643:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==28) ) {
                    alt11=1;
                }
            }
            switch (alt11) {
                case 1 :
                    // InternalMGLang.g:644:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.'
                    {
                    // InternalMGLang.g:644:4: ( (otherlv_0= RULE_ID ) )
                    // InternalMGLang.g:645:5: (otherlv_0= RULE_ID )
                    {
                    // InternalMGLang.g:645:5: (otherlv_0= RULE_ID )
                    // InternalMGLang.g:646:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNodeRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_19); 

                    						newLeafNode(otherlv_0, grammarAccess.getNodeAccess().getSrcModelImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,28,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getNodeAccess().getFullStopKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMGLang.g:662:3: ( (otherlv_2= RULE_ID ) )
            // InternalMGLang.g:663:4: (otherlv_2= RULE_ID )
            {
            // InternalMGLang.g:663:4: (otherlv_2= RULE_ID )
            // InternalMGLang.g:664:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNodeRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(otherlv_2, grammarAccess.getNodeAccess().getTypeEClassCrossReference_1_0());
            				

            }


            }

            // InternalMGLang.g:675:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalMGLang.g:676:4: (lv_name_3_0= RULE_ID )
            {
            // InternalMGLang.g:676:4: (lv_name_3_0= RULE_ID )
            // InternalMGLang.g:677:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_20); 

            					newLeafNode(lv_name_3_0, grammarAccess.getNodeAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalMGLang.g:693:3: ( ( (lv_createdBy_4_0= ruleNodeContent ) ) | (this_ASSIGNMENT_OP_5= RULE_ASSIGNMENT_OP ( (lv_createdBy_6_0= rulePatternCall ) ) ) )?
            int alt12=3;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==21) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_ASSIGNMENT_OP) ) {
                alt12=2;
            }
            switch (alt12) {
                case 1 :
                    // InternalMGLang.g:694:4: ( (lv_createdBy_4_0= ruleNodeContent ) )
                    {
                    // InternalMGLang.g:694:4: ( (lv_createdBy_4_0= ruleNodeContent ) )
                    // InternalMGLang.g:695:5: (lv_createdBy_4_0= ruleNodeContent )
                    {
                    // InternalMGLang.g:695:5: (lv_createdBy_4_0= ruleNodeContent )
                    // InternalMGLang.g:696:6: lv_createdBy_4_0= ruleNodeContent
                    {

                    						newCompositeNode(grammarAccess.getNodeAccess().getCreatedByNodeContentParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_createdBy_4_0=ruleNodeContent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNodeRule());
                    						}
                    						set(
                    							current,
                    							"createdBy",
                    							lv_createdBy_4_0,
                    							"org.mofgen.MGLang.NodeContent");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMGLang.g:714:4: (this_ASSIGNMENT_OP_5= RULE_ASSIGNMENT_OP ( (lv_createdBy_6_0= rulePatternCall ) ) )
                    {
                    // InternalMGLang.g:714:4: (this_ASSIGNMENT_OP_5= RULE_ASSIGNMENT_OP ( (lv_createdBy_6_0= rulePatternCall ) ) )
                    // InternalMGLang.g:715:5: this_ASSIGNMENT_OP_5= RULE_ASSIGNMENT_OP ( (lv_createdBy_6_0= rulePatternCall ) )
                    {
                    this_ASSIGNMENT_OP_5=(Token)match(input,RULE_ASSIGNMENT_OP,FOLLOW_7); 

                    					newLeafNode(this_ASSIGNMENT_OP_5, grammarAccess.getNodeAccess().getASSIGNMENT_OPTerminalRuleCall_3_1_0());
                    				
                    // InternalMGLang.g:719:5: ( (lv_createdBy_6_0= rulePatternCall ) )
                    // InternalMGLang.g:720:6: (lv_createdBy_6_0= rulePatternCall )
                    {
                    // InternalMGLang.g:720:6: (lv_createdBy_6_0= rulePatternCall )
                    // InternalMGLang.g:721:7: lv_createdBy_6_0= rulePatternCall
                    {

                    							newCompositeNode(grammarAccess.getNodeAccess().getCreatedByPatternCallParserRuleCall_3_1_1_0());
                    						
                    pushFollow(FOLLOW_2);
                    lv_createdBy_6_0=rulePatternCall();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getNodeRule());
                    							}
                    							set(
                    								current,
                    								"createdBy",
                    								lv_createdBy_6_0,
                    								"org.mofgen.MGLang.PatternCall");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNode"


    // $ANTLR start "entryRuleNodeContent"
    // InternalMGLang.g:744:1: entryRuleNodeContent returns [EObject current=null] : iv_ruleNodeContent= ruleNodeContent EOF ;
    public final EObject entryRuleNodeContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNodeContent = null;


        try {
            // InternalMGLang.g:744:52: (iv_ruleNodeContent= ruleNodeContent EOF )
            // InternalMGLang.g:745:2: iv_ruleNodeContent= ruleNodeContent EOF
            {
             newCompositeNode(grammarAccess.getNodeContentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNodeContent=ruleNodeContent();

            state._fsp--;

             current =iv_ruleNodeContent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNodeContent"


    // $ANTLR start "ruleNodeContent"
    // InternalMGLang.g:751:1: ruleNodeContent returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_refsAssigns_2_0= ruleNodeReferenceOrAssignmentOrControlFlow ) )* otherlv_3= '}' ) ;
    public final EObject ruleNodeContent() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_refsAssigns_2_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:757:2: ( ( () otherlv_1= '{' ( (lv_refsAssigns_2_0= ruleNodeReferenceOrAssignmentOrControlFlow ) )* otherlv_3= '}' ) )
            // InternalMGLang.g:758:2: ( () otherlv_1= '{' ( (lv_refsAssigns_2_0= ruleNodeReferenceOrAssignmentOrControlFlow ) )* otherlv_3= '}' )
            {
            // InternalMGLang.g:758:2: ( () otherlv_1= '{' ( (lv_refsAssigns_2_0= ruleNodeReferenceOrAssignmentOrControlFlow ) )* otherlv_3= '}' )
            // InternalMGLang.g:759:3: () otherlv_1= '{' ( (lv_refsAssigns_2_0= ruleNodeReferenceOrAssignmentOrControlFlow ) )* otherlv_3= '}'
            {
            // InternalMGLang.g:759:3: ()
            // InternalMGLang.g:760:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNodeContentAccess().getNodeContentAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,21,FOLLOW_15); 

            			newLeafNode(otherlv_1, grammarAccess.getNodeContentAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalMGLang.g:770:3: ( (lv_refsAssigns_2_0= ruleNodeReferenceOrAssignmentOrControlFlow ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID||LA13_0==35) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalMGLang.g:771:4: (lv_refsAssigns_2_0= ruleNodeReferenceOrAssignmentOrControlFlow )
            	    {
            	    // InternalMGLang.g:771:4: (lv_refsAssigns_2_0= ruleNodeReferenceOrAssignmentOrControlFlow )
            	    // InternalMGLang.g:772:5: lv_refsAssigns_2_0= ruleNodeReferenceOrAssignmentOrControlFlow
            	    {

            	    					newCompositeNode(grammarAccess.getNodeContentAccess().getRefsAssignsNodeReferenceOrAssignmentOrControlFlowParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_15);
            	    lv_refsAssigns_2_0=ruleNodeReferenceOrAssignmentOrControlFlow();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getNodeContentRule());
            	    					}
            	    					add(
            	    						current,
            	    						"refsAssigns",
            	    						lv_refsAssigns_2_0,
            	    						"org.mofgen.MGLang.NodeReferenceOrAssignmentOrControlFlow");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            otherlv_3=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getNodeContentAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNodeContent"


    // $ANTLR start "entryRulePatternCall"
    // InternalMGLang.g:797:1: entryRulePatternCall returns [EObject current=null] : iv_rulePatternCall= rulePatternCall EOF ;
    public final EObject entryRulePatternCall() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePatternCall = null;


        try {
            // InternalMGLang.g:797:52: (iv_rulePatternCall= rulePatternCall EOF )
            // InternalMGLang.g:798:2: iv_rulePatternCall= rulePatternCall EOF
            {
             newCompositeNode(grammarAccess.getPatternCallRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePatternCall=rulePatternCall();

            state._fsp--;

             current =iv_rulePatternCall; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePatternCall"


    // $ANTLR start "rulePatternCall"
    // InternalMGLang.g:804:1: rulePatternCall returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_params_2_0= ruleArithmeticExpression ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleArithmeticExpression ) ) )* )? otherlv_5= ')' ) ;
    public final EObject rulePatternCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_params_2_0 = null;

        EObject lv_params_4_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:810:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_params_2_0= ruleArithmeticExpression ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleArithmeticExpression ) ) )* )? otherlv_5= ')' ) )
            // InternalMGLang.g:811:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_params_2_0= ruleArithmeticExpression ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleArithmeticExpression ) ) )* )? otherlv_5= ')' )
            {
            // InternalMGLang.g:811:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_params_2_0= ruleArithmeticExpression ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleArithmeticExpression ) ) )* )? otherlv_5= ')' )
            // InternalMGLang.g:812:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_params_2_0= ruleArithmeticExpression ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleArithmeticExpression ) ) )* )? otherlv_5= ')'
            {
            // InternalMGLang.g:812:3: ( (otherlv_0= RULE_ID ) )
            // InternalMGLang.g:813:4: (otherlv_0= RULE_ID )
            {
            // InternalMGLang.g:813:4: (otherlv_0= RULE_ID )
            // InternalMGLang.g:814:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPatternCallRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(otherlv_0, grammarAccess.getPatternCallAccess().getCalledPatternCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,19,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getPatternCallAccess().getLeftParenthesisKeyword_1());
            		
            // InternalMGLang.g:829:3: ( ( (lv_params_2_0= ruleArithmeticExpression ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleArithmeticExpression ) ) )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=RULE_STRING && LA15_0<=RULE_ID)||(LA15_0>=RULE_TRUE && LA15_0<=RULE_DOUBLE)||LA15_0==19||(LA15_0>=44 && LA15_0<=46)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalMGLang.g:830:4: ( (lv_params_2_0= ruleArithmeticExpression ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleArithmeticExpression ) ) )*
                    {
                    // InternalMGLang.g:830:4: ( (lv_params_2_0= ruleArithmeticExpression ) )
                    // InternalMGLang.g:831:5: (lv_params_2_0= ruleArithmeticExpression )
                    {
                    // InternalMGLang.g:831:5: (lv_params_2_0= ruleArithmeticExpression )
                    // InternalMGLang.g:832:6: lv_params_2_0= ruleArithmeticExpression
                    {

                    						newCompositeNode(grammarAccess.getPatternCallAccess().getParamsArithmeticExpressionParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_params_2_0=ruleArithmeticExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPatternCallRule());
                    						}
                    						add(
                    							current,
                    							"params",
                    							lv_params_2_0,
                    							"org.mofgen.MGLang.ArithmeticExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMGLang.g:849:4: (otherlv_3= ',' ( (lv_params_4_0= ruleArithmeticExpression ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==25) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalMGLang.g:850:5: otherlv_3= ',' ( (lv_params_4_0= ruleArithmeticExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,25,FOLLOW_22); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getPatternCallAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalMGLang.g:854:5: ( (lv_params_4_0= ruleArithmeticExpression ) )
                    	    // InternalMGLang.g:855:6: (lv_params_4_0= ruleArithmeticExpression )
                    	    {
                    	    // InternalMGLang.g:855:6: (lv_params_4_0= ruleArithmeticExpression )
                    	    // InternalMGLang.g:856:7: lv_params_4_0= ruleArithmeticExpression
                    	    {

                    	    							newCompositeNode(grammarAccess.getPatternCallAccess().getParamsArithmeticExpressionParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_13);
                    	    lv_params_4_0=ruleArithmeticExpression();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getPatternCallRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"params",
                    	    								lv_params_4_0,
                    	    								"org.mofgen.MGLang.ArithmeticExpression");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getPatternCallAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePatternCall"


    // $ANTLR start "entryRuleNodeReferenceOrAssignmentOrControlFlow"
    // InternalMGLang.g:883:1: entryRuleNodeReferenceOrAssignmentOrControlFlow returns [EObject current=null] : iv_ruleNodeReferenceOrAssignmentOrControlFlow= ruleNodeReferenceOrAssignmentOrControlFlow EOF ;
    public final EObject entryRuleNodeReferenceOrAssignmentOrControlFlow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNodeReferenceOrAssignmentOrControlFlow = null;


        try {
            // InternalMGLang.g:883:79: (iv_ruleNodeReferenceOrAssignmentOrControlFlow= ruleNodeReferenceOrAssignmentOrControlFlow EOF )
            // InternalMGLang.g:884:2: iv_ruleNodeReferenceOrAssignmentOrControlFlow= ruleNodeReferenceOrAssignmentOrControlFlow EOF
            {
             newCompositeNode(grammarAccess.getNodeReferenceOrAssignmentOrControlFlowRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNodeReferenceOrAssignmentOrControlFlow=ruleNodeReferenceOrAssignmentOrControlFlow();

            state._fsp--;

             current =iv_ruleNodeReferenceOrAssignmentOrControlFlow; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNodeReferenceOrAssignmentOrControlFlow"


    // $ANTLR start "ruleNodeReferenceOrAssignmentOrControlFlow"
    // InternalMGLang.g:890:1: ruleNodeReferenceOrAssignmentOrControlFlow returns [EObject current=null] : (this_PatternNodeReference_0= rulePatternNodeReference | this_Assignment_1= ruleAssignment | this_Switch_2= ruleSwitch ) ;
    public final EObject ruleNodeReferenceOrAssignmentOrControlFlow() throws RecognitionException {
        EObject current = null;

        EObject this_PatternNodeReference_0 = null;

        EObject this_Assignment_1 = null;

        EObject this_Switch_2 = null;



        	enterRule();

        try {
            // InternalMGLang.g:896:2: ( (this_PatternNodeReference_0= rulePatternNodeReference | this_Assignment_1= ruleAssignment | this_Switch_2= ruleSwitch ) )
            // InternalMGLang.g:897:2: (this_PatternNodeReference_0= rulePatternNodeReference | this_Assignment_1= ruleAssignment | this_Switch_2= ruleSwitch )
            {
            // InternalMGLang.g:897:2: (this_PatternNodeReference_0= rulePatternNodeReference | this_Assignment_1= ruleAssignment | this_Switch_2= ruleSwitch )
            int alt16=3;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==29) ) {
                    alt16=1;
                }
                else if ( (LA16_1==RULE_ASSIGNMENT_OP) ) {
                    alt16=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA16_0==35) ) {
                alt16=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalMGLang.g:898:3: this_PatternNodeReference_0= rulePatternNodeReference
                    {

                    			newCompositeNode(grammarAccess.getNodeReferenceOrAssignmentOrControlFlowAccess().getPatternNodeReferenceParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PatternNodeReference_0=rulePatternNodeReference();

                    state._fsp--;


                    			current = this_PatternNodeReference_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMGLang.g:907:3: this_Assignment_1= ruleAssignment
                    {

                    			newCompositeNode(grammarAccess.getNodeReferenceOrAssignmentOrControlFlowAccess().getAssignmentParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Assignment_1=ruleAssignment();

                    state._fsp--;


                    			current = this_Assignment_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMGLang.g:916:3: this_Switch_2= ruleSwitch
                    {

                    			newCompositeNode(grammarAccess.getNodeReferenceOrAssignmentOrControlFlowAccess().getSwitchParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Switch_2=ruleSwitch();

                    state._fsp--;


                    			current = this_Switch_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNodeReferenceOrAssignmentOrControlFlow"


    // $ANTLR start "entryRulePatternNodeReference"
    // InternalMGLang.g:928:1: entryRulePatternNodeReference returns [EObject current=null] : iv_rulePatternNodeReference= rulePatternNodeReference EOF ;
    public final EObject entryRulePatternNodeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePatternNodeReference = null;


        try {
            // InternalMGLang.g:928:61: (iv_rulePatternNodeReference= rulePatternNodeReference EOF )
            // InternalMGLang.g:929:2: iv_rulePatternNodeReference= rulePatternNodeReference EOF
            {
             newCompositeNode(grammarAccess.getPatternNodeReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePatternNodeReference=rulePatternNodeReference();

            state._fsp--;

             current =iv_rulePatternNodeReference; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePatternNodeReference"


    // $ANTLR start "rulePatternNodeReference"
    // InternalMGLang.g:935:1: rulePatternNodeReference returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '->' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject rulePatternNodeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalMGLang.g:941:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '->' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalMGLang.g:942:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '->' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalMGLang.g:942:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '->' ( (otherlv_2= RULE_ID ) ) )
            // InternalMGLang.g:943:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '->' ( (otherlv_2= RULE_ID ) )
            {
            // InternalMGLang.g:943:3: ( (otherlv_0= RULE_ID ) )
            // InternalMGLang.g:944:4: (otherlv_0= RULE_ID )
            {
            // InternalMGLang.g:944:4: (otherlv_0= RULE_ID )
            // InternalMGLang.g:945:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPatternNodeReferenceRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_23); 

            					newLeafNode(otherlv_0, grammarAccess.getPatternNodeReferenceAccess().getTypeEReferenceCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,29,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getPatternNodeReferenceAccess().getHyphenMinusGreaterThanSignKeyword_1());
            		
            // InternalMGLang.g:960:3: ( (otherlv_2= RULE_ID ) )
            // InternalMGLang.g:961:4: (otherlv_2= RULE_ID )
            {
            // InternalMGLang.g:961:4: (otherlv_2= RULE_ID )
            // InternalMGLang.g:962:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPatternNodeReferenceRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_2, grammarAccess.getPatternNodeReferenceAccess().getTargetNodeCrossReference_2_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePatternNodeReference"


    // $ANTLR start "entryRuleAssignment"
    // InternalMGLang.g:977:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // InternalMGLang.g:977:51: (iv_ruleAssignment= ruleAssignment EOF )
            // InternalMGLang.g:978:2: iv_ruleAssignment= ruleAssignment EOF
            {
             newCompositeNode(grammarAccess.getAssignmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;

             current =iv_ruleAssignment; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // InternalMGLang.g:984:1: ruleAssignment returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) this_ASSIGNMENT_OP_1= RULE_ASSIGNMENT_OP ( (lv_value_2_0= ruleArithmeticExpression ) ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_ASSIGNMENT_OP_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:990:2: ( ( ( (otherlv_0= RULE_ID ) ) this_ASSIGNMENT_OP_1= RULE_ASSIGNMENT_OP ( (lv_value_2_0= ruleArithmeticExpression ) ) ) )
            // InternalMGLang.g:991:2: ( ( (otherlv_0= RULE_ID ) ) this_ASSIGNMENT_OP_1= RULE_ASSIGNMENT_OP ( (lv_value_2_0= ruleArithmeticExpression ) ) )
            {
            // InternalMGLang.g:991:2: ( ( (otherlv_0= RULE_ID ) ) this_ASSIGNMENT_OP_1= RULE_ASSIGNMENT_OP ( (lv_value_2_0= ruleArithmeticExpression ) ) )
            // InternalMGLang.g:992:3: ( (otherlv_0= RULE_ID ) ) this_ASSIGNMENT_OP_1= RULE_ASSIGNMENT_OP ( (lv_value_2_0= ruleArithmeticExpression ) )
            {
            // InternalMGLang.g:992:3: ( (otherlv_0= RULE_ID ) )
            // InternalMGLang.g:993:4: (otherlv_0= RULE_ID )
            {
            // InternalMGLang.g:993:4: (otherlv_0= RULE_ID )
            // InternalMGLang.g:994:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssignmentRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_24); 

            					newLeafNode(otherlv_0, grammarAccess.getAssignmentAccess().getTargetENamedElementCrossReference_0_0());
            				

            }


            }

            this_ASSIGNMENT_OP_1=(Token)match(input,RULE_ASSIGNMENT_OP,FOLLOW_22); 

            			newLeafNode(this_ASSIGNMENT_OP_1, grammarAccess.getAssignmentAccess().getASSIGNMENT_OPTerminalRuleCall_1());
            		
            // InternalMGLang.g:1009:3: ( (lv_value_2_0= ruleArithmeticExpression ) )
            // InternalMGLang.g:1010:4: (lv_value_2_0= ruleArithmeticExpression )
            {
            // InternalMGLang.g:1010:4: (lv_value_2_0= ruleArithmeticExpression )
            // InternalMGLang.g:1011:5: lv_value_2_0= ruleArithmeticExpression
            {

            					newCompositeNode(grammarAccess.getAssignmentAccess().getValueArithmeticExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleArithmeticExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAssignmentRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.mofgen.MGLang.ArithmeticExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleParameter"
    // InternalMGLang.g:1032:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalMGLang.g:1032:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalMGLang.g:1033:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalMGLang.g:1039:1: ruleParameter returns [EObject current=null] : (this_PrimitiveParameter_0= rulePrimitiveParameter | this_ParameterNode_1= ruleParameterNode ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveParameter_0 = null;

        EObject this_ParameterNode_1 = null;



        	enterRule();

        try {
            // InternalMGLang.g:1045:2: ( (this_PrimitiveParameter_0= rulePrimitiveParameter | this_ParameterNode_1= ruleParameterNode ) )
            // InternalMGLang.g:1046:2: (this_PrimitiveParameter_0= rulePrimitiveParameter | this_ParameterNode_1= ruleParameterNode )
            {
            // InternalMGLang.g:1046:2: (this_PrimitiveParameter_0= rulePrimitiveParameter | this_ParameterNode_1= ruleParameterNode )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=47 && LA17_0<=51)) ) {
                alt17=1;
            }
            else if ( (LA17_0==RULE_ID) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalMGLang.g:1047:3: this_PrimitiveParameter_0= rulePrimitiveParameter
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getPrimitiveParameterParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PrimitiveParameter_0=rulePrimitiveParameter();

                    state._fsp--;


                    			current = this_PrimitiveParameter_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMGLang.g:1056:3: this_ParameterNode_1= ruleParameterNode
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getParameterNodeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterNode_1=ruleParameterNode();

                    state._fsp--;


                    			current = this_ParameterNode_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRulePrimitiveParameter"
    // InternalMGLang.g:1068:1: entryRulePrimitiveParameter returns [EObject current=null] : iv_rulePrimitiveParameter= rulePrimitiveParameter EOF ;
    public final EObject entryRulePrimitiveParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveParameter = null;


        try {
            // InternalMGLang.g:1068:59: (iv_rulePrimitiveParameter= rulePrimitiveParameter EOF )
            // InternalMGLang.g:1069:2: iv_rulePrimitiveParameter= rulePrimitiveParameter EOF
            {
             newCompositeNode(grammarAccess.getPrimitiveParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimitiveParameter=rulePrimitiveParameter();

            state._fsp--;

             current =iv_rulePrimitiveParameter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimitiveParameter"


    // $ANTLR start "rulePrimitiveParameter"
    // InternalMGLang.g:1075:1: rulePrimitiveParameter returns [EObject current=null] : ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject rulePrimitiveParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Enumerator lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:1081:2: ( ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalMGLang.g:1082:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalMGLang.g:1082:2: ( ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // InternalMGLang.g:1083:3: ( (lv_type_0_0= rulePrimitiveType ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalMGLang.g:1083:3: ( (lv_type_0_0= rulePrimitiveType ) )
            // InternalMGLang.g:1084:4: (lv_type_0_0= rulePrimitiveType )
            {
            // InternalMGLang.g:1084:4: (lv_type_0_0= rulePrimitiveType )
            // InternalMGLang.g:1085:5: lv_type_0_0= rulePrimitiveType
            {

            					newCompositeNode(grammarAccess.getPrimitiveParameterAccess().getTypePrimitiveTypeEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
            lv_type_0_0=rulePrimitiveType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPrimitiveParameterRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_0_0,
            						"org.mofgen.MGLang.PrimitiveType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMGLang.g:1102:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMGLang.g:1103:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMGLang.g:1103:4: (lv_name_1_0= RULE_ID )
            // InternalMGLang.g:1104:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getPrimitiveParameterAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPrimitiveParameterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimitiveParameter"


    // $ANTLR start "entryRuleParameterNode"
    // InternalMGLang.g:1124:1: entryRuleParameterNode returns [EObject current=null] : iv_ruleParameterNode= ruleParameterNode EOF ;
    public final EObject entryRuleParameterNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterNode = null;


        try {
            // InternalMGLang.g:1124:54: (iv_ruleParameterNode= ruleParameterNode EOF )
            // InternalMGLang.g:1125:2: iv_ruleParameterNode= ruleParameterNode EOF
            {
             newCompositeNode(grammarAccess.getParameterNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterNode=ruleParameterNode();

            state._fsp--;

             current =iv_ruleParameterNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterNode"


    // $ANTLR start "ruleParameterNode"
    // InternalMGLang.g:1131:1: ruleParameterNode returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleParameterNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;


        	enterRule();

        try {
            // InternalMGLang.g:1137:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) ( (lv_name_3_0= RULE_ID ) ) ) )
            // InternalMGLang.g:1138:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) ( (lv_name_3_0= RULE_ID ) ) )
            {
            // InternalMGLang.g:1138:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) ( (lv_name_3_0= RULE_ID ) ) )
            // InternalMGLang.g:1139:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (otherlv_2= RULE_ID ) ) ( (lv_name_3_0= RULE_ID ) )
            {
            // InternalMGLang.g:1139:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==28) ) {
                    alt18=1;
                }
            }
            switch (alt18) {
                case 1 :
                    // InternalMGLang.g:1140:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.'
                    {
                    // InternalMGLang.g:1140:4: ( (otherlv_0= RULE_ID ) )
                    // InternalMGLang.g:1141:5: (otherlv_0= RULE_ID )
                    {
                    // InternalMGLang.g:1141:5: (otherlv_0= RULE_ID )
                    // InternalMGLang.g:1142:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getParameterNodeRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_19); 

                    						newLeafNode(otherlv_0, grammarAccess.getParameterNodeAccess().getSrcModelImportCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,28,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getParameterNodeAccess().getFullStopKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMGLang.g:1158:3: ( (otherlv_2= RULE_ID ) )
            // InternalMGLang.g:1159:4: (otherlv_2= RULE_ID )
            {
            // InternalMGLang.g:1159:4: (otherlv_2= RULE_ID )
            // InternalMGLang.g:1160:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterNodeRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(otherlv_2, grammarAccess.getParameterNodeAccess().getTypeEClassifierCrossReference_1_0());
            				

            }


            }

            // InternalMGLang.g:1171:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalMGLang.g:1172:4: (lv_name_3_0= RULE_ID )
            {
            // InternalMGLang.g:1172:4: (lv_name_3_0= RULE_ID )
            // InternalMGLang.g:1173:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_3_0, grammarAccess.getParameterNodeAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterNodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterNode"


    // $ANTLR start "entryRuleRefOrCall"
    // InternalMGLang.g:1193:1: entryRuleRefOrCall returns [EObject current=null] : iv_ruleRefOrCall= ruleRefOrCall EOF ;
    public final EObject entryRuleRefOrCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefOrCall = null;


        try {
            // InternalMGLang.g:1193:50: (iv_ruleRefOrCall= ruleRefOrCall EOF )
            // InternalMGLang.g:1194:2: iv_ruleRefOrCall= ruleRefOrCall EOF
            {
             newCompositeNode(grammarAccess.getRefOrCallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRefOrCall=ruleRefOrCall();

            state._fsp--;

             current =iv_ruleRefOrCall; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRefOrCall"


    // $ANTLR start "ruleRefOrCall"
    // InternalMGLang.g:1200:1: ruleRefOrCall returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '(' ( (lv_params_5_0= ruleRefParams ) )? ( (lv_bracesSet_6_0= ')' ) ) )? )* ) ;
    public final EObject ruleRefOrCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_bracesSet_6_0=null;
        EObject lv_params_5_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:1206:2: ( ( ( (otherlv_0= RULE_ID ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '(' ( (lv_params_5_0= ruleRefParams ) )? ( (lv_bracesSet_6_0= ')' ) ) )? )* ) )
            // InternalMGLang.g:1207:2: ( ( (otherlv_0= RULE_ID ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '(' ( (lv_params_5_0= ruleRefParams ) )? ( (lv_bracesSet_6_0= ')' ) ) )? )* )
            {
            // InternalMGLang.g:1207:2: ( ( (otherlv_0= RULE_ID ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '(' ( (lv_params_5_0= ruleRefParams ) )? ( (lv_bracesSet_6_0= ')' ) ) )? )* )
            // InternalMGLang.g:1208:3: ( (otherlv_0= RULE_ID ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '(' ( (lv_params_5_0= ruleRefParams ) )? ( (lv_bracesSet_6_0= ')' ) ) )? )*
            {
            // InternalMGLang.g:1208:3: ( (otherlv_0= RULE_ID ) )
            // InternalMGLang.g:1209:4: (otherlv_0= RULE_ID )
            {
            // InternalMGLang.g:1209:4: (otherlv_0= RULE_ID )
            // InternalMGLang.g:1210:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRefOrCallRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_18); 

            					newLeafNode(otherlv_0, grammarAccess.getRefOrCallAccess().getRefEObjectCrossReference_0_0());
            				

            }


            }

            // InternalMGLang.g:1221:3: ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '(' ( (lv_params_5_0= ruleRefParams ) )? ( (lv_bracesSet_6_0= ')' ) ) )? )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==28) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalMGLang.g:1222:4: () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '(' ( (lv_params_5_0= ruleRefParams ) )? ( (lv_bracesSet_6_0= ')' ) ) )?
            	    {
            	    // InternalMGLang.g:1222:4: ()
            	    // InternalMGLang.g:1223:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getRefOrCallAccess().getRefOrCallTargetAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,28,FOLLOW_7); 

            	    				newLeafNode(otherlv_2, grammarAccess.getRefOrCallAccess().getFullStopKeyword_1_1());
            	    			
            	    // InternalMGLang.g:1233:4: ( (otherlv_3= RULE_ID ) )
            	    // InternalMGLang.g:1234:5: (otherlv_3= RULE_ID )
            	    {
            	    // InternalMGLang.g:1234:5: (otherlv_3= RULE_ID )
            	    // InternalMGLang.g:1235:6: otherlv_3= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getRefOrCallRule());
            	    						}
            	    					
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_25); 

            	    						newLeafNode(otherlv_3, grammarAccess.getRefOrCallAccess().getRefENamedElementCrossReference_1_2_0());
            	    					

            	    }


            	    }

            	    // InternalMGLang.g:1246:4: (otherlv_4= '(' ( (lv_params_5_0= ruleRefParams ) )? ( (lv_bracesSet_6_0= ')' ) ) )?
            	    int alt20=2;
            	    int LA20_0 = input.LA(1);

            	    if ( (LA20_0==19) ) {
            	        alt20=1;
            	    }
            	    switch (alt20) {
            	        case 1 :
            	            // InternalMGLang.g:1247:5: otherlv_4= '(' ( (lv_params_5_0= ruleRefParams ) )? ( (lv_bracesSet_6_0= ')' ) )
            	            {
            	            otherlv_4=(Token)match(input,19,FOLLOW_21); 

            	            					newLeafNode(otherlv_4, grammarAccess.getRefOrCallAccess().getLeftParenthesisKeyword_1_3_0());
            	            				
            	            // InternalMGLang.g:1251:5: ( (lv_params_5_0= ruleRefParams ) )?
            	            int alt19=2;
            	            int LA19_0 = input.LA(1);

            	            if ( ((LA19_0>=RULE_STRING && LA19_0<=RULE_ID)||(LA19_0>=RULE_TRUE && LA19_0<=RULE_DOUBLE)||LA19_0==19||(LA19_0>=44 && LA19_0<=46)) ) {
            	                alt19=1;
            	            }
            	            switch (alt19) {
            	                case 1 :
            	                    // InternalMGLang.g:1252:6: (lv_params_5_0= ruleRefParams )
            	                    {
            	                    // InternalMGLang.g:1252:6: (lv_params_5_0= ruleRefParams )
            	                    // InternalMGLang.g:1253:7: lv_params_5_0= ruleRefParams
            	                    {

            	                    							newCompositeNode(grammarAccess.getRefOrCallAccess().getParamsRefParamsParserRuleCall_1_3_1_0());
            	                    						
            	                    pushFollow(FOLLOW_9);
            	                    lv_params_5_0=ruleRefParams();

            	                    state._fsp--;


            	                    							if (current==null) {
            	                    								current = createModelElementForParent(grammarAccess.getRefOrCallRule());
            	                    							}
            	                    							set(
            	                    								current,
            	                    								"params",
            	                    								lv_params_5_0,
            	                    								"org.mofgen.MGLang.RefParams");
            	                    							afterParserOrEnumRuleCall();
            	                    						

            	                    }


            	                    }
            	                    break;

            	            }

            	            // InternalMGLang.g:1270:5: ( (lv_bracesSet_6_0= ')' ) )
            	            // InternalMGLang.g:1271:6: (lv_bracesSet_6_0= ')' )
            	            {
            	            // InternalMGLang.g:1271:6: (lv_bracesSet_6_0= ')' )
            	            // InternalMGLang.g:1272:7: lv_bracesSet_6_0= ')'
            	            {
            	            lv_bracesSet_6_0=(Token)match(input,20,FOLLOW_18); 

            	            							newLeafNode(lv_bracesSet_6_0, grammarAccess.getRefOrCallAccess().getBracesSetRightParenthesisKeyword_1_3_2_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getRefOrCallRule());
            	            							}
            	            							setWithLastConsumed(current, "bracesSet", true, ")");
            	            						

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRefOrCall"


    // $ANTLR start "entryRuleRefParams"
    // InternalMGLang.g:1290:1: entryRuleRefParams returns [EObject current=null] : iv_ruleRefParams= ruleRefParams EOF ;
    public final EObject entryRuleRefParams() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefParams = null;


        try {
            // InternalMGLang.g:1290:50: (iv_ruleRefParams= ruleRefParams EOF )
            // InternalMGLang.g:1291:2: iv_ruleRefParams= ruleRefParams EOF
            {
             newCompositeNode(grammarAccess.getRefParamsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRefParams=ruleRefParams();

            state._fsp--;

             current =iv_ruleRefParams; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRefParams"


    // $ANTLR start "ruleRefParams"
    // InternalMGLang.g:1297:1: ruleRefParams returns [EObject current=null] : ( ( (lv_params_0_0= ruleArithmeticExpression ) ) (otherlv_1= ',' ( (lv_params_2_0= ruleArithmeticExpression ) ) )* ) ;
    public final EObject ruleRefParams() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_params_0_0 = null;

        EObject lv_params_2_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:1303:2: ( ( ( (lv_params_0_0= ruleArithmeticExpression ) ) (otherlv_1= ',' ( (lv_params_2_0= ruleArithmeticExpression ) ) )* ) )
            // InternalMGLang.g:1304:2: ( ( (lv_params_0_0= ruleArithmeticExpression ) ) (otherlv_1= ',' ( (lv_params_2_0= ruleArithmeticExpression ) ) )* )
            {
            // InternalMGLang.g:1304:2: ( ( (lv_params_0_0= ruleArithmeticExpression ) ) (otherlv_1= ',' ( (lv_params_2_0= ruleArithmeticExpression ) ) )* )
            // InternalMGLang.g:1305:3: ( (lv_params_0_0= ruleArithmeticExpression ) ) (otherlv_1= ',' ( (lv_params_2_0= ruleArithmeticExpression ) ) )*
            {
            // InternalMGLang.g:1305:3: ( (lv_params_0_0= ruleArithmeticExpression ) )
            // InternalMGLang.g:1306:4: (lv_params_0_0= ruleArithmeticExpression )
            {
            // InternalMGLang.g:1306:4: (lv_params_0_0= ruleArithmeticExpression )
            // InternalMGLang.g:1307:5: lv_params_0_0= ruleArithmeticExpression
            {

            					newCompositeNode(grammarAccess.getRefParamsAccess().getParamsArithmeticExpressionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_26);
            lv_params_0_0=ruleArithmeticExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRefParamsRule());
            					}
            					add(
            						current,
            						"params",
            						lv_params_0_0,
            						"org.mofgen.MGLang.ArithmeticExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMGLang.g:1324:3: (otherlv_1= ',' ( (lv_params_2_0= ruleArithmeticExpression ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==25) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalMGLang.g:1325:4: otherlv_1= ',' ( (lv_params_2_0= ruleArithmeticExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,25,FOLLOW_22); 

            	    				newLeafNode(otherlv_1, grammarAccess.getRefParamsAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalMGLang.g:1329:4: ( (lv_params_2_0= ruleArithmeticExpression ) )
            	    // InternalMGLang.g:1330:5: (lv_params_2_0= ruleArithmeticExpression )
            	    {
            	    // InternalMGLang.g:1330:5: (lv_params_2_0= ruleArithmeticExpression )
            	    // InternalMGLang.g:1331:6: lv_params_2_0= ruleArithmeticExpression
            	    {

            	    						newCompositeNode(grammarAccess.getRefParamsAccess().getParamsArithmeticExpressionParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_26);
            	    lv_params_2_0=ruleArithmeticExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getRefParamsRule());
            	    						}
            	    						add(
            	    							current,
            	    							"params",
            	    							lv_params_2_0,
            	    							"org.mofgen.MGLang.ArithmeticExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRefParams"


    // $ANTLR start "entryRuleGenerator"
    // InternalMGLang.g:1353:1: entryRuleGenerator returns [EObject current=null] : iv_ruleGenerator= ruleGenerator EOF ;
    public final EObject entryRuleGenerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenerator = null;


        try {
            // InternalMGLang.g:1353:50: (iv_ruleGenerator= ruleGenerator EOF )
            // InternalMGLang.g:1354:2: iv_ruleGenerator= ruleGenerator EOF
            {
             newCompositeNode(grammarAccess.getGeneratorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGenerator=ruleGenerator();

            state._fsp--;

             current =iv_ruleGenerator; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGenerator"


    // $ANTLR start "ruleGenerator"
    // InternalMGLang.g:1360:1: ruleGenerator returns [EObject current=null] : ( () otherlv_1= 'gen' otherlv_2= '(' ( (lv_params_3_0= ruleParameter ) )* otherlv_4= ')' otherlv_5= '{' ( (lv_commands_6_0= ruleGeneratorExpression ) )* otherlv_7= '}' ) ;
    public final EObject ruleGenerator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_params_3_0 = null;

        EObject lv_commands_6_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:1366:2: ( ( () otherlv_1= 'gen' otherlv_2= '(' ( (lv_params_3_0= ruleParameter ) )* otherlv_4= ')' otherlv_5= '{' ( (lv_commands_6_0= ruleGeneratorExpression ) )* otherlv_7= '}' ) )
            // InternalMGLang.g:1367:2: ( () otherlv_1= 'gen' otherlv_2= '(' ( (lv_params_3_0= ruleParameter ) )* otherlv_4= ')' otherlv_5= '{' ( (lv_commands_6_0= ruleGeneratorExpression ) )* otherlv_7= '}' )
            {
            // InternalMGLang.g:1367:2: ( () otherlv_1= 'gen' otherlv_2= '(' ( (lv_params_3_0= ruleParameter ) )* otherlv_4= ')' otherlv_5= '{' ( (lv_commands_6_0= ruleGeneratorExpression ) )* otherlv_7= '}' )
            // InternalMGLang.g:1368:3: () otherlv_1= 'gen' otherlv_2= '(' ( (lv_params_3_0= ruleParameter ) )* otherlv_4= ')' otherlv_5= '{' ( (lv_commands_6_0= ruleGeneratorExpression ) )* otherlv_7= '}'
            {
            // InternalMGLang.g:1368:3: ()
            // InternalMGLang.g:1369:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getGeneratorAccess().getGeneratorAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,30,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getGeneratorAccess().getGenKeyword_1());
            		
            otherlv_2=(Token)match(input,19,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getGeneratorAccess().getLeftParenthesisKeyword_2());
            		
            // InternalMGLang.g:1383:3: ( (lv_params_3_0= ruleParameter ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_ID||(LA23_0>=47 && LA23_0<=51)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalMGLang.g:1384:4: (lv_params_3_0= ruleParameter )
            	    {
            	    // InternalMGLang.g:1384:4: (lv_params_3_0= ruleParameter )
            	    // InternalMGLang.g:1385:5: lv_params_3_0= ruleParameter
            	    {

            	    					newCompositeNode(grammarAccess.getGeneratorAccess().getParamsParameterParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_12);
            	    lv_params_3_0=ruleParameter();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getGeneratorRule());
            	    					}
            	    					add(
            	    						current,
            	    						"params",
            	    						lv_params_3_0,
            	    						"org.mofgen.MGLang.Parameter");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            otherlv_4=(Token)match(input,20,FOLLOW_10); 

            			newLeafNode(otherlv_4, grammarAccess.getGeneratorAccess().getRightParenthesisKeyword_4());
            		
            otherlv_5=(Token)match(input,21,FOLLOW_27); 

            			newLeafNode(otherlv_5, grammarAccess.getGeneratorAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalMGLang.g:1410:3: ( (lv_commands_6_0= ruleGeneratorExpression ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_ID||(LA24_0>=31 && LA24_0<=32)||LA24_0==35||LA24_0==40||LA24_0==43) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalMGLang.g:1411:4: (lv_commands_6_0= ruleGeneratorExpression )
            	    {
            	    // InternalMGLang.g:1411:4: (lv_commands_6_0= ruleGeneratorExpression )
            	    // InternalMGLang.g:1412:5: lv_commands_6_0= ruleGeneratorExpression
            	    {

            	    					newCompositeNode(grammarAccess.getGeneratorAccess().getCommandsGeneratorExpressionParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_27);
            	    lv_commands_6_0=ruleGeneratorExpression();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getGeneratorRule());
            	    					}
            	    					add(
            	    						current,
            	    						"commands",
            	    						lv_commands_6_0,
            	    						"org.mofgen.MGLang.GeneratorExpression");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            otherlv_7=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getGeneratorAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGenerator"


    // $ANTLR start "entryRuleGeneratorExpression"
    // InternalMGLang.g:1437:1: entryRuleGeneratorExpression returns [EObject current=null] : iv_ruleGeneratorExpression= ruleGeneratorExpression EOF ;
    public final EObject entryRuleGeneratorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratorExpression = null;


        try {
            // InternalMGLang.g:1437:60: (iv_ruleGeneratorExpression= ruleGeneratorExpression EOF )
            // InternalMGLang.g:1438:2: iv_ruleGeneratorExpression= ruleGeneratorExpression EOF
            {
             newCompositeNode(grammarAccess.getGeneratorExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGeneratorExpression=ruleGeneratorExpression();

            state._fsp--;

             current =iv_ruleGeneratorExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGeneratorExpression"


    // $ANTLR start "ruleGeneratorExpression"
    // InternalMGLang.g:1444:1: ruleGeneratorExpression returns [EObject current=null] : (this_ForStatement_0= ruleForStatement | this_Switch_1= ruleSwitch | this_Collection_2= ruleCollection | this_PatternCall_3= rulePatternCall | this_PatternVariable_4= rulePatternVariable | this_Variable_5= ruleVariable ) ;
    public final EObject ruleGeneratorExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ForStatement_0 = null;

        EObject this_Switch_1 = null;

        EObject this_Collection_2 = null;

        EObject this_PatternCall_3 = null;

        EObject this_PatternVariable_4 = null;

        EObject this_Variable_5 = null;



        	enterRule();

        try {
            // InternalMGLang.g:1450:2: ( (this_ForStatement_0= ruleForStatement | this_Switch_1= ruleSwitch | this_Collection_2= ruleCollection | this_PatternCall_3= rulePatternCall | this_PatternVariable_4= rulePatternVariable | this_Variable_5= ruleVariable ) )
            // InternalMGLang.g:1451:2: (this_ForStatement_0= ruleForStatement | this_Switch_1= ruleSwitch | this_Collection_2= ruleCollection | this_PatternCall_3= rulePatternCall | this_PatternVariable_4= rulePatternVariable | this_Variable_5= ruleVariable )
            {
            // InternalMGLang.g:1451:2: (this_ForStatement_0= ruleForStatement | this_Switch_1= ruleSwitch | this_Collection_2= ruleCollection | this_PatternCall_3= rulePatternCall | this_PatternVariable_4= rulePatternVariable | this_Variable_5= ruleVariable )
            int alt25=6;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt25=1;
                }
                break;
            case 35:
                {
                alt25=2;
                }
                break;
            case 40:
            case 43:
                {
                alt25=3;
                }
                break;
            case RULE_ID:
                {
                int LA25_4 = input.LA(2);

                if ( (LA25_4==19) ) {
                    alt25=4;
                }
                else if ( (LA25_4==RULE_ID) ) {
                    alt25=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 4, input);

                    throw nvae;
                }
                }
                break;
            case 31:
                {
                alt25=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalMGLang.g:1452:3: this_ForStatement_0= ruleForStatement
                    {

                    			newCompositeNode(grammarAccess.getGeneratorExpressionAccess().getForStatementParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ForStatement_0=ruleForStatement();

                    state._fsp--;


                    			current = this_ForStatement_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMGLang.g:1461:3: this_Switch_1= ruleSwitch
                    {

                    			newCompositeNode(grammarAccess.getGeneratorExpressionAccess().getSwitchParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Switch_1=ruleSwitch();

                    state._fsp--;


                    			current = this_Switch_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMGLang.g:1470:3: this_Collection_2= ruleCollection
                    {

                    			newCompositeNode(grammarAccess.getGeneratorExpressionAccess().getCollectionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Collection_2=ruleCollection();

                    state._fsp--;


                    			current = this_Collection_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMGLang.g:1479:3: this_PatternCall_3= rulePatternCall
                    {

                    			newCompositeNode(grammarAccess.getGeneratorExpressionAccess().getPatternCallParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_PatternCall_3=rulePatternCall();

                    state._fsp--;


                    			current = this_PatternCall_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalMGLang.g:1488:3: this_PatternVariable_4= rulePatternVariable
                    {

                    			newCompositeNode(grammarAccess.getGeneratorExpressionAccess().getPatternVariableParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_PatternVariable_4=rulePatternVariable();

                    state._fsp--;


                    			current = this_PatternVariable_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalMGLang.g:1497:3: this_Variable_5= ruleVariable
                    {

                    			newCompositeNode(grammarAccess.getGeneratorExpressionAccess().getVariableParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_Variable_5=ruleVariable();

                    state._fsp--;


                    			current = this_Variable_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGeneratorExpression"


    // $ANTLR start "entryRulePatternVariable"
    // InternalMGLang.g:1509:1: entryRulePatternVariable returns [EObject current=null] : iv_rulePatternVariable= rulePatternVariable EOF ;
    public final EObject entryRulePatternVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePatternVariable = null;


        try {
            // InternalMGLang.g:1509:56: (iv_rulePatternVariable= rulePatternVariable EOF )
            // InternalMGLang.g:1510:2: iv_rulePatternVariable= rulePatternVariable EOF
            {
             newCompositeNode(grammarAccess.getPatternVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePatternVariable=rulePatternVariable();

            state._fsp--;

             current =iv_rulePatternVariable; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePatternVariable"


    // $ANTLR start "rulePatternVariable"
    // InternalMGLang.g:1516:1: rulePatternVariable returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) this_ASSIGNMENT_OP_2= RULE_ASSIGNMENT_OP ( (lv_patternCall_3_0= rulePatternCall ) ) ) ;
    public final EObject rulePatternVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token this_ASSIGNMENT_OP_2=null;
        EObject lv_patternCall_3_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:1522:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) this_ASSIGNMENT_OP_2= RULE_ASSIGNMENT_OP ( (lv_patternCall_3_0= rulePatternCall ) ) ) )
            // InternalMGLang.g:1523:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) this_ASSIGNMENT_OP_2= RULE_ASSIGNMENT_OP ( (lv_patternCall_3_0= rulePatternCall ) ) )
            {
            // InternalMGLang.g:1523:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) this_ASSIGNMENT_OP_2= RULE_ASSIGNMENT_OP ( (lv_patternCall_3_0= rulePatternCall ) ) )
            // InternalMGLang.g:1524:3: ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) this_ASSIGNMENT_OP_2= RULE_ASSIGNMENT_OP ( (lv_patternCall_3_0= rulePatternCall ) )
            {
            // InternalMGLang.g:1524:3: ( (otherlv_0= RULE_ID ) )
            // InternalMGLang.g:1525:4: (otherlv_0= RULE_ID )
            {
            // InternalMGLang.g:1525:4: (otherlv_0= RULE_ID )
            // InternalMGLang.g:1526:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPatternVariableRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(otherlv_0, grammarAccess.getPatternVariableAccess().getTypePatternCrossReference_0_0());
            				

            }


            }

            // InternalMGLang.g:1537:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMGLang.g:1538:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMGLang.g:1538:4: (lv_name_1_0= RULE_ID )
            // InternalMGLang.g:1539:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_24); 

            					newLeafNode(lv_name_1_0, grammarAccess.getPatternVariableAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPatternVariableRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            this_ASSIGNMENT_OP_2=(Token)match(input,RULE_ASSIGNMENT_OP,FOLLOW_7); 

            			newLeafNode(this_ASSIGNMENT_OP_2, grammarAccess.getPatternVariableAccess().getASSIGNMENT_OPTerminalRuleCall_2());
            		
            // InternalMGLang.g:1559:3: ( (lv_patternCall_3_0= rulePatternCall ) )
            // InternalMGLang.g:1560:4: (lv_patternCall_3_0= rulePatternCall )
            {
            // InternalMGLang.g:1560:4: (lv_patternCall_3_0= rulePatternCall )
            // InternalMGLang.g:1561:5: lv_patternCall_3_0= rulePatternCall
            {

            					newCompositeNode(grammarAccess.getPatternVariableAccess().getPatternCallPatternCallParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_patternCall_3_0=rulePatternCall();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPatternVariableRule());
            					}
            					set(
            						current,
            						"patternCall",
            						lv_patternCall_3_0,
            						"org.mofgen.MGLang.PatternCall");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePatternVariable"


    // $ANTLR start "entryRuleVariable"
    // InternalMGLang.g:1582:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalMGLang.g:1582:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalMGLang.g:1583:2: iv_ruleVariable= ruleVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalMGLang.g:1589:1: ruleVariable returns [EObject current=null] : (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) this_ASSIGNMENT_OP_2= RULE_ASSIGNMENT_OP ( (lv_value_3_0= ruleArithmeticExpression ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token this_ASSIGNMENT_OP_2=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:1595:2: ( (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) this_ASSIGNMENT_OP_2= RULE_ASSIGNMENT_OP ( (lv_value_3_0= ruleArithmeticExpression ) ) ) )
            // InternalMGLang.g:1596:2: (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) this_ASSIGNMENT_OP_2= RULE_ASSIGNMENT_OP ( (lv_value_3_0= ruleArithmeticExpression ) ) )
            {
            // InternalMGLang.g:1596:2: (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) this_ASSIGNMENT_OP_2= RULE_ASSIGNMENT_OP ( (lv_value_3_0= ruleArithmeticExpression ) ) )
            // InternalMGLang.g:1597:3: otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) this_ASSIGNMENT_OP_2= RULE_ASSIGNMENT_OP ( (lv_value_3_0= ruleArithmeticExpression ) )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getVariableAccess().getVarKeyword_0());
            		
            // InternalMGLang.g:1601:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMGLang.g:1602:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMGLang.g:1602:4: (lv_name_1_0= RULE_ID )
            // InternalMGLang.g:1603:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_24); 

            					newLeafNode(lv_name_1_0, grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVariableRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            this_ASSIGNMENT_OP_2=(Token)match(input,RULE_ASSIGNMENT_OP,FOLLOW_22); 

            			newLeafNode(this_ASSIGNMENT_OP_2, grammarAccess.getVariableAccess().getASSIGNMENT_OPTerminalRuleCall_2());
            		
            // InternalMGLang.g:1623:3: ( (lv_value_3_0= ruleArithmeticExpression ) )
            // InternalMGLang.g:1624:4: (lv_value_3_0= ruleArithmeticExpression )
            {
            // InternalMGLang.g:1624:4: (lv_value_3_0= ruleArithmeticExpression )
            // InternalMGLang.g:1625:5: lv_value_3_0= ruleArithmeticExpression
            {

            					newCompositeNode(grammarAccess.getVariableAccess().getValueArithmeticExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_3_0=ruleArithmeticExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVariableRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_3_0,
            						"org.mofgen.MGLang.ArithmeticExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleForStatement"
    // InternalMGLang.g:1646:1: entryRuleForStatement returns [EObject current=null] : iv_ruleForStatement= ruleForStatement EOF ;
    public final EObject entryRuleForStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForStatement = null;


        try {
            // InternalMGLang.g:1646:53: (iv_ruleForStatement= ruleForStatement EOF )
            // InternalMGLang.g:1647:2: iv_ruleForStatement= ruleForStatement EOF
            {
             newCompositeNode(grammarAccess.getForStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleForStatement=ruleForStatement();

            state._fsp--;

             current =iv_ruleForStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForStatement"


    // $ANTLR start "ruleForStatement"
    // InternalMGLang.g:1653:1: ruleForStatement returns [EObject current=null] : (otherlv_0= 'for' ( (lv_head_1_0= ruleForHead ) ) otherlv_2= '{' ( (lv_body_3_0= ruleForBody ) ) otherlv_4= '}' ) ;
    public final EObject ruleForStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_head_1_0 = null;

        EObject lv_body_3_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:1659:2: ( (otherlv_0= 'for' ( (lv_head_1_0= ruleForHead ) ) otherlv_2= '{' ( (lv_body_3_0= ruleForBody ) ) otherlv_4= '}' ) )
            // InternalMGLang.g:1660:2: (otherlv_0= 'for' ( (lv_head_1_0= ruleForHead ) ) otherlv_2= '{' ( (lv_body_3_0= ruleForBody ) ) otherlv_4= '}' )
            {
            // InternalMGLang.g:1660:2: (otherlv_0= 'for' ( (lv_head_1_0= ruleForHead ) ) otherlv_2= '{' ( (lv_body_3_0= ruleForBody ) ) otherlv_4= '}' )
            // InternalMGLang.g:1661:3: otherlv_0= 'for' ( (lv_head_1_0= ruleForHead ) ) otherlv_2= '{' ( (lv_body_3_0= ruleForBody ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getForStatementAccess().getForKeyword_0());
            		
            // InternalMGLang.g:1665:3: ( (lv_head_1_0= ruleForHead ) )
            // InternalMGLang.g:1666:4: (lv_head_1_0= ruleForHead )
            {
            // InternalMGLang.g:1666:4: (lv_head_1_0= ruleForHead )
            // InternalMGLang.g:1667:5: lv_head_1_0= ruleForHead
            {

            					newCompositeNode(grammarAccess.getForStatementAccess().getHeadForHeadParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_10);
            lv_head_1_0=ruleForHead();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForStatementRule());
            					}
            					set(
            						current,
            						"head",
            						lv_head_1_0,
            						"org.mofgen.MGLang.ForHead");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,21,FOLLOW_27); 

            			newLeafNode(otherlv_2, grammarAccess.getForStatementAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMGLang.g:1688:3: ( (lv_body_3_0= ruleForBody ) )
            // InternalMGLang.g:1689:4: (lv_body_3_0= ruleForBody )
            {
            // InternalMGLang.g:1689:4: (lv_body_3_0= ruleForBody )
            // InternalMGLang.g:1690:5: lv_body_3_0= ruleForBody
            {

            					newCompositeNode(grammarAccess.getForStatementAccess().getBodyForBodyParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_28);
            lv_body_3_0=ruleForBody();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForStatementRule());
            					}
            					set(
            						current,
            						"body",
            						lv_body_3_0,
            						"org.mofgen.MGLang.ForBody");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getForStatementAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForStatement"


    // $ANTLR start "entryRuleForHead"
    // InternalMGLang.g:1715:1: entryRuleForHead returns [EObject current=null] : iv_ruleForHead= ruleForHead EOF ;
    public final EObject entryRuleForHead() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForHead = null;


        try {
            // InternalMGLang.g:1715:48: (iv_ruleForHead= ruleForHead EOF )
            // InternalMGLang.g:1716:2: iv_ruleForHead= ruleForHead EOF
            {
             newCompositeNode(grammarAccess.getForHeadRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleForHead=ruleForHead();

            state._fsp--;

             current =iv_ruleForHead; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForHead"


    // $ANTLR start "ruleForHead"
    // InternalMGLang.g:1722:1: ruleForHead returns [EObject current=null] : (this_GeneralForHead_0= ruleGeneralForHead | this_ForEachHead_1= ruleForEachHead ) ;
    public final EObject ruleForHead() throws RecognitionException {
        EObject current = null;

        EObject this_GeneralForHead_0 = null;

        EObject this_ForEachHead_1 = null;



        	enterRule();

        try {
            // InternalMGLang.g:1728:2: ( (this_GeneralForHead_0= ruleGeneralForHead | this_ForEachHead_1= ruleForEachHead ) )
            // InternalMGLang.g:1729:2: (this_GeneralForHead_0= ruleGeneralForHead | this_ForEachHead_1= ruleForEachHead )
            {
            // InternalMGLang.g:1729:2: (this_GeneralForHead_0= ruleGeneralForHead | this_ForEachHead_1= ruleForEachHead )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID) ) {
                int LA26_1 = input.LA(2);

                if ( (LA26_1==33) ) {
                    alt26=1;
                }
                else if ( (LA26_1==28||LA26_1==34) ) {
                    alt26=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalMGLang.g:1730:3: this_GeneralForHead_0= ruleGeneralForHead
                    {

                    			newCompositeNode(grammarAccess.getForHeadAccess().getGeneralForHeadParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_GeneralForHead_0=ruleGeneralForHead();

                    state._fsp--;


                    			current = this_GeneralForHead_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMGLang.g:1739:3: this_ForEachHead_1= ruleForEachHead
                    {

                    			newCompositeNode(grammarAccess.getForHeadAccess().getForEachHeadParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ForEachHead_1=ruleForEachHead();

                    state._fsp--;


                    			current = this_ForEachHead_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForHead"


    // $ANTLR start "entryRuleGeneralForHead"
    // InternalMGLang.g:1751:1: entryRuleGeneralForHead returns [EObject current=null] : iv_ruleGeneralForHead= ruleGeneralForHead EOF ;
    public final EObject entryRuleGeneralForHead() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneralForHead = null;


        try {
            // InternalMGLang.g:1751:55: (iv_ruleGeneralForHead= ruleGeneralForHead EOF )
            // InternalMGLang.g:1752:2: iv_ruleGeneralForHead= ruleGeneralForHead EOF
            {
             newCompositeNode(grammarAccess.getGeneralForHeadRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGeneralForHead=ruleGeneralForHead();

            state._fsp--;

             current =iv_ruleGeneralForHead; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGeneralForHead"


    // $ANTLR start "ruleGeneralForHead"
    // InternalMGLang.g:1758:1: ruleGeneralForHead returns [EObject current=null] : ( ( (lv_iteratorVar_0_0= RULE_ID ) ) otherlv_1= 'in' ( (lv_range_2_0= ruleForRange ) ) ) ;
    public final EObject ruleGeneralForHead() throws RecognitionException {
        EObject current = null;

        Token lv_iteratorVar_0_0=null;
        Token otherlv_1=null;
        EObject lv_range_2_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:1764:2: ( ( ( (lv_iteratorVar_0_0= RULE_ID ) ) otherlv_1= 'in' ( (lv_range_2_0= ruleForRange ) ) ) )
            // InternalMGLang.g:1765:2: ( ( (lv_iteratorVar_0_0= RULE_ID ) ) otherlv_1= 'in' ( (lv_range_2_0= ruleForRange ) ) )
            {
            // InternalMGLang.g:1765:2: ( ( (lv_iteratorVar_0_0= RULE_ID ) ) otherlv_1= 'in' ( (lv_range_2_0= ruleForRange ) ) )
            // InternalMGLang.g:1766:3: ( (lv_iteratorVar_0_0= RULE_ID ) ) otherlv_1= 'in' ( (lv_range_2_0= ruleForRange ) )
            {
            // InternalMGLang.g:1766:3: ( (lv_iteratorVar_0_0= RULE_ID ) )
            // InternalMGLang.g:1767:4: (lv_iteratorVar_0_0= RULE_ID )
            {
            // InternalMGLang.g:1767:4: (lv_iteratorVar_0_0= RULE_ID )
            // InternalMGLang.g:1768:5: lv_iteratorVar_0_0= RULE_ID
            {
            lv_iteratorVar_0_0=(Token)match(input,RULE_ID,FOLLOW_29); 

            					newLeafNode(lv_iteratorVar_0_0, grammarAccess.getGeneralForHeadAccess().getIteratorVarIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGeneralForHeadRule());
            					}
            					setWithLastConsumed(
            						current,
            						"iteratorVar",
            						lv_iteratorVar_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,33,FOLLOW_22); 

            			newLeafNode(otherlv_1, grammarAccess.getGeneralForHeadAccess().getInKeyword_1());
            		
            // InternalMGLang.g:1788:3: ( (lv_range_2_0= ruleForRange ) )
            // InternalMGLang.g:1789:4: (lv_range_2_0= ruleForRange )
            {
            // InternalMGLang.g:1789:4: (lv_range_2_0= ruleForRange )
            // InternalMGLang.g:1790:5: lv_range_2_0= ruleForRange
            {

            					newCompositeNode(grammarAccess.getGeneralForHeadAccess().getRangeForRangeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_range_2_0=ruleForRange();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGeneralForHeadRule());
            					}
            					set(
            						current,
            						"range",
            						lv_range_2_0,
            						"org.mofgen.MGLang.ForRange");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGeneralForHead"


    // $ANTLR start "entryRuleForEachHead"
    // InternalMGLang.g:1811:1: entryRuleForEachHead returns [EObject current=null] : iv_ruleForEachHead= ruleForEachHead EOF ;
    public final EObject entryRuleForEachHead() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForEachHead = null;


        try {
            // InternalMGLang.g:1811:52: (iv_ruleForEachHead= ruleForEachHead EOF )
            // InternalMGLang.g:1812:2: iv_ruleForEachHead= ruleForEachHead EOF
            {
             newCompositeNode(grammarAccess.getForEachHeadRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleForEachHead=ruleForEachHead();

            state._fsp--;

             current =iv_ruleForEachHead; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForEachHead"


    // $ANTLR start "ruleForEachHead"
    // InternalMGLang.g:1818:1: ruleForEachHead returns [EObject current=null] : ( ( (lv_src_0_0= ruleRefOrCall ) ) otherlv_1= '-' ( (otherlv_2= RULE_ID ) ) otherlv_3= '->' ( (lv_iteratorVar_4_0= RULE_ID ) ) ) ;
    public final EObject ruleForEachHead() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_iteratorVar_4_0=null;
        EObject lv_src_0_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:1824:2: ( ( ( (lv_src_0_0= ruleRefOrCall ) ) otherlv_1= '-' ( (otherlv_2= RULE_ID ) ) otherlv_3= '->' ( (lv_iteratorVar_4_0= RULE_ID ) ) ) )
            // InternalMGLang.g:1825:2: ( ( (lv_src_0_0= ruleRefOrCall ) ) otherlv_1= '-' ( (otherlv_2= RULE_ID ) ) otherlv_3= '->' ( (lv_iteratorVar_4_0= RULE_ID ) ) )
            {
            // InternalMGLang.g:1825:2: ( ( (lv_src_0_0= ruleRefOrCall ) ) otherlv_1= '-' ( (otherlv_2= RULE_ID ) ) otherlv_3= '->' ( (lv_iteratorVar_4_0= RULE_ID ) ) )
            // InternalMGLang.g:1826:3: ( (lv_src_0_0= ruleRefOrCall ) ) otherlv_1= '-' ( (otherlv_2= RULE_ID ) ) otherlv_3= '->' ( (lv_iteratorVar_4_0= RULE_ID ) )
            {
            // InternalMGLang.g:1826:3: ( (lv_src_0_0= ruleRefOrCall ) )
            // InternalMGLang.g:1827:4: (lv_src_0_0= ruleRefOrCall )
            {
            // InternalMGLang.g:1827:4: (lv_src_0_0= ruleRefOrCall )
            // InternalMGLang.g:1828:5: lv_src_0_0= ruleRefOrCall
            {

            					newCompositeNode(grammarAccess.getForEachHeadAccess().getSrcRefOrCallParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_30);
            lv_src_0_0=ruleRefOrCall();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForEachHeadRule());
            					}
            					set(
            						current,
            						"src",
            						lv_src_0_0,
            						"org.mofgen.MGLang.RefOrCall");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,34,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getForEachHeadAccess().getHyphenMinusKeyword_1());
            		
            // InternalMGLang.g:1849:3: ( (otherlv_2= RULE_ID ) )
            // InternalMGLang.g:1850:4: (otherlv_2= RULE_ID )
            {
            // InternalMGLang.g:1850:4: (otherlv_2= RULE_ID )
            // InternalMGLang.g:1851:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getForEachHeadRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_23); 

            					newLeafNode(otherlv_2, grammarAccess.getForEachHeadAccess().getErefEReferenceCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,29,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getForEachHeadAccess().getHyphenMinusGreaterThanSignKeyword_3());
            		
            // InternalMGLang.g:1866:3: ( (lv_iteratorVar_4_0= RULE_ID ) )
            // InternalMGLang.g:1867:4: (lv_iteratorVar_4_0= RULE_ID )
            {
            // InternalMGLang.g:1867:4: (lv_iteratorVar_4_0= RULE_ID )
            // InternalMGLang.g:1868:5: lv_iteratorVar_4_0= RULE_ID
            {
            lv_iteratorVar_4_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_iteratorVar_4_0, grammarAccess.getForEachHeadAccess().getIteratorVarIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getForEachHeadRule());
            					}
            					setWithLastConsumed(
            						current,
            						"iteratorVar",
            						lv_iteratorVar_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForEachHead"


    // $ANTLR start "entryRuleForBody"
    // InternalMGLang.g:1888:1: entryRuleForBody returns [EObject current=null] : iv_ruleForBody= ruleForBody EOF ;
    public final EObject entryRuleForBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForBody = null;


        try {
            // InternalMGLang.g:1888:48: (iv_ruleForBody= ruleForBody EOF )
            // InternalMGLang.g:1889:2: iv_ruleForBody= ruleForBody EOF
            {
             newCompositeNode(grammarAccess.getForBodyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleForBody=ruleForBody();

            state._fsp--;

             current =iv_ruleForBody; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForBody"


    // $ANTLR start "ruleForBody"
    // InternalMGLang.g:1895:1: ruleForBody returns [EObject current=null] : ( () ( (lv_commands_1_0= ruleGeneratorExpression ) )* ) ;
    public final EObject ruleForBody() throws RecognitionException {
        EObject current = null;

        EObject lv_commands_1_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:1901:2: ( ( () ( (lv_commands_1_0= ruleGeneratorExpression ) )* ) )
            // InternalMGLang.g:1902:2: ( () ( (lv_commands_1_0= ruleGeneratorExpression ) )* )
            {
            // InternalMGLang.g:1902:2: ( () ( (lv_commands_1_0= ruleGeneratorExpression ) )* )
            // InternalMGLang.g:1903:3: () ( (lv_commands_1_0= ruleGeneratorExpression ) )*
            {
            // InternalMGLang.g:1903:3: ()
            // InternalMGLang.g:1904:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getForBodyAccess().getForBodyAction_0(),
            					current);
            			

            }

            // InternalMGLang.g:1910:3: ( (lv_commands_1_0= ruleGeneratorExpression ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_ID||(LA27_0>=31 && LA27_0<=32)||LA27_0==35||LA27_0==40||LA27_0==43) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalMGLang.g:1911:4: (lv_commands_1_0= ruleGeneratorExpression )
            	    {
            	    // InternalMGLang.g:1911:4: (lv_commands_1_0= ruleGeneratorExpression )
            	    // InternalMGLang.g:1912:5: lv_commands_1_0= ruleGeneratorExpression
            	    {

            	    					newCompositeNode(grammarAccess.getForBodyAccess().getCommandsGeneratorExpressionParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_31);
            	    lv_commands_1_0=ruleGeneratorExpression();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getForBodyRule());
            	    					}
            	    					add(
            	    						current,
            	    						"commands",
            	    						lv_commands_1_0,
            	    						"org.mofgen.MGLang.GeneratorExpression");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForBody"


    // $ANTLR start "entryRuleSwitchExpression"
    // InternalMGLang.g:1933:1: entryRuleSwitchExpression returns [EObject current=null] : iv_ruleSwitchExpression= ruleSwitchExpression EOF ;
    public final EObject entryRuleSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchExpression = null;


        try {
            // InternalMGLang.g:1933:57: (iv_ruleSwitchExpression= ruleSwitchExpression EOF )
            // InternalMGLang.g:1934:2: iv_ruleSwitchExpression= ruleSwitchExpression EOF
            {
             newCompositeNode(grammarAccess.getSwitchExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSwitchExpression=ruleSwitchExpression();

            state._fsp--;

             current =iv_ruleSwitchExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSwitchExpression"


    // $ANTLR start "ruleSwitchExpression"
    // InternalMGLang.g:1940:1: ruleSwitchExpression returns [EObject current=null] : (this_ForStatement_0= ruleForStatement | this_Collection_1= ruleCollection | this_PatternCall_2= rulePatternCall | this_PatternVariable_3= rulePatternVariable | this_NodeReferenceOrAssignmentOrControlFlow_4= ruleNodeReferenceOrAssignmentOrControlFlow ) ;
    public final EObject ruleSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ForStatement_0 = null;

        EObject this_Collection_1 = null;

        EObject this_PatternCall_2 = null;

        EObject this_PatternVariable_3 = null;

        EObject this_NodeReferenceOrAssignmentOrControlFlow_4 = null;



        	enterRule();

        try {
            // InternalMGLang.g:1946:2: ( (this_ForStatement_0= ruleForStatement | this_Collection_1= ruleCollection | this_PatternCall_2= rulePatternCall | this_PatternVariable_3= rulePatternVariable | this_NodeReferenceOrAssignmentOrControlFlow_4= ruleNodeReferenceOrAssignmentOrControlFlow ) )
            // InternalMGLang.g:1947:2: (this_ForStatement_0= ruleForStatement | this_Collection_1= ruleCollection | this_PatternCall_2= rulePatternCall | this_PatternVariable_3= rulePatternVariable | this_NodeReferenceOrAssignmentOrControlFlow_4= ruleNodeReferenceOrAssignmentOrControlFlow )
            {
            // InternalMGLang.g:1947:2: (this_ForStatement_0= ruleForStatement | this_Collection_1= ruleCollection | this_PatternCall_2= rulePatternCall | this_PatternVariable_3= rulePatternVariable | this_NodeReferenceOrAssignmentOrControlFlow_4= ruleNodeReferenceOrAssignmentOrControlFlow )
            int alt28=5;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt28=1;
                }
                break;
            case 40:
            case 43:
                {
                alt28=2;
                }
                break;
            case RULE_ID:
                {
                switch ( input.LA(2) ) {
                case RULE_ASSIGNMENT_OP:
                case 29:
                    {
                    alt28=5;
                    }
                    break;
                case RULE_ID:
                    {
                    alt28=4;
                    }
                    break;
                case 19:
                    {
                    alt28=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 3, input);

                    throw nvae;
                }

                }
                break;
            case 35:
                {
                alt28=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalMGLang.g:1948:3: this_ForStatement_0= ruleForStatement
                    {

                    			newCompositeNode(grammarAccess.getSwitchExpressionAccess().getForStatementParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ForStatement_0=ruleForStatement();

                    state._fsp--;


                    			current = this_ForStatement_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMGLang.g:1957:3: this_Collection_1= ruleCollection
                    {

                    			newCompositeNode(grammarAccess.getSwitchExpressionAccess().getCollectionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Collection_1=ruleCollection();

                    state._fsp--;


                    			current = this_Collection_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMGLang.g:1966:3: this_PatternCall_2= rulePatternCall
                    {

                    			newCompositeNode(grammarAccess.getSwitchExpressionAccess().getPatternCallParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_PatternCall_2=rulePatternCall();

                    state._fsp--;


                    			current = this_PatternCall_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMGLang.g:1975:3: this_PatternVariable_3= rulePatternVariable
                    {

                    			newCompositeNode(grammarAccess.getSwitchExpressionAccess().getPatternVariableParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_PatternVariable_3=rulePatternVariable();

                    state._fsp--;


                    			current = this_PatternVariable_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalMGLang.g:1984:3: this_NodeReferenceOrAssignmentOrControlFlow_4= ruleNodeReferenceOrAssignmentOrControlFlow
                    {

                    			newCompositeNode(grammarAccess.getSwitchExpressionAccess().getNodeReferenceOrAssignmentOrControlFlowParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_NodeReferenceOrAssignmentOrControlFlow_4=ruleNodeReferenceOrAssignmentOrControlFlow();

                    state._fsp--;


                    			current = this_NodeReferenceOrAssignmentOrControlFlow_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSwitchExpression"


    // $ANTLR start "entryRuleSwitch"
    // InternalMGLang.g:1996:1: entryRuleSwitch returns [EObject current=null] : iv_ruleSwitch= ruleSwitch EOF ;
    public final EObject entryRuleSwitch() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitch = null;


        try {
            // InternalMGLang.g:1996:47: (iv_ruleSwitch= ruleSwitch EOF )
            // InternalMGLang.g:1997:2: iv_ruleSwitch= ruleSwitch EOF
            {
             newCompositeNode(grammarAccess.getSwitchRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSwitch=ruleSwitch();

            state._fsp--;

             current =iv_ruleSwitch; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSwitch"


    // $ANTLR start "ruleSwitch"
    // InternalMGLang.g:2003:1: ruleSwitch returns [EObject current=null] : (this_IfElseSwitch_0= ruleIfElseSwitch | this_SwitchCase_1= ruleSwitchCase ) ;
    public final EObject ruleSwitch() throws RecognitionException {
        EObject current = null;

        EObject this_IfElseSwitch_0 = null;

        EObject this_SwitchCase_1 = null;



        	enterRule();

        try {
            // InternalMGLang.g:2009:2: ( (this_IfElseSwitch_0= ruleIfElseSwitch | this_SwitchCase_1= ruleSwitchCase ) )
            // InternalMGLang.g:2010:2: (this_IfElseSwitch_0= ruleIfElseSwitch | this_SwitchCase_1= ruleSwitchCase )
            {
            // InternalMGLang.g:2010:2: (this_IfElseSwitch_0= ruleIfElseSwitch | this_SwitchCase_1= ruleSwitchCase )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==35) ) {
                int LA29_1 = input.LA(2);

                if ( (LA29_1==21) ) {
                    alt29=1;
                }
                else if ( (LA29_1==19) ) {
                    alt29=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 29, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalMGLang.g:2011:3: this_IfElseSwitch_0= ruleIfElseSwitch
                    {

                    			newCompositeNode(grammarAccess.getSwitchAccess().getIfElseSwitchParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_IfElseSwitch_0=ruleIfElseSwitch();

                    state._fsp--;


                    			current = this_IfElseSwitch_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMGLang.g:2020:3: this_SwitchCase_1= ruleSwitchCase
                    {

                    			newCompositeNode(grammarAccess.getSwitchAccess().getSwitchCaseParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_SwitchCase_1=ruleSwitchCase();

                    state._fsp--;


                    			current = this_SwitchCase_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSwitch"


    // $ANTLR start "entryRuleIfElseSwitch"
    // InternalMGLang.g:2032:1: entryRuleIfElseSwitch returns [EObject current=null] : iv_ruleIfElseSwitch= ruleIfElseSwitch EOF ;
    public final EObject entryRuleIfElseSwitch() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfElseSwitch = null;


        try {
            // InternalMGLang.g:2032:53: (iv_ruleIfElseSwitch= ruleIfElseSwitch EOF )
            // InternalMGLang.g:2033:2: iv_ruleIfElseSwitch= ruleIfElseSwitch EOF
            {
             newCompositeNode(grammarAccess.getIfElseSwitchRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIfElseSwitch=ruleIfElseSwitch();

            state._fsp--;

             current =iv_ruleIfElseSwitch; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfElseSwitch"


    // $ANTLR start "ruleIfElseSwitch"
    // InternalMGLang.g:2039:1: ruleIfElseSwitch returns [EObject current=null] : (otherlv_0= 'switch' otherlv_1= '{' ( (lv_cases_2_0= ruleIfElseCase ) )+ ( (lv_default_3_0= ruleDefault ) )? otherlv_4= '}' ) ;
    public final EObject ruleIfElseSwitch() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_cases_2_0 = null;

        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:2045:2: ( (otherlv_0= 'switch' otherlv_1= '{' ( (lv_cases_2_0= ruleIfElseCase ) )+ ( (lv_default_3_0= ruleDefault ) )? otherlv_4= '}' ) )
            // InternalMGLang.g:2046:2: (otherlv_0= 'switch' otherlv_1= '{' ( (lv_cases_2_0= ruleIfElseCase ) )+ ( (lv_default_3_0= ruleDefault ) )? otherlv_4= '}' )
            {
            // InternalMGLang.g:2046:2: (otherlv_0= 'switch' otherlv_1= '{' ( (lv_cases_2_0= ruleIfElseCase ) )+ ( (lv_default_3_0= ruleDefault ) )? otherlv_4= '}' )
            // InternalMGLang.g:2047:3: otherlv_0= 'switch' otherlv_1= '{' ( (lv_cases_2_0= ruleIfElseCase ) )+ ( (lv_default_3_0= ruleDefault ) )? otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,35,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getIfElseSwitchAccess().getSwitchKeyword_0());
            		
            otherlv_1=(Token)match(input,21,FOLLOW_32); 

            			newLeafNode(otherlv_1, grammarAccess.getIfElseSwitchAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalMGLang.g:2055:3: ( (lv_cases_2_0= ruleIfElseCase ) )+
            int cnt30=0;
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==36) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalMGLang.g:2056:4: (lv_cases_2_0= ruleIfElseCase )
            	    {
            	    // InternalMGLang.g:2056:4: (lv_cases_2_0= ruleIfElseCase )
            	    // InternalMGLang.g:2057:5: lv_cases_2_0= ruleIfElseCase
            	    {

            	    					newCompositeNode(grammarAccess.getIfElseSwitchAccess().getCasesIfElseCaseParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_33);
            	    lv_cases_2_0=ruleIfElseCase();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getIfElseSwitchRule());
            	    					}
            	    					add(
            	    						current,
            	    						"cases",
            	    						lv_cases_2_0,
            	    						"org.mofgen.MGLang.IfElseCase");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt30 >= 1 ) break loop30;
                        EarlyExitException eee =
                            new EarlyExitException(30, input);
                        throw eee;
                }
                cnt30++;
            } while (true);

            // InternalMGLang.g:2074:3: ( (lv_default_3_0= ruleDefault ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==38) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalMGLang.g:2075:4: (lv_default_3_0= ruleDefault )
                    {
                    // InternalMGLang.g:2075:4: (lv_default_3_0= ruleDefault )
                    // InternalMGLang.g:2076:5: lv_default_3_0= ruleDefault
                    {

                    					newCompositeNode(grammarAccess.getIfElseSwitchAccess().getDefaultDefaultParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_28);
                    lv_default_3_0=ruleDefault();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getIfElseSwitchRule());
                    					}
                    					set(
                    						current,
                    						"default",
                    						lv_default_3_0,
                    						"org.mofgen.MGLang.Default");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getIfElseSwitchAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfElseSwitch"


    // $ANTLR start "entryRuleIfElseCase"
    // InternalMGLang.g:2101:1: entryRuleIfElseCase returns [EObject current=null] : iv_ruleIfElseCase= ruleIfElseCase EOF ;
    public final EObject entryRuleIfElseCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfElseCase = null;


        try {
            // InternalMGLang.g:2101:51: (iv_ruleIfElseCase= ruleIfElseCase EOF )
            // InternalMGLang.g:2102:2: iv_ruleIfElseCase= ruleIfElseCase EOF
            {
             newCompositeNode(grammarAccess.getIfElseCaseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIfElseCase=ruleIfElseCase();

            state._fsp--;

             current =iv_ruleIfElseCase; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfElseCase"


    // $ANTLR start "ruleIfElseCase"
    // InternalMGLang.g:2108:1: ruleIfElseCase returns [EObject current=null] : (otherlv_0= 'case' ( (lv_val_1_0= ruleArithmeticExpression ) ) otherlv_2= ':' ( (lv_body_3_0= ruleCaseBody ) ) ) ;
    public final EObject ruleIfElseCase() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_val_1_0 = null;

        EObject lv_body_3_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:2114:2: ( (otherlv_0= 'case' ( (lv_val_1_0= ruleArithmeticExpression ) ) otherlv_2= ':' ( (lv_body_3_0= ruleCaseBody ) ) ) )
            // InternalMGLang.g:2115:2: (otherlv_0= 'case' ( (lv_val_1_0= ruleArithmeticExpression ) ) otherlv_2= ':' ( (lv_body_3_0= ruleCaseBody ) ) )
            {
            // InternalMGLang.g:2115:2: (otherlv_0= 'case' ( (lv_val_1_0= ruleArithmeticExpression ) ) otherlv_2= ':' ( (lv_body_3_0= ruleCaseBody ) ) )
            // InternalMGLang.g:2116:3: otherlv_0= 'case' ( (lv_val_1_0= ruleArithmeticExpression ) ) otherlv_2= ':' ( (lv_body_3_0= ruleCaseBody ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_22); 

            			newLeafNode(otherlv_0, grammarAccess.getIfElseCaseAccess().getCaseKeyword_0());
            		
            // InternalMGLang.g:2120:3: ( (lv_val_1_0= ruleArithmeticExpression ) )
            // InternalMGLang.g:2121:4: (lv_val_1_0= ruleArithmeticExpression )
            {
            // InternalMGLang.g:2121:4: (lv_val_1_0= ruleArithmeticExpression )
            // InternalMGLang.g:2122:5: lv_val_1_0= ruleArithmeticExpression
            {

            					newCompositeNode(grammarAccess.getIfElseCaseAccess().getValArithmeticExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_34);
            lv_val_1_0=ruleArithmeticExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIfElseCaseRule());
            					}
            					set(
            						current,
            						"val",
            						lv_val_1_0,
            						"org.mofgen.MGLang.ArithmeticExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,37,FOLLOW_35); 

            			newLeafNode(otherlv_2, grammarAccess.getIfElseCaseAccess().getColonKeyword_2());
            		
            // InternalMGLang.g:2143:3: ( (lv_body_3_0= ruleCaseBody ) )
            // InternalMGLang.g:2144:4: (lv_body_3_0= ruleCaseBody )
            {
            // InternalMGLang.g:2144:4: (lv_body_3_0= ruleCaseBody )
            // InternalMGLang.g:2145:5: lv_body_3_0= ruleCaseBody
            {

            					newCompositeNode(grammarAccess.getIfElseCaseAccess().getBodyCaseBodyParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_body_3_0=ruleCaseBody();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIfElseCaseRule());
            					}
            					set(
            						current,
            						"body",
            						lv_body_3_0,
            						"org.mofgen.MGLang.CaseBody");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfElseCase"


    // $ANTLR start "entryRuleDefault"
    // InternalMGLang.g:2166:1: entryRuleDefault returns [EObject current=null] : iv_ruleDefault= ruleDefault EOF ;
    public final EObject entryRuleDefault() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefault = null;


        try {
            // InternalMGLang.g:2166:48: (iv_ruleDefault= ruleDefault EOF )
            // InternalMGLang.g:2167:2: iv_ruleDefault= ruleDefault EOF
            {
             newCompositeNode(grammarAccess.getDefaultRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDefault=ruleDefault();

            state._fsp--;

             current =iv_ruleDefault; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefault"


    // $ANTLR start "ruleDefault"
    // InternalMGLang.g:2173:1: ruleDefault returns [EObject current=null] : (otherlv_0= 'default' otherlv_1= ':' this_CaseBody_2= ruleCaseBody ) ;
    public final EObject ruleDefault() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject this_CaseBody_2 = null;



        	enterRule();

        try {
            // InternalMGLang.g:2179:2: ( (otherlv_0= 'default' otherlv_1= ':' this_CaseBody_2= ruleCaseBody ) )
            // InternalMGLang.g:2180:2: (otherlv_0= 'default' otherlv_1= ':' this_CaseBody_2= ruleCaseBody )
            {
            // InternalMGLang.g:2180:2: (otherlv_0= 'default' otherlv_1= ':' this_CaseBody_2= ruleCaseBody )
            // InternalMGLang.g:2181:3: otherlv_0= 'default' otherlv_1= ':' this_CaseBody_2= ruleCaseBody
            {
            otherlv_0=(Token)match(input,38,FOLLOW_34); 

            			newLeafNode(otherlv_0, grammarAccess.getDefaultAccess().getDefaultKeyword_0());
            		
            otherlv_1=(Token)match(input,37,FOLLOW_35); 

            			newLeafNode(otherlv_1, grammarAccess.getDefaultAccess().getColonKeyword_1());
            		

            			newCompositeNode(grammarAccess.getDefaultAccess().getCaseBodyParserRuleCall_2());
            		
            pushFollow(FOLLOW_2);
            this_CaseBody_2=ruleCaseBody();

            state._fsp--;


            			current = this_CaseBody_2;
            			afterParserOrEnumRuleCall();
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefault"


    // $ANTLR start "entryRuleSwitchCase"
    // InternalMGLang.g:2201:1: entryRuleSwitchCase returns [EObject current=null] : iv_ruleSwitchCase= ruleSwitchCase EOF ;
    public final EObject entryRuleSwitchCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchCase = null;


        try {
            // InternalMGLang.g:2201:51: (iv_ruleSwitchCase= ruleSwitchCase EOF )
            // InternalMGLang.g:2202:2: iv_ruleSwitchCase= ruleSwitchCase EOF
            {
             newCompositeNode(grammarAccess.getSwitchCaseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSwitchCase=ruleSwitchCase();

            state._fsp--;

             current =iv_ruleSwitchCase; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSwitchCase"


    // $ANTLR start "ruleSwitchCase"
    // InternalMGLang.g:2208:1: ruleSwitchCase returns [EObject current=null] : (otherlv_0= 'switch' otherlv_1= '(' ( (lv_attribute_2_0= ruleRefOrCall ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_cases_5_0= ruleCase ) )+ ( (lv_default_6_0= ruleDefault ) )? otherlv_7= '}' ) ;
    public final EObject ruleSwitchCase() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_attribute_2_0 = null;

        EObject lv_cases_5_0 = null;

        EObject lv_default_6_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:2214:2: ( (otherlv_0= 'switch' otherlv_1= '(' ( (lv_attribute_2_0= ruleRefOrCall ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_cases_5_0= ruleCase ) )+ ( (lv_default_6_0= ruleDefault ) )? otherlv_7= '}' ) )
            // InternalMGLang.g:2215:2: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_attribute_2_0= ruleRefOrCall ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_cases_5_0= ruleCase ) )+ ( (lv_default_6_0= ruleDefault ) )? otherlv_7= '}' )
            {
            // InternalMGLang.g:2215:2: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_attribute_2_0= ruleRefOrCall ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_cases_5_0= ruleCase ) )+ ( (lv_default_6_0= ruleDefault ) )? otherlv_7= '}' )
            // InternalMGLang.g:2216:3: otherlv_0= 'switch' otherlv_1= '(' ( (lv_attribute_2_0= ruleRefOrCall ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_cases_5_0= ruleCase ) )+ ( (lv_default_6_0= ruleDefault ) )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,35,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getSwitchCaseAccess().getSwitchKeyword_0());
            		
            otherlv_1=(Token)match(input,19,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getSwitchCaseAccess().getLeftParenthesisKeyword_1());
            		
            // InternalMGLang.g:2224:3: ( (lv_attribute_2_0= ruleRefOrCall ) )
            // InternalMGLang.g:2225:4: (lv_attribute_2_0= ruleRefOrCall )
            {
            // InternalMGLang.g:2225:4: (lv_attribute_2_0= ruleRefOrCall )
            // InternalMGLang.g:2226:5: lv_attribute_2_0= ruleRefOrCall
            {

            					newCompositeNode(grammarAccess.getSwitchCaseAccess().getAttributeRefOrCallParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_9);
            lv_attribute_2_0=ruleRefOrCall();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSwitchCaseRule());
            					}
            					set(
            						current,
            						"attribute",
            						lv_attribute_2_0,
            						"org.mofgen.MGLang.RefOrCall");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,20,FOLLOW_10); 

            			newLeafNode(otherlv_3, grammarAccess.getSwitchCaseAccess().getRightParenthesisKeyword_3());
            		
            otherlv_4=(Token)match(input,21,FOLLOW_32); 

            			newLeafNode(otherlv_4, grammarAccess.getSwitchCaseAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalMGLang.g:2251:3: ( (lv_cases_5_0= ruleCase ) )+
            int cnt32=0;
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==36) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalMGLang.g:2252:4: (lv_cases_5_0= ruleCase )
            	    {
            	    // InternalMGLang.g:2252:4: (lv_cases_5_0= ruleCase )
            	    // InternalMGLang.g:2253:5: lv_cases_5_0= ruleCase
            	    {

            	    					newCompositeNode(grammarAccess.getSwitchCaseAccess().getCasesCaseParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_33);
            	    lv_cases_5_0=ruleCase();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSwitchCaseRule());
            	    					}
            	    					add(
            	    						current,
            	    						"cases",
            	    						lv_cases_5_0,
            	    						"org.mofgen.MGLang.Case");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt32 >= 1 ) break loop32;
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
            } while (true);

            // InternalMGLang.g:2270:3: ( (lv_default_6_0= ruleDefault ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==38) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalMGLang.g:2271:4: (lv_default_6_0= ruleDefault )
                    {
                    // InternalMGLang.g:2271:4: (lv_default_6_0= ruleDefault )
                    // InternalMGLang.g:2272:5: lv_default_6_0= ruleDefault
                    {

                    					newCompositeNode(grammarAccess.getSwitchCaseAccess().getDefaultDefaultParserRuleCall_6_0());
                    				
                    pushFollow(FOLLOW_28);
                    lv_default_6_0=ruleDefault();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSwitchCaseRule());
                    					}
                    					set(
                    						current,
                    						"default",
                    						lv_default_6_0,
                    						"org.mofgen.MGLang.Default");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getSwitchCaseAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSwitchCase"


    // $ANTLR start "entryRuleCase"
    // InternalMGLang.g:2297:1: entryRuleCase returns [EObject current=null] : iv_ruleCase= ruleCase EOF ;
    public final EObject entryRuleCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCase = null;


        try {
            // InternalMGLang.g:2297:45: (iv_ruleCase= ruleCase EOF )
            // InternalMGLang.g:2298:2: iv_ruleCase= ruleCase EOF
            {
             newCompositeNode(grammarAccess.getCaseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCase=ruleCase();

            state._fsp--;

             current =iv_ruleCase; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCase"


    // $ANTLR start "ruleCase"
    // InternalMGLang.g:2304:1: ruleCase returns [EObject current=null] : (this_CaseWithCast_0= ruleCaseWithCast | this_CaseWithoutCast_1= ruleCaseWithoutCast ) ;
    public final EObject ruleCase() throws RecognitionException {
        EObject current = null;

        EObject this_CaseWithCast_0 = null;

        EObject this_CaseWithoutCast_1 = null;



        	enterRule();

        try {
            // InternalMGLang.g:2310:2: ( (this_CaseWithCast_0= ruleCaseWithCast | this_CaseWithoutCast_1= ruleCaseWithoutCast ) )
            // InternalMGLang.g:2311:2: (this_CaseWithCast_0= ruleCaseWithCast | this_CaseWithoutCast_1= ruleCaseWithoutCast )
            {
            // InternalMGLang.g:2311:2: (this_CaseWithCast_0= ruleCaseWithCast | this_CaseWithoutCast_1= ruleCaseWithoutCast )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==36) ) {
                int LA34_1 = input.LA(2);

                if ( (LA34_1==RULE_STRING||(LA34_1>=RULE_TRUE && LA34_1<=RULE_DOUBLE)||LA34_1==19||(LA34_1>=44 && LA34_1<=46)) ) {
                    alt34=2;
                }
                else if ( (LA34_1==RULE_ID) ) {
                    switch ( input.LA(3) ) {
                    case 19:
                    case 34:
                    case 37:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                        {
                        alt34=2;
                        }
                        break;
                    case RULE_ID:
                        {
                        alt34=1;
                        }
                        break;
                    case 28:
                        {
                        int LA34_5 = input.LA(4);

                        if ( (LA34_5==RULE_ID) ) {
                            int LA34_6 = input.LA(5);

                            if ( (LA34_6==RULE_ID) ) {
                                alt34=1;
                            }
                            else if ( (LA34_6==19||LA34_6==28||LA34_6==34||LA34_6==37||(LA34_6>=52 && LA34_6<=64)) ) {
                                alt34=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 34, 6, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 34, 5, input);

                            throw nvae;
                        }
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 34, 3, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 34, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalMGLang.g:2312:3: this_CaseWithCast_0= ruleCaseWithCast
                    {

                    			newCompositeNode(grammarAccess.getCaseAccess().getCaseWithCastParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_CaseWithCast_0=ruleCaseWithCast();

                    state._fsp--;


                    			current = this_CaseWithCast_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMGLang.g:2321:3: this_CaseWithoutCast_1= ruleCaseWithoutCast
                    {

                    			newCompositeNode(grammarAccess.getCaseAccess().getCaseWithoutCastParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_CaseWithoutCast_1=ruleCaseWithoutCast();

                    state._fsp--;


                    			current = this_CaseWithoutCast_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCase"


    // $ANTLR start "entryRuleCaseWithCast"
    // InternalMGLang.g:2333:1: entryRuleCaseWithCast returns [EObject current=null] : iv_ruleCaseWithCast= ruleCaseWithCast EOF ;
    public final EObject entryRuleCaseWithCast() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseWithCast = null;


        try {
            // InternalMGLang.g:2333:53: (iv_ruleCaseWithCast= ruleCaseWithCast EOF )
            // InternalMGLang.g:2334:2: iv_ruleCaseWithCast= ruleCaseWithCast EOF
            {
             newCompositeNode(grammarAccess.getCaseWithCastRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCaseWithCast=ruleCaseWithCast();

            state._fsp--;

             current =iv_ruleCaseWithCast; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCaseWithCast"


    // $ANTLR start "ruleCaseWithCast"
    // InternalMGLang.g:2340:1: ruleCaseWithCast returns [EObject current=null] : (otherlv_0= 'case' ( (lv_node_1_0= ruleNode ) ) (otherlv_2= 'when' ( (lv_when_3_0= ruleArithmeticExpression ) ) )? otherlv_4= ':' ( (lv_body_5_0= ruleCaseBody ) ) ) ;
    public final EObject ruleCaseWithCast() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_node_1_0 = null;

        EObject lv_when_3_0 = null;

        EObject lv_body_5_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:2346:2: ( (otherlv_0= 'case' ( (lv_node_1_0= ruleNode ) ) (otherlv_2= 'when' ( (lv_when_3_0= ruleArithmeticExpression ) ) )? otherlv_4= ':' ( (lv_body_5_0= ruleCaseBody ) ) ) )
            // InternalMGLang.g:2347:2: (otherlv_0= 'case' ( (lv_node_1_0= ruleNode ) ) (otherlv_2= 'when' ( (lv_when_3_0= ruleArithmeticExpression ) ) )? otherlv_4= ':' ( (lv_body_5_0= ruleCaseBody ) ) )
            {
            // InternalMGLang.g:2347:2: (otherlv_0= 'case' ( (lv_node_1_0= ruleNode ) ) (otherlv_2= 'when' ( (lv_when_3_0= ruleArithmeticExpression ) ) )? otherlv_4= ':' ( (lv_body_5_0= ruleCaseBody ) ) )
            // InternalMGLang.g:2348:3: otherlv_0= 'case' ( (lv_node_1_0= ruleNode ) ) (otherlv_2= 'when' ( (lv_when_3_0= ruleArithmeticExpression ) ) )? otherlv_4= ':' ( (lv_body_5_0= ruleCaseBody ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getCaseWithCastAccess().getCaseKeyword_0());
            		
            // InternalMGLang.g:2352:3: ( (lv_node_1_0= ruleNode ) )
            // InternalMGLang.g:2353:4: (lv_node_1_0= ruleNode )
            {
            // InternalMGLang.g:2353:4: (lv_node_1_0= ruleNode )
            // InternalMGLang.g:2354:5: lv_node_1_0= ruleNode
            {

            					newCompositeNode(grammarAccess.getCaseWithCastAccess().getNodeNodeParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_36);
            lv_node_1_0=ruleNode();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCaseWithCastRule());
            					}
            					set(
            						current,
            						"node",
            						lv_node_1_0,
            						"org.mofgen.MGLang.Node");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMGLang.g:2371:3: (otherlv_2= 'when' ( (lv_when_3_0= ruleArithmeticExpression ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==39) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalMGLang.g:2372:4: otherlv_2= 'when' ( (lv_when_3_0= ruleArithmeticExpression ) )
                    {
                    otherlv_2=(Token)match(input,39,FOLLOW_22); 

                    				newLeafNode(otherlv_2, grammarAccess.getCaseWithCastAccess().getWhenKeyword_2_0());
                    			
                    // InternalMGLang.g:2376:4: ( (lv_when_3_0= ruleArithmeticExpression ) )
                    // InternalMGLang.g:2377:5: (lv_when_3_0= ruleArithmeticExpression )
                    {
                    // InternalMGLang.g:2377:5: (lv_when_3_0= ruleArithmeticExpression )
                    // InternalMGLang.g:2378:6: lv_when_3_0= ruleArithmeticExpression
                    {

                    						newCompositeNode(grammarAccess.getCaseWithCastAccess().getWhenArithmeticExpressionParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_34);
                    lv_when_3_0=ruleArithmeticExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCaseWithCastRule());
                    						}
                    						set(
                    							current,
                    							"when",
                    							lv_when_3_0,
                    							"org.mofgen.MGLang.ArithmeticExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,37,FOLLOW_35); 

            			newLeafNode(otherlv_4, grammarAccess.getCaseWithCastAccess().getColonKeyword_3());
            		
            // InternalMGLang.g:2400:3: ( (lv_body_5_0= ruleCaseBody ) )
            // InternalMGLang.g:2401:4: (lv_body_5_0= ruleCaseBody )
            {
            // InternalMGLang.g:2401:4: (lv_body_5_0= ruleCaseBody )
            // InternalMGLang.g:2402:5: lv_body_5_0= ruleCaseBody
            {

            					newCompositeNode(grammarAccess.getCaseWithCastAccess().getBodyCaseBodyParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_body_5_0=ruleCaseBody();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCaseWithCastRule());
            					}
            					set(
            						current,
            						"body",
            						lv_body_5_0,
            						"org.mofgen.MGLang.CaseBody");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCaseWithCast"


    // $ANTLR start "entryRuleCaseWithoutCast"
    // InternalMGLang.g:2423:1: entryRuleCaseWithoutCast returns [EObject current=null] : iv_ruleCaseWithoutCast= ruleCaseWithoutCast EOF ;
    public final EObject entryRuleCaseWithoutCast() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseWithoutCast = null;


        try {
            // InternalMGLang.g:2423:56: (iv_ruleCaseWithoutCast= ruleCaseWithoutCast EOF )
            // InternalMGLang.g:2424:2: iv_ruleCaseWithoutCast= ruleCaseWithoutCast EOF
            {
             newCompositeNode(grammarAccess.getCaseWithoutCastRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCaseWithoutCast=ruleCaseWithoutCast();

            state._fsp--;

             current =iv_ruleCaseWithoutCast; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCaseWithoutCast"


    // $ANTLR start "ruleCaseWithoutCast"
    // InternalMGLang.g:2430:1: ruleCaseWithoutCast returns [EObject current=null] : (otherlv_0= 'case' ( (lv_val_1_0= ruleArithmeticExpression ) ) otherlv_2= ':' ( (lv_body_3_0= ruleCaseBody ) ) ) ;
    public final EObject ruleCaseWithoutCast() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_val_1_0 = null;

        EObject lv_body_3_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:2436:2: ( (otherlv_0= 'case' ( (lv_val_1_0= ruleArithmeticExpression ) ) otherlv_2= ':' ( (lv_body_3_0= ruleCaseBody ) ) ) )
            // InternalMGLang.g:2437:2: (otherlv_0= 'case' ( (lv_val_1_0= ruleArithmeticExpression ) ) otherlv_2= ':' ( (lv_body_3_0= ruleCaseBody ) ) )
            {
            // InternalMGLang.g:2437:2: (otherlv_0= 'case' ( (lv_val_1_0= ruleArithmeticExpression ) ) otherlv_2= ':' ( (lv_body_3_0= ruleCaseBody ) ) )
            // InternalMGLang.g:2438:3: otherlv_0= 'case' ( (lv_val_1_0= ruleArithmeticExpression ) ) otherlv_2= ':' ( (lv_body_3_0= ruleCaseBody ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_22); 

            			newLeafNode(otherlv_0, grammarAccess.getCaseWithoutCastAccess().getCaseKeyword_0());
            		
            // InternalMGLang.g:2442:3: ( (lv_val_1_0= ruleArithmeticExpression ) )
            // InternalMGLang.g:2443:4: (lv_val_1_0= ruleArithmeticExpression )
            {
            // InternalMGLang.g:2443:4: (lv_val_1_0= ruleArithmeticExpression )
            // InternalMGLang.g:2444:5: lv_val_1_0= ruleArithmeticExpression
            {

            					newCompositeNode(grammarAccess.getCaseWithoutCastAccess().getValArithmeticExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_34);
            lv_val_1_0=ruleArithmeticExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCaseWithoutCastRule());
            					}
            					set(
            						current,
            						"val",
            						lv_val_1_0,
            						"org.mofgen.MGLang.ArithmeticExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,37,FOLLOW_35); 

            			newLeafNode(otherlv_2, grammarAccess.getCaseWithoutCastAccess().getColonKeyword_2());
            		
            // InternalMGLang.g:2465:3: ( (lv_body_3_0= ruleCaseBody ) )
            // InternalMGLang.g:2466:4: (lv_body_3_0= ruleCaseBody )
            {
            // InternalMGLang.g:2466:4: (lv_body_3_0= ruleCaseBody )
            // InternalMGLang.g:2467:5: lv_body_3_0= ruleCaseBody
            {

            					newCompositeNode(grammarAccess.getCaseWithoutCastAccess().getBodyCaseBodyParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_body_3_0=ruleCaseBody();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCaseWithoutCastRule());
            					}
            					set(
            						current,
            						"body",
            						lv_body_3_0,
            						"org.mofgen.MGLang.CaseBody");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCaseWithoutCast"


    // $ANTLR start "entryRuleCaseBody"
    // InternalMGLang.g:2488:1: entryRuleCaseBody returns [EObject current=null] : iv_ruleCaseBody= ruleCaseBody EOF ;
    public final EObject entryRuleCaseBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseBody = null;


        try {
            // InternalMGLang.g:2488:49: (iv_ruleCaseBody= ruleCaseBody EOF )
            // InternalMGLang.g:2489:2: iv_ruleCaseBody= ruleCaseBody EOF
            {
             newCompositeNode(grammarAccess.getCaseBodyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCaseBody=ruleCaseBody();

            state._fsp--;

             current =iv_ruleCaseBody; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCaseBody"


    // $ANTLR start "ruleCaseBody"
    // InternalMGLang.g:2495:1: ruleCaseBody returns [EObject current=null] : ( ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleSwitchExpression ) )* otherlv_3= '}' ) | ( ( (lv_expressions_4_0= ruleSwitchExpression ) ) this_NEWLINE_5= RULE_NEWLINE ) ) ;
    public final EObject ruleCaseBody() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token this_NEWLINE_5=null;
        EObject lv_expressions_2_0 = null;

        EObject lv_expressions_4_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:2501:2: ( ( ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleSwitchExpression ) )* otherlv_3= '}' ) | ( ( (lv_expressions_4_0= ruleSwitchExpression ) ) this_NEWLINE_5= RULE_NEWLINE ) ) )
            // InternalMGLang.g:2502:2: ( ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleSwitchExpression ) )* otherlv_3= '}' ) | ( ( (lv_expressions_4_0= ruleSwitchExpression ) ) this_NEWLINE_5= RULE_NEWLINE ) )
            {
            // InternalMGLang.g:2502:2: ( ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleSwitchExpression ) )* otherlv_3= '}' ) | ( ( (lv_expressions_4_0= ruleSwitchExpression ) ) this_NEWLINE_5= RULE_NEWLINE ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==21) ) {
                alt37=1;
            }
            else if ( (LA37_0==RULE_ID||LA37_0==32||LA37_0==35||LA37_0==40||LA37_0==43) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalMGLang.g:2503:3: ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleSwitchExpression ) )* otherlv_3= '}' )
                    {
                    // InternalMGLang.g:2503:3: ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleSwitchExpression ) )* otherlv_3= '}' )
                    // InternalMGLang.g:2504:4: () otherlv_1= '{' ( (lv_expressions_2_0= ruleSwitchExpression ) )* otherlv_3= '}'
                    {
                    // InternalMGLang.g:2504:4: ()
                    // InternalMGLang.g:2505:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getCaseBodyAccess().getCaseBodyAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,21,FOLLOW_37); 

                    				newLeafNode(otherlv_1, grammarAccess.getCaseBodyAccess().getLeftCurlyBracketKeyword_0_1());
                    			
                    // InternalMGLang.g:2515:4: ( (lv_expressions_2_0= ruleSwitchExpression ) )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==RULE_ID||LA36_0==32||LA36_0==35||LA36_0==40||LA36_0==43) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // InternalMGLang.g:2516:5: (lv_expressions_2_0= ruleSwitchExpression )
                    	    {
                    	    // InternalMGLang.g:2516:5: (lv_expressions_2_0= ruleSwitchExpression )
                    	    // InternalMGLang.g:2517:6: lv_expressions_2_0= ruleSwitchExpression
                    	    {

                    	    						newCompositeNode(grammarAccess.getCaseBodyAccess().getExpressionsSwitchExpressionParserRuleCall_0_2_0());
                    	    					
                    	    pushFollow(FOLLOW_37);
                    	    lv_expressions_2_0=ruleSwitchExpression();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getCaseBodyRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"expressions",
                    	    							lv_expressions_2_0,
                    	    							"org.mofgen.MGLang.SwitchExpression");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop36;
                        }
                    } while (true);

                    otherlv_3=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getCaseBodyAccess().getRightCurlyBracketKeyword_0_3());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMGLang.g:2540:3: ( ( (lv_expressions_4_0= ruleSwitchExpression ) ) this_NEWLINE_5= RULE_NEWLINE )
                    {
                    // InternalMGLang.g:2540:3: ( ( (lv_expressions_4_0= ruleSwitchExpression ) ) this_NEWLINE_5= RULE_NEWLINE )
                    // InternalMGLang.g:2541:4: ( (lv_expressions_4_0= ruleSwitchExpression ) ) this_NEWLINE_5= RULE_NEWLINE
                    {
                    // InternalMGLang.g:2541:4: ( (lv_expressions_4_0= ruleSwitchExpression ) )
                    // InternalMGLang.g:2542:5: (lv_expressions_4_0= ruleSwitchExpression )
                    {
                    // InternalMGLang.g:2542:5: (lv_expressions_4_0= ruleSwitchExpression )
                    // InternalMGLang.g:2543:6: lv_expressions_4_0= ruleSwitchExpression
                    {

                    						newCompositeNode(grammarAccess.getCaseBodyAccess().getExpressionsSwitchExpressionParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_38);
                    lv_expressions_4_0=ruleSwitchExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCaseBodyRule());
                    						}
                    						add(
                    							current,
                    							"expressions",
                    							lv_expressions_4_0,
                    							"org.mofgen.MGLang.SwitchExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_NEWLINE_5=(Token)match(input,RULE_NEWLINE,FOLLOW_2); 

                    				newLeafNode(this_NEWLINE_5, grammarAccess.getCaseBodyAccess().getNEWLINETerminalRuleCall_1_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCaseBody"


    // $ANTLR start "entryRuleCollection"
    // InternalMGLang.g:2569:1: entryRuleCollection returns [EObject current=null] : iv_ruleCollection= ruleCollection EOF ;
    public final EObject entryRuleCollection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollection = null;


        try {
            // InternalMGLang.g:2569:51: (iv_ruleCollection= ruleCollection EOF )
            // InternalMGLang.g:2570:2: iv_ruleCollection= ruleCollection EOF
            {
             newCompositeNode(grammarAccess.getCollectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCollection=ruleCollection();

            state._fsp--;

             current =iv_ruleCollection; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCollection"


    // $ANTLR start "ruleCollection"
    // InternalMGLang.g:2576:1: ruleCollection returns [EObject current=null] : (this_List_0= ruleList | this_Map_1= ruleMap ) ;
    public final EObject ruleCollection() throws RecognitionException {
        EObject current = null;

        EObject this_List_0 = null;

        EObject this_Map_1 = null;



        	enterRule();

        try {
            // InternalMGLang.g:2582:2: ( (this_List_0= ruleList | this_Map_1= ruleMap ) )
            // InternalMGLang.g:2583:2: (this_List_0= ruleList | this_Map_1= ruleMap )
            {
            // InternalMGLang.g:2583:2: (this_List_0= ruleList | this_Map_1= ruleMap )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==40) ) {
                alt38=1;
            }
            else if ( (LA38_0==43) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalMGLang.g:2584:3: this_List_0= ruleList
                    {

                    			newCompositeNode(grammarAccess.getCollectionAccess().getListParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_List_0=ruleList();

                    state._fsp--;


                    			current = this_List_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMGLang.g:2593:3: this_Map_1= ruleMap
                    {

                    			newCompositeNode(grammarAccess.getCollectionAccess().getMapParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Map_1=ruleMap();

                    state._fsp--;


                    			current = this_Map_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCollection"


    // $ANTLR start "entryRuleList"
    // InternalMGLang.g:2605:1: entryRuleList returns [EObject current=null] : iv_ruleList= ruleList EOF ;
    public final EObject entryRuleList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList = null;


        try {
            // InternalMGLang.g:2605:45: (iv_ruleList= ruleList EOF )
            // InternalMGLang.g:2606:2: iv_ruleList= ruleList EOF
            {
             newCompositeNode(grammarAccess.getListRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleList=ruleList();

            state._fsp--;

             current =iv_ruleList; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleList"


    // $ANTLR start "ruleList"
    // InternalMGLang.g:2612:1: ruleList returns [EObject current=null] : (otherlv_0= 'List' ( (lv_name_1_0= RULE_ID ) ) (this_ASSIGNMENT_OP_2= RULE_ASSIGNMENT_OP ( (lv_createdBy_3_0= ruleListAssignment ) ) )? ) ;
    public final EObject ruleList() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token this_ASSIGNMENT_OP_2=null;
        EObject lv_createdBy_3_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:2618:2: ( (otherlv_0= 'List' ( (lv_name_1_0= RULE_ID ) ) (this_ASSIGNMENT_OP_2= RULE_ASSIGNMENT_OP ( (lv_createdBy_3_0= ruleListAssignment ) ) )? ) )
            // InternalMGLang.g:2619:2: (otherlv_0= 'List' ( (lv_name_1_0= RULE_ID ) ) (this_ASSIGNMENT_OP_2= RULE_ASSIGNMENT_OP ( (lv_createdBy_3_0= ruleListAssignment ) ) )? )
            {
            // InternalMGLang.g:2619:2: (otherlv_0= 'List' ( (lv_name_1_0= RULE_ID ) ) (this_ASSIGNMENT_OP_2= RULE_ASSIGNMENT_OP ( (lv_createdBy_3_0= ruleListAssignment ) ) )? )
            // InternalMGLang.g:2620:3: otherlv_0= 'List' ( (lv_name_1_0= RULE_ID ) ) (this_ASSIGNMENT_OP_2= RULE_ASSIGNMENT_OP ( (lv_createdBy_3_0= ruleListAssignment ) ) )?
            {
            otherlv_0=(Token)match(input,40,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getListAccess().getListKeyword_0());
            		
            // InternalMGLang.g:2624:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMGLang.g:2625:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMGLang.g:2625:4: (lv_name_1_0= RULE_ID )
            // InternalMGLang.g:2626:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_39); 

            					newLeafNode(lv_name_1_0, grammarAccess.getListAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getListRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalMGLang.g:2642:3: (this_ASSIGNMENT_OP_2= RULE_ASSIGNMENT_OP ( (lv_createdBy_3_0= ruleListAssignment ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_ASSIGNMENT_OP) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalMGLang.g:2643:4: this_ASSIGNMENT_OP_2= RULE_ASSIGNMENT_OP ( (lv_createdBy_3_0= ruleListAssignment ) )
                    {
                    this_ASSIGNMENT_OP_2=(Token)match(input,RULE_ASSIGNMENT_OP,FOLLOW_40); 

                    				newLeafNode(this_ASSIGNMENT_OP_2, grammarAccess.getListAccess().getASSIGNMENT_OPTerminalRuleCall_2_0());
                    			
                    // InternalMGLang.g:2647:4: ( (lv_createdBy_3_0= ruleListAssignment ) )
                    // InternalMGLang.g:2648:5: (lv_createdBy_3_0= ruleListAssignment )
                    {
                    // InternalMGLang.g:2648:5: (lv_createdBy_3_0= ruleListAssignment )
                    // InternalMGLang.g:2649:6: lv_createdBy_3_0= ruleListAssignment
                    {

                    						newCompositeNode(grammarAccess.getListAccess().getCreatedByListAssignmentParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_createdBy_3_0=ruleListAssignment();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getListRule());
                    						}
                    						set(
                    							current,
                    							"createdBy",
                    							lv_createdBy_3_0,
                    							"org.mofgen.MGLang.ListAssignment");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleList"


    // $ANTLR start "entryRuleListAssignment"
    // InternalMGLang.g:2671:1: entryRuleListAssignment returns [EObject current=null] : iv_ruleListAssignment= ruleListAssignment EOF ;
    public final EObject entryRuleListAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListAssignment = null;


        try {
            // InternalMGLang.g:2671:55: (iv_ruleListAssignment= ruleListAssignment EOF )
            // InternalMGLang.g:2672:2: iv_ruleListAssignment= ruleListAssignment EOF
            {
             newCompositeNode(grammarAccess.getListAssignmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleListAssignment=ruleListAssignment();

            state._fsp--;

             current =iv_ruleListAssignment; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleListAssignment"


    // $ANTLR start "ruleListAssignment"
    // InternalMGLang.g:2678:1: ruleListAssignment returns [EObject current=null] : (this_ListAdHoc_0= ruleListAdHoc | this_RefOrCall_1= ruleRefOrCall ) ;
    public final EObject ruleListAssignment() throws RecognitionException {
        EObject current = null;

        EObject this_ListAdHoc_0 = null;

        EObject this_RefOrCall_1 = null;



        	enterRule();

        try {
            // InternalMGLang.g:2684:2: ( (this_ListAdHoc_0= ruleListAdHoc | this_RefOrCall_1= ruleRefOrCall ) )
            // InternalMGLang.g:2685:2: (this_ListAdHoc_0= ruleListAdHoc | this_RefOrCall_1= ruleRefOrCall )
            {
            // InternalMGLang.g:2685:2: (this_ListAdHoc_0= ruleListAdHoc | this_RefOrCall_1= ruleRefOrCall )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==41) ) {
                alt40=1;
            }
            else if ( (LA40_0==RULE_ID) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalMGLang.g:2686:3: this_ListAdHoc_0= ruleListAdHoc
                    {

                    			newCompositeNode(grammarAccess.getListAssignmentAccess().getListAdHocParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ListAdHoc_0=ruleListAdHoc();

                    state._fsp--;


                    			current = this_ListAdHoc_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMGLang.g:2695:3: this_RefOrCall_1= ruleRefOrCall
                    {

                    			newCompositeNode(grammarAccess.getListAssignmentAccess().getRefOrCallParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_RefOrCall_1=ruleRefOrCall();

                    state._fsp--;


                    			current = this_RefOrCall_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleListAssignment"


    // $ANTLR start "entryRuleListAdHoc"
    // InternalMGLang.g:2707:1: entryRuleListAdHoc returns [EObject current=null] : iv_ruleListAdHoc= ruleListAdHoc EOF ;
    public final EObject entryRuleListAdHoc() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListAdHoc = null;


        try {
            // InternalMGLang.g:2707:50: (iv_ruleListAdHoc= ruleListAdHoc EOF )
            // InternalMGLang.g:2708:2: iv_ruleListAdHoc= ruleListAdHoc EOF
            {
             newCompositeNode(grammarAccess.getListAdHocRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleListAdHoc=ruleListAdHoc();

            state._fsp--;

             current =iv_ruleListAdHoc; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleListAdHoc"


    // $ANTLR start "ruleListAdHoc"
    // InternalMGLang.g:2714:1: ruleListAdHoc returns [EObject current=null] : (otherlv_0= '[' ( (lv_elements_1_0= ruleArithmeticExpression ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleArithmeticExpression ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleListAdHoc() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_elements_1_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:2720:2: ( (otherlv_0= '[' ( (lv_elements_1_0= ruleArithmeticExpression ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleArithmeticExpression ) ) )* otherlv_4= ']' ) )
            // InternalMGLang.g:2721:2: (otherlv_0= '[' ( (lv_elements_1_0= ruleArithmeticExpression ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleArithmeticExpression ) ) )* otherlv_4= ']' )
            {
            // InternalMGLang.g:2721:2: (otherlv_0= '[' ( (lv_elements_1_0= ruleArithmeticExpression ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleArithmeticExpression ) ) )* otherlv_4= ']' )
            // InternalMGLang.g:2722:3: otherlv_0= '[' ( (lv_elements_1_0= ruleArithmeticExpression ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleArithmeticExpression ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_22); 

            			newLeafNode(otherlv_0, grammarAccess.getListAdHocAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalMGLang.g:2726:3: ( (lv_elements_1_0= ruleArithmeticExpression ) )
            // InternalMGLang.g:2727:4: (lv_elements_1_0= ruleArithmeticExpression )
            {
            // InternalMGLang.g:2727:4: (lv_elements_1_0= ruleArithmeticExpression )
            // InternalMGLang.g:2728:5: lv_elements_1_0= ruleArithmeticExpression
            {

            					newCompositeNode(grammarAccess.getListAdHocAccess().getElementsArithmeticExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_41);
            lv_elements_1_0=ruleArithmeticExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getListAdHocRule());
            					}
            					add(
            						current,
            						"elements",
            						lv_elements_1_0,
            						"org.mofgen.MGLang.ArithmeticExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMGLang.g:2745:3: (otherlv_2= ',' ( (lv_elements_3_0= ruleArithmeticExpression ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==25) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalMGLang.g:2746:4: otherlv_2= ',' ( (lv_elements_3_0= ruleArithmeticExpression ) )
            	    {
            	    otherlv_2=(Token)match(input,25,FOLLOW_22); 

            	    				newLeafNode(otherlv_2, grammarAccess.getListAdHocAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalMGLang.g:2750:4: ( (lv_elements_3_0= ruleArithmeticExpression ) )
            	    // InternalMGLang.g:2751:5: (lv_elements_3_0= ruleArithmeticExpression )
            	    {
            	    // InternalMGLang.g:2751:5: (lv_elements_3_0= ruleArithmeticExpression )
            	    // InternalMGLang.g:2752:6: lv_elements_3_0= ruleArithmeticExpression
            	    {

            	    						newCompositeNode(grammarAccess.getListAdHocAccess().getElementsArithmeticExpressionParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_41);
            	    lv_elements_3_0=ruleArithmeticExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getListAdHocRule());
            	    						}
            	    						add(
            	    							current,
            	    							"elements",
            	    							lv_elements_3_0,
            	    							"org.mofgen.MGLang.ArithmeticExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

            otherlv_4=(Token)match(input,42,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getListAdHocAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleListAdHoc"


    // $ANTLR start "entryRuleMap"
    // InternalMGLang.g:2778:1: entryRuleMap returns [EObject current=null] : iv_ruleMap= ruleMap EOF ;
    public final EObject entryRuleMap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMap = null;


        try {
            // InternalMGLang.g:2778:44: (iv_ruleMap= ruleMap EOF )
            // InternalMGLang.g:2779:2: iv_ruleMap= ruleMap EOF
            {
             newCompositeNode(grammarAccess.getMapRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMap=ruleMap();

            state._fsp--;

             current =iv_ruleMap; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMap"


    // $ANTLR start "ruleMap"
    // InternalMGLang.g:2785:1: ruleMap returns [EObject current=null] : (otherlv_0= 'Map' ( (lv_name_1_0= RULE_ID ) ) (this_ASSIGNMENT_OP_2= RULE_ASSIGNMENT_OP ( (lv_createdBy_3_0= ruleMapAssignment ) ) )? ) ;
    public final EObject ruleMap() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token this_ASSIGNMENT_OP_2=null;
        EObject lv_createdBy_3_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:2791:2: ( (otherlv_0= 'Map' ( (lv_name_1_0= RULE_ID ) ) (this_ASSIGNMENT_OP_2= RULE_ASSIGNMENT_OP ( (lv_createdBy_3_0= ruleMapAssignment ) ) )? ) )
            // InternalMGLang.g:2792:2: (otherlv_0= 'Map' ( (lv_name_1_0= RULE_ID ) ) (this_ASSIGNMENT_OP_2= RULE_ASSIGNMENT_OP ( (lv_createdBy_3_0= ruleMapAssignment ) ) )? )
            {
            // InternalMGLang.g:2792:2: (otherlv_0= 'Map' ( (lv_name_1_0= RULE_ID ) ) (this_ASSIGNMENT_OP_2= RULE_ASSIGNMENT_OP ( (lv_createdBy_3_0= ruleMapAssignment ) ) )? )
            // InternalMGLang.g:2793:3: otherlv_0= 'Map' ( (lv_name_1_0= RULE_ID ) ) (this_ASSIGNMENT_OP_2= RULE_ASSIGNMENT_OP ( (lv_createdBy_3_0= ruleMapAssignment ) ) )?
            {
            otherlv_0=(Token)match(input,43,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getMapAccess().getMapKeyword_0());
            		
            // InternalMGLang.g:2797:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMGLang.g:2798:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMGLang.g:2798:4: (lv_name_1_0= RULE_ID )
            // InternalMGLang.g:2799:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_39); 

            					newLeafNode(lv_name_1_0, grammarAccess.getMapAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMapRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalMGLang.g:2815:3: (this_ASSIGNMENT_OP_2= RULE_ASSIGNMENT_OP ( (lv_createdBy_3_0= ruleMapAssignment ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ASSIGNMENT_OP) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalMGLang.g:2816:4: this_ASSIGNMENT_OP_2= RULE_ASSIGNMENT_OP ( (lv_createdBy_3_0= ruleMapAssignment ) )
                    {
                    this_ASSIGNMENT_OP_2=(Token)match(input,RULE_ASSIGNMENT_OP,FOLLOW_40); 

                    				newLeafNode(this_ASSIGNMENT_OP_2, grammarAccess.getMapAccess().getASSIGNMENT_OPTerminalRuleCall_2_0());
                    			
                    // InternalMGLang.g:2820:4: ( (lv_createdBy_3_0= ruleMapAssignment ) )
                    // InternalMGLang.g:2821:5: (lv_createdBy_3_0= ruleMapAssignment )
                    {
                    // InternalMGLang.g:2821:5: (lv_createdBy_3_0= ruleMapAssignment )
                    // InternalMGLang.g:2822:6: lv_createdBy_3_0= ruleMapAssignment
                    {

                    						newCompositeNode(grammarAccess.getMapAccess().getCreatedByMapAssignmentParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_createdBy_3_0=ruleMapAssignment();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMapRule());
                    						}
                    						set(
                    							current,
                    							"createdBy",
                    							lv_createdBy_3_0,
                    							"org.mofgen.MGLang.MapAssignment");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMap"


    // $ANTLR start "entryRuleMapAssignment"
    // InternalMGLang.g:2844:1: entryRuleMapAssignment returns [EObject current=null] : iv_ruleMapAssignment= ruleMapAssignment EOF ;
    public final EObject entryRuleMapAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapAssignment = null;


        try {
            // InternalMGLang.g:2844:54: (iv_ruleMapAssignment= ruleMapAssignment EOF )
            // InternalMGLang.g:2845:2: iv_ruleMapAssignment= ruleMapAssignment EOF
            {
             newCompositeNode(grammarAccess.getMapAssignmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMapAssignment=ruleMapAssignment();

            state._fsp--;

             current =iv_ruleMapAssignment; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMapAssignment"


    // $ANTLR start "ruleMapAssignment"
    // InternalMGLang.g:2851:1: ruleMapAssignment returns [EObject current=null] : (this_MapAdHoc_0= ruleMapAdHoc | this_RefOrCall_1= ruleRefOrCall ) ;
    public final EObject ruleMapAssignment() throws RecognitionException {
        EObject current = null;

        EObject this_MapAdHoc_0 = null;

        EObject this_RefOrCall_1 = null;



        	enterRule();

        try {
            // InternalMGLang.g:2857:2: ( (this_MapAdHoc_0= ruleMapAdHoc | this_RefOrCall_1= ruleRefOrCall ) )
            // InternalMGLang.g:2858:2: (this_MapAdHoc_0= ruleMapAdHoc | this_RefOrCall_1= ruleRefOrCall )
            {
            // InternalMGLang.g:2858:2: (this_MapAdHoc_0= ruleMapAdHoc | this_RefOrCall_1= ruleRefOrCall )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==41) ) {
                alt43=1;
            }
            else if ( (LA43_0==RULE_ID) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // InternalMGLang.g:2859:3: this_MapAdHoc_0= ruleMapAdHoc
                    {

                    			newCompositeNode(grammarAccess.getMapAssignmentAccess().getMapAdHocParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_MapAdHoc_0=ruleMapAdHoc();

                    state._fsp--;


                    			current = this_MapAdHoc_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMGLang.g:2868:3: this_RefOrCall_1= ruleRefOrCall
                    {

                    			newCompositeNode(grammarAccess.getMapAssignmentAccess().getRefOrCallParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_RefOrCall_1=ruleRefOrCall();

                    state._fsp--;


                    			current = this_RefOrCall_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMapAssignment"


    // $ANTLR start "entryRuleMapAdHoc"
    // InternalMGLang.g:2880:1: entryRuleMapAdHoc returns [EObject current=null] : iv_ruleMapAdHoc= ruleMapAdHoc EOF ;
    public final EObject entryRuleMapAdHoc() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapAdHoc = null;


        try {
            // InternalMGLang.g:2880:49: (iv_ruleMapAdHoc= ruleMapAdHoc EOF )
            // InternalMGLang.g:2881:2: iv_ruleMapAdHoc= ruleMapAdHoc EOF
            {
             newCompositeNode(grammarAccess.getMapAdHocRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMapAdHoc=ruleMapAdHoc();

            state._fsp--;

             current =iv_ruleMapAdHoc; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMapAdHoc"


    // $ANTLR start "ruleMapAdHoc"
    // InternalMGLang.g:2887:1: ruleMapAdHoc returns [EObject current=null] : (otherlv_0= '[' ( (lv_entries_1_0= ruleMapTupel ) ) (otherlv_2= ',' ( (lv_entries_3_0= ruleMapTupel ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleMapAdHoc() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_entries_1_0 = null;

        EObject lv_entries_3_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:2893:2: ( (otherlv_0= '[' ( (lv_entries_1_0= ruleMapTupel ) ) (otherlv_2= ',' ( (lv_entries_3_0= ruleMapTupel ) ) )* otherlv_4= ']' ) )
            // InternalMGLang.g:2894:2: (otherlv_0= '[' ( (lv_entries_1_0= ruleMapTupel ) ) (otherlv_2= ',' ( (lv_entries_3_0= ruleMapTupel ) ) )* otherlv_4= ']' )
            {
            // InternalMGLang.g:2894:2: (otherlv_0= '[' ( (lv_entries_1_0= ruleMapTupel ) ) (otherlv_2= ',' ( (lv_entries_3_0= ruleMapTupel ) ) )* otherlv_4= ']' )
            // InternalMGLang.g:2895:3: otherlv_0= '[' ( (lv_entries_1_0= ruleMapTupel ) ) (otherlv_2= ',' ( (lv_entries_3_0= ruleMapTupel ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getMapAdHocAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalMGLang.g:2899:3: ( (lv_entries_1_0= ruleMapTupel ) )
            // InternalMGLang.g:2900:4: (lv_entries_1_0= ruleMapTupel )
            {
            // InternalMGLang.g:2900:4: (lv_entries_1_0= ruleMapTupel )
            // InternalMGLang.g:2901:5: lv_entries_1_0= ruleMapTupel
            {

            					newCompositeNode(grammarAccess.getMapAdHocAccess().getEntriesMapTupelParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_41);
            lv_entries_1_0=ruleMapTupel();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMapAdHocRule());
            					}
            					add(
            						current,
            						"entries",
            						lv_entries_1_0,
            						"org.mofgen.MGLang.MapTupel");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMGLang.g:2918:3: (otherlv_2= ',' ( (lv_entries_3_0= ruleMapTupel ) ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==25) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalMGLang.g:2919:4: otherlv_2= ',' ( (lv_entries_3_0= ruleMapTupel ) )
            	    {
            	    otherlv_2=(Token)match(input,25,FOLLOW_8); 

            	    				newLeafNode(otherlv_2, grammarAccess.getMapAdHocAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalMGLang.g:2923:4: ( (lv_entries_3_0= ruleMapTupel ) )
            	    // InternalMGLang.g:2924:5: (lv_entries_3_0= ruleMapTupel )
            	    {
            	    // InternalMGLang.g:2924:5: (lv_entries_3_0= ruleMapTupel )
            	    // InternalMGLang.g:2925:6: lv_entries_3_0= ruleMapTupel
            	    {

            	    						newCompositeNode(grammarAccess.getMapAdHocAccess().getEntriesMapTupelParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_41);
            	    lv_entries_3_0=ruleMapTupel();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMapAdHocRule());
            	    						}
            	    						add(
            	    							current,
            	    							"entries",
            	    							lv_entries_3_0,
            	    							"org.mofgen.MGLang.MapTupel");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

            otherlv_4=(Token)match(input,42,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getMapAdHocAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMapAdHoc"


    // $ANTLR start "entryRuleMapTupel"
    // InternalMGLang.g:2951:1: entryRuleMapTupel returns [EObject current=null] : iv_ruleMapTupel= ruleMapTupel EOF ;
    public final EObject entryRuleMapTupel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapTupel = null;


        try {
            // InternalMGLang.g:2951:49: (iv_ruleMapTupel= ruleMapTupel EOF )
            // InternalMGLang.g:2952:2: iv_ruleMapTupel= ruleMapTupel EOF
            {
             newCompositeNode(grammarAccess.getMapTupelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMapTupel=ruleMapTupel();

            state._fsp--;

             current =iv_ruleMapTupel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMapTupel"


    // $ANTLR start "ruleMapTupel"
    // InternalMGLang.g:2958:1: ruleMapTupel returns [EObject current=null] : (otherlv_0= '(' ( (lv_key_1_0= ruleArithmeticExpression ) ) otherlv_2= ',' ( (lv_value_3_0= ruleArithmeticExpression ) ) otherlv_4= ')' ) ;
    public final EObject ruleMapTupel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_key_1_0 = null;

        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:2964:2: ( (otherlv_0= '(' ( (lv_key_1_0= ruleArithmeticExpression ) ) otherlv_2= ',' ( (lv_value_3_0= ruleArithmeticExpression ) ) otherlv_4= ')' ) )
            // InternalMGLang.g:2965:2: (otherlv_0= '(' ( (lv_key_1_0= ruleArithmeticExpression ) ) otherlv_2= ',' ( (lv_value_3_0= ruleArithmeticExpression ) ) otherlv_4= ')' )
            {
            // InternalMGLang.g:2965:2: (otherlv_0= '(' ( (lv_key_1_0= ruleArithmeticExpression ) ) otherlv_2= ',' ( (lv_value_3_0= ruleArithmeticExpression ) ) otherlv_4= ')' )
            // InternalMGLang.g:2966:3: otherlv_0= '(' ( (lv_key_1_0= ruleArithmeticExpression ) ) otherlv_2= ',' ( (lv_value_3_0= ruleArithmeticExpression ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_22); 

            			newLeafNode(otherlv_0, grammarAccess.getMapTupelAccess().getLeftParenthesisKeyword_0());
            		
            // InternalMGLang.g:2970:3: ( (lv_key_1_0= ruleArithmeticExpression ) )
            // InternalMGLang.g:2971:4: (lv_key_1_0= ruleArithmeticExpression )
            {
            // InternalMGLang.g:2971:4: (lv_key_1_0= ruleArithmeticExpression )
            // InternalMGLang.g:2972:5: lv_key_1_0= ruleArithmeticExpression
            {

            					newCompositeNode(grammarAccess.getMapTupelAccess().getKeyArithmeticExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_42);
            lv_key_1_0=ruleArithmeticExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMapTupelRule());
            					}
            					set(
            						current,
            						"key",
            						lv_key_1_0,
            						"org.mofgen.MGLang.ArithmeticExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_22); 

            			newLeafNode(otherlv_2, grammarAccess.getMapTupelAccess().getCommaKeyword_2());
            		
            // InternalMGLang.g:2993:3: ( (lv_value_3_0= ruleArithmeticExpression ) )
            // InternalMGLang.g:2994:4: (lv_value_3_0= ruleArithmeticExpression )
            {
            // InternalMGLang.g:2994:4: (lv_value_3_0= ruleArithmeticExpression )
            // InternalMGLang.g:2995:5: lv_value_3_0= ruleArithmeticExpression
            {

            					newCompositeNode(grammarAccess.getMapTupelAccess().getValueArithmeticExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_9);
            lv_value_3_0=ruleArithmeticExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMapTupelRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_3_0,
            						"org.mofgen.MGLang.ArithmeticExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getMapTupelAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMapTupel"


    // $ANTLR start "entryRuleForRange"
    // InternalMGLang.g:3020:1: entryRuleForRange returns [EObject current=null] : iv_ruleForRange= ruleForRange EOF ;
    public final EObject entryRuleForRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForRange = null;


        try {
            // InternalMGLang.g:3020:49: (iv_ruleForRange= ruleForRange EOF )
            // InternalMGLang.g:3021:2: iv_ruleForRange= ruleForRange EOF
            {
             newCompositeNode(grammarAccess.getForRangeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleForRange=ruleForRange();

            state._fsp--;

             current =iv_ruleForRange; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForRange"


    // $ANTLR start "ruleForRange"
    // InternalMGLang.g:3027:1: ruleForRange returns [EObject current=null] : ( ( (lv_start_0_0= ruleArithmeticExpression ) ) otherlv_1= ':' ( (lv_end_2_0= ruleArithmeticExpression ) ) ) ;
    public final EObject ruleForRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_start_0_0 = null;

        EObject lv_end_2_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:3033:2: ( ( ( (lv_start_0_0= ruleArithmeticExpression ) ) otherlv_1= ':' ( (lv_end_2_0= ruleArithmeticExpression ) ) ) )
            // InternalMGLang.g:3034:2: ( ( (lv_start_0_0= ruleArithmeticExpression ) ) otherlv_1= ':' ( (lv_end_2_0= ruleArithmeticExpression ) ) )
            {
            // InternalMGLang.g:3034:2: ( ( (lv_start_0_0= ruleArithmeticExpression ) ) otherlv_1= ':' ( (lv_end_2_0= ruleArithmeticExpression ) ) )
            // InternalMGLang.g:3035:3: ( (lv_start_0_0= ruleArithmeticExpression ) ) otherlv_1= ':' ( (lv_end_2_0= ruleArithmeticExpression ) )
            {
            // InternalMGLang.g:3035:3: ( (lv_start_0_0= ruleArithmeticExpression ) )
            // InternalMGLang.g:3036:4: (lv_start_0_0= ruleArithmeticExpression )
            {
            // InternalMGLang.g:3036:4: (lv_start_0_0= ruleArithmeticExpression )
            // InternalMGLang.g:3037:5: lv_start_0_0= ruleArithmeticExpression
            {

            					newCompositeNode(grammarAccess.getForRangeAccess().getStartArithmeticExpressionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_34);
            lv_start_0_0=ruleArithmeticExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForRangeRule());
            					}
            					set(
            						current,
            						"start",
            						lv_start_0_0,
            						"org.mofgen.MGLang.ArithmeticExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,37,FOLLOW_22); 

            			newLeafNode(otherlv_1, grammarAccess.getForRangeAccess().getColonKeyword_1());
            		
            // InternalMGLang.g:3058:3: ( (lv_end_2_0= ruleArithmeticExpression ) )
            // InternalMGLang.g:3059:4: (lv_end_2_0= ruleArithmeticExpression )
            {
            // InternalMGLang.g:3059:4: (lv_end_2_0= ruleArithmeticExpression )
            // InternalMGLang.g:3060:5: lv_end_2_0= ruleArithmeticExpression
            {

            					newCompositeNode(grammarAccess.getForRangeAccess().getEndArithmeticExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_end_2_0=ruleArithmeticExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForRangeRule());
            					}
            					set(
            						current,
            						"end",
            						lv_end_2_0,
            						"org.mofgen.MGLang.ArithmeticExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForRange"


    // $ANTLR start "entryRuleArithmeticExpression"
    // InternalMGLang.g:3081:1: entryRuleArithmeticExpression returns [EObject current=null] : iv_ruleArithmeticExpression= ruleArithmeticExpression EOF ;
    public final EObject entryRuleArithmeticExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArithmeticExpression = null;


        try {
            // InternalMGLang.g:3081:61: (iv_ruleArithmeticExpression= ruleArithmeticExpression EOF )
            // InternalMGLang.g:3082:2: iv_ruleArithmeticExpression= ruleArithmeticExpression EOF
            {
             newCompositeNode(grammarAccess.getArithmeticExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArithmeticExpression=ruleArithmeticExpression();

            state._fsp--;

             current =iv_ruleArithmeticExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArithmeticExpression"


    // $ANTLR start "ruleArithmeticExpression"
    // InternalMGLang.g:3088:1: ruleArithmeticExpression returns [EObject current=null] : this_TertiaryExpression_0= ruleTertiaryExpression ;
    public final EObject ruleArithmeticExpression() throws RecognitionException {
        EObject current = null;

        EObject this_TertiaryExpression_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:3094:2: (this_TertiaryExpression_0= ruleTertiaryExpression )
            // InternalMGLang.g:3095:2: this_TertiaryExpression_0= ruleTertiaryExpression
            {

            		newCompositeNode(grammarAccess.getArithmeticExpressionAccess().getTertiaryExpressionParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_TertiaryExpression_0=ruleTertiaryExpression();

            state._fsp--;


            		current = this_TertiaryExpression_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArithmeticExpression"


    // $ANTLR start "entryRuleTertiaryExpression"
    // InternalMGLang.g:3106:1: entryRuleTertiaryExpression returns [EObject current=null] : iv_ruleTertiaryExpression= ruleTertiaryExpression EOF ;
    public final EObject entryRuleTertiaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTertiaryExpression = null;


        try {
            // InternalMGLang.g:3106:59: (iv_ruleTertiaryExpression= ruleTertiaryExpression EOF )
            // InternalMGLang.g:3107:2: iv_ruleTertiaryExpression= ruleTertiaryExpression EOF
            {
             newCompositeNode(grammarAccess.getTertiaryExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTertiaryExpression=ruleTertiaryExpression();

            state._fsp--;

             current =iv_ruleTertiaryExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTertiaryExpression"


    // $ANTLR start "ruleTertiaryExpression"
    // InternalMGLang.g:3113:1: ruleTertiaryExpression returns [EObject current=null] : (this_SecondaryExpression_0= ruleSecondaryExpression ( () ( (lv_op_2_0= ruleTertiaryOp ) ) ( (lv_right_3_0= ruleSecondaryExpression ) ) )* ) ;
    public final EObject ruleTertiaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_SecondaryExpression_0 = null;

        Enumerator lv_op_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:3119:2: ( (this_SecondaryExpression_0= ruleSecondaryExpression ( () ( (lv_op_2_0= ruleTertiaryOp ) ) ( (lv_right_3_0= ruleSecondaryExpression ) ) )* ) )
            // InternalMGLang.g:3120:2: (this_SecondaryExpression_0= ruleSecondaryExpression ( () ( (lv_op_2_0= ruleTertiaryOp ) ) ( (lv_right_3_0= ruleSecondaryExpression ) ) )* )
            {
            // InternalMGLang.g:3120:2: (this_SecondaryExpression_0= ruleSecondaryExpression ( () ( (lv_op_2_0= ruleTertiaryOp ) ) ( (lv_right_3_0= ruleSecondaryExpression ) ) )* )
            // InternalMGLang.g:3121:3: this_SecondaryExpression_0= ruleSecondaryExpression ( () ( (lv_op_2_0= ruleTertiaryOp ) ) ( (lv_right_3_0= ruleSecondaryExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getTertiaryExpressionAccess().getSecondaryExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_43);
            this_SecondaryExpression_0=ruleSecondaryExpression();

            state._fsp--;


            			current = this_SecondaryExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMGLang.g:3129:3: ( () ( (lv_op_2_0= ruleTertiaryOp ) ) ( (lv_right_3_0= ruleSecondaryExpression ) ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==34||(LA45_0>=58 && LA45_0<=59)) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalMGLang.g:3130:4: () ( (lv_op_2_0= ruleTertiaryOp ) ) ( (lv_right_3_0= ruleSecondaryExpression ) )
            	    {
            	    // InternalMGLang.g:3130:4: ()
            	    // InternalMGLang.g:3131:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getTertiaryExpressionAccess().getTertiaryLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalMGLang.g:3137:4: ( (lv_op_2_0= ruleTertiaryOp ) )
            	    // InternalMGLang.g:3138:5: (lv_op_2_0= ruleTertiaryOp )
            	    {
            	    // InternalMGLang.g:3138:5: (lv_op_2_0= ruleTertiaryOp )
            	    // InternalMGLang.g:3139:6: lv_op_2_0= ruleTertiaryOp
            	    {

            	    						newCompositeNode(grammarAccess.getTertiaryExpressionAccess().getOpTertiaryOpEnumRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_22);
            	    lv_op_2_0=ruleTertiaryOp();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTertiaryExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"op",
            	    							lv_op_2_0,
            	    							"org.mofgen.MGLang.TertiaryOp");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalMGLang.g:3156:4: ( (lv_right_3_0= ruleSecondaryExpression ) )
            	    // InternalMGLang.g:3157:5: (lv_right_3_0= ruleSecondaryExpression )
            	    {
            	    // InternalMGLang.g:3157:5: (lv_right_3_0= ruleSecondaryExpression )
            	    // InternalMGLang.g:3158:6: lv_right_3_0= ruleSecondaryExpression
            	    {

            	    						newCompositeNode(grammarAccess.getTertiaryExpressionAccess().getRightSecondaryExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_43);
            	    lv_right_3_0=ruleSecondaryExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTertiaryExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.mofgen.MGLang.SecondaryExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTertiaryExpression"


    // $ANTLR start "entryRuleSecondaryExpression"
    // InternalMGLang.g:3180:1: entryRuleSecondaryExpression returns [EObject current=null] : iv_ruleSecondaryExpression= ruleSecondaryExpression EOF ;
    public final EObject entryRuleSecondaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecondaryExpression = null;


        try {
            // InternalMGLang.g:3180:60: (iv_ruleSecondaryExpression= ruleSecondaryExpression EOF )
            // InternalMGLang.g:3181:2: iv_ruleSecondaryExpression= ruleSecondaryExpression EOF
            {
             newCompositeNode(grammarAccess.getSecondaryExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSecondaryExpression=ruleSecondaryExpression();

            state._fsp--;

             current =iv_ruleSecondaryExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSecondaryExpression"


    // $ANTLR start "ruleSecondaryExpression"
    // InternalMGLang.g:3187:1: ruleSecondaryExpression returns [EObject current=null] : (this_PrimaryExpr_0= rulePrimaryExpr ( () ( (lv_op_2_0= ruleSecondaryOp ) ) ( (lv_right_3_0= rulePrimaryExpr ) ) )* ) ;
    public final EObject ruleSecondaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpr_0 = null;

        Enumerator lv_op_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:3193:2: ( (this_PrimaryExpr_0= rulePrimaryExpr ( () ( (lv_op_2_0= ruleSecondaryOp ) ) ( (lv_right_3_0= rulePrimaryExpr ) ) )* ) )
            // InternalMGLang.g:3194:2: (this_PrimaryExpr_0= rulePrimaryExpr ( () ( (lv_op_2_0= ruleSecondaryOp ) ) ( (lv_right_3_0= rulePrimaryExpr ) ) )* )
            {
            // InternalMGLang.g:3194:2: (this_PrimaryExpr_0= rulePrimaryExpr ( () ( (lv_op_2_0= ruleSecondaryOp ) ) ( (lv_right_3_0= rulePrimaryExpr ) ) )* )
            // InternalMGLang.g:3195:3: this_PrimaryExpr_0= rulePrimaryExpr ( () ( (lv_op_2_0= ruleSecondaryOp ) ) ( (lv_right_3_0= rulePrimaryExpr ) ) )*
            {

            			newCompositeNode(grammarAccess.getSecondaryExpressionAccess().getPrimaryExprParserRuleCall_0());
            		
            pushFollow(FOLLOW_44);
            this_PrimaryExpr_0=rulePrimaryExpr();

            state._fsp--;


            			current = this_PrimaryExpr_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMGLang.g:3203:3: ( () ( (lv_op_2_0= ruleSecondaryOp ) ) ( (lv_right_3_0= rulePrimaryExpr ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( ((LA46_0>=60 && LA46_0<=61)) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalMGLang.g:3204:4: () ( (lv_op_2_0= ruleSecondaryOp ) ) ( (lv_right_3_0= rulePrimaryExpr ) )
            	    {
            	    // InternalMGLang.g:3204:4: ()
            	    // InternalMGLang.g:3205:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getSecondaryExpressionAccess().getSecondaryLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalMGLang.g:3211:4: ( (lv_op_2_0= ruleSecondaryOp ) )
            	    // InternalMGLang.g:3212:5: (lv_op_2_0= ruleSecondaryOp )
            	    {
            	    // InternalMGLang.g:3212:5: (lv_op_2_0= ruleSecondaryOp )
            	    // InternalMGLang.g:3213:6: lv_op_2_0= ruleSecondaryOp
            	    {

            	    						newCompositeNode(grammarAccess.getSecondaryExpressionAccess().getOpSecondaryOpEnumRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_22);
            	    lv_op_2_0=ruleSecondaryOp();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getSecondaryExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"op",
            	    							lv_op_2_0,
            	    							"org.mofgen.MGLang.SecondaryOp");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalMGLang.g:3230:4: ( (lv_right_3_0= rulePrimaryExpr ) )
            	    // InternalMGLang.g:3231:5: (lv_right_3_0= rulePrimaryExpr )
            	    {
            	    // InternalMGLang.g:3231:5: (lv_right_3_0= rulePrimaryExpr )
            	    // InternalMGLang.g:3232:6: lv_right_3_0= rulePrimaryExpr
            	    {

            	    						newCompositeNode(grammarAccess.getSecondaryExpressionAccess().getRightPrimaryExprParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_44);
            	    lv_right_3_0=rulePrimaryExpr();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getSecondaryExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.mofgen.MGLang.PrimaryExpr");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSecondaryExpression"


    // $ANTLR start "entryRulePrimaryExpr"
    // InternalMGLang.g:3254:1: entryRulePrimaryExpr returns [EObject current=null] : iv_rulePrimaryExpr= rulePrimaryExpr EOF ;
    public final EObject entryRulePrimaryExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpr = null;


        try {
            // InternalMGLang.g:3254:52: (iv_rulePrimaryExpr= rulePrimaryExpr EOF )
            // InternalMGLang.g:3255:2: iv_rulePrimaryExpr= rulePrimaryExpr EOF
            {
             newCompositeNode(grammarAccess.getPrimaryExprRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExpr=rulePrimaryExpr();

            state._fsp--;

             current =iv_rulePrimaryExpr; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpr"


    // $ANTLR start "rulePrimaryExpr"
    // InternalMGLang.g:3261:1: rulePrimaryExpr returns [EObject current=null] : (this_RelationExpression_0= ruleRelationExpression ( () ( (lv_op_2_0= rulePrimaryOp ) ) ( (lv_right_3_0= ruleRelationExpression ) ) )* ) ;
    public final EObject rulePrimaryExpr() throws RecognitionException {
        EObject current = null;

        EObject this_RelationExpression_0 = null;

        Enumerator lv_op_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:3267:2: ( (this_RelationExpression_0= ruleRelationExpression ( () ( (lv_op_2_0= rulePrimaryOp ) ) ( (lv_right_3_0= ruleRelationExpression ) ) )* ) )
            // InternalMGLang.g:3268:2: (this_RelationExpression_0= ruleRelationExpression ( () ( (lv_op_2_0= rulePrimaryOp ) ) ( (lv_right_3_0= ruleRelationExpression ) ) )* )
            {
            // InternalMGLang.g:3268:2: (this_RelationExpression_0= ruleRelationExpression ( () ( (lv_op_2_0= rulePrimaryOp ) ) ( (lv_right_3_0= ruleRelationExpression ) ) )* )
            // InternalMGLang.g:3269:3: this_RelationExpression_0= ruleRelationExpression ( () ( (lv_op_2_0= rulePrimaryOp ) ) ( (lv_right_3_0= ruleRelationExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getPrimaryExprAccess().getRelationExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_45);
            this_RelationExpression_0=ruleRelationExpression();

            state._fsp--;


            			current = this_RelationExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMGLang.g:3277:3: ( () ( (lv_op_2_0= rulePrimaryOp ) ) ( (lv_right_3_0= ruleRelationExpression ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( ((LA47_0>=62 && LA47_0<=64)) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalMGLang.g:3278:4: () ( (lv_op_2_0= rulePrimaryOp ) ) ( (lv_right_3_0= ruleRelationExpression ) )
            	    {
            	    // InternalMGLang.g:3278:4: ()
            	    // InternalMGLang.g:3279:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getPrimaryExprAccess().getPrimaryLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalMGLang.g:3285:4: ( (lv_op_2_0= rulePrimaryOp ) )
            	    // InternalMGLang.g:3286:5: (lv_op_2_0= rulePrimaryOp )
            	    {
            	    // InternalMGLang.g:3286:5: (lv_op_2_0= rulePrimaryOp )
            	    // InternalMGLang.g:3287:6: lv_op_2_0= rulePrimaryOp
            	    {

            	    						newCompositeNode(grammarAccess.getPrimaryExprAccess().getOpPrimaryOpEnumRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_22);
            	    lv_op_2_0=rulePrimaryOp();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPrimaryExprRule());
            	    						}
            	    						set(
            	    							current,
            	    							"op",
            	    							lv_op_2_0,
            	    							"org.mofgen.MGLang.PrimaryOp");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalMGLang.g:3304:4: ( (lv_right_3_0= ruleRelationExpression ) )
            	    // InternalMGLang.g:3305:5: (lv_right_3_0= ruleRelationExpression )
            	    {
            	    // InternalMGLang.g:3305:5: (lv_right_3_0= ruleRelationExpression )
            	    // InternalMGLang.g:3306:6: lv_right_3_0= ruleRelationExpression
            	    {

            	    						newCompositeNode(grammarAccess.getPrimaryExprAccess().getRightRelationExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_45);
            	    lv_right_3_0=ruleRelationExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPrimaryExprRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.mofgen.MGLang.RelationExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpr"


    // $ANTLR start "entryRuleRelationExpression"
    // InternalMGLang.g:3328:1: entryRuleRelationExpression returns [EObject current=null] : iv_ruleRelationExpression= ruleRelationExpression EOF ;
    public final EObject entryRuleRelationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationExpression = null;


        try {
            // InternalMGLang.g:3328:59: (iv_ruleRelationExpression= ruleRelationExpression EOF )
            // InternalMGLang.g:3329:2: iv_ruleRelationExpression= ruleRelationExpression EOF
            {
             newCompositeNode(grammarAccess.getRelationExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelationExpression=ruleRelationExpression();

            state._fsp--;

             current =iv_ruleRelationExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationExpression"


    // $ANTLR start "ruleRelationExpression"
    // InternalMGLang.g:3335:1: ruleRelationExpression returns [EObject current=null] : (this_BaseExpr_0= ruleBaseExpr ( () ( (lv_relation_2_0= ruleRelationalOp ) ) ( (lv_right_3_0= ruleBaseExpr ) ) )* ) ;
    public final EObject ruleRelationExpression() throws RecognitionException {
        EObject current = null;

        EObject this_BaseExpr_0 = null;

        Enumerator lv_relation_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMGLang.g:3341:2: ( (this_BaseExpr_0= ruleBaseExpr ( () ( (lv_relation_2_0= ruleRelationalOp ) ) ( (lv_right_3_0= ruleBaseExpr ) ) )* ) )
            // InternalMGLang.g:3342:2: (this_BaseExpr_0= ruleBaseExpr ( () ( (lv_relation_2_0= ruleRelationalOp ) ) ( (lv_right_3_0= ruleBaseExpr ) ) )* )
            {
            // InternalMGLang.g:3342:2: (this_BaseExpr_0= ruleBaseExpr ( () ( (lv_relation_2_0= ruleRelationalOp ) ) ( (lv_right_3_0= ruleBaseExpr ) ) )* )
            // InternalMGLang.g:3343:3: this_BaseExpr_0= ruleBaseExpr ( () ( (lv_relation_2_0= ruleRelationalOp ) ) ( (lv_right_3_0= ruleBaseExpr ) ) )*
            {

            			newCompositeNode(grammarAccess.getRelationExpressionAccess().getBaseExprParserRuleCall_0());
            		
            pushFollow(FOLLOW_46);
            this_BaseExpr_0=ruleBaseExpr();

            state._fsp--;


            			current = this_BaseExpr_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMGLang.g:3351:3: ( () ( (lv_relation_2_0= ruleRelationalOp ) ) ( (lv_right_3_0= ruleBaseExpr ) ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( ((LA48_0>=52 && LA48_0<=57)) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalMGLang.g:3352:4: () ( (lv_relation_2_0= ruleRelationalOp ) ) ( (lv_right_3_0= ruleBaseExpr ) )
            	    {
            	    // InternalMGLang.g:3352:4: ()
            	    // InternalMGLang.g:3353:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getRelationExpressionAccess().getRelLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalMGLang.g:3359:4: ( (lv_relation_2_0= ruleRelationalOp ) )
            	    // InternalMGLang.g:3360:5: (lv_relation_2_0= ruleRelationalOp )
            	    {
            	    // InternalMGLang.g:3360:5: (lv_relation_2_0= ruleRelationalOp )
            	    // InternalMGLang.g:3361:6: lv_relation_2_0= ruleRelationalOp
            	    {

            	    						newCompositeNode(grammarAccess.getRelationExpressionAccess().getRelationRelationalOpEnumRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_22);
            	    lv_relation_2_0=ruleRelationalOp();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getRelationExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"relation",
            	    							lv_relation_2_0,
            	    							"org.mofgen.MGLang.RelationalOp");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalMGLang.g:3378:4: ( (lv_right_3_0= ruleBaseExpr ) )
            	    // InternalMGLang.g:3379:5: (lv_right_3_0= ruleBaseExpr )
            	    {
            	    // InternalMGLang.g:3379:5: (lv_right_3_0= ruleBaseExpr )
            	    // InternalMGLang.g:3380:6: lv_right_3_0= ruleBaseExpr
            	    {

            	    						newCompositeNode(grammarAccess.getRelationExpressionAccess().getRightBaseExprParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_46);
            	    lv_right_3_0=ruleBaseExpr();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getRelationExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.mofgen.MGLang.BaseExpr");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationExpression"


    // $ANTLR start "entryRuleBaseExpr"
    // InternalMGLang.g:3402:1: entryRuleBaseExpr returns [EObject current=null] : iv_ruleBaseExpr= ruleBaseExpr EOF ;
    public final EObject entryRuleBaseExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseExpr = null;


        try {
            // InternalMGLang.g:3402:49: (iv_ruleBaseExpr= ruleBaseExpr EOF )
            // InternalMGLang.g:3403:2: iv_ruleBaseExpr= ruleBaseExpr EOF
            {
             newCompositeNode(grammarAccess.getBaseExprRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBaseExpr=ruleBaseExpr();

            state._fsp--;

             current =iv_ruleBaseExpr; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBaseExpr"


    // $ANTLR start "ruleBaseExpr"
    // InternalMGLang.g:3409:1: ruleBaseExpr returns [EObject current=null] : ( (otherlv_0= '(' this_ArithmeticExpression_1= ruleArithmeticExpression otherlv_2= ')' ) | ( () otherlv_4= '!' ( (lv_expr_5_0= ruleBaseExpr ) ) ) | ( () ( (lv_func_7_0= ruleMathFunc ) ) otherlv_8= '(' ( (lv_expr_9_0= ruleArithmeticExpression ) ) otherlv_10= ')' ) | this_Literal_11= ruleLiteral | this_RefOrCall_12= ruleRefOrCall | this_PatternCall_13= rulePatternCall ) ;
    public final EObject ruleBaseExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject this_ArithmeticExpression_1 = null;

        EObject lv_expr_5_0 = null;

        Enumerator lv_func_7_0 = null;

        EObject lv_expr_9_0 = null;

        EObject this_Literal_11 = null;

        EObject this_RefOrCall_12 = null;

        EObject this_PatternCall_13 = null;



        	enterRule();

        try {
            // InternalMGLang.g:3415:2: ( ( (otherlv_0= '(' this_ArithmeticExpression_1= ruleArithmeticExpression otherlv_2= ')' ) | ( () otherlv_4= '!' ( (lv_expr_5_0= ruleBaseExpr ) ) ) | ( () ( (lv_func_7_0= ruleMathFunc ) ) otherlv_8= '(' ( (lv_expr_9_0= ruleArithmeticExpression ) ) otherlv_10= ')' ) | this_Literal_11= ruleLiteral | this_RefOrCall_12= ruleRefOrCall | this_PatternCall_13= rulePatternCall ) )
            // InternalMGLang.g:3416:2: ( (otherlv_0= '(' this_ArithmeticExpression_1= ruleArithmeticExpression otherlv_2= ')' ) | ( () otherlv_4= '!' ( (lv_expr_5_0= ruleBaseExpr ) ) ) | ( () ( (lv_func_7_0= ruleMathFunc ) ) otherlv_8= '(' ( (lv_expr_9_0= ruleArithmeticExpression ) ) otherlv_10= ')' ) | this_Literal_11= ruleLiteral | this_RefOrCall_12= ruleRefOrCall | this_PatternCall_13= rulePatternCall )
            {
            // InternalMGLang.g:3416:2: ( (otherlv_0= '(' this_ArithmeticExpression_1= ruleArithmeticExpression otherlv_2= ')' ) | ( () otherlv_4= '!' ( (lv_expr_5_0= ruleBaseExpr ) ) ) | ( () ( (lv_func_7_0= ruleMathFunc ) ) otherlv_8= '(' ( (lv_expr_9_0= ruleArithmeticExpression ) ) otherlv_10= ')' ) | this_Literal_11= ruleLiteral | this_RefOrCall_12= ruleRefOrCall | this_PatternCall_13= rulePatternCall )
            int alt49=6;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt49=1;
                }
                break;
            case 44:
                {
                alt49=2;
                }
                break;
            case 45:
            case 46:
                {
                alt49=3;
                }
                break;
            case RULE_STRING:
            case RULE_TRUE:
            case RULE_FALSE:
            case RULE_DOUBLE:
                {
                alt49=4;
                }
                break;
            case RULE_ID:
                {
                int LA49_5 = input.LA(2);

                if ( (LA49_5==19) ) {
                    alt49=6;
                }
                else if ( (LA49_5==EOF||LA49_5==RULE_ID||LA49_5==RULE_NEWLINE||(LA49_5>=20 && LA49_5<=22)||LA49_5==25||LA49_5==28||(LA49_5>=31 && LA49_5<=32)||(LA49_5>=34 && LA49_5<=35)||LA49_5==37||LA49_5==40||(LA49_5>=42 && LA49_5<=43)||(LA49_5>=52 && LA49_5<=64)) ) {
                    alt49=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 5, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // InternalMGLang.g:3417:3: (otherlv_0= '(' this_ArithmeticExpression_1= ruleArithmeticExpression otherlv_2= ')' )
                    {
                    // InternalMGLang.g:3417:3: (otherlv_0= '(' this_ArithmeticExpression_1= ruleArithmeticExpression otherlv_2= ')' )
                    // InternalMGLang.g:3418:4: otherlv_0= '(' this_ArithmeticExpression_1= ruleArithmeticExpression otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,19,FOLLOW_22); 

                    				newLeafNode(otherlv_0, grammarAccess.getBaseExprAccess().getLeftParenthesisKeyword_0_0());
                    			

                    				newCompositeNode(grammarAccess.getBaseExprAccess().getArithmeticExpressionParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_9);
                    this_ArithmeticExpression_1=ruleArithmeticExpression();

                    state._fsp--;


                    				current = this_ArithmeticExpression_1;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_2=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getBaseExprAccess().getRightParenthesisKeyword_0_2());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMGLang.g:3436:3: ( () otherlv_4= '!' ( (lv_expr_5_0= ruleBaseExpr ) ) )
                    {
                    // InternalMGLang.g:3436:3: ( () otherlv_4= '!' ( (lv_expr_5_0= ruleBaseExpr ) ) )
                    // InternalMGLang.g:3437:4: () otherlv_4= '!' ( (lv_expr_5_0= ruleBaseExpr ) )
                    {
                    // InternalMGLang.g:3437:4: ()
                    // InternalMGLang.g:3438:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getBaseExprAccess().getNegationExpressionAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_4=(Token)match(input,44,FOLLOW_22); 

                    				newLeafNode(otherlv_4, grammarAccess.getBaseExprAccess().getExclamationMarkKeyword_1_1());
                    			
                    // InternalMGLang.g:3448:4: ( (lv_expr_5_0= ruleBaseExpr ) )
                    // InternalMGLang.g:3449:5: (lv_expr_5_0= ruleBaseExpr )
                    {
                    // InternalMGLang.g:3449:5: (lv_expr_5_0= ruleBaseExpr )
                    // InternalMGLang.g:3450:6: lv_expr_5_0= ruleBaseExpr
                    {

                    						newCompositeNode(grammarAccess.getBaseExprAccess().getExprBaseExprParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_expr_5_0=ruleBaseExpr();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBaseExprRule());
                    						}
                    						set(
                    							current,
                    							"expr",
                    							lv_expr_5_0,
                    							"org.mofgen.MGLang.BaseExpr");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMGLang.g:3469:3: ( () ( (lv_func_7_0= ruleMathFunc ) ) otherlv_8= '(' ( (lv_expr_9_0= ruleArithmeticExpression ) ) otherlv_10= ')' )
                    {
                    // InternalMGLang.g:3469:3: ( () ( (lv_func_7_0= ruleMathFunc ) ) otherlv_8= '(' ( (lv_expr_9_0= ruleArithmeticExpression ) ) otherlv_10= ')' )
                    // InternalMGLang.g:3470:4: () ( (lv_func_7_0= ruleMathFunc ) ) otherlv_8= '(' ( (lv_expr_9_0= ruleArithmeticExpression ) ) otherlv_10= ')'
                    {
                    // InternalMGLang.g:3470:4: ()
                    // InternalMGLang.g:3471:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getBaseExprAccess().getFunctionCallAction_2_0(),
                    						current);
                    				

                    }

                    // InternalMGLang.g:3477:4: ( (lv_func_7_0= ruleMathFunc ) )
                    // InternalMGLang.g:3478:5: (lv_func_7_0= ruleMathFunc )
                    {
                    // InternalMGLang.g:3478:5: (lv_func_7_0= ruleMathFunc )
                    // InternalMGLang.g:3479:6: lv_func_7_0= ruleMathFunc
                    {

                    						newCompositeNode(grammarAccess.getBaseExprAccess().getFuncMathFuncEnumRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_func_7_0=ruleMathFunc();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBaseExprRule());
                    						}
                    						set(
                    							current,
                    							"func",
                    							lv_func_7_0,
                    							"org.mofgen.MGLang.MathFunc");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,19,FOLLOW_22); 

                    				newLeafNode(otherlv_8, grammarAccess.getBaseExprAccess().getLeftParenthesisKeyword_2_2());
                    			
                    // InternalMGLang.g:3500:4: ( (lv_expr_9_0= ruleArithmeticExpression ) )
                    // InternalMGLang.g:3501:5: (lv_expr_9_0= ruleArithmeticExpression )
                    {
                    // InternalMGLang.g:3501:5: (lv_expr_9_0= ruleArithmeticExpression )
                    // InternalMGLang.g:3502:6: lv_expr_9_0= ruleArithmeticExpression
                    {

                    						newCompositeNode(grammarAccess.getBaseExprAccess().getExprArithmeticExpressionParserRuleCall_2_3_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_expr_9_0=ruleArithmeticExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBaseExprRule());
                    						}
                    						set(
                    							current,
                    							"expr",
                    							lv_expr_9_0,
                    							"org.mofgen.MGLang.ArithmeticExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_10=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_10, grammarAccess.getBaseExprAccess().getRightParenthesisKeyword_2_4());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMGLang.g:3525:3: this_Literal_11= ruleLiteral
                    {

                    			newCompositeNode(grammarAccess.getBaseExprAccess().getLiteralParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Literal_11=ruleLiteral();

                    state._fsp--;


                    			current = this_Literal_11;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalMGLang.g:3534:3: this_RefOrCall_12= ruleRefOrCall
                    {

                    			newCompositeNode(grammarAccess.getBaseExprAccess().getRefOrCallParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_RefOrCall_12=ruleRefOrCall();

                    state._fsp--;


                    			current = this_RefOrCall_12;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalMGLang.g:3543:3: this_PatternCall_13= rulePatternCall
                    {

                    			newCompositeNode(grammarAccess.getBaseExprAccess().getPatternCallParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_PatternCall_13=rulePatternCall();

                    state._fsp--;


                    			current = this_PatternCall_13;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBaseExpr"


    // $ANTLR start "entryRuleLiteral"
    // InternalMGLang.g:3555:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalMGLang.g:3555:48: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalMGLang.g:3556:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalMGLang.g:3562:1: ruleLiteral returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_StringLiteral_1= ruleStringLiteral | this_NumberLiteral_2= ruleNumberLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanLiteral_0 = null;

        EObject this_StringLiteral_1 = null;

        EObject this_NumberLiteral_2 = null;



        	enterRule();

        try {
            // InternalMGLang.g:3568:2: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_StringLiteral_1= ruleStringLiteral | this_NumberLiteral_2= ruleNumberLiteral ) )
            // InternalMGLang.g:3569:2: (this_BooleanLiteral_0= ruleBooleanLiteral | this_StringLiteral_1= ruleStringLiteral | this_NumberLiteral_2= ruleNumberLiteral )
            {
            // InternalMGLang.g:3569:2: (this_BooleanLiteral_0= ruleBooleanLiteral | this_StringLiteral_1= ruleStringLiteral | this_NumberLiteral_2= ruleNumberLiteral )
            int alt50=3;
            switch ( input.LA(1) ) {
            case RULE_TRUE:
            case RULE_FALSE:
                {
                alt50=1;
                }
                break;
            case RULE_STRING:
                {
                alt50=2;
                }
                break;
            case RULE_DOUBLE:
                {
                alt50=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // InternalMGLang.g:3570:3: this_BooleanLiteral_0= ruleBooleanLiteral
                    {

                    			newCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_BooleanLiteral_0=ruleBooleanLiteral();

                    state._fsp--;


                    			current = this_BooleanLiteral_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMGLang.g:3579:3: this_StringLiteral_1= ruleStringLiteral
                    {

                    			newCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_StringLiteral_1=ruleStringLiteral();

                    state._fsp--;


                    			current = this_StringLiteral_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMGLang.g:3588:3: this_NumberLiteral_2= ruleNumberLiteral
                    {

                    			newCompositeNode(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumberLiteral_2=ruleNumberLiteral();

                    state._fsp--;


                    			current = this_NumberLiteral_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleBooleanLiteral"
    // InternalMGLang.g:3600:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalMGLang.g:3600:55: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalMGLang.g:3601:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;

             current =iv_ruleBooleanLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanLiteral"


    // $ANTLR start "ruleBooleanLiteral"
    // InternalMGLang.g:3607:1: ruleBooleanLiteral returns [EObject current=null] : ( ( (lv_val_0_1= RULE_TRUE | lv_val_0_2= RULE_FALSE ) ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_1=null;
        Token lv_val_0_2=null;


        	enterRule();

        try {
            // InternalMGLang.g:3613:2: ( ( ( (lv_val_0_1= RULE_TRUE | lv_val_0_2= RULE_FALSE ) ) ) )
            // InternalMGLang.g:3614:2: ( ( (lv_val_0_1= RULE_TRUE | lv_val_0_2= RULE_FALSE ) ) )
            {
            // InternalMGLang.g:3614:2: ( ( (lv_val_0_1= RULE_TRUE | lv_val_0_2= RULE_FALSE ) ) )
            // InternalMGLang.g:3615:3: ( (lv_val_0_1= RULE_TRUE | lv_val_0_2= RULE_FALSE ) )
            {
            // InternalMGLang.g:3615:3: ( (lv_val_0_1= RULE_TRUE | lv_val_0_2= RULE_FALSE ) )
            // InternalMGLang.g:3616:4: (lv_val_0_1= RULE_TRUE | lv_val_0_2= RULE_FALSE )
            {
            // InternalMGLang.g:3616:4: (lv_val_0_1= RULE_TRUE | lv_val_0_2= RULE_FALSE )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_TRUE) ) {
                alt51=1;
            }
            else if ( (LA51_0==RULE_FALSE) ) {
                alt51=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // InternalMGLang.g:3617:5: lv_val_0_1= RULE_TRUE
                    {
                    lv_val_0_1=(Token)match(input,RULE_TRUE,FOLLOW_2); 

                    					newLeafNode(lv_val_0_1, grammarAccess.getBooleanLiteralAccess().getValTRUETerminalRuleCall_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanLiteralRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"val",
                    						lv_val_0_1,
                    						"org.mofgen.MGLang.TRUE");
                    				

                    }
                    break;
                case 2 :
                    // InternalMGLang.g:3632:5: lv_val_0_2= RULE_FALSE
                    {
                    lv_val_0_2=(Token)match(input,RULE_FALSE,FOLLOW_2); 

                    					newLeafNode(lv_val_0_2, grammarAccess.getBooleanLiteralAccess().getValFALSETerminalRuleCall_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanLiteralRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"val",
                    						lv_val_0_2,
                    						"org.mofgen.MGLang.FALSE");
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanLiteral"


    // $ANTLR start "entryRuleStringLiteral"
    // InternalMGLang.g:3652:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalMGLang.g:3652:54: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalMGLang.g:3653:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
             newCompositeNode(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;

             current =iv_ruleStringLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // InternalMGLang.g:3659:1: ruleStringLiteral returns [EObject current=null] : ( (lv_val_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;


        	enterRule();

        try {
            // InternalMGLang.g:3665:2: ( ( (lv_val_0_0= RULE_STRING ) ) )
            // InternalMGLang.g:3666:2: ( (lv_val_0_0= RULE_STRING ) )
            {
            // InternalMGLang.g:3666:2: ( (lv_val_0_0= RULE_STRING ) )
            // InternalMGLang.g:3667:3: (lv_val_0_0= RULE_STRING )
            {
            // InternalMGLang.g:3667:3: (lv_val_0_0= RULE_STRING )
            // InternalMGLang.g:3668:4: lv_val_0_0= RULE_STRING
            {
            lv_val_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            				newLeafNode(lv_val_0_0, grammarAccess.getStringLiteralAccess().getValSTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getStringLiteralRule());
            				}
            				setWithLastConsumed(
            					current,
            					"val",
            					lv_val_0_0,
            					"org.eclipse.xtext.common.Terminals.STRING");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "entryRuleNumberLiteral"
    // InternalMGLang.g:3687:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // InternalMGLang.g:3687:54: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // InternalMGLang.g:3688:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
            {
             newCompositeNode(grammarAccess.getNumberLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumberLiteral=ruleNumberLiteral();

            state._fsp--;

             current =iv_ruleNumberLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumberLiteral"


    // $ANTLR start "ruleNumberLiteral"
    // InternalMGLang.g:3694:1: ruleNumberLiteral returns [EObject current=null] : ( (lv_val_0_0= RULE_DOUBLE ) ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;


        	enterRule();

        try {
            // InternalMGLang.g:3700:2: ( ( (lv_val_0_0= RULE_DOUBLE ) ) )
            // InternalMGLang.g:3701:2: ( (lv_val_0_0= RULE_DOUBLE ) )
            {
            // InternalMGLang.g:3701:2: ( (lv_val_0_0= RULE_DOUBLE ) )
            // InternalMGLang.g:3702:3: (lv_val_0_0= RULE_DOUBLE )
            {
            // InternalMGLang.g:3702:3: (lv_val_0_0= RULE_DOUBLE )
            // InternalMGLang.g:3703:4: lv_val_0_0= RULE_DOUBLE
            {
            lv_val_0_0=(Token)match(input,RULE_DOUBLE,FOLLOW_2); 

            				newLeafNode(lv_val_0_0, grammarAccess.getNumberLiteralAccess().getValDOUBLETerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getNumberLiteralRule());
            				}
            				setWithLastConsumed(
            					current,
            					"val",
            					lv_val_0_0,
            					"org.mofgen.MGLang.DOUBLE");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumberLiteral"


    // $ANTLR start "ruleMathFunc"
    // InternalMGLang.g:3722:1: ruleMathFunc returns [Enumerator current=null] : ( (enumLiteral_0= 'sqrt' ) | (enumLiteral_1= 'abs' ) ) ;
    public final Enumerator ruleMathFunc() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMGLang.g:3728:2: ( ( (enumLiteral_0= 'sqrt' ) | (enumLiteral_1= 'abs' ) ) )
            // InternalMGLang.g:3729:2: ( (enumLiteral_0= 'sqrt' ) | (enumLiteral_1= 'abs' ) )
            {
            // InternalMGLang.g:3729:2: ( (enumLiteral_0= 'sqrt' ) | (enumLiteral_1= 'abs' ) )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==45) ) {
                alt52=1;
            }
            else if ( (LA52_0==46) ) {
                alt52=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // InternalMGLang.g:3730:3: (enumLiteral_0= 'sqrt' )
                    {
                    // InternalMGLang.g:3730:3: (enumLiteral_0= 'sqrt' )
                    // InternalMGLang.g:3731:4: enumLiteral_0= 'sqrt'
                    {
                    enumLiteral_0=(Token)match(input,45,FOLLOW_2); 

                    				current = grammarAccess.getMathFuncAccess().getSQRTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMathFuncAccess().getSQRTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMGLang.g:3738:3: (enumLiteral_1= 'abs' )
                    {
                    // InternalMGLang.g:3738:3: (enumLiteral_1= 'abs' )
                    // InternalMGLang.g:3739:4: enumLiteral_1= 'abs'
                    {
                    enumLiteral_1=(Token)match(input,46,FOLLOW_2); 

                    				current = grammarAccess.getMathFuncAccess().getABSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMathFuncAccess().getABSEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMathFunc"


    // $ANTLR start "rulePrimitiveType"
    // InternalMGLang.g:3749:1: rulePrimitiveType returns [Enumerator current=null] : ( (enumLiteral_0= 'int' ) | (enumLiteral_1= 'char' ) | (enumLiteral_2= 'double' ) | (enumLiteral_3= 'String' ) | (enumLiteral_4= 'boolean' ) ) ;
    public final Enumerator rulePrimitiveType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalMGLang.g:3755:2: ( ( (enumLiteral_0= 'int' ) | (enumLiteral_1= 'char' ) | (enumLiteral_2= 'double' ) | (enumLiteral_3= 'String' ) | (enumLiteral_4= 'boolean' ) ) )
            // InternalMGLang.g:3756:2: ( (enumLiteral_0= 'int' ) | (enumLiteral_1= 'char' ) | (enumLiteral_2= 'double' ) | (enumLiteral_3= 'String' ) | (enumLiteral_4= 'boolean' ) )
            {
            // InternalMGLang.g:3756:2: ( (enumLiteral_0= 'int' ) | (enumLiteral_1= 'char' ) | (enumLiteral_2= 'double' ) | (enumLiteral_3= 'String' ) | (enumLiteral_4= 'boolean' ) )
            int alt53=5;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt53=1;
                }
                break;
            case 48:
                {
                alt53=2;
                }
                break;
            case 49:
                {
                alt53=3;
                }
                break;
            case 50:
                {
                alt53=4;
                }
                break;
            case 51:
                {
                alt53=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // InternalMGLang.g:3757:3: (enumLiteral_0= 'int' )
                    {
                    // InternalMGLang.g:3757:3: (enumLiteral_0= 'int' )
                    // InternalMGLang.g:3758:4: enumLiteral_0= 'int'
                    {
                    enumLiteral_0=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getPrimitiveTypeAccess().getINTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPrimitiveTypeAccess().getINTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMGLang.g:3765:3: (enumLiteral_1= 'char' )
                    {
                    // InternalMGLang.g:3765:3: (enumLiteral_1= 'char' )
                    // InternalMGLang.g:3766:4: enumLiteral_1= 'char'
                    {
                    enumLiteral_1=(Token)match(input,48,FOLLOW_2); 

                    				current = grammarAccess.getPrimitiveTypeAccess().getCHAREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getPrimitiveTypeAccess().getCHAREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMGLang.g:3773:3: (enumLiteral_2= 'double' )
                    {
                    // InternalMGLang.g:3773:3: (enumLiteral_2= 'double' )
                    // InternalMGLang.g:3774:4: enumLiteral_2= 'double'
                    {
                    enumLiteral_2=(Token)match(input,49,FOLLOW_2); 

                    				current = grammarAccess.getPrimitiveTypeAccess().getDOUBLEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getPrimitiveTypeAccess().getDOUBLEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMGLang.g:3781:3: (enumLiteral_3= 'String' )
                    {
                    // InternalMGLang.g:3781:3: (enumLiteral_3= 'String' )
                    // InternalMGLang.g:3782:4: enumLiteral_3= 'String'
                    {
                    enumLiteral_3=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getPrimitiveTypeAccess().getSTRINGEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getPrimitiveTypeAccess().getSTRINGEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMGLang.g:3789:3: (enumLiteral_4= 'boolean' )
                    {
                    // InternalMGLang.g:3789:3: (enumLiteral_4= 'boolean' )
                    // InternalMGLang.g:3790:4: enumLiteral_4= 'boolean'
                    {
                    enumLiteral_4=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getPrimitiveTypeAccess().getBOOLEANEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getPrimitiveTypeAccess().getBOOLEANEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimitiveType"


    // $ANTLR start "ruleRelationalOp"
    // InternalMGLang.g:3800:1: ruleRelationalOp returns [Enumerator current=null] : ( (enumLiteral_0= '>' ) | (enumLiteral_1= '>=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<=' ) | (enumLiteral_5= '<' ) ) ;
    public final Enumerator ruleRelationalOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalMGLang.g:3806:2: ( ( (enumLiteral_0= '>' ) | (enumLiteral_1= '>=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<=' ) | (enumLiteral_5= '<' ) ) )
            // InternalMGLang.g:3807:2: ( (enumLiteral_0= '>' ) | (enumLiteral_1= '>=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<=' ) | (enumLiteral_5= '<' ) )
            {
            // InternalMGLang.g:3807:2: ( (enumLiteral_0= '>' ) | (enumLiteral_1= '>=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<=' ) | (enumLiteral_5= '<' ) )
            int alt54=6;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt54=1;
                }
                break;
            case 53:
                {
                alt54=2;
                }
                break;
            case 54:
                {
                alt54=3;
                }
                break;
            case 55:
                {
                alt54=4;
                }
                break;
            case 56:
                {
                alt54=5;
                }
                break;
            case 57:
                {
                alt54=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // InternalMGLang.g:3808:3: (enumLiteral_0= '>' )
                    {
                    // InternalMGLang.g:3808:3: (enumLiteral_0= '>' )
                    // InternalMGLang.g:3809:4: enumLiteral_0= '>'
                    {
                    enumLiteral_0=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getRelationalOpAccess().getGREATEREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getRelationalOpAccess().getGREATEREnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMGLang.g:3816:3: (enumLiteral_1= '>=' )
                    {
                    // InternalMGLang.g:3816:3: (enumLiteral_1= '>=' )
                    // InternalMGLang.g:3817:4: enumLiteral_1= '>='
                    {
                    enumLiteral_1=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getRelationalOpAccess().getGREATER_OR_EQUALEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getRelationalOpAccess().getGREATER_OR_EQUALEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMGLang.g:3824:3: (enumLiteral_2= '==' )
                    {
                    // InternalMGLang.g:3824:3: (enumLiteral_2= '==' )
                    // InternalMGLang.g:3825:4: enumLiteral_2= '=='
                    {
                    enumLiteral_2=(Token)match(input,54,FOLLOW_2); 

                    				current = grammarAccess.getRelationalOpAccess().getEQUALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getRelationalOpAccess().getEQUALEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMGLang.g:3832:3: (enumLiteral_3= '!=' )
                    {
                    // InternalMGLang.g:3832:3: (enumLiteral_3= '!=' )
                    // InternalMGLang.g:3833:4: enumLiteral_3= '!='
                    {
                    enumLiteral_3=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getRelationalOpAccess().getUNEQUALEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getRelationalOpAccess().getUNEQUALEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMGLang.g:3840:3: (enumLiteral_4= '<=' )
                    {
                    // InternalMGLang.g:3840:3: (enumLiteral_4= '<=' )
                    // InternalMGLang.g:3841:4: enumLiteral_4= '<='
                    {
                    enumLiteral_4=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getRelationalOpAccess().getLESS_OR_EQUALEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getRelationalOpAccess().getLESS_OR_EQUALEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalMGLang.g:3848:3: (enumLiteral_5= '<' )
                    {
                    // InternalMGLang.g:3848:3: (enumLiteral_5= '<' )
                    // InternalMGLang.g:3849:4: enumLiteral_5= '<'
                    {
                    enumLiteral_5=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getRelationalOpAccess().getLESSEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getRelationalOpAccess().getLESSEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationalOp"


    // $ANTLR start "ruleTertiaryOp"
    // InternalMGLang.g:3859:1: ruleTertiaryOp returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '||' ) ) ;
    public final Enumerator ruleTertiaryOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMGLang.g:3865:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '||' ) ) )
            // InternalMGLang.g:3866:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '||' ) )
            {
            // InternalMGLang.g:3866:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '||' ) )
            int alt55=3;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt55=1;
                }
                break;
            case 34:
                {
                alt55=2;
                }
                break;
            case 59:
                {
                alt55=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // InternalMGLang.g:3867:3: (enumLiteral_0= '+' )
                    {
                    // InternalMGLang.g:3867:3: (enumLiteral_0= '+' )
                    // InternalMGLang.g:3868:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,58,FOLLOW_2); 

                    				current = grammarAccess.getTertiaryOpAccess().getPLUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getTertiaryOpAccess().getPLUSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMGLang.g:3875:3: (enumLiteral_1= '-' )
                    {
                    // InternalMGLang.g:3875:3: (enumLiteral_1= '-' )
                    // InternalMGLang.g:3876:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,34,FOLLOW_2); 

                    				current = grammarAccess.getTertiaryOpAccess().getMINUSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getTertiaryOpAccess().getMINUSEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMGLang.g:3883:3: (enumLiteral_2= '||' )
                    {
                    // InternalMGLang.g:3883:3: (enumLiteral_2= '||' )
                    // InternalMGLang.g:3884:4: enumLiteral_2= '||'
                    {
                    enumLiteral_2=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getTertiaryOpAccess().getOREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getTertiaryOpAccess().getOREnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTertiaryOp"


    // $ANTLR start "ruleSecondaryOp"
    // InternalMGLang.g:3894:1: ruleSecondaryOp returns [Enumerator current=null] : ( (enumLiteral_0= '%' ) | (enumLiteral_1= '^' ) ) ;
    public final Enumerator ruleSecondaryOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMGLang.g:3900:2: ( ( (enumLiteral_0= '%' ) | (enumLiteral_1= '^' ) ) )
            // InternalMGLang.g:3901:2: ( (enumLiteral_0= '%' ) | (enumLiteral_1= '^' ) )
            {
            // InternalMGLang.g:3901:2: ( (enumLiteral_0= '%' ) | (enumLiteral_1= '^' ) )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==60) ) {
                alt56=1;
            }
            else if ( (LA56_0==61) ) {
                alt56=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // InternalMGLang.g:3902:3: (enumLiteral_0= '%' )
                    {
                    // InternalMGLang.g:3902:3: (enumLiteral_0= '%' )
                    // InternalMGLang.g:3903:4: enumLiteral_0= '%'
                    {
                    enumLiteral_0=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getSecondaryOpAccess().getMODEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getSecondaryOpAccess().getMODEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMGLang.g:3910:3: (enumLiteral_1= '^' )
                    {
                    // InternalMGLang.g:3910:3: (enumLiteral_1= '^' )
                    // InternalMGLang.g:3911:4: enumLiteral_1= '^'
                    {
                    enumLiteral_1=(Token)match(input,61,FOLLOW_2); 

                    				current = grammarAccess.getSecondaryOpAccess().getXOREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getSecondaryOpAccess().getXOREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSecondaryOp"


    // $ANTLR start "rulePrimaryOp"
    // InternalMGLang.g:3921:1: rulePrimaryOp returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '&&' ) ) ;
    public final Enumerator rulePrimaryOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMGLang.g:3927:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '&&' ) ) )
            // InternalMGLang.g:3928:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '&&' ) )
            {
            // InternalMGLang.g:3928:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '&&' ) )
            int alt57=3;
            switch ( input.LA(1) ) {
            case 62:
                {
                alt57=1;
                }
                break;
            case 63:
                {
                alt57=2;
                }
                break;
            case 64:
                {
                alt57=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // InternalMGLang.g:3929:3: (enumLiteral_0= '*' )
                    {
                    // InternalMGLang.g:3929:3: (enumLiteral_0= '*' )
                    // InternalMGLang.g:3930:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,62,FOLLOW_2); 

                    				current = grammarAccess.getPrimaryOpAccess().getMULEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPrimaryOpAccess().getMULEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMGLang.g:3937:3: (enumLiteral_1= '/' )
                    {
                    // InternalMGLang.g:3937:3: (enumLiteral_1= '/' )
                    // InternalMGLang.g:3938:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,63,FOLLOW_2); 

                    				current = grammarAccess.getPrimaryOpAccess().getDIVEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getPrimaryOpAccess().getDIVEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMGLang.g:3945:3: (enumLiteral_2= '&&' )
                    {
                    // InternalMGLang.g:3945:3: (enumLiteral_2= '&&' )
                    // InternalMGLang.g:3946:4: enumLiteral_2= '&&'
                    {
                    enumLiteral_2=(Token)match(input,64,FOLLOW_2); 

                    				current = grammarAccess.getPrimaryOpAccess().getANDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getPrimaryOpAccess().getANDEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryOp"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000041000002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x000F800000100020L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000002100000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x000F800000000020L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000090800400020L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000200042L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000700000180730L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000700000080730L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000010080002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000090980400020L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000090980000022L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000005000400000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000090900200020L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x000000A000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000090900600020L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000020000000020L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000040002000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0C00000400000002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0xC000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x03F0000000000002L});

}