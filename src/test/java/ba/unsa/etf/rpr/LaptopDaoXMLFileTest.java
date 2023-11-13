package ba.unsa.etf.rpr;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
class LaptopDaoXMLFileTest {
    @Test
    public void testMock() throws Exception {
        Laptop mockLaptop = new Laptop();
        mockLaptop.setBrend("Microsoft");
        mockLaptop.setSsd(1024);
        mockLaptop.setRam(16);
        mockLaptop.setHdd(0);
        mockLaptop.setVelicinaEkrana(14);
        mockLaptop.setCijena(1500);
        mockLaptop.setModel("surface pro");
        mockLaptop.setGrafickaKartica("Intel Xe Graphics");
        mockLaptop.setProcesor("Intel i5G");
        LaptopDaoXMLFile dao = Mockito.mock(LaptopDaoXMLFile.class);
        ArrayList<Laptop> laptops = new ArrayList<>();
        laptops.add(mockLaptop);
        Mockito.when(dao.vratiPodatkeIzDatoteke()).thenReturn(laptops);
        assertEquals("Microsoft",dao.vratiPodatkeIzDatoteke().get(0).getBrend());
        assertEquals("Intel i5G",dao.vratiPodatkeIzDatoteke().get(0).getProcesor());
        assertEquals(1024,dao.vratiPodatkeIzDatoteke().get(0).getSsd());
    }
    @Test
    public void testDodajLaptopUFile() {
        File serijskiFile = new File("laptopi.xml");
        if(!serijskiFile.exists()){
            LaptopDaoXMLFile dao = new LaptopDaoXMLFile(serijskiFile);
            Laptop laptop1 = new Laptop(), laptop2= new Laptop(), laptop3 = new Laptop(), laptop4 = new Laptop(), laptop5 = new Laptop();
            laptop1.setBrend("Apple");
            laptop2.setBrend("Lenovo");
            laptop3.setBrend("Dell");
            laptop4.setBrend("HP");
            laptop5.setBrend("Asus");
            laptop1.setModel("MackBook Pro");
            laptop2.setModel("ThinkPad X1");
            laptop3.setModel("Longitude 5420");
            laptop4.setModel("EliteBook");
            laptop5.setModel("F515");
            laptop1.setCijena(3000);
            laptop2.setCijena(1700);
            laptop3.setCijena(1400);
            laptop4.setCijena(1500);
            laptop5.setCijena(1200);
            laptop1.setHdd(0);
            laptop2.setHdd(2000);
            laptop3.setHdd(0);
            laptop4.setHdd(1562);
            laptop5.setHdd(512);
            laptop1.setProcesor("M2");
            laptop2.setProcesor("Intel i7H");
            laptop3.setProcesor("Intel i5G");
            laptop4.setProcesor("Intel i7G");
            laptop5.setProcesor("Rayzen 3");
            laptop1.setRam(32);
            laptop2.setRam(64);
            laptop3.setRam(16);
            laptop4.setRam(32);
            laptop5.setRam(8);
            laptop1.setGrafickaKartica("Intel HD Graphics 530");
            laptop2.setGrafickaKartica("Nvidea RTX 3500ti");
            laptop3.setGrafickaKartica("Intel Xe Graphics");
            laptop4.setGrafickaKartica("Intel HD Graphics 530");
            laptop5.setGrafickaKartica("Intel Xe Graphics");
            laptop1.setVelicinaEkrana(15.7);
            laptop2.setVelicinaEkrana(17.5);
            laptop3.setVelicinaEkrana(14);
            laptop4.setVelicinaEkrana(15.5);
            laptop5.setVelicinaEkrana(16.3);
            laptop1.setSsd(2000);
            laptop2.setSsd(1000);
            laptop3.setSsd(256);
            laptop4.setSsd(556);
            laptop5.setSsd(0);
            dao.dodajLaptopUFile(laptop1);
            dao.dodajLaptopUFile(laptop2);
            dao.dodajLaptopUFile(laptop3);
            dao.dodajLaptopUFile(laptop4);
            dao.dodajLaptopUFile(laptop5);
        }
    }
    @Test
    public void testVratiPodatkeIzDatoteke() throws Exception {
        File serijskiFile = new File("laptopi.xml");
        LaptopDaoXMLFile dao = new LaptopDaoXMLFile(serijskiFile);
        for (Laptop laptop : dao.vratiPodatkeIzDatoteke()) {
            System.out.println(laptop);
        }
    }
    @Test
    public void testGetLaptop() throws Exception {
        File serijskiFile = new File("laptopi.xml");
        if(serijskiFile.exists()){
            LaptopDaoXMLFile dao = new LaptopDaoXMLFile(serijskiFile);
            Laptop trazeni = dao.getLaptop("Intel i5G");
            System.out.println(trazeni.getBrend());
            assertEquals(dao.getLaptop("Intel i5G"), trazeni);
        }
    }
}