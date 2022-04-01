package CEMS.src.application;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="Club")
public class Club {
    public static int COUNT_FOR_IDS = 10;

    @Id
    @Column(name="club_id ")
    private int clubID = 5;
    @Column(name="club_name")
    private String clubName;
    @Column(name="club_description")
    private String clubDescription;
    @OneToMany(mappedBy = "club")
    private List<Expenditure> expenditure = new ArrayList<Expenditure>();
    @OneToMany(mappedBy = "club")
    private List<ClubBudget> clubBudget = new ArrayList<ClubBudget>();
    @OneToMany(mappedBy = "club")
    private List<ClubEventBudget> clubEventBudget = new ArrayList<ClubEventBudget>();
    @OneToMany(mappedBy = "club")
    private List<User> clubUsers = new ArrayList<>();

    public Club () {

    }

    public Club(String clubName, String clubDescription) {
        super();
        this.clubID = ++COUNT_FOR_IDS;
        this.clubName = clubName;
        this.clubDescription = clubDescription;
        this.clubUsers = new ArrayList<>();
    }
    //option to create Club with an existing list of Users
    public Club(String clubName, String clubDescription, ArrayList<User> clubUsers) {
        super();
        this.clubID = ++COUNT_FOR_IDS;
        this.clubName = clubName;
        this.clubDescription = clubDescription;
        this.clubUsers = clubUsers;
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

    public static int getCountForIds() {
        return COUNT_FOR_IDS;
    }

    public static void setCountForIds(int countForIds) {
        COUNT_FOR_IDS = countForIds;
    }

    public List<ClubBudget> getClubBudget() {
        return clubBudget;
    }

    public void setClubBudget(List<ClubBudget> clubBudget) {
        this.clubBudget = clubBudget;
    }

    public List<ClubEventBudget> getClubEventBudget() {
        return clubEventBudget;
    }

    public void setClubEventBudget(List<ClubEventBudget> clubEventBudget) {
        this.clubEventBudget = clubEventBudget;
    }

    public List<User> getClubUsers() {
        return clubUsers;
    }

    public void setClubUsers(List<User> clubUsers) {
        this.clubUsers = clubUsers;
    }

    public void addUser(User user){
        clubUsers.add(user);
    }



    @Override
    public String toString(){
        return this.clubName;
    }

    public Integer maxClubId() {
        Integer result = null;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("select max(c.clubID) from Club c");
            result = (int) query.getResultList().get(0);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return result;
    }
}
