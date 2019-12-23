package egitim.uniyaz.domain;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Audited
@Table(name = "Kullanici")
public class Kullanici extends BaseDomain {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(length = 50)
    @Size(max = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private KullaniciState kullaniciState;

    private String kullaniciParola;

    public KullaniciState getKullaniciState() {
        return kullaniciState;
    }

    public void setKullaniciState(KullaniciState kullaniciState) {
        this.kullaniciState = kullaniciState;
    }

    public String getKullaniciParola() {
        return kullaniciParola;
    }

    public void setKullaniciParola(String kullaniciParola) {
        this.kullaniciParola = kullaniciParola;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
