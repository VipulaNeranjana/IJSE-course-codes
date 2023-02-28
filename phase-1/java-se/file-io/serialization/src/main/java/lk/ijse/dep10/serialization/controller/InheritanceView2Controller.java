package lk.ijse.dep10.serialization.controller;

import javafx.event.ActionEvent;
import lk.ijse.dep10.serialization.model.inherit2.D;

import java.io.*;

public class InheritanceView2Controller {
    private File file2 = new File("file2.dep10");
    public void btnSerializeOnAction(ActionEvent actionEvent) {
        D instance = new D(50, 60, 70, 80);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(instance);
            System.out.println("serialization done");

            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnDeserializeOnAction(ActionEvent actionEvent) {


        try {
            FileInputStream fileInputStream = new FileInputStream(file2);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            D instance = (D) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println(instance);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
