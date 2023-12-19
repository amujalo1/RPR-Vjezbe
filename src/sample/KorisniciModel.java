package sample;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KorisniciModel {
    private ObservableList<Korisnik> korisnici = FXCollections.observableArrayList();
    private ObjectProperty<Korisnik> trenutniKorisnik = new SimpleObjectProperty<>();

    public KorisniciModel() {
        napuni();
        // Postavi prvog korisnika kao trenutnog po defaultu
        if (!korisnici.isEmpty()) {
            trenutniKorisnik.set(korisnici.get(0));
        }
    }

    public ObservableList<Korisnik> getKorisnici() {
        return korisnici;
    }

    public ObjectProperty<Korisnik> getTrenutniKorisnik() {
        return trenutniKorisnik;
    }

    public void setTrenutniKorisnik(Korisnik korisnik) {
        trenutniKorisnik.set(korisnik);
    }

    public void dodajNovogKorisnika() {
        Korisnik noviKorisnik = new Korisnik("", "", "", "", "");
        korisnici.add(noviKorisnik);
        setTrenutniKorisnik(noviKorisnik);
    }

    private void napuni() {
        // Popuni listu sa podacima
        korisnici.add(new Korisnik("Ime1", "Prezime1", "email1@example.com", "korisnik1", "lozinka1"));
        korisnici.add(new Korisnik("Ime2", "Prezime2", "email2@example.com", "korisnik2", "lozinka2"));
        // Dodajte više korisnika po potrebi
    }
}
