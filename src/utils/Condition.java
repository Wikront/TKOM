package utils;

import lexer.Token;

/**
 * Created by Wiktor on 15.05.2017.
 */
public class Condition extends Node {
    private Token.TYPE type;
    private String name;

    public Location getLocation() {
        return location;
    }

    public Weekday getWeekday() {
        return weekday;
    }

    public Day getDay() {
        return day;
    }

    public Month getMonth() {
        return month;
    }

    public Time getTime() {
        return time;
    }

    private Location location;
    private Weekday weekday;
    private Day day;
    private Month month;
    private Time time;
    private boolean multipleCondition = false;
    private String operator;
    private String firstConditionName;

    public String getOperator() {
        return operator;
    }

    public String getFirstConditionName() {
        return firstConditionName;
    }

    public String getSecondConditionName() {
        return secondConditionName;
    }

    public boolean isFirstNot() {
        return firstNot;
    }

    public boolean isSecondNot() {
        return secondNot;
    }

    private String secondConditionName;
    private boolean firstNot = false;
    private boolean secondNot = false;

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
    public void setOperator(String operator){
        this.operator = operator;
    }
    public void setFirstConditionName(String firstConditionName){
        this.firstConditionName = firstConditionName;
    }
    public void setSecondConditionName(String secondConditionName){
        this.secondConditionName = secondConditionName;
    }
    public void setMultipleCondition(boolean multipleCondition){
        this.multipleCondition = multipleCondition;
    }
    public void setFirsNot(){
        firstNot = true;
    }
    public void setSecondNot(){
        secondNot = true;
    }
    public Token.TYPE getType() { return type; }
    public boolean isMultipleCondition(){
        return multipleCondition;
    }

}
