package egitim.uniyaz.dao;

import egitim.uniyaz.MyUI;
import egitim.uniyaz.domain.KitapOkumaState;
import egitim.uniyaz.domain.Kullanici;
import egitim.uniyaz.domain.UyeKitap;
import egitim.uniyaz.ui.views.KullaniciGirisView;
import egitim.uniyaz.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

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

    public UyeKitap updateUyeKitap(UyeKitap uyeKitap) {

        Long id=uyeKitap.getId();
        Date baslangicTarihi=uyeKitap.getBaslangicTarihi();
        Long gun=uyeKitap.getGun();
        KitapOkumaState kitapOkumaState=uyeKitap.getKitapOkumaState();

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession();) {

            String hql = "update UyeKitap set baslangicTarihi = :baslangicTarihi , gun = :gun , kitapOkumaState = :kitapOkumaState  where id = :id";

            Query query = session.createQuery(hql);

            query.setParameter("baslangicTarihi", baslangicTarihi);
            query.setParameter("gun", gun);
            query.setParameter("kitapOkumaState", kitapOkumaState);
            query.setParameter("id", id);

            session.getTransaction().begin();
            uyeKitap = (UyeKitap) session.merge(uyeKitap);
            session.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return uyeKitap;
    }

    public List<UyeKitap> findAllKitapByKullanici(Kullanici kullanici) {
        List<UyeKitap> uyeKitapList = null;

        Long kullaniciId=kullanici.getId();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select uyeKitap From UyeKitap uyeKitap where  ID_KULLANICI=:ID_KULLANICI";
            Query query = session.createQuery(hql);
            query.setParameter("ID_KULLANICI", kullaniciId);
            uyeKitapList = query.list();//?
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return uyeKitapList;
    }



    public List<UyeKitap> findFinishKitapByKullanici(Kullanici kullanici) {
        List<UyeKitap> uyeKitapList = null;

        Long kullaniciId=kullanici.getId();

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select uyeKitap From UyeKitap uyeKitap where  ID_KULLANICI=:ID_KULLANICI and kitapOkumaState='OKUDUM'";
            Query query = session.createQuery(hql);
            query.setParameter("ID_KULLANICI", kullaniciId);
            uyeKitapList = query.list();//?
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return uyeKitapList;
    }

}
