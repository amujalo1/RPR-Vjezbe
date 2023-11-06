package ba.unsa.etf.rpr;

// Enum za pozivne brojeve gradova
public enum Grad {
    SARAJEVO("033"), TUZLA("035"), ZENICA("032"), BRCKO("049");

    private String pozitivniBroj;

    Grad(String pozitivniBroj) {
        this.pozitivniBroj = pozitivniBroj;
    }

    public static Grad izPozitivnog(String pozivni) {
        for (Grad g : Grad.values()) {
            if (g.getPozivniBroj().equals(pozivni)) {
                return g;
            }
        }
        return null;
    }
    public String getPozivniBroj() { return pozitivniBroj; }
    }