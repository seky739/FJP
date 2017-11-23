package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Switch;

import static java.util.stream.Collectors.toList;

public class SwitchVisitor extends ExpBaseVisitor<Switch> {
    @Override
    public Switch visitSwitchStatement(ExpParser.SwitchStatementContext ctx) {
        CasVisitor casVisitor=new CasVisitor();
        DefaultCaseVisitor defaultCaseVisitor=new DefaultCaseVisitor();
        Switch sWitch=new Switch();

        sWitch.variable.name=ctx.IDENT().getText();
        sWitch.cases.addAll(ctx.cas().stream().map(casContext -> casContext.accept(casVisitor)).collect(toList()));
        sWitch.defaultCase=defaultCaseVisitor.visitDefaultcas(ctx.defaultcas());

        System.out.println("Visit Switch");
        return sWitch;
    }
}
