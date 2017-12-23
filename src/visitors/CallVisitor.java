package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import org.antlr.v4.runtime.tree.TerminalNode;
import types.Call;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CallVisitor extends ExpBaseVisitor<Call> {
    @Override
    public Call visitCallStatement(ExpParser.CallStatementContext ctx) {
        System.out.println("Visit Call");
        Call call=new Call();
        call.functionName=ctx.IDENT().toString();
        call.parameters = new ArrayList<>();

        List<TerminalNode> nodes = ctx.callParam().IDENT();
        for (TerminalNode node :
                nodes) {
            call.parameters.add(node.getText());
        }
        return call;
    }
}
