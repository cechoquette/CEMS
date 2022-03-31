package CEMS.src.application;

import java.util.HashMap;

public class ClubMemberForm extends Form{

    public static int COUNT_FOR_IDS;
    private ClubMember clubMember;
    private int formID;
    private HashMap<Object, Object> hmData;

    public ClubMemberForm(RequestType requestType, HashMap<Object, Object> hmData){
        this.hmData = hmData;
        this.formID = ++COUNT_FOR_IDS;

    }

    public ClubMember getClubMember(){
        return clubMember;
    }

    public ClubMember createMember(){
    //Todo code

        this.clubMember = new ClubMember();
        return clubMember;
    }

    public void updateMember(ClubMember clubMember){//data coming in will be the same as with a User Update, check User Profile UI for keys
        //Todo code
    }

    public void deleteMember(){

    }

}
