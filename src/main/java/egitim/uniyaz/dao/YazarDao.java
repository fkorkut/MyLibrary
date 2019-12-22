package egitim.uniyaz.dao;

import egitim.uniyaz.domain.Kitap;
import egitim.uniyaz.domain.Yazar;
import egitim.uniyaz.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;


public class YazarDao {

    public Yazar saveYazar(Yazar yazar) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            session.getTransaction().begin();
            yazar = (Yazar) session.merge(yazar);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return yazar;
    }

    public List<Yazar> findAllYazar() {
        List<Yazar> yazarList = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select yazar From Yazar yazar";
            Query query = session.createQuery(hql);
            yazarList = query.list();//?
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return yazarList;
    }
}
