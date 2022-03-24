package application;

public class User {
	
	// Initialize variables
	private int userID; // query the DB to find the latest userID
	private int studentID;
	private String username, password, userType, // ie: Admin, Admin+, SuperAdmin
					permission, firstName, lastName, 
					phone, email;
	
	
	/** Constructor to create a user object **/
	public User(String email, String password, String permission, 
				String firstName, String lastName,
				String phone, int studentID) {
		// To set the userID, first query the DB to find the latest userID and increment by 1
//		this.userID = ;
		this.email = email;
		this.password = password;
		this.permission = permission;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.studentID = studentID;	
	}
	
	// Get the userID
	public int getUserID() {
		return userID;
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
	
	
	/** Method to update a user's permission 
	 * @param permission is the permission you wish to update it to **/
	public static void updatePermission(User user, String permission) {
		// If the userID is already set to the specified permission
		if (user.getPermission() == permission) {
			
			// Do nothing
		
		// Else, update the permissions
		} else {
			this.permission = permission;
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
		User user = new User("erin@email.com", "pass", "Admin+", "Erin", "Cameron", "8578695116", 123456);
		
		System.out.println(user.getEmail());
		System.out.println(user.getUserID());
	}
	
}
