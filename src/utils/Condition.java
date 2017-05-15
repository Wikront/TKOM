package utils;

import lexer.Token;

/**
 * Created by Wiktor on 15.05.2017.
 */
public class Condition extends Node {
    private Token.TYPE type;
    private String name;
    private Location location;
    private Weekday weekday;
    private Day day;
    private Month month;
    private Time time;

    public Condition() {
        super(AST.NODE_TYPE.CONDITION);
    }
    public String getName(){ return name; }
    public void setType(Token.TYPE type){
        this.type = type;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setLocation(Location location){
        this.location = location;
    }
    public void setWeekday(Weekday weekday){
        this.weekday = weekday;
    }
    public void setDay(Day day){
        this.day = day;
    }
    public void setMonth(Month month){
        this.month = month;
    }
    public void setTime(Time time){
        this.time = time;
    }

}
