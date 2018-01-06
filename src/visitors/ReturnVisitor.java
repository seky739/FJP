package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Return;
import types.VariableDef;

public class ReturnVisitor extends ExpBaseVisitor<Return> {
    @Override
    public Return visitRetrn(ExpParser.RetrnContext ctx) {
        Return retrn = new Return();
        if(ctx.IDENT() != null) {
            retrn.value = new VariableDef();
            retrn.value.name = ctx.IDENT().getText();
            retrn.value.isConstant = true;
        }
        return retrn;
    }
}
