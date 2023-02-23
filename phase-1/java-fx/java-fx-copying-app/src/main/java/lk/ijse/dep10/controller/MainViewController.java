package lk.ijse.dep10.controller;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainViewController {

    @FXML
    private Button btnCopy;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSelectDestination;

    @FXML
    private Button btnSelectFile;

    @FXML
    private Label lblPercentage;

    @FXML
    private ProgressBar prbCopying;

    @FXML
    private TextField txtFileDestination;

    @FXML
    private TextField txtSelectFile;

    private File selectedFile;
    private File destinatedFile;

    private String fileName;

    public void initialize(){
        txtSelectFile.setText("No File Selected");
        txtFileDestination.setText("No Path Selected");
    }

    @FXML
    void btnCopyOnAction(ActionEvent event) throws IOException {

        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                FileInputStream fileInputStream = new FileInputStream(selectedFile);
                FileOutputStream fileOutputStream = new FileOutputStream(destinatedFile);

                while (true) {
                    byte[] buffer = new byte[1024 * 1024 * 10];
                    int read = fileInputStream.read(buffer);
                    if(read == -1) break;
                    fileOutputStream.write(buffer,0,read);

                    double progressCounter  = ((double) destinatedFile.length()/(double) selectedFile.length());
                    System.out.println(progressCounter);

                    updateProgress(progressCounter,1);
                    updateMessage((int)(progressCounter* 100 )+ "%");
                }

                fileInputStream.close();
                fileOutputStream.close();
                return null;
            }
        };

        new Thread(task).start();

        prbCopying.progressProperty().bind(task.progressProperty());
        lblPercentage.textProperty().bind(task.messageProperty());
        System.out.println("done");
    }

    @FXML
    void btnResetOnAction(ActionEvent event) {
        txtFileDestination.clear();
        txtSelectFile.clear();
        selectedFile = null;
        destinatedFile =  null;
        btnCopy.setDisable(true);
        prbCopying.progressProperty().unbind();
        prbCopying.setProgress(0.0);
        lblPercentage.textProperty().unbind();
        lblPercentage.setText("Percentage %");

    }

    @FXML
    void btnSelectDestinationOnAction(ActionEvent event) {

        DirectoryChooser fileChooser = new DirectoryChooser();
        File fileDirected = fileChooser.showDialog(txtSelectFile.getScene().getWindow());
        if(fileDirected == null){
            txtSelectFile.setText("No path selected");
            return;
        }
        File file = new File(fileDirected.getAbsolutePath() ,""+fileName);
        if(file.exists()){
            Alert thisFileIsAlreadyExist = new Alert(Alert.AlertType.WARNING, "this file is already exist", ButtonType.CANCEL);
            thisFileIsAlreadyExist.showAndWait();
            return;
        }
        destinatedFile = file;
        txtFileDestination.setText(file.getAbsolutePath());

        checkingForFiles();
    }

    @FXML
    void btnSelectFileOnAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(txtSelectFile.getScene().getWindow());
        if(file == null){
            txtSelectFile.setText("No file selected");
            return;
        }

        fileName = file.getName();
        selectedFile = file;
        txtSelectFile.setText(file.getPath());

        checkingForFiles();

    }

    private void checkingForFiles(){
        if(selectedFile != null && destinatedFile != null) {
            btnCopy.setDisable(false);
            return;
        }
        btnCopy.setDisable(true);
    }

}
