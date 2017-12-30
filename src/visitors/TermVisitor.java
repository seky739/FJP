package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import org.antlr.v4.runtime.tree.TerminalNode;
import types.Term;
import types.enums.ValueOperations;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.stream.Collectors.toList;

public class TermVisitor extends ExpBaseVisitor<Term> {
    public Term visitTerm(ExpParser.TermContext ctx) {
        System.out.println("Visit Term  " +ctx.getText());
        Term term=new Term();
        FactorVisitor factorVisitor=new FactorVisitor();

        term.factor=new ArrayList<>();
        term.operations=new ArrayList<>();


        term.factor.addAll(ctx.factor().stream().map(factorContext -> factorContext.accept(factorVisitor)).collect(toList()));
        if(term.factor.size()>1){
            for (TerminalNode t : ctx.MULDIV()) {
                term.operations.add(ValueOperations.getOperation(t.getText()));
            }
        }
        System.out.println( Arrays.toString(term.operations.toArray()));
        return term;
    }
}
