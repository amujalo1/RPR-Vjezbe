package ba.unsa.etf.rpr;
public class Osoba {
    protected String ime;
    protected String prezime;

    public Osoba(String ime, String prezime){
        this.ime = ime;
        this.prezime = prezime;
    }
    @Override
    public String toString(){
        return ime+" "+prezime;
    }
}