package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import model.Modules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class MainFormController {

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
    private ListView<?> lstContact;

    @FXML
    private ListView<?> lstModule;

    @FXML
    private ListView<?> lstSelectedModule;

    @FXML
    private ListView<?> lstStudent;

    @FXML
    private RadioButton rdoFemale;

    @FXML
    private RadioButton rdoMale;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtName;


    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnBackOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnForwordOnAction(ActionEvent event) {

    }

    @FXML
    void btnNewStudentOnAction(ActionEvent event) {


        lblGender.setTextFill(Color.BLACK);
        txtContact.getStyleClass().remove("invalid");
        txtName.getStyleClass().remove("invalid");
        lstContact.getStyleClass().remove("invalid");
        lstSelectedModule.getStyleClass().remove("invalid");


        txtName.setDisable(false);
        txtContact.setDisable(false);
        btnAdd.setDisable(false);
        rdoMale.setDisable(false);
        rdoFemale.setDisable(false);
        btnSave.setDisable(false);

        lstStudent.getSelectionModel().clearSelection();
        lstContact.getSelectionModel().clearSelection();
        lstSelectedModule.getSelectionModel().clearSelection();

        txtName.clear();
        txtContact.clear();
        rdoMale.getToggleGroup().selectToggle(null);

        lstSelectedModule.getItems().clear();

        ArrayList<String> seSubjects = new ArrayList<>(Arrays.asList("java", "angular", "react"));
        Modules se = new Modules("SE", seSubjects);

        ArrayList<String> meSubjects = new ArrayList<>(Arrays.asList("manufacturing", "thermodynamics", "fluid"));
        Modules me = new Modules("ME", meSubjects);

        ObservableList<Modules> degreeList = cmbDegree.getItems();
        degreeList.clear();
        degreeList.addAll(se,me);



    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    @FXML
    void lstStudentOnAction(ActionEvent event) {

    }

    @FXML
    void txtContactOnAction(ActionEvent event) {

    }

}
