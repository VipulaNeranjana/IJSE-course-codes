package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

public class ListViewSceneController {

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

    public void initialize(){
        lstNames.getSelectionModel().selectedItemProperty().addListener((value, previousValue, currentValue) -> {
//            System.out.println(currentValue);
            lblSelectedName.setText("selected name is : " + currentValue);
            btnRemove.setDisable(false);
        });
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String input = textInput.getText();
        if(input.isBlank()) {
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
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure to delete "+selectedName+" ???");
        alert.setTitle("delete name");

        Optional<ButtonType> button = alert.showAndWait();
        if(button.isEmpty()) return;
        if(button.get() == ButtonType.OK){
            int selectedIndex = lstNames.getSelectionModel().getSelectedIndex();
            System.out.println(selectedIndex);
            lstNames.getItems().remove(selectedIndex);
            lstNames.refresh();
            lstNames.getSelectionModel().clearSelection();
            lblSelectedName.setText(selectedName +" removed");
            textInput.requestFocus();

        }

    }

}
