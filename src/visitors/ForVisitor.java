package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Cycle;
import types.enums.StatementType;

import static java.util.stream.Collectors.toList;

public class ForVisitor extends ExpBaseVisitor<Cycle> {

    @Override
    public Cycle visitForStatement(ExpParser.ForStatementContext ctx) {
        System.out.println("Visit For");
        Cycle forCycle=new Cycle();
        ConditionVisitor conditionVisitor=new ConditionVisitor();
        StatementVisitor statementVisitor=new StatementVisitor();

        forCycle.type = StatementType.FOR;
        forCycle.condition=conditionVisitor.visitCondition(ctx.condition());
        forCycle.statements = ctx.statement().stream().map(statementContext -> statementContext.accept(statementVisitor)).collect(toList());


        return forCycle;
    }
}
