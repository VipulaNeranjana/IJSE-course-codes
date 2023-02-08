package lk.ijse.dep10.student;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Arrays;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.centerOnScreen();
        primaryStage.show();
        studentForm(primaryStage);

    }

    public void studentForm(Stage stage){
        VBox vBox1 = new VBox();
        VBox vBox2 = new VBox();
        GridPane gridPane = new GridPane();
        AnchorPane anchorPane1 = new AnchorPane();
        AnchorPane anchorPane2 = new AnchorPane();
        AnchorPane anchorPane3 = new AnchorPane();
        AnchorPane anchorPane4 = new AnchorPane();
        Scene scene = new Scene(gridPane);

        Label title = new Label("Student Form");
        Label idLabel = new Label("id: ");
        Label nameLabel = new Label("name: ");
        Label nicLabel = new Label("nic: ");
        Label contactLabel = new Label("contact: ");
        Label idValidation = new Label("Id is not valid!");
        Label nameValidation = new Label("Name is not valid");
        Label nicValidation = new Label("nic is not valid!");
        Label contactValidation = new Label("contact is not valid!");

        TextField idText = new TextField();
        TextField nameText = new TextField();
        TextField nicText = new TextField();
        TextField contactText = new TextField();

        Button button = new Button("validate");
        button.setDefaultButton(true);
        contactText.setPromptText("Ex: XXX-XXXXXXX");

//        gridPane.setGridLinesVisible(true);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPrefWidth(100);
        gridPane.getColumnConstraints().add(column1);

        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(70);
        gridPane.getColumnConstraints().add(column2);

        RowConstraints row1 = new RowConstraints();
        row1.setMinHeight(40);
        gridPane.getRowConstraints().add(row1);

        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(15);
        gridPane.getRowConstraints().add(row2);

        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(10);
        gridPane.getRowConstraints().add(row3);

        RowConstraints row4 = new RowConstraints();
        row4.setPercentHeight(15);
        gridPane.getRowConstraints().add(row4);

        RowConstraints row5 = new RowConstraints();
        row5.setPercentHeight(10);
        gridPane.getRowConstraints().add(row5);

        RowConstraints row6 = new RowConstraints();
        row6.setPercentHeight(15);
        gridPane.getRowConstraints().add(row6);

        RowConstraints row7 = new RowConstraints();
        row7.setPercentHeight(10);
        gridPane.getRowConstraints().add(row7);

        RowConstraints row8 = new RowConstraints();
        row8.setPercentHeight(15);
        gridPane.getRowConstraints().add(row8);

        RowConstraints row9 = new RowConstraints();
        row9.setPercentHeight(10);
        gridPane.getRowConstraints().add(row9);


        GridPane.setHalignment(idLabel, HPos.RIGHT);
        GridPane.setHalignment(nameLabel, HPos.RIGHT);
        GridPane.setHalignment(nicLabel, HPos.RIGHT);
        GridPane.setHalignment(contactLabel, HPos.RIGHT);
        GridPane.setHalignment(title, HPos.CENTER);

        idValidation.setVisible(false);
        nameValidation.setVisible(false);
        nicValidation.setVisible(false);
        contactValidation.setVisible(false);
        idValidation.setTextFill(Color.ORANGERED);
        nameValidation.setTextFill(Color.ORANGERED);
        nicValidation.setTextFill(Color.ORANGERED);
        contactValidation.setTextFill(Color.ORANGERED);

        gridPane.setPadding(new Insets(60,10,60,10));
        gridPane.setAlignment(Pos.CENTER);
        title.setFont(new Font(30));
        title.setTextFill(Color.DARKBLUE);

        gridPane.setMinWidth(600);
        gridPane.setMinHeight(400);


        gridPane.add(title,0,0,2,1);
        gridPane.add(idLabel,0,1);
        gridPane.add(idText,1,1);
        gridPane.add(idValidation,1,2);
        gridPane.add(nameLabel,0,3);
        gridPane.add(nameText,1,3);
        gridPane.add(nameValidation,1,4);
        gridPane.add(nicLabel,0,5);
        gridPane.add(nicText,1,5);
        gridPane.add(nicValidation,1,6);
        gridPane.add(contactLabel,0,7);
        gridPane.add(contactText,1,7);
        gridPane.add(contactValidation,1,8);
        gridPane.add(button,1,9);

        button.setOnAction(actionEvent -> {
            boolean isIdValid = idValidation(idText.getText());
            boolean isNameValid = nameValidation(nameText.getText());
            boolean isNicValid = nicValidation(nicText.getText());
            boolean isContactValid = contactValidation(contactText.getText());

            idValidation.setVisible(!isIdValid);
            nameValidation.setVisible(!isNameValid);
            nicValidation.setVisible(!isNicValid);
            contactValidation.setVisible(!isContactValid);

            if(!isIdValid) idText.selectAll();
            if(!isNameValid) nameText.selectAll();
            if(!isNicValid) nicText.selectAll();
            if(!isContactValid) contactText.selectAll();

            if(isContactValid && isIdValid && isNameValid && isNicValid){
                successScene(stage);
            }
        });

        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public boolean idValidation(String id){
        char[] idChar = id.toCharArray();
        System.out.println(id);
        boolean isValid = false;
        if(idChar.length == 4 && idChar[0] == 'S' ){
            for (int i = 1; i < idChar.length ; i++) {
                if(!Character.isDigit(idChar[i])){
                    isValid = false;
                    break;
                }
                isValid = true;
            }
        }
        return isValid;
    }
    public boolean nameValidation(String name){
        if(name.length() == 0 ) return false;
        return true;
    }
    public boolean nicValidation(String nic){
        char[] nicChar = nic.toCharArray();
        boolean isValid = false;
        if(nicChar.length != 10 ) return isValid;
        if(!(nicChar[9] == 'v' || nicChar[9] == 'V' )) return isValid;

        for (int i = 0; i < nicChar.length-1; i++) {

            if(!Character.isDigit(nicChar[i])) {
                isValid = false;
                return isValid;
            }
            isValid = true;
        }
        return isValid;
    }
    public boolean contactValidation(String contact){
        char[] contactChar = contact.toCharArray();

        if(contactChar.length != 11 || contactChar[3] != '-') return false;

        for (int i = 0; i < contactChar.length; i++) {
            if(i == 3) continue;
            if(!Character.isDigit(contactChar[i])) return false;
        }
        return true;
    }

    public void successScene(Stage stage){
        Label label = new Label("Success!!");
        AnchorPane anchorPane = new AnchorPane(label);
        Scene scene = new Scene(anchorPane);

        anchorPane.setMinWidth(400);
        anchorPane.setMinHeight(600);
        label.setAlignment(Pos.CENTER);
        label.setFont(new Font(20));
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();


    }
}
