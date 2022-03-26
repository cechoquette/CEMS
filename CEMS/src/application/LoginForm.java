package CEMS.src.application;

import java.util.HashMap;

public class LoginForm extends Form {

    private boolean isFilled;

    // Constructor
    LoginForm(RequestType requestType, HashMap<Object, Object> hmData){
        logUserIn(hmData);
    }

    /** Method to log a user into the system - cross-references user data from the DB **/
    public void logUserIn(HashMap<Object, Object> hmData) {
        // TODO: Code
    }

    public boolean isFilled() {
        // TODO: Ensure all fields are filled, if not - return false, else - return true
        return isFilled;
    }

}
