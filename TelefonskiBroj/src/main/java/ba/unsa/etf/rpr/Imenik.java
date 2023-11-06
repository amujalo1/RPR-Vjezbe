package ba.unsa.etf.rpr;

import java.util.*;

public class Imenik {
    private HashMap<String, TelefonskiBroj> imenik = new HashMap<>();

    public Map<String, TelefonskiBroj> getImenik() {
        return imenik;
    }

    public void setImenik(Map<String, TelefonskiBroj> imenik) {
        this.imenik = (HashMap<String, TelefonskiBroj>) imenik;
    }

    public void dodaj(String ime, TelefonskiBroj broj) {
        imenik.put(ime,broj);
    }
    public String dajBroj(String ime) {
        TelefonskiBroj broj = imenik.get(ime);
        if (broj != null) {
            return broj.ispisi();
        } else {
            throw new Izuzetci.PersonNotFoundException("Nema podataka za ime " + ime);
        }
    }
    public String dajIme(TelefonskiBroj broj) {
        for (Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()) {
            if (entry.getValue().hashCode() == broj.hashCode()) {
                return entry.getKey();
            }
        }
        throw new Izuzetci.PersonNotFoundException("Nema podataka za broj " + broj.ispisi());
    }

    public String naSlovo(char s) {
        StringBuilder result = new StringBuilder();
        int counter = 1;
        for (Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()) {
            if (Character.toLowerCase(entry.getKey().charAt(0)) == Character.toLowerCase(s)) {
                result.append(counter).append(". ").append(entry.getKey()).append(" - ").append(entry.getValue().ispisi()).append("\n");

            }
            counter++;
        }
        return result.toString();
    }
    public Set<String> izGrada(Grad g) {
        TreeSet<String> sortedNames = new TreeSet<>();
        for (Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()) {
            if (entry.getValue() instanceof FiksniBroj) {
                FiksniBroj fiksniBroj = (FiksniBroj) entry.getValue();
                if (fiksniBroj.getGrad() == g) {
                    sortedNames.add(entry.getKey());
                }
            }
        }
        return sortedNames;
    }

    public Set<TelefonskiBroj> izGradaBrojevi(Grad g) {
        TreeSet<TelefonskiBroj> sortedNumbers = new TreeSet<>(Comparator.comparing(TelefonskiBroj::ispisi));
        for (Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()) {
            if (entry.getValue() instanceof FiksniBroj) {
                FiksniBroj fiksniBroj = (FiksniBroj) entry.getValue();
                if (fiksniBroj.getGrad() == g) {
                    sortedNumbers.add(fiksniBroj);
                }
            }
        }
        return sortedNumbers;
    }
}
