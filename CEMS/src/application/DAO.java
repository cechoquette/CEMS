package CEMS.src.application;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class DAO {
    static HashMap<Integer, Club> getClubByIDHashMap = new HashMap<>();
    static HashMap<String, User> getUserByEmail = new HashMap<>();

    ////////// ClubDAO

    public void addClub(Club club) {
        if (getClubByIDHashMap.isEmpty() || !getClubByIDHashMap.containsValue(club)){
            getClubByIDHashMap.put(club.getClubID(), club);
        }
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Object object = session.save(club);
            session.get(Club.class, (Serializable) object);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateClub(Club club) {
        if (!getClubByIDHashMap.isEmpty() && getClubByIDHashMap.containsValue(club)){
            getClubByIDHashMap.remove(club.getClubID());
            getClubByIDHashMap.put(club.getClubID(), club);
        }
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.merge(club);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Club getClub(int clubID) {
        if (!getClubByIDHashMap.isEmpty() && getClubByIDHashMap.get(clubID) != null){
            return getClubByIDHashMap.get(clubID);
        }
        else{
            Transaction transaction = null;
            Club club = null;
            try {
                Session session = HibernateUtil.getSessionFactory().openSession();
                transaction = session.beginTransaction();
                club = session.get(Club.class, clubID);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
            } finally {

                getClubByIDHashMap.put(clubID, club);
                return getClubByIDHashMap.get(clubID);
            }
        }
    }

    public Club getClubByName(String clubName) {
        if (!getClubByIDHashMap.isEmpty()) {
            for (Club clubinmap : getClubByIDHashMap.values()) {
                if (clubinmap.getClubName().matches(clubName)) {
                    return clubinmap;
                }
            }
        }
        Transaction transaction = null;
        Club club = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String hql = "from Club c where c.clubName =: name";
            Query query = session.createQuery(hql);
            query.setParameter("name", clubName);
            query.setMaxResults(1);
            club = (Club) query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            return club;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Club> getAllClubs() {
        Transaction transaction = null;
        List<Club> clubs = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Club> criteria = builder.createQuery(Club.class);
            criteria.from(Club.class);
            clubs = session.createQuery(criteria).getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (clubs != null) {
                if (!getClubByIDHashMap.isEmpty()) {

                    for (Club freshclub : clubs) {
                        if (!getClubByIDHashMap.containsKey(freshclub.getClubID())) {
                            getClubByIDHashMap.put(freshclub.getClubID(), freshclub);
                        }
                    }
                    clubs = new ArrayList<Club>(getClubByIDHashMap.values());
                }
                else {
                    for (Club newClub : clubs) {
                        getClubByIDHashMap.put(newClub.getClubID(), newClub);
                    }
                }
            }
            return clubs;
        }
    }

    //// UserDAO
    public void addUser(User user) {
        if (getUserByEmail.isEmpty() || !getUserByEmail.containsValue(user)){
            getUserByEmail.put(user.getEmail(), user);
        }
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try  {
            transaction = session.beginTransaction();
            Object object = session.save(user);
            session.get(User.class, (Serializable) object);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateUser(User user) {
        if (!getUserByEmail.isEmpty() && getUserByEmail.containsValue(user)){
            //the reason this is not redundant is in the instance where a user changes their email
            //this puts that user back in memory under the new key
            getUserByEmail.remove(user.getEmail());
            getUserByEmail.put(user.getEmail(), user);
        }
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.merge(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public User getUser(String userEmail) {
        if (!getUserByEmail.isEmpty() && getUserByEmail.get(userEmail) != null) {
            return getUserByEmail.get(userEmail);
        }
        Transaction transaction = null;
        User user = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String hql = "from User u where u.email =: email";
            Query query = session.createQuery(hql);
            query.setParameter("email", userEmail);
            query.setMaxResults(1);
            user = (User) query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            return user;
        }
    }

    public List<User> getUsersByClub(int clubID) {

        Transaction transaction = null;
        List<User> users = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String hql = "from User u where u.club.id =: clubid";
            Query query = session.createQuery(hql);
            query.setParameter("clubid", clubID);
            users = (List<User>) query.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if(users != null) {
                if (!getUserByEmail.isEmpty()) {
                    for (User freshuser : users) {
                        if (!getUserByEmail.containsKey(freshuser.getEmail())) {
                            getUserByEmail.put(freshuser.getEmail(), freshuser);
                        }
                    }
                    users = new ArrayList<User>(getUserByEmail.values());
                } else {
                    for (User newUser : users) {
                        getUserByEmail.put(newUser.getEmail(), newUser);
                    }
                }
            }
            return users;
        }
    }

    public void deleteUser(int studentID) {
        if(!getUserByEmail.isEmpty()){//if user is in memory, remove them
            for (User oldUser: getUserByEmail.values()){
                if(oldUser.getStudentID() == studentID){
                    getUserByEmail.remove(oldUser.getEmail());
                }
            }
        }
        Transaction transaction = null;
        User user = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            user = session.get(User.class, studentID);
            if (user != null) {
                session.delete(user);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    ///////// ClubBudgetDAO

    public void addClubBudget(ClubBudget clubBudget) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Object object = session.save(clubBudget);
            session.get(ClubBudget.class, (Serializable) object);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public ClubBudget getClubBudget(int clubBudgetID) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        ClubBudget clubBudget = null;
        try {
            transaction = session.beginTransaction();
            clubBudget = session.get(ClubBudget.class, clubBudgetID);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            return clubBudget;

        }
    }

    public ClubBudget getClubBudgetByClub(String clubName) {
        Transaction transaction = null;
        ClubBudget clubBudget = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String hql = "select cb from ClubBudget cb inner join cb.club where cb.clubName =: name ";
            Query query = session.createQuery(hql);
            query.setParameter("name", clubName);
            query.setMaxResults(1);
            clubBudget = (ClubBudget) query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            return clubBudget;
        }
    }

    ////////// ClubEventDAO
    HashMap<Integer, ClubEvent> getClubEventByID = new HashMap<>();

    static LocalDateTime startDate = LocalDateTime.now();
    static LocalDateTime endDate = LocalDateTime.now();

    public void refreshEvents(){//sets events HM to new pull from database with whatever last dates you requested
        getClubEventByDate(startDate, endDate);
    }

    public void addClubEvent(ClubEvent clubEvent) {


        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            Object object = session.save(clubEvent);
            session.get(ClubEvent.class, (Serializable) object);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            refreshEvents();
            session.close();
        }
    }

    public void updateClubEvent(ClubEvent clubEvent) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try  {
            transaction = session.beginTransaction();
            session.merge(clubEvent);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            refreshEvents();//Remove all events stored in memory, replace with fresh
        }
    }

    public ClubEvent getClubEvent(int eventID) {
        if (!getClubEventByID.isEmpty() && getClubEventByID.get(eventID) != null) {
            return getClubEventByID.get(eventID);
        }
        Transaction transaction = null;
        ClubEvent clubEvent = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            clubEvent = session.get(ClubEvent.class, eventID);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            return clubEvent;
        }
    }

    public List<ClubEvent> getClubEventByClub(String clubName) {
        getClubEventByID.clear();
        Transaction transaction = null;
        List<ClubEvent> clubEvents = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String hql ="select ce from ClubEvent as ce INNER JOIN ce.club as c WHERE c.clubName= :name";
            //String hql = "select ce from ClubEvent ce join ce.club where clubName =: name ";
            Query query = session.createQuery(hql);
            query.setParameter("name", clubName);
            clubEvents = (List<ClubEvent>) query.list();
            transaction.commit();
            System.out.println("Okay  line 427 club events = " + clubEvents.get(0));
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println("Not Okay  line 429 club events = " + clubEvents);
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            System.out.println("Okay  line 432 club events = " + clubEvents.get(0));
            if (clubEvents != null) {
                for (ClubEvent newEvent : clubEvents) {
                    getClubEventByID.put(newEvent.getEventID(), newEvent);
                }
            }
            return clubEvents;
        }
    }

    public List<ClubEvent>  getClubEventByDate(LocalDateTime start, LocalDateTime end) {
        startDate = start;
        endDate = end;
        getClubEventByID.clear();

        Transaction transaction = null;
        List<ClubEvent> clubEvents = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String hql = "from ClubEvent ce where ce.eventDateTime between :start and :end";
            Query query = session.createQuery(hql);
            query.setParameter("start", start);
            query.setParameter("end", end);
            clubEvents = query.list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if(clubEvents != null) {
                for (ClubEvent newEvent : clubEvents) {
                    getClubEventByID.put(newEvent.getEventID(), newEvent);
                }
            }
            return clubEvents;
        }
    }


    public List<ClubEvent>  getClubEventByDateAndClub(LocalDateTime start, LocalDateTime end,String clubName ) {
        startDate = start;
        endDate = end;
        getClubEventByID.clear();

        Transaction transaction = null;
        List<ClubEvent> clubEvents = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String hql ="select ce from ClubEvent as ce INNER JOIN ce.club as c WHERE c.clubName= :name and " +
                    "ce.eventDateTime between :start and :end";
            Query query = session.createQuery(hql);
            query.setParameter("name", clubName);
            query.setParameter("start", start);
            query.setParameter("end", end);
            clubEvents = query.list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if(clubEvents != null) {
                for (ClubEvent newEvent : clubEvents) {
                    getClubEventByID.put(newEvent.getEventID(), newEvent);
                }
            }
            return clubEvents;
        }
    }

    @SuppressWarnings("unchecked")
        public List<ClubEvent> getAllClubEvents()  {
            getClubByIDHashMap.clear();

            Transaction transaction = null;
            List<ClubEvent> clubEvents = null;
            try {
                Session session = HibernateUtil.getSessionFactory().openSession();
                transaction = session.beginTransaction();
                CriteriaBuilder builder = session.getCriteriaBuilder();
                CriteriaQuery<ClubEvent> criteria = builder.createQuery(ClubEvent.class);
                criteria.from(ClubEvent.class);
                clubEvents = session.createQuery(criteria).getResultList();
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                if (transaction != null) {
                    transaction.rollback();
                }
            } finally {
                if(clubEvents != null) {
                    for (ClubEvent newEvent : clubEvents) {
                        getClubEventByID.put(newEvent.getEventID(), newEvent);
                    }
                }
                return clubEvents;
            }
    }


    @SuppressWarnings("null")
    public void deleteClubEvent(int eventID) {
        getClubByIDHashMap.clear();
        Transaction transaction = null;
        ClubEvent clubEvent = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            clubEvent = session.get(ClubEvent.class, eventID);
            if (clubEvent != null) {
                session.delete(clubEvent);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            refreshEvents();
        }

    }

    ////////// ClubEventBudget DAO

    public void addClubEventBudget(ClubEventBudget clubEventBudget) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Object object = session.save(clubEventBudget);
            session.get(ClubEventBudget.class, (Serializable) object);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public ClubEventBudget getClubEventBudget(int eventBudgetID) {
        Transaction transaction = null;
        ClubEventBudget clubEventBudget = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            clubEventBudget = session.get(ClubEventBudget.class, eventBudgetID);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            return clubEventBudget;
        }
    }

    public ClubEventBudget getClubEventBudgetByEvent(int eventID) {
        Transaction transaction = null;
        ClubEventBudget clubEventBudget = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String hql = "select ceb from ClubEventBudget ceb inner join ceb.clubevent where ceb.event_id =: eventid ";
            Query query = session.createQuery(hql);
            query.setParameter("eventid", eventID);
            query.setMaxResults(1);
            clubEventBudget = (ClubEventBudget) query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            return clubEventBudget;
        }
    }

    /////////ExpenditureDAO

    public void addExpenditure(Expenditure expenditure) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Object object = session.save(expenditure);
            session.get(Expenditure.class, (Serializable) object);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Expenditure getExpenditure(int expenditureID) {
        Transaction transaction = null;
        Expenditure expenditure = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            expenditure = session.get(Expenditure.class, expenditureID); //get student object by id
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            return expenditure;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Expenditure> getAllExpenditure() {
            Transaction transaction = null;
            List<Expenditure> expenditure = null;
            try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Expenditure> criteria = builder.createQuery(Expenditure.class);
            criteria.from(Expenditure.class);
            expenditure = session.createQuery(criteria).getResultList();
            transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
            } finally {
                return expenditure;
            }

        }

    public List<Expenditure> getAllExpenditureByClub(String clubName) {
        Transaction transaction = null;
        List<Expenditure> expenditure = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String hql ="select e from Expenditure as e INNER JOIN e.club as c WHERE c.clubName= :name";
            //String hql = "select ce from ClubEvent ce join ce.club where clubName =: name ";
            Query query = session.createQuery(hql);
            query.setParameter("name", clubName);
            expenditure  = (List<Expenditure>) query.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            return expenditure;
        }
    }

    public List<Expenditure> getAllExpenditureByEvent(int eventID) {
        Transaction transaction = null;
        List<Expenditure> expenditure = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String hql ="select e from Expenditure as e INNER JOIN e.clubevent as c WHERE c.event_id= :eventid";
            //String hql = "select ce from ClubEvent ce join ce.club where clubName =: name ";
            Query query = session.createQuery(hql);
            query.setParameter("eventid", eventID);
            expenditure  = (List<Expenditure>) query.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            return expenditure;
        }
    }

    public List<Expenditure>  getExpenditurByDate(Date start,Date end) {
        Transaction transaction = null;
        List<Expenditure> expenditures = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String hql = "from Expenditure e where e.date between :start and :end";
            Query query = session.createQuery(hql);
            query.setParameter("start ", start);
            query.setParameter("end", end);
            expenditures = query.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            return expenditures;
        }
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
        } finally {
            return result;
        }
    }
    public Integer maxClubEventId() {
        Integer result = null;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("select max(ce.eventID) from ClubEvent ce");
            result = (int) query.getResultList().get(0);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            return result;
        }
    }
    public Integer maxClubBudgetId() {
        Integer result = null;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("select max(cb.clubBudgetID) from ClubBudget cb");
            result = (int) query.getResultList().get(0);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            return result;
        }
    }
    public Integer maxClubEventBudget() {
        Integer result = null;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("select max(ceb.eventBudgetID) from ClubEventBudget ceb");
            result = (int) query.getResultList().get(0);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            return result;
        }
    }
    public Integer maxExpenditureID() {
        Integer result = null;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("select max(e.expenditureID) from Expenditure e");
            result = (int) query.getResultList().get(0);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            return result;
        }
    }

/*
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {

        DAO dao55 = new DAO();
        User user2 = new User("zviko","gwek","1239840293","zviko.g@hotmail.com",
                1234,dao55.getClub(2),null,"name","yourname");
        dao55.addUser(user2);
        System.out.println(dao55.getClubByName("All Clubs"));
        System.out.println(dao55.getClub(1));
        System.out.println(dao55.getUsersByClub(1));
        System.out.println(dao55.getAllClubs());
        User user = dao55.getUser("master@email.com");
        user.setPassword("1fkkr");
        user.setUserSalt("5henks");
        dao55.updateUser(user);
        user2.setUserSalt("9wxunwj");
        user2.setUserSalt("8bwhbi2eu");

    }
*/
}