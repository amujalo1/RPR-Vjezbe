import ba.unsa.etf.rpr.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LicneInformacije osoba = new LicneInformacije("John", "Doe");
        InformacijeOStudentu student = new InformacijeOStudentu("Marko", "Marković", "3. godina", "12345");
        InformacijeONastavniku nastavnik = new InformacijeONastavniku("Ana", "Anić", "Docent");
        Predmet predmet = new Predmet("Programiranje", "Učenje programiranja u Javi");

        List<Predstavljiv> predstavljivi = Arrays.asList(osoba, student, nastavnik, predmet);

        KolekcijaPoruka kolekcijaPoruka = new KolekcijaPoruka(predstavljivi);

        for (String poruka : kolekcijaPoruka.getPoruke()) {
            System.out.println(poruka);
            System.out.println("----------------------");
        }
    }
}
