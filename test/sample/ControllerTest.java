package sample;

import static org.junit.jupiter.api.Assertions.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import static org.testfx.matcher.control.ListViewMatchers.*;

import java.util.Objects;

@ExtendWith(ApplicationExtension.class)
class ControllerTest {


    private TextField ime;
    private TextField prezime;
    private TextField email;
    private TextField kime;
    private TextField lozinka;

    @Start
    public void start (Stage stage) throws Exception {
        Parent mainNode = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("unosKorisnika.fxml")));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }

    @Test
    public void startWithNullString (FxRobot robot) {
        ime = robot.lookup("#ime").queryAs(TextField.class);
        assertEquals("", ime.getText());
        prezime = robot.lookup("#prezime").queryAs(TextField.class);
        assertEquals("", prezime.getText());
        kime = robot.lookup("#kime").queryAs(TextField.class);
        assertEquals("", kime.getText());
        email = robot.lookup("#email").queryAs(TextField.class);
        assertEquals("", email.getText());
        lozinka = robot.lookup("#lozinka").queryAs(TextField.class);
        assertEquals("", lozinka.getText());
    }

    @Test
    public void clickOnListViewItem(FxRobot robot) {
        robot.clickOn("#listaKorisnika").clickOn("korisnik2");
        ime = robot.lookup("#ime").queryAs(TextField.class);
        assertEquals("Ime2", ime.getText());
        prezime = robot.lookup("#prezime").queryAs(TextField.class);
        assertEquals("Prezime2", prezime.getText());
        email = robot.lookup("#email").queryAs(TextField.class);
        assertEquals("email2@example.com", email.getText());
        kime = robot.lookup("#kime").queryAs(TextField.class);
        assertEquals("korisnik2", kime.getText());
        lozinka = robot.lookup("#lozinka").queryAs(TextField.class);
        assertEquals("lozinka2", lozinka.getText());
    }

    @Test
    public void clickOnDodajAfterSelection (FxRobot robot) {
        robot.clickOn("#listaKorisnika").clickOn("korisnik2");
        robot.clickOn("#dodajButton");
        ime = robot.lookup("#ime").queryAs(TextField.class);
        assertEquals("", ime.getText());
        prezime = robot.lookup("#prezime").queryAs(TextField.class);
        assertEquals("", prezime.getText());
        email = robot.lookup("#email").queryAs(TextField.class);
        assertEquals("", email.getText());
        kime = robot.lookup("#kime").queryAs(TextField.class);
        assertEquals("", kime.getText());
        lozinka = robot.lookup("#lozinka").queryAs(TextField.class);
        assertEquals("", lozinka.getText());
    }
    @Test
    public void saveNewKorisnikAfterSelection (FxRobot robot) {
        robot.clickOn("#listaKorisnika").clickOn("korisnik2");
        robot.clickOn("#dodajButton");
        robot.clickOn("#ime").write("Amer");
        robot.clickOn("#prezime").write("Mujalo");
        robot.clickOn("#email").write("amujalo1@etf.unsa.ba");
        robot.clickOn("#lozinka").write("12345");
        robot.clickOn("#kime").write("amujalo1");
        robot.clickOn("#listaKorisnika").clickOn("korisnik2");
        robot.clickOn("#listaKorisnika").clickOn("amujalo1");
        ime = robot.lookup("#ime").queryAs(TextField.class);
        assertEquals("Amer", ime.getText());
        prezime = robot.lookup("#prezime").queryAs(TextField.class);
        assertEquals("Mujalo", prezime.getText());
        email = robot.lookup("#email").queryAs(TextField.class);
        assertEquals("amujalo1@etf.unsa.ba", email.getText());
        kime = robot.lookup("#kime").queryAs(TextField.class);
        assertEquals("amujalo1", kime.getText());
        lozinka = robot.lookup("#lozinka").queryAs(TextField.class);
        assertEquals("12345", lozinka.getText());
    }
    @Test
    public void saveSelectedKorisnikAfterSelection(FxRobot robot) {
        robot.clickOn("#listaKorisnika").clickOn("korisnik2");

        // Use keyboard shortcuts to clear existing text in the fields before entering new text
        robot.clickOn("#ime").press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL).type(KeyCode.DELETE).write("MojeIme");
        robot.clickOn("#prezime").press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL).type(KeyCode.DELETE).write("MojePrezime");
        robot.clickOn("#kime").press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL).type(KeyCode.DELETE).write("IzmjenjeniKorisnik");

        // Click on another item to deselect the current one
        robot.clickOn("#listaKorisnika").clickOn("korisnik1");

        // Click on the item to select it again and trigger the save
        robot.clickOn("#listaKorisnika").clickOn("IzmjenjeniKorisnik");

        // Verify the text fields have the correct values
        ime = robot.lookup("#ime").queryAs(TextField.class);
        assertEquals("MojeIme", ime.getText());

        prezime = robot.lookup("#prezime").queryAs(TextField.class);
        assertEquals("MojePrezime", prezime.getText());

        email = robot.lookup("#email").queryAs(TextField.class);
        assertEquals("email2@example.com", email.getText());

        kime = robot.lookup("#kime").queryAs(TextField.class);
        assertEquals("IzmjenjeniKorisnik", kime.getText());

        lozinka = robot.lookup("#lozinka").queryAs(TextField.class);
        assertEquals("lozinka2", lozinka.getText());
    }

}