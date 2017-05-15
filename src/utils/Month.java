package utils;

/**
 * Created by Wiktor on 15.05.2017.
 */
public class Month extends Node {
    private String from;
    private String to;

    public Month() {
        super(AST.NODE_TYPE.MONTH);
    }
    public void setMonth(String from, String to){
        this.from = from;
        this.to = to;
    }
    public void setMonth(String form){
        this.from = form;
        this.to = form;
    }
}
