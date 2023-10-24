import ba.unsa.etf.rpr.Kalkulator;
public class Main {
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("Molim unesite točno jedan broj kao argument.");
            return;
        }
        try {
            Kalkulator cal = new Kalkulator();
            double sinus = cal.Sin(Double.parseDouble(args[0]));
            long fact = cal.Fact((int)Double.parseDouble(args[0]));
            System.out.println("sin("+Double.parseDouble(args[0])+") = " + sinus);
            System.out.println((int)Double.parseDouble(args[0])+"! = " + fact);
        } catch (NumberFormatException e){
            System.out.println("Uneseni argument nije valjani broj.");
        }
    }
}
