package lk.ijse.dep10.fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/view/MainFormat.fxml"));
        AnchorPane root = fxmlLoader.load();


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("first Fxml");
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}
