package CEMS.src.application;

import java.security.NoSuchProviderException;
import java.util.HashMap;

import static CEMS.src.application.Main.CURRENTUSER;

public class LoginForm extends Form {

    private boolean isFilled;
    private HashMap<Object, Object> hmData;

    // Constructor
    LoginForm(RequestType requestType, HashMap<Object, Object> hmData) throws NoSuchProviderException {
        this.hmData = hmData;
        logUserIn();
    }

    /** Method to log a user into the system - cross-references user data from the DB **/
    public void logUserIn() {
        //hmData is now a class data member. No need for parameters this way.

        // Retrieve the user's email & password on login attempt
        String email = (String)hmData.get("LoginUserEmail");
        String password = (String)hmData.get("LoginUserPassword");

        // Retrieve the user's salt from the DB
        String salt = CURRENTUSER.getUserSalt();

        // Hash the entered password
        String hashedPassword = null;
        try {
            hashedPassword = PasswordUtil.hashPassword(CURRENTUSER, password, salt);
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }

        // Compare the email and the hashed password to the one stored in the DB
        // Check the email & pass
        if (CURRENTUSER.getEmail().equals(email) && CURRENTUSER.getPassword().equals(hashedPassword)) {
            // do something
        } else {
            // do something;
        }

//        if (isFilled()) {
//            // TODO: Code
//        }
    }

    public boolean isFilled() {
        // TODO: Ensure all fields are filled, if not - return false, else - return true
        return isFilled;
    }

}
