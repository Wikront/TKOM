package utils;

/**
 * Created by Wiktor on 15.05.2017.
 */
public class Weekday extends Node {
    private int from;

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    private int to;

    public Weekday() {
        super(AST.NODE_TYPE.WEEKDAY);
    }
    public void setDay(String from, String to){

        this.from = convertDay(from);
        this.to = convertDay(to);
    }
    public void setDay(String from){
        this.from = convertDay(from);
        this.to = this.from;
    }
    private int convertDay(String day){
        switch (day){
            case "sunday":
                return 0;
            case "monday":
                return 1;
            case "tuesday":
                return 2;
            case "wednesday":
                return 3;
            case "thursday":
                return 4;
            case "friday":
                return 5;
            case "saturday":
                return 6;
            default:
                return -1;
        }
    }
}
