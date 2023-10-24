package ba.unsa.etf.rpr;
import java.util.ArrayList;
import java.util.List;

public class Banka {
    protected List<Korisnik> korisnici;
    protected List<Uposlenik> uposlenici;
    private long brojRacunaCounter;

    public Banka() {
        korisnici = new ArrayList<>();
        uposlenici = new ArrayList<>();
        brojRacunaCounter = 1;
    }

    public Korisnik kreirajNovogKorisnika(String ime, String prezime) {
        Korisnik korisnik = new Korisnik(ime, prezime);
        korisnici.add(korisnik);
        return korisnik;
    }

    public Uposlenik kreirajNovogUposlenika(String ime, String prezime) {
        Uposlenik uposlenik = new Uposlenik(ime, prezime);
        uposlenici.add(uposlenik);
        return uposlenik;
    }

    public Racun kreirajRacunZaKorisnika(Korisnik korisnik) {
        Racun racun = new Racun(brojRacunaCounter++, korisnik);
        korisnik.dodajRacun(racun);
        return racun;
    }
}
