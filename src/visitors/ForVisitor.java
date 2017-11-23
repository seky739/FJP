package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Cycle;

import static java.util.stream.Collectors.toList;

public class ForVisitor extends ExpBaseVisitor<Cycle> {

    @Override
    public Cycle visitForStatement(ExpParser.ForStatementContext ctx) {
        Cycle forCycle=new Cycle();
        ConditionVisitor conditionVisitor=new ConditionVisitor();
        StatementVisitor statementVisitor=new StatementVisitor();

        forCycle.condition=conditionVisitor.visitCondition(ctx.condition());
        forCycle.statements.addAll(ctx.statement().stream().map(statementContext -> statementContext.accept(statementVisitor)).collect(toList()));


        System.out.println("Visit For");
        return forCycle;
    }
}
