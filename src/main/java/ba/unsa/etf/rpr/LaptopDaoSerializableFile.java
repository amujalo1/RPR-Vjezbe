package ba.unsa.etf.rpr;
import javax.management.BadAttributeValueExpException;

import java.io.*;
import java.util.ArrayList;

public class LaptopDaoSerializableFile implements LaptopDao{
    private File file;
    private ArrayList<Laptop> laptopi;
    public LaptopDaoSerializableFile(File file){
        this.file=file;
        laptopi = vratiPodatkeIzDatoteke();
    }
    @Override
    public void dodajLaptopUFile(Laptop laptop){
        //napuniListu(vratiPodatkeIzDatoteke());
        //laptopi.add(laptop);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            laptopi.add(laptop);
            oos.writeObject(laptopi);
        } catch (IOException e) {
            System.out.println("Greska: " + e);
        }
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        this.laptopi.add(laptop);
    }
    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi = laptopi;
    }

    @Override
    public Laptop getLaptop(String procesor) throws Exception {
        for (Laptop laptop : laptopi) {
            if (laptop.getProcesor().equals(procesor)) {
                return laptop;
            }
        }
        throw new Exception("Nema laptopa s traženim procesorom.");
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        //if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                return (ArrayList<Laptop>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Geska: " + e);
            }
        //}
        return new ArrayList<>();
    }

}
