package parser;

import lexer.Lexer;
import lexer.Token;
import logger.Error;
import source.TextPosition;
import utils.*;

/**
 * Created by Wiktor on 14.05.2017.
 */
public class Parser {
    private Lexer lexer;
    private Error error;
    private Token token;
    private Program program;

    public Parser(Lexer lexer){
        this.lexer = lexer;
        this.error = new Error();
        token = new Token("", Token.TYPE.CONDITION, new TextPosition(0,0));
        program = parse();
    }

    public Program getProgram(){
        return program;
    }

    public Program parse(){
        return program();
    }

    private int accept(Token.TYPE type){
        token = lexer.getNextToken();
        if(token.getType() != type){
            error.expexted(type, token);
            return -1;
        }else {
            return 0;
        }
    }

    private int accept(Token.TYPE types[]){
        token = lexer.getNextToken();
        for(int i = 0; i < types.length; i++){
            if(token.getType() == types[i]){
                return i;
            }
        }
        error.unexpected(token);
        return -1;
    }

    private Program program(){
        Program program = new Program();
        Token.TYPE allowed[] = {Token.TYPE.CONDITION, Token.TYPE.IF_STATEMENT, Token.TYPE.FOREACH_STATEMENT, Token.TYPE.EVERY_STATEMENT, Token.TYPE.CONTACT, Token.TYPE.EOF};
        while (token.getType() != Token.TYPE.EOF){
            int index = accept(allowed);
            switch (index){
                case 0:
                    program.addCondition(condition());
                    break;
                case 1:
                    program.addIfStatement(ifStatement());
                    break;
                case 2:
                    program.addForeachStatement(foreachStatement());
                    break;
                case 3:
                    program.addEveryStatement(everyStatement());
                    break;
                case 4:
                    program.addContact(contact());
            }
        }

        return program;
    }

    private Condition condition(){
        Condition condition = new Condition();
        accept(Token.TYPE.STRING);
        condition.setName(token.getValue());
        Token.TYPE allowed[] = {Token.TYPE.MONTH, Token.TYPE.LOCATION, Token.TYPE.WEEKDAY, Token.TYPE.DAY, Token.TYPE.TIME};
        int index = accept(allowed);
        switch (index){
            case 0:
                condition.setType(Token.TYPE.MONTH);
                condition.setMonth(month());
                break;
            case 1:
                condition.setType(Token.TYPE.LOCATION);
                condition.setLocation(location());
                break;
            case 2:
                condition.setType(Token.TYPE.WEEKDAY);
                condition.setWeekday(weekday());
                break;
            case 3:
                condition.setType(Token.TYPE.DAY);
                condition.setDay(day());
                break;
            case 4:
                condition.setType(Token.TYPE.TIME);
                condition.setTime(time());
        }
        return condition;
    }

    private Month month(){
        Month month = new Month();
        accept(Token.TYPE.OPERATOR);
        if(token.getValue().equals("from")){
            accept(Token.TYPE.MONTH_VALUE);
            String from = token.getValue();
            accept(Token.TYPE.TO);
            accept(Token.TYPE.MONTH_VALUE);
            month.setMonth(from, token.getValue());
        } else {
            accept(Token.TYPE.MONTH_VALUE);
            month.setMonth(token.getValue());
        }
        return month;
    }

    private Location location(){
        Location location = new Location();
        accept(Token.TYPE.AROUND);
        accept(Token.TYPE.NUMBER);
        try {
            location.setAround(Integer.parseInt(token.getValue()));
        }catch (Exception e){

        }
        accept(Token.TYPE.NUMBER);
        try {
            location.setX(Float.parseFloat(token.getValue()));
        }catch (Exception e){

        }
        accept(Token.TYPE.NUMBER);
        try {
            location.setY(Float.parseFloat(token.getValue()));
        }catch (Exception e){

        }
        return location;
    }

