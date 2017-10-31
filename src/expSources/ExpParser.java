package expSources;// Generated from C:/Users/micha/IdeaProjects/Test/src\Exp.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, IDENT=42, NUMBER=43, BOOLVALUE=44, WhiteSpace=45, 
		NewLine=46;
	public static final int
		RULE_program = 0, RULE_block = 1, RULE_var = 2, RULE_statement = 3, RULE_retrn = 4, 
		RULE_forStatement = 5, RULE_cas = 6, RULE_defaultcas = 7, RULE_multipleAssigned = 8, 
		RULE_condition = 9, RULE_type = 10, RULE_expression = 11, RULE_term = 12, 
		RULE_factor = 13;
	public static final String[] ruleNames = {
		"program", "block", "var", "statement", "retrn", "forStatement", "cas", 
		"defaultcas", "multipleAssigned", "condition", "type", "expression", "term", 
		"factor"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "'function'", "'('", "','", "')'", "':'", "'void'", "';'", 
		"'const'", "':='", "'call'", "'begin'", "'end'", "'if'", "'then'", "'else'", 
		"'while'", "'do'", "'repeat'", "'until'", "'for'", "'switch'", "'{'", 
		"'}'", "'?'", "'='", "' return'", "'case'", "'break'", "'default'", "'#'", 
		"'<'", "'<='", "'>'", "'>='", "'boolean'", "' int'", "'+'", "'-'", "'*'", 
		"'/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "IDENT", "NUMBER", "BOOLVALUE", "WhiteSpace", 
		"NewLine"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Exp.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExpParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			block();
			setState(29);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<TerminalNode> IDENT() { return getTokens(ExpParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(ExpParser.IDENT, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			var();
			setState(56); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				match(T__1);
				setState(33);
				match(IDENT);
				setState(34);
				match(T__2);
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__35 || _la==T__36) {
					{
					setState(35);
					type();
					setState(36);
					match(IDENT);
					setState(43);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__3) {
						{
						{
						setState(37);
						match(T__3);
						setState(38);
						type();
						setState(39);
						match(IDENT);
						}
						}
						setState(45);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(48);
				match(T__4);
				setState(49);
				match(T__5);
				setState(52);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__35:
				case T__36:
					{
					setState(50);
					type();
					}
					break;
				case T__6:
					{
					setState(51);
					match(T__6);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(54);
				match(T__7);
				setState(55);
				var();
				}
				}
				setState(58); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__1 );
			setState(60);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> IDENT() { return getTokens(ExpParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(ExpParser.IDENT, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(ExpParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(ExpParser.NUMBER, i);
		}
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(62);
				match(T__8);
				setState(63);
				type();
				setState(64);
				match(IDENT);
				setState(65);
				match(T__9);
				setState(66);
				match(NUMBER);
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(67);
					match(T__3);
					setState(68);
					match(IDENT);
					setState(69);
					match(T__9);
					setState(70);
					match(NUMBER);
					}
					}
					setState(75);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(76);
				match(T__7);
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__35 || _la==T__36) {
				{
				{
				setState(83);
				type();
				setState(84);
				match(IDENT);
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(85);
					match(T__3);
					setState(86);
					match(IDENT);
					}
					}
					setState(91);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(92);
				match(T__7);
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(ExpParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(ExpParser.IDENT, i);
		}
		public MultipleAssignedContext multipleAssigned() {
			return getRuleContext(MultipleAssignedContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<TerminalNode> NUMBER() { return getTokens(ExpParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(ExpParser.NUMBER, i);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public DefaultcasContext defaultcas() {
			return getRuleContext(DefaultcasContext.class,0);
		}
		public List<CasContext> cas() {
			return getRuleContexts(CasContext.class);
		}
		public CasContext cas(int i) {
			return getRuleContext(CasContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> BOOLVALUE() { return getTokens(ExpParser.BOOLVALUE); }
		public TerminalNode BOOLVALUE(int i) {
			return getToken(ExpParser.BOOLVALUE, i);
		}
		public RetrnContext retrn() {
			return getRuleContext(RetrnContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				match(IDENT);
				setState(100);
				match(T__9);
				setState(101);
				multipleAssigned();
				setState(102);
				match(T__7);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				match(T__10);
				setState(105);
				match(IDENT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(106);
				match(T__11);
				setState(107);
				statement();
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(108);
					match(T__7);
					setState(109);
					statement();
					}
					}
					setState(114);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(115);
				match(T__12);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(117);
				match(T__13);
				setState(118);
				condition();
				setState(119);
				match(T__14);
				setState(121); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(120);
						statement();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(123); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(131);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(125);
					match(T__15);
					setState(127); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(126);
							statement();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(129); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(133);
				match(T__16);
				setState(134);
				match(T__2);
				setState(135);
				condition();
				setState(136);
				match(T__4);
				setState(137);
				match(T__17);
				setState(138);
				statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(140);
				match(T__18);
				setState(141);
				statement();
				setState(142);
				match(T__19);
				setState(143);
				match(T__2);
				setState(144);
				condition();
				setState(145);
				match(T__4);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(147);
				match(T__17);
				setState(148);
				statement();
				setState(149);
				match(T__16);
				setState(150);
				match(T__2);
				setState(151);
				condition();
				setState(152);
				match(T__4);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(154);
				match(T__20);
				setState(155);
				match(T__2);
				setState(156);
				match(IDENT);
				setState(157);
				match(T__9);
				setState(158);
				match(NUMBER);
				setState(159);
				match(T__7);
				setState(160);
				condition();
				setState(161);
				match(T__7);
				setState(162);
				forStatement();
				setState(163);
				match(T__4);
				setState(164);
				statement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(166);
				match(T__21);
				setState(167);
				match(T__2);
				setState(168);
				condition();
				setState(169);
				match(T__4);
				setState(170);
				match(T__22);
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__27) {
					{
					{
					setState(171);
					cas();
					}
					}
					setState(176);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(177);
				defaultcas();
				setState(178);
				match(T__23);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(180);
				match(IDENT);
				setState(181);
				match(T__9);
				setState(182);
				match(T__2);
				setState(183);
				condition();
				setState(184);
				match(T__4);
				setState(185);
				match(T__24);
				setState(186);
				expression();
				setState(187);
				match(T__5);
				setState(188);
				expression();
				setState(189);
				match(T__7);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(191);
				match(T__22);
				setState(192);
				match(IDENT);
				setState(195); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(193);
					match(T__3);
					setState(194);
					match(IDENT);
					}
					}
					setState(197); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__3 );
				setState(199);
				match(T__23);
				setState(200);
				match(T__25);
				setState(201);
				match(T__22);
				setState(202);
				_la = _input.LA(1);
				if ( !(_la==NUMBER || _la==BOOLVALUE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(205); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(203);
					match(T__3);
					setState(204);
					_la = _input.LA(1);
					if ( !(_la==NUMBER || _la==BOOLVALUE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(207); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__3 );
				setState(209);
				match(T__23);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(210);
				match(T__26);
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENT) {
					{
					setState(211);
					retrn();
					}
				}

				setState(214);
				match(T__7);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RetrnContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(ExpParser.IDENT, 0); }
		public RetrnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retrn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).enterRetrn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).exitRetrn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitRetrn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetrnContext retrn() throws RecognitionException {
		RetrnContext _localctx = new RetrnContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_retrn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(ExpParser.IDENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(IDENT);
			setState(220);
			match(T__9);
			setState(221);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CasContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ExpParser.NUMBER, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public CasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cas; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).enterCas(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).exitCas(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitCas(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CasContext cas() throws RecognitionException {
		CasContext _localctx = new CasContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cas);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(T__27);
			setState(224);
			match(NUMBER);
			setState(225);
			match(T__5);
			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__11) | (1L << T__13) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__26) | (1L << IDENT))) != 0)) {
				{
				{
				setState(226);
				statement();
				}
				}
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(232);
			match(T__28);
			setState(233);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefaultcasContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public DefaultcasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultcas; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).enterDefaultcas(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).exitDefaultcas(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitDefaultcas(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultcasContext defaultcas() throws RecognitionException {
		DefaultcasContext _localctx = new DefaultcasContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_defaultcas);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(T__29);
			setState(236);
			match(T__5);
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__11) | (1L << T__13) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__26) | (1L << IDENT))) != 0)) {
				{
				{
				setState(237);
				statement();
				}
				}
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(243);
			match(T__28);
			setState(244);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultipleAssignedContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(ExpParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(ExpParser.IDENT, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public MultipleAssignedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multipleAssigned; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).enterMultipleAssigned(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).exitMultipleAssigned(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitMultipleAssigned(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultipleAssignedContext multipleAssigned() throws RecognitionException {
		MultipleAssignedContext _localctx = new MultipleAssignedContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_multipleAssigned);
		int _la;
		try {
			setState(254);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENT) {
					{
					{
					setState(246);
					match(IDENT);
					setState(247);
					match(T__9);
					}
					}
					setState(252);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__37:
			case T__38:
				enterOuterAlt(_localctx, 2);
				{
				setState(253);
				expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			expression();
			setState(257);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__25) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(258);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			_la = _input.LA(1);
			if ( !(_la==T__35 || _la==T__36) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			_la = _input.LA(1);
			if ( !(_la==T__37 || _la==T__38) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(263);
			term();
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__37) | (1L << T__38) | (1L << IDENT) | (1L << NUMBER))) != 0)) {
				{
				{
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__37 || _la==T__38) {
					{
					{
					setState(264);
					_la = _input.LA(1);
					if ( !(_la==T__37 || _la==T__38) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(269);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(270);
				term();
				}
				}
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			factor();
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__39 || _la==T__40) {
				{
				{
				setState(277);
				_la = _input.LA(1);
				if ( !(_la==T__39 || _la==T__40) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(278);
				factor();
				}
				}
				setState(283);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(ExpParser.IDENT, 0); }
		public TerminalNode NUMBER() { return getToken(ExpParser.NUMBER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_factor);
		try {
			setState(290);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(284);
				match(IDENT);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				match(NUMBER);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(286);
				match(T__2);
				setState(287);
				expression();
				setState(288);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\60\u0127\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\7\3,\n\3\f\3\16\3/\13\3\5\3\61\n\3\3\3\3\3\3"+
		"\3\3\3\5\3\67\n\3\3\3\3\3\6\3;\n\3\r\3\16\3<\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\7\4J\n\4\f\4\16\4M\13\4\3\4\3\4\7\4Q\n\4\f\4\16\4T"+
		"\13\4\3\4\3\4\3\4\3\4\7\4Z\n\4\f\4\16\4]\13\4\3\4\3\4\7\4a\n\4\f\4\16"+
		"\4d\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5q\n\5\f\5\16\5"+
		"t\13\5\3\5\3\5\3\5\3\5\3\5\3\5\6\5|\n\5\r\5\16\5}\3\5\3\5\6\5\u0082\n"+
		"\5\r\5\16\5\u0083\5\5\u0086\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u00af\n\5\f\5\16"+
		"\5\u00b2\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\6\5\u00c6\n\5\r\5\16\5\u00c7\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\6\5\u00d0\n\5\r\5\16\5\u00d1\3\5\3\5\3\5\5\5\u00d7\n\5\3\5\5\5\u00da"+
		"\n\5\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\7\b\u00e6\n\b\f\b\16\b\u00e9"+
		"\13\b\3\b\3\b\3\b\3\t\3\t\3\t\7\t\u00f1\n\t\f\t\16\t\u00f4\13\t\3\t\3"+
		"\t\3\t\3\n\3\n\7\n\u00fb\n\n\f\n\16\n\u00fe\13\n\3\n\5\n\u0101\n\n\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\7\r\u010c\n\r\f\r\16\r\u010f\13\r"+
		"\3\r\7\r\u0112\n\r\f\r\16\r\u0115\13\r\3\16\3\16\3\16\7\16\u011a\n\16"+
		"\f\16\16\16\u011d\13\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0125\n\17"+
		"\3\17\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\7\3\2-.\4\2\34\34!"+
		"%\3\2&\'\3\2()\3\2*+\2\u013c\2\36\3\2\2\2\4!\3\2\2\2\6R\3\2\2\2\b\u00d9"+
		"\3\2\2\2\n\u00db\3\2\2\2\f\u00dd\3\2\2\2\16\u00e1\3\2\2\2\20\u00ed\3\2"+
		"\2\2\22\u0100\3\2\2\2\24\u0102\3\2\2\2\26\u0106\3\2\2\2\30\u0108\3\2\2"+
		"\2\32\u0116\3\2\2\2\34\u0124\3\2\2\2\36\37\5\4\3\2\37 \7\3\2\2 \3\3\2"+
		"\2\2!:\5\6\4\2\"#\7\4\2\2#$\7,\2\2$\60\7\5\2\2%&\5\26\f\2&-\7,\2\2\'("+
		"\7\6\2\2()\5\26\f\2)*\7,\2\2*,\3\2\2\2+\'\3\2\2\2,/\3\2\2\2-+\3\2\2\2"+
		"-.\3\2\2\2.\61\3\2\2\2/-\3\2\2\2\60%\3\2\2\2\60\61\3\2\2\2\61\62\3\2\2"+
		"\2\62\63\7\7\2\2\63\66\7\b\2\2\64\67\5\26\f\2\65\67\7\t\2\2\66\64\3\2"+
		"\2\2\66\65\3\2\2\2\678\3\2\2\289\7\n\2\29;\5\6\4\2:\"\3\2\2\2;<\3\2\2"+
		"\2<:\3\2\2\2<=\3\2\2\2=>\3\2\2\2>?\5\b\5\2?\5\3\2\2\2@A\7\13\2\2AB\5\26"+
		"\f\2BC\7,\2\2CD\7\f\2\2DK\7-\2\2EF\7\6\2\2FG\7,\2\2GH\7\f\2\2HJ\7-\2\2"+
		"IE\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2LN\3\2\2\2MK\3\2\2\2NO\7\n\2\2"+
		"OQ\3\2\2\2P@\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2Sb\3\2\2\2TR\3\2\2\2"+
		"UV\5\26\f\2V[\7,\2\2WX\7\6\2\2XZ\7,\2\2YW\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2"+
		"[\\\3\2\2\2\\^\3\2\2\2][\3\2\2\2^_\7\n\2\2_a\3\2\2\2`U\3\2\2\2ad\3\2\2"+
		"\2b`\3\2\2\2bc\3\2\2\2c\7\3\2\2\2db\3\2\2\2ef\7,\2\2fg\7\f\2\2gh\5\22"+
		"\n\2hi\7\n\2\2i\u00da\3\2\2\2jk\7\r\2\2k\u00da\7,\2\2lm\7\16\2\2mr\5\b"+
		"\5\2no\7\n\2\2oq\5\b\5\2pn\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2su\3\2"+
		"\2\2tr\3\2\2\2uv\7\17\2\2v\u00da\3\2\2\2wx\7\20\2\2xy\5\24\13\2y{\7\21"+
		"\2\2z|\5\b\5\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0085\3\2\2\2"+
		"\177\u0081\7\22\2\2\u0080\u0082\5\b\5\2\u0081\u0080\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0086\3\2\2\2\u0085"+
		"\177\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u00da\3\2\2\2\u0087\u0088\7\23"+
		"\2\2\u0088\u0089\7\5\2\2\u0089\u008a\5\24\13\2\u008a\u008b\7\7\2\2\u008b"+
		"\u008c\7\24\2\2\u008c\u008d\5\b\5\2\u008d\u00da\3\2\2\2\u008e\u008f\7"+
		"\25\2\2\u008f\u0090\5\b\5\2\u0090\u0091\7\26\2\2\u0091\u0092\7\5\2\2\u0092"+
		"\u0093\5\24\13\2\u0093\u0094\7\7\2\2\u0094\u00da\3\2\2\2\u0095\u0096\7"+
		"\24\2\2\u0096\u0097\5\b\5\2\u0097\u0098\7\23\2\2\u0098\u0099\7\5\2\2\u0099"+
		"\u009a\5\24\13\2\u009a\u009b\7\7\2\2\u009b\u00da\3\2\2\2\u009c\u009d\7"+
		"\27\2\2\u009d\u009e\7\5\2\2\u009e\u009f\7,\2\2\u009f\u00a0\7\f\2\2\u00a0"+
		"\u00a1\7-\2\2\u00a1\u00a2\7\n\2\2\u00a2\u00a3\5\24\13\2\u00a3\u00a4\7"+
		"\n\2\2\u00a4\u00a5\5\f\7\2\u00a5\u00a6\7\7\2\2\u00a6\u00a7\5\b\5\2\u00a7"+
		"\u00da\3\2\2\2\u00a8\u00a9\7\30\2\2\u00a9\u00aa\7\5\2\2\u00aa\u00ab\5"+
		"\24\13\2\u00ab\u00ac\7\7\2\2\u00ac\u00b0\7\31\2\2\u00ad\u00af\5\16\b\2"+
		"\u00ae\u00ad\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1"+
		"\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b4\5\20\t\2"+
		"\u00b4\u00b5\7\32\2\2\u00b5\u00da\3\2\2\2\u00b6\u00b7\7,\2\2\u00b7\u00b8"+
		"\7\f\2\2\u00b8\u00b9\7\5\2\2\u00b9\u00ba\5\24\13\2\u00ba\u00bb\7\7\2\2"+
		"\u00bb\u00bc\7\33\2\2\u00bc\u00bd\5\30\r\2\u00bd\u00be\7\b\2\2\u00be\u00bf"+
		"\5\30\r\2\u00bf\u00c0\7\n\2\2\u00c0\u00da\3\2\2\2\u00c1\u00c2\7\31\2\2"+
		"\u00c2\u00c5\7,\2\2\u00c3\u00c4\7\6\2\2\u00c4\u00c6\7,\2\2\u00c5\u00c3"+
		"\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\u00ca\7\32\2\2\u00ca\u00cb\7\34\2\2\u00cb\u00cc\7"+
		"\31\2\2\u00cc\u00cf\t\2\2\2\u00cd\u00ce\7\6\2\2\u00ce\u00d0\t\2\2\2\u00cf"+
		"\u00cd\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2"+
		"\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00da\7\32\2\2\u00d4\u00d6\7\35\2\2\u00d5"+
		"\u00d7\5\n\6\2\u00d6\u00d5\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\3\2"+
		"\2\2\u00d8\u00da\7\n\2\2\u00d9e\3\2\2\2\u00d9j\3\2\2\2\u00d9l\3\2\2\2"+
		"\u00d9w\3\2\2\2\u00d9\u0087\3\2\2\2\u00d9\u008e\3\2\2\2\u00d9\u0095\3"+
		"\2\2\2\u00d9\u009c\3\2\2\2\u00d9\u00a8\3\2\2\2\u00d9\u00b6\3\2\2\2\u00d9"+
		"\u00c1\3\2\2\2\u00d9\u00d4\3\2\2\2\u00da\t\3\2\2\2\u00db\u00dc\7,\2\2"+
		"\u00dc\13\3\2\2\2\u00dd\u00de\7,\2\2\u00de\u00df\7\f\2\2\u00df\u00e0\5"+
		"\30\r\2\u00e0\r\3\2\2\2\u00e1\u00e2\7\36\2\2\u00e2\u00e3\7-\2\2\u00e3"+
		"\u00e7\7\b\2\2\u00e4\u00e6\5\b\5\2\u00e5\u00e4\3\2\2\2\u00e6\u00e9\3\2"+
		"\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00ea\3\2\2\2\u00e9"+
		"\u00e7\3\2\2\2\u00ea\u00eb\7\37\2\2\u00eb\u00ec\7\n\2\2\u00ec\17\3\2\2"+
		"\2\u00ed\u00ee\7 \2\2\u00ee\u00f2\7\b\2\2\u00ef\u00f1\5\b\5\2\u00f0\u00ef"+
		"\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3"+
		"\u00f5\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f6\7\37\2\2\u00f6\u00f7\7"+
		"\n\2\2\u00f7\21\3\2\2\2\u00f8\u00f9\7,\2\2\u00f9\u00fb\7\f\2\2\u00fa\u00f8"+
		"\3\2\2\2\u00fb\u00fe\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\u0101\3\2\2\2\u00fe\u00fc\3\2\2\2\u00ff\u0101\5\30\r\2\u0100\u00fc\3"+
		"\2\2\2\u0100\u00ff\3\2\2\2\u0101\23\3\2\2\2\u0102\u0103\5\30\r\2\u0103"+
		"\u0104\t\3\2\2\u0104\u0105\5\30\r\2\u0105\25\3\2\2\2\u0106\u0107\t\4\2"+
		"\2\u0107\27\3\2\2\2\u0108\u0109\t\5\2\2\u0109\u0113\5\32\16\2\u010a\u010c"+
		"\t\5\2\2\u010b\u010a\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d"+
		"\u010e\3\2\2\2\u010e\u0110\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0112\5\32"+
		"\16\2\u0111\u010d\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0111\3\2\2\2\u0113"+
		"\u0114\3\2\2\2\u0114\31\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u011b\5\34\17"+
		"\2\u0117\u0118\t\6\2\2\u0118\u011a\5\34\17\2\u0119\u0117\3\2\2\2\u011a"+
		"\u011d\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\33\3\2\2"+
		"\2\u011d\u011b\3\2\2\2\u011e\u0125\7,\2\2\u011f\u0125\7-\2\2\u0120\u0121"+
		"\7\5\2\2\u0121\u0122\5\30\r\2\u0122\u0123\7\7\2\2\u0123\u0125\3\2\2\2"+
		"\u0124\u011e\3\2\2\2\u0124\u011f\3\2\2\2\u0124\u0120\3\2\2\2\u0125\35"+
		"\3\2\2\2\33-\60\66<KR[br}\u0083\u0085\u00b0\u00c7\u00d1\u00d6\u00d9\u00e7"+
		"\u00f2\u00fc\u0100\u010d\u0113\u011b\u0124";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}