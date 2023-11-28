package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class Predmet implements Predstavljiv{
    private String naziv,  opisPredmeta;
    private List<Ocjena> ocjene;
    public Predmet(String naziv, String opisPredmeta){
        this.naziv = naziv;
        this.opisPredmeta = opisPredmeta;
        this.ocjene = new ArrayList<>();
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
    public List<Ocjena> getOcjene() {
        return ocjene;
    }
    @Override
    public String predstavi(){
        return "Predmet: " + naziv + "\nOpis: " + opisPredmeta;
    }

    public Ocjena ocijeni(int ocjena) {
        Ocjena novaOcjena = new Ocjena(null, ocjena); // null jer predmet ocjenjuju svi, ne samo studenti
        ocjene.add(novaOcjena);
        return novaOcjena;
    }
}
