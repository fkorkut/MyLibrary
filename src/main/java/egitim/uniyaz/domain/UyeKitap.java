package egitim.uniyaz.domain;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
@Audited
@Table(name = "UyeKitap")
public class UyeKitap extends BaseDomain {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_KITAP", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "UYEKITAP_KITAP_ID"))
    private Kitap kitap;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_KULLANICI", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "UYEKITAP_KULLANICI_ID"))
    private Kullanici kullanici;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private KitapOkumaState kitapOkumaState;

    private  long gun;


    private Date baslangicTarihi;

    public KitapOkumaState getKitapOkumaState() {
        return kitapOkumaState;
    }

    public void setKitapOkumaState(KitapOkumaState kitapOkumaState) {
        this.kitapOkumaState = kitapOkumaState;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

     public Date getBaslangicTarihi() {
        return baslangicTarihi;
    }

    public void setBaslangicTarihi(Date baslangicTarihi) {
        this.baslangicTarihi = baslangicTarihi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Kitap getKitap() {
        return kitap;
    }

    public void setKitap(Kitap kitap) {
        this.kitap = kitap;
    }

    public long getGun() {
        return gun;
    }

    public void setGun(long gun) {
        this.gun = gun;
    }


    @Override
    public String toString() {
        return kullanici+" "+kitap;
    }
}
