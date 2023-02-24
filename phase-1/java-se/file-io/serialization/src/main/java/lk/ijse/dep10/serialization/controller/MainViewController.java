package lk.ijse.dep10.serialization.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {

    @FXML
    private Button btnHelloSerialization;

    @FXML
    private Button btnManageStudent;

    @FXML
    void btnHelloSerializationOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(new FXMLLoader(getClass().getResource("/view/HelloView.fxml")).load()));
        stage.show();
        stage.centerOnScreen();
        stage.setTitle("Hello serialization");
    }

    @FXML
    void btnManageStudentOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(new FXMLLoader(getClass().getResource("/view/StudentView.fxml")).load()));
        stage.show();
        stage.centerOnScreen();
        stage.setTitle("Manage Student");
    }

}
