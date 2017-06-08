package generator;

import java.util.Calendar;

/**
 * Created by Wiktor on 07.06.2017.
 */
public class Weekday implements Condition {
    private int number;
    private int from;
    private int to;
    private boolean not;

    public Weekday(int from, int to){
        this.from = from;
        this.to = to;
    }

    public Weekday(int number){
        this.number = number;
    }

    @Override
    public boolean check() {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if(number != -1){
            if(dayOfWeek == number){
                return true;
            }else {
                return false;
            }
        } else {
            if(dayOfWeek >= from && dayOfWeek <= to){
                return true;
            } else {
                return false;
            }
        }
    }
}
