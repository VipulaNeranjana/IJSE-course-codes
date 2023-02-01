import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        System.out.println("here is the app initializer main method opening");
        launch(args);
        System.out.println("here is the app initializer main method ending");
    }

    @Override
    public void start(Stage primaryStage) {

        System.out.println("here is the app initializer start method");
        Platform.exit();
    }
}
