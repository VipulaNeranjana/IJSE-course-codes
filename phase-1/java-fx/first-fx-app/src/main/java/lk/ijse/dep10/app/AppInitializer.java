package lk.ijse.dep10.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Stage stage = new Stage();

        AnchorPane anchorPane = new AnchorPane();
        Button button1 = new Button("Click me");
        button1.setLayoutX(50);
        button1.setLayoutY(250);
        anchorPane.getChildren().add(button1);

        Scene mainScene = new Scene(anchorPane);
        stage.setScene(mainScene);
        stage.setTitle("My first java fx app");
        stage.setWidth(500);
        stage.setHeight(500);
        stage.show();

        Stage stage2 = new Stage();
        stage2.setTitle("second stage");
        stage2.show();

    }
}
