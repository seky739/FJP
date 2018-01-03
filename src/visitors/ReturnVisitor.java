package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Return;

public class ReturnVisitor extends ExpBaseVisitor<Return> {
    @Override
    public Return visitRetrn(ExpParser.RetrnContext ctx) {
        Return retrn=new Return();

        if(ctx.IDENT()!=null) {
            retrn.value.name = ctx.IDENT().getText();
        }else {
            retrn.value.initialized=false;
        }
        return retrn;
    }
}
