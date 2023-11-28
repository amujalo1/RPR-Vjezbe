package ba.unsa.etf.rpr;

public class InformacijeOStudentu extends LicneInformacije {
    private String godinaStudija, brojIndexa;
    public InformacijeOStudentu(String ime, String prezime, String godinaStudija, String brojIndexa){
        super(ime,prezime);
        this.godinaStudija = godinaStudija;
        this.brojIndexa = brojIndexa;
    }

    public String getGodinaStudija() {
        return godinaStudija;
    }

    public void setGodinaStudija(String godinaStudija) {
        this.godinaStudija = godinaStudija;
    }

    public String getBrojIndexa() {
        return brojIndexa;
    }

    public void setBrojIndexa(String brojIndexa) {
        this.brojIndexa = brojIndexa;
    }
    @Override
    public String predstavi() {
        return super.predstavi() + "\nGodina studija: " + godinaStudija + "\nBroj indexa: " + brojIndexa;
    }
}
