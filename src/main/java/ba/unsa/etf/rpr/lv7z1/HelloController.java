package ba.unsa.etf.rpr.lv7z1;

import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class HelloController {
    ArrayList<Korisnik> korisnici = new ArrayList<>();
    public TextField prezime;
    public TextField email;
    public TextField kime;
    public PasswordField lozinka;
    public TextField ime;
    public ListView listaKorisnika;

    public void prikaziKorisnika(MouseEvent mouseEvent) {
        int indeks = listaKorisnika.getSelectionModel().getSelectedIndex();
        if (indeks >= 0) {
            Korisnik odabrani = null;
            String odabranoKorisnickoIme = (String) listaKorisnika.getItems().get(indeks);
            for (Korisnik k : korisnici) {
                if(k.getKorisnickoIme().equals(odabranoKorisnickoIme))
                    odabrani = k;
            };

            assert odabrani != null;
            kime.setText(odabrani.getKorisnickoIme());
            ime.setText(odabrani.ime);
            prezime.setText(odabrani.prezime);
            email.setText(odabrani.email);
            lozinka.setText(odabrani.lozinka);
        }
    }

    private class Korisnik {
        String ime;
        String prezime;
        String email;
        String korisnickoIme;
        String lozinka;

        public Korisnik(String ime, String prezime, String email, String korisnickoIme, String lozinka) {
            this.ime = ime;
            this.prezime = prezime;
            this.email = email;
            this.korisnickoIme = korisnickoIme;
            this.lozinka = lozinka;
        }

        public String getKorisnickoIme() {
            return korisnickoIme;
        }
    }


    public void Dodaj(MouseEvent keyEvent) {
        Korisnik noviKorisnik = new Korisnik(ime.getText(), prezime.getText(), email.getText(), kime.getText(), lozinka.getText());
        listaKorisnika.getItems().add(noviKorisnik.getKorisnickoIme());
        korisnici.add(noviKorisnik);
        ime.clear();
        prezime.clear();
        email.clear();
        kime.clear();
        lozinka.clear();
    }

    public void Kraj(MouseEvent keyEvent) {
        System.exit(0);
    }
}
