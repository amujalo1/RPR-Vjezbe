package ba.unsa.etf.rpr.lv10;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GlavnaController {
    @FXML
    private TableView<Grad> tableViewGradovi;
    @FXML
    private TableColumn<Grad, Integer> colGradId;
    @FXML
    private TableColumn<Grad, String> colGradNaziv;
    @FXML
    private TableColumn<Grad, Integer> colGradStanovnika;
    @FXML
    private TableColumn<Grad, String> colGradDrzava;
    @FXML
    private Button btnDodajGrad;
    @FXML
    private Button btnDodajDrzavu;
    @FXML
    private Button btnIzmijeniGrad;
    @FXML
    private Button btnObrisiGrad;

    private ObservableList<Grad> gradovi;

    public void initialize() {

        // Inicijalizacija stupaca u TableView
        refreshData();

        // Postavka događaja na dugmadima
        btnDodajGrad.setOnAction(event -> dodajGrad());
        btnDodajDrzavu.setOnAction(event -> otvoriDrzavaFormu());
        btnIzmijeniGrad.setOnAction(event -> otvoriGradFormu());
        btnObrisiGrad.setOnAction(event -> obrisiGrad());
    }

    private void dodajGrad() {

        Grad noviGrad = new Grad(GeografijaDAO.getInstance().brojGradova()+1, "Novi Grad", 0, "Nepoznata Država");
        gradovi.add(noviGrad);
        GeografijaDAO.getInstance().dodajGrad(noviGrad);
    }



    private void obrisiGrad() {
        Grad selektovaniGrad = tableViewGradovi.getSelectionModel().getSelectedItem();
        if (selektovaniGrad != null) {
            GeografijaDAO.getInstance().obrisiGrad(selektovaniGrad);
            gradovi.remove(selektovaniGrad);
        }
    }
    private void otvoriDrzavaFormu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("drzava.fxml"));
            Parent root = loader.load();

            DrzavaController drzavaController = loader.getController();
            // Dodajte kod za inicijalizaciju ili prenos podataka prema potrebi

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root));
            stage.showAndWait();

            // Kod koji se izvršava nakon zatvaranja prozora (npr. osvežavanje podataka)
            refreshData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void otvoriGradFormu() {
        Grad selektovaniGrad = tableViewGradovi.getSelectionModel().getSelectedItem();
        if (selektovaniGrad != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("grad.fxml"));
                Parent root = loader.load();
                GradController gradController = loader.getController();
                gradController.setGrad(selektovaniGrad); // Postavljanje selektovanog grada

                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(new Scene(root));
                stage.showAndWait();

                // Kod koji se izvršava nakon zatvaranja prozora (npr. osvežavanje podataka)
                refreshData();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void refreshData() {
        colGradId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colGradNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        colGradStanovnika.setCellValueFactory(new PropertyValueFactory<>("brojStanovnika"));
        colGradDrzava.setCellValueFactory(new PropertyValueFactory<>("drzava"));

        // Popuni TableView podacima
        gradovi = FXCollections.observableArrayList(GeografijaDAO.getInstance().gradovi());
        tableViewGradovi.setItems(gradovi);
    }
}

