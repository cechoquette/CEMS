package CEMS.src.application;

import java.util.HashMap;

public class ClubForm extends Form{

    private static int formID; //needs to be called from Database, or saved and retrieved at startup
    private boolean isFilled;



    private Club club;



    public ClubForm(RequestType requestType, HashMap<Object, Object> hmData){
        createClub(hmData);
    }

    public void createClub(HashMap<Object, Object> hmData){
        String clubName = (String)hmData.get("ClubName");
        String clubDescription = (String)hmData.get("ClubDescription");


        this.club = new Club(clubName, clubDescription);
    }

    public Club getClub() {
        return club;
    }

}
