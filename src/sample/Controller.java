package sample;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.beans.binding.Bindings;


public class Controller {
    @FXML
    private ListView<Korisnik> listaKorisnika;

    @FXML
    private Button dodajButton;
    @FXML
    private TextField ime;
    @FXML
    private TextField prezime;
    @FXML
    private TextField email;
    @FXML
    private TextField kime;
    @FXML
    private PasswordField lozinka;

    private final KorisniciModel model = new KorisniciModel();

    @FXML
    public void initialize() {
        // Poveži listu korisnika s modelom
        listaKorisnika.setItems(model.getKorisnici());
        // Listener za promjenu selektiranog korisnika
        model.getTrenutniKorisnik().addListener((obs,oldKorisnik, newKorisnik)->{
            if(oldKorisnik!=null) {
                unbindTextFields(oldKorisnik);
            }
            if(newKorisnik==null) {
                ime.setText("");
                prezime.setText("");
                email.setText("");
                kime.setText("");
                lozinka.setText("");
            }
            else {
                postaviVrijednostiPolja(newKorisnik);
            }
        });

    }

    private void postaviVrijednostiPolja(Korisnik korisnik) {
        //unbindTextFields(); // Prekini sve prethodne veze

        // Postavi vrijednosti polja na odabrane vrijednosti korisnika
        bindTextField(ime, korisnik.imeProperty());
        bindTextField(prezime, korisnik.prezimeProperty());
        bindTextField(email, korisnik.emailProperty());
        bindTextField(kime, korisnik.korisnickoImeProperty());
        bindTextField(lozinka, korisnik.lozinkaProperty());
    }

    private void bindTextField(TextField textField, StringProperty stringProperty) {
        // Veži tekstualno polje s odgovarajućim StringProperty-em
        textField.textProperty().bindBidirectional(stringProperty);
    }

    private void unbindTextFields(Korisnik korisnik) {
        // Prekini sve veze s tekstualnim poljima
        ime.textProperty().unbindBidirectional(korisnik.imeProperty());
        prezime.textProperty().unbindBidirectional(korisnik.prezimeProperty());
        email.textProperty().unbindBidirectional(korisnik.emailProperty());
        kime.textProperty().unbindBidirectional(korisnik.korisnickoImeProperty());
        lozinka.textProperty().unbindBidirectional(korisnik.lozinkaProperty());
    }


    @FXML
    public void prikaziKorisnika(MouseEvent event) {
        Korisnik IzabraniKorisnik = (Korisnik) listaKorisnika.getSelectionModel().getSelectedItem();
        if (IzabraniKorisnik != null) {
            model.setTrenutniKorisnik(IzabraniKorisnik);
            listaKorisnika.refresh();
        }
    }

    @FXML
    public void Dodaj(MouseEvent keyEvent) {
        // Dodaj novog korisnika i postavi ga kao trenutnog
        model.dodajNovogKorisnika();
    }

    @FXML
    public void Kraj(MouseEvent keyEvent) {
        System.exit(0);
    }


}

