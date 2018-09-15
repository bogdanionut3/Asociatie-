import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {
    private Scanner sc;

    private Locatar insertNewLocatar() {
        System.out.println("Introduceti numele locatarului");
        String name = sc.nextLine();
        System.out.println("Introduceti CNP locatar");
        String cnp = sc.nextLine();
        System.out.println("Introduceti adresa de mail");
        String mail = sc.nextLine();
        Locatar locatar = new Locatar(name, cnp, mail);
        return locatar;
    }

    private Integer drawMainMenu() {
        System.out.println("\n***************************");
        System.out.println("Operations:");
        System.out.println("1. Register");
        System.out.println("2. Unregister");
        System.out.println("3. Exit");
        Integer option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public void switchMenu() {
        HibernateLocatari db = new HibernateLocatari();
        List<Object> objList = db.getAll(Apartament.class);
        List<Apartament> apList = new ArrayList<Apartament>();
        for (Object e : objList) {
            apList.add((Apartament) e);
        }
        AsociatieProprietari asociatie = new AsociatieProprietari(apList, "1234");


        while (true) {
            switch (drawMainMenu()) {
                case 1:
                    for (Apartament ap : apList) {
                        System.out.println("Introduceti numarul apartamentului");
                        int numar = sc.nextInt();
                        Apartament ap1 = new Apartament(numar);
                        if (ap1.contains(insertNewLocatar()))
                            asociatie.registerAp(ap,insertNewLocatar());
                    }
                    break;
                case 2:
                    asociatie.unregister(insertNewLocatar());
                case 3:
                    System.out.println("Have a nice day");
                    break;
                default:
                    System.out.println("Va rog selectati optiunea corecta.");
            }
        }
    }



//        List<Apartament> listaAp = new ArrayList<Apartament>();
//        List<Contor> contorList;
//        for (int i = 1; i <= 5; i++) {
//            contorList = new ArrayList<Contor>();
//            Contor contorBaie1 = new Contor("baie", 0, Contor.contorType.AP_CALDA);
//            Contor contorBaie2 = new Contor("bucatarie", 0, Contor.contorType.APA_RECE);
//            Contor contorBucatarie1 = new Contor("bucatarie", 0, Contor.contorType.APA_RECE);
//            Contor contorBucatarie2 = new Contor("baie", 0, Contor.contorType.AP_CALDA);
//            Contor contorGaz = new Contor("gaz", 0, Contor.contorType.GAZ);
//            contorList.add(contorBaie1);
//            contorList.add(contorBaie2);
//            contorList.add(contorBucatarie1);
//            contorList.add(contorBucatarie2);
//            contorList.add(contorGaz);
//            listaAp.add(new Apartament(i, contorList));
//        }
//        HibernateLocatari hibernate = new HibernateLocatari();
//        for (Apartament a:listaAp)
//        hibernate.insert(a);

}
