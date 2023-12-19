package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader root = new FXMLLoader(getClass().getResource("unosKorisnika.fxml"));
        stage.setTitle("Korisnici");
        stage.setScene(new Scene(root.load()));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
