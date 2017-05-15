package lexer;

import source.TextPosition;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wiktor on 18.04.2017.
 */
public class Token {

    private TYPE type;
    private String value;
    private TextPosition position;

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
        STRING,
        NUMBER,
        EOF,
        TIME,
        NOT,
        OPEN_MESSAGE,
        CLOSE_MESSAGE,
        MONTH_VALUE,
        TO,
        AROUND,
        WEEKDAY_TYPE
    }

    public Token(String value, TYPE type, TextPosition position) {
        this.value = value;
        this.type = type;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Value: " + value + " | Token type: " + type + " | Line: " + position.getLineNumber() + " | Column: " + position.getColumnNumber();
    }

    public TYPE getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public TextPosition getPosition() {
        return position;
    }
}
