package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class KolekcijaPoruka {
    private List<String> poruke;
    public KolekcijaPoruka(List<Predstavljiv> predstavljivi) {
        this.poruke = new ArrayList<>();
        for (Predstavljiv predstavljiv : predstavljivi) {
            poruke.add(predstavljiv.predstavi());
        }
    }
    public List<String> getPoruke() {
        return poruke;
    }
}
