package sample;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KorisniciModelTest {

    @Test
    void testDodajNovogKorisnika() {
        KorisniciModel model = new KorisniciModel();
        int initialSize = model.getKorisnici().size();

        model.dodajNovogKorisnika();

        assertEquals(initialSize + 1, model.getKorisnici().size());
    }

    @Test
    void testSetAndGetTrenutniKorisnik() {
        KorisniciModel model = new KorisniciModel();
        Korisnik korisnik = new Korisnik("","","","",""); // Assuming you have a default constructor in Korisnik

        model.setTrenutniKorisnik(korisnik);
        assertEquals(korisnik,model.getTrenutniKorisnik().getValue());
    }

    @Test
    void testUpdateKorisnikInfo() {
        KorisniciModel model = new KorisniciModel();
        Korisnik korisnik = new Korisnik("","","","","");
        model.setTrenutniKorisnik(korisnik);

        String novoIme = "NovoIme";
        korisnik.setIme(novoIme);

        assertEquals(novoIme, korisnik.getIme());
    }
}