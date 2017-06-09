package generator;

/**
 * Created by Wiktor on 08.06.2017.
 */
public class Contact {
    int number;
    String name;

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Contact(int number, String name){
        this.name = name;
        this.number = number;
    }
}
