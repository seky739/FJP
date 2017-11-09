// Generated from C:/Users/micha/IdeaProjects/Test/src\Exp.g4 by ANTLR 4.7
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
	 * Enter a parse tree produced by {@link ExpParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(ExpParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(ExpParser.VarContext ctx);
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
	 * Enter a parse tree produced by {@link ExpParser#multipleAssigned}.
	 * @param ctx the parse tree
	 */
	void enterMultipleAssigned(ExpParser.MultipleAssignedContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#multipleAssigned}.
	 * @param ctx the parse tree
	 */
	void exitMultipleAssigned(ExpParser.MultipleAssignedContext ctx);
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
	 * Enter a parse tree produced by {@link ExpParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(ExpParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(ExpParser.TypeContext ctx);
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