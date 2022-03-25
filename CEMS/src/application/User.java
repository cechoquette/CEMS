package CEMS.src.application;

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
				String securityAnswer) {
		// To set the userID, first query the DB to find the latest userID and increment by 1
//		this.userID = ; // Not using userID anymore, only studentID
		this.email = email;
		this.password = password;
		this.salt = salt; // TODO: get the users salt from the password creation
		this.permission = permission;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.studentID = studentID;
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

	// Get password
	public String getPassword() {
		return password;
	}

	// Get security question
	public String getSecurityQuestion() {
		return securityQuestion;
	}

	// Set the security question
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	
	/** Method to update a user's permission 
	 * @param - is the permission you wish to update it to **/
	public static void updatePermission(User user, String newPermission) {
		// If the userID is already set to the specified permission
		if (user.getPermission() == newPermission) {
			
			// Do nothing
		
		// Else, update the permissions to the new permission
		} else {
			user.setPermission(newPermission);
		}	
	}
	
	/** Method to delete a user 
	 * @param **/
	public static void deleteUser(User user, String email) {
		// Remove the user from the database and send a confirmation that this was completed
		if (user.getEmail() == email) {
			user = null; // Dereference the object
		}
	}
	
	// Test
	public static void main(String[] args) {
		User user = new User("erin@email.com", "pass", "Admin+",
				"Erin", "Cameron", "8578695116", 123456, "Age?", "29");
		
		System.out.println(user.getEmail());
	}
	
}
