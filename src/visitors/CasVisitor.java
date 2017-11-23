package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Case;

import static java.util.stream.Collectors.toList;


public class CasVisitor extends ExpBaseVisitor<Case> {

    @Override
    public Case visitCas(ExpParser.CasContext ctx) {
        StatementVisitor statementVisitor=new StatementVisitor();
        Case cas=new Case();
        cas.value=Integer.parseInt(ctx.NUMBER().getText());
        cas.caseStatement = ctx.statement().stream().map(statementContext -> statementContext.accept(statementVisitor)).collect(toList());

        return cas;
    }
}
