package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Factor;

public class FactorVisitor extends ExpBaseVisitor<Factor> {

    @Override
    public Factor visitFactor(ExpParser.FactorContext ctx) {
        System.out.println("Visit Factor");
        Factor factor=new Factor();



        if (ctx.IDENT().getText()!=null){
            factor.factorType=2;
            factor.identificator=ctx.IDENT().getText();
        }else if (ctx.NUMBER().getText()!=null){
            factor.factorType=1;
            factor.value=Integer.parseInt(ctx.NUMBER().getText());
        }else if (ctx.BOOLVALUE().getText()!=null){
            factor.factorType=0;
            factor.value= (ctx.BOOLVALUE().equals("true")) ? (1) : (0);
        }


        return factor;
    }
}
