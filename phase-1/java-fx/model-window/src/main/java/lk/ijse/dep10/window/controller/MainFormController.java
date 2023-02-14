package lk.ijse.dep10.window.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MainFormController {

    public Button btnModelWindow1;
    public Button btnModelWindow2;
    public Button btnOpenDialog;
    public Button btnSaveDialog;
    public Button btnDrectChooser;

    public MainFormController(){
        System.out.println("constructor" + btnNormalWindow);
    }

    @FXML
    private Button btnNormalWindow;

    public void initialize(){
        System.out.println("initializer" + btnNormalWindow);
    }

    @FXML
    void btnNormalWindowAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        URL resource = getClass().getResource("/view/MainForm.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        AnchorPane root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println(btnNormalWindow);
    }

    public void btnModelWindow1Action(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();

        URL resource = getClass().getResource("/view/EmptyForm.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        AnchorPane anchorPane1 = fxmlLoader.load();
        Scene scene = new Scene(anchorPane1);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setTitle("window 1");
        stage.show();
        stage.centerOnScreen();
    }

    public void btnModelWindow2Action(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();

        URL resource = getClass().getResource("/view/EmptyForm.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        AnchorPane anchorPane1 = fxmlLoader.load();
        Scene scene = new Scene(anchorPane1);
        stage.setScene(scene);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(btnModelWindow2.getScene().getWindow());

        stage.setTitle("window 2");
        stage.show();
        stage.centerOnScreen();
    }



    public void btnSaveDialogOnAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open a File");
        File file = fileChooser.showSaveDialog(btnSaveDialog.getScene().getWindow());
        System.out.println(file);
    }

    public void btnOpenDialogOnAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open a File");
        fileChooser.showOpenDialog(btnSaveDialog.getScene().getWindow());

    }

    public void btnDrectChooserOnAction(ActionEvent actionEvent) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Open a File");
        File file = directoryChooser.showDialog(btnDrectChooser.getScene().getWindow());
        System.out.println(file);
    }
}
