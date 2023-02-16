package controller;


import Model.Employee;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.Optional;

public class TableViewScenenController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnNEw;

    @FXML
    private Button btnSave;

    @FXML
    private Label lblAdress;

    @FXML
    private Label lblID;

    @FXML
    private Label lblName;

    @FXML
    private TableView<Employee> tblEmployees;

    @FXML
    private TextField txtAdress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    public void initialize(){
        /*column mapping*/

        tblEmployees.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblEmployees.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblEmployees.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        Employee e001 = new Employee("E001", "kasun", "panadura");
        Employee e002 = new Employee("E002", "ruwan", "galewela");
        Employee e003 = new Employee("E003", "vipula", "veyangoda");
        Employee e004 = new Employee("E004", "amani", "kaluthara");

        tblEmployees.getItems().addAll(e001,e002,e003,e004);

        txtId.setDisable(true);
        txtName.setDisable(true);
        txtAdress.setDisable(true);
        btnSave.setDisable(true);
        btnDelete.setDisable(true);

        tblEmployees.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            btnDelete.setDisable(current ==null);
            if(current == null) return;

            txtId.setText(current.getId());
            txtName.setText(current.getName());
            txtAdress.setText(current.getAddress());
        });


    }
    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        Optional<ButtonType> optButton = new Alert(Alert.AlertType.CONFIRMATION, "are you sure??", ButtonType.YES, ButtonType.NO).showAndWait();
        if(optButton.isEmpty() || optButton.get() == ButtonType.NO) return;

        ObservableList<Employee> employees = tblEmployees.getItems();
        Employee selectedItems = tblEmployees.getSelectionModel().getSelectedItem();
        employees.remove(selectedItems);
        btnNEw.fire();
    }

    @FXML
    void btnNewOnAction(ActionEvent event) {
        txtId.setDisable(false);
        txtName.setDisable(false);
        txtAdress.setDisable(false);
        btnSave.setDisable(false);
        btnDelete.setDisable(false);

        txtId.clear();
        txtName.clear();
        txtAdress.clear();

        txtId.requestFocus();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        String id = txtId.getText().strip();
        String name = txtName.getText().strip();
        String address = txtAdress.getText().strip();

        for (TextField txt : new TextField[]{txtId, txtName, txtAdress}) {
            if(txt.getText().isBlank()){
                txt.selectAll();
                txt.requestFocus();
                return;
            }
        }

        for (Employee employee : tblEmployees.getItems()) {
//            if(selectedItems != null)return;
            if(employee.getId().equals(id)){
                txtId.selectAll();
                txtId.requestFocus();
                return;
            }
        }

        Employee selectedItems = tblEmployees.getSelectionModel().getSelectedItem();
        if(selectedItems == null){
            Employee employee = new Employee(id, name, address);
            tblEmployees.getItems().add(employee);
        }
        else{

            selectedItems.setId(txtId.getText());
            selectedItems.setName(txtName.getText());
            selectedItems.setAddress(txtAdress.getText());
        }
        btnNEw.fire();
    }

}
