import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ap", orphanRemoval = true)
    private List<Locatar> locatari;

    public Apartament(Integer nr, List<Contor> contoare) {
        this.contoare = contoare;
        for (Contor c : contoare) {
            c.setAp(this);
        }
        locatari = new ArrayList<Locatar>();
        this.nr = nr;
    }

    public void addLoc(Locatar loc) {
        locatari.add(loc);
        loc.setAp(this);
    }

    public boolean contains(Locatar locatar) {
        return locatari.contains(locatar);
    }


    public void removeLoc(Locatar loc) {
        locatari.remove(loc);
        loc.setAp(null);
    }


    public Apartament(Integer nr) {
        this.nr = nr;

    }

    public Apartament() {

    }

    @Override
    public String toString() {
        return "Apartament " +
                "nr=" + nr + "\n" +
                ", contoare=" + contoare + "\n" +
                ", locatari=" + locatari + "\n"
                ;
    }

    public Locatar getLocByCNP(Locatar loc) {

        for(Locatar l:locatari)
         if(l.equals(loc))
            return l;
        return null;
    }
}
