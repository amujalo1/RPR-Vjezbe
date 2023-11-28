import ba.unsa.etf.rpr.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predmet programiranje = new Predmet("Programiranje", "Učenje programiranja u Javi");
        InformacijeONastavniku nastavnik = new InformacijeONastavniku("Ana", "Anić", "Docent");
        InformacijeOStudentu student = new InformacijeOStudentu("Marko", "Marković", "3. godina", "12345");

        System.out.print("Unesite ocjenu za predmet Programiranje: ");
        int ocjenaPredmet = scanner.nextInt();
        nastavnik.ocijeni(student, ocjenaPredmet);

        if (student != null) {
            System.out.print("Unesite ocjenu za nastavnika Anu Anić: ");
            int ocjenaNastavnik = scanner.nextInt();
            nastavnik.ocijeni(student, ocjenaNastavnik);
        }

        System.out.println("\nOcjene za predmet Programiranje:");
        for (Ocjena ocjena : programiranje.getOcjene()) {
            System.out.println("Ocjenio: " + ocjena.getOsoba().getIme() + " " + ocjena.getOsoba().getPrezime());
            System.out.println("Ocjena: " + ocjena.getOcjena());
            System.out.println("----------------------");
        }

        System.out.println("\nOcjene za nastavnika Anu Anić:");
        for (Ocjena ocjena : nastavnik.getOcjene()) {
            System.out.println("Ocjenio: " + ocjena.getOsoba().getIme() + " " + ocjena.getOsoba().getPrezime());
            System.out.println("Ocjena: " + ocjena.getOcjena());
            System.out.println("----------------------");
        }
    }
}
