package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Factor;

public class FactorVisitor extends ExpBaseVisitor<Factor> {

    @Override
    public Factor visitFactor(ExpParser.FactorContext ctx) {
        System.out.println("Visit Factor  "+ctx.getText());
        Factor factor=new Factor();



        if (ctx.IDENT()!=null){
            factor.factorType=2;
            factor.identificator=ctx.IDENT().getText();
        }else if (ctx.NUMBER()!=null){
            factor.factorType=1;
            factor.value=Integer.parseInt(ctx.NUMBER().getText());
        }else if (ctx.BOOLVALUE()!=null){
            factor.factorType=0;
            factor.value= (ctx.BOOLVALUE().equals("true")) ? (1) : (0);
        }


        return factor;
    }
}
