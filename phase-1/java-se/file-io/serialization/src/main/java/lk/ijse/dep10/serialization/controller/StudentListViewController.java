package lk.ijse.dep10.serialization.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dep10.serialization.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentListViewController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnNewStudent;

    @FXML
    private Button btnSave;

    @FXML
    private TableView<Student> tblStudents;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    private File directory = new File(new File(System.getProperty("user.home")),"Desktop");
    private File file = new File(directory,"studentList.dep");

    public void initialize(){

        tblStudents.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblStudents.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblStudents.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        if(file.exists()){
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                List<Student> tblData = (List<Student>)objectInputStream.readObject();
                ObservableList<Student> tblDataObservable = FXCollections.observableList(tblData);
                tblStudents.getItems().addAll(tblDataObservable);

                objectInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        tblStudents.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            System.out.println("im in the listener");
            btnDelete.setDisable(current == null);
        });
    }

    @FXML
    void btnNewStudentOnAction(ActionEvent event) {
        txtId.setDisable(false);
        txtName.setDisable(false);
        txtAddress.setDisable(false);
        btnSave.setDisable(false);

        txtId.clear();
        txtName.clear();
        txtAddress.clear();
        tblStudents.getSelectionModel().clearSelection();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Student selectedItem = tblStudents.getSelectionModel().getSelectedItem();
        if(selectedItem == null){
            new Alert(Alert.AlertType.ERROR,"nothing selected!").show();
            return;
        }
        tblStudents.getItems().remove(selectedItem);
        tblStudents.refresh();
        new Alert(Alert.AlertType.CONFIRMATION,selectedItem.name+ " removed.").show();
        btnDelete.setDisable(true);

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if(!checkValidityOfTheInputs()) {
            new Alert(Alert.AlertType.WARNING,"Invalid input fields").show();
            return;
        }
        Student student = new Student(txtId.getText(), txtName.getText(), txtAddress.getText());
        tblStudents.getItems().add(student);
        tblStudents.refresh();

        ObservableList<Student> items = tblStudents.getItems();

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(new ArrayList<Student>(items));
            System.out.println("Done Serialization");

            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        txtId.clear();
        txtName.clear();
        txtAddress.clear();
        tblStudents.getSelectionModel().clearSelection();
    }

    private boolean checkValidityOfTheInputs(){
        if(txtId.getText().isBlank() || txtName.getText().isBlank() || txtAddress.getText().isBlank()) return false;

        return true;
    }

}
