import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity

public class Apartament implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = false)
    private Integer nr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ap")//relatia dintre tabele
    private List<Contor> contoare;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ap")
    private List<Locatar> locatari;

    public Apartament(List<Contor> contoare) {
        this.contoare = contoare;
        for(Contor c: contoare){
            c.setAp(this);
        }
    }
    public void addLoc(Locatar loc){
        locatari.add(loc);
        loc.setAp(this);
    }

    public void removeLoc(Locatar loc){
        locatari.remove(loc);
        loc.setAp(this);
    }


  public Apartament(Integer nr){
        this.nr = nr;

    }
    public Apartament(){

    }

    @Override
    public String toString() {
        return "Apartament " +
                "nr=" + nr + "\n"+
                ", contoare=" + contoare +"\n"+
                ", locatari=" + locatari +"\n"
                ;
    }
}
