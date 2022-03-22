package application;

public class User {
	
	// Initialize variables
	private int userID; // query the DB to find the latest userID
	private String username, password, userType, // ie: Admin, Admin+, SuperAdmin
					permission, firstName, lastName, 
					phone, email, studentID;
	
	
	/** Constructor to create a user object **/
	public User(String username, String password, String userType,
				String permission, String firstName, String lastName,
				String phone, String email, String studentID) {
		// To set the userID, first query the DB to find the latest userID and increment by 1
//		this.userID = ;
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.permission = permission;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.studentID = studentID;	
	}
	
	
	/** Method to update a user's permission 
	 * @param permission is the permission you wish to update it to **/
	public void updatePermission(String userID, String permission) {
		// If the userID is already set to the specified permission
		
		// Else
	}
	
	/** Method to delete a user 
	 * @param **/
	public void deleteUser(String userID, String email) {
		// Remove the user from the database and send a confirmation that this was completed
	}
	
	
}
