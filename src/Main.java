import lexer.Lexer;
import parser.Parser;
import semantics.Semantics;
import source.Source;
import test.LexerTest;
import utils.Program;

public class Main {

    public static void main(String[] args) {
        Source source = new Source("/Users/Wiktor/dev/IdeaProjects/TKOM/src/test/test.txt");
        Lexer lexer = new Lexer(source);
        Parser parser = new Parser(lexer);
        Semantics semantics = new Semantics(parser.getProgram());
    }
}
