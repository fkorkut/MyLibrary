package egitim.uniyaz.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "UyeKitap")
public class UyeKitap {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KITAP", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "UYEKITAP_KITAP_ID"))
    private Kitap kitap;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KULLANICI", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "UYEKITAP_KULLANICI_ID"))
    private Kullanici kullanici;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private KitapOkumaState kitapOkumaState;

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

    private  int gun;

    public int getGun() {
        return gun;
    }

    public void setGun(int gun) {
        this.gun = gun;
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


    @Override
    public String toString() {
        return kullanici+" "+kitap;
    }
}
