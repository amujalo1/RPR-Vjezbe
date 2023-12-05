package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader root = new FXMLLoader(getClass().getResource("digitron.fxml"));
        primaryStage.setTitle("Kalkulator");
        primaryStage.setScene(new Scene(root.load()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
