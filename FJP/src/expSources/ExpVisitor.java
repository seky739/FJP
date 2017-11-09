package expSources;// Generated from C:/Users/micha/IdeaProjects/Test/src\Exp.g4 by ANTLR 4.7
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
	 * Visit a parse tree produced by {@link ExpParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(ExpParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(ExpParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#retrn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetrn(ExpParser.RetrnContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(ExpParser.ForStatementContext ctx);
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
	 * Visit a parse tree produced by {@link ExpParser#multipleAssigned}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleAssigned(ExpParser.MultipleAssignedContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(ExpParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(ExpParser.TypeContext ctx);
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