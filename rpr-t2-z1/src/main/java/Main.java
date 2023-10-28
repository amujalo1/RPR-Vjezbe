//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import ba.unsa.etf.rpr.Kalkulator;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Molim unesite tocno jedan broj kao argument.");
        } else {
            try {
                Kalkulator cal = new Kalkulator();
                double sinus = cal.Sin(Double.parseDouble(args[0]));
                long fact = cal.Fact((int)Double.parseDouble(args[1]));
                System.out.println("sin(" + Double.parseDouble(args[0]) + ") = " + sinus);
                System.out.println((int)Double.parseDouble(args[1]) + "! = " + fact);
            } catch (NumberFormatException var6) {
                System.out.println("Uneseni argument nije valjani broj.");
            }

        }
    }
}
