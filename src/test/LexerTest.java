package test;

import lexer.Loader;
import lexer.Token;

import java.util.LinkedList;

/**
 * Created by Wiktor on 19.04.2017.
 */
public class LexerTest {
    private Loader loader;
    private LinkedList<Token> tokens;

    public LexerTest(){
        loader = new Loader("/Users/Wiktor/IdeaProjects/TKOM/src/test/testFile.txt");
        tokens = loader.getTokens();
        printResult();
    }

    private void printResult(){
        for(Token token: tokens){
            System.out.println(token);
        }
    }
}
