package ba.unsa.etf.rpr;

import java.util.ArrayList;

public interface LaptopDao {
    void dodajLaptopUListu(Laptop laptop);
    void dodajLaptopUFile(Laptop laptop);
    Laptop getLaptop(String procesor) throws Exception;
    void napuniListu(ArrayList<Laptop> laptopi);
    ArrayList<Laptop> vratiPodatkeIzDatoteke();
}
