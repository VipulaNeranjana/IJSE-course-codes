package lk.ijse.dep10.serialization.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {

    public Button btnStudentListing;
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

    public void btnStudentListingOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(new FXMLLoader(getClass().getResource("/view/StudentListView.fxml")).load()));
        stage.show();
        stage.centerOnScreen();
        stage.setTitle("Manage Student List");
    }

    public void btnSerializationWithInheritanceOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(new FXMLLoader(getClass().getResource("/view/InheritanceView.fxml")).load()));
        stage.setTitle("Inheritance View");
        stage.show();
        stage.centerOnScreen();
    }

    public void btnSerializationWithInheritance2OnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(new FXMLLoader(getClass().getResource("/view/InheritanceView2.fxml")).load()));
        stage.setTitle("Inheritance View");
        stage.show();
        stage.centerOnScreen();
    }

    public void btnTransiantOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(new FXMLLoader(getClass().getResource("/view/TransiantView.fxml")).load()));
        stage.setTitle("Transiant view");
        stage.show();
        stage.centerOnScreen();
    }
}
