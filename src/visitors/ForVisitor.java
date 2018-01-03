package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Cycle;
import types.UnaryOperation;
import types.VariableDef;
import types.enums.StatementType;

import static java.util.stream.Collectors.toList;

public class ForVisitor extends ExpBaseVisitor<Cycle> {

    @Override
    public Cycle visitForStatement(ExpParser.ForStatementContext ctx) {
        Cycle forCycle=new Cycle();
        ConditionVisitor conditionVisitor=new ConditionVisitor();
        StatementVisitor statementVisitor=new StatementVisitor();

        forCycle.type = StatementType.FOR;
        forCycle.condition=conditionVisitor.visitCondition(ctx.condition());
        forCycle.statements = ctx.statement().stream().map(statementContext -> statementContext.accept(statementVisitor)).collect(toList());

        UnaryVisitor unaryVisitor = new UnaryVisitor();
        forCycle.increment  = unaryVisitor.visitUnaryOperation(ctx.unaryOperation());

        return forCycle;
    }
}
