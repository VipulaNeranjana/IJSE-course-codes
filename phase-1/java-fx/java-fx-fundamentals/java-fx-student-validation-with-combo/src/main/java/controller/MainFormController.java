package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import model.Modules;
import model.Student;
import util.Gender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;


public class MainFormController {

    public TableView<Student> tblStudent;
    public ToggleGroup gender;
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnForword;

    @FXML
    private Button btnNewStudent;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnSave;

    @FXML
    private CheckBox chkPartTime;

    @FXML
    private ComboBox<Modules> cmbDegree;

    @FXML
    private Label lblGender;

    @FXML
    private Label lblId;

    @FXML
    private ListView<String> lstContact;

    @FXML
    private ListView<String> lstModule;

    @FXML
    private ListView<String> lstSelectedModule;


    @FXML
    private RadioButton rdoFemale;

    @FXML
    private RadioButton rdoMale;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtName;

    private boolean isPartTimer;

    private boolean isNameValid;

    private boolean isContactValid;

    private boolean isValid;

    private int idSE = 0;
    private int idME = 0;
    public void initialize(){
        lstModule.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lstSelectedModule.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        lstSelectedModule.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            btnBack.setDisable(current == null);
        });

        lstModule.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            btnForword.setDisable(current == null);

        });

        cmbDegree.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            if(current == null) return;

            lstModule.getItems().clear();      //-----------------------------------------------------------------
            lstModule.getItems().addAll(current.subjects);
            lstSelectedModule.getItems().clear();
            tblStudent.refresh();
        });

        tblStudent.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            btnDelete.setDisable(current == null);

            if(current == null) return;


            txtContact.clear();
            lstModule.getItems().clear();
            lstContact.getItems().clear();
            lstSelectedModule.getItems().clear();

            System.out.println(current.getContact());
            System.out.println(current.getSelectedModules());
            lblId.setText(current.getId());

            txtName.setText(current.getName());
            lstSelectedModule.getItems().addAll(new ArrayList<>(current.getSelectedModules()));
            lstContact.getItems().addAll(current.getContact());

            if(current.moduleName.equals("ME")){
                ArrayList<String> meSubjects = new ArrayList<>(Arrays.asList("manufacturing", "thermodynamics", "fluid"));
                Modules me = new Modules("ME", meSubjects);

                lstModule.getItems().addAll(me.subjects);
                lstModule.getItems().removeAll(current.selectedModules);
            }
            if(current.moduleName.equals("SE")){
                ArrayList<String> seSubjects = new ArrayList<>(Arrays.asList("java", "angular", "react"));
                Modules se = new Modules("SE", seSubjects);

                lstModule.getItems().addAll(se.subjects);
                lstModule.getItems().removeAll(current.selectedModules);
            }


            if(current.gender == Gender.MALE) rdoMale.getToggleGroup().selectToggle(rdoMale);
            if(current.gender == Gender.FEMALE) rdoFemale.getToggleGroup().selectToggle(rdoFemale);

            lstSelectedModule.refresh();
            lstContact.refresh();
        });

        lstContact.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            btnRemove.setDisable(current == null);
        });

        txtName.textProperty().addListener((value, previous, current) -> {
            isNameValid = true;
            for (char c : current.toCharArray()) {
                if(!(Character.isSpaceChar(c) || Character.isLetter(c))) {
                    isNameValid =false;
                    if(txtName.getStyleClass().contains("invalid")) return;

                    txtName.getStyleClass().add("invalid");
                    return;
                }
            }
            txtName.getStyleClass().remove("invalid");
        });

        txtContact.textProperty().addListener((value,previous,current) -> {
            isContactValid =true;
            char[] numbers = current.toCharArray();
            for (int i = 0; i < current.length(); i++) {
                if((i == 3)){
                    if(!(numbers[i]=='-')){
                        isContactValid = false;
                        if(txtContact.getStyleClass().contains("invalid")) return;

                        txtContact.getStyleClass().add("invalid");
                        return;
                    }
                    else {
                        isContactValid =true;
                        continue;
                    }
                }

                if(!Character.isDigit(numbers[i])){
                    isContactValid = false;
                    if(txtContact.getStyleClass().contains("invalid")) return;

                    txtContact.getStyleClass().add("invalid");
                    return;
                }
            }
            txtContact.getStyleClass().remove("invalid");
        });
    }


    @FXML
    void btnAddOnAction(ActionEvent event) {

        if(!isContactValid || txtContact.getText().strip().length() != 11){
            isValid = false;
            txtContact.selectAll();
            txtContact.requestFocus();
            if(txtContact.getStyleClass().contains("invalid")) {
                return;
            }
            txtContact.getStyleClass().add("invalid");
            return;
        }

        lstContact.getItems().add(txtContact.getText());
        txtContact.clear();
        txtContact.requestFocus();

    }

    @FXML
    void btnBackOnAction(ActionEvent event) {

        ObservableList<String> selectedItems = lstSelectedModule.getSelectionModel().getSelectedItems();
        if(selectedItems == null) return;
        lstModule.getItems().addAll(selectedItems);
        lstSelectedModule.getItems().removeAll(selectedItems);
        lstSelectedModule.getSelectionModel().clearSelection();
        btnBack.setDisable(true);

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Student student = tblStudent.getSelectionModel().getSelectedItem();
        Optional<ButtonType> conformation = new Alert(Alert.AlertType.CONFIRMATION, "Are You sure to delete" + student.id, ButtonType.YES, ButtonType.NO).showAndWait();
        if(conformation.isEmpty() || conformation.get() == ButtonType.NO){
            return;
        }
        tblStudent.getItems().remove(student);
        btnNewStudent.fire();
    }

    @FXML
    void btnForwordOnAction(ActionEvent event) {

        ObservableList<String> selectedItems = lstModule.getSelectionModel().getSelectedItems();

        if(selectedItems == null) return;
        else {
            lstSelectedModule.getItems().addAll(selectedItems);
            lstModule.getItems().removeAll(selectedItems);
            lstModule.getSelectionModel().clearSelection();
            btnForword.setDisable(true);
        }
    }

    @FXML
    void btnNewStudentOnAction(ActionEvent event) {


        lblGender.setTextFill(Color.BLACK);
        txtContact.getStyleClass().remove("invalid");
        txtName.getStyleClass().remove("invalid");
        lstContact.getStyleClass().remove("invalid");
        lstSelectedModule.getStyleClass().remove("invalid");
        lblGender.getStyleClass().remove("warning");


        txtName.setDisable(false);
        txtContact.setDisable(false);
        btnAdd.setDisable(false);
        rdoMale.setDisable(false);
        rdoFemale.setDisable(false);
        btnSave.setDisable(false);
        cmbDegree.setDisable(false);
//        btnForword.setDisable(false);
//        btnBack.setDisable(false);

        lstContact.getSelectionModel().clearSelection();
        lstSelectedModule.getSelectionModel().clearSelection();

        txtName.clear();
        txtContact.clear();
        lblId.setText("Generated ID");
        rdoMale.getToggleGroup().selectToggle(null);

//        lstSelectedModule.getItems().clear();
        lstModule.getItems().clear();
        lstSelectedModule.getItems().clear();
        lstContact.getItems().clear();
        tblStudent.refresh();

        ArrayList<String> seSubjects = new ArrayList<>(Arrays.asList("java", "angular", "react"));
        Modules se = new Modules("SE", seSubjects);

        ArrayList<String> meSubjects = new ArrayList<>(Arrays.asList("manufacturing", "thermodynamics", "fluid"));
        Modules me = new Modules("ME", meSubjects);

        ObservableList<Modules> degreeList = cmbDegree.getItems();
        degreeList.clear();
        degreeList.addAll(se,me);

        isPartTimer = chkPartTime.isSelected();



    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {

        String contact = lstContact.getSelectionModel().getSelectedItem();
        lstContact.getItems().remove(contact);
        lstContact.getSelectionModel().clearSelection();
        txtContact.requestFocus();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        isValid = true;

        String name = txtName.getText();
        String contact = txtContact.getText();
        isPartTimer = chkPartTime.isSelected();
        Modules value = cmbDegree.getSelectionModel().selectedItemProperty().getValue();


        ObservableList<String> selectedModules = lstSelectedModule.getItems();
        if(selectedModules.size() < 2){
            lstModule.requestFocus();
            lstModule.getStyleClass().add("invalid");
            return;
        }

        ObservableList<String> contacts = lstContact.getItems();
        if(contacts.isEmpty()){
            txtContact.requestFocus();
            txtContact.selectAll();
            txtContact.getStyleClass().add("invalid");
            return;
        }

        if((rdoMale.getToggleGroup().getSelectedToggle() == null)){
            lblGender.getStyleClass().add("warning");
            return;
        }

        if (!isNameValid) {
            txtName.requestFocus();
            txtName.selectAll();
            txtName.getStyleClass().add("invalid");
            return;
        }


        if(!isValid) return;

        ObservableList<String> contactList = FXCollections.observableArrayList(contacts);
        ObservableList<String> selectedModulesList = FXCollections.observableArrayList(selectedModules);

        Student selectedStudent = tblStudent.getSelectionModel().getSelectedItem();
        if(selectedStudent == null){

            String id = generatingId(value.moduleName);

            Student student = new Student(id, name, value.moduleName, rdoMale.isSelected() ? Gender.MALE : Gender.FEMALE, contactList, selectedModulesList, isPartTimer);

            tblStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
            tblStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
            tblStudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("moduleName"));

            tblStudent.getItems().addAll(student);

        }else {
            selectedStudent.setName(txtName.getText());
            selectedStudent.contact.clear();
            selectedStudent.contact.addAll(lstContact.getItems());
            selectedStudent.selectedModules.clear();
            selectedStudent.setSelectedModules(selectedModulesList);
            selectedStudent.setModuleName(value.moduleName);

            tblStudent.refresh();


        }



        btnNewStudent.fire();

    }

    private String generatingId(String name){
        if(name ==  null)  return  "Generated ID";
        if(name.equals("ME")){
            return String.format("ME%03d",idME++);
        }
        return String.format("SE%03d",idSE++);
    }




    @FXML
    void txtContactOnAction(ActionEvent event) {

    }

    public void tblStudenOnAction(SortEvent<TableView> tableViewSortEvent) {
    }
}
