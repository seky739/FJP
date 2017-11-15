package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Variable;
import types.enums.VarType;

public class VariableVisitor extends ExpBaseVisitor<Variable> {

    @Override
    public Variable visitVariable(ExpParser.VariableContext ctx) {
        System.out.println("Visit variable");
        Variable variable = new Variable();

        variable.name = ctx.IDENT().getText();
        variable.type = VarType.getType(ctx.TYPE().getText());
        variable.isConstant = ctx.variableConst()!=null;
        if(ctx.variableValue() == null){
            variable.initialized = false;
            variable.value = 0;
        }else {
            variable.initialized = true;
            variable.value = getValue(variable.type, ctx.variableValue().getText());
        }
        
        System.out.println(variable);
        return variable;
    }

    private int getValue(VarType type, String value){
        int result = 0;
        if(type == VarType.NUMBER){
            result = Integer.parseInt(value);
        }else {
            if(value.equals("true")){
                result = 1;
            }
        }
        return result;
    }
}
