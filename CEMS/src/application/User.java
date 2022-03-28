package CEMS.src.application;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;

public class User {
	
	// Initialize variables
	private int studentID;
	private String email, password, permission, // Permission ie: Admin, Admin+, SuperAdmin
					firstName, lastName, phone, salt,
					securityQuestion, securityAnswer;
	private static Club club;
//	private static ArrayList<String> clubs = new ArrayList<String>();
	
	
	/** Constructor to create a user object **/
	public User(String firstName, String lastName, String phone, String email,
				int studentID, Club club, String permission, String securityQuestion,
				String securityAnswer) throws NoSuchAlgorithmException, NoSuchProviderException {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.studentID = studentID; // StudentID is the unique identifying value of each user
		this.club = club;
		this.permission = permission;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;

		// TODO: PASSWORD - to be implemented in the PasswordUtil when a user goes through the "reset password" pathway
		// Call the PasswordUtil method to hash the password and generate a salt
//		this.salt = PasswordUtil.generateSalt();
//		this.password = PasswordUtil.hashPassword(password, salt);
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

	// Set salt
	public void setUserSalt() {
		this.salt = salt;
	}

	// Get password
	public String getPassword() {
		return password;
	}

	// Set password
	public void setPassword(String password) { this.password = password; }

	// Get security question
	public String getSecurityQuestion() {
		return securityQuestion;
	}

	// Set the security question
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	// Get security answer
	public String getSecurityAnswer() { return securityAnswer; }

	// Set the security answer
	public void setSecurityAnswer(String securityAnswer) { this.securityAnswer = securityAnswer; }

	// Get the Club
	public Club getUserClub() { return club; }

	// Set the club
	public void setUserClub(Club club) { this.club = club; }

//	// TODO: Get clubs -- ArrayList version
//	public static String getClub(int index) {
//		int clubSize = clubs.size();
//		String[] clubArray = new String[clubSize];
//
//		for (int i = 0; i < clubSize; i++) {
//			clubArray[i] = clubs.get(i);
//		}
//		// Return the requested club
//		return clubArray[index];
//	}
//
//	// TODO: Get club list
//	public static String[] getClubList() {
//		String[] clubArray = new String[clubs.size()];
//		for(int i =0; i < clubs.size(); i++){
//			clubArray[i] = clubs.get(i);
//		}
//		return clubArray;
//
//		// OR just have a return type of ArrayList and return "clubs"
//		// return clubs;
//	}
//
//	// TEMP - add club
//	public static void addClub(String club) {
//		clubs.add(club);
//	}
	
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
//		User user = new User("Erin", "Cameron", "867-878-6767",
//				"erin@email.com", 123456789, "Club 123", "Admin", "Age?", "29");

//		user.addClub("Test1");
//		user.addClub("Test2");

//		System.out.println(user.getEmail());
//		System.out.println(user.getUserSalt());
//		System.out.println(user.getPassword());
//		System.out.println(user.getFirstName());
//		System.out.println(user.getLastName());
//		System.out.println(user.getStudentID());
//		System.out.println(user.getSecurityQuestion());
//		System.out.println(user.getSecurityAnswer());
//		System.out.println(user.getPhone());
//		System.out.println(user.getPermission());
//
//		user.updatePermission(user, "SuperAdmin");
//		System.out.println("After update Permission to SuperAdmin permission is: " + user.getPermission());
	}
	
}
