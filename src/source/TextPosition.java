package source;

/**
 * Created by Wiktor on 13.05.2017.
 */
public class TextPosition {
    private int lineNumber;
    private int columnNumber;

    public TextPosition(int lineNumber, int columnNumber){
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

    public int getLineNumber(){
        return lineNumber;
    }

    public int getColumnNumber(){
        return columnNumber;
    }
}
