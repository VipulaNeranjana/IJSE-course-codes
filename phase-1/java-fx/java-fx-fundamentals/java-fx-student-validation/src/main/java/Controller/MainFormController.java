package Controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class MainFormController {

    public Button btnAdd;
    public Button btnRemove;
    @FXML
    private Button btnAllModulesToSelected;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnSelectedToAllModules;

    @FXML
    private ListView<String> lstAllModuls;

    @FXML
    private ListView<String> lstContacts;

    @FXML
    private ListView<String> lstSelectedModules;

    @FXML
    private ListView<Student> lstStudents;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    private int id = 1;
    private String idString;

    private boolean isValid = true;
    private int contactCount = 0;
    private  int moduleCount = 0;

    public void initialize(){
        txtId.setDisable(true);
        btnAllModulesToSelected.setDisable(true);
        btnSelectedToAllModules.setDisable(true);
        moduleCount = 0;
        contactCount = 0;
        btnDelete.setDisable(true);
        btnRemove.setDisable(true);
        btnSave.requestFocus();

        if(id<1000) idString = String.format("%03d",id);
        else if (id>1000) idString = String.format("%s",id);
        txtId.setText(idString);

        ObservableList<String> modules = lstAllModuls.getItems();
        modules.addAll("JavaFx","Angular","AI","React","ReactJs");

        lstContacts.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            if(current == null){
                btnRemove.setDisable(true);
            }
            btnRemove.setDisable(false);
        });

        lstAllModuls.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            if(current == null){
                btnAllModulesToSelected.setDisable(true);
            }
            btnAllModulesToSelected.setDisable(false);
        });

        lstSelectedModules.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            if(current == null){
                btnSelectedToAllModules.setDisable(true);
            }
            btnSelectedToAllModules.setDisable(false);
        });

        lstStudents.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            if(current == null){
                btnDelete.setDisable(true);
                return;
            }
            Student student = lstStudents.getSelectionModel().getSelectedItem();

            txtId.setText(student.id);
            txtName.setText(student.name);

            for (String module : student.modules){
                System.out.println(module);
                lstSelectedModules.getItems().add(module);
            }
            for (String contact : student.contacts){
                lstContacts.getItems().add(contact);
            }
            btnDelete.setDisable(false);
        });
    }

    @FXML
    void btnAllModulesToSelectedOnAction(ActionEvent event) {
        int index = lstAllModuls.getSelectionModel().getSelectedIndex();
        if(index == -1) return;

        lstSelectedModules.getItems().add(lstAllModuls.getSelectionModel().getSelectedItem());
        lstAllModuls.getItems().remove(index);
        btnAllModulesToSelected.setDisable(true);
        lstAllModuls.getSelectionModel().clearSelection();
        moduleCount++;

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        int index = lstStudents.getSelectionModel().getSelectedIndex();
        System.out.println(index);
        Student student = lstStudents.getSelectionModel().getSelectedItem();

        if(index == -1)return;

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete " + student.name, ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> canDelete = alert.showAndWait();

        if(canDelete.isEmpty() || canDelete.get() == ButtonType.NO) return;
        if(canDelete.get() == ButtonType.YES) {
            if(id<1000) idString = String.format("%03d",id);
            else if (id>1000) idString = String.format("%s",id);
            txtId.setText(idString);

            lstStudents.getItems().remove(index);

            moduleCount = 0;
            contactCount = 0;
            txtName.clear();
            txtContact.clear();
            isValid = true;

            lstContacts.getItems().clear();
            lstSelectedModules.getItems().clear();

            txtName.requestFocus();


        }

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {


        txtName.getStyleClass().remove("invalid");
        txtContact.getStyleClass().remove("invalid");

        if(moduleCount < 3){
            isValid = false;
            lstAllModuls.requestFocus();
            lstAllModuls.getStyleClass().add("invalid");
            return;
        }


        if(contactCount == 0) {
            isValid = false;
            txtContact.requestFocus();
            txtContact.getStyleClass().add("invalid");
            return;
        }

        if(!isValidName(txtName.getText())){
            txtName.requestFocus();
            txtName.selectAll();
            txtName.getStyleClass().add("invalid");
            isValid =false;
            return;
        }

        if(!isValid) return;

        String name = txtName.getText();
        String studentID = txtId.getText();

        String[] mod = new String[moduleCount];
        for (int i = 0; i < moduleCount; i++) {
            mod[i] = lstSelectedModules.getItems().get(i);
        }

        String[] cont = new String[contactCount];
        for (int i = 0; i < contactCount; i++) {
            cont[i] = lstContacts.getItems().get(i);
        }

        Student student = new Student(studentID,name, cont, mod);
        System.out.println(student);
        lstStudents.getItems().add(student);

        id++;

        moduleCount = 0;
        contactCount = 0;

        if(id<1000) idString = String.format("%03d",id);
        else if (id>1000) idString = String.format("%s",id);
        txtId.setText(idString);

        txtName.clear();
        txtContact.clear();
        lstContacts.getItems().clear();
        lstSelectedModules.getItems().clear();

        lstAllModuls.getSelectionModel().clearSelection();

        txtId.setText(idString);
        txtName.requestFocus();

        lstAllModuls.getItems().clear();
        ObservableList<String> modules = lstAllModuls.getItems();
        modules.addAll("JavaFx","Angular","AI","React","ReactJs");

    }

    public boolean isValidName(String name){
        if(name.isBlank()) return false;
        for(char c : name.toCharArray()){
            if(Character.isDigit(c)) return false;
        }
        isValid =true;
        return true;
    }

    public boolean isValidContact(String number){
        if((number.length() != 11 || number.charAt(3) != '-' || number.isBlank())) return false;
        for (String numberInLst :  lstContacts.getItems()){
            if(number.equals(numberInLst)) return false;
        }

        int i = 0;
        for (char c : number.toCharArray()){
            if(i == 3) continue;

            if(!Character.isDigit(c)) return false;
            i++;
        }
        isValid = true;
        return true;
    }

    @FXML
    void btnSelectedToAllModulesOnAction(ActionEvent event) {
        int index = lstSelectedModules.getSelectionModel().getSelectedIndex();
        if(index == -1) return;

        lstAllModuls.getItems().add(lstSelectedModules.getSelectionModel().getSelectedItem());
        lstSelectedModules.getItems().remove(index);
        btnSelectedToAllModules.setDisable(true);
        lstAllModuls.getSelectionModel().clearSelection();
        moduleCount--;

    }

    public void btnAddOnAction(ActionEvent actionEvent) {

        if(!isValidContact(txtContact.getText())){
            txtContact.requestFocus();
            txtContact.selectAll();
            txtContact.getStyleClass().add("invalid");
            return;
        }

        txtContact.getStyleClass().remove("invalid");
        String number =  txtContact.getText();

        ObservableList<String> numbers = lstContacts.getItems();
        numbers.add(number);

        lstContacts.getSelectionModel().clearSelection();

        txtContact.clear();
        txtContact.requestFocus();

        contactCount++;

    }

    public void btnRemove(ActionEvent actionEvent) {
        int index = lstContacts.getSelectionModel().getSelectedIndex();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete " + lstContacts.getSelectionModel().getSelectedItem(), ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> canDelete = alert.showAndWait();

        if(canDelete.isEmpty() || canDelete.get() == ButtonType.NO) return;

        if(canDelete.get() == ButtonType.YES) {
            lstContacts.getItems().remove(index);

            lstContacts.getSelectionModel().clearSelection();

            btnRemove.setDisable(true);
            txtContact.requestFocus();

            contactCount--;
        }



    }
}
