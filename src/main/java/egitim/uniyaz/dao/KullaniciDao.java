package egitim.uniyaz.dao;


import egitim.uniyaz.domain.Kullanici;
import egitim.uniyaz.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class KullaniciDao {
//    private SessionFactory sessionFactory;
//
//    public KullaniciDao() {
//        sessionFactory = HibernateUtil.getSessionFactory();
//    }

    public Kullanici findKullanici(Kullanici giriskullanici) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        String name=giriskullanici.getName();
        String kullaniciParola=giriskullanici.getKullaniciParola();

        try (Session session = sessionFactory.openSession();) {
            String hql = "Select kullanici from Kullanici kullanici where name = :name and kullaniciParola=:kullaniciParola";
            Query query = session.createQuery(hql);
            query.setParameter("name", name);
            query.setParameter("kullaniciParola",kullaniciParola);
            Kullanici kullanici=(Kullanici)query.uniqueResult();
            return kullanici;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    public List<Kullanici> findAllUye() {
        List<Kullanici> kullaniciList = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select kullanici From Kullanici kullanici where  kullaniciState='UYE'";
            Query query = session.createQuery(hql);
            kullaniciList = query.list();//?
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return kullaniciList;
    }
}
