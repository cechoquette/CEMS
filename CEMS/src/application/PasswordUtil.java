package CEMS.src.application;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class PasswordUtil {

    /** Method to hash and salt a password using SHA-256 encryption
     * @return a string to the calling method **/
    // TODO: TEST
    public static String hashPassword(User user, String password, String salt) throws NoSuchProviderException {

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

        // Catch block
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // Return the hashed string
        return sb.toString();
    }


    /** Method to retrieve a randomized salt to strengthen the password
     * @return the salt string to the calling method **/
    public static String generateSalt() throws NoSuchAlgorithmException, NoSuchProviderException {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG", "SUN"); // pseudo-random number generation algorithm used
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return salt.toString();
    }

    public static void setCurrentUser(User user) {
        Main.CURRENTUSER = user;
        if (Main.CURRENTUSER != null) {
            if (Main.CURRENTUSER.getUserClub().getClubID() == 1) {//don't remove this. Ensures Object permanence of the ALLCLUBS.
                Main.CURRENTUSER.setUserClub(Main.ALLCLUBS);
            }
        }
    }

}