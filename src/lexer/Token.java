package lexer;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wiktor on 18.04.2017.
 */
public class Token {

    private TYPE type;
    private String value;
    private String filename;
    private int line;
    private static Map<TYPE, String> tokenTypes;

    static {
        tokenTypes = new HashMap<TYPE, String>();
        tokenTypes.put(TYPE.CONDITION, "condition");
        tokenTypes.put(TYPE.CONTACT, "contact");
        tokenTypes.put(TYPE.BOOL_OPERATOR, "bool_operator");
        tokenTypes.put(TYPE.OPERATOR, "operator");
        tokenTypes.put(TYPE.OPEN_BRACKET, "open_bracket");
        tokenTypes.put(TYPE.CLOSE_BRACKET, "close_bracket");
        tokenTypes.put(TYPE.IF_STATEMENT, "if_statement");
        tokenTypes.put(TYPE.TIME_UNIT, "time_unit");
        tokenTypes.put(TYPE.FOREACH_STATEMENT, "foreach_statement");
        tokenTypes.put(TYPE.ALARM_TYPE, "alarm_type");
        tokenTypes.put(TYPE.EVERY_STATEMENT, "every_statement");
        tokenTypes.put(TYPE.OPEN_INSTRUCTION, "open_instruction");
        tokenTypes.put(TYPE.CLOSE_INSTRUCTION, "close_instruction");
        tokenTypes.put(TYPE.LOCATION, "location");
        tokenTypes.put(TYPE.MONTH, "month");
        tokenTypes.put(TYPE.DAY, "day");
        tokenTypes.put(TYPE.WEEKDAY, "weekday");
        tokenTypes.put(TYPE.HOUR, "hour");
        tokenTypes.put(TYPE.MINUTE, "minute");
        tokenTypes.put(TYPE.STRING, "string");
    }

    public enum TYPE {
        CONDITION,
        CONTACT,
        BOOL_OPERATOR,
        OPERATOR,
        OPEN_BRACKET,
        CLOSE_BRACKET,
        IF_STATEMENT,
        TIME_UNIT,
        FOREACH_STATEMENT,
        ALARM_TYPE,
        EVERY_STATEMENT,
        OPEN_INSTRUCTION,
        CLOSE_INSTRUCTION,
        LOCATION,
        MONTH,
        DAY,
        WEEKDAY,
        HOUR,
        MINUTE,
        STRING
    }

    public Token(String value, String filename, TYPE type, int line) {
        this.value = value;
        this.filename = filename;
        this.type = type;
        this.line = line;
    }

    @Override
    public String toString() {
        return "Value: " + value + " | Token type: " + type + " | File: " + filename + " | Line: " + line;
    }

    public TYPE getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public String getFile() {
        return filename;
    }

    public int getLine() {
        return line;
    }
}
