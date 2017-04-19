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
