// Generated from C:/Users/micha/Documents/GitHub/FJP/src\Exp.g4 by ANTLR 4.7
package expSources;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpParser}.
 */
public interface ExpListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExpParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ExpParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ExpParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ExpParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ExpParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#variableDef}.
	 * @param ctx the parse tree
	 */
	void enterVariable(ExpParser.VariableDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#variableDef}.
	 * @param ctx the parse tree
	 */
	void exitVariable(ExpParser.VariableDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#variableConst}.
	 * @param ctx the parse tree
	 */
	void enterVariableConst(ExpParser.VariableConstContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#variableConst}.
	 * @param ctx the parse tree
	 */
	void exitVariableConst(ExpParser.VariableConstContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#variableValue}.
	 * @param ctx the parse tree
	 */
	void enterVariableValue(ExpParser.VariableValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#variableValue}.
	 * @param ctx the parse tree
	 */
	void exitVariableValue(ExpParser.VariableValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(ExpParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(ExpParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(ExpParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(ExpParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#returnParam}.
	 * @param ctx the parse tree
	 */
	void enterReturnParam(ExpParser.ReturnParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#returnParam}.
	 * @param ctx the parse tree
	 */
	void exitReturnParam(ExpParser.ReturnParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ExpParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ExpParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(ExpParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(ExpParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(ExpParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(ExpParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#doWhileStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStatement(ExpParser.DoWhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#doWhileStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStatement(ExpParser.DoWhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#repeatStatement}.
	 * @param ctx the parse tree
	 */
	void enterRepeatStatement(ExpParser.RepeatStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#repeatStatement}.
	 * @param ctx the parse tree
	 */
	void exitRepeatStatement(ExpParser.RepeatStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#ifCondition}.
	 * @param ctx the parse tree
	 */
	void enterIfCondition(ExpParser.IfConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#ifCondition}.
	 * @param ctx the parse tree
	 */
	void exitIfCondition(ExpParser.IfConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(ExpParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(ExpParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#ternaryOperation}.
	 * @param ctx the parse tree
	 */
	void enterTernaryOperation(ExpParser.TernaryOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#ternaryOperation}.
	 * @param ctx the parse tree
	 */
	void exitTernaryOperation(ExpParser.TernaryOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#callStatement}.
	 * @param ctx the parse tree
	 */
	void enterCallStatement(ExpParser.CallStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#callStatement}.
	 * @param ctx the parse tree
	 */
	void exitCallStatement(ExpParser.CallStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(ExpParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(ExpParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#multipleAssignment}.
	 * @param ctx the parse tree
	 */
	void enterMultipleAssignment(ExpParser.MultipleAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#multipleAssignment}.
	 * @param ctx the parse tree
	 */
	void exitMultipleAssignment(ExpParser.MultipleAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#paralelAssignment}.
	 * @param ctx the parse tree
	 */
	void enterParalelAssignment(ExpParser.ParalelAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#paralelAssignment}.
	 * @param ctx the parse tree
	 */
	void exitParalelAssignment(ExpParser.ParalelAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#cas}.
	 * @param ctx the parse tree
	 */
	void enterCas(ExpParser.CasContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#cas}.
	 * @param ctx the parse tree
	 */
	void exitCas(ExpParser.CasContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#defaultcas}.
	 * @param ctx the parse tree
	 */
	void enterDefaultcas(ExpParser.DefaultcasContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#defaultcas}.
	 * @param ctx the parse tree
	 */
	void exitDefaultcas(ExpParser.DefaultcasContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#retrn}.
	 * @param ctx the parse tree
	 */
	void enterRetrn(ExpParser.RetrnContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#retrn}.
	 * @param ctx the parse tree
	 */
	void exitRetrn(ExpParser.RetrnContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#unaryOperation}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperation(ExpParser.UnaryOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#unaryOperation}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperation(ExpParser.UnaryOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperator(ExpParser.UnaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperator(ExpParser.UnaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(ExpParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(ExpParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ExpParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ExpParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(ExpParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(ExpParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(ExpParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(ExpParser.FactorContext ctx);
}