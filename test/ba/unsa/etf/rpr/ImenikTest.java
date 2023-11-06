package ba.unsa.etf.rpr;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

class ImenikTest {
    private static Imenik imenik = new Imenik();
    @BeforeAll
    public static void setup() {
        imenik.dodaj("Amer", new FiksniBroj(Grad.SARAJEVO,"576-917"));
        imenik.dodaj("Mera", new FiksniBroj(Grad.SARAJEVO,"546-217"));
        imenik.dodaj("Rema", new MobilniBroj(61,"580-917"));
        imenik.dodaj("Eram", new MedunarodniBroj("+44","576123917"));
    }
    @Test
    public void testDodajIPronadiOsobu() {
        Imenik imenik = new Imenik();

        // Dodaj osobu u imenik
        FiksniBroj broj = new FiksniBroj(Grad.SARAJEVO, "123-456");
        imenik.dodaj("John Doe", broj);

        // Pronađi broj za osobu
        String pronadenBroj = imenik.dajBroj("John Doe");
        assertEquals("033/123-456", pronadenBroj);
    }
    @Test
    public void testDajNepostojecuOsobu() {
        Imenik imenik = new Imenik();

        try {
            // Pokušaj pristupiti osobi koja nije u imeniku
            String pronadenBroj = imenik.dajBroj("Stevan");
        } catch (Izuzetci.PersonNotFoundException e) {
            assertEquals("Nema podataka za ime Stevan", e.getMessage());
            System.out.println("Bacen ispravan izuzetak: "+e.getMessage());
        }
    }

    @Test
    public void testInvalidPhoneNumberException() {
        try {
            // Pokušaj dodati neispravan broj
            FiksniBroj broj = new FiksniBroj(Grad.SARAJEVO, null);
        } catch (Izuzetci.InvalidPhoneNumberException e) {
            assertEquals("Pozivni broj za fiksni telefon nije ok!", e.getMessage());
            System.out.println("Bacen ispravan izuzetak: "+ e.getMessage());
        }
    }
    @Test
    public void testIzGradaBrojevi() {
        try {
            Grad gradBrojevi = Grad.SARAJEVO;
            Set<TelefonskiBroj> brojeviIzGrada = imenik.izGradaBrojevi(gradBrojevi);
            System.out.println("Brojevi iz grada " + gradBrojevi + ":");
            for ( TelefonskiBroj t : brojeviIzGrada ) {
                System.out.println(t.ispisi());
            }
        } catch (Izuzetci.InvalidPhoneNumberException e) {
            fail("Bacen neispravan izuzetak: "+e.getMessage());
        }
    }
}