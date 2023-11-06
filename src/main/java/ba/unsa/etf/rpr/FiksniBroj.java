package ba.unsa.etf.rpr;

import java.util.Objects;

public class FiksniBroj extends TelefonskiBroj {
    private Grad grad;
    private String broj;

    public FiksniBroj(Grad grad, String broj) {
        if(null == grad || broj == null) {
            throw new Izuzetci.InvalidPhoneNumberException("Pozivni broj za fiksni telefon nije ok!");
        }
        this.grad = grad;
        this.broj = broj;
    }

    @Override
    public String ispisi() {
        if(grad == null || broj == null)
            return null;
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

    public Grad getGrad() {
        return grad;
    }
}
