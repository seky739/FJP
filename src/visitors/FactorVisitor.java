package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Call;
import types.Expression;
import types.Factor;
import types.VariableDef;
import types.enums.FactorType;
import types.enums.VarType;

public class FactorVisitor extends ExpBaseVisitor<Factor> {

    @Override
    public Factor visitFactor(ExpParser.FactorContext ctx) {
        System.out.println("Visit Factor  "+ctx.getText());
        Factor factor=new Factor();


        // ident
        if (ctx.IDENT()!=null){

            factor.factorType = FactorType.VARIABLE;
            factor.name = ctx.IDENT().getText();
            factor.vardef = new VariableDef();
            factor.vardef.name = ctx.IDENT().getText();
            if(ctx.NEGATION()!=null || ctx.PREOPERATION() != null){
                factor.vardef.negative = true;
            }

        }else if (ctx.NUMBER()!=null){ // number
            factor.factorType = FactorType.NUMBER;
            factor.vardef = new VariableDef();
            factor.vardef.setConstantNumber(ctx.NUMBER().getText());
            if(ctx.PREOPERATION()!= null && ctx.PREOPERATION().getText().equals("-")){
                factor.vardef.value *= -1;
            }
        }else if (ctx.BOOLVALUE()!=null){ // bool
            factor.factorType = FactorType.BOOLEAN;
            factor.vardef = new VariableDef();
            factor.vardef.setConstantBool(ctx.BOOLVALUE().getText());
            if(ctx.NEGATION() != null && ctx.NEGATION().getText().equals("!")){
                factor.vardef.value = factor.vardef.value == 1 ? 0 : 1;
            }
        }else if(ctx.expression() != null){
            factor.factorType = FactorType.EXPRESSION;
            factor.expression = new ExpressionVisitor().visitExpression(ctx.expression());
        }else if(ctx.callStatement() != null){
            factor.factorType = FactorType.CALL;

            CallVisitor callVisitor = new CallVisitor();
            Call call = callVisitor.visitCallStatement(ctx.callStatement());
            //TODO not done yet

        }


        return factor;
    }
}
