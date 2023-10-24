package ba.unsa.etf.rpr;
import java.util.ArrayList;
import java.util.List;

public class Korisnik extends Osoba {
    private List<Racun> racuni;

    public Korisnik(String ime, String prezime) {
        super(ime, prezime);
        racuni = new ArrayList<>();
    }

    public void dodajRacun(Racun racun) {
        racuni.add(racun);
    }
}
