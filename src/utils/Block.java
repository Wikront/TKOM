package utils;

/**
 * Created by Wiktor on 15.05.2017.
 */
public class Block extends Node {
    private String message;
    private ForeachStatement foreachStatement;
    int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public EveryStatement getEveryStatement() {

        return everyStatement;
    }

    private EveryStatement everyStatement;

    public Block() {
        super(AST.NODE_TYPE.BLOCK);
        message = "";
        foreachStatement = null;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setEveryStatement(EveryStatement everyStatement) {
        this.everyStatement = everyStatement;
    }

    public void addWord(String word){

        message += " ";
        message += word;
    }

    public void setForeachStatement(ForeachStatement foreachStatement){
        this.foreachStatement = foreachStatement;
    }

    public String getMessage(){
        return message;
    }

    public ForeachStatement getForeachStatement(){
        return foreachStatement;
    }
}
