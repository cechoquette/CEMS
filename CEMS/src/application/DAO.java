package CEMS.src.application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.*;

public class DAO {

    //// ClubDAO
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

    /*    @SuppressWarnings("unchecked")
        public List<Club> getAllClubs() {
            Transaction transaction = null;
            List<Club> clubs = null;
            try {
                Session session = HibernateUtil.getSessionFactory().openSession();
                transaction = session.beginTransaction();
                clubs = session.createQuery("from club").list();
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
            }
            return clubs;
        }
    */ // getall() not working yet
    @SuppressWarnings("null")
    public void deleteClub(int clubID) {
        Transaction transaction = null;
        Club club = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            club = session.get(Club.class, clubID);
            if (club != null) {
                session.delete(club);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    //// UserDAO
    public void addUser(User user ){
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

    public User getUser(int studentID) {
        Transaction transaction = null;
        User user = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            user = session.get(User.class, studentID); //get student object by id
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
            if (user!= null) {
                session.delete(user);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    //// ClubBudgetDAO

    public void saveClubBudget(ClubBudget clubBudget) {
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

    public void updateClubBudget(ClubBudget clubBudget) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(clubBudget);
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

    @SuppressWarnings("null")
    public void deleteClubBudget(int clubBudgetID) {
        Transaction transaction = null;
        ClubBudget clubBudget = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            clubBudget = session.get(ClubBudget.class, clubBudgetID);
            if (clubBudget != null) {
                session.delete(clubBudget);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }



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
}
