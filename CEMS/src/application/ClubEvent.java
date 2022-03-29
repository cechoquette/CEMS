package CEMS.src.application;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.persistence.*;

import static CEMS.src.application.Main.ALLCLUBS;


@Entity
@Table(name="ClubEvent")
public class ClubEvent {
    public static int COUNT_FOR_IDS;

    @Id
    @Column(name="event_id")
    private int eventID;
    @Column(name="event_name")
    private String eventName;
    @Column(name="event_description")
    private String eventDescription;
    private Club associatedClub;//might be club id, not sure yet
    @Column(name="event_date")
    private LocalDateTime eventDateTime;
    @Column(name="event_location")
    private String eventLocation;
    private String[] emailGroup;
    @Column(name="event_attendance")
    private int attendance;

    public ClubEvent(){}
    public ClubEvent(String name, String desc, Club club, LocalDateTime dateTime, String location, String emailGroup){
        this.eventID = COUNT_FOR_IDS++;
        this.eventName = name;
        this.associatedClub = club;
        this.eventDescription = desc;
        this.eventDateTime = dateTime;
        this.eventLocation = location;
        this.emailGroup = getEmails(emailGroup);//could be null
        if(club == ALLCLUBS){
            setAttendanceLarge();
        }
        else{
            setAttendanceSmall();
        }
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

    //method takes a String, either "none" or "all members..." and populates emailGroup accordingly
    public String[] getEmails(String emailType) {
        ArrayList<ClubMember> clubMember = this.associatedClub.getClubMembers();

        String[] emails = new String[clubMember.size()];

        for (int i=0; i<clubMember.size(); i++){
            emails[i] = clubMember.get(i).getClubMemberEmail();
        }
        if(emails == null) emails[0] = emailType;

        return emails;
    }//cant be null, element 0 should be "none"

    public void setEmailGroup(String[] emailGroup) {
        this.emailGroup = emailGroup;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendanceSmall() {
        this.attendance = (int)(Math.random() * 25);
    }

    public void setAttendanceLarge() {
        this.attendance = (int)(Math.random() * 1000);
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String[] getEmailGroup() {
        return emailGroup;
    }

    @Override
    public String toString(){
        return this.eventName;
    }




}
