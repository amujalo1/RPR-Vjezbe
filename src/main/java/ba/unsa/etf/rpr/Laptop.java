package ba.unsa.etf.rpr;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Laptop {
    private String brend;
    private String model;
    private double cijena;
    private int ram, hdd, ssd;
    private String procesor;
    private String grafickaKartica;
    private double velicinaEkrana;

    public Laptop() {
    }
    public String getBrend(){
        return brend;
    }
    public void setBrend(String brend){
        this.brend = brend;
    }
    public String getModel(){
        return model;
    }
    public void setModel(String model){
        this.model = model;
    }
    public String getProcesor(){
        return procesor;
    }
    public void setProcesor(String procesor){
        this.procesor = procesor;
    }
    public String getGrafickaKartica(){
        return grafickaKartica;
    }
    public void setGrafickaKartica(String grafickaKartica){
        this.grafickaKartica = grafickaKartica;
    }
    public double getVelicinaEkrana(){
        return velicinaEkrana;
    }
    public void setVelicinaEkrana(double velicinaEkrana){
        this.velicinaEkrana = velicinaEkrana;
    }
    public double getCijena(){
        return cijena;
    }
    public void setCijena(double cijena){
        this.cijena = cijena;
    }
    public int getRam(){
        return ram;
    }
    public void setRam(int ram){
        this.ram = ram;
    }
    public int getHdd(){
        return hdd;
    }
    public void setHdd(int hdd){
        this.hdd = hdd;
    }
    public int getSsd(){
        return ssd;
    }
    public void setSsd(int ssd){
        this.ssd = ssd;
    }
}
