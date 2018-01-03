package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import org.antlr.v4.runtime.tree.TerminalNode;
import types.ParallelAssignment;

import java.util.ArrayList;
import java.util.List;

public class ParallelAssignmentVisitor extends ExpBaseVisitor<ParallelAssignment>{

    @Override
    public ParallelAssignment visitParallelAssignment(ExpParser.ParallelAssignmentContext ctx) {
        ParallelAssignment assignment = null;
        if(ctx.IDENT().size() == ctx.variableValue().size()){
            assignment = new ParallelAssignment();
            assignment.variables = new ArrayList<>();
            assignment.values = new ArrayList<>();
            List<TerminalNode> identList = ctx.IDENT();
            for (TerminalNode n :
                    identList) {
                assignment.variables.add(n.getText());
            }

            List<ExpParser.VariableValueContext> valueContexts = ctx.variableValue();
            for (ExpParser.VariableValueContext v:
                    valueContexts) {
                int value = 0;
                if(v.BOOLVALUE() != null){
                    // is boolean
                    if(v.BOOLVALUE().getText().equals("true")){
                        value = 1;
                    }
                }else {
                    value = Integer.parseInt(v.NUMBER().getText());
                }
                assignment.values.add(value);
            }
        }else {
            System.err.println("Parallel assignment should have same number of left part as right part");
        }

        return assignment;
    }
}
