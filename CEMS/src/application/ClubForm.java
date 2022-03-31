package CEMS.src.application;

import java.util.ArrayList;
import java.util.HashMap;

public class ClubForm extends Form{
    public static int COUNT_FOR_IDS;
    private static int formID; //needs to be called from Database, or saved and retrieved at startup
    private boolean isFilled;

    private Club club;
    private HashMap<Object, Object> hmData;

    public ClubForm(RequestType requestType, HashMap<Object, Object> hmData){

        this.formID = ++COUNT_FOR_IDS;
        this.hmData = hmData;
    }

    public Club createClub(){
        String clubName = (String)hmData.get("ClubName");
        String clubDescription = (String)hmData.get("ClubDescription");
        if(hmData.get("ClubMembers") != null){
            ArrayList<ClubMember> clubMembers = (ArrayList<ClubMember>)hmData.get("ClubMembers");
            this.club = new Club(clubName, clubDescription, clubMembers);
        }
        else {
            this.club = new Club(clubName, clubDescription);
        }
        return club;
    }

    public Club getClub() {
        return club;
    }

}
