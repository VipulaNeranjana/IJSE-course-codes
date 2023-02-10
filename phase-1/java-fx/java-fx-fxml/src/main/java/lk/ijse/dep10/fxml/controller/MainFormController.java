package lk.ijse.dep10.fxml.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class MainFormController {

    @FXML
    private Button btnRemove;

    @FXML
    private HBox dressContainor;

    @FXML
    void btnRemoveOnAction(ActionEvent event) {

        System.out.println("btn");
    }

}
