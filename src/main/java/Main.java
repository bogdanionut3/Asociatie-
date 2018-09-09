import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Integer meniuPrincipal(Scanner sc)
    {
        System.out.println("1. Inregistrare locatar nou");
        System.out.println("2. Sterege locatar din evidenta");
        System.out.println("3. Citire contoare");
        System.out.println("4. Iesire");
        Integer optiune = sc.nextInt();
        return optiune;
    }


    public static void optiunea1(Scanner sc, AsociatieProprietari asc)
    {
        System.out.println("Introduceti numele");
        String nume = sc.next();
        System.out.println("Introduceti CNP");
        String CNP = sc.next();
        System.out.println("Introduceti adresa de mail");
        String mail = sc.next();
        Apartament ap = new Apartament();
        Locatar loc = new Locatar(nume,CNP,mail);
        asc.registerAp(ap,loc);
    }
    public static void optiunea2(Scanner sc, AsociatieProprietari asc)
    {
        System.out.println("Introduceti numele");
        String nume = sc.next();
        System.out.println("Introduceti CNP");
        String CNP = sc.next();
        System.out.println("Introduceti adresa de mail");
        String mail = sc.next();
        Apartament ap = new Apartament();
        Locatar loc = new Locatar(nume,CNP,mail);
        asc.unregister(loc);
    }

    public static void optiunea3(Scanner sc, Apartament ap){
        System.out.println("Introduceti locatia contorului");
        String locatieContor = sc.next();
        System.out.println("Index apa rece");
        int indexRece = sc.nextInt();
        System.out.println("Index apa calda");
        int indexCalda = sc.nextInt();
        System.out.println("Index gaz");
        int indexGaz = sc.nextInt();
        Contor contorRece = new Contor(locatieContor,indexRece,Contor.contorType.APA_RECE);
        Contor contorCalda = new Contor(locatieContor, indexCalda, Contor.contorType.AP_CALDA);
        Contor contorGaz = new Contor(locatieContor, indexGaz,Contor.contorType.GAZ);
        List<Contor> cont = new ArrayList<Contor>();
        cont.add(contorRece);
        cont.add(contorCalda);
        cont.add(contorGaz);
        ap = new Apartament(cont);
        System.out.println(ap);
        }


    public static void main(String[] args) {
        List<Apartament> listaAp = new ArrayList<Apartament>();
        for(int i = 1; i<=5; i++){
            listaAp.add(new Apartament(i));
        }
        AsociatieProprietari asc = new AsociatieProprietari(listaAp,"RO12INGB00000900001254");
        Apartament ap = new Apartament();
        Scanner sc = new Scanner(System.in);
        while (true)
        {
            Integer optiune = meniuPrincipal(sc);
            switch (optiune)
            {
                case 1:
                    optiunea1(sc, asc);
                    break;
                case 2:
                    optiunea2(sc, asc);
                    break;
                case 3:
                    optiunea3(sc, ap);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Optiunea nu exista");
                    break;
            }
        }
      /*  HibernateLocatari app = new HibernateLocatari();
        Locatar loc = new Locatar("bogdan@yahoo.com", "Bogdan", "12354");
        app.insert(loc);
        System.out.println(loc);
        System.out.println(app.getAll(Locatar.class));//aduc clasa locatar.
        Contor x = new Contor("baie", 0, Contor.contorType.AP_CALDA);
        Contor y = new Contor("bucatarie", 0, Contor.contorType.GAZ);
        Contor z = new Contor("bucatarie", 0, Contor.contorType.APA_RECE);

        List<Contor> cont = new ArrayList<Contor>();
        cont.add(x);
        cont.add(y);
        cont.add(z);

        Apartament ap1 = new Apartament(208, cont);
        Apartament ap = new Apartament();
        List<Apartament> aplist = new ArrayList<Apartament>();
        aplist.add(ap);
        AsociatieProprietari asc = new AsociatieProprietari(aplist, "ro");
        app.insert(ap1);
        asc.registerAp(ap1,loc);
        System.out.println(ap1);
        System.out.println(asc.registerAp(ap1,loc));*/
    }
}
