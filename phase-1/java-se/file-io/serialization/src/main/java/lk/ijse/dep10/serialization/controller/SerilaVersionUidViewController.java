package lk.ijse.dep10.serialization.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import lk.ijse.dep10.serialization.model.Customer;

import java.io.*;

public class SerilaVersionUidViewController {

    @FXML
    private Button btnDeserialize;

    @FXML
    private Button btnSerilaize;

    private File file = new File("customer.dep10");
    @FXML
    void btnDeserializeOnAction(ActionEvent event) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Customer c001 = (Customer) objectInputStream.readObject();
//            System.out.println(c001);
            c001.print();
            objectInputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    void btnSerilaizeOnAction(ActionEvent event) {
        Customer c001 = new Customer("C001", "kasun","galle");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(c001);
            objectOutputStream.close();
            System.out.println("serialization done");
        }catch (Exception e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"something went wrong");
        }
    }

}
