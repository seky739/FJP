package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.VariableDef;
import types.enums.VarType;

public class VariableVisitor extends ExpBaseVisitor<VariableDef> {

    @Override
    public VariableDef visitVariableDef(ExpParser.VariableDefContext ctx) {
        VariableDef variableDef = new VariableDef();

        variableDef.name = ctx.IDENT().getText();
        variableDef.type = VarType.getType(ctx.TYPE().getText());
        variableDef.isVarConstant = ctx.variableConst()!=null;
        variableDef.isConstant = false;
        if(ctx.variableValue() == null){
            variableDef.initialized = false;
            variableDef.value = 0;
        }else {
            variableDef.initialized = true;
            variableDef.value = getValue(ctx.variableValue().getText());
        }
        return variableDef;
    }

    private int getValue(String value){
        int result = 0;
        if(value.equals("true")){
            result = 1;
        }else if(value.equals("false")){
            result = 0;
        }else {
            result = Integer.parseInt(value);
        }
        return result;
    }
}
