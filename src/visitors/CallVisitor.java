package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Call;

public class CallVisitor extends ExpBaseVisitor<Call> {
    @Override
    public Call visitCallStatement(ExpParser.CallStatementContext ctx) {
        Call call=new Call();

        call.functionName=ctx.IDENT().toString();

        System.out.println("Visit Call");
        return call;
    }
}
