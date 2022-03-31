package CEMS.src.application;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.persistence.*;

@Entity
@Table(name="User")
public class User {
	
	// Initialize variables
	@Id
	@Column(name="student_id ")
	private int studentID;
	@Column(name="email_address")
	private String email;
	@Column(name="password_")
	private String password;
	@Column(name="permissions")
	private String permission; // Permission ie: Admin, Admin+, SuperAdmin
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="phone_number")
	private String phone;
	@Column(name="salt")
	private String salt;
	@Column(name="security_question")
	private String securityQuestion;
	@Column(name="security_answer")
	private String securityAnswer;
	//@Column(name="club")
	private static Club club;

	public User() {
	}
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
	public void setUserSalt(String salt) {
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
