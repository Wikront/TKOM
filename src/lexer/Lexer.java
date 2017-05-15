package lexer;

import source.Source;
import source.TextPosition;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Wiktor on 18.04.2017.
 */
public class Lexer {
    private Source source;
    int character = -2;

    public Lexer(Source source){
        this.source = source;
        initializeTokenTypes();
        initializeNoWhitespaceTokens();
    }
    private HashMap<String, Token.TYPE> tokenTypes = new HashMap<>();

    private void initializeTokenTypes(){
        tokenTypes.put("condition", Token.TYPE.CONDITION);
        tokenTypes.put("contact", Token.TYPE.CONTACT);
        tokenTypes.put("and", Token.TYPE.BOOL_OPERATOR);
        tokenTypes.put("or", Token.TYPE.BOOL_OPERATOR);
        tokenTypes.put("not", Token.TYPE.NOT);
        tokenTypes.put("equals", Token.TYPE.OPERATOR);
        tokenTypes.put("from", Token.TYPE.OPERATOR);
        tokenTypes.put("to", Token.TYPE.TO);
        tokenTypes.put("around", Token.TYPE.AROUND);
        tokenTypes.put("(", Token.TYPE.OPEN_BRACKET);
        tokenTypes.put(")", Token.TYPE.CLOSE_BRACKET);
        tokenTypes.put("if", Token.TYPE.IF_STATEMENT);
        tokenTypes.put("s", Token.TYPE.TIME_UNIT);
        tokenTypes.put("ms", Token.TYPE.TIME_UNIT);
        tokenTypes.put("foreach", Token.TYPE.FOREACH_STATEMENT);
        tokenTypes.put("vibration", Token.TYPE.ALARM_TYPE);
        tokenTypes.put("sound", Token.TYPE.ALARM_TYPE);
        tokenTypes.put("every", Token.TYPE.EVERY_STATEMENT);
        tokenTypes.put("{", Token.TYPE.OPEN_INSTRUCTION);
        tokenTypes.put("}", Token.TYPE.CLOSE_INSTRUCTION);
        tokenTypes.put("location", Token.TYPE.LOCATION);
        tokenTypes.put("month", Token.TYPE.MONTH);
        tokenTypes.put("day", Token.TYPE.DAY);
        tokenTypes.put("weekday", Token.TYPE.WEEKDAY);
        tokenTypes.put("monday", Token.TYPE.WEEKDAY_TYPE);
        tokenTypes.put("tuesday", Token.TYPE.WEEKDAY_TYPE);
        tokenTypes.put("wednesday", Token.TYPE.WEEKDAY_TYPE);
        tokenTypes.put("thursday", Token.TYPE.WEEKDAY_TYPE);
        tokenTypes.put("friday", Token.TYPE.WEEKDAY_TYPE);
        tokenTypes.put("saturday", Token.TYPE.WEEKDAY_TYPE);
        tokenTypes.put("sunday", Token.TYPE.WEEKDAY_TYPE);
        tokenTypes.put("h", Token.TYPE.HOUR);
        tokenTypes.put("m", Token.TYPE.MINUTE);
        tokenTypes.put("time", Token.TYPE.TIME);
        tokenTypes.put("January", Token.TYPE.MONTH_VALUE);
        tokenTypes.put("February", Token.TYPE.MONTH_VALUE);
        tokenTypes.put("March", Token.TYPE.MONTH_VALUE);
        tokenTypes.put("April", Token.TYPE.MONTH_VALUE);
        tokenTypes.put("May", Token.TYPE.MONTH_VALUE);
        tokenTypes.put("June", Token.TYPE.MONTH_VALUE);
        tokenTypes.put("July", Token.TYPE.MONTH_VALUE);
        tokenTypes.put("August", Token.TYPE.MONTH_VALUE);
        tokenTypes.put("September", Token.TYPE.MONTH_VALUE);
        tokenTypes.put("October", Token.TYPE.MONTH_VALUE);
        tokenTypes.put("November", Token.TYPE.MONTH_VALUE);
        tokenTypes.put("December", Token.TYPE.MONTH_VALUE);
    }

    private HashMap<Character, Integer> noWhitespaceTokens = new HashMap<>();

    private void initializeNoWhitespaceTokens(){
        noWhitespaceTokens.put('(', 1);
        noWhitespaceTokens.put(')', 1);
        noWhitespaceTokens.put('{', 1);
        noWhitespaceTokens.put('}', 1);
    }

    private Token.TYPE getTokenType(String string) {
        if(tokenTypes.get(string) != null)
            return tokenTypes.get(string);
        else
            return Token.TYPE.STRING;
    }

    public Token getNextToken(){
        if(character == -2)
        {
            character = source.nextChar();
        }
        TextPosition position = source.getPosition();
        if(character == -1){
                return new Token("", Token.TYPE.EOF, position);
        }
        if(Character.isWhitespace((char)character)){  //skip whitespaces
            while(true){
                character = source.nextChar();
                if(!Character.isWhitespace((char)character))
                    break;
            }
        }
        if(Character.isAlphabetic((char)character)){ //keywords
            String value = "";
            int nextChar = character;
            while (true){
                value += Character.toString((char)nextChar);
                nextChar = source.nextChar();
                if(Character.isWhitespace((char)nextChar) || nextChar == -1){
                    character = nextChar;
                    return new Token(value, getTokenType(value), position);
                }
            }
        }
        if(Character.isDigit((char)character)){ //Numeric value
            String value = "";
            int nextChar = character;
            while (true){
                value += Character.toString((char)nextChar);
                nextChar = source.nextChar();
                if(Character.isWhitespace((char)nextChar) || nextChar == -1){
                    character = nextChar;
                    return new Token(value, Token.TYPE.NUMBER, position);
                }
            }
        }
        if((char)character == '{'){
            character = -2;
            return new Token("{", Token.TYPE.OPEN_INSTRUCTION, position);
        }
        if((char)character == '}'){
            character = -2;
            return new Token("}", Token.TYPE.CLOSE_INSTRUCTION, position);
        }
        if((char)character == '('){
            character = -2;
            return new Token("(", Token.TYPE.OPEN_BRACKET, position);
        }
        if((char)character == ')'){
            character = -2;
            return new Token(")", Token.TYPE.CLOSE_BRACKET, position);
        }
        if((char)character == '['){
            character = -2;
            return new Token("[", Token.TYPE.OPEN_MESSAGE, position);
        }
        if((char)character == ']'){
            character = -2;
            return new Token("]", Token.TYPE.CLOSE_MESSAGE, position);
        }
        return null;
    }

    /**___TEST_ONLY___**/
    public LinkedList<Token> convertToTokens() {
        LinkedList<Token> tokens = new LinkedList<>();
        while (true) {
            Token token = getNextToken();
            if(token.getType() == Token.TYPE.EOF)
                break;
            tokens.add(token);
        }
        return tokens;
    }
}
