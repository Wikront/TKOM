package test;

import utils.Response;

import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Wiktor on 09.06.2017.
 */
public class Logger {

    public Logger(){};

    public static void log(LinkedList<Response> responses){
        if(responses == null)
            return;
        for(int i = 0; i< responses.size(); i++){
            Response response = responses.get(i);
            if(response.getType() == 0){
                System.out.println("notification: " + response.getMessage());
            }
            if(response.getType() == 1){
                Timer timer = new Timer(true);
                timer.schedule(new ScheduledTask(response.getMessage(), response.getCount()), 1, response.getInterval());
            }
            if(response.getType() == 2){
                LinkedList<generator.Contact> contacts = response.getContacts();
                for(int j = 0; j < contacts.size(); j++){
                    System.out.println("message: " + response.getMessage() + " to contact: " + contacts.get(j).getName() + " " + contacts.get(j).getNumber());
                }
            }
        }
    }
}

class ScheduledTask extends TimerTask {
    String message;
    int count;

    public ScheduledTask(String message, int count){
        this.message = message;
        this.count = count;
    }

    public void run() {
        System.out.println("alarm: " + message);
        count --;
        if(count == 0){
            this.cancel();
        }
    }
}