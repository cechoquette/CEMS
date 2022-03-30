package CEMS.src.application;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.io.Serializable;

public class ClubDAO {

    public void saveClub(Club club) {
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
    */ //
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
    // TEST

    public static void main(String[] args) {

        ClubDAO clubdao = new ClubDAO();

        Club club = new Club("knitting club","we enjoy knitting");
        Club club1 = new Club("sowing club","we enjoy sowing");
        clubdao.saveClub(club);
        clubdao.saveClub(club1);
        System.out.println(clubdao.getClub(1));
        club.setClubName("rowing");
        clubdao.updateClub(club);
        System.out.println(clubdao.getClub(1));
        //System.out.println(clubdao.getAllClubs());
        clubdao.deleteClub(1);

    }


}
