package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Expression;

import java.util.ArrayList;

import static java.util.stream.Collectors.toList;

public class ExpressionVisitor extends ExpBaseVisitor<Expression>{
    @Override
    public Expression visitExpression(ExpParser.ExpressionContext ctx) {
        System.out.println("Visit Expression");
        TermVisitor termVisitor=new TermVisitor();

        Expression expression=new Expression();
        expression.variables=new ArrayList<>();
        expression.operations=new ArrayList<>();
        expression.terms=new ArrayList<>();


        //expression.variables.addAll(ctx.factor().stream().map(factorContext -> factorContext.accept(fa)).collect(toList()));
        expression.terms.addAll(ctx.term().stream().map(term -> term.accept(termVisitor)).collect(toList()));






        return expression;
    }
}
