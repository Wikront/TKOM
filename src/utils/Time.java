package utils;

/**
 * Created by Wiktor on 15.05.2017.
 */
public class Time extends Node {
    private int hours;
    private int minutes;

    public Time() {
        super(AST.NODE_TYPE.TIME);
    }
    public void setMinutes(int minutes){
        this.minutes = minutes;
    }
    public void setHours(int hours){
        this.hours = hours;
    }
}
