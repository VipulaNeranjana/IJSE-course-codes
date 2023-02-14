package lk.ijse.dep10.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import lk.ijse.dep10.util.util.DynamicArray;

import java.util.Arrays;
import java.util.Optional;

public class MainFormController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnContains;

    @FXML
    private Button btnPrint;

    @FXML
    private Button btnPrintAll;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnSize;

    @FXML
    private TextField number;

    private DynamicArray numbers = new DynamicArray();

    @FXML
    void btnAddOnAction(ActionEvent event) {

        String value = number.getText();
        numbers.add(value);
        number.clear();
        number.requestFocus();
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        numbers.clear();
    }

    @FXML
    void btnContainsOnAction(ActionEvent event) {
        TextInputDialog prompt = new TextInputDialog("Enter value :");
        Optional<String> optInout = prompt.showAndWait();
        if(optInout.isEmpty() || optInout.get().isBlank()) return;

        String value = optInout.get();

        System.out.println(numbers.contains(value));
    }

    @FXML
    void btnPrintAllOnAction(ActionEvent event) {
        System.out.println(numbers);
    }

    @FXML
    void btnPrintOnAction(ActionEvent event) {

        TextInputDialog prompt = new TextInputDialog("Enter something :");
        Optional<String> optInout = prompt.showAndWait();
        System.out.println(optInout.isEmpty());
        if(optInout.isEmpty() || optInout.get().isBlank()) return;

        int index = Integer.parseInt(optInout.get());

        if(index < 0 || numbers.size() <= index) {
            System.err.println("Invalid index");
            return;
        }
        System.out.println(numbers.get(index));
    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        TextInputDialog prompt = new TextInputDialog("Enter to remove :");
        Optional<String> optInout = prompt.showAndWait();
        if(optInout.isEmpty() || optInout.get().isBlank()) return;

//        int index = (numbers.indexOf(optInout.get()));         // to dlt by number

        int index = Integer.parseInt(optInout.get());

        if(index < 0 || numbers.size() <= index) {
            System.err.println("Invalid index");
            return;
        }
        numbers.remove(index);
    }

    @FXML
    void btnSizeOnAction(ActionEvent event) {
        System.out.println("size: " + numbers.size());
    }

    @FXML
    void numberOnAction(ActionEvent event) {

    }

}
