package CEMS.src.application;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="Club")
public class Club {
    public static int COUNT_FOR_IDS;

    @Id
    @Column(name="club_id ")
    private int clubID;
    @Column(name="club_name")
    private String clubName;
    @Column(name="club_description")
    private String clubDescription;
    //@OneToMany   need to annotate user class
    //private List<User> user = new ArrayList<User>();
    @OneToMany(mappedBy = "club")
    private List<Expenditure> expenditure = new ArrayList<Expenditure>();
    @OneToMany(mappedBy = "club")
    private List<ClubBudget> clubBudget = new ArrayList<ClubBudget>();
    @OneToMany(mappedBy = "club")
    private List<ClubEventBudget> clubEventBudget = new ArrayList<ClubEventBudget>();
    @OneToMany(mappedBy = "club")
    private List<ClubMember> clubMembers = new ArrayList<>();

    public Club () {

    }

    public Club(String clubName, String clubDescription) {
        super();
        this.clubID = ++COUNT_FOR_IDS;
        this.clubName = clubName;
        this.clubDescription = clubDescription;
        this.clubMembers = new ArrayList<>();
    }
    //option to create Club with an existing list of ClubMembers
    public Club(String clubName, String clubDescription, ArrayList<ClubMember> clubMembers) {
        super();
        this.clubID = ++COUNT_FOR_IDS;
        this.clubName = clubName;
        this.clubDescription = clubDescription;
        this.clubMembers = clubMembers;
    }

    public int getClubID() {
        return clubID;
    }

    public void setClubID(int clubID) {
        this.clubID = clubID;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubDescription() {
        return clubDescription;
    }

    public void setClubDescription(String clubDescription) {
        this.clubDescription = clubDescription;
    }
    /*need to annotate user class
    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
 */
    public List<Expenditure> getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(List<Expenditure> expenditure) {
        this.expenditure = expenditure;
    }

    public List<ClubMember> getClubMembers() {
        return clubMembers;
    }

    public void setClubMembers(ArrayList<ClubMember> clubMembers) {
        this.clubMembers = clubMembers;
    }

    public void addClubMember(ClubMember clubMember){
        clubMembers.add(clubMember);
    }

    @Override
    public String toString(){
        return this.clubName;
    }
}
