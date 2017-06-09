import generator.Generator;
import lexer.Lexer;
import parser.Parser;
import semantics.Semantics;
import source.Source;
import test.LexerTest;
import utils.Contact;
import utils.Program;
import utils.Response;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.TimerTask;
import java.util.Timer;
import test.Logger;

public class Main {

    public static void main(String[] args) {
        //Source source = new Source("/Users/Wiktor/dev/IdeaProjects/TKOM/src/test/test.txt");
        Source source = new Source(args[0]);
        Lexer lexer = new Lexer(source);
        Parser parser = new Parser(lexer);
        Semantics semantics = new Semantics(parser.getProgram());
        Generator generator = new Generator(parser.getProgram());
        Scanner scanner = new Scanner(System.in);
        Logger logger = new  Logger();
        while (true) {
            String readString = scanner.nextLine();
            System.out.println(readString);
            if (readString.equals("")) {
                LinkedList<Response> responses = generator.check();
                logger.log(generator.check());
            }
            if (scanner.hasNextLine())
                readString = scanner.nextLine();
            else
                readString = null;
        }
    }


}


