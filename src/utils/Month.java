package utils;

/**
 * Created by Wiktor on 15.05.2017.
 */
public class Month extends Node {
    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    private int from;
    private int to;

    public Month() {
        super(AST.NODE_TYPE.MONTH);
    }
    public void setMonth(String from, String to){
        this.from = convertMonth(from);
        this.to = convertMonth(to);
    }
    public void setMonth(String form){
        this.from = convertMonth(form);
        this.to = this.from;
    }
    private int convertMonth(String month){
        switch (month) {
            case "January":
                return 0;
            case "February":
                return 1;
            case "March":
                return 2;
            case "April":
                return 3;
            case "May":
                return 4;
            case "June":
                return 5;
            case "July":
                return 6;
            case "August":
                return 7;
            case "September":
                return 8;
            case "October":
                return 9;
            case "November":
                return 10;
            case "December":
                return 11;
            default:
                return -1;

        }
    }
}
