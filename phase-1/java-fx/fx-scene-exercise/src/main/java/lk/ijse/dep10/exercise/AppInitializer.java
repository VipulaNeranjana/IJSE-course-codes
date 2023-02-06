package lk.ijse.dep10.exercise;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.show();
        primaryStage.centerOnScreen();
        loginScene(primaryStage);
    }

    public void loginScene(Stage stage) {
        Label logInLabel = new Label("LOG IN");
        Label passwordLabel = new Label("Enter the password");
        Label statusLabel = new Label("Password is incorrect");
        PasswordField passwordField = new PasswordField();
        Button button = new Button("Log in");
        VBox vBox = new VBox(logInLabel, passwordLabel, passwordField, statusLabel, button);
        Scene scene = new Scene(vBox);

        vBox.setPadding(new Insets(20));
        vBox.setSpacing(6);
        vBox.setMinWidth(500);
        vBox.setMinHeight(500);
        vBox.setAlignment(Pos.CENTER);
        logInLabel.setFont(new Font(40));
        logInLabel.setTextFill(Color.DARKBLUE);
        logInLabel.setPadding(new Insets(0,0,40,0));
        button.setDefaultButton(true);
        passwordField.setMaxWidth(250);
        statusLabel.setTextFill(Color.rgb(200,2,2,1));
        statusLabel.setVisible(false);
        button.setOnAction(actionEvent -> {
            if (passwordField.getText().equals("Admin")) mainScene(stage);

            else {
                statusLabel.setVisible(true);
                passwordField.selectAll();
            }
        });

        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    public void mainScene(Stage stage){
        Label label = new Label("Welcome to the App");
//        Label lbl = new Label("Hi! i'm moving");
        Label lbl = new Label("Hutta");

        label.setFont(new Font(30));
//        VBox vBox = new VBox(label);
        AnchorPane anchorPane = new AnchorPane(lbl);
        Scene scene = new Scene(anchorPane);

        anchorPane.setMinWidth(800);
        anchorPane.setMinHeight(600);

        anchorPane.setOnMouseEntered(mouseEvent -> lbl.setVisible(true));
        anchorPane.setOnMouseExited(mouseEvent -> lbl.setVisible(false));
        anchorPane.setOnMouseMoved(mouseEvent -> {
            lbl.setLayoutX(mouseEvent.getX() + 20);
            lbl.setLayoutY(mouseEvent.getY() + 20);
        });


//        vBox.setMinWidth(500);
//        vBox.setMinHeight(500);
//        vBox.setAlignment(Pos.CENTER);
//        label.setTextFill(Color.rgb(0,100,250,0.3));

        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("My App");
        stage.show();

    }
}
