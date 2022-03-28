package CEMS.src.application;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ClubEvent {
    public static int COUNT_FOR_IDS;

    private int eventID;
    private String eventName;
    private String eventDescription;
    private Club associatedClub;//might be club id, not sure yet
    private LocalDateTime eventDateTime;
    private String eventLocation;
    private String[] emailGroup;

    public ClubEvent(){}
    public ClubEvent(String name, String desc, Club club, LocalDateTime dateTime, String location, String[] emailGroup){
        this.eventID = COUNT_FOR_IDS++;
        this.eventName = name;
        this.associatedClub = club;
        this.eventDescription = desc;
        this.eventDateTime = dateTime;
        this.eventLocation = location;
        this.emailGroup = emailGroup;//could be null
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

    public String[] getEmails() {
        ArrayList<ClubMember> clubMember = this.associatedClub.getClubMembers();

        String[] emails = new String[clubMember.size()];

        for (int i=0; i<clubMember.size(); i++){
            emails[i] = clubMember.get(i).getClubMemberEmail();
        }

        return emails;
    }//could be null

    public void setEmailGroup(String[] emailGroup) {
        this.emailGroup = emailGroup;
    }

    @Override
    public String toString(){
        return this.eventName;
    }


}
