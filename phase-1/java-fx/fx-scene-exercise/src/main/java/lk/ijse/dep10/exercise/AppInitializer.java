package lk.ijse.dep10.exercise;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class AppInitializer extends Application {

    private int i = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.show();
        primaryStage.centerOnScreen();
        loginScene(primaryStage);
    }
//    private void tempScene


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
        logInLabel.setPadding(new Insets(0, 0, 40, 0));
        button.setDefaultButton(true);
        passwordField.setMaxWidth(250);
        statusLabel.setTextFill(Color.rgb(200, 2, 2, 1));
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

    public void mainScene(Stage stage) {
        Label label = new Label("Welcome to the App");
        Label lbl = new Label("Hi! i'm moving");
        Label lblDinamic = new Label("");
        ArrayList<String> arrDinamic = new ArrayList<String>();
        String[] arrSentences = new String[]{
                "I am vipula and I know it",
                "I am hungry now",
                "There is nothing to shy"
        };
        String block = String.format("\u001b");
        Sphere sphere = new Sphere();


        Rectangle2D rectangle2D = new Rectangle2D(1, 1, 1, 1);

        label.setFont(new Font(30));

        KeyFrame key1 = new KeyFrame(Duration.millis(0), actionEvent -> {
            TranslateTransition translateX = new TranslateTransition(Duration.seconds(1), label);
            translateX.setFromX(-500);
            translateX.setToX(20);
            translateX.play();
        });
        KeyFrame key2 = new KeyFrame(Duration.millis(1000), actionEvent -> {
            TranslateTransition translate1X = new TranslateTransition(Duration.millis(1000), label);
            translate1X.setFromX(20);
            translate1X.setToX(0);
            translate1X.play();
        });
        KeyFrame key3 = new KeyFrame(Duration.millis(2000), actionEvent -> {
            label.setScaleX(2);
            label.setScaleY(2);
        });
        KeyFrame key4 = new KeyFrame(Duration.millis(2500), actionEvent -> {
            label.setScaleX(1);
            label.setScaleY(1);
        });

        for (int i = 0; i < arrSentences.length; i++) {
            String string1 = "";
            char[] chars = arrSentences[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                string1 = string1 + chars[j];
//                lblDinamic.setText(string1);
                arrDinamic.add(string1);
                arrDinamic.add(string1 + block);

                System.out.println(lblDinamic.getText());
                if (j == chars.length - 1) {
                    for (int k = chars.length - 1; k >= 0; k--) {
                        String string = "";
                        for (int l = 0; l < k; l++) {
                            string = string + chars[l];
                        }
//                        System.out.println(lblDinamic.getText());
//                        lblDinamic.setText(string);
                        arrDinamic.add(string);
                        arrDinamic.add(string + block);

                    }
                }

            }

        }


        Timeline timeline = new Timeline(key1, key2, key3, key4);
        timeline.setCycleCount(1);
        timeline.play();

        KeyFrame key5 = new KeyFrame(Duration.seconds(0.2), actionEvent -> {

            lblDinamic.setText(arrDinamic.get(i));
            i++;
            if (i == arrDinamic.size() - 1) i = 0;
//            for (int i = 0; i < arrSentences.length; i++) {
//                String string1 = "";
//                char[] chars = arrSentences[i].toCharArray();
//                for (int j = 0; j < chars.length; j++) {
//                    string1 = string1 + chars[j];
//                    lblDinamic.setText(string1);
//                    System.out.println(lblDinamic.getText());
//                    if (j == chars.length-1){
//                        for (int k = chars.length-1; k >= 0 ; k--) {
//                            String string = "";
//                            for (int l = 0; l < k; l++) {
//                                string = string + chars[l];
//                            }
//                            System.out.println(lblDinamic.getText());
//                            lblDinamic.setText(string);
//                            try {
//                                Thread.sleep(3000);
//                            } catch (InterruptedException e) {
//                                throw new RuntimeException(e);
//                            }
//                        }
//                    }
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//
//            }
        });
        VBox vBox = new VBox(label);
        AnchorPane anchorPane = new AnchorPane(vBox, lbl, lblDinamic);
        Timeline timeline1 = new Timeline(key5);
        timeline1.setCycleCount(Animation.INDEFINITE);
        timeline1.playFromStart();


        Scene scene = new Scene(anchorPane);

        anchorPane.setBackground(Background.fill(new Color(1, 1, 1, 0)));

        anchorPane.setMinWidth(800);
        anchorPane.setMinHeight(600);

//        anchorPane.setOnMouseEntered(mouseEvent -> lbl.setVisible(true));
//        anchorPane.setOnMouseExited(mouseEvent -> lbl.setVisible(false));
//        anchorPane.setOnMouseMoved(mouseEvent -> {
//            lbl.setLayoutX(mouseEvent.getX() + 20);
//            lbl.setLayoutY(mouseEvent.getY() + 20);
//        });

        anchorPane.setOnMouseEntered(mouseEvent -> lblDinamic.setVisible(true));
        anchorPane.setOnMouseExited(mouseEvent -> lblDinamic.setVisible(false));
        anchorPane.setOnMouseMoved(mouseEvent -> {
            lblDinamic.setLayoutX(mouseEvent.getX() + 20);
            lblDinamic.setLayoutY(mouseEvent.getY() + 20);
        });


        vBox.setMinWidth(800);
        vBox.setMinHeight(600);
        vBox.setAlignment(Pos.CENTER);
        label.setTextFill(Color.rgb(0, 100, 250, 0.3));

        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("My App");
        stage.show();

    }
}
