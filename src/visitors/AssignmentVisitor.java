package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Assignment;

import java.util.ArrayList;
import java.util.List;

public class AssignmentVisitor extends ExpBaseVisitor<Assignment> {

    //TODO michal

    @Override
    public Assignment visitAssignment(ExpParser.AssignmentContext ctx) {
        System.out.println("Visit Assignment "+ ctx.getText());
        ExpressionVisitor expressionVisitor=new ExpressionVisitor();

        Assignment assignment=new Assignment();
        assignment.varNames = new ArrayList<>();
        assignment.expression = expressionVisitor.visitExpression(ctx.expression());

        assignment.varNames.add(ctx.IDENT().getText()); // first variables

        List<ExpParser.MultipleAssignmentContext> otherVarNames = ctx.multipleAssignment();
        for (ExpParser.MultipleAssignmentContext c :
                otherVarNames) {
            assignment.varNames.add(c.IDENT().getText());
        }
        return assignment;
    }


}
