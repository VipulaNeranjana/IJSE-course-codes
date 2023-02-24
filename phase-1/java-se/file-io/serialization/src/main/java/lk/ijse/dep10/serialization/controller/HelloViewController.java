package lk.ijse.dep10.serialization.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lk.ijse.dep10.serialization.model.Student;

import java.io.*;

public class HelloViewController {

    @FXML
    private Button btnSave;

    @FXML
    private TextField txtAdress;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;

    private File file = new File(new File(System.getProperty("user.home")), "Desktop");
    private File studentFile = new File(file, "student.dep");
    public void initialize(){
        if(!studentFile.exists())return;


        try {
            FileInputStream fileInputStream = new FileInputStream(studentFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Student student = (Student)objectInputStream.readObject();

            txtID.setText(student.id);
            txtName.setText(student.name);
            txtAdress.setText(student.address);

            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        Student student = new Student(txtID.getText(), txtName.getText(), txtAdress.getText());

        System.out.println(studentFile.exists());


        try {
            FileOutputStream fileOutputStream = new FileOutputStream(studentFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(student);
            objectOutputStream.close();

            new Alert(Alert.AlertType.INFORMATION,"Saved").show();
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"failed to save the student , try again").show();
        }
    }

}
