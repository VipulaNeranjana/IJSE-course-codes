package lk.ijse.dep10.fx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        System.out.println("just before the launch of java fx runtime env.");
        launch(args);  /*to start java fx runtime environment*/
        System.out.println("just after the the launch of java fx runtime env.");
    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("im in");
        Platform.exit();

    }
}
