package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Call;

public class CallVisitor extends ExpBaseVisitor<Call> {
    @Override
    public Call visitCallStatement(ExpParser.CallStatementContext ctx) {
        System.out.println("Visit Call");
        return super.visitCallStatement(ctx);
    }
}
