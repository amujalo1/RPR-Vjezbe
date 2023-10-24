package ba.unsa.etf.rpr;

import java.util.Collection;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class StatistikaBrojeva {
    public static void main(String[] args) {
        List<Double> nizLista = new ArrayList<>();
        Scanner skaner = new Scanner(System.in);
        do {
            System.out.println("Unesite broj (ili 'stop' za završetak unosa): ");
            String unos = skaner.nextLine();
            if (unos.equalsIgnoreCase("stop")){
                if (nizLista.isEmpty()) {
                    System.out.println("Niste unijeli nijedan broj.");
                } else {
                    double min = Collections.min(nizLista);
                    double max = Collections.max(nizLista);
                    double sum = 0;
                    for (double num : nizLista){
                        sum += num;
                    }
                    double avgVrj = sum / nizLista.size();
                    double sumPowDiff = 0;
                    for (double num : nizLista){
                        sumPowDiff += Math.pow(num - avgVrj,2);
                    }
                    double standardDeviation = Math.sqrt(sumPowDiff / nizLista.size());
                    System.out.println("Minimum: " + min);
                    System.out.println("Maksimum: " + max);
                    System.out.println("Srednja vrijednost: " + avgVrj);
                    System.out.println("Standardna devijacija: " + standardDeviation);
                }
                break;
            } else {
                try{
                    nizLista.add(Double.parseDouble(unos));
                } catch (NumberFormatException e){
                    System.out.println("Niste unijeli ispravan broj. Pokušajte ponovno.");
                }
            }
        } while(true);
    }
}