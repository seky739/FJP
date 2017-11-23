package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Cycle;

public class RepeatVisitor extends ExpBaseVisitor <Cycle> {

    @Override
    public Cycle visitRepeatStatement(ExpParser.RepeatStatementContext ctx) {
        System.out.println("Visit Repeat until");
        return super.visitRepeatStatement(ctx);
    }
}
