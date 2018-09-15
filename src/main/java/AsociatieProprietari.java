
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

    public Apartament  unregister(Locatar loc) {
        boolean unregistered = false;
        for (int i = 0; i < apartaments.size(); i++) {
            Apartament aux = apartaments.get(i);
            if (aux.contains(loc)) {
                Locatar locFromDB = aux.getLocByCNP(loc);
                apartaments.get(i).removeLoc(loc);
                locFromDB.setAp(null);
                return aux;
            }
        }
        return null;
    }
}
