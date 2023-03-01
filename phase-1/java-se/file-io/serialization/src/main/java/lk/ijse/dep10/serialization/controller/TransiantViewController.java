package lk.ijse.dep10.serialization.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import lk.ijse.dep10.serialization.enmumaration.Status;
import lk.ijse.dep10.serialization.model.Employee;
import lk.ijse.dep10.serialization.model.PersonInfo;
import lk.ijse.dep10.serialization.model.inherit2.A;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class TransiantViewController {

    @FXML
    public ToggleGroup Status;

    @FXML
    public Button btnAddEmployeeContact;

    @FXML
    public Button btnAddSpouseContact;

    @FXML
    public Button btnDelete;

    @FXML
    public Button btnNewEmployee;

    @FXML
    public Button btnRemoveEmployeeContact;

    @FXML
    public Button btnRemoveSpouseContact;

    @FXML
    public Button btnSave;

    @FXML
    public ListView<String> lstEmployeeContact;

    @FXML
    public ListView<String> lstSpouseContact;

    @FXML
    public RadioButton rdoMarried;

    @FXML
    public RadioButton rdoSingle;

    @FXML
    public TableView<Employee> tblDetails;

    @FXML
    public TextField txtContact;

    @FXML
    public TextField txtId;

    @FXML
    public TextField txtName;

    @FXML
    public TextField txtSpouseContact;

    @FXML
    public TextField txtSpouseName;
    public VBox vboxSpouse;

    private File employeeDB = new File("employee.db.dep10");
    ArrayList<Employee>  employeeList = new ArrayList<>();
    public void initialize(){
        tblDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("spouseName"));
        tblDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("btnDelete"));

        try {
            FileInputStream fileInputStream = new FileInputStream(employeeDB);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            employeeList = (ArrayList<Employee>) objectInputStream.readObject();
            for (Employee employee : employeeList) {
                Button btn = new Button("Delete");
                btn.setOnAction(actionEvent -> {
                    tblDetails.getItems().remove(employee);

                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(employeeDB);
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                        employeeList.remove(employee);
                        objectOutputStream.writeObject(employeeList);
                        objectOutputStream.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                });
                employee.setBtnDelete(btn);
            }
            tblDetails.getItems().addAll(employeeList);
            tblDetails.refresh();
            objectInputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        lstSpouseContact.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            btnRemoveSpouseContact.setDisable(current == null);
        });

        lstEmployeeContact.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            btnRemoveEmployeeContact.setDisable(current == null);
        });

        tblDetails.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            btnDelete.setDisable(current == null);
        });

        vboxSpouse.setDisable(true);

        rdoSingle.getToggleGroup().selectedToggleProperty().addListener((observableValue, toggle, current) -> {
            vboxSpouse.setDisable(current == rdoSingle);
        });
        btnRemoveEmployeeContact.setDisable(true);
        btnRemoveSpouseContact.setDisable(true);
        btnDelete.setDisable(true);
    }

    @FXML
    void btnAddEmployeeContactOnAction(ActionEvent event) {
        ObservableList<String> employeeContactItems = lstEmployeeContact.getItems();
        if(txtContact.getText().isBlank() || employeeContactItems.contains(txtContact.getText())) {
            txtContact.requestFocus();
            return;
        }
        employeeContactItems.add(txtContact.getText());
        txtContact.clear();
        txtContact.requestFocus();
    }

    @FXML
    void btnAddSpouseContactOnAction(ActionEvent event) {
        ObservableList<String> spouseContactItems = lstSpouseContact.getItems();
        if(txtSpouseContact.getText().isBlank() | spouseContactItems.contains(txtSpouseContact.getText())) {
            txtSpouseContact.requestFocus();
            return;
        }
        spouseContactItems.add(txtSpouseContact.getText());
        txtSpouseContact.clear();
        txtSpouseContact.requestFocus();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Employee employee = tblDetails.getSelectionModel().getSelectedItem();
        if(employee == null) return;
        tblDetails.getItems().remove(employee);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(employeeDB);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            employeeList.remove(employee);
            objectOutputStream.writeObject(employeeList);
            objectOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        tblDetails.getSelectionModel().clearSelection();

    }

    @FXML
    void btnNewEmployeeOnAction(ActionEvent event) {
        txtContact.clear();
        txtId.clear();
        txtName.clear();
        txtSpouseContact.clear();
        txtSpouseName.clear();
        lstEmployeeContact.getItems().clear();
        lstSpouseContact.getItems().clear();
        tblDetails.getSelectionModel().clearSelection();
        rdoMarried.getToggleGroup().selectToggle(null);

        txtId.requestFocus();
    }

    @FXML
    void btnRemoveEmployeeContactOnAction(ActionEvent event) {
        lstEmployeeContact.getItems().remove(lstEmployeeContact.getSelectionModel().getSelectedIndex());
        if(lstEmployeeContact.getItems().isEmpty()){
            txtContact.requestFocus();
        }

    }

    @FXML
    void btnRemoveSpouseContactOnAction(ActionEvent event) {
        lstSpouseContact.getItems().remove(lstEmployeeContact.getSelectionModel().getSelectedIndex());
        if(lstSpouseContact.getItems().isEmpty()){
            txtSpouseContact.requestFocus();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if(!isTrue()) return;

        String id = txtId.getText();
        String name = txtName.getText();
        ArrayList<String> employeeContatctList = new ArrayList<>(lstEmployeeContact.getItems());
        PersonInfo employeeInfo = new PersonInfo(name, employeeContatctList);
        Status status = Status.getSelectedToggle() == rdoMarried ? lk.ijse.dep10.serialization.enmumaration.Status.MARRIED : lk.ijse.dep10.serialization.enmumaration.Status.SINGLE;
        PersonInfo spouseInfo = null;

        if(status == lk.ijse.dep10.serialization.enmumaration.Status.MARRIED){
            String spouseName = txtSpouseName.getText();
            ArrayList<String> spouseContactNumbers = new ArrayList<>(lstSpouseContact.getItems());
            spouseInfo = new PersonInfo(spouseName,spouseContactNumbers);
        }

        Button button = new Button("Delete");
        Employee employee = new Employee(id, employeeInfo, status, spouseInfo,button);
        employeeList.add(employee);
        button.setOnAction(actionEvent -> {
            System.out.println("im in");
            tblDetails.getItems().remove(employee);

            try {
                FileOutputStream fileOutputStream = new FileOutputStream(employeeDB);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                employeeList.remove(employee);
                objectOutputStream.writeObject(employeeList);
                objectOutputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(employeeDB);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(employeeList);
            objectOutputStream.close();
            tblDetails.getItems().add(employee);
        }catch (Exception e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"something went wrong").show();
            employeeList.remove(employee);
        }
    }
    private boolean isTrue(){
        if(txtId.getText().isBlank()){
            txtId.requestFocus();
            return false;
        }
        if(txtName.getText().isBlank()){
            txtName.requestFocus();
            return false;
        }
        if(rdoSingle.getToggleGroup().getSelectedToggle() == rdoMarried){
            if(txtSpouseName.getText().isBlank()){
                txtSpouseName.requestFocus();
                return false;
            }
            if(lstSpouseContact.getItems().isEmpty()) {
                txtSpouseContact.requestFocus();
                return false;
            }
        }
        if(rdoSingle.getToggleGroup().selectedToggleProperty() ==  null){
            rdoSingle.requestFocus();
            return false;
        }
        if(lstEmployeeContact.getItems().isEmpty()) {
            txtContact.requestFocus();
            return false;
        }

        return true;
    }

    @FXML
    void lstEmployeeContactOnKeyReleased(KeyEvent event) {
        if(event.getCode() == KeyCode.DELETE) btnRemoveEmployeeContact.fire();

    }

    @FXML
    void lstSpouseContactOnKeyReleased(KeyEvent event) {
        if(event.getCode() == KeyCode.DELETE) btnRemoveSpouseContact.fire();
    }

    @FXML
    void tblDetailsOnKeyReleased(KeyEvent event) {
        if(event.getCode() == KeyCode.DELETE) btnDelete.fire();
    }

}
