package CEMS.src.application;

import CEMS.src.controllers.LoginPageUIController;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;

import static CEMS.src.application.Main.CURRENTUSER;

public class LoginForm extends Form {

    private boolean isFilled;
    private HashMap<Object, Object> hmData;

    // Constructor
    LoginForm(RequestType requestType, HashMap<Object, Object> hmData) throws NoSuchProviderException {
        this.hmData = hmData;
//        logUserIn();
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
    }

    public void passwordReset(User user) {
        // Retrieve the user's password on reset attempt
        String password = hmData.get("ResetUserPassword").toString();
        String salt = "";
        // Retrieve the user's salt from the DB

        if (Main.CURRENTUSER.getUserSalt() != null) {
            System.out.println("user already has a salt - resetting password...");
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
            try {
                System.out.println("user does not yet have a salt - creating one...");
                salt = PasswordUtil.generateSalt();
                System.out.println("salt: " + salt);
                Main.CURRENTUSER.setUserSalt(salt);
                System.out.println("Main User salt: " + Main.CURRENTUSER.getUserSalt());

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

        System.out.println(Main.CURRENTUSER.getUserSalt() + " " + Main.CURRENTUSER.getPassword());
//        // Hash the newly entered password
//        String hashedPassword = null;
//        try {
//            hashedPassword = PasswordUtil.hashPassword(CURRENTUSER, password, salt);
//        } catch (NoSuchProviderException e) {
//            e.printStackTrace();
//        }
//
//        // Set the CURRENTUSER's password to the newly hashed password
//        CURRENTUSER.setPassword(hashedPassword);
    }

    public boolean isFilled() {
        // TODO: Ensure all fields are filled, if not - return false, else - return true
        return isFilled;
    }

}
