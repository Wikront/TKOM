package utils;

/**
 * Created by Wiktor on 15.05.2017.
 */
public class Time extends Node {
    public int getHoursTo() {
        return hoursTo;
    }

    public int getMinutesTo() {
        return minutesTo;
    }

    private int hoursFrom;

    public void setHoursTo(int hoursTo) {
        this.hoursTo = hoursTo;
    }

    public void setMinutesTo(int minutesTo) {
        this.minutesTo = minutesTo;
    }

    private int minutesFrom;
    private int hoursTo;
    private int minutesTo;

    public int getHoursFrom() {
        return hoursFrom;
    }

    public int getMinutesFrom() {
        return minutesFrom;
    }

    public Time() {
        super(AST.NODE_TYPE.TIME);
    }
    public void setMinutesFrom(int minutes){
        this.minutesFrom = minutes;
    }
    public void setHoursFrom(int hours){
        this.hoursFrom = hours;
    }
}
