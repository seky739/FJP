package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Cycle;

public class ForVisitor extends ExpBaseVisitor<Cycle> {

    @Override
    public Cycle visitForStatement(ExpParser.ForStatementContext ctx) {
        System.out.println("Visit For");
        return super.visitForStatement(ctx);
    }
}
