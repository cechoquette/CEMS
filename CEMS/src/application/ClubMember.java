package CEMS.src.application;

public class ClubMember {
	
	private int userID;
	private Club club;
	
	ClubMember(Club club){
		this.club = club;
	}
	
	ClubMember(Club club, int userID){
		this.club = club;
		this.userID = userID;
	}

}
