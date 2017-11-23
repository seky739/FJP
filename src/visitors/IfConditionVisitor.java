package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.IfCondition;

public class IfConditionVisitor extends ExpBaseVisitor<IfCondition> {

    @Override
    public IfCondition visitIfCondition(ExpParser.IfConditionContext ctx) {
        System.out.println("Visit If Conditon");

        //from there visit condition
      return super.visitIfCondition(ctx);
    }
}
