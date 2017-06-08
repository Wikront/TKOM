package generator;

/**
 * Created by Wiktor on 08.06.2017.
 */
public class Cond implements Condition {
    Condition first;
    Condition second;
    int operator;
    boolean firstNot;
    boolean secondNot;

    public Cond(Condition first, Condition second, int operator, boolean firstNot, boolean secondNot){
        this.first = first;
        this.second = second;
        this.firstNot = firstNot;
        this.secondNot = secondNot;
        this.operator = operator;
    }

    @Override
    public boolean check() {
        boolean firstResult;
        boolean secondResult;
        if(firstNot){
            firstResult = !first.check();
        }else {
            firstResult = first.check();
        }
        if(secondNot){
            secondResult = !second.check();
        }else {
            secondResult = second.check();
        }
        if(operator == 0){
            return firstResult && secondResult;
        } else {
            return firstResult || secondResult;
        }
    }
}
