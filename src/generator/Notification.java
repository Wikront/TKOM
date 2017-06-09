package generator;

import utils.*;
import utils.Contact;
import java.util.TimerTask;
import java.util.Timer;

import java.util.LinkedList;

/**
 * Created by Wiktor on 07.06.2017.
 */
public class Notification {
    int type;
    String message;
    int interval;
    int count;
    LinkedList<generator.Contact> contacts;
    Condition condition;

    public Notification(String message, Condition condition){
        this.message = message;
        this.type = 0;
        this.condition = condition;

    }
    public Notification(String message, int interval, int count, Condition condition){
        this.message = message;
        this.interval = interval;
        this.count = count;
        this.type = 1;
        this.condition = condition;

    }
    public Notification(String message, LinkedList<generator.Contact> contacts, Condition condition){
        this.message = message;
        this.contacts = contacts;
        this.type = 2;
        this.condition = condition;
    }

    private Response trigger(){
//        if(this.type == 0){
//            System.out.println("notification: " + message);
//        }
//        if(this.type == 1){
//            Timer timer = new Timer(true);
//            timer.schedule(new ScheduledTask(message, count), 1, interval);
//        }
//        if(this.type == 2){
//            for(int i = 0; i < contacts.size(); i++){
//                System.out.println("message: " + message + " to contact: " + contacts.get(i));
//            }
//        }

        if(this.type == 0){
            return new Response(message);
        }
        if(this.type == 1){
            return new Response(message, interval, count);
        }
        if(this.type == 2){
            for(int i = 0; i < contacts.size(); i++){
                return new Response(message, contacts);
            }
        }
        return null;
    }

    public Response check(){
        if(condition.check())
            return trigger();
        else return null;
    }
}