    private Weekday weekday(){
        Weekday weekday = new Weekday();
        accept(Token.TYPE.OPERATOR);
        if(token.getValue().equals("from")){
            accept(Token.TYPE.WEEKDAY_TYPE);
            String from = token.getValue();
            accept(Token.TYPE.TO);
            accept(Token.TYPE.WEEKDAY_TYPE);
            weekday.setDay(from, token.getValue());
        } else if (token.getValue().equals("equals")){
            accept(Token.TYPE.WEEKDAY_TYPE);
            weekday.setDay(token.getValue());
        }
        return weekday;
    }

    private Day day(){
        Day day = new Day();
        accept(Token.TYPE.OPERATOR);
        if(token.getValue().equals("from")){
            accept(Token.TYPE.NUMBER);
            int from = Integer.parseInt(token.getValue());
            accept(Token.TYPE.TO);
            accept(Token.TYPE.NUMBER);
            day.setDay(from, Integer.parseInt(token.getValue()));
        } else if (token.getValue().equals("equals")){
            accept(Token.TYPE.NUMBER);
            day.setDay(Integer.parseInt(token.getValue()));
        }
        return day;
    }

    private Time time(){
        Time time = new Time();
        accept(Token.TYPE.NUMBER);
        try {
            time.setHours(Integer.parseInt(token.getValue()));
        }catch (Exception e){

        }
        accept(Token.TYPE.HOUR);
        accept(Token.TYPE.NUMBER);
        try {
            time.setMinutes(Integer.parseInt(token.getValue()));
        }catch (Exception e){

        }
        accept(Token.TYPE.MINUTE);
        return time;
    }

    private Contact contact(){
        Contact contact = new Contact();
        accept(Token.TYPE.STRING);
        contact.setName(token.getValue());
        accept(Token.TYPE.NUMBER);
        try {
            contact.setNumber(Integer.parseInt(token.getValue()));
        }catch (Exception e){

        }
        return contact;
    }

    private IfStatement ifStatement(){
        IfStatement ifStatement = new IfStatement();
        ifStatement.setIfCondition(ifCondition());
        ifStatement.setBlock(block());
        return ifStatement;
    }

    private ForeachStatement foreachStatement(){
        ForeachStatement foreachStatement = new ForeachStatement();
        foreachStatement.setBlock(block());
        return foreachStatement;
    }

    private EveryStatement everyStatement(){
        EveryStatement everyStatement = new EveryStatement();
        accept(Token.TYPE.OPEN_BRACKET);
        accept(Token.TYPE.NUMBER);
        everyStatement.setTime(Integer.parseInt(token.getValue()));
        accept(Token.TYPE.CLOSE_BRACKET);
        everyStatement.setBlock(block());
        return everyStatement;
    }

    private IfCondition ifCondition(){
        IfCondition ifCondition = new IfCondition();
        accept(Token.TYPE.OPEN_BRACKET);
        while(token.getType() != Token.TYPE.CLOSE_BRACKET){
            Token.TYPE allowed[] = {Token.TYPE.NOT, Token.TYPE.STRING};
            int index = accept(allowed);
            if(index == 0){
                accept(Token.TYPE.STRING);
                ifCondition.addNot(token.getValue());
            }
            ifCondition.addSingleCondition(token.getValue());
            Token.TYPE allowed1[] = {Token.TYPE.CLOSE_BRACKET, Token.TYPE.BOOL_OPERATOR};
            accept(allowed1);
            if(index == 1){
                ifCondition.addOperator(token.getValue());
            }else{
               break;
            }
        }
        return ifCondition;
    }

    private Block block(){
        Block block = new Block();
        accept(Token.TYPE.OPEN_INSTRUCTION);
        accept(Token.TYPE.OPEN_MESSAGE);
        while (token.getType() != Token.TYPE.CLOSE_MESSAGE){
            Token.TYPE allowed[] = {Token.TYPE.STRING, Token.TYPE.CLOSE_MESSAGE};
            int index = accept(allowed);
            if(index == 0){
                block.addWord(token.getValue());
            }else {
                break;
            }
        }
        accept(Token.TYPE.CLOSE_INSTRUCTION);
        return block;
    }
}
