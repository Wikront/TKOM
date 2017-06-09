package generator;

import java.util.Calendar;

/**
 * Created by Wiktor on 07.06.2017.
 */
public class Month implements Condition {
    private int number = -1;
    private int from;
    private int to;

    public Month(int from, int to){
        this.from = from;
        this.to = to;
    }

    public Month(int number){
        this.number = number;
    }

    @Override
    public boolean check() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        System.out.println(from + " " + to + "  " + month);
        if(number != -1){
            if (number == month){
                return true;
            } else {
                return false;
            }
        } else {
            if (month >= from && month <= to){
                return true;
            } else {
                return false;
            }
        }
    }
}
