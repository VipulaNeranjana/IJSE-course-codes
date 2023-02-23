package lk.ijse.dep10.editor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.*;

public class EditorSceneController {

    @FXML
    private TextArea txtEditor;

    @FXML
    void mnAboutOnAction(ActionEvent event) {

    }

    @FXML
    void mnCloseOnAction(ActionEvent event) {

    }

    @FXML
    void mnNewOnAction(ActionEvent event) {
        txtEditor.clear();

    }

    @FXML
    void mnOpenOnAction(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("open a text file");
        File file = fileChooser.showOpenDialog(txtEditor.getScene().getWindow());
        if(file == null) return;

        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = fileInputStream.readAllBytes();

        txtEditor.setText(new String(bytes));

        fileInputStream.close();

    }

    @FXML
    void mnPrintOnAction(ActionEvent event) {

    }

    @FXML
    void mnSaveOnAction(ActionEvent event) throws IOException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save text file");
        File file = fileChooser.showSaveDialog(txtEditor.getScene().getWindow());
        if(file == null) return;

        FileOutputStream fileOutputStream = new FileOutputStream(file);

        String text = txtEditor.getText();
        byte[] bytes = text.getBytes();
        fileOutputStream.write(bytes);

        fileOutputStream.close();
    }

}
