package generator;
import java.util.*;

/**
 * Created by Wiktor on 07.06.2017.
 */
public class Day implements Condition {
    private int number = -1;
    private int from = -1;
    private int to = -1;

    public Day(int from, int to){
        this.from = from;
        this.to = to;
    }

    public Day(int number){
        this.number = number;
    }

    @Override
    public boolean check() {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_MONTH);
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
