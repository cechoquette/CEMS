package CEMS.src.application;

import java.util.ArrayList;
import java.util.HashMap;

public class ClubForm extends Form{
    public static int COUNT_FOR_IDS;
    static int formID; //needs to be called from Database, or saved and retrieved at startup
    private boolean isFilled;

    private Club club;
    private HashMap<Object, Object> hmData;

    public ClubForm(RequestType requestType, HashMap<Object, Object> hmData){

        formID = ++COUNT_FOR_IDS;
        this.hmData = hmData;
    }

    public Club createClub(){
        String clubName = (String)hmData.get("ClubName");
        String clubDescription = (String)hmData.get("ClubDescription");
        if(hmData.get("ClubUsers") != null){
            ArrayList<User> clubUsers = (ArrayList<User>)hmData.get("ClubUsers");
            this.club = new Club(clubName, clubDescription, clubUsers);
        }
        else {
            this.club = new Club(clubName, clubDescription);
        }
        return club;
    }

    public Club getClub() {
        return club;
    }

    public void updateClub(Club club) {
        if(hmData.get("ClubName") != null)
            club.setClubName((String)hmData.get("ClubName"));
        if(hmData.get("ClubDescription") != null)
            club.setClubDescription((String)hmData.get("ClubDescription"));
        if (hmData.get("ClubUsers") != null)
            club.setClubUsers((ArrayList<User>)hmData.get("ClubUsers"));
    }
}
