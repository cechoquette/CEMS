package CEMS.src.application;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;


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

    private ArrayList<ClubMember> clubMembers;//new

    public Club(){}

    public Club(String clubName, String clubDescription) {
        super();
        this.clubID = ++COUNT_FOR_IDS;
        this.clubName = clubName;
        this.clubDescription = clubDescription;
    }

    public Club(String clubName, String clubDescription, ArrayList<ClubMember> clubMembers) {
        super();
        this.clubID = ++COUNT_FOR_IDS;
        this.clubName = clubName;
        this.clubDescription = clubDescription;
        setClubMembers(clubMembers);
    }

    public static int getCountForIds() {
        return COUNT_FOR_IDS;
    }

    public static void setCountForIds(int countForIds) {
        COUNT_FOR_IDS = countForIds;
    }

    public ArrayList<ClubMember> getClubMembers() {
        return clubMembers;
    }

    public void setClubMembers(ArrayList<ClubMember> clubMembers) {
        this.clubMembers = clubMembers;
    }

    public void addClubMember(ClubMember clubMember){
        clubMembers.add(clubMember);
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

}
