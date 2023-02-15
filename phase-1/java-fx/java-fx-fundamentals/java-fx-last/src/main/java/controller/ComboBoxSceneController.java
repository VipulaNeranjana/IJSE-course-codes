package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ComboBoxSceneController {

    @FXML
    private Button btnAdd;

    @FXML
    private ComboBox<String> cmbSomething;

    @FXML
    private Label lblOutput;

    @FXML
    private TextField txtInput;

    public void initialize(){
        ObservableList<String> itemList = cmbSomething.getItems();
        itemList.addAll("kasun","nuwan","vipula");

        cmbSomething.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            if(current ==null){
                lblOutput.setText("select something to display".toUpperCase());
            }
            else {
                lblOutput.setText(("selected : "+ current).toUpperCase());
            }
        });
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        if(txtInput.getText().isEmpty())return;
        ObservableList<String> items = cmbSomething.getItems();
        items.add(txtInput.getText().strip());
        txtInput.requestFocus();
        txtInput.clear();
    }

}
