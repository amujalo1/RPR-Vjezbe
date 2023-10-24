package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StatistikaBrojeva {
    public StatistikaBrojeva() {
    }

    public static void main(String[] args) {
        List<Double> nizLista = new ArrayList();
        Scanner skaner = new Scanner(System.in);

        while(true) {
            System.out.println("Unesite broj (ili 'stop' za završetak unosa): ");
            String unos = skaner.nextLine();
            if (unos.equalsIgnoreCase("stop")) {
                if (nizLista.isEmpty()) {
                    System.out.println("Niste unijeli nijedan broj.");
                } else {
                    double min = (Double)Collections.min(nizLista);
                    double max = (Double)Collections.max(nizLista);
                    double sum = 0.0;

                    double num1;
                    for(Iterator var = nizLista.iterator(); var.hasNext(); sum += num1) {
                        num1 = (Double)var.next();
                    }

                    double avgVrj = sum / (double)nizLista.size();

                    double sumPowDiff = 0.0;
                    double num2;
                    for(Iterator var = nizLista.iterator(); var.hasNext(); sumPowDiff += Math.pow(num2 - avgVrj, 2.0)) {
                        num2 = (Double)var.next();
                    }

                    double standardDeviation = Math.sqrt(sumPowDiff / (double)nizLista.size());
                    System.out.println("Minimum: " + min);
                    System.out.println("Maksimum: " + max);
                    System.out.println("Srednja vrijednost: " + avgVrj);
                    System.out.println("Standardna devijacija: " + standardDeviation);
                }
                return;
            }
            try {
                nizLista.add(Double.parseDouble(unos));
            } catch (NumberFormatException var17) {
                System.out.println("Niste unijeli ispravan broj. Pokušajte ponovno.");
            }
        }
    }
}
