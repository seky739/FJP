package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Cycle;

public class WhileVisitor extends ExpBaseVisitor<Cycle> {
    @Override
    public Cycle visitWhileStatement(ExpParser.WhileStatementContext ctx) {
        System.out.println("Visit While");
        return super.visitWhileStatement(ctx);
    }
}
