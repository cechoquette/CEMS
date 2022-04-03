package CEMS.src.application;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.persistence.*;
import java.util.List;

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
    @Column(name="event_date")
    private LocalDateTime eventDateTime;
    @Column(name="event_location")
    private String eventLocation;
    @ElementCollection
    private List<String> emailGroup= new ArrayList<String>();
    //@Column(name="email_group")//****To change
    //private List<String> emailGroup;
    @Column(name="event_attendance")
    private int attendance;
    @OneToMany(mappedBy = "clubEvent")
    private List<Expenditure> expenditure = new ArrayList<Expenditure>();
    @OneToMany(mappedBy = "clubEvent")
    private List<ClubEventBudget> clubEvent = new ArrayList<ClubEventBudget>();
    @ManyToOne
    @JoinColumn(name="club_id")
    private Club club;

    public ClubEvent(){}
    public ClubEvent(String name, String desc, Club club, LocalDateTime dateTime, String location, String emailGroup){
        this.eventID = ++COUNT_FOR_IDS;
        this.eventName = name;
        this.club = club;
        this.eventDescription = desc;
        this.eventDateTime = dateTime;
        this.eventLocation = location;
        setEmails(emailGroup);//could be null
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

    public Club getClub() {
        if(club == null)
            return ALLCLUBS;
        else
            return this.club;
    }


    public void setClub(Club club) {
        this.club = club;
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
    public List<String> setEmails(String emailType) {
        List<User> clubUsers = getClub().getClubUsers();

        List<String> emails = new ArrayList<>();

        for (int i=0; i<clubUsers.size(); i++){
            emails.add(clubUsers.get(i).getEmail());
        }
        if(emails.isEmpty() || emailType.matches("None")) emails.add("none@email.com");

        this.emailGroup = emails;
        return emails;
    }//cant be null, element 0 should be "none"
    
    

    public void setEmailGroup(List<String> emailGroup) {
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

    public List<String> getEmailGroup() {
        return emailGroup;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public List<Expenditure> getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(List<Expenditure> expenditure) {
        this.expenditure = expenditure;
    }

    public List<ClubEventBudget> getClubEvent() {
        return clubEvent;
    }

    public void setClubEvent(List<ClubEventBudget> clubEvent) {
        this.clubEvent = clubEvent;
    }

    @Override
    public String toString(){
        return this.eventName;
    }




}
