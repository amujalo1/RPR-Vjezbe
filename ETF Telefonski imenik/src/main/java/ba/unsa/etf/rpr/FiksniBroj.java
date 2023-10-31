package ba.unsa.etf.rpr;

import java.util.Objects;

public class FiksniBroj extends TelefonskiBroj {
    Grad grad;
    private String broj;

    public FiksniBroj(Grad grad, String broj) {
        this.grad = grad;
        this.broj = broj;
    }

    @Override
    public String ispisi() {
        String pozivniBroj = switch (grad) {
            case SARAJEVO -> "033";
            case TUZLA -> "035";
            case ZENICA -> "032";
            case BRCKO -> "049";
        };
        return pozivniBroj + "/" + broj;
    }
    @Override
    public int hashCode() {
        return Objects.hash(grad, broj);
    }
}
