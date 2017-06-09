package generator;

import java.util.Calendar;

/**
 * Created by Wiktor on 07.06.2017.
 */
public class Time implements Condition {
    private int hour = -1;
    private int minute = -1;
    private int hourFrom = -1;
    private int minuteFrom = -1;
    private int hourTo = -1;
    private int minuteTo = -1;

    public Time(int hour, int minute){
        this.hour = hour;
        this.minute = minute;
    }

    public Time(int hourFrom, int minuteFrom, int hourTo, int minuteTo){
        this.minuteFrom = minuteFrom;
        this.hourFrom = hourFrom;
        this.hourTo = hourTo;
        this.minuteTo = minuteTo;
    }

    @Override
    public boolean check() {
        Calendar calendar = Calendar.getInstance();
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        int currentMinute = calendar.get(Calendar.MINUTE);
        if(hour != -1 && minute != -1){
            if(currentHour == hour && currentMinute == minute){
                return true;
            } else {
                return false;
            }

        } else {
            if(currentHour == hourFrom && currentMinute == minuteFrom && currentMinute == minuteTo && currentHour == hourTo)
                return true;
            if(currentHour == hourFrom){
                if(currentMinute >= minuteFrom && currentMinute <= minuteTo){
                    return true;
                }else {
                    return false;
                }
            } else if (currentHour > hourFrom && currentHour < hourTo){
                return true;
            } else if (currentHour == hourTo){
                if(currentMinute < minuteTo){
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
