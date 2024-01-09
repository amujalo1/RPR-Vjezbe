package ba.unsa.etf.rpr.lv10;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.SQLException;

public class GradController {
    private Grad gradZaIzmenu;
    @FXML
    private TextField fieldNaziv;
    @FXML
    private TextField fieldBrojStanovnika;
    @FXML
    private ChoiceBox<String> choiceDrzava;
    @FXML
    private Button btnOk;
    @FXML
    private Button btnCancel;
    private ObservableList<String> drzave;

    public void initialize() {
        // Popuni ChoiceBox s državama
        drzave = FXCollections.observableArrayList(GeografijaDAO.getInstance().drzaveNazivi());
        choiceDrzava.setItems(drzave);

        // Postavka događaja na dugmadima
        btnOk.setOnAction(event -> {
            try {
                potvrdiUnos();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        btnCancel.setOnAction(event -> zatvoriFormu());
    }
    public void setGrad(Grad grad) {
        gradZaIzmenu = grad;
        // Postavite podatke grada u odgovarajuće kontrole (TextField, ChoiceBox itd.)
        // Primer:
        fieldNaziv.setText(grad.getNaziv());
        fieldBrojStanovnika.setText(String.valueOf(grad.getBrojStanovnika()));
        choiceDrzava.setValue(grad.getDrzava());
    }

    private void potvrdiUnos() throws SQLException {
        if (gradZaIzmenu != null) {
            // Ako postoji grad za izmenu, obavite izmenu umesto dodavanja
            izmeniGrad();
        }
    }

    private void izmeniGrad() throws SQLException {
        // Implementirajte izmenu podataka o gradu u bazi podataka
        gradZaIzmenu.setNaziv(fieldNaziv.getText().trim());
        gradZaIzmenu.setBrojStanovnika(Integer.parseInt(fieldBrojStanovnika.getText().trim()));
        gradZaIzmenu.setDrzava(choiceDrzava.getValue());
        gradZaIzmenu.setId(gradZaIzmenu.getId());
        System.out.println(gradZaIzmenu.getId());

        GeografijaDAO.getInstance().izmijeniGrad(gradZaIzmenu);
        //GeografijaDAO.getInstance().obrisiGrad();
        if (gradZaIzmenu.getNaziv().isEmpty() || gradZaIzmenu.getBrojStanovnika()==0 || gradZaIzmenu.getDrzava() == null) {
            // Primer: promeni boju polja u crveno
            fieldNaziv.setStyle("-fx-border-color: red;");
            fieldBrojStanovnika.setStyle("-fx-border-color: red;");
            return;
        }

        zatvoriFormu();
    }



    private void zatvoriFormu() {
        // Zatvori prozor
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}
