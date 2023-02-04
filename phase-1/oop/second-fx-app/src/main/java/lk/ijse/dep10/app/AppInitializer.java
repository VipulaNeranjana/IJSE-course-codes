package lk.ijse.dep10.app;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AppInitializer extends Application {
    public AppInitializer() {

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

//        hBoxDemo();
//        vBoxDemo();
//        gridPainDemo();
        anchorPaneDemo();

        Button btn1 = new Button("Button 1");
        Button btn2 = new Button("Button 2");
        Button btn3 = new Button("Button 3");
        Button btn4 = new Button("Button 4");
        Button btn5 = new Button("Button 5");

        TextField txt1 = new TextField();
        TextField txt2 = new TextField();
        TextField txt3 = new TextField();
        TextField txt4 = new TextField();

//        AnchorPane anchorPane = new AnchorPane(btn1,btn2,btn3,btn4,btn5,txt1,txt2,txt3,txt4);
        BorderPane anchorPane = new BorderPane();
//        anchorPane.getChildren().addAll(btn1,btn2,btn3,btn4,btn5,txt1,txt2,txt3,txt4);  //except borderpane
        anchorPane.setTop(btn1);
        anchorPane.setBottom(btn2);
        anchorPane.setCenter(btn3);
        anchorPane.setLeft(btn4);
        anchorPane.setRight(btn5);

        BorderPane.setAlignment(btn1, Pos.CENTER);
        BorderPane.setAlignment(btn2, Pos.CENTER);
        BorderPane.setAlignment(btn3, Pos.CENTER);
        BorderPane.setAlignment(btn4, Pos.CENTER);
        BorderPane.setAlignment(btn5, Pos.CENTER);

//        btn5.setLayoutX(250);
//        btn5.setLayoutY(250);
//
//        btn4.setLayoutX(100);
//        btn4.setLayoutY(250);

        Scene scene= new Scene(anchorPane);
        primaryStage.setScene(scene);

        Stage stage1 = new Stage();
        primaryStage.setTitle("maven app");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
        primaryStage.centerOnScreen();

    }

    private void hBoxDemo(){
        Stage stage = new Stage();

        Button[] buttons = new Button[5];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button("btn" + (i+1));
        }

        HBox hBox = new HBox(buttons);
        Scene scene = new Scene(hBox);


        stage.setScene(scene);
        stage.sizeToScene();

        stage.setTitle("HBoxDemo");
        stage.setWidth(500);
        stage.setHeight(500);
        stage.show();
        stage.centerOnScreen();
    }

    private void vBoxDemo(){
        Stage stage = new Stage();

        TextField[] textFields = new TextField[5];
        for (int i = 0; i < textFields.length; i++) {
            textFields[i] = new TextField();
        }

        VBox vBox = new VBox(textFields);
        Scene scene = new Scene(vBox);


        stage.setScene(scene);
        stage.sizeToScene();

        stage.setTitle("HBoxDemo");
        stage.setWidth(500);
        stage.setHeight(500);
        stage.show();
        stage.centerOnScreen();
    }



    private void gridPainDemo(){
        Stage stage = new Stage();

        Label labelTitle = new Label("customer details");
        labelTitle.setFont(Font.font(20));

        Label lblId = new Label("Enter Id");
        Label lblName = new Label("Enter name");
        Label lblAddress = new Label("Enter address");                // these are controls

        TextField txtId = new TextField();
        TextField txtName = new TextField();
        TextArea txtAddress = new TextArea();

        Button btn = new Button("SAVE");
        btn.setOnAction(actionEvent -> {
            System.out.println("IJSE");                             //reactive programming paradigm
            hBoxDemo();
        });

        GridPane gridPane = new GridPane();
        gridPane.add(labelTitle,0,0,2,1);
        gridPane.add(lblId,0,1);
        gridPane.add(lblName,0,2);
        gridPane.add(lblAddress,0,3);

        gridPane.add(txtId,1,1);
        gridPane.add(txtName,1,2);
        gridPane.add(txtAddress,1,3);

        gridPane.add(btn,1,4);

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));
//        gridPane.setGridLinesVisible(true);

        GridPane.setHalignment(labelTitle, HPos.CENTER);

        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.sizeToScene();


        stage.setTitle("Grid pain demo");
        stage.show();
        stage.centerOnScreen();
    }
}
