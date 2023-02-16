package controller;

import Model.StudentInfo;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import util.Gender;

import java.util.ArrayList;
import java.util.Optional;

public class ListExViewController {

    public Label lblGender;
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDlelete;

    @FXML
    private Button btnForword;

    @FXML
    private Button btnNewStudent;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnSave;

    @FXML
    private ToggleGroup gender;

    @FXML
    private ListView<String> lstContact;

    @FXML
    private ListView<String> lstModules;

    @FXML
    private ListView<String> lstSelectedModule;

    @FXML
    private ListView<StudentInfo> lstStudent;

    @FXML
    private RadioButton rdoFemale;

    @FXML
    private RadioButton rdoMale;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    public void initialize(){
        lstModules.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lstSelectedModule.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        txtName.textProperty().addListener((value, previous, current) -> {
            System.out.println(value);
            txtName.getStyleClass().remove("invalid");

            for(char c : current.toCharArray()){
                if(!(Character.isLetter(c) || Character.isSpaceChar(c))){
                    txtName.getStyleClass().add("invalid");
                    return;
                }
            }
        });
        txtContact.textProperty().addListener((value,previous,current) -> {
            btnAdd.setDisable(false);
            txtContact.getStyleClass().remove("invalid");
            char[] chars = current.toCharArray();
            if(chars.length>11) {
                txtContact.getStyleClass().add("invalid");
                btnAdd.setDisable(true);
                return;
            }
            for (int i = 0; i < chars.length; i++) {
                if(i == 3 ){
                    if(!(chars[i]=='-')){
                        txtContact.getStyleClass().add("invalid");
                        btnAdd.setDisable(true);
                        return;
                    }
                    continue;
                }
                if(!(Character.isDigit(chars[i]))){
                    txtContact.getStyleClass().add("invalid");
                    btnAdd.setDisable(true);
                    return;
                }

            }
        });
        lstContact.getSelectionModel().selectedItemProperty().addListener(((value, previous, current) -> {
            btnRemove.setDisable(current == null);
        }));

        lstModules.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            btnForword.setDisable(current == null);
        });
        lstSelectedModule.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            btnBack.setDisable(current == null);
        });

        lstStudent.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            btnDlelete.setDisable(current == null);

            if(current == null) return;

            txtId.setText(current.id);
            txtName.setText(current.name);
            if(current.gender == Gender.MALE){
                rdoMale.getToggleGroup().selectToggle(rdoMale);
            }
            if(current.gender == Gender.FEMALE){
                rdoFemale.getToggleGroup().selectToggle(rdoFemale);
            }
            txtContact.clear();
            lstContact.getItems().clear();
            lstContact.getItems().addAll(current.contacts);
            lstSelectedModule.getItems().clear();
            lstSelectedModule.getItems().addAll(current.modules);

            ObservableList<String> moduleList = lstModules.getItems();
            moduleList.clear();
            moduleList.addAll("Object Oriented Programming", "Programming Fundamentals","Mongo DB","REACT","Database Management System","Docker","Angular");

            lstModules.getItems().removeAll(current.modules);
        });

    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        if(txtContact.getText().length()  < 11) {
            txtContact.getStyleClass().add("invalid");
            return;
        }

        String contact = txtContact.getText();
        ObservableList<String> contactList = lstContact.getItems();
        for(String c : contactList){
            if(contact.equals(c)) {
                txtContact.getStyleClass().add("invalid");
                return;
            }
        }

        lstContact.getSelectionModel().clearSelection();

        contactList.add(contact.strip());
        txtContact.clear();
        txtContact.requestFocus();

    }

    @FXML
    void btnBackOnAction(ActionEvent event) {

        ObservableList<String> selectedModules = lstSelectedModule.getItems();
        ObservableList<String> modules = lstModules.getItems();
        modules.addAll(lstSelectedModule.getSelectionModel().getSelectedItems());
        selectedModules.removeAll(lstSelectedModule.getSelectionModel().getSelectedItems());

        lstSelectedModule.getSelectionModel().clearSelection();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();

        if(buttonType.isEmpty() || buttonType.get() == ButtonType.NO) return;

        lstStudent.getItems().remove(lstStudent.getSelectionModel().getSelectedItem());
    }

    @FXML
    void btnForwordOnAction(ActionEvent event) {

        ObservableList<String> selectedItems = lstSelectedModule.getItems();
        selectedItems.addAll(lstModules.getSelectionModel().getSelectedItems());
        lstModules.getItems().removeAll(lstModules.getSelectionModel().getSelectedItems());

        lstModules.getSelectionModel().clearSelection();
        lstSelectedModule.getStyleClass().remove("invalid");
    }

    @FXML
    void btnNewStudentOnAction(ActionEvent event) {
        txtId.setText(generateNewStudentId());     //--------------------------------------

        lblGender.setTextFill(Color.BLACK);
        txtContact.getStyleClass().remove("invalid");
        txtName.getStyleClass().remove("invalid");
        lstContact.getStyleClass().remove("invalid");
        lstSelectedModule.getStyleClass().remove("invalid");


        txtId.setDisable(false);
        txtName.setDisable(false);
        txtContact.setDisable(false);
        btnAdd.setDisable(false);
        rdoMale.setDisable(false);
        rdoFemale.setDisable(false);
        btnSave.setDisable(false);

        lstStudent.getSelectionModel().clearSelection();

        txtName.clear();
        txtContact.clear();
        rdoFemale.getToggleGroup().selectToggle(null);

        ObservableList<String> moduleList = lstModules.getItems();  //-----------------------------------
        moduleList.clear();
        moduleList.addAll("Object Oriented Programming", "Programming Fundamentals","Mongo DB","REACT","Database Management System","Docker","Angular");

        ObservableList<String> contactList = lstContact.getItems();
        contactList.clear();

        ObservableList<String> selectedModules = lstSelectedModule.getItems();
        selectedModules.clear();

        txtName.requestFocus();

    }

    private String generateNewStudentId() {
        ObservableList<StudentInfo> studentList = lstStudent.getItems();

        if ((studentList.isEmpty())) return "S001";
        String lastStudentId = studentList.get(studentList.size() - 1).id;
        int newId = Integer.parseInt(lastStudentId.substring(1)) + 1;
        return  String.format("S%03d",newId);
    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {

        ObservableList<String> contactList = lstContact.getItems();
        contactList.remove(lstContact.getSelectionModel().getSelectedItem());
        lstContact.getSelectionModel().clearSelection();
        txtContact.requestFocus();

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        boolean isValid = true;
        lblGender.setTextFill(Color.BLACK);
        lstContact.getStyleClass().remove("invalid");
        lstSelectedModule.getStyleClass().remove("invalid");

        String name = txtName.getText();
        String contact = txtContact.getText();

        if(lstSelectedModule.getItems().size() < 3){
            isValid = false;
            lstModules.getStyleClass().add("invalid");
            lstModules.requestFocus();
        }

        if(lstContact.getItems().isEmpty()){
            isValid =false;
            lstContact.getStyleClass().add("invalid");
            txtContact.selectAll();
            txtContact.requestFocus();
        }

        if(rdoMale.getToggleGroup().getSelectedToggle() == null){
            isValid = false;
            rdoMale.requestFocus();
            lblGender.setTextFill(Color.RED);
        }

        if(name.isEmpty() || txtName.getStyleClass().contains("invalid")){
            new Alert(Alert.AlertType.ERROR,"Name is invalid or empty").show();
            isValid =false;
            if(!txtName.getStyleClass().contains("invalid")) txtName.getStyleClass().add("invalid");

            txtName.selectAll();
            txtName.requestFocus();
        }

        if(!isValid) return;

        StudentInfo selectedStudent = lstStudent.getSelectionModel().getSelectedItem();

        ObservableList<StudentInfo> studentList = lstStudent.getItems();
        for(StudentInfo student : studentList){
            for(String number : student.contacts){

                if(student == selectedStudent) continue;

                if(isDuplicate(contact)){
                    new Alert(Alert.AlertType.ERROR, String.format("the %s number already exist", contact)).showAndWait();
                    lstContact.getStyleClass().add("invalid");
                    lstContact.requestFocus();
                    return;
                }
            }
        }

        if(selectedStudent == null){
            StudentInfo student = new StudentInfo(txtId.getText(), txtName.getText(), rdoMale.isSelected() ? Gender.MALE : Gender.FEMALE, new ArrayList<>(lstContact.getItems()), new ArrayList<>(lstSelectedModule.getItems()));
            studentList.add(student);

        }
        else {
            selectedStudent.name =  txtName.getText().strip();
            selectedStudent.gender = rdoMale.isSelected() ? Gender.MALE : Gender.FEMALE;
            selectedStudent.contacts.clear();
            selectedStudent.contacts.addAll(new ArrayList<>(lstContact.getItems()));
            selectedStudent.modules.clear();
            selectedStudent.modules.addAll(new ArrayList<>(lstSelectedModule.getItems()));

        }
        btnNewStudent.fire();
    }

    private boolean isDuplicate(String contact){
        for(String enteredContact : lstContact.getItems()){
            if(enteredContact.equals((contact))) return true;
        }
        return false;
    }

    @FXML
    void lstContactOnKeyRelesed(KeyEvent event) {
        if(event.getCode() == KeyCode.DELETE) btnRemove.fire();

    }

    @FXML
    void lstModulesOnKeyRelesed(KeyEvent event) {

        if(event.getCode() == KeyCode.ENTER) btnForword.fire();
    }

    @FXML
    void lstSelectedModulesOnKeyRelesed(KeyEvent event) {
        if(event.getCode() == KeyCode.DELETE) btnBack.fire();

    }

    @FXML
    void lstStudentOnKeyRelesed(KeyEvent event) {

    }

    @FXML
    void txtContactOnAction(ActionEvent event) {

        btnAdd.fire();

    }

}
