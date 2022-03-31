package CEMS.src.application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

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

    @SuppressWarnings("null")

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

    public User getUser(String email) {
        Transaction transaction = null;
        User user = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            user = session.get(User.class, email); //get student object by email on login
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return user;
    }

    /*
        @SuppressWarnings("unchecked")
        public List<User> getAllUsers() {
            Transaction transaction = null;
            List<User> users = null;
            try {
                Session session = HibernateUtil.getSessionFactory().openSession();
                transaction = session.beginTransaction();
                users = session.createQuery("from user").list();
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
            }
            return users;
        }
    */ // get all not working yet
    @SuppressWarnings("null")
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
    /*
        @SuppressWarnings("unchecked")
        public List<Expenditure> getAllExpenditure() {
            Transaction transaction = null;
            List<Expenditure> expenditure = null;
            try {
                Session session = HibernateUtil.getSessionFactory().openSession();
                transaction = session.beginTransaction();
                clubEventBudget = session.createQuery("from expenditure").list();
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
            }
            return expenditure;
        }
    */ // get all not working yet


    /////////ClubMemberDAO
//    public void addClubMember(ClubMember clubMember) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            Object object = session.save(clubMember);
//            session.get(ClubMember.class, (Serializable) object);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//    }
//
//    public void updateClubMember(ClubMember clubMember) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            session.saveOrUpdate(clubMember);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//    }

//    public ClubMember getClubMember(int student_id) {
//        Transaction transaction = null;
//        ClubMember clubMember = null;
//        try {
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            transaction = session.beginTransaction();
//            clubMember = session.get(ClubMember.class, student_id); //get student object by id
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
//        return clubMember;
//    }

    /*    @SuppressWarnings("unchecked")
        public List<ClubMember> getAllClubMember() {
            Transaction transaction = null;
            List<ClubMember> clubMembers = null;
            try {
                Session session = HibernateUtil.getSessionFactory().openSession();
                transaction = session.beginTransaction();
                clubMembers = session.createQuery("from club").list();
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
            }
            return clubMembers;
        }
    */ /*
 getall() not working yet
    @SuppressWarnings("null")
    public void deleteClubMember(int student_id) {
        Transaction transaction = null;
        ClubMember clubMember = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            clubMember = session.get(ClubMember.class, student_id);
            if (clubMember != null) {
                session.delete(clubMember);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
*/

   /*

    //// Add
    public void addUser(User user) {
        Transaction transaction = null;
        Session session = newSession.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            System.out.println("Save Successful");
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public void addClub(Club club) {
        Transaction transaction = null;
        Session session = newSession.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(club);
            session.getTransaction().commit();
            System.out.println("Save Successful");
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void addExpenditure(Expenditure expenditure) {
        Transaction transaction = null;
        Session session = newSession.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(expenditure);
            session.getTransaction().commit();
            System.out.println("Save Successful");
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    //// GET


    //// Lists

    public List<Club> getClubs() {
        List<Club> clubs = new ArrayList<Club>();
        Transaction transaction = null;
        Session session = newSession.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            clubs = session.createQuery("from Club" ).list();

        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return clubs;
    }

    public List<Expenditure> getExpenditures() {
        List<Expenditure> expenditures = new ArrayList<Expenditure>();
        Transaction transaction = null;
        Session session = newSession.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            expenditures
                    = session.createQuery("from Expenditure" ).list();

        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return expenditures;
    }

    //////////TEST
    public static void main(String[] args) {

        DAO dao = new DAO();
        Club club = new Club("knitting club","we enjoy knitting");
        dao.addClub(club);
    }

    */


    public static void main(String[] args) {
        DAO dao = new DAO();
/*
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
*/
    }
}
