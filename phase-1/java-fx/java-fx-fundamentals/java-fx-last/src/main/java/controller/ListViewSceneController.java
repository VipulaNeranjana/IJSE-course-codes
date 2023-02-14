package controller;

import Model.Student;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class ListViewSceneController {

    public TextField txtNddress;
    public TextField txtName;
    public TextField txtId;
    public TextField name;
    public Button btnSave;
    public Button btnDelete;
    public ListView<Student> lstStudents;
    public Button btnNew;
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnRemove;

    @FXML
    private Label lblSelectedName;

    @FXML
    private ListView<String> lstNames;

    @FXML
    private TextField textInput;

    public void initialize() {
        lstNames.getSelectionModel().selectedItemProperty().addListener((value, previousValue, currentValue) -> {
//            System.out.println(currentValue);
            if (currentValue == null) {
                lblSelectedName.setText("no name has been selected");
                btnRemove.setDisable(true);
            }
            lblSelectedName.setText("selected name is : " + currentValue);
            btnRemove.setDisable(false);
        });

        lstStudents.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            if(current == null) {
                btnDelete.setDisable(true);
                return;
            }

            btnDelete.setDisable(false);
            txtId.setText(current.id);
            name.setText(current.name);
            txtNddress.setText(current.address);

            txtId.setDisable(true);


        });
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String input = textInput.getText();
        if (input.isBlank()) {
            textInput.selectAll();
            textInput.requestFocus();
            return;
        }

        ObservableList<String> names = lstNames.getItems();
        names.add(textInput.getText().strip());

        textInput.clear();
        textInput.requestFocus();
    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) throws InterruptedException {
        String selectedName = lstNames.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete " + selectedName + " ???");
        alert.setTitle("delete name");

        Optional<ButtonType> button = alert.showAndWait();
        if (button.isEmpty()) return;
        if (button.get() == ButtonType.OK) {
            int selectedIndex = lstNames.getSelectionModel().getSelectedIndex();
            lstNames.getItems().remove(selectedIndex);

            lstNames.refresh();

            lblSelectedName.setText(selectedName + " removed");
            lstNames.getSelectionModel().clearSelection();
            btnRemove.setDisable(true);

            textInput.requestFocus();

        }

    }

    public void onKeyPressed(KeyEvent keyEvent) {
        int selectedIndex = lstNames.getSelectionModel().getSelectedIndex();
        String selectedName = lstNames.getSelectionModel().getSelectedItem();

        if (keyEvent.getCode() == KeyCode.DELETE) {
            lstNames.getItems().remove(selectedIndex);

            lstNames.refresh();

            lblSelectedName.setText(selectedName + " removed");
            lstNames.getSelectionModel().clearSelection();
            btnRemove.setDisable(true);

            textInput.requestFocus();
        }
    }

    public void btnNewOnAction(ActionEvent actionEvent) {
        txtId.setDisable(false);
        name.setDisable(false);
        txtNddress.setDisable(false);
        btnSave.setDisable(false);

        txtId.clear();
        name.clear();
        txtNddress.clear();

        txtId.getStyleClass().remove("invalid");
        name.getStyleClass().remove("invalid");
        txtNddress.getStyleClass().remove("invalid");

        lstStudents.getSelectionModel().clearSelection();

        txtId.requestFocus();
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        boolean isValid = true;

        String id = txtId.getText();
        String address = txtNddress.getText();
        String name1 = name.getText();

        txtId.getStyleClass().remove("invalid");
        name.getStyleClass().remove("invalid");
        txtNddress.getStyleClass().remove("invalid");


        if (address.isBlank() || address.length() < 3) {
            txtNddress.getStyleClass().add("invalid");
            txtNddress.requestFocus();
            isValid = false;
        }
        if (name1.isBlank()) {
            name.getStyleClass().add("invalid");
            name.requestFocus();
            isValid = false;
        }
        if (id.isBlank() || id.charAt(0) != 'S' || id.substring(1).length() < 3 || !isNumber(id.substring(1))) {
            txtId.getStyleClass().add("invalid");
            txtId.requestFocus();
            isValid = false;

        }

        if(!isValid)return;

        if(lstStudents.getSelectionModel().getSelectedIndex() == -1){
            ObservableList<Student> studentList = lstStudents.getItems();
            for(Student student : studentList){
                if(student.id.equals(id)) {
                    txtId.getStyleClass().add("invalid");
                    txtId.requestFocus();
                    txtId.selectAll();
                    return;
                }
            }
            Student student = new Student(id, name1, address);
            studentList.add(student);
        }else {
            Student student = lstStudents.getSelectionModel().getSelectedItem();

            student.name = name1;
            student.address = address;

        }


        btnNew.fire();



    }

    private boolean isNumber(String string) {
        for (char c : string.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        int studentIndex = lstStudents.getSelectionModel().getSelectedIndex();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete " + lstStudents.getSelectionModel().getSelectedItem().name, ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> result = alert.showAndWait();

        if(result.isEmpty() || result.get() == ButtonType.NO) return;

        if(result.isPresent() && result.get() == ButtonType.YES){
            lstStudents.getItems().remove(studentIndex);
            btnNew.fire();
        }


    }

    public void txtOnAction(ActionEvent actionEvent) {
        btnSave.fire();

    }

    public void lstStudentOnKeyRelesed(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER){
            btnDelete.fire();
        }
    }
}
