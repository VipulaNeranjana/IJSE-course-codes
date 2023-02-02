package lk.ijse.dep10.app;

import javafx.application.Application;
import javafx.stage.Stage;

public class AppInitializer extends Application {
    public AppInitializer() {
        System.out.println("hi");
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Stage stage1 = new Stage();
        stage1.setTitle("maven app");
        stage1.setWidth(500);
        stage1.setHeight(500);
        stage1.show();
        stage1.centerOnScreen();

    }
}
