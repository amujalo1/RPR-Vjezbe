package ba.unsa.etf.rpr.lv10;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GeografijaDAOTest {

    // Test instance for GeografijaDAO
    private GeografijaDAO geografijaDAO;

    @BeforeEach
    void setUp() {
        // Recreate GeografijaDAO instance before each test
        geografijaDAO = GeografijaDAO.getInstance();
    }

    // Tests considering order of execution and current state of the database

    @Test
    @Order(1)
    void testDodajDrzavu() {
        geografijaDAO.dodajDrzavu(new Drzava(4, "Bosna i Hercegovina", "Sarajevo"));
        ArrayList<String> drzave = geografijaDAO.drzaveNazivi();
        assertTrue(drzave.contains("Bosna i Hercegovina"));
    }

    @Test
    @Order(2)
    void testDodajGrad() {
        geografijaDAO.dodajGrad(new Grad(1, "Sarajevo", 500000, "Bosna i Hercegovina"));
        ArrayList<String> gradovi = geografijaDAO.gradoviNazivi();
        assertTrue(gradovi.contains("Sarajevo"));
    }

    @Test
    @Order(3)
    void testIzmijeniGrad() {
        geografijaDAO.izmijeniGrad(new Grad(1, "Sarajevo", 600000, "Bosna i Hercegovina"));
        ArrayList<Grad> gradovi = geografijaDAO.gradovi();
        assertEquals(600000, gradovi.get(0).getBrojStanovnika());
    }

    @Test
    @Order(4)
    void testObrisiGrad() {
        geografijaDAO.obrisiGrad(new Grad(1, "Sarajevo", 600000, "Bosna i Hercegovina"));
        ArrayList<String> gradovi = geografijaDAO.gradoviNazivi();
        assertFalse(gradovi.contains("Sarajevo"));
    }
}
