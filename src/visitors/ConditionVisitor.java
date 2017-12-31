package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Condition;
import types.enums.ConditionalOperation;

public class ConditionVisitor extends ExpBaseVisitor<Condition> {

    @Override
    public Condition visitCondition(ExpParser.ConditionContext ctx) {
        System.out.println("Visit Condition");
        ExpressionVisitor expressionVisitor = new ExpressionVisitor();
        Condition condition = new Condition();
        condition.operation= ConditionalOperation.getValue(ctx.COMPARATOR().getText());
        condition.leftPart=expressionVisitor.visitExpression(ctx.expression(0));
        condition.rightPart=expressionVisitor.visitExpression(ctx.expression(1));
        return condition;
    }
}
