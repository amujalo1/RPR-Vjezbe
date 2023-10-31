import ba.unsa.etf.rpr.*;

import java.util.Scanner;
import java.util.*;
class ImenikException extends  Exception {
    public ImenikException(String error) {
        super(error);
    }
}
public class Program {
    public static void main(String[] args) {
        Imenik imenik = new Imenik();
        Scanner ulaz = new Scanner(System.in);

        while(true){
            System.out.println("Odaberite akciju:");
            System.out.println("1. Dodaj osobu u imenik");
            System.out.println("2. Pronađi broj po imenu");
            System.out.println("3. Pronađi ime po broju");
            System.out.println("4. Ispis imena koje počinju s određenim slovom");
            System.out.println("5. Ispis imena iz određenog grada");
            System.out.println("6. Ispis brojeva iz određenog grada");
            System.out.println("0. Izlaz");

            int odabir = ulaz.nextInt();
            ulaz.nextLine();

            switch (odabir) {
                case 1 :
                    try {
                        System.out.println("Unesite ime osobe:");
                        String ime = ulaz.nextLine();
                        System.out.println("Odaberite vrstu broja (1 - Fiksni, 2 - Mobilni, 3 - Međunarodni):");
                        int vrstaBroja = ulaz.nextInt();
                        ulaz.nextLine();
                        if (vrstaBroja == 1) {
                            System.out.println("Unesite grad (SARAJEVO, TUZLA, ZENICA, BRCKO):");
                            Grad grad = Grad.valueOf(ulaz.nextLine().toUpperCase());
                            System.out.println("Unesite broj (npr. 123-456):");
                            String broj = ulaz.nextLine();
                            imenik.dodaj(ime, new FiksniBroj(grad, broj));
                        } else if (vrstaBroja == 2) {
                            System.out.println("Unesite mobilnu mrežu (60-67):");
                            int mobilnaMreza = ulaz.nextInt();
                            ulaz.nextLine();
                            System.out.println("Unesite broj (npr. 987-654):");
                            String broj = ulaz.nextLine();
                            imenik.dodaj(ime, new MobilniBroj(mobilnaMreza, broj));
                        } else if (vrstaBroja == 3) {
                            System.out.println("Unesite državni pozivni broj (npr. +387):");
                            String drzava = ulaz.nextLine();
                            System.out.println("Unesite broj (npr. 123-789):");
                            String broj = ulaz.nextLine();
                            imenik.dodaj(ime, new MedunarodniBroj(drzava, broj));
                        } else {
                            System.out.println("Pogrešan unos vrste broja.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Greška prilikom unosa: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Unesite ime osobe za pretragu:");
                    String imePretrage = ulaz.nextLine();
                    String broj = imenik.dajBroj(imePretrage);
                    System.out.println("Telefonski broj za " + imePretrage + ": " + broj);
                    break;
                case 3:
                    System.out.println("Unesite broj za pretragu:");
                    String brojPretrage = ulaz.nextLine();
                    String ime = imenik.dajIme(new MedunarodniBroj("+387", brojPretrage));
                    System.out.println("Osoba s brojem " + brojPretrage + " je: " + ime);
                    break;
                case 4:
                    System.out.println("Unesite slovo za pretragu:");
                    char slovo = ulaz.nextLine().charAt(0);
                    String rezultat = imenik.naSlovo(slovo);
                    System.out.println("Osobe koje počinju s '" + slovo + "':\n" + rezultat);
                case 5:
                    System.out.println("Unesite grad za pretragu (SARAJEVO, TUZLA, ZENICA, BRCKO):");
                    Grad grad = Grad.valueOf(ulaz.nextLine().toUpperCase());
                    Set<String> imenaIzGrada = imenik.izGrada(grad);
                    System.out.println("Osobe iz grada " + grad + ":\n" + imenaIzGrada);
                    break;
                case 6:
                    System.out.println("Unesite grad za pretragu (SARAJEVO, TUZLA, ZENICA, BRCKO):");
                    Grad gradBrojevi = Grad.valueOf(ulaz.nextLine().toUpperCase());
                    Set<TelefonskiBroj> brojeviIzGrada = imenik.izGradaBrojevi(gradBrojevi);
                    System.out.println("Brojevi iz grada " + gradBrojevi + ":\n" + brojeviIzGrada);
                    break;
                case 0:
                    System.out.println("Izlaz iz programa.");
                    ulaz.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nepostojeća opcija.");
            }
        }
    }
}
