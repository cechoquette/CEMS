package CEMS.src.application;

import java.util.HashMap;

public class LoginForm extends Form {

    private boolean isFilled;
    private HashMap<Object, Object> hmData;

    // Constructor
    LoginForm(RequestType requestType, HashMap<Object, Object> hmData){
        this.hmData = hmData;
        logUserIn();
    }

    /** Method to log a user into the system - cross-references user data from the DB **/
    public void logUserIn() {
        //hmData is now a class data member. No need for parameters this way.

        if (isFilled()) {
            // TODO: Code
        }
    }

    public boolean isFilled() {
        // TODO: Ensure all fields are filled, if not - return false, else - return true
        return isFilled;
    }

}
