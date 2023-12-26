package ba.unsa.etf.rpr;


import java.util.ArrayList;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GeografijaDAO geografijaDAO = GeografijaDAO.getInstance();

        String gradoviInfo = ispisiGradove();
        System.out.println(gradoviInfo);
        glavniGrad();
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

    public static void glavniGrad() {
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
}
