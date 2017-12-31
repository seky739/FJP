package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.TernaryAssignment;
import types.VariableDef;

public class TernaryVisitor extends ExpBaseVisitor<TernaryAssignment>{

    @Override
    public TernaryAssignment visitTernaryAssignment(ExpParser.TernaryAssignmentContext ctx) {
        TernaryAssignment assignment = new TernaryAssignment();
        assignment.variableDef = new VariableDef();
        assignment.variableDef.name = ctx.IDENT().getText();
        assignment.variableDef.isConstant = false;

        assignment.condition = new ConditionVisitor().visitCondition(ctx.condition());

        ExpressionVisitor expressionVisitor = new ExpressionVisitor();
        assignment.trueExpression = expressionVisitor.visitExpression(ctx.expression(0));
        assignment.falseExpression = expressionVisitor.visitExpression(ctx.expression(1));

        return assignment;
    }
}
