import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Contor implements Serializable {
    public enum contorType {
        GAZ,
        AP_CALDA,
        APA_RECE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String locatie;
    @Column(nullable = false, name = "contor_index")
    private Integer index;
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private contorType type;
    @ManyToOne
    private Apartament ap;

    public Contor() {
    }

    public Contor(String locatie, Integer index, contorType type) {
        this.locatie = locatie;
        this.index = index;
        this.type = type;
    }

    public void setAp(Apartament ap){
        this.ap = ap;
    }

    @Override
    public String toString() {
        return "Contor{" +
                "id=" + id +
                ", locatie='" + locatie + '\'' +
                ", index=" + index +
                ", type=" + type +
                '}';
    }
}
