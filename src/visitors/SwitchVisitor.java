package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Switch;
import types.VariableDef;

import static java.util.stream.Collectors.toList;

public class SwitchVisitor extends ExpBaseVisitor<Switch> {
    @Override
    public Switch visitSwitchStatement(ExpParser.SwitchStatementContext ctx) {
        CasVisitor casVisitor=new CasVisitor();
        Switch sWitch=new Switch();
        sWitch.variableDef = new VariableDef();
        sWitch.variableDef.name = ctx.IDENT().getText();
        sWitch.variableDef.isConstant = false;

        sWitch.cases = ctx.cas().stream().map(casContext -> casContext.accept(casVisitor)).collect(toList());
        sWitch.defaultCase = casVisitor.visitDefaultcas(ctx.defaultcas());

        return sWitch;
    }
}
