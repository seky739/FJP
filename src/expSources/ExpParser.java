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
		T__24=25, BOOLVALUE=26, TYPE=27, COMPARATOR=28, PREOPERATION=29, BOOLOPERATION=30, 
		MULDIV=31, ASSIGN=32, END_STATEMENT=33, NEGATION=34, IDENT=35, NUMBER=36, 
		WS=37;
	public static final int
		RULE_program = 0, RULE_block = 1, RULE_variableDef = 2, RULE_variableConst = 3, 
		RULE_variableValue = 4, RULE_method = 5, RULE_parameter = 6, RULE_returnParam = 7, 
		RULE_statement = 8, RULE_forStatement = 9, RULE_whileStatement = 10, RULE_doWhileStatement = 11, 
		RULE_repeatStatement = 12, RULE_ifCondition = 13, RULE_switchStatement = 14, 
		RULE_ternaryAssignment = 15, RULE_callStatement = 16, RULE_elseStatement = 17, 
		RULE_callParam = 18, RULE_assignment = 19, RULE_multipleAssignment = 20, 
		RULE_parallelAssignment = 21, RULE_cas = 22, RULE_defaultcas = 23, RULE_retrn = 24, 
		RULE_unaryOperation = 25, RULE_unaryOperator = 26, RULE_condition = 27, 
		RULE_expression = 28, RULE_term = 29, RULE_factor = 30;
	public static final String[] ruleNames = {
		"program", "block", "variableDef", "variableConst", "variableValue", "method", 
		"parameter", "returnParam", "statement", "forStatement", "whileStatement", 
		"doWhileStatement", "repeatStatement", "ifCondition", "switchStatement", 
		"ternaryAssignment", "callStatement", "elseStatement", "callParam", "assignment", 
		"multipleAssignment", "parallelAssignment", "cas", "defaultcas", "retrn", 
		"unaryOperation", "unaryOperator", "condition", "expression", "term", 
		"factor"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "'const'", "'function'", "'('", "','", "')'", "':'", "'{'", 
		"'}'", "'void'", "'for'", "'while'", "'do'", "'repeat'", "'until'", "'if'", 
		"'switch'", "'?'", "'call'", "'else'", "'case'", "'default'", "'return'", 
		"'++'", "'--'", null, null, null, null, null, null, "':='", "';'", "'!'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "BOOLVALUE", "TYPE", "COMPARATOR", "PREOPERATION", "BOOLOPERATION", 
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
		public RetrnContext retrn() {
			return getRuleContext(RetrnContext.class,0);
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
			setState(107);
			match(T__6);
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==TYPE) {
				{
				{
				setState(108);
				variableDef();
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(114);
			match(T__7);
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__23) | (1L << T__24) | (1L << IDENT))) != 0)) {
				{
				{
				setState(115);
				statement();
				}
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(121);
			retrn();
			setState(122);
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
			setState(124);
			match(TYPE);
			setState(125);
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
			setState(127);
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
		public TernaryAssignmentContext ternaryAssignment() {
			return getRuleContext(TernaryAssignmentContext.class,0);
		}
		public ParallelAssignmentContext parallelAssignment() {
			return getRuleContext(ParallelAssignmentContext.class,0);
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
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				callStatement();
				setState(131);
				match(END_STATEMENT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(133);
				ifCondition();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(134);
				whileStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(135);
				repeatStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(136);
				doWhileStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(137);
				forStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(138);
				switchStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(139);
				ternaryAssignment();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(140);
				parallelAssignment();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(141);
				unaryOperation();
				setState(142);
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
			setState(146);
			match(T__10);
			setState(147);
			match(T__3);
			setState(148);
			condition();
			setState(149);
			match(END_STATEMENT);
			setState(150);
			unaryOperation();
			setState(151);
			match(T__5);
			setState(152);
			match(T__7);
			setState(154); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(153);
				statement();
				}
				}
				setState(156); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__23) | (1L << T__24) | (1L << IDENT))) != 0) );
			setState(158);
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
			setState(160);
			match(T__11);
			setState(161);
			match(T__3);
			setState(162);
			condition();
			setState(163);
			match(T__5);
			setState(164);
			match(T__7);
			setState(166); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(165);
				statement();
				}
				}
				setState(168); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__23) | (1L << T__24) | (1L << IDENT))) != 0) );
			setState(170);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(T__12);
			setState(173);
			match(T__7);
			setState(175); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(174);
				statement();
				}
				}
				setState(177); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__23) | (1L << T__24) | (1L << IDENT))) != 0) );
			setState(179);
			match(T__8);
			setState(180);
			match(T__11);
			setState(181);
			match(T__3);
			setState(182);
			condition();
			setState(183);
			match(T__5);
			setState(184);
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
			setState(186);
			match(T__13);
			setState(187);
			match(T__7);
			setState(189); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(188);
				statement();
				}
				}
				setState(191); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__23) | (1L << T__24) | (1L << IDENT))) != 0) );
			setState(193);
			match(T__8);
			setState(194);
			match(T__14);
			setState(195);
			match(T__3);
			setState(196);
			condition();
			setState(197);
			match(T__5);
			setState(198);
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
			setState(200);
			match(T__15);
			setState(201);
			match(T__3);
			setState(202);
			condition();
			setState(203);
			match(T__5);
			setState(204);
			match(T__7);
			setState(206); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(205);
				statement();
				}
				}
				setState(208); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__23) | (1L << T__24) | (1L << IDENT))) != 0) );
			setState(210);
			match(T__8);
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19) {
				{
				setState(211);
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
			setState(214);
			match(T__16);
			setState(215);
			match(T__3);
			setState(216);
			match(IDENT);
			setState(217);
			match(T__5);
			setState(218);
			match(T__7);
			setState(220); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(219);
				cas();
				}
				}
				setState(222); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__20 );
			setState(224);
			defaultcas();
			setState(225);
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

	public static class TernaryAssignmentContext extends ParserRuleContext {
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
		public TernaryAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ternaryAssignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitTernaryAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TernaryAssignmentContext ternaryAssignment() throws RecognitionException {
		TernaryAssignmentContext _localctx = new TernaryAssignmentContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ternaryAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(IDENT);
			setState(228);
			match(ASSIGN);
			setState(229);
			match(T__3);
			setState(230);
			condition();
			setState(231);
			match(T__5);
			setState(232);
			match(T__17);
			setState(233);
			expression();
			setState(234);
			match(T__6);
			setState(235);
			expression();
			setState(236);
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
			setState(238);
			match(T__18);
			setState(239);
			match(IDENT);
			setState(240);
			match(T__3);
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(241);
				callParam();
				}
			}

			setState(244);
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
			setState(246);
			match(T__19);
			setState(247);
			match(T__7);
			setState(249); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(248);
				statement();
				}
				}
				setState(251); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__23) | (1L << T__24) | (1L << IDENT))) != 0) );
			setState(253);
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
			setState(255);
			match(IDENT);
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(256);
				match(T__4);
				setState(257);
				match(IDENT);
				}
				}
				setState(262);
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
		public TerminalNode END_STATEMENT() { return getToken(ExpParser.END_STATEMENT, 0); }
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
			setState(263);
			match(IDENT);
			setState(267);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(264);
					multipleAssignment();
					}
					} 
				}
				setState(269);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			setState(270);
			match(ASSIGN);
			setState(273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(271);
				expression();
				}
				break;
			case 2:
				{
				setState(272);
				callStatement();
				}
				break;
			}
			setState(275);
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
			setState(277);
			match(ASSIGN);
			setState(278);
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

	public static class ParallelAssignmentContext extends ParserRuleContext {
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
		public ParallelAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parallelAssignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitParallelAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParallelAssignmentContext parallelAssignment() throws RecognitionException {
		ParallelAssignmentContext _localctx = new ParallelAssignmentContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_parallelAssignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(T__7);
			setState(281);
			match(IDENT);
			setState(284); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(282);
				match(T__4);
				setState(283);
				match(IDENT);
				}
				}
				setState(286); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			setState(288);
			match(T__8);
			setState(289);
			match(ASSIGN);
			setState(290);
			match(T__7);
			{
			setState(291);
			variableValue();
			}
			setState(294); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(292);
				match(T__4);
				{
				setState(293);
				variableValue();
				}
				}
				}
				setState(296); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			setState(298);
			match(T__8);
			setState(299);
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
			setState(301);
			match(T__20);
			setState(302);
			match(NUMBER);
			setState(303);
			match(T__6);
			setState(307);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__23) | (1L << T__24) | (1L << IDENT))) != 0)) {
				{
				{
				setState(304);
				statement();
				}
				}
				setState(309);
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
			setState(310);
			match(T__21);
			setState(311);
			match(T__6);
			setState(315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__23) | (1L << T__24) | (1L << IDENT))) != 0)) {
				{
				{
				setState(312);
				statement();
				}
				}
				setState(317);
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
			setState(318);
			match(T__22);
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(319);
				match(IDENT);
				}
			}

			setState(322);
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
		public UnaryOperatorContext unaryOperator() {
			return getRuleContext(UnaryOperatorContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(ExpParser.IDENT, 0); }
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
			setState(324);
			unaryOperator();
			setState(325);
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
			setState(327);
			_la = _input.LA(1);
			if ( !(_la==T__23 || _la==T__24) ) {
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
			setState(329);
			expression();
			setState(330);
			match(COMPARATOR);
			setState(331);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			term();
			setState(338);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PREOPERATION || _la==BOOLOPERATION) {
				{
				{
				setState(334);
				_la = _input.LA(1);
				if ( !(_la==PREOPERATION || _la==BOOLOPERATION) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(335);
				term();
				}
				}
				setState(340);
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
			setState(341);
			factor();
			setState(346);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULDIV) {
				{
				{
				setState(342);
				match(MULDIV);
				setState(343);
				factor();
				}
				}
				setState(348);
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
		public TerminalNode NEGATION() { return getToken(ExpParser.NEGATION, 0); }
		public TerminalNode NUMBER() { return getToken(ExpParser.NUMBER, 0); }
		public TerminalNode PREOPERATION() { return getToken(ExpParser.PREOPERATION, 0); }
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
		int _la;
		try {
			setState(366);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(350);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEGATION) {
					{
					setState(349);
					match(NEGATION);
					}
				}

				setState(352);
				match(BOOLVALUE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(354);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PREOPERATION) {
					{
					setState(353);
					match(PREOPERATION);
					}
				}

				setState(356);
				match(NUMBER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(357);
				callStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(358);
				match(T__3);
				setState(359);
				expression();
				setState(360);
				match(T__5);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(363);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PREOPERATION || _la==NEGATION) {
					{
					setState(362);
					_la = _input.LA(1);
					if ( !(_la==PREOPERATION || _la==NEGATION) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(365);
				match(IDENT);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'\u0173\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\2\3\3\7\3E\n\3\f\3\16\3H\13\3\3\3\6\3K\n\3\r\3\16\3L\3\4\5\4P\n"+
		"\4\3\4\3\4\3\4\3\4\5\4V\n\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\7\7d\n\7\f\7\16\7g\13\7\5\7i\n\7\3\7\3\7\3\7\3\7\3\7\7\7p\n\7\f"+
		"\7\16\7s\13\7\3\7\3\7\7\7w\n\7\f\7\16\7z\13\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5"+
		"\n\u0093\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\6\13\u009d\n\13\r"+
		"\13\16\13\u009e\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u00a9\n\f\r\f\16"+
		"\f\u00aa\3\f\3\f\3\r\3\r\3\r\6\r\u00b2\n\r\r\r\16\r\u00b3\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\16\3\16\3\16\6\16\u00c0\n\16\r\16\16\16\u00c1\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\6\17\u00d1"+
		"\n\17\r\17\16\17\u00d2\3\17\3\17\5\17\u00d7\n\17\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\6\20\u00df\n\20\r\20\16\20\u00e0\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\5\22\u00f5"+
		"\n\22\3\22\3\22\3\23\3\23\3\23\6\23\u00fc\n\23\r\23\16\23\u00fd\3\23\3"+
		"\23\3\24\3\24\3\24\7\24\u0105\n\24\f\24\16\24\u0108\13\24\3\25\3\25\7"+
		"\25\u010c\n\25\f\25\16\25\u010f\13\25\3\25\3\25\3\25\5\25\u0114\n\25\3"+
		"\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\6\27\u011f\n\27\r\27\16\27"+
		"\u0120\3\27\3\27\3\27\3\27\3\27\3\27\6\27\u0129\n\27\r\27\16\27\u012a"+
		"\3\27\3\27\3\27\3\30\3\30\3\30\3\30\7\30\u0134\n\30\f\30\16\30\u0137\13"+
		"\30\3\31\3\31\3\31\7\31\u013c\n\31\f\31\16\31\u013f\13\31\3\32\3\32\5"+
		"\32\u0143\n\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\7\36\u0153\n\36\f\36\16\36\u0156\13\36\3\37\3\37\3\37"+
		"\7\37\u015b\n\37\f\37\16\37\u015e\13\37\3 \5 \u0161\n \3 \3 \5 \u0165"+
		"\n \3 \3 \3 \3 \3 \3 \3 \5 \u016e\n \3 \5 \u0171\n \3 \2\2!\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>\2\7\4\2\34\34&"+
		"&\4\2\f\f\35\35\3\2\32\33\3\2\37 \4\2\37\37$$\2\u017f\2@\3\2\2\2\4F\3"+
		"\2\2\2\6O\3\2\2\2\bY\3\2\2\2\n[\3\2\2\2\f]\3\2\2\2\16~\3\2\2\2\20\u0081"+
		"\3\2\2\2\22\u0092\3\2\2\2\24\u0094\3\2\2\2\26\u00a2\3\2\2\2\30\u00ae\3"+
		"\2\2\2\32\u00bc\3\2\2\2\34\u00ca\3\2\2\2\36\u00d8\3\2\2\2 \u00e5\3\2\2"+
		"\2\"\u00f0\3\2\2\2$\u00f8\3\2\2\2&\u0101\3\2\2\2(\u0109\3\2\2\2*\u0117"+
		"\3\2\2\2,\u011a\3\2\2\2.\u012f\3\2\2\2\60\u0138\3\2\2\2\62\u0140\3\2\2"+
		"\2\64\u0146\3\2\2\2\66\u0149\3\2\2\28\u014b\3\2\2\2:\u014f\3\2\2\2<\u0157"+
		"\3\2\2\2>\u0170\3\2\2\2@A\5\4\3\2AB\7\3\2\2B\3\3\2\2\2CE\5\6\4\2DC\3\2"+
		"\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GJ\3\2\2\2HF\3\2\2\2IK\5\f\7\2JI\3\2"+
		"\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\5\3\2\2\2NP\5\b\5\2ON\3\2\2\2OP\3"+
		"\2\2\2PQ\3\2\2\2QR\7\35\2\2RU\7%\2\2ST\7\"\2\2TV\5\n\6\2US\3\2\2\2UV\3"+
		"\2\2\2VW\3\2\2\2WX\7#\2\2X\7\3\2\2\2YZ\7\4\2\2Z\t\3\2\2\2[\\\t\2\2\2\\"+
		"\13\3\2\2\2]^\7\5\2\2^_\7%\2\2_h\7\6\2\2`e\5\16\b\2ab\7\7\2\2bd\5\16\b"+
		"\2ca\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fi\3\2\2\2ge\3\2\2\2h`\3\2\2"+
		"\2hi\3\2\2\2ij\3\2\2\2jk\7\b\2\2kl\7\t\2\2lm\5\20\t\2mq\7\t\2\2np\5\6"+
		"\4\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2rt\3\2\2\2sq\3\2\2\2tx\7\n"+
		"\2\2uw\5\22\n\2vu\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zx\3"+
		"\2\2\2{|\5\62\32\2|}\7\13\2\2}\r\3\2\2\2~\177\7\35\2\2\177\u0080\7%\2"+
		"\2\u0080\17\3\2\2\2\u0081\u0082\t\3\2\2\u0082\21\3\2\2\2\u0083\u0093\5"+
		"(\25\2\u0084\u0085\5\"\22\2\u0085\u0086\7#\2\2\u0086\u0093\3\2\2\2\u0087"+
		"\u0093\5\34\17\2\u0088\u0093\5\26\f\2\u0089\u0093\5\32\16\2\u008a\u0093"+
		"\5\30\r\2\u008b\u0093\5\24\13\2\u008c\u0093\5\36\20\2\u008d\u0093\5 \21"+
		"\2\u008e\u0093\5,\27\2\u008f\u0090\5\64\33\2\u0090\u0091\7#\2\2\u0091"+
		"\u0093\3\2\2\2\u0092\u0083\3\2\2\2\u0092\u0084\3\2\2\2\u0092\u0087\3\2"+
		"\2\2\u0092\u0088\3\2\2\2\u0092\u0089\3\2\2\2\u0092\u008a\3\2\2\2\u0092"+
		"\u008b\3\2\2\2\u0092\u008c\3\2\2\2\u0092\u008d\3\2\2\2\u0092\u008e\3\2"+
		"\2\2\u0092\u008f\3\2\2\2\u0093\23\3\2\2\2\u0094\u0095\7\r\2\2\u0095\u0096"+
		"\7\6\2\2\u0096\u0097\58\35\2\u0097\u0098\7#\2\2\u0098\u0099\5\64\33\2"+
		"\u0099\u009a\7\b\2\2\u009a\u009c\7\n\2\2\u009b\u009d\5\22\n\2\u009c\u009b"+
		"\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\u00a1\7\13\2\2\u00a1\25\3\2\2\2\u00a2\u00a3\7\16"+
		"\2\2\u00a3\u00a4\7\6\2\2\u00a4\u00a5\58\35\2\u00a5\u00a6\7\b\2\2\u00a6"+
		"\u00a8\7\n\2\2\u00a7\u00a9\5\22\n\2\u00a8\u00a7\3\2\2\2\u00a9\u00aa\3"+
		"\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac"+
		"\u00ad\7\13\2\2\u00ad\27\3\2\2\2\u00ae\u00af\7\17\2\2\u00af\u00b1\7\n"+
		"\2\2\u00b0\u00b2\5\22\n\2\u00b1\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\7\13"+
		"\2\2\u00b6\u00b7\7\16\2\2\u00b7\u00b8\7\6\2\2\u00b8\u00b9\58\35\2\u00b9"+
		"\u00ba\7\b\2\2\u00ba\u00bb\7#\2\2\u00bb\31\3\2\2\2\u00bc\u00bd\7\20\2"+
		"\2\u00bd\u00bf\7\n\2\2\u00be\u00c0\5\22\n\2\u00bf\u00be\3\2\2\2\u00c0"+
		"\u00c1\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\3\2"+
		"\2\2\u00c3\u00c4\7\13\2\2\u00c4\u00c5\7\21\2\2\u00c5\u00c6\7\6\2\2\u00c6"+
		"\u00c7\58\35\2\u00c7\u00c8\7\b\2\2\u00c8\u00c9\7#\2\2\u00c9\33\3\2\2\2"+
		"\u00ca\u00cb\7\22\2\2\u00cb\u00cc\7\6\2\2\u00cc\u00cd\58\35\2\u00cd\u00ce"+
		"\7\b\2\2\u00ce\u00d0\7\n\2\2\u00cf\u00d1\5\22\n\2\u00d0\u00cf\3\2\2\2"+
		"\u00d1\u00d2\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4"+
		"\3\2\2\2\u00d4\u00d6\7\13\2\2\u00d5\u00d7\5$\23\2\u00d6\u00d5\3\2\2\2"+
		"\u00d6\u00d7\3\2\2\2\u00d7\35\3\2\2\2\u00d8\u00d9\7\23\2\2\u00d9\u00da"+
		"\7\6\2\2\u00da\u00db\7%\2\2\u00db\u00dc\7\b\2\2\u00dc\u00de\7\n\2\2\u00dd"+
		"\u00df\5.\30\2\u00de\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00de\3\2"+
		"\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\5\60\31\2\u00e3"+
		"\u00e4\7\13\2\2\u00e4\37\3\2\2\2\u00e5\u00e6\7%\2\2\u00e6\u00e7\7\"\2"+
		"\2\u00e7\u00e8\7\6\2\2\u00e8\u00e9\58\35\2\u00e9\u00ea\7\b\2\2\u00ea\u00eb"+
		"\7\24\2\2\u00eb\u00ec\5:\36\2\u00ec\u00ed\7\t\2\2\u00ed\u00ee\5:\36\2"+
		"\u00ee\u00ef\7#\2\2\u00ef!\3\2\2\2\u00f0\u00f1\7\25\2\2\u00f1\u00f2\7"+
		"%\2\2\u00f2\u00f4\7\6\2\2\u00f3\u00f5\5&\24\2\u00f4\u00f3\3\2\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\7\b\2\2\u00f7#\3\2\2\2"+
		"\u00f8\u00f9\7\26\2\2\u00f9\u00fb\7\n\2\2\u00fa\u00fc\5\22\n\2\u00fb\u00fa"+
		"\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe"+
		"\u00ff\3\2\2\2\u00ff\u0100\7\13\2\2\u0100%\3\2\2\2\u0101\u0106\7%\2\2"+
		"\u0102\u0103\7\7\2\2\u0103\u0105\7%\2\2\u0104\u0102\3\2\2\2\u0105\u0108"+
		"\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\'\3\2\2\2\u0108"+
		"\u0106\3\2\2\2\u0109\u010d\7%\2\2\u010a\u010c\5*\26\2\u010b\u010a\3\2"+
		"\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e"+
		"\u0110\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0113\7\"\2\2\u0111\u0114\5:"+
		"\36\2\u0112\u0114\5\"\22\2\u0113\u0111\3\2\2\2\u0113\u0112\3\2\2\2\u0114"+
		"\u0115\3\2\2\2\u0115\u0116\7#\2\2\u0116)\3\2\2\2\u0117\u0118\7\"\2\2\u0118"+
		"\u0119\7%\2\2\u0119+\3\2\2\2\u011a\u011b\7\n\2\2\u011b\u011e\7%\2\2\u011c"+
		"\u011d\7\7\2\2\u011d\u011f\7%\2\2\u011e\u011c\3\2\2\2\u011f\u0120\3\2"+
		"\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122\3\2\2\2\u0122"+
		"\u0123\7\13\2\2\u0123\u0124\7\"\2\2\u0124\u0125\7\n\2\2\u0125\u0128\5"+
		"\n\6\2\u0126\u0127\7\7\2\2\u0127\u0129\5\n\6\2\u0128\u0126\3\2\2\2\u0129"+
		"\u012a\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012c\3\2"+
		"\2\2\u012c\u012d\7\13\2\2\u012d\u012e\7#\2\2\u012e-\3\2\2\2\u012f\u0130"+
		"\7\27\2\2\u0130\u0131\7&\2\2\u0131\u0135\7\t\2\2\u0132\u0134\5\22\n\2"+
		"\u0133\u0132\3\2\2\2\u0134\u0137\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136"+
		"\3\2\2\2\u0136/\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u0139\7\30\2\2\u0139"+
		"\u013d\7\t\2\2\u013a\u013c\5\22\n\2\u013b\u013a\3\2\2\2\u013c\u013f\3"+
		"\2\2\2\u013d\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e\61\3\2\2\2\u013f"+
		"\u013d\3\2\2\2\u0140\u0142\7\31\2\2\u0141\u0143\7%\2\2\u0142\u0141\3\2"+
		"\2\2\u0142\u0143\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0145\7#\2\2\u0145"+
		"\63\3\2\2\2\u0146\u0147\5\66\34\2\u0147\u0148\7%\2\2\u0148\65\3\2\2\2"+
		"\u0149\u014a\t\4\2\2\u014a\67\3\2\2\2\u014b\u014c\5:\36\2\u014c\u014d"+
		"\7\36\2\2\u014d\u014e\5:\36\2\u014e9\3\2\2\2\u014f\u0154\5<\37\2\u0150"+
		"\u0151\t\5\2\2\u0151\u0153\5<\37\2\u0152\u0150\3\2\2\2\u0153\u0156\3\2"+
		"\2\2\u0154\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155;\3\2\2\2\u0156\u0154"+
		"\3\2\2\2\u0157\u015c\5> \2\u0158\u0159\7!\2\2\u0159\u015b\5> \2\u015a"+
		"\u0158\3\2\2\2\u015b\u015e\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d\3\2"+
		"\2\2\u015d=\3\2\2\2\u015e\u015c\3\2\2\2\u015f\u0161\7$\2\2\u0160\u015f"+
		"\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0171\7\34\2\2"+
		"\u0163\u0165\7\37\2\2\u0164\u0163\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0166"+
		"\3\2\2\2\u0166\u0171\7&\2\2\u0167\u0171\5\"\22\2\u0168\u0169\7\6\2\2\u0169"+
		"\u016a\5:\36\2\u016a\u016b\7\b\2\2\u016b\u0171\3\2\2\2\u016c\u016e\t\6"+
		"\2\2\u016d\u016c\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u016f\3\2\2\2\u016f"+
		"\u0171\7%\2\2\u0170\u0160\3\2\2\2\u0170\u0164\3\2\2\2\u0170\u0167\3\2"+
		"\2\2\u0170\u0168\3\2\2\2\u0170\u016d\3\2\2\2\u0171?\3\2\2\2\"FLOUehqx"+
		"\u0092\u009e\u00aa\u00b3\u00c1\u00d2\u00d6\u00e0\u00f4\u00fd\u0106\u010d"+
		"\u0113\u0120\u012a\u0135\u013d\u0142\u0154\u015c\u0160\u0164\u016d\u0170";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}