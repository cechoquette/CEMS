package CEMS.src.application;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordUtil {

    /** Method to hash and salt a password using SHA-256 encryption
     * @return a string to the calling method **/
    // TODO: TEST
    public static String hashPassword(String password, String salt) throws NoSuchProviderException {

        // Initialize variables & create a StringBuilder
        MessageDigest md;
        StringBuilder sb = new StringBuilder();

        try {
            // Specify the message digest as SHA-256 Hash encryption
            md = MessageDigest.getInstance("SHA-256");

            // Pass the salt to the message digest as bytes
            md.update(salt.getBytes());

            // Generate the salted hashed message - convert to hexadecimal
            byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

            for (byte strbyte : hashedPassword) {
                sb.append(String.format("%02x", strbyte));
            }

            // Store the hashed string & salt in the DB
            PasswordUtil.storePassAndSalt(sb.toString(), salt);

            // Catch block
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // Return the hashed string
        return sb.toString();
    }


    /** Method to retrieve a randomized salt to strengthen the password
     * @return the salt string to the calling method **/
    // TODO: TEST
    public static String generateSalt() throws NoSuchAlgorithmException, NoSuchProviderException {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG", "SUN"); // pseudo-random number generation algorithm used
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return salt.toString();
    }


    /** Method to store the password in the DB **/
    private static void storePassAndSalt(String newPass, String newSalt) {
        // TODO: code to store password & salt in the DB
    }


    /** Method to validate password in the DB **/
    // TODO: TEST
    private static boolean validatePassword(User user, String enteredEmail, String enteredPassword) throws NoSuchProviderException {
        // To authenticate user, hash the password using the salt retrieved from the DB - then compare this hashed PW to the one in the DB
        // Initialize variables
        String salt = user.getUserSalt(); // Retrieve the users salt from the DB and store in variable

        // Hash the password entered with the user's salt
        String hashedPass = PasswordUtil.hashPassword(enteredPassword, salt);

        // Return a boolean to determine if the passwords and emails match
        return user.getPassword() == hashedPass
                && user.getEmail() == enteredEmail;
    }


    /** Method to reset password in the DB **/
    // TODO: TEST
    public static void resetPass(User user, String enteredEmail, String enteredSecurityQuestion, String newPass)
            throws NoSuchProviderException, NoSuchAlgorithmException {

        // If the users email and security question are verified
        if (verifyPassReset(user, enteredEmail, enteredSecurityQuestion)) {

            // Use the users new password to overwrite the password & salt in the DB
            String newSalt = PasswordUtil.generateSalt(); // Obtain a new salt
            String newHashedPass = PasswordUtil.hashPassword(newPass, newSalt); // Hash the new password with a new salt
            PasswordUtil.storePassAndSalt(newHashedPass, newSalt); // Store new password & salt in DB
        }
    }

    /** Method to verify email and security question in the DB **/
    // TODO: TEST
    public static boolean verifyPassReset(User user, String enteredEmail, String enteredSecurityQuestion) {
        return user.getEmail() == enteredEmail
                && user.getSecurityQuestion() == enteredSecurityQuestion;
    }


    /** Main Method - temporary **/
    public static void main(String[] args) throws NoSuchProviderException, NoSuchAlgorithmException {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user for username and password
        System.out.println("Email: ");
        String email = input.next();
        System.out.println("Password: ");
        String pw = input.next();

        // Hash the password
        String testSalt = PasswordUtil.generateSalt();
        String hashed = PasswordUtil.hashPassword(pw, testSalt);

        // Display the hashed password
        System.out.println("Hashed password with salt: " + hashed);

        // Validate the password
//        System.out.println(HashPass.validatePassword(hashed, email, pw));
    }

}