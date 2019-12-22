package egitim.uniyaz.dao;

import egitim.uniyaz.domain.UyeKitap;
import egitim.uniyaz.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UyeKitapDao {
    public UyeKitap saveUyeKitap(UyeKitap uyeKitap) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            session.getTransaction().begin();
            uyeKitap = (UyeKitap) session.merge(uyeKitap);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return uyeKitap;
    }

}
