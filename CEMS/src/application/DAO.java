package CEMS.src.application;
/*
import java.util.ArrayList;
import java.util.List;
import org.hibernate.*;

public class DAO {
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
}
*/