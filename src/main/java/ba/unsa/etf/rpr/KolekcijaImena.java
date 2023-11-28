package ba.unsa.etf.rpr;


import java.util.List;

public class KolekcijaImena {
    private List<String> imePrezime;
    public KolekcijaImena(List<String> imePrezime) {
        this.imePrezime = imePrezime;
    }
    public String getNajduzeIme(){
        String max = new String();
        for(String str : imePrezime){
            if(max.length() < str.length())
                max = str;
        }
        return max;
    }
}