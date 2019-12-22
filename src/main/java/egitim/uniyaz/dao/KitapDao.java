package egitim.uniyaz.dao;

import egitim.uniyaz.domain.Kitap;
import egitim.uniyaz.domain.Yazar;
import egitim.uniyaz.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class KitapDao {

    public Kitap saveKitap(Kitap kitap) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            session.getTransaction().begin();
            kitap = (Kitap) session.merge(kitap);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return kitap;
    }
    public List<Kitap> findAllKitap() {
        List<Kitap> kitapList = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select kitap From Kitap kitap";
            Query query = session.createQuery(hql);
            kitapList = query.list();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return kitapList;
    }
}
