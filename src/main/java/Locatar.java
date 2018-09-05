import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
//@Entity("")
public class Locatar implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)//il oblig sa mentioneze un nume
    private String cnp;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @ManyToOne
    private Apartament ap;

    public Locatar(  String name, String cnp, String email){
        this.name = name;
        this.cnp = cnp;
        this.email = email;
    }

    public Locatar() {
    }

    public void setAp(Apartament ap){
        this.ap = ap;
    }

    @Override
    public String toString() {
        return "Locatar{" +
                "id=" + id +
                ", cnp='" + cnp + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
