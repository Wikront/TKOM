package semantics;

import logger.Error;
import utils.IfStatement;
import utils.Program;

import java.util.HashMap;

/**
 * Created by Wiktor on 15.05.2017.
 */
public class Semantics {
    private Program program;
    private HashMap<String, Integer> declaredConditions;
    private HashMap<String, Integer> declaredContacts;
    private Error error;

    public Semantics(Program program){
        this.program = program;
        error = new Error();
        declaredConditions = new HashMap<>();
        declaredContacts = new HashMap<>();
        mainCheck();
    }
    private void mainCheck(){
        for(int i = 0; i < program.getConditions().size(); i++){
            if(!declaredConditions.containsKey(program.getConditions().get(i).getName())){
                declaredConditions.put(program.getConditions().get(i).getName(),1);
            }else {
                error.redefined(program.getConditions().get(i).getName());
            }
        }
        for(int i = 0; i < program.getContacts().size(); i++){
            if(!declaredContacts.containsKey(program.getContacts().get(i).getName())){
                declaredContacts.put(program.getContacts().get(i).getName(), 1);
            }else {
                error.redefinedContact(program.getContacts().get(i).getName());
            }
        }
//        for(int i = 0; i < program.getIfStatements().size(); i++){
//            IfStatement ifStatement = program.getIfStatements().get(i);
//            for(int j = 0; j < ifStatement.getIfCondition().getSingleConditions().size(); j++){
//                if(!declaredConditions.containsKey(ifStatement.getIfCondition().getSingleConditions().get(j))){
//                    error.undeclared(ifStatement.getIfCondition().getSingleConditions().get(j));
//                }
//            }
//        }
    }

}
