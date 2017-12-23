package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.VariableDef;
import types.enums.VarType;

public class VariableVisitor extends ExpBaseVisitor<VariableDef> {

    @Override
    public VariableDef visitVariableDef(ExpParser.VariableDefContext ctx) {
        System.out.println("Visit variableDef");
        VariableDef variableDef = new VariableDef();

        variableDef.name = ctx.IDENT().getText();
        variableDef.type = VarType.getType(ctx.TYPE().getText());
        variableDef.isConstant = ctx.variableConst()!=null;
        if(ctx.variableValue() == null){
            variableDef.initialized = false;
            variableDef.value = 0;
        }else {
            variableDef.initialized = true;
            variableDef.value = getValue(variableDef.type, ctx.variableValue().getText());
        }
        
        System.out.println(variableDef);
        return variableDef;
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
