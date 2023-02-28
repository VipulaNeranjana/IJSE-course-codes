package lk.ijse.dep10.serialization.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import lk.ijse.dep10.serialization.model.inherit1.D;

import java.io.*;

public class InheritanceViewController {

    @FXML
    private Button btnDeserialize;

    @FXML
    private Button btnSerialize;

    private File file1 = new File("file1.dep10");

    @FXML
    void btnDeserializeOnAction(ActionEvent event) throws IOException {

        try {
            FileInputStream fileInputStream = new FileInputStream(file1);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            D instance = (D) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println(instance);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    void btnSerializeOnAction(ActionEvent event) {
        D instance = new D(50, 60, 70, 80);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file1);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(instance);
            System.out.println("serialization done");

            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
