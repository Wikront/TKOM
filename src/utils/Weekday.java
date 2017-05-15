package utils;

/**
 * Created by Wiktor on 15.05.2017.
 */
public class Weekday extends Node {
    private String from;
    private String to;

    public Weekday() {
        super(AST.NODE_TYPE.WEEKDAY);
    }
    public void setDay(String from, String to){
        this.from = from;
        this.to = to;
    }
    public void setDay(String from){
        this.from = from;
        this.to = from;
    }
}
