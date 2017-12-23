package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import org.antlr.v4.runtime.tree.TerminalNode;
import types.ParalelAssignment;

import java.util.ArrayList;
import java.util.List;

public class ParallelAssignmentVisitor extends ExpBaseVisitor<ParalelAssignment>{
    @Override
    public ParalelAssignment visitParalelAssignment(ExpParser.ParalelAssignmentContext ctx) {
        ParalelAssignment assignment = new ParalelAssignment();
        assignment.varNames = new ArrayList<>();
        assignment.values = new ArrayList<>();

        List<TerminalNode> identList = ctx.IDENT();
        for (TerminalNode n :
                identList) {
            assignment.varNames.add(n.getText());
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
        return assignment;
    }
}
