package CEMS.src.application;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class DAO {

    ////////// ClubDAO
    public void addClub(Club club) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Object object = session.save(club);
            session.get(Club.class, (Serializable) object);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateClub(Club club) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(club);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Club getClub(int clubID) {
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
        }
        return club;
    }

    public Club getClubByName(String clubName) {
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
        }
        return club;
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
        }
        return clubs;
    }

    //// UserDAO
    public void addUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Object object = session.save(user);
            session.get(User.class, (Serializable) object);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
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
        }
        return user;
    }

    public List<User> getUsersByClub(int clubID){
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
        }
        return users;
    }

    public void deleteUser(int studentID) {
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
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Object object = session.save(clubBudget);
            session.get(ClubBudget.class, (Serializable) object);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public ClubBudget getClubBudget(int clubBudgetID) {
        Transaction transaction = null;
        ClubBudget clubBudget = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            clubBudget = session.get(ClubBudget.class, clubBudgetID);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return clubBudget;
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
        }
        return clubBudget;
    }

    ////////// ClubEventDAO

    public void addClubEvent(ClubEvent clubEvent) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Object object = session.save(clubEvent);
            session.get(ClubEvent.class, (Serializable) object);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateClubEvent(ClubEvent clubEvent) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(clubEvent);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public ClubEvent getClubEvent(int eventID) {
        Transaction transaction = null;
        ClubEvent clubEvent = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            clubEvent = session.get(ClubEvent.class, eventID);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return clubEvent;
    }
    public List<ClubEvent>getClubEventByClub(String clubName) {
        Transaction transaction = null;
        List<ClubEvent> clubEvents = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String hql = "from ClubEvent ce where ce.clubName =: clubname";
            Query query = session.createQuery(hql);
            query.setParameter("clubname", clubName);
            clubEvents = (List<ClubEvent>) query.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return clubEvents;
    }

    public List<ClubEvent>  getClubEventByDate(Date start,Date end) {
        Transaction transaction = null;
        List<ClubEvent> clubEvents = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String hql = "from ClubEvent ce where ce.eventDateTime between :start and :end";
            Query query = session.createQuery(hql);
            query.setParameter("start ", start);
            query.setParameter("end", end);
            clubEvents = query.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return clubEvents;
    }

    @SuppressWarnings("unchecked")
        public List<ClubEvent> getAllClubEvents()  {
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
                if (transaction != null) {
                    transaction.rollback();
                }
            }
            return clubEvents;
    }


    @SuppressWarnings("null")
    public void deleteClubEvent(int eventID) {
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
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    ////////// ClubEventBudget DAO

    public void addClubEventBudget(ClubEventBudget clubEventBudget) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Object object = session.save(clubEventBudget);
            session.get(ClubEventBudget.class, (Serializable) object);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
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
        }
        return clubEventBudget;
    }

    /////////ExpenditureDAO

    public void addExpenditure(Expenditure expenditure) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Object object = session.save(expenditure);
            session.get(Expenditure.class, (Serializable) object);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
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
        }
        return expenditure;
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
            }
            return expenditure;
        }

    public List<Expenditure> getAllExpenditureByClub(String clubName) {
        Transaction transaction = null;
        List<Expenditure> expenditure = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<Expenditure> criteria = builder.createQuery(Expenditure.class);
            Root<Expenditure> root = criteria.from(Expenditure.class);
            root.join("club");

            criteria.where(builder.equal(root.get("clubName"), clubName));
            Query<Expenditure> query = session.createQuery(criteria);
            expenditure = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return expenditure;
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
        }
        return expenditures;
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
        }
        return result;
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
        }
        return result;
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
        }
        return result;
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
        }
        return result;
    }


    public static void main(String[] args) {

        DAO dao55 = new DAO();
        System.out.println(dao55.getClubByName("All Clubs"));
        System.out.println(dao55.getClub(1));
        System.out.println(dao55.getUsersByClub(1));
        System.out.println(dao55.getAllClubs());
        User user = dao55.getUser("master@email.com");
        user.setPassword("10fvjoshoi0");
        //user.setUserSalt("5510fvjoshoi0");
        dao55.updateUser(user);
    }

}