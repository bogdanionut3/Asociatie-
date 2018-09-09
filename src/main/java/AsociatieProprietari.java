
import java.util.List;

public class AsociatieProprietari {
    private List<Apartament> apartaments;
    private final String iban;

    public AsociatieProprietari(List<Apartament> apartaments, String iban) {
        this.apartaments = apartaments;
        this.iban = iban;
    }

    public Apartament registerAp(Apartament ap, Locatar loc) {
        ap.addLoc(loc);
        return ap;
    }

    public boolean unregister(Locatar loc) {
        boolean unregistered = false;
        for (int i = 0; i < apartaments.size(); i++) {
            apartaments.get(i).removeLoc(loc);
            unregistered = true;
        }
        return unregistered;
    }
}
