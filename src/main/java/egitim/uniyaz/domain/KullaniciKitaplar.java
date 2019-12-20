package egitim.uniyaz.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "KullaniciKitaplar")
public class KullaniciKitaplar {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KITAP", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "KULLANICIKITAP_KITAP_ID"))
    private Kitap kitap;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_YAZAR", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "KULLANICIKITAP_YAZAR_ID"))
    private Yazar yazar;

    private  int gun;

    public int getGun() {
        return gun;
    }

    public void setGun(int gun) {
        this.gun = gun;
    }

    public Yazar getYazar() {
        return yazar;
    }

    public void setYazar(Yazar yazar) {
        this.yazar = yazar;
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
        return yazar+" "+kitap;
    }
}
