import org.antlr.v4.runtime.*;
import expSources.*;



public class Main {

    public static void main(String[] args) {
        ANTLRInputStream in = new ANTLRInputStream("const int identifikace:=2;function identifikator( int id1):void;const int iD:=2;begin return id;end.");
        ExpLexer lexer = new ExpLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExpParser parser = new ExpParser(tokens);

        System.out.println(parser.program().toStringTree());

    }

}

