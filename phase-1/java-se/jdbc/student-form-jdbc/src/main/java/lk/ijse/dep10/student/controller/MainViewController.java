package lk.ijse.dep10.student.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dep10.student.enumaration.Gender;
import lk.ijse.dep10.student.model.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MainViewController {

    @FXML
    private Button btnNewStudent;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnSave;

    @FXML
    private ComboBox<Gender> cmbGender;

    @FXML
    private DatePicker dpBirthDate;

    @FXML
    private TableView<Student> tblStudent;

    @FXML
    private TextField txtAdress;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtSecondName;
    ArrayList<Student> studentList;

    private boolean isValid;

    public void initialize() {
        ObservableList<Gender> genderList = FXCollections.observableArrayList();
        genderList.addAll(Gender.MALE, Gender.FEMALE);
        cmbGender.setItems(genderList);

        tblStudent.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            btnRemove.setDisable(current == null);
            if(current == null) return;

            btnNewStudent.fire();

            txtId.setText(String.valueOf(current.getId()));
            txtFirstName.setText(current.getFirst_name());
            txtSecondName.setText(current.getSecond_name());
            txtAdress.setText(current.getAddress());
            cmbGender.setValue(Gender.valueOf(current.getGender()));
            dpBirthDate.setValue(LocalDate.parse(current.getDob()));


        });

        studentList = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://dep10.lk:3306/dep10_hello", "root", "2273349@P");
            String sql = "SELECT * FROM Students";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String second_name = resultSet.getString("second_name");
                String address = resultSet.getString("address");
                String gender = resultSet.getString("gender");
                String dob = resultSet.getString("dob");

                Student student = new Student(id, firstName, second_name, address, gender, dob);
                System.out.println(id + firstName + second_name + address + gender + dob);
                studentList.add(student);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        tblStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("first_name"));
        tblStudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("second_name"));
        tblStudent.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblStudent.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("gender"));
        tblStudent.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("dob"));

        tblStudent.getItems().addAll(studentList);

    }

    @FXML
    void btnNewStudentOnAction(ActionEvent event) {
        txtId.clear();
        int oldId = tblStudent.getItems().get(tblStudent.getItems().size() - 1).getId();
        txtId.setText(String.valueOf(oldId+1));

        txtId.setDisable(false);
        txtFirstName.setDisable(false);
        txtSecondName.setDisable(false);
        txtAdress.setDisable(false);
        cmbGender.setDisable(false);
        dpBirthDate.setDisable(false);
        btnSave.setDisable(false);
        btnRemove.setDisable(false);


        txtFirstName.clear();
        txtSecondName.clear();
        txtAdress.clear();
        cmbGender.setValue(null);
        dpBirthDate.setValue(null);
    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        Student selectedStudent = tblStudent.getSelectionModel().getSelectedItem();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DELETE FROM Students WHERE id=").append(selectedStudent.getId());

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://dep10.lk:3306/dep10_hello","root","2273349@P");
            Statement statement = connection.createStatement();
            statement.executeUpdate(stringBuilder.toString());
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        tblStudent.getItems().remove(selectedStudent);
        tblStudent.refresh();

        tblStudent.getSelectionModel().clearSelection();

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        isValid = true;
        if (!isValidDob()) {
            dpBirthDate.requestFocus();
            isValid = false;
        }

        if (!isGenderSelected()) {
            cmbGender.requestFocus();
            isValid = false;
        }

        if (!isValidAddress(txtAdress.getText())) {
            txtAdress.requestFocus();
            txtAdress.selectAll();
            isValid = false;
        }

        if (!isValidName(txtSecondName.getText())) {
            txtSecondName.requestFocus();
            txtSecondName.selectAll();
            isValid = false;
        }

        if (!isValidName(txtFirstName.getText())) {
            txtFirstName.requestFocus();
            txtFirstName.selectAll();
            isValid = false;
        }

        if(!isValid) return;

        Student student = new Student(Integer.parseInt(txtId.getText()), txtFirstName.getText(), txtSecondName.getText(), txtAdress.getText(), String.valueOf(cmbGender.getSelectionModel().getSelectedItem()), String.valueOf(dpBirthDate.getValue()));
        StringBuilder stringBuilder = new StringBuilder();
        if(tblStudent.getSelectionModel().getSelectedItem() == null){
            stringBuilder.append("INSERT INTO Students VALUES ")
                    .append("("+ student.getId())
                    .append(",").append("'")
                    .append(student.getFirst_name()).append("'").append(",").append("'")
                    .append(student.getSecond_name()).append("'").append(",").append("'")
                    .append(student.getAddress()).append("'").append(",").append("'")
                    .append(student.getGender()).append("'").append(",").append("'")
                    .append(student.getDob()).append("'").append(")");
        }

        else {
            stringBuilder.append("UPDATE Students SET ")
                    .append("first_name=").append("'"+student.getFirst_name()+"',")
                    .append("second_name=").append("'"+student.getSecond_name()+"',")
                    .append("address=").append("'"+student.getAddress()+"',")
                    .append("gender=").append("'"+student.getGender()+"',")
                    .append("dob=").append("'"+student.getDob()+"' WHERE id=").append(student.getId());
        }
        System.out.println(stringBuilder.toString());

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://dep10.lk:3306/dep10_hello","root","2273349@P");
            Statement statement = connection.createStatement();
            int effectedRows = statement.executeUpdate(stringBuilder.toString());

            System.out.println(effectedRows);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        if(tblStudent.getSelectionModel().getSelectedItem() != null){
            tblStudent.getItems().remove(tblStudent.getSelectionModel().getSelectedItem());
            tblStudent.getSelectionModel().clearSelection();
        }

        tblStudent.getItems().add(student);
        tblStudent.refresh();

        txtId.clear();
        txtFirstName.clear();
        txtSecondName.clear();
        txtAdress.clear();
        cmbGender.setValue(null);
        dpBirthDate.setValue(null);


    }

    private boolean isValidName(String name) {
        return name.matches("[a-z A-Z]{3,}");
    }

    private boolean isValidAddress(String name) {
        return name.matches("[a-z A-Z]{3,}");
    }

    private boolean isGenderSelected() {
        if (cmbGender.getSelectionModel().getSelectedItem() == null) return false;
        return true;
    }

    private boolean isValidDob() {
        LocalDate date = dpBirthDate.getValue();
        if (String.valueOf(date.getYear()).matches("19[8|9]\\d{1}|200[0-9]")) return true;
        return false;
    }


}
