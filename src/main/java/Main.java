import ba.unsa.etf.rpr.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Primjer korištenja s KolekcijaImena
        List<String> imena1 = new ArrayList<>();
        imena1.add("Ana Ivanović");
        imena1.add("Marko Marković");
        KolekcijaImena kolekcija1 = new KolekcijaImena(imena1);
        Pobjednik pobjednik1 = new Pobjednik(kolekcija1);
        System.out.println(pobjednik1);

        // Primjer korištenja s KolekcijaImenaIPrezimena
        List<String> imena2 = new ArrayList<>();
        imena2.add("Ivana");
        imena2.add("Nikola");
        List<String> prezimena2 = new ArrayList<>();
        prezimena2.add("Ivanović");
        prezimena2.add("Nikolić");
        KolekcijaImenaIPrezimena kolekcija2 = new KolekcijaImenaIPrezimena(imena2, prezimena2);
        Pobjednik pobjednik2 = new Pobjednik(kolekcija2);
        System.out.println(pobjednik2);
    }
}
