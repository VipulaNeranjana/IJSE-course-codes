package lk.ijse.dep10.app;

import javafx.application.Application;
import javafx.stage.Stage;

public class AppInitializer extends Application {
    public AppInitializer() {
        
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Stage stage1 = new Stage();
        primaryStage.setTitle("maven app");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
        primaryStage.centerOnScreen();

    }
}
