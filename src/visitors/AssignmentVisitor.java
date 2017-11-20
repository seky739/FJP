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
        System.out.println("Visit Assignment");
        ExpressionVisitor expressionVisitor=new ExpressionVisitor();

        Assignment assignment=new Assignment();
        assignment.varNames=new ArrayList<>();
        assignment.expressions=new ArrayList<>();
        assignment.varNames.add(ctx.IDENT().getText());

        assignment.expressions.add(expressionVisitor.visitExpression(ctx.expression()));
        //// Todo visitor EXPRESSION assignment.expressions.add();
        System.out.println(assignment.varNames.get(0)+":="+assignment.expressions.get(0).terms.get(0).factor.get(0).identificator);
        //List<String> nextVarnames = null;
        //assignment.varNames.addAll(nextVarnames);




        return assignment;
    }
}
