package ba.unsa.etf.rpr;
import java.util.Scanner;
public class sumaCifara {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Unesite broj n: ");
        int n = scanner.nextInt();

        System.out.println("Brojevi između 1 i " + n + " koji su djeljivi sa sumom svojih cifara su:");
        for (int i = 1; i <= n; i++) {
            if (i % sumaCifara(i) == 0) {
                System.out.print(i + " ");
            }
        }
    }

    public static int sumaCifara(int broj) {
        int suma = 0;
        while (broj > 0) {
            suma += broj % 10;
            broj /= 10;
        }
        return suma;
    }
}