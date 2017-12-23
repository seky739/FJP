// Generated from /home/vnkid/Workspace/seky/FJP/src/Exp.g4 by ANTLR 4.7
package expSources;
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
		T__24=25, T__25=26, BOOLVALUE=27, TYPE=28, COMPARATOR=29, PREOPERATION=30, 
		BOOLOPERATION=31, MULDIV=32, ASSIGN=33, END_STATEMENT=34, NEGATION=35, 
		IDENT=36, NUMBER=37, WS=38;
	public static final int
		RULE_program = 0, RULE_block = 1, RULE_variableDef = 2, RULE_variableConst = 3, 
		RULE_variableValue = 4, RULE_method = 5, RULE_parameter = 6, RULE_returnParam = 7, 
		RULE_statement = 8, RULE_forStatement = 9, RULE_whileStatement = 10, RULE_doWhileStatement = 11, 
		RULE_repeatStatement = 12, RULE_ifCondition = 13, RULE_switchStatement = 14, 
		RULE_ternaryOperation = 15, RULE_callStatement = 16, RULE_elseStatement = 17, 
		RULE_callParam = 18, RULE_assignment = 19, RULE_multipleAssignment = 20, 
		RULE_paralelAssignment = 21, RULE_cas = 22, RULE_defaultcas = 23, RULE_retrn = 24, 
		RULE_unaryOperation = 25, RULE_unaryOperator = 26, RULE_condition = 27, 
		RULE_expression = 28, RULE_term = 29, RULE_factor = 30;
	public static final String[] ruleNames = {
		"program", "block", "variableDef", "variableConst", "variableValue", "method", 
		"parameter", "returnParam", "statement", "forStatement", "whileStatement", 
		"doWhileStatement", "repeatStatement", "ifCondition", "switchStatement", 
		"ternaryOperation", "callStatement", "elseStatement", "callParam", "assignment", 
		"multipleAssignment", "paralelAssignment", "cas", "defaultcas", "retrn", 
		"unaryOperation", "unaryOperator", "condition", "expression", "term", 
		"factor"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "'const'", "'function'", "'('", "','", "')'", "':'", "'{'", 
		"'}'", "'void'", "'for'", "'while'", "'do'", "'repeat'", "'until'", "'if'", 
		"'switch'", "'?'", "'call'", "'else'", "'case'", "'break'", "'default'", 
		"'return'", "'++'", "'--'", null, null, null, null, null, null, "':='", 
		"';'", "'!'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "BOOLVALUE", "TYPE", "COMPARATOR", "PREOPERATION", "BOOLOPERATION", 
		"MULDIV", "ASSIGN", "END_STATEMENT", "NEGATION", "IDENT", "NUMBER", "WS"
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
			setState(62);
			block();
			setState(63);
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
		public List<VariableDefContext> variableDef() {
			return getRuleContexts(VariableDefContext.class);
		}
		public VariableDefContext variableDef(int i) {
			return getRuleContext(VariableDefContext.class,i);
		}
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
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
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==TYPE) {
				{
				{
				setState(65);
				variableDef();
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(71);
				method();
				}
				}
				setState(74); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 );
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

	public static class VariableDefContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(ExpParser.TYPE, 0); }
		public TerminalNode IDENT() { return getToken(ExpParser.IDENT, 0); }
		public TerminalNode END_STATEMENT() { return getToken(ExpParser.END_STATEMENT, 0); }
		public VariableConstContext variableConst() {
			return getRuleContext(VariableConstContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(ExpParser.ASSIGN, 0); }
		public VariableValueContext variableValue() {
			return getRuleContext(VariableValueContext.class,0);
		}
		public VariableDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitVariableDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDefContext variableDef() throws RecognitionException {
		VariableDefContext _localctx = new VariableDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_variableDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(76);
				variableConst();
				}
			}

			setState(79);
			match(TYPE);
			setState(80);
			match(IDENT);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(81);
				match(ASSIGN);
				setState(82);
				variableValue();
				}
			}

			setState(85);
			match(END_STATEMENT);
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

	public static class VariableConstContext extends ParserRuleContext {
		public VariableConstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableConst; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitVariableConst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableConstContext variableConst() throws RecognitionException {
		VariableConstContext _localctx = new VariableConstContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variableConst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__1);
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

	public static class VariableValueContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ExpParser.NUMBER, 0); }
		public TerminalNode BOOLVALUE() { return getToken(ExpParser.BOOLVALUE, 0); }
		public VariableValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitVariableValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableValueContext variableValue() throws RecognitionException {
		VariableValueContext _localctx = new VariableValueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variableValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_la = _input.LA(1);
			if ( !(_la==BOOLVALUE || _la==NUMBER) ) {
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

	public static class MethodContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(ExpParser.IDENT, 0); }
		public ReturnParamContext returnParam() {
			return getRuleContext(ReturnParamContext.class,0);
		}
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<VariableDefContext> variableDef() {
			return getRuleContexts(VariableDefContext.class);
		}
		public VariableDefContext variableDef(int i) {
			return getRuleContext(VariableDefContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(T__2);
			setState(92);
			match(IDENT);
			setState(93);
			match(T__3);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(94);
				parameter();
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(95);
					match(T__4);
					setState(96);
					parameter();
					}
					}
					setState(101);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(104);
			match(T__5);
			setState(105);
			match(T__6);
			setState(106);
			returnParam();
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==TYPE) {
				{
				{
				setState(107);
				variableDef();
				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(113);
			match(T__7);
			setState(115); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(114);
				statement();
				}
				}
				setState(117); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__23) | (1L << IDENT))) != 0) );
			setState(119);
			match(T__8);
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

	public static class ParameterContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(ExpParser.TYPE, 0); }
		public TerminalNode IDENT() { return getToken(ExpParser.IDENT, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(TYPE);
			setState(122);
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

	public static class ReturnParamContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(ExpParser.TYPE, 0); }
		public ReturnParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnParam; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitReturnParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnParamContext returnParam() throws RecognitionException {
		ReturnParamContext _localctx = new ReturnParamContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_returnParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_la = _input.LA(1);
			if ( !(_la==T__9 || _la==TYPE) ) {
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

	public static class StatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public CallStatementContext callStatement() {
			return getRuleContext(CallStatementContext.class,0);
		}
		public TerminalNode END_STATEMENT() { return getToken(ExpParser.END_STATEMENT, 0); }
		public IfConditionContext ifCondition() {
			return getRuleContext(IfConditionContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public RepeatStatementContext repeatStatement() {
			return getRuleContext(RepeatStatementContext.class,0);
		}
		public DoWhileStatementContext doWhileStatement() {
			return getRuleContext(DoWhileStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public SwitchStatementContext switchStatement() {
			return getRuleContext(SwitchStatementContext.class,0);
		}
		public TernaryOperationContext ternaryOperation() {
			return getRuleContext(TernaryOperationContext.class,0);
		}
		public ParalelAssignmentContext paralelAssignment() {
			return getRuleContext(ParalelAssignmentContext.class,0);
		}
		public RetrnContext retrn() {
			return getRuleContext(RetrnContext.class,0);
		}
		public UnaryOperationContext unaryOperation() {
			return getRuleContext(UnaryOperationContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		try {
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				callStatement();
				setState(128);
				match(END_STATEMENT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(130);
				ifCondition();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(131);
				whileStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(132);
				repeatStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(133);
				doWhileStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(134);
				forStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(135);
				switchStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(136);
				ternaryOperation();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(137);
				paralelAssignment();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(138);
				retrn();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(139);
				unaryOperation();
				setState(140);
				match(END_STATEMENT);
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

	public static class ForStatementContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public UnaryOperationContext unaryOperation() {
			return getRuleContext(UnaryOperationContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(T__10);
			setState(145);
			match(T__3);
			setState(146);
			condition();
			setState(147);
			match(END_STATEMENT);
			setState(148);
			unaryOperation();
			setState(149);
			match(T__5);
			setState(150);
			match(T__7);
			setState(152); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(151);
				statement();
				}
				}
				setState(154); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__23) | (1L << IDENT))) != 0) );
			setState(156);
			match(T__8);
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

	public static class WhileStatementContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_whileStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(T__11);
			setState(159);
			match(T__3);
			setState(160);
			condition();
			setState(161);
			match(T__5);
			setState(162);
			match(T__12);
			setState(163);
			match(T__7);
			setState(165); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(164);
				statement();
				}
				}
				setState(167); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__23) | (1L << IDENT))) != 0) );
			setState(169);
			match(T__8);
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

	public static class DoWhileStatementContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode END_STATEMENT() { return getToken(ExpParser.END_STATEMENT, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public DoWhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitDoWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoWhileStatementContext doWhileStatement() throws RecognitionException {
		DoWhileStatementContext _localctx = new DoWhileStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_doWhileStatement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(T__12);
			setState(173); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(172);
					statement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(175); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(177);
			match(T__11);
			setState(178);
			match(T__3);
			setState(179);
			condition();
			setState(180);
			match(T__5);
			setState(181);
			match(END_STATEMENT);
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

	public static class RepeatStatementContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode END_STATEMENT() { return getToken(ExpParser.END_STATEMENT, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public RepeatStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitRepeatStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatStatementContext repeatStatement() throws RecognitionException {
		RepeatStatementContext _localctx = new RepeatStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_repeatStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(T__13);
			setState(184);
			match(T__7);
			setState(186); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(185);
				statement();
				}
				}
				setState(188); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__23) | (1L << IDENT))) != 0) );
			setState(190);
			match(T__8);
			setState(191);
			match(T__14);
			setState(192);
			match(T__3);
			setState(193);
			condition();
			setState(194);
			match(T__5);
			setState(195);
			match(END_STATEMENT);
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

	public static class IfConditionContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public IfConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifCondition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitIfCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfConditionContext ifCondition() throws RecognitionException {
		IfConditionContext _localctx = new IfConditionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ifCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(T__15);
			setState(198);
			match(T__3);
			setState(199);
			condition();
			setState(200);
			match(T__5);
			setState(201);
			match(T__7);
			setState(203); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(202);
				statement();
				}
				}
				setState(205); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__23) | (1L << IDENT))) != 0) );
			setState(207);
			match(T__8);
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19) {
				{
				setState(208);
				elseStatement();
				}
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

	public static class SwitchStatementContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(ExpParser.IDENT, 0); }
		public DefaultcasContext defaultcas() {
			return getRuleContext(DefaultcasContext.class,0);
		}
		public List<CasContext> cas() {
			return getRuleContexts(CasContext.class);
		}
		public CasContext cas(int i) {
			return getRuleContext(CasContext.class,i);
		}
		public SwitchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitSwitchStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchStatementContext switchStatement() throws RecognitionException {
		SwitchStatementContext _localctx = new SwitchStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_switchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(T__16);
			setState(212);
			match(T__3);
			setState(213);
			match(IDENT);
			setState(214);
			match(T__5);
			setState(215);
			match(T__7);
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__20) {
				{
				{
				setState(216);
				cas();
				}
				}
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(222);
			defaultcas();
			setState(223);
			match(T__8);
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

	public static class TernaryOperationContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(ExpParser.IDENT, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode END_STATEMENT() { return getToken(ExpParser.END_STATEMENT, 0); }
		public TernaryOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ternaryOperation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitTernaryOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TernaryOperationContext ternaryOperation() throws RecognitionException {
		TernaryOperationContext _localctx = new TernaryOperationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ternaryOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(IDENT);
			setState(226);
			match(ASSIGN);
			setState(227);
			match(T__3);
			setState(228);
			condition();
			setState(229);
			match(T__5);
			setState(230);
			match(T__17);
			setState(231);
			expression();
			setState(232);
			match(T__6);
			setState(233);
			expression();
			setState(234);
			match(END_STATEMENT);
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

	public static class CallStatementContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(ExpParser.IDENT, 0); }
		public CallParamContext callParam() {
			return getRuleContext(CallParamContext.class,0);
		}
		public CallStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitCallStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallStatementContext callStatement() throws RecognitionException {
		CallStatementContext _localctx = new CallStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_callStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(T__18);
			setState(237);
			match(IDENT);
			setState(238);
			match(T__3);
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(239);
				callParam();
				}
			}

			setState(242);
			match(T__5);
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

	public static class ElseStatementContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_elseStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(T__19);
			setState(245);
			match(T__7);
			setState(247); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(246);
				statement();
				}
				}
				setState(249); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__23) | (1L << IDENT))) != 0) );
			setState(251);
			match(T__8);
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

	public static class CallParamContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(ExpParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(ExpParser.IDENT, i);
		}
		public CallParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callParam; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitCallParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallParamContext callParam() throws RecognitionException {
		CallParamContext _localctx = new CallParamContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_callParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(253);
			match(IDENT);
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(254);
				match(T__4);
				setState(255);
				match(IDENT);
				}
				}
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(ExpParser.IDENT, 0); }
		public TerminalNode ASSIGN() { return getToken(ExpParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CallStatementContext callStatement() {
			return getRuleContext(CallStatementContext.class,0);
		}
		public List<MultipleAssignmentContext> multipleAssignment() {
			return getRuleContexts(MultipleAssignmentContext.class);
		}
		public MultipleAssignmentContext multipleAssignment(int i) {
			return getRuleContext(MultipleAssignmentContext.class,i);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_assignment);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(IDENT);
			setState(265);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(262);
					multipleAssignment();
					}
					} 
				}
				setState(267);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			setState(268);
			match(ASSIGN);
			setState(271);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(269);
				expression();
				}
				break;
			case 2:
				{
				setState(270);
				callStatement();
				}
				break;
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

	public static class MultipleAssignmentContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(ExpParser.ASSIGN, 0); }
		public TerminalNode IDENT() { return getToken(ExpParser.IDENT, 0); }
		public MultipleAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multipleAssignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitMultipleAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultipleAssignmentContext multipleAssignment() throws RecognitionException {
		MultipleAssignmentContext _localctx = new MultipleAssignmentContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_multipleAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(ASSIGN);
			setState(274);
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

	public static class ParalelAssignmentContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(ExpParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(ExpParser.IDENT, i);
		}
		public TerminalNode ASSIGN() { return getToken(ExpParser.ASSIGN, 0); }
		public TerminalNode END_STATEMENT() { return getToken(ExpParser.END_STATEMENT, 0); }
		public List<VariableValueContext> variableValue() {
			return getRuleContexts(VariableValueContext.class);
		}
		public VariableValueContext variableValue(int i) {
			return getRuleContext(VariableValueContext.class,i);
		}
		public ParalelAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paralelAssignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitParalelAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParalelAssignmentContext paralelAssignment() throws RecognitionException {
		ParalelAssignmentContext _localctx = new ParalelAssignmentContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_paralelAssignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(T__7);
			setState(277);
			match(IDENT);
			setState(280); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(278);
				match(T__4);
				setState(279);
				match(IDENT);
				}
				}
				setState(282); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			setState(284);
			match(T__8);
			setState(285);
			match(ASSIGN);
			setState(286);
			match(T__7);
			{
			setState(287);
			variableValue();
			}
			setState(290); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(288);
				match(T__4);
				{
				setState(289);
				variableValue();
				}
				}
				}
				setState(292); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			setState(294);
			match(T__8);
			setState(295);
			match(END_STATEMENT);
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
		public TerminalNode END_STATEMENT() { return getToken(ExpParser.END_STATEMENT, 0); }
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitCas(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CasContext cas() throws RecognitionException {
		CasContext _localctx = new CasContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_cas);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			match(T__20);
			setState(298);
			match(NUMBER);
			setState(299);
			match(T__6);
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__23) | (1L << IDENT))) != 0)) {
				{
				{
				setState(300);
				statement();
				}
				}
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(306);
			match(T__21);
			setState(307);
			match(END_STATEMENT);
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
		public TerminalNode END_STATEMENT() { return getToken(ExpParser.END_STATEMENT, 0); }
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitDefaultcas(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultcasContext defaultcas() throws RecognitionException {
		DefaultcasContext _localctx = new DefaultcasContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_defaultcas);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			match(T__22);
			setState(310);
			match(T__6);
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__23) | (1L << IDENT))) != 0)) {
				{
				{
				setState(311);
				statement();
				}
				}
				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(317);
			match(T__21);
			setState(318);
			match(END_STATEMENT);
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
		public TerminalNode END_STATEMENT() { return getToken(ExpParser.END_STATEMENT, 0); }
		public TerminalNode IDENT() { return getToken(ExpParser.IDENT, 0); }
		public RetrnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retrn; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitRetrn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetrnContext retrn() throws RecognitionException {
		RetrnContext _localctx = new RetrnContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_retrn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(T__23);
			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(321);
				match(IDENT);
				}
			}

			setState(324);
			match(END_STATEMENT);
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

	public static class UnaryOperationContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(ExpParser.IDENT, 0); }
		public UnaryOperatorContext unaryOperator() {
			return getRuleContext(UnaryOperatorContext.class,0);
		}
		public UnaryOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOperation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitUnaryOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOperationContext unaryOperation() throws RecognitionException {
		UnaryOperationContext _localctx = new UnaryOperationContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_unaryOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			match(IDENT);
			setState(327);
			unaryOperator();
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

	public static class UnaryOperatorContext extends ParserRuleContext {
		public UnaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitUnaryOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOperatorContext unaryOperator() throws RecognitionException {
		UnaryOperatorContext _localctx = new UnaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_unaryOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			_la = _input.LA(1);
			if ( !(_la==T__24 || _la==T__25) ) {
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

	public static class ConditionContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMPARATOR() { return getToken(ExpParser.COMPARATOR, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			expression();
			setState(332);
			match(COMPARATOR);
			setState(333);
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

	public static class ExpressionContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> PREOPERATION() { return getTokens(ExpParser.PREOPERATION); }
		public TerminalNode PREOPERATION(int i) {
			return getToken(ExpParser.PREOPERATION, i);
		}
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> NEGATION() { return getTokens(ExpParser.NEGATION); }
		public TerminalNode NEGATION(int i) {
			return getToken(ExpParser.NEGATION, i);
		}
		public List<TerminalNode> BOOLOPERATION() { return getTokens(ExpParser.BOOLOPERATION); }
		public TerminalNode BOOLOPERATION(int i) {
			return getToken(ExpParser.BOOLOPERATION, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_expression);
		int _la;
		try {
			setState(360);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(336);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PREOPERATION) {
					{
					setState(335);
					match(PREOPERATION);
					}
				}

				setState(338);
				term();
				setState(343);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==PREOPERATION) {
					{
					{
					setState(339);
					match(PREOPERATION);
					setState(340);
					term();
					}
					}
					setState(345);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(347);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEGATION) {
					{
					setState(346);
					match(NEGATION);
					}
				}

				setState(349);
				factor();
				setState(357);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==BOOLOPERATION) {
					{
					{
					setState(350);
					match(BOOLOPERATION);
					setState(352);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==NEGATION) {
						{
						setState(351);
						match(NEGATION);
						}
					}

					setState(354);
					factor();
					}
					}
					setState(359);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> MULDIV() { return getTokens(ExpParser.MULDIV); }
		public TerminalNode MULDIV(int i) {
			return getToken(ExpParser.MULDIV, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			factor();
			setState(367);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULDIV) {
				{
				{
				setState(363);
				match(MULDIV);
				setState(364);
				factor();
				}
				}
				setState(369);
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
		public TerminalNode BOOLVALUE() { return getToken(ExpParser.BOOLVALUE, 0); }
		public TerminalNode NUMBER() { return getToken(ExpParser.NUMBER, 0); }
		public CallStatementContext callStatement() {
			return getRuleContext(CallStatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(ExpParser.IDENT, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_factor);
		try {
			setState(378);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLVALUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(370);
				match(BOOLVALUE);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(371);
				match(NUMBER);
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 3);
				{
				setState(372);
				callStatement();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 4);
				{
				setState(373);
				match(T__3);
				setState(374);
				expression();
				setState(375);
				match(T__5);
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 5);
				{
				setState(377);
				match(IDENT);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u017f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\2\3\3\7\3E\n\3\f\3\16\3H\13\3\3\3\6\3K\n\3\r\3\16\3L\3\4\5\4P\n"+
		"\4\3\4\3\4\3\4\3\4\5\4V\n\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\7\7d\n\7\f\7\16\7g\13\7\5\7i\n\7\3\7\3\7\3\7\3\7\7\7o\n\7\f\7\16"+
		"\7r\13\7\3\7\3\7\6\7v\n\7\r\7\16\7w\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0091\n"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\6\13\u009b\n\13\r\13\16\13"+
		"\u009c\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u00a8\n\f\r\f\16\f\u00a9"+
		"\3\f\3\f\3\r\3\r\6\r\u00b0\n\r\r\r\16\r\u00b1\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\6\16\u00bd\n\16\r\16\16\16\u00be\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\6\17\u00ce\n\17\r\17\16\17"+
		"\u00cf\3\17\3\17\5\17\u00d4\n\17\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00dc"+
		"\n\20\f\20\16\20\u00df\13\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\5\22\u00f3\n\22\3\22"+
		"\3\22\3\23\3\23\3\23\6\23\u00fa\n\23\r\23\16\23\u00fb\3\23\3\23\3\24\3"+
		"\24\3\24\7\24\u0103\n\24\f\24\16\24\u0106\13\24\3\25\3\25\7\25\u010a\n"+
		"\25\f\25\16\25\u010d\13\25\3\25\3\25\3\25\5\25\u0112\n\25\3\26\3\26\3"+
		"\26\3\27\3\27\3\27\3\27\6\27\u011b\n\27\r\27\16\27\u011c\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\6\27\u0125\n\27\r\27\16\27\u0126\3\27\3\27\3\27\3\30\3"+
		"\30\3\30\3\30\7\30\u0130\n\30\f\30\16\30\u0133\13\30\3\30\3\30\3\30\3"+
		"\31\3\31\3\31\7\31\u013b\n\31\f\31\16\31\u013e\13\31\3\31\3\31\3\31\3"+
		"\32\3\32\5\32\u0145\n\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\3\36\5\36\u0153\n\36\3\36\3\36\3\36\7\36\u0158\n\36\f\36\16"+
		"\36\u015b\13\36\3\36\5\36\u015e\n\36\3\36\3\36\3\36\5\36\u0163\n\36\3"+
		"\36\7\36\u0166\n\36\f\36\16\36\u0169\13\36\5\36\u016b\n\36\3\37\3\37\3"+
		"\37\7\37\u0170\n\37\f\37\16\37\u0173\13\37\3 \3 \3 \3 \3 \3 \3 \3 \5 "+
		"\u017d\n \3 \2\2!\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<>\2\5\4\2\35\35\'\'\4\2\f\f\36\36\3\2\33\34\2\u018e\2@\3\2\2"+
		"\2\4F\3\2\2\2\6O\3\2\2\2\bY\3\2\2\2\n[\3\2\2\2\f]\3\2\2\2\16{\3\2\2\2"+
		"\20~\3\2\2\2\22\u0090\3\2\2\2\24\u0092\3\2\2\2\26\u00a0\3\2\2\2\30\u00ad"+
		"\3\2\2\2\32\u00b9\3\2\2\2\34\u00c7\3\2\2\2\36\u00d5\3\2\2\2 \u00e3\3\2"+
		"\2\2\"\u00ee\3\2\2\2$\u00f6\3\2\2\2&\u00ff\3\2\2\2(\u0107\3\2\2\2*\u0113"+
		"\3\2\2\2,\u0116\3\2\2\2.\u012b\3\2\2\2\60\u0137\3\2\2\2\62\u0142\3\2\2"+
		"\2\64\u0148\3\2\2\2\66\u014b\3\2\2\28\u014d\3\2\2\2:\u016a\3\2\2\2<\u016c"+
		"\3\2\2\2>\u017c\3\2\2\2@A\5\4\3\2AB\7\3\2\2B\3\3\2\2\2CE\5\6\4\2DC\3\2"+
		"\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GJ\3\2\2\2HF\3\2\2\2IK\5\f\7\2JI\3\2"+
		"\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\5\3\2\2\2NP\5\b\5\2ON\3\2\2\2OP\3"+
		"\2\2\2PQ\3\2\2\2QR\7\36\2\2RU\7&\2\2ST\7#\2\2TV\5\n\6\2US\3\2\2\2UV\3"+
		"\2\2\2VW\3\2\2\2WX\7$\2\2X\7\3\2\2\2YZ\7\4\2\2Z\t\3\2\2\2[\\\t\2\2\2\\"+
		"\13\3\2\2\2]^\7\5\2\2^_\7&\2\2_h\7\6\2\2`e\5\16\b\2ab\7\7\2\2bd\5\16\b"+
		"\2ca\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fi\3\2\2\2ge\3\2\2\2h`\3\2\2"+
		"\2hi\3\2\2\2ij\3\2\2\2jk\7\b\2\2kl\7\t\2\2lp\5\20\t\2mo\5\6\4\2nm\3\2"+
		"\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2qs\3\2\2\2rp\3\2\2\2su\7\n\2\2tv\5\22"+
		"\n\2ut\3\2\2\2vw\3\2\2\2wu\3\2\2\2wx\3\2\2\2xy\3\2\2\2yz\7\13\2\2z\r\3"+
		"\2\2\2{|\7\36\2\2|}\7&\2\2}\17\3\2\2\2~\177\t\3\2\2\177\21\3\2\2\2\u0080"+
		"\u0091\5(\25\2\u0081\u0082\5\"\22\2\u0082\u0083\7$\2\2\u0083\u0091\3\2"+
		"\2\2\u0084\u0091\5\34\17\2\u0085\u0091\5\26\f\2\u0086\u0091\5\32\16\2"+
		"\u0087\u0091\5\30\r\2\u0088\u0091\5\24\13\2\u0089\u0091\5\36\20\2\u008a"+
		"\u0091\5 \21\2\u008b\u0091\5,\27\2\u008c\u0091\5\62\32\2\u008d\u008e\5"+
		"\64\33\2\u008e\u008f\7$\2\2\u008f\u0091\3\2\2\2\u0090\u0080\3\2\2\2\u0090"+
		"\u0081\3\2\2\2\u0090\u0084\3\2\2\2\u0090\u0085\3\2\2\2\u0090\u0086\3\2"+
		"\2\2\u0090\u0087\3\2\2\2\u0090\u0088\3\2\2\2\u0090\u0089\3\2\2\2\u0090"+
		"\u008a\3\2\2\2\u0090\u008b\3\2\2\2\u0090\u008c\3\2\2\2\u0090\u008d\3\2"+
		"\2\2\u0091\23\3\2\2\2\u0092\u0093\7\r\2\2\u0093\u0094\7\6\2\2\u0094\u0095"+
		"\58\35\2\u0095\u0096\7$\2\2\u0096\u0097\5\64\33\2\u0097\u0098\7\b\2\2"+
		"\u0098\u009a\7\n\2\2\u0099\u009b\5\22\n\2\u009a\u0099\3\2\2\2\u009b\u009c"+
		"\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\u009f\7\13\2\2\u009f\25\3\2\2\2\u00a0\u00a1\7\16\2\2\u00a1\u00a2\7\6"+
		"\2\2\u00a2\u00a3\58\35\2\u00a3\u00a4\7\b\2\2\u00a4\u00a5\7\17\2\2\u00a5"+
		"\u00a7\7\n\2\2\u00a6\u00a8\5\22\n\2\u00a7\u00a6\3\2\2\2\u00a8\u00a9\3"+
		"\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab"+
		"\u00ac\7\13\2\2\u00ac\27\3\2\2\2\u00ad\u00af\7\17\2\2\u00ae\u00b0\5\22"+
		"\n\2\u00af\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1"+
		"\u00b2\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\7\16\2\2\u00b4\u00b5\7"+
		"\6\2\2\u00b5\u00b6\58\35\2\u00b6\u00b7\7\b\2\2\u00b7\u00b8\7$\2\2\u00b8"+
		"\31\3\2\2\2\u00b9\u00ba\7\20\2\2\u00ba\u00bc\7\n\2\2\u00bb\u00bd\5\22"+
		"\n\2\u00bc\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bc\3\2\2\2\u00be"+
		"\u00bf\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\7\13\2\2\u00c1\u00c2\7"+
		"\21\2\2\u00c2\u00c3\7\6\2\2\u00c3\u00c4\58\35\2\u00c4\u00c5\7\b\2\2\u00c5"+
		"\u00c6\7$\2\2\u00c6\33\3\2\2\2\u00c7\u00c8\7\22\2\2\u00c8\u00c9\7\6\2"+
		"\2\u00c9\u00ca\58\35\2\u00ca\u00cb\7\b\2\2\u00cb\u00cd\7\n\2\2\u00cc\u00ce"+
		"\5\22\n\2\u00cd\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00cd\3\2\2\2"+
		"\u00cf\u00d0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d3\7\13\2\2\u00d2\u00d4"+
		"\5$\23\2\u00d3\u00d2\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\35\3\2\2\2\u00d5"+
		"\u00d6\7\23\2\2\u00d6\u00d7\7\6\2\2\u00d7\u00d8\7&\2\2\u00d8\u00d9\7\b"+
		"\2\2\u00d9\u00dd\7\n\2\2\u00da\u00dc\5.\30\2\u00db\u00da\3\2\2\2\u00dc"+
		"\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e0\3\2"+
		"\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e1\5\60\31\2\u00e1\u00e2\7\13\2\2\u00e2"+
		"\37\3\2\2\2\u00e3\u00e4\7&\2\2\u00e4\u00e5\7#\2\2\u00e5\u00e6\7\6\2\2"+
		"\u00e6\u00e7\58\35\2\u00e7\u00e8\7\b\2\2\u00e8\u00e9\7\24\2\2\u00e9\u00ea"+
		"\5:\36\2\u00ea\u00eb\7\t\2\2\u00eb\u00ec\5:\36\2\u00ec\u00ed\7$\2\2\u00ed"+
		"!\3\2\2\2\u00ee\u00ef\7\25\2\2\u00ef\u00f0\7&\2\2\u00f0\u00f2\7\6\2\2"+
		"\u00f1\u00f3\5&\24\2\u00f2\u00f1\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4"+
		"\3\2\2\2\u00f4\u00f5\7\b\2\2\u00f5#\3\2\2\2\u00f6\u00f7\7\26\2\2\u00f7"+
		"\u00f9\7\n\2\2\u00f8\u00fa\5\22\n\2\u00f9\u00f8\3\2\2\2\u00fa\u00fb\3"+
		"\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\u00fe\7\13\2\2\u00fe%\3\2\2\2\u00ff\u0104\7&\2\2\u0100\u0101\7\7\2\2"+
		"\u0101\u0103\7&\2\2\u0102\u0100\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102"+
		"\3\2\2\2\u0104\u0105\3\2\2\2\u0105\'\3\2\2\2\u0106\u0104\3\2\2\2\u0107"+
		"\u010b\7&\2\2\u0108\u010a\5*\26\2\u0109\u0108\3\2\2\2\u010a\u010d\3\2"+
		"\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010e\3\2\2\2\u010d"+
		"\u010b\3\2\2\2\u010e\u0111\7#\2\2\u010f\u0112\5:\36\2\u0110\u0112\5\""+
		"\22\2\u0111\u010f\3\2\2\2\u0111\u0110\3\2\2\2\u0112)\3\2\2\2\u0113\u0114"+
		"\7#\2\2\u0114\u0115\7&\2\2\u0115+\3\2\2\2\u0116\u0117\7\n\2\2\u0117\u011a"+
		"\7&\2\2\u0118\u0119\7\7\2\2\u0119\u011b\7&\2\2\u011a\u0118\3\2\2\2\u011b"+
		"\u011c\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011e\3\2"+
		"\2\2\u011e\u011f\7\13\2\2\u011f\u0120\7#\2\2\u0120\u0121\7\n\2\2\u0121"+
		"\u0124\5\n\6\2\u0122\u0123\7\7\2\2\u0123\u0125\5\n\6\2\u0124\u0122\3\2"+
		"\2\2\u0125\u0126\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127"+
		"\u0128\3\2\2\2\u0128\u0129\7\13\2\2\u0129\u012a\7$\2\2\u012a-\3\2\2\2"+
		"\u012b\u012c\7\27\2\2\u012c\u012d\7\'\2\2\u012d\u0131\7\t\2\2\u012e\u0130"+
		"\5\22\n\2\u012f\u012e\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2"+
		"\u0131\u0132\3\2\2\2\u0132\u0134\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u0135"+
		"\7\30\2\2\u0135\u0136\7$\2\2\u0136/\3\2\2\2\u0137\u0138\7\31\2\2\u0138"+
		"\u013c\7\t\2\2\u0139\u013b\5\22\n\2\u013a\u0139\3\2\2\2\u013b\u013e\3"+
		"\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013f\3\2\2\2\u013e"+
		"\u013c\3\2\2\2\u013f\u0140\7\30\2\2\u0140\u0141\7$\2\2\u0141\61\3\2\2"+
		"\2\u0142\u0144\7\32\2\2\u0143\u0145\7&\2\2\u0144\u0143\3\2\2\2\u0144\u0145"+
		"\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0147\7$\2\2\u0147\63\3\2\2\2\u0148"+
		"\u0149\7&\2\2\u0149\u014a\5\66\34\2\u014a\65\3\2\2\2\u014b\u014c\t\4\2"+
		"\2\u014c\67\3\2\2\2\u014d\u014e\5:\36\2\u014e\u014f\7\37\2\2\u014f\u0150"+
		"\5:\36\2\u01509\3\2\2\2\u0151\u0153\7 \2\2\u0152\u0151\3\2\2\2\u0152\u0153"+
		"\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0159\5<\37\2\u0155\u0156\7 \2\2\u0156"+
		"\u0158\5<\37\2\u0157\u0155\3\2\2\2\u0158\u015b\3\2\2\2\u0159\u0157\3\2"+
		"\2\2\u0159\u015a\3\2\2\2\u015a\u016b\3\2\2\2\u015b\u0159\3\2\2\2\u015c"+
		"\u015e\7%\2\2\u015d\u015c\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u015f\3\2"+
		"\2\2\u015f\u0167\5> \2\u0160\u0162\7!\2\2\u0161\u0163\7%\2\2\u0162\u0161"+
		"\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0166\5> \2\u0165"+
		"\u0160\3\2\2\2\u0166\u0169\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0168\3\2"+
		"\2\2\u0168\u016b\3\2\2\2\u0169\u0167\3\2\2\2\u016a\u0152\3\2\2\2\u016a"+
		"\u015d\3\2\2\2\u016b;\3\2\2\2\u016c\u0171\5> \2\u016d\u016e\7\"\2\2\u016e"+
		"\u0170\5> \2\u016f\u016d\3\2\2\2\u0170\u0173\3\2\2\2\u0171\u016f\3\2\2"+
		"\2\u0171\u0172\3\2\2\2\u0172=\3\2\2\2\u0173\u0171\3\2\2\2\u0174\u017d"+
		"\7\35\2\2\u0175\u017d\7\'\2\2\u0176\u017d\5\"\22\2\u0177\u0178\7\6\2\2"+
		"\u0178\u0179\5:\36\2\u0179\u017a\7\b\2\2\u017a\u017d\3\2\2\2\u017b\u017d"+
		"\7&\2\2\u017c\u0174\3\2\2\2\u017c\u0175\3\2\2\2\u017c\u0176\3\2\2\2\u017c"+
		"\u0177\3\2\2\2\u017c\u017b\3\2\2\2\u017d?\3\2\2\2$FLOUehpw\u0090\u009c"+
		"\u00a9\u00b1\u00be\u00cf\u00d3\u00dd\u00f2\u00fb\u0104\u010b\u0111\u011c"+
		"\u0126\u0131\u013c\u0144\u0152\u0159\u015d\u0162\u0167\u016a\u0171\u017c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}