package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Term;

import java.util.ArrayList;

import static java.util.stream.Collectors.toList;

public class TermVisitor extends ExpBaseVisitor<Term> {
    public Term visitTerm(ExpParser.TermContext ctx) {
        System.out.println("Visit Term");
        Term term=new Term();
        FactorVisitor factorVisitor=new FactorVisitor();

        term.factor=new ArrayList<>();
        term.operations=new ArrayList<>();


        term.factor.addAll(ctx.factor().stream().map(factorContext -> factorContext.accept(factorVisitor)).collect(toList()));
        //term.operations.addAll(ctx.MULDIV());
        return term;
    }
}
