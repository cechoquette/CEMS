package CEMS.src.application;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;

public class LoginForm extends Form {

    private boolean isFilled;
    private HashMap<Object, Object> hmData;

    // Constructor
    LoginForm(RequestType requestType, HashMap<Object, Object> hmData) throws NoSuchProviderException {
        this.hmData = hmData;
    }

    /** Method to log a user into the system - cross-references user data from CURRENTUSER **/
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
    }

    /** Method to reset a user's password - cross-references user data from CURRENTUSER **/
    public void passwordReset(User user) {
        // Retrieve the user's password on reset attempt
        String password = (String)hmData.get("ResetUserPassword");

        String salt = "";

        // If the main user already has a password setup
        if (Main.CURRENTUSER.getUserSalt() != null) {
            // Retrieve the user's salt from the DB
            salt = Main.CURRENTUSER.getUserSalt();
            String hashedPassword = null;

            // Hash the new password
            try {
                hashedPassword = PasswordUtil.hashPassword(Main.CURRENTUSER, password, salt);
            } catch (NoSuchProviderException e) {
                e.printStackTrace();
            }

            // Set the CURRENTUSER's password to the newly hashed password
            Main.CURRENTUSER.setPassword(hashedPassword);

        } else {
            // Else, if the user does not already have a password set up
            try {
                salt = PasswordUtil.generateSalt();
                Main.CURRENTUSER.setUserSalt(salt);

                String hashedPassword = null;

                // Hash the new password
                try {
                    hashedPassword = PasswordUtil.hashPassword(Main.CURRENTUSER, password, salt);
                } catch (NoSuchProviderException e) {
                    e.printStackTrace();
                }

                // Set the CURRENTUSER's password to the newly hashed password
                Main.CURRENTUSER.setPassword(hashedPassword);

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (NoSuchProviderException e) {
                e.printStackTrace();
            }
        }
    }

}
