package egitim.uniyaz.domain;


import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Audited
@Table(name = "Kitap")
public class Kitap extends BaseDomain {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(length = 50)
    @Size(max = 50)
    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_YAZAR", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "KITAP_YAZAR_ID"))
    private Yazar yazar;

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
