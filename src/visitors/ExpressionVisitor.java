package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import org.antlr.v4.runtime.tree.TerminalNode;
import types.Expression;
import types.enums.ValueOperations;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.stream.Collectors.toList;

public class ExpressionVisitor extends ExpBaseVisitor<Expression> {
    @Override
    public Expression visitExpression(ExpParser.ExpressionContext ctx) {
        TermVisitor termVisitor = new TermVisitor();

        Expression expression = new Expression();
        expression.operations = new ArrayList<>();
        expression.terms = new ArrayList<>();


        expression.terms.addAll(ctx.term().stream().map(term -> term.accept(termVisitor)).collect(toList()));
        if(expression.terms.size()>1){
            if(ctx.PREOPERATION() != null){
                for (TerminalNode terminalNode : ctx.PREOPERATION()) {
                    expression.operations.add(ValueOperations.getOperationByChar(terminalNode.getText()));
                }
            }else {
                for (TerminalNode terminalNode : ctx.BOOLOPERATION()) {
                    expression.operations.add(ValueOperations.getOperationByChar(terminalNode.getText()));
                }
            }
        }
        return expression;
    }


}
