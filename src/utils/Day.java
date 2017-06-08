package utils;

/**
 * Created by Wiktor on 15.05.2017.
 */
public class Day extends Node {
    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    int from;
    int to;

    public Day() {
        super(AST.NODE_TYPE.DAY);
    }
    public void setDay(int from, int to){
        this.from = from;
        this.to = to;
    }
    public void setDay(int from){
        this.from = from;
        this.to = from;
    }

}
