package ba.unsa.etf.rpr;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.management.BadAttributeValueExpException;
import java.io.File;
import java.util.ArrayList;
public class testLaptopDao {
    @Test
    public void testDodajLaptopUFile() {
        File file = new File("laptopi.txt");
        LaptopDao dao = new LaptopDaoSerializableFile(file);

        Laptop laptop1 = new Laptop();
        laptop1.setProcesor("Intel i5-G11");
        laptop1.setBrend("Dell");
        laptop1.setModel("longitude 5420");
        laptop1.setCijena(1500.0);
        laptop1.setRam(16);
        laptop1.setHdd(0);
        laptop1.setSsd(516);
        laptop1.setGrafickaKartica("Intel xe");
        laptop1.setVelicinaEkrana(14);

        dao.dodajLaptopUFile(laptop1);

        Laptop retrievedLaptop = null;
        try {
            retrievedLaptop = dao.getLaptop("Intel i5-G11");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Dostavljeni laptop: " + retrievedLaptop.getModel());
    }
}
