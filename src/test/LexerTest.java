package test;

import lexer.Lexer;
import lexer.Token;
import org.junit.*;
import source.Source;

import java.util.LinkedList;

/**
 * Created by Wiktor on 19.04.2017.
 */
public class LexerTest {

    private LinkedList<Token> tokens;
    private Source source;
    private Lexer lexer;
    private String[] values;
    private int[] lines = {1,1,1,1,2,2,2,2,2,2,2,3,3,3,4,4,5,5,5,5,5,5,5,6,6,6,6,6,7,7,7,7,8,8,9,9,9,9,10,10,11,11,12,12};


    @Before
    public void intialize(){
        source = new Source("/Users/Wiktor/dev/IdeaProjects/TKOM/src/test/testFile.txt");
        lexer = new Lexer(source);
        tokens = lexer.convertToTokens();
        String file =  "condition xd contact 345 romek and tomek or wiktor not wojtek equals { } ( ) from monday to tuesday around h 34 " +
        "if s ms foreach test vibration or sound rolki every sunday location 345 month 1 day 3 h 23 m 3";
        values = file.split(" ");
    }

    @Test
    public void TokensValuesShouldBeCorrect() {

        for(int i = 0; i < values.length; i++) {
            Assert.assertEquals("Token.Value should be correct", values[i], tokens.get(i).getValue());
        }

    }

    @Test
    public void TokensLinesShouldBeCorrect() {

        for(int i = 0; i < values.length; i++) {
            Assert.assertEquals("Token.Line should be correct", lines[i], tokens.get(i).getPosition().getLineNumber());
        }

    }

    @Test
    public void TokensTypesShouldBeCorrect() {

            Assert.assertEquals("Token.Condition should be correct", Token.TYPE.CONDITION, tokens.get(0).getType());
            Assert.assertEquals("Token.Condition should be correct", Token.TYPE.STRING, tokens.get(1).getType());
            Assert.assertEquals("Token.Condition should be correct", Token.TYPE.CONTACT, tokens.get(2).getType());
            Assert.assertEquals("Token.Condition should be correct", Token.TYPE.BOOL_OPERATOR, tokens.get(5).getType());
            Assert.assertEquals("Token.Condition should be correct", Token.TYPE.OPERATOR, tokens.get(11).getType());
            Assert.assertEquals("Token.Condition should be correct", Token.TYPE.OPEN_INSTRUCTION, tokens.get(12).getType());
            Assert.assertEquals("Token.Condition should be correct", Token.TYPE.CLOSE_INSTRUCTION, tokens.get(13).getType());
            Assert.assertEquals("Token.Condition should be correct", Token.TYPE.OPEN_BRACKET, tokens.get(14).getType());
            Assert.assertEquals("Token.Condition should be correct", Token.TYPE.CLOSE_BRACKET, tokens.get(15).getType());
            Assert.assertEquals("Token.Condition should be correct", Token.TYPE.WEEKDAY, tokens.get(17).getType());
            Assert.assertEquals("Token.Condition should be correct", Token.TYPE.HOUR, tokens.get(21).getType());
            Assert.assertEquals("Token.Condition should be correct", Token.TYPE.IF_STATEMENT, tokens.get(23).getType());
            Assert.assertEquals("Token.Condition should be correct", Token.TYPE.TIME_UNIT, tokens.get(24).getType());
            Assert.assertEquals("Token.Condition should be correct", Token.TYPE.FOREACH_STATEMENT, tokens.get(26).getType());
            Assert.assertEquals("Token.Condition should be correct", Token.TYPE.ALARM_TYPE, tokens.get(30).getType());
            Assert.assertEquals("Token.Condition should be correct", Token.TYPE.EVERY_STATEMENT, tokens.get(32).getType());
            Assert.assertEquals("Token.Condition should be correct", Token.TYPE.LOCATION, tokens.get(34).getType());
            Assert.assertEquals("Token.Condition should be correct", Token.TYPE.MONTH, tokens.get(36).getType());
            Assert.assertEquals("Token.Condition should be correct", Token.TYPE.DAY, tokens.get(38).getType());
            Assert.assertEquals("Token.Condition should be correct", Token.TYPE.HOUR, tokens.get(40).getType());
            Assert.assertEquals("Token.Condition should be correct", Token.TYPE.MINUTE, tokens.get(42).getType());
    }

    @Test
    public void printResult(){
        for(Token token: tokens){
            System.out.println(token);
        }
    }

}
