package CEMS.src.application;

import java.time.LocalDateTime;
import java.util.HashMap;

public class ClubEventForm extends Form{

    public static int COUNT_FOR_IDS;
    private ClubEvent clubEvent;
    private int formID;
    private HashMap<Object, Object> hmData;

    public ClubEventForm(RequestType requestType, HashMap<Object, Object> hmData){
        this.hmData = hmData;
        this.formID = ++COUNT_FOR_IDS;
    }

    public ClubEvent getEvent(){
        return clubEvent;
    }

    public ClubEvent createClubEvent(){

        String eventName = (String)hmData.get("EventName");
        String eventDesc = (String)hmData.get("EventDescription");
        Club eventClub = (Club)hmData.get("EventClub");
        LocalDateTime eventDateTime = (LocalDateTime)hmData.get("EventDateTime");
        String eventLocation = (String)hmData.get("EventLocation");
        String emailGroup = (String)hmData.get("EventEmailGroup");

        this.clubEvent = new ClubEvent(eventName, eventDesc, eventClub, eventDateTime, eventLocation, emailGroup);
        return clubEvent;
    }

    public void updateClubEvent(ClubEvent clubEvent){

        //todo code
        if(hmData.get("EventName") != null)
            clubEvent.setEventName((String)hmData.get("EventName"));
        if(hmData.get("EventDescription") != null)
            clubEvent.setEventDescription((String)hmData.get("EventDescription"));
        if(hmData.get("EventClub") != null)
            clubEvent.setClub((Club)hmData.get("EventClub"));
        if(hmData.get("EventDateTime") != null)
            clubEvent.setEventDateTime((LocalDateTime)hmData.get("EventDateTime"));
        if(hmData.get("EventLocation") != null)
            clubEvent.setEventLocation((String)hmData.get("EventLocation"));
        if(hmData.get("EventName") != null)
            clubEvent.setEmails((String)hmData.get("EventEmailGroup"));
    }

    public void deleteEvent(ClubEvent clubEvent){
        clubEvent = null;
    }




}
