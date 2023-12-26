package ba.unsa.etf.rpr;


import java.util.ArrayList;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GeografijaDAO geografijaDAO = GeografijaDAO.getInstance();

        String gradoviInfo = ispisiGradove();
        System.out.println(gradoviInfo);

        glavniGradTest();
        dodajGradTest();
        dodajDrzavuTest();
        izmijeniGradTest();
        obrisiDrzavuTest();

        // Print updated list of cities
        gradoviInfo = ispisiGradove();
        System.out.println(gradoviInfo);
    }
    public static String ispisiGradove() {
        GeografijaDAO geografijaDAO = GeografijaDAO.getInstance();
        ArrayList<Grad> gradovi = geografijaDAO.gradovi();

        StringBuilder result = new StringBuilder();
        for (Grad grad : gradovi) {
            result.append(grad.getNaziv()).append(" (").append(grad.getDrzava()).append(") - ").append(grad.getBrojStanovnika()).append("\n");
        }
        return result.toString();
    }
    public static void glavniGradTest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite naziv države:");
        String nazivDrzave = scanner.nextLine();

        GeografijaDAO geografijaDAO = GeografijaDAO.getInstance();
        String glavniGrad = geografijaDAO.glavniGrad(nazivDrzave);

        if (glavniGrad != null) {
            System.out.println("Glavni grad države " + nazivDrzave + " je " + glavniGrad);
        } else {
            System.out.println("Nepostojeća država");
        }
    }

    public static void dodajGradTest() {
        GeografijaDAO geografijaDAO = GeografijaDAO.getInstance();
        Grad noviGrad = new Grad("Berlin", 3500000, "Njemačka");
        geografijaDAO.dodajGrad(noviGrad);
        System.out.println("Grad dodan: " + noviGrad.getNaziv());
    }

    public static void dodajDrzavuTest() {
        GeografijaDAO geografijaDAO = GeografijaDAO.getInstance();
        Drzava novaDrzava = new Drzava("Italija", "Rim");
        geografijaDAO.dodajDrzavu(novaDrzava);
        System.out.println("Država dodana: " + novaDrzava.getNaziv());
    }

    public static void izmijeniGradTest() {
        GeografijaDAO geografijaDAO = GeografijaDAO.getInstance();
        Grad gradZaIzmjenu = new Grad("London", 9000000, "Velika Britanija");
        geografijaDAO.izmijeniGrad(gradZaIzmjenu);
        System.out.println("Grad izmijenjen: " + gradZaIzmjenu.getNaziv());
    }

    public static void obrisiDrzavuTest() {
        GeografijaDAO geografijaDAO = GeografijaDAO.getInstance();
        System.out.println("Unesite naziv države za brisanje:");
        Scanner scanner = new Scanner(System.in);
        String nazivDrzave = scanner.nextLine();
        geografijaDAO.obrisiDrzavu(nazivDrzave);
        System.out.println("Država i gradovi u njoj obrisani: " + nazivDrzave);
    }

}
