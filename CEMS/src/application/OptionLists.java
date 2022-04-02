package CEMS.src.application;


import java.util.ArrayList;
import java.util.List;

// class to use for storing arrays for drop-down menus,
// if you do not want to use an enumeration,
// or for small drop-downs,
// or for getting lists from the Database
public class OptionLists {

	public static String[] EMAIL_GROUPS(){
		return new String[]{"All Club Members", "None"};
	}

	public static ClubEvent[] getEvents(Timeframe timeframe){
		//method will get ClubEvents in a given Timeframe from Database and populate an array of ClubEvents
		//Timeframe allows a day, a month, 17 days from the 6th of June, any timeframe you want. See class Timeframe for constructors.

		//call Database to populate
		//ClubEvents[] clubEvents = ...

		//temp Events[]
		ClubEvent[] clubEvents = {
		new ClubEvent(),
				new ClubEvent("Meeting 123", " ", null, null, "", "None"),
				new ClubEvent("Sparklethon", " ", null, null, " ", "None")
//				new ClubEvent(),
//				new ClubEvent(),
//				new ClubEvent(),
//				new ClubEvent(),


		};

		return clubEvents;
	}
	//method returns list of current user's club's events, ordered by date
	public static List<ClubEvent> getUserEventsList(){
		DAO dao2 = new DAO();
		List<Club> clubEvents ;
//				= dao2.getAllClubEventsByClub();
//		return clubEvents;


		return new ArrayList<>();
	}

	public static ClubEvent[] getEvents(){//no timeframe, all ClubEvents
		//method will get all ClubEvents from the current User's Club from Database and populate an array of ClubEvents

		//temp Events[]
		ClubEvent[] clubEvents = {
				new ClubEvent(),
				new ClubEvent("Meeting 123", " ", Main.ALLCLUBS, null, "", "None"),
				new ClubEvent("Sparklethon", " ", Main.ALLCLUBS, null, " ", "None")
//				new ClubEvent(),
//				new ClubEvent(),
//				new ClubEvent(),
//				new ClubEvent(),


		};

		return clubEvents;

	}

	public static String[] getAdmins(){
		return new String[0];
	}

	public static String[] getGeneralMembers(){
		return new String[0];
	}

	public static List<Club> getAllClubsList(){
		DAO dao1 = new DAO();
		List<Club> clubs = dao1.getAllClubs();
		return clubs;

//		return new ArrayList<>();
	}

	//method is for testing only. For real method, use getAllClubsList()
	public static Club[] getClubs() {
		//method to get list of all clubs from database
		//call controller //give it the main User's ID, it should get you the clubs
		//if user is member of all clubs, database SHOULD return all the clubs?

//		DAO dao1 = new DAO();
//		List<Club> clubs = dao1.getAllClubs();

//		Club[] clubsArray = (Club[])clubs.toArray();

		//check if current user is a superadmin, give them the list of all clubs
//		if (Main.currentUser.getClub() == )

//		temp Club[]
		Club algomaUBusiness = new Club("Algoma U Business Society",
				"The Algoma University Business Society (AUBS) is a student run club that represents " +
						"the interests of students pursuing their Bachelor of Business Administration degree at " +
						"Algoma University.");

		Club bikeShare = new Club("Bike Share Club",
				"To provide an opportunity for students to go on bike " +
						"rides and trails. And to support the well-being of students.");

		Club danceClub = new Club("Dance Club",
						"Engage students with different stlyes of dance and cultures. " +
								"And students in an uplifting environment.");

		Club journey = new Club("Journey", "Volunteer work, be more socially active. Connect with other people to build a good network.");
		Club biology = new Club("Biology", "Algoma University Biology Club is a great club for anyone, " +
				"in the Algoma University Community interested in biology and the environment.");
		Club algomaReads = new Club("Algoma Reads", "Algoma Reads is an academic course in which students do experiential " +
				"learning by hosting public literary events. The literary events (which always include a guest speaker" +
				" who is often the book’s author) are free and open to all Algoma University students.");
		Club algomaNFT = new Club("Algoma NFT Club", "To make nfts and share more info about blockchain technology.  " +
				"The main goal is to make something useful which can help students with the same vision.");
		Club francophone = new Club("Algoma Francophone", "We will organize walks in French, do poetry readings in " +
				"French on Zoom, music nights in French. The main goals are to foster French speaking & wellness.");
		Club foreignFilm = new Club("Foreign Film Club", "Algoma Foreign Film Club empowers students to make positive changes in" +
				" the world by reflecting on important themes in the current foreign film industry.");
		Club fsae = new Club("Algoma FSAE", "Algoma Formula SAE is a student design competition team that competes against " +
				"hundreds of university teams from around the world to design, build and race an open wheeled race car.");
		Club glee = new Club("Algoma Glee Club", "The Algoma Glee Club is a show choir team, dedicated to singing popular " +
				"tunes, having fun, and entering competitions around the country.");
		Club knitting = new Club("Knitting Club", "We are knitter enthusiasts of all skill levels, from people who have " +
				"never tried knitting before, but want to learn a new hobby, to 80 year old retirees who do nothing else! " +
				"Come one come all to the University's most tight-knit community.");
		Club techEnviro = new Club("Tech Environment Club", "We are a club dedicated to technology initiatives at Algomau " +
				"that will help protect and save our planet from Climate Change.");


		Club[] clubsTemp =

				{Main.ALLCLUBS, algomaUBusiness, bikeShare, danceClub, journey, biology, algomaNFT, algomaReads, francophone,
						foreignFilm, fsae, glee, knitting, techEnviro

				};

//		return clubsArray;
		return clubsTemp;
	}
	
	
	
	
}
