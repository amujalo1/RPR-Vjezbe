package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.*;
import org.junit.Test;

import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ImenikTest {
    private static Imenik imenik = new Imenik();
    @BeforeAll
    public static void setup() {
        imenik.dodaj("Amer", new FiksniBroj(Grad.SARAJEVO,"576-917"));
        imenik.dodaj("Mera", new FiksniBroj(Grad.SARAJEVO,"546-217"));
        imenik.dodaj("Rema", new MobilniBroj(61,"580-917"));
        imenik.dodaj("Eram", new MedunarodniBroj("+44","576123917"));
    }
    @Test
    public void testMockExternal() {
        Imenik i =Mockito.mock(Imenik.class);
        Mockito.when(i.dajBroj("Mera")).thenReturn("Nema broja!");

        String str = i.dajBroj("Mera");
        assertEquals("Nema broja!",str);
    }

    @Test
    public void testMockInternal() {
        HashMap<String, TelefonskiBroj> mapa = Mockito.mock(HashMap.class);
        Mockito.when(mapa.get("Amer")).thenReturn(new FiksniBroj(Grad.BRCKO,"576-917"));
        imenik.setImenik(mapa);

        String str = imenik.dajBroj("Amer");
        assertNotEquals(str,"033/576-917");
        assertEquals(str,"049/576-917");
    }
}