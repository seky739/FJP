package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Cycle;

public class DoWhileVisitor extends ExpBaseVisitor<Cycle> {
    @Override
    public Cycle visitDoWhileStatement(ExpParser.DoWhileStatementContext ctx) {
        System.out.println("Visit Do While");
        return super.visitDoWhileStatement(ctx);
    }
}
