package lk.ijse.dep10.ds;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ObservableList ol = FXCollections.observableArrayList();

//        ol.add(10);
//        ol.add(20);
//        ol.add(30);
//        ol.add(40);
//
//        System.out.println(ol);
//        System.out.println(ol.size());
//        System.out.println(ol.get());

        ListChangeListener subscriber1 = change -> System.out.println("subscriber1 : " + change);
        ListChangeListener subscriber2 = change -> System.out.println("subscriber2 : " + change);
        ListChangeListener subscriber3 = change -> System.out.println("subscriber2 : " + change);

        ol.addListener(subscriber1);
        ol.addListener(subscriber2);

        ol.add(10);
    }
}
