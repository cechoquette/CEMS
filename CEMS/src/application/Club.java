package CEMS.src.application;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Club")
public class Club {

    @Id
    @Column(name="club_id ")
    private int clubID;
    @Column(name="club_name")
    private String clubName;
    @Column(name="club_description")
    private String clubDescription;

    public Club () {

    }

    public Club(int clubID, String clubName, String clubDescription) {
        super();
        this.clubID = clubID;
        this.clubName = clubName;
        this.clubDescription = clubDescription;
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
