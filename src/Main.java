import org.antlr.v4.runtime.*;
import expSources.*;


public class Main {

    public static void main(String[] args) {
        ANTLRInputStream in = new ANTLRInputStream("const int identifikace:=2; int id;function identifikator( int id1):void;const int iD:=2;const int kk45ll:=2,ll:=4; int id44,kk;id22:=+2+2;.");
        ExpLexer lexer = new ExpLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExpParser parser = new ExpParser(tokens);
        System.out.println(parser.program().toString());

    }
}
