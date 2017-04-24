package lexer;

import java.util.LinkedList;
import java.io.*;

/**
 * Created by Wiktor on 18.04.2017.
 */
public class Lexer {

    public Lexer(){}

    private LinkedList<String> condition = new LinkedList<>();
    private LinkedList<String> contact = new LinkedList<>();
    private LinkedList<String> boolOperator = new LinkedList<>();
    private LinkedList<String> operator = new LinkedList<>();
    private LinkedList<String> openBracket = new LinkedList<>();
    private LinkedList<String> closeBracket = new LinkedList<>();
    private LinkedList<String> ifStatement = new LinkedList<>();
    private LinkedList<String> timeUnit = new LinkedList<>();
    private LinkedList<String> foreachStatement = new LinkedList<>();
    private LinkedList<String> alarmType = new LinkedList<>();
    private LinkedList<String> everyStatement = new LinkedList<>();
    private LinkedList<String> openInstruction = new LinkedList<>();
    private LinkedList<String> closeInstruction = new LinkedList<>();
    private LinkedList<String> location = new LinkedList<>();
    private LinkedList<String> month = new LinkedList<>();
    private LinkedList<String> day = new LinkedList<>();
    private LinkedList<String> weekday = new LinkedList<>();
    private LinkedList<String> hour = new LinkedList<>();
    private LinkedList<String> minute = new LinkedList<>();
    private LinkedList<String> singleChar = new LinkedList<>();

    public void addCondition(String e) {
        condition.add(e);
    }

    public void addContact(String e) {
        contact.add(e);
    }

    public void addBoolOperator(String e) {
        boolOperator.add(e);
    }

    public void addOperator(String e) {
        operator.add(e);
    }

    public void addOpenBracket(String e) {
        openBracket.add(e);
    }

    public void addCloseBracket(String e) {
        closeBracket.add(e);
    }

    public void addIfStatement(String e) {
        ifStatement.add(e);
    }

    public void addTimeUnit(String e) {
        timeUnit.add(e);
    }

    public void addForeachStatement(String e) {
        foreachStatement.add(e);
    }

    public void addAlarmType(String e) {
        alarmType.add(e);
    }

    public void addEveryStatement(String e) {
        everyStatement.add(e);
    }

    public void addOpenInstruction(String e) {
        openInstruction.add(e);
    }

    public void addCloseInstruction(String e) {
        closeInstruction.add(e);
    }

    public void addLocation(String e) {
        location.add(e);
    }

    public void addMonth(String e) {
        month.add(e);
    }

    public void addDay(String e) {
        day.add(e);
    }

    public void addWeekday(String e) {
        weekday.add(e);
    }

    public void addHour(String e) {
        hour.add(e);
    }

    public void addMinute(String e) {
        minute.add(e);
    }

    public void addSingleChar(String e){
        singleChar.add(e);
    }

    public boolean isCondition(String e) {
        return condition.contains(e);
    }

    public boolean isContact(String e) {
        return contact.contains(e);
    }

    public boolean isBoolOperator(String e) {
        return boolOperator.contains(e);
    }

    public boolean isOperator(String e) {
        return operator.contains(e);
    }

    public boolean isOpenBracket(String e) {
        return openBracket.contains(e);
    }

    public boolean isCloseBracket(String e) {
        return closeBracket.contains(e);
    }

    public boolean isIfStatement(String e) {
        return ifStatement.contains(e);
    }

    public boolean isTimeUnit(String e) {
        return timeUnit.contains(e);
    }

    public boolean isForeachStatement(String e) {
        return foreachStatement.contains(e);
    }

    public boolean isAlarmType(String e) {
        return alarmType.contains(e);
    }

    public boolean isEveryStatement(String e) {
        return everyStatement.contains(e);
    }

    public boolean isOpenInstruction(String e) {
        return openInstruction.contains(e);
    }

    public boolean isCloseInstruction(String e) {
        return closeInstruction.contains(e);
    }

    public boolean isLocation(String e) {
        return location.contains(e);
    }

    public boolean isMonth(String e) {
        return month.contains(e);
    }

    public boolean isDay(String e) {
        return day.contains(e);
    }

    public boolean isWeekday(String e) {
        return weekday.contains(e);
    }

    public boolean isHour(String e) {
        return hour.contains(e);
    }

    public boolean isMinute(String e) {
        return minute.contains(e);
    }

    public boolean isSingleChar(String e){
        return singleChar.contains(e);
    }

    private Token.TYPE getTokenType(String string) {
        if (isCondition(string)) return Token.TYPE.CONDITION;
        if (isContact(string)) return Token.TYPE.CONTACT;
        if (isBoolOperator(string)) return Token.TYPE.BOOL_OPERATOR;
        if (isOperator(string)) return Token.TYPE.OPERATOR;
        if (isOpenBracket(string)) return Token.TYPE.OPEN_BRACKET;
        if (isCloseBracket(string)) return Token.TYPE.CLOSE_BRACKET;
        if (isIfStatement(string)) return Token.TYPE.IF_STATEMENT;
        if (isTimeUnit(string)) return Token.TYPE.TIME_UNIT;
        if (isForeachStatement(string)) return Token.TYPE.FOREACH_STATEMENT;
        if (isAlarmType(string)) return Token.TYPE.ALARM_TYPE;
        if (isEveryStatement(string)) return Token.TYPE.EVERY_STATEMENT;
        if (isOpenInstruction(string)) return Token.TYPE.OPEN_INSTRUCTION;
        if (isCloseInstruction(string)) return Token.TYPE.CLOSE_INSTRUCTION;
        if (isLocation(string)) return Token.TYPE.LOCATION;
        if (isMonth(string)) return Token.TYPE.MONTH;
        if (isDay(string)) return Token.TYPE.DAY;
        if (isWeekday(string)) return Token.TYPE.WEEKDAY;
        if (isHour(string)) return Token.TYPE.HOUR;
        if (isMinute(string)) return Token.TYPE.MINUTE;
        return Token.TYPE.STRING;
    }

    public LinkedList<Token> convertToTokens(String filename) {
        BufferedReader reader = null;
        LinkedList<Token> tokens = new LinkedList<>();
        try {
            reader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int character;
        int lineCounter = 1;
        String value = "";
        try {
            while ((character = reader.read()) != -1) {

                if(isSingleChar(Character.toString((char)character))){
                    if(value != "") {
                        Token.TYPE type = getTokenType(value);
                        tokens.add(new Token(value, filename, type, lineCounter));
                    }
                    Token.TYPE type = getTokenType(Character.toString((char)character));
                    tokens.add(new Token(Character.toString((char)character), filename, type, lineCounter));
                    continue;
                }

                if(character == ' ' || character == '\t' ) {
                    if(value != "") {
                        Token.TYPE type = getTokenType(value);
                        tokens.add(new Token(value, filename, type, lineCounter));
                    }
                    value = "";
                } else if(character == '\n') {
                    if(value != "") {
                        Token.TYPE type = getTokenType(value);
                        tokens.add(new Token(value, filename, type, lineCounter));
                    }
                    value = "";
                    lineCounter++;
                } else {
                    value += Character.toString((char)character);
                }

            }
            if(value != "") {
                Token.TYPE type = getTokenType(value);
                tokens.add(new Token(value, filename, type, lineCounter));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tokens;
    }
}
