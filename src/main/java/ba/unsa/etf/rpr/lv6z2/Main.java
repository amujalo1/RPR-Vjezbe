package ba.unsa.etf.rpr.lv6z2;

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
