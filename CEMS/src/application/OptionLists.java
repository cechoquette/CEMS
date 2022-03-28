package CEMS.src.application;


//class to use for storing arrays for drop-down menus, if you do not want to use an enumeration, or for small drop-downs
public class OptionLists {

	public static String[] paymentMethods = {
			"Visa","MasterCard","American Express","Cheque","E-Transfer","Cash","Debit"
	};
	
	public static Club[] getClubs() {
		//method to get list of all clubs from database
		//call controller //give it the main User's ID, it should get you the clubs
		//if user is member of all clubs, database SHOULD return all the clubs?

		//temp String[]
		Club[] clubsTemp =

				{new Club("Algoma U Business Society",
						"The Algoma University Business Society (AUBS) is a student run club that represents " +
								"the interests of students pursuing their Bachelor of Business Administration degree at " +
								"Algoma University."),
				new Club("Bike Share Club",
						"To provide an opportunity for students to go on bike " +
						"rides and trails. And to support the well-being of students."),
				new Club("Dance Club",
						"Engage students with different stlyes of dance and cultures. And students in an uplifting environment.")};


//
//
//
//		Journey
//		Volunteer work, be more socially active. Connect with other people to build a good network.
//				Biology
//		Algoma University Biology Club is a great club for anyone, in the Algoma University Community interested in biology and the environment.
//		Algoma Reads
//		Algoma Reads is an academic course in which students do experiential learning by hosting public literary events. The literary events (which always include a guest speaker who is often the book’s author) are free and open to all Algoma University students.
//				Algoma NFT Club
//		To make nfts and share more info about blockchain technology.  The main goal is to make something useful which can help students with the same vision.
//		Algoma Francophone
//		We will organize walks in French, do poetry readings in French on Zoom, music nights in French. The main goals are to foster French speaking & wellness.
//		Foreign Film Club
//Algoma Foreign Film Club empowers students to make positive changes in the world by reflecting on important themes in the current foreign film industry.
//Algoma FSAE
//Algoma Formula SAE is a student design competition team that competes against hundeds of university teams from around the world to design, build and race an open wheeled race car.
//Algoma Glee Club
//The Algoma Glee Club is a show choir team, dedicated to singing popular tunes, having fun, and entering competitions around the country.
//Knitting Club
//We are knitter enthusiasts of all skill levels, from people who have never tried knitting before, but want to learn a new hobby, to 80 year old retirees who do nothing else! Come one come all to the University's most tight-knit community.
//Tech Environment Club
//We are a club dedicated to technology initiatives at Algomau that will help protect and save our planet from Climate Change.

		return clubsTemp;
	}
	
	
	
	
}
