package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Variable;

public class VariableVisitor extends ExpBaseVisitor<Variable> {

    @Override
    public Variable visitVariable(ExpParser.VariableContext ctx) {
        System.out.println("Visit variable");
        Variable variable = new Variable();



        return variable;
    }
}
