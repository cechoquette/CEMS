package CEMS.src.application;

import java.time.LocalDateTime;
import java.util.HashMap;

public class ClubEventForm extends Form{

    public static int COUNT_FOR_IDS;
    private ClubEvent clubEvent;
    private int formID;

    public ClubEventForm(RequestType requestType, HashMap<Object, Object> hmData){
        this.formID = ++COUNT_FOR_IDS;

        createEvent(hmData);

    }

    public ClubEvent getEvent(){
        return clubEvent;
    }

    public void createEvent(HashMap<Object, Object> hmData){

        String eventName = (String)hmData.get("EventName");
        String eventDesc = (String)hmData.get("EventDescription");
        Club eventClub = (Club)hmData.get("EventClub");
        LocalDateTime eventDateTime = (LocalDateTime)hmData.get("EventDateTime");
        String eventLocation = (String)hmData.get("EventLocation");
        String emailGroup = (String)hmData.get("EventEmailGroup");

        this.clubEvent = new ClubEvent(eventName, eventDesc, eventClub, eventDateTime, eventLocation, emailGroup);

    }

    public void updateEvent(){

    }

    public void deleteEvent(){

    }




}
