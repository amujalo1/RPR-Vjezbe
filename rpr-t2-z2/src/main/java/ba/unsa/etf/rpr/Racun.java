package ba.unsa.etf.rpr;

public class Racun {
    private long brojRacuna;
    private Osoba korisnikRacuna;
    private boolean odobrenjePrekoracenja;
    private double stanjeRacuna;

    public Racun(long brojRacuna, Osoba korisnikRacuna) {
        this.brojRacuna = brojRacuna;
        this.korisnikRacuna = korisnikRacuna;
        this.odobrenjePrekoracenja = false;
        this.stanjeRacuna = 0.0;
    }

    public boolean provjeriOdobrenjePrekoracenja(double iznos) {
        return odobrenjePrekoracenja || stanjeRacuna >= iznos;
    }

    public boolean izvrsiUplatu(double iznos) {
        if (iznos >= 0) {
            stanjeRacuna += iznos;
            return true;
        }
        return false;
    }

    public boolean izvrsiIsplatu(double iznos) {
        if (provjeriOdobrenjePrekoracenja(iznos) && iznos >= 0) {
            stanjeRacuna -= iznos;
            return true;
        }
        return false;
    }

    public void odobriPrekoracenje(double iznos) {
        if (iznos >= 0) {
            odobrenjePrekoracenja = true;
        }
    }
}

