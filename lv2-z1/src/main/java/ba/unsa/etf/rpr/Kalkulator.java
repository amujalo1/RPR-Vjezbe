package ba.unsa.etf.rpr;

public class Kalkulator {
    public double Sin(double num){
        return Math.sin(num);
    }
    public long Fact(int num){
        if(num < 0)
            return -1;
        else if (num == 0)
            return 1;
        else {
            long faktorijel = 1;
            for(int i = 1; i< num; i++)
                faktorijel*=i;
            return faktorijel;
        }
    }
}