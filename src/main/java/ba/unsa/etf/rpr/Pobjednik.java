package ba.unsa.etf.rpr;

public class Pobjednik {
    private String ime, prezime;
    private int brojZnakova;
    public Pobjednik(KolekcijaImena kolekcijaImena){
        String najduzeIme = kolekcijaImena.getNajduzeIme();
        String[] dijelovi = najduzeIme.split(" ");
        this.ime = dijelovi[0];
        this.prezime = dijelovi[1];
        this.brojZnakova = najduzeIme.length();
    }
    public Pobjednik(KolekcijaImenaIPrezimena kolekcijaImenaIPrezimena){
        String najduzeIme = kolekcijaImenaIPrezimena.getImePrezime(kolekcijaImenaIPrezimena.getInedxNajduzegPara());
        String[] dijelovi = najduzeIme.split(" ");
        this.ime = dijelovi[0];
        this.prezime = dijelovi[1];
        this.brojZnakova = najduzeIme.length();
    }
    @Override
    public String toString(){
        return "Pobjednik{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", brojZnakova=" + brojZnakova +
                '}';
    }
}
