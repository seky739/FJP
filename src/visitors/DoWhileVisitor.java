package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Cycle;

import static java.util.stream.Collectors.toList;

public class DoWhileVisitor extends ExpBaseVisitor<Cycle> {
    @Override
    public Cycle visitDoWhileStatement(ExpParser.DoWhileStatementContext ctx) {
        Cycle doWhile =new Cycle();
        StatementVisitor statementVisitor=new StatementVisitor();
        ConditionVisitor conditionVisitor=new ConditionVisitor();
        doWhile.statements.addAll(ctx.statement().stream().map(statementContext -> statementContext.accept(statementVisitor)).collect(toList()));
        doWhile.condition=conditionVisitor.visitCondition(ctx.condition());


        System.out.println("Visit Do While");
        return doWhile;
    }
}
