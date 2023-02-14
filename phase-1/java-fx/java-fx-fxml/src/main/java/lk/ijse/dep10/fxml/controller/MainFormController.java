package lk.ijse.dep10.fxml.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainFormController {

    @FXML
    private Button btnRemove;

    @FXML
    private HBox dressContainor;

    @FXML
    void btnRemoveOnAction(ActionEvent event) throws IOException {

        Stage normalWindow = new Stage();

        URL resource = getClass().getResource("/EmptyForm.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        fxmlLoader.load();

        normalWindow.setTitle("normal window");
        normalWindow.show();
        normalWindow.centerOnScreen();

        System.out.println("btn");
    }

}
