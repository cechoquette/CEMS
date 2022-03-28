package CEMS.src.application;

public class ClubMember {
	
	private int userID;
	private Club club;
	private String clubMemberName;
	private String clubMemberEmail;
	
	public ClubMember(){}
	
	public ClubMember(int userID, String name, String email, Club club){
		this.userID = userID;
		this.clubMemberName = name;
		this.clubMemberEmail = email;




		club.addClubMember(this);
	}

}
