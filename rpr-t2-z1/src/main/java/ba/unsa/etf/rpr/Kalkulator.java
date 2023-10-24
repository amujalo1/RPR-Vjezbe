
package ba.unsa.etf.rpr;

public class Kalkulator {
    public Kalkulator() {
    }

    public double Sin(double num) {
        return Math.sin(num);
    }

    public long Fact(int num) {
        if (num < 0) {
            return -1L;
        } else if (num == 0) {
            return 1L;
        } else {
            long faktorijel = 1L;

            for(int i = 1; i < num; ++i) {
                faktorijel *= (long)i;
            }

            return faktorijel;
        }
    }
}
