package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class InformacijeONastavniku extends LicneInformacije{
    private String titula;
    private List<Ocjena> ocjene;

    public InformacijeONastavniku(String ime, String prezime, String titula){
        super(ime,prezime);
        this.titula=titula;
        this.ocjene = new ArrayList<>();
    }

    public String getTitula() {
        return titula;
    }

    public void setTitula(String titula) {
        this.titula = titula;
    }
    public List<Ocjena> getOcjene() {
        return ocjene;
    }
    @Override
    public String predstavi(){
        return super.predstavi() + "\nTitula: " + titula;
    }
    public Ocjena ocijeni(LicneInformacije student,int ocjena) {
        Ocjena novaOcjena = new Ocjena(student, ocjena);
        ocjene.add(novaOcjena);
        return novaOcjena;
    }
}
