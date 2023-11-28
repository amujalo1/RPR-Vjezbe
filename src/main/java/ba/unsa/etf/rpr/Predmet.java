package ba.unsa.etf.rpr;

public class Predmet implements Predstavljiv{
    private String naziv,  opisPredmeta;
    public Predmet(String naziv, String opisPredmeta){
        this.naziv = naziv;
        this.opisPredmeta = opisPredmeta;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpisPredmeta() {
        return opisPredmeta;
    }

    public void setOpisPredmeta(String opisPredmeta) {
        this.opisPredmeta = opisPredmeta;
    }
    @Override
    public String predstavi(){
        return "Predmet: " + naziv + "\nOpis: " + opisPredmeta;
    }
}
