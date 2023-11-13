package ba.unsa.etf.rpr;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import javax.management.BadAttributeValueExpException;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
public class LaptopDaoJSONFile implements LaptopDao  {
    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoJSONFile(File file) {
        this.file = file;
        laptopi = vratiPodatkeIzDatoteke();
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        //napuniListu(vratiPodatkeIzDatoteke());
        //laptopi.add(laptop);
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            laptopi.add(laptop);
            mapper.writeValue(file, laptopi);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        this.laptopi.add(laptop);
    }

    @Override
    public Laptop getLaptop(String procesor) throws Exception {
        for (Laptop laptop : laptopi) {
            if (laptop.getProcesor().equals(procesor)) {
                return laptop;
            }
        }
        throw new BadAttributeValueExpException("Nema laptopa s traženim procesorom.");
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi = laptopi;
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        //if (file.exists()) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(ArrayList.class, Laptop.class));
        } catch (IOException e) {
            System.out.println("Geska: " + e);
        }
        //}
        return new ArrayList<>();
    }
}