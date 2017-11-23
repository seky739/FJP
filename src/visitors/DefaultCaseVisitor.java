package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.DefaultCase;


import static java.util.stream.Collectors.toList;

public class DefaultCaseVisitor extends ExpBaseVisitor<DefaultCase> {
    @Override
    public DefaultCase visitDefaultcas(ExpParser.DefaultcasContext ctx) {
        DefaultCase defaultCase=new DefaultCase();
        StatementVisitor statementVisitor=new StatementVisitor();
        defaultCase.caseStatement.addAll(ctx.statement().stream().map(statementContext -> statementContext.accept(statementVisitor)).collect(toList()));


        return defaultCase;
    }
}
