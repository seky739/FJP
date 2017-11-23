package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Switch;

import static java.util.stream.Collectors.toList;

public class SwitchVisitor extends ExpBaseVisitor<Switch> {
    @Override
    public Switch visitSwitchStatement(ExpParser.SwitchStatementContext ctx) {
        System.out.println("Visit Switch");

        CasVisitor casVisitor=new CasVisitor();
        Switch sWitch=new Switch();

        sWitch.variable.name=ctx.IDENT().getText();
        sWitch.cases = ctx.cas().stream().map(casContext -> casContext.accept(casVisitor)).collect(toList());
        sWitch.defaultCase=casVisitor.visitDefaultcas(ctx.defaultcas());

        return sWitch;
    }
}
