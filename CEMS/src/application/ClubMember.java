package CEMS.src.application;

import java.util.ArrayList;
import javax.persistence.*;

@Entity
@Table(name="User")
public class ClubMember {
	//No need for ID count. Primary key is based on student IDs as in User class.
	@Id
	@Column(name="student_id")
	private int studentID;
	@Column(name="club_member_first_name")
	private String clubMemberFirstName;
	@Column(name="club_member_last_name")
	private String clubMemberLastName;
	@Column(name="club_member_email")
	private String clubMemberEmail;
	@ManyToOne
	private User user;
	@ManyToOne
	private Club club;

	public ClubMember(){}
	//Constructor for creating a ClubMember who is not a User. In this case private field User remains null. Can be changed later.
	public ClubMember(int studentID, String firstName, String lastName, String email, Club club){
		this.studentID = studentID;
		this.clubMemberFirstName = firstName;
		this.clubMemberLastName = lastName;
		this.clubMemberEmail = email;

		club.addClubMember(this);
	}
	//Constructor for creating a ClubMember from a User.
	public ClubMember(User user){
		this.studentID = user.getStudentID();
		this.clubMemberFirstName = user.getFirstName();
		this.clubMemberLastName = user.getLastName();
		this.clubMemberEmail = user.getEmail();
//		this.club = user.getClub...
		this.user = user;

		club.addClubMember(this);
	}
	//user this if ClubMember already exists for that User. i.e. They are already in Club List as a Member, not yet as User.
	public void addUserToClubMember(User user){
		if(this.user == null) {
			this.user = user;
		}
		else{
			System.out.println("User already exists. Could not merge \nUser ID: "
					+ user.getStudentID() + "\nwith \nClub Member ID: " + this.studentID
					+ " \nName: " + clubMemberFirstName + " " + clubMemberLastName );
		}
	}

	//need a method to get a specific ClubMember. Probably from Database, or from Club memberList.

	public ClubMember getClubMember(Club club, int studentID){//method may return null if ClubMember not found.
		if(club.getClubMembers() != null){
			ArrayList<ClubMember> clubMemberList = club.getClubMembers();
			for(int i = 0; i<clubMemberList.size(); i++){
				if (clubMemberList.get(i).getStudentID() == studentID){
					return clubMemberList.get(i);
				}
			}
		}
		return null;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public String getClubMemberFirstName() {
		return clubMemberFirstName;
	}

	public void setClubMemberFirstName(String clubMemberFirstName) {
		this.clubMemberFirstName = clubMemberFirstName;
	}

	public String getClubMemberLastName() {
		return clubMemberLastName;
	}

	public void setClubMemberLastName(String clubMemberLastName) {
		this.clubMemberLastName = clubMemberLastName;
	}

	public String getClubMemberEmail() {
		return clubMemberEmail;
	}

	public void setClubMemberEmail(String clubMemberEmail) {
		this.clubMemberEmail = clubMemberEmail;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
