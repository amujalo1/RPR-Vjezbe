package ba.unsa.etf.rpr;


public class Drzava {
    private String naziv;
    private String glavniGrad;

    public Drzava(String naziv, String glavniGrad) {
        this.naziv = naziv;
        this.glavniGrad = glavniGrad;
    }

    public String getGlavniGrad() {
        return glavniGrad;
    }

    public void setGlavniGrad(String glavniGrad) {
        this.glavniGrad = glavniGrad;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
