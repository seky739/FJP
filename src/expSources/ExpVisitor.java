// Generated from /home/vnkid/Workspace/seky/FJP/src/Exp.g4 by ANTLR 4.7
package expSources;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExpParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExpVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExpParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ExpParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(ExpParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#variableDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDef(ExpParser.VariableDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#variableConst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableConst(ExpParser.VariableConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#variableValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableValue(ExpParser.VariableValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(ExpParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(ExpParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#returnParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnParam(ExpParser.ReturnParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(ExpParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(ExpParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(ExpParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#doWhileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStatement(ExpParser.DoWhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#repeatStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatStatement(ExpParser.RepeatStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#ifCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfCondition(ExpParser.IfConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(ExpParser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#ternaryOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryOperation(ExpParser.TernaryOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#callStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallStatement(ExpParser.CallStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#elseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStatement(ExpParser.ElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#callParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallParam(ExpParser.CallParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(ExpParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#multipleAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleAssignment(ExpParser.MultipleAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#paralelAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParalelAssignment(ExpParser.ParalelAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#cas}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCas(ExpParser.CasContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#defaultcas}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultcas(ExpParser.DefaultcasContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#retrn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetrn(ExpParser.RetrnContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#unaryOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperation(ExpParser.UnaryOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#unaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperator(ExpParser.UnaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(ExpParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ExpParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(ExpParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(ExpParser.FactorContext ctx);
}