package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Switch;

public class SwitchVisitor extends ExpBaseVisitor<Switch> {
    @Override
    public Switch visitSwitchStatement(ExpParser.SwitchStatementContext ctx) {
        System.out.println("Visit Switch");
        return super.visitSwitchStatement(ctx);
    }
}
