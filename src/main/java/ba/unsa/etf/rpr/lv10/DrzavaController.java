package ba.unsa.etf.rpr.lv10;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DrzavaController {
    @FXML
    private TextField fieldNaziv;
    @FXML
    private ChoiceBox<String> choiceGrad;
    @FXML
    private Button btnOk;
    @FXML
    private Button btnCancel;

    private ObservableList<String> gradovi;

    public void initialize() {
        // Popuni ChoiceBox s gradovima
        gradovi = FXCollections.observableArrayList(GeografijaDAO.getInstance().gradoviNazivi());
        choiceGrad.setItems(gradovi);

        // Postavka događaja na dugmadima
        btnOk.setOnAction(event -> potvrdiUnos());
        btnCancel.setOnAction(event -> zatvoriFormu());
    }

    private void potvrdiUnos() {
        int id = GeografijaDAO.getInstance().brojDrzava() + 1;
        String nazivDrzave = fieldNaziv.getText().trim();
        String glavniGrad = choiceGrad.getValue();

        // Dodaj državu u bazu podataka
        Drzava novaDrzava = new Drzava(id,nazivDrzave, glavniGrad);
        GeografijaDAO.getInstance().dodajDrzavu(novaDrzava);

        // Zatvori prozor
        zatvoriFormu();
    }

    private void zatvoriFormu() {
        // Zatvori prozor
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}
