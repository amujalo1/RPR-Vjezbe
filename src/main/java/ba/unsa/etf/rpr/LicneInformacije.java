package ba.unsa.etf.rpr;


public class LicneInformacije implements Predstavljiv {
    protected String ime;
    protected String prezime;
    public LicneInformacije(String ime, String prezime){
        this.ime = ime;
        this.prezime = prezime;
    }
    LicneInformacije(){}
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    @Override
    public String predstavi(){
        return "Osoba: " + ime + " " + prezime;
    }
}