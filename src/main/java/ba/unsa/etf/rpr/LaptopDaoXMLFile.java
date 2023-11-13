package ba.unsa.etf.rpr;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

import javax.management.BadAttributeValueExpException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class LaptopDaoXMLFile implements LaptopDao {
    private File file;
    private ArrayList<Laptop> laptopi;
    public LaptopDaoXMLFile(File file) {
        this.file = file;
        laptopi = vratiPodatkeIzDatoteke();
    }
    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        try{
            XmlMapper xmlMapper = new XmlMapper();
            laptopi.add(laptop);
            String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(laptopi);
            FileOutputStream fo = new FileOutputStream(file);
            fo.write(xml.getBytes());
            fo.close();
        } catch (IOException e){
            System.out.println("Greska: " + e);
        }
    }

    @Override
    public Laptop getLaptop(String procesor) throws Exception{
        for(Laptop laptop : laptopi){
            if(laptop.getProcesor().equals(procesor))
                    return laptop;
        }
        throw new BadAttributeValueExpException("Nema laptopa s traženim procesorom.");
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi = laptopi;
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        if(file.exists()) {
            try {
                XmlMapper xmlMapper = new XmlMapper();
                return xmlMapper.readValue(file,xmlMapper.getTypeFactory().constructCollectionType(ArrayList.class,Laptop.class));
            } catch (IOException e) {
                System.out.println("Greska: " + e);
            }
        }
        return new ArrayList<>();
    }
}
