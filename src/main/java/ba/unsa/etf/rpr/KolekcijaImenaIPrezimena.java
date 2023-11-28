package ba.unsa.etf.rpr;
import java.util.List;
public class KolekcijaImenaIPrezimena {
    List<String>  imena;
    List<String> prezimena;
    public KolekcijaImenaIPrezimena(List<String> imena, List<String> prezimena) {
        this.imena = imena;
        this.prezimena = prezimena;
    }
    public int getInedxNajduzegPara(){
        int najduzeIme = 0, indeks = 0;
        for(int i=0; i<imena.size();i++){
            String imePrezime = getImePrezime(i);
            if(imePrezime.length()>najduzeIme){
                najduzeIme = imePrezime.length();
                indeks = i;
            }
        }
        return indeks;
    }
    public String getImePrezime(int i) {
        return imena.get(i) + " " + prezimena.get(i);
    }
}
