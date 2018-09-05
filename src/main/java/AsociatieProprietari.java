
import java.util.List;

public class AsociatieProprietari {
    private List<Apartament> apartaments;
    private final String iban;

    public AsociatieProprietari(List<Apartament> apartaments, String iban) {
        this.apartaments = apartaments;
        this.iban = iban;
        }

        public Apartament registerAp(Apartament ap, Locatar loc){
           ap.addLoc(loc);
           return ap;
        }

        public Apartament unregister(Apartament ap, Locatar loc){
           ap.removeLoc(loc);
           return ap;
        }
}
