package CEMS.src.application;

import java.time.LocalDateTime;

public class ClubEvent {
    public static int COUNT_FOR_IDS;

    private int eventID;
    private String eventName;
    private String eventDescription;
    private Club associatedClub;//might be club id, not sure yet
    private LocalDateTime eventDateTime;
    private String[] emailGroup;

    public ClubEvent(){}
    public ClubEvent(String name, String desc, Club club, LocalDateTime dateTime, String[] emailGroup){
        this.eventID = COUNT_FOR_IDS++;
        this.eventName = name;
        this.associatedClub = club;
        this.eventDescription = desc;
        this.eventDateTime = dateTime;
        this.emailGroup = emailGroup;
    }

    public static int getCountForIds() {
        return COUNT_FOR_IDS;
    }

    public static void setCountForIds(int countForIds) {
        COUNT_FOR_IDS = countForIds;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }


    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Club getAssociatedClub() {
        return associatedClub;
    }

    public void setAssociatedClub(Club associatedClub) {
        this.associatedClub = associatedClub;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public LocalDateTime getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(LocalDateTime eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public String[] getEmailGroup() {
        return emailGroup;
    }

    public void setEmailGroup(String[] emailGroup) {
        this.emailGroup = emailGroup;
    }

    @Override
    public String toString(){
        return this.eventName;
    }


}
