package application;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordUtil {

    /** Method to hash and salt a password using SHA-256 encryption
     * @return a string to the calling method **/
    private static String hashPassword(String password) throws NoSuchProviderException {

        // Initialize variables & create a stringbuilder
        MessageDigest md;
        StringBuilder sb = new StringBuilder();

        try {
            // Specify the message digest as SHA-256 Hash encryption
            md = MessageDigest.getInstance("SHA-256");

            // Call method for salt generation, store in variable and pass the salt to the message digest as bytes
            String salt = getSalt();
            md.update(salt.getBytes());

            // Generate the salted hashed message - convert to hexadecimal
            byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

            for (byte strbyte : hashedPassword) {
                sb.append(String.format("%02x", strbyte));
            }

            // Catch block
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // TODO: Store the hashed string in the DB


        // Return the hashed string
        return sb.toString();
    }


    /** Method to retrieve a randomized salt to strengthen the password
     * @return the salt string to the calling method **/
    private static String getSalt() throws NoSuchAlgorithmException, NoSuchProviderException {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG", "SUN"); // pseudo-random number generation algorithm used
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return salt.toString();
    }


    /** Method to validate password in the DB **/
    // TODO: FIX
    private static boolean validatePassword(String hashedPass, String email, String password) throws NoSuchProviderException {
        String hp = PasswordUtil.hashPassword("hey");

        // TODO: Fix
        if (hashedPass == PasswordUtil.hashPassword(hp) && email == email) {
            return true;
        } else {
            return false;
        }
    }


    /** Method to reset password in the DB **/
    public static void ResetPass(/*User user, */String email, String securityQuestion, String newPass) {

        // TODO: Verify email and security question
        if (verifyPassReset(email, securityQuestion)) {

            // Use the users new password to overwrite the password in the DB
            // This will need to use the hash method, and a method to store in DB

        }

    }

    /** Method to verify email and security question in the DB **/
    public static boolean verifyPassReset(String email, String securityQuestion) {

        // TODO: Code

        return false;
    }


    /** Main Method - temporary **/
    public static void main(String[] args) throws NoSuchProviderException {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user for username and password
        System.out.println("Email: ");
        String email = input.next();
        System.out.println("Password: ");
        String pw = input.next();

        // Hash the password
        String hashed = PasswordUtil.hashPassword(pw);

        // Display the hashed password
        System.out.println("Hashed password with salt: " + hashed);

        // Validate the password
//        System.out.println(HashPass.validatePassword(hashed, email, pw));
    }

}

