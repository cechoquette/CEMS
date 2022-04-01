package CEMS.src.application;

import CEMS.src.controllers.LoginPageUIController;

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
    public boolean logUserIn() {
        //hmData is now a class data member. No need for parameters this way.

        // Retrieve the user's email & password on login attempt
        String email = (String)hmData.get("LoginUserEmail");
        String password = (String)hmData.get("LoginUserPassword");

        // Retrieve the user's salt from the DB
        String salt = Main.CURRENTUSER.getUserSalt();

        // Hash the entered password
        String hashedPassword = null;
        try {
            hashedPassword = PasswordUtil.hashPassword(Main.CURRENTUSER, password, salt);
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }

        // Compare the email and the hashed password to the one stored in the DB
        // Check the email & pass
        if (Main.CURRENTUSER.getEmail().equals(email) && Main.CURRENTUSER.getPassword().equals(hashedPassword)) {
            return true;
        } else {
            return false;
        }

//        if (isFilled()) {
//            // TODO: Code
//        }
    }

    public void passwordReset(User user) {
        // Retrieve the user's password on reset attempt
        String password = (String)hmData.get("ResetUserPassword");

        // Retrieve the user's salt from the DB
        String salt = CURRENTUSER.getUserSalt();

        // Hash the newly entered password
        String hashedPassword = null;
        try {
            hashedPassword = PasswordUtil.hashPassword(CURRENTUSER, password, salt);
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }

        // Set the CURRENTUSER's password to the newly hashed password
        CURRENTUSER.setPassword(hashedPassword);
    }

    public boolean isFilled() {
        // TODO: Ensure all fields are filled, if not - return false, else - return true
        return isFilled;
    }

}
