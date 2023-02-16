package controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SettingViewControll {

    @FXML
    private Button btnApply;

    @FXML
    private Label lblTitle;

    @FXML
    private TextField txtTitle;
    private SimpleStringProperty observable;

    public void initData(SimpleStringProperty title){    //should be void ---------------------------------------------------------------------------
        observable = title;
        txtTitle.setText(title.getValue());
    }

    @FXML
    void btnApplyOnAction(ActionEvent event) {

        observable.setValue(txtTitle.getText());
    }

}
