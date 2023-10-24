package ba.unsa.etf.rpr;
import java.util.Scanner;

public class ispis2Br {
    public static void main(String[] args) {
        Scanner ulaz = new Scanner(System.in);
        System.out.print("Unesi broj 1: ");
        int br1 = ulaz.nextInt();
        System.out.print("Unesi broj 2: ");
        int br2 = ulaz.nextInt();
        System.out.printf("broj 1: %d, broj 2: %d",br1,br2);
    }
}