package lk.ijse.dep10.controls;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dep10.model.Item;

import java.math.BigDecimal;

public class MainFormController {

    public Label lblTotalProfit;
    @FXML
    private Button btnNew;

    @FXML
    private Button btnSave;

    @FXML
    private TableView<Item> tblItems;

    @FXML
    private TextField txtBuyingPrice;

    @FXML
    private TextField txtCode;

    @FXML
    private TextField txtDiscription;

    @FXML
    private TextField txtQuantity;

    @FXML
    private TextField txtSellingPrice;

    public void initialize(){
        tblItems.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("code"));
        tblItems.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblItems.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("buyingPrice"));
        tblItems.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("SellingPrice"));
        tblItems.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tblItems.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("total"));
        tblItems.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("estimatedTotalPrice"));

        btnNew.fire();

    }

    @FXML
    void btnNewOnAction(ActionEvent event) {

        txtQuantity.clear();
        txtBuyingPrice.clear();
        txtSellingPrice.clear();
        txtDiscription.clear();

        txtDiscription.requestFocus();

        tblItems.getSelectionModel().clearSelection();

        txtCode.setText(generateItem());




    }

    private void calculateTotal(){
        BigDecimal bigDecimal = BigDecimal.ZERO;
        for (Item item : tblItems.getItems()) {
            bigDecimal = bigDecimal.add(item.getEstimatedTotalPrice());
        }

         lblTotalProfit.setText("Estimated total : "+bigDecimal.toString());
    }

    private String generateItem(){
        ObservableList<Item> items = tblItems.getItems();

        if(items.isEmpty()) return "I001";

        String lastItemCode = items.get(items.size() - 1).getCode();
        int nextCode = Integer.parseInt(lastItemCode.substring(1)) + 1;

        return String.format("I%03d",nextCode);

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        if (tblItems.getSelectionModel().isEmpty()) {
            Item item = new Item(
                    txtCode.getText(),
                    txtDiscription.getText(),
                    new BigDecimal(txtBuyingPrice.getText()),
                    new BigDecimal(txtSellingPrice.getText()),
                    txtQuantity.getText());

            ObservableList<Item> items = tblItems.getItems();
            items.add(item);

            calculateTotal();

        }

        btnNew.fire();

    }

}
