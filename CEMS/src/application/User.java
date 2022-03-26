package CEMS.src.application;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class User {
	
	// Initialize variables
	private int studentID; // query the DB to find the latest studentID
	private static String email, password, permission,// ie: Admin, Admin+, SuperAdmin
					firstName, lastName, phone, salt,
					securityQuestion, securityAnswer;
	
	
	/** Constructor to create a user object **/
	public User(String email, String password, String permission, 
				String firstName, String lastName,
				String phone, int studentID, String securityQuestion,
				String securityAnswer) throws NoSuchAlgorithmException, NoSuchProviderException {
		this.studentID = studentID; // StudentID is the unique identifying value of each user
		this.email = email;
		this.permission = permission;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;

		// Call the PasswordUtil method to hash the password and generate a salt
		this.salt = PasswordUtil.generateSalt();
		this.password = PasswordUtil.hashPassword(password, salt);
	}

	// Get the email
	public String getEmail() {
		return email;
	}

	// Get the permission
	public String getPermission() {
		return permission;
	}

	// Set the permission
	public void setPermission(String permission) {
		this.permission = permission;
	}

	// Get first name
	public String getFirstName() {
		return firstName;
	}

	// Get last name
	public String getLastName() {
		return lastName;
	}

	// Get phone number
	public String getPhone() {
		return phone;
	}

	// Get student ID number
	public int getStudentID() {
		return studentID;
	}

	// Get salt
	public String getUserSalt() {
		return salt;
	}

	// Get password
	public String getPassword() {
		return password;
	}

	// Get security question
	public String getSecurityQuestion() {
		return securityQuestion;
	}

	// Get security answer
	public String getSecurityAnswer() {
		return securityAnswer;
	}

	// Set the security answer
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	// Set the security question
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	
	/** Method to update a user's permission 
	 * @param - is the permission you wish to update it to **/
	public static void updatePermission(User user, String newPermission) {
		// If the userID is not already set to the specified permission
		if (user.getPermission() != newPermission) {
			// Update the permissions to the new permission
			user.setPermission(newPermission);
		}
	}
	
	/** Method to delete a user 
	 * @param **/
	public static void deleteUser(User user, String enteredEmail) {
		// Remove the user from the database and send a confirmation that this was completed
		if (user.getEmail() == enteredEmail) {
			user = null; // Dereference the object
		}
	}
	
	// Testing - temporary
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
		User user = new User("erin@email.com", "pass", "Admin+",
				"Erin", "Cameron", "8578695116", 123456, "Age?", "29");

		System.out.println(user.getEmail());
		System.out.println(user.getUserSalt());
		System.out.println(user.getPassword());
		System.out.println(user.getFirstName());
		System.out.println(user.getLastName());
		System.out.println(user.getStudentID());
		System.out.println(user.getSecurityQuestion());
		System.out.println(user.getSecurityAnswer());
		System.out.println(user.getPhone());
		System.out.println(user.getPermission());

		user.updatePermission(user, "SuperAdmin");
		System.out.println("After update Permission to SuperAdmin permission is: " + user.getPermission());
	}
	
}
