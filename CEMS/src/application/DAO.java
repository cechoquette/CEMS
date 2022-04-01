package CEMS.src.application;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
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
            club = session.get(Club.class, clubID); //get student object by id
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
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
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


    /*    @SuppressWarnings("unchecked")
        public List<ClubBudget> getAllClubBudgets() {
            Transaction transaction = null;
            List<ClubBudgets> clubBudgets = null;
            try {
                Session session = HibernateUtil.getSessionFactory().openSession();
                transaction = session.beginTransaction();
                clubs = session.createQuery("from ClubBudget").list();
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
            }
            return clubBudgets;
        }
    */ // getAllClubbBudgets


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

    /*    @SuppressWarnings("unchecked")
        public List<ClubEvent> getAllClubEvents() {
            Transaction transaction = null;
            List<ClubEvents> clubEvents = null;
            try {
                Session session = HibernateUtil.getSessionFactory().openSession();
                transaction = session.beginTransaction();
                clubEvents = session.createQuery("from ClubEvent").list();
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
            }
            return clubEvents;
        }
    */ // getAllClubEvent

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
            clubEventBudget = session.get(ClubEventBudget.class, eventBudgetID); //get student object by id
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return clubEventBudget;
    }
    /*
        @SuppressWarnings("unchecked")
        public List<ClubEventBudget> getClubEventBudget() {
            Transaction transaction = null;
            List<ClubEventBudget> users = null;
            try {
                Session session = HibernateUtil.getSessionFactory().openSession();
                transaction = session.beginTransaction();
                clubEventBudget = session.createQuery("from clubeventbudget").list();
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
            }
            return clubEventBudget;
        }
    */ // get all not working yet

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

    public Integer max() {
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


    /*
        public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
            DAO dao = new DAO();
            Club club1 = new Club("cs club","we enjoy cs");
            User user = new User("Erin", "Cameron", "867-878-6767",
                    "erin@algoma.ca", 123456789, club1, "Admin", "Age?", "29");
            dao.addClub(club1);
            dao.getClubByName("cs club");
            dao.addUser(user);
            System.out.println(dao.getClubByName("cs club"));
            user.setPassword("25163");
            dao.updateUser(user);
            System.out.println(dao.getUser("erin@algoma.ca"));
            user.setPassword("glokmn");
            user.setUserSalt("35789");
            dao.updateUser(user);
            System.out.println(dao.getUser("erin@algoma.ca"));
        }
    */
    //Club Test
/*    public static void main(String[] args){
        DAO dao = new DAO();
        Club club = new Club("knitting club", "we enjoy knitting");
        Club club1 = new Club("sowing club", "we enjoy sowing");
        Club club2 = new Club("running club", "we enjoy runnig");
        Club club3 = new Club("cs club", "we enjoy cs");
        dao.addClub(club);
        dao.addClub(club1);
        dao.addClub(club2);
        dao.addClub(club3);
        System.out.println(dao.getClub(1));
        club2.setClubName("singing");
        dao.updateClub(club2);
        System.out.println(dao.getClub(1));
        System.out.println(dao.getAllClubs());
        System.out.println(club1.max());
          System.out.println(dao.getClubBudgetByClub("sowing club"));

    }
*/

}