package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import org.antlr.v4.runtime.tree.TerminalNode;
import types.Expression;
import types.enums.AlgebraicOperations;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.stream.Collectors.toList;

public class ExpressionVisitor extends ExpBaseVisitor<Expression> {
    @Override
    public Expression visitExpression(ExpParser.ExpressionContext ctx) {
        System.out.println("Visit Expression  " +ctx.getText());
        TermVisitor termVisitor=new TermVisitor();
        FactorVisitor factorVisitor=new FactorVisitor();
        Expression expression=new Expression();
        expression.variableDefs =new ArrayList<>();
        expression.operations=new ArrayList<>();
        expression.terms=new ArrayList<>();

        /*if(ctx.factor()!=null){
            expression.variableDefs.addAll(ctx.factor().stream().map(factorContext -> factorContext.accept(factorVisitor)).collect(toList()));
        }*/
        expression.terms.addAll(ctx.term().stream().map(term -> term.accept(termVisitor)).collect(toList()));
        for (TerminalNode l:ctx.PREOPERATION()) {
            expression.operations.add(AlgebraicOperations.getOperation(l.getText()));
        }
        System.out.println( Arrays.toString(expression.operations.toArray()));





        return expression;
    }
}
