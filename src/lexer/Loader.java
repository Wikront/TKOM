package lexer;

import java.util.LinkedList;

/**
 * Created by Wiktor on 18.04.2017.
 */
public class Loader {

    private Lexer lexer = new Lexer();
    private LinkedList<Token> tokens;

    public Loader(String filename){
        initializeLexer();
        tokens = lexer.convertToTokens(filename);
    }

    public LinkedList<Token> getTokens(){
        return tokens;
    }

    private void initializeLexer(){
        lexer.addCondition("condition");
        lexer.addContact("contact");
        lexer.addBoolOperator("and");
        lexer.addBoolOperator("or");
        lexer.addBoolOperator("not");
        lexer.addOperator("equals");
        lexer.addOperator("from");
        lexer.addOperator("to");
        lexer.addOperator("around");
        lexer.addOpenBracket("(");
        lexer.addCloseBracket(")");
        lexer.addIfStatement("if");
        lexer.addTimeUnit("s");
        lexer.addTimeUnit("ms");
        lexer.addForeachStatement("foreach");
        lexer.addAlarmType("vibration");
        lexer.addAlarmType("sound");
        lexer.addEveryStatement("every");
        lexer.addOpenInstruction("{");
        lexer.addCloseInstruction("}");
        lexer.addLocation("location");
        lexer.addMonth("month");
        lexer.addDay("day");
        lexer.addWeekday("monday");
        lexer.addWeekday("tuesday");
        lexer.addWeekday("wednesday");
        lexer.addWeekday("thursday");
        lexer.addWeekday("friday");
        lexer.addWeekday("saturday");
        lexer.addWeekday("sunday");
        lexer.addHour("h");
        lexer.addMinute("m");
    }
}
