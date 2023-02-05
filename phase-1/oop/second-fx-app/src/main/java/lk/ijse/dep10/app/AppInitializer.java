package lk.ijse.dep10.app;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AppInitializer extends Application {
    public AppInitializer() {

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        vBoxMain();

    }

    private void stackPaneDemo() {
        Stage stage = new Stage();
        StackPane stackPane = new StackPane();
        Scene scene = new Scene(stackPane);

        Sphere sphere = new Sphere(70);
        Text text = new Text("this is middle of the sphere");

        Circle circle = new Circle(300, 150, 200);
        Button cancelButton = new Button("cancel");
        Button saveButton = new Button("save");

        StackPane.setAlignment(cancelButton, Pos.BOTTOM_RIGHT);
        StackPane.setAlignment(saveButton, Pos.BOTTOM_RIGHT);

        circle.setFill(Color.MAROON);
        circle.setStroke(Color.CYAN);

        text.setFont(Font.font(null, FontWeight.BOLD, 15));
        text.setFill(Color.ORANGE);

        StackPane.setMargin(circle, new Insets(10, 10, 50, 10));
        StackPane.setMargin(sphere, new Insets(10, 10, 50, 10));
        StackPane.setMargin(text, new Insets(10, 10, 50, 10));
        StackPane.setMargin(saveButton, new Insets(0, 63, 0, 0));
        stackPane.getChildren().addAll(circle, sphere, text, cancelButton, saveButton);
        stage.setScene(scene);
        stage.show();
    }

    private void vBoxMain() {
        Stage stage = new Stage();
        VBox vBox = new VBox();
        Scene scene = new Scene(vBox);

        Button button1 = new Button("tilePane Demo");
        Button button2 = new Button("stackPane Demo");
        Button button3 = new Button("hBox Demo");
        Button button4 = new Button("flowPane Demo");
        Button button5 = new Button("borderPane Demo");
        Button button6 = new Button("anchorPane Demo");
        Button button7 = new Button("gridPane Demo");
        Button button8 = new Button("exit");

        button1.setPrefWidth(450);
        button2.setPrefWidth(450);
        button3.setPrefWidth(450);
        button4.setPrefWidth(450);
        button5.setPrefWidth(450);
        button6.setPrefWidth(450);
        button7.setPrefWidth(450);
        button8.setPrefWidth(450);

        button1.setPrefHeight(50);
        button2.setPrefHeight(50);
        button3.setPrefHeight(50);
        button4.setPrefHeight(50);
        button5.setPrefHeight(50);
        button6.setPrefHeight(50);
        button7.setPrefHeight(50);
        button8.setPrefHeight(50);

        button8.setStyle("-fx-background-color: #ff0000");

        vBox.setPadding(new Insets(20));
        vBox.setSpacing(5);

        button1.setOnAction(actionEvent -> {
            tilePaneDemo();
        });
        button2.setOnAction(actionEvent -> {
            stackPaneDemo();
        });
        button3.setOnAction(actionEvent -> {
            hBoxDemo();
        });
        button4.setOnAction(actionEvent -> {
            flowPaneDemo();
        });
        button5.setOnAction(actionEvent -> {
            borderPaneDemo();
        });
        button6.setOnAction(actionEvent -> {
            anchorPaneDemo();
        });
        button7.setOnAction(actionEvent -> {
            gridPainDemo();
        });
        button8.setOnAction(actionEvent -> {
            stage.close();
        });



        vBox.getChildren().addAll(button1,button2,button3,button4,button5,button6,button7,button8);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    private void flowPaneDemo() {
        Stage stage = new Stage();
        FlowPane flowPane = new FlowPane();

        VBox vBox1 = new VBox();
        VBox vBox2 = new VBox();
        VBox vBox3 = new VBox();

        Label nameLabel = new Label("name");
        TextField nameTextField = new TextField();
        Label idLabel = new Label("id");
        TextField idTextField = new TextField();
        Label commentLabel = new Label("comment");
        TextArea commentTextArea = new TextArea();

        ButtonBar buttonBar = new ButtonBar();
        buttonBar.setPadding(new Insets(10));

        Button cancelButton = new Button("cancel");
        Button saveButton = new Button("save");

        buttonBar.setButtonData(saveButton, ButtonBar.ButtonData.OK_DONE);
        buttonBar.setButtonData(cancelButton, ButtonBar.ButtonData.CANCEL_CLOSE);

        buttonBar.getButtons().addAll(saveButton, cancelButton);
        vBox1.getChildren().addAll(nameLabel, nameTextField);
        vBox2.getChildren().addAll(idLabel, idTextField);
        vBox3.getChildren().addAll(commentLabel, commentTextArea);
        flowPane.getChildren().addAll(vBox1, vBox2, vBox3, buttonBar);

        flowPane.setPadding(new Insets(20));
        Scene scene = new Scene(flowPane);
        stage.setScene(scene);
        stage.show();
    }

    private void hBoxDemo() {
        Stage stage = new Stage();

        Button[] buttons = new Button[5];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button("btn" + (i + 1));
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

    private void HBoxDemo() {
        Stage stage = new Stage();

        TextField[] textFields = new TextField[5];
        for (int i = 0; i < textFields.length; i++) {
            textFields[i] = new TextField();
        }

        HBox hBox = new HBox(textFields);
        Scene scene = new Scene(hBox);


        stage.setScene(scene);
        stage.sizeToScene();

        stage.setTitle("HBoxDemo");
        stage.show();
        stage.centerOnScreen();
    }

    private void anchorPaneDemo() {
        Stage stage = new Stage();

        Button btn1 = new Button("btn1");
        Button btn2 = new Button("btn2");
        Button btn3 = new Button("btn3");
        Button btn4 = new Button("btn4");

        AnchorPane anchorPane = new AnchorPane();
        Scene scene = new Scene(anchorPane);


        Hyperlink signOutLink = new Hyperlink("Sign Out");
        anchorPane.getChildren().add(signOutLink);
        AnchorPane.setTopAnchor(signOutLink, 10.0d);
        AnchorPane.setRightAnchor(signOutLink, 10.0d);

        var hBox = hBoxInAnchorPane();
        anchorPane.getChildren().add(hBox);
        AnchorPane.setBottomAnchor(hBox, 10.0d);
        AnchorPane.setRightAnchor(hBox, 10.0d);

        Label label1 = new Label("Programme Status");
        AnchorPane.setBottomAnchor(label1, 10.0d);
        AnchorPane.setLeftAnchor(label1, 10.0d);
        anchorPane.getChildren().add(label1);

        TextArea textArea = new TextArea();
        anchorPane.getChildren().add(textArea);
        AnchorPane.setLeftAnchor(textArea, 10.0d);
        AnchorPane.setRightAnchor(textArea, 10.0d);
        AnchorPane.setBottomAnchor(textArea, 35.0d);
        AnchorPane.setTopAnchor(textArea, 35.0d);

        stage.setScene(scene);


        stage.setTitle("anchorPaneDemo");
        stage.setHeight(250);
        stage.setWidth(250);
        stage.show();
    }

    private HBox hBoxInAnchorPane() {
        Circle circle = new Circle();
        circle.setFill(Color.GREEN);
        circle.setRadius(10);

        Label label1 = new Label("Connection");

        HBox hBox = new HBox();
        hBox.setSpacing(10.0d);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.getChildren().addAll(circle, label1);

        return hBox;
    }


    private void tilePaneDemo() {
        Stage stage = new Stage();
        stage.setTitle("TilePane Demo");

        TilePane tilePane = new TilePane();
        tilePane.setPrefColumns(3);
        tilePane.setPrefRows(3);
        tilePane.setAlignment(Pos.CENTER);
        tilePane.setPrefTileHeight(100);
        tilePane.setPrefTileWidth(100);

        Scene scene = new Scene(tilePane);
        scene.setFill(Color.MAROON);            //dont work, why is that?

        tilePane.getChildren().addAll(
                new Rectangle(50, 50, Color.RED),
                new Rectangle(50, 50, Color.GREEN),
                new Rectangle(50, 50, Color.YELLOW),
                new Rectangle(50, 50, Color.BLUE),
                new Rectangle(50, 50, Color.CYAN),
                new Rectangle(50, 50, Color.PURPLE),
                new Rectangle(50, 50, Color.ROSYBROWN),
                new Rectangle(50, 50, Color.HOTPINK),
                new Rectangle(50, 50, Color.ORANGE)
        );


        stage.setScene(scene);
        stage.show();
    }

    private void gridPainDemo() {
        Stage stage = new Stage();

        Label labelTitle = new Label("customer details");
        labelTitle.setFont(Font.font(20));

        Label lblId = new Label("Enter Id");
        Label lblName = new Label("Enter name");
        Label lblAddress = new Label("Enter address");                // these are controls
        Label lblBirthMonth = new Label("Enter birth month");

        TextField txtId = new TextField();
        TextField txtName = new TextField();
        TextArea txtAddress = new TextArea();

        ObservableList<String> months = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
        ComboBox<String> cbMonths = new ComboBox<>(months);

        Button btn = new Button("SAVE");
        btn.setOnAction(actionEvent -> {
            System.out.println("IJSE");                             //reactive programming paradigm
            hBoxDemo();
        });

        GridPane gridPane = new GridPane();
        gridPane.add(labelTitle, 0, 0, 2, 1);
        gridPane.add(lblId, 0, 1);
        gridPane.add(lblName, 0, 2);
        gridPane.add(lblBirthMonth, 0, 3);
        gridPane.add(lblAddress, 0, 4);

        gridPane.add(txtId, 1, 1);
        gridPane.add(txtName, 1, 2);
        gridPane.add(cbMonths, 1, 3);
        gridPane.add(txtAddress, 1, 4);

        Separator sep = new Separator();
        gridPane.add(sep, 0, 5, 2, 5);

        gridPane.add(btn, 1, 9);

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));
//        gridPane.setGridLinesVisible(true);

        VBox.setVgrow(gridPane, Priority.ALWAYS);

        GridPane.setHalignment(labelTitle, HPos.CENTER);
        GridPane.setHalignment(btn, HPos.RIGHT);

        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.sizeToScene();


        stage.setTitle("Grid pain demo");
        stage.show();
        stage.centerOnScreen();
    }

    private void borderPaneDemo() {
        Stage stage = new Stage();
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane);

        borderPane.setTop(new TextField("Top"));
        borderPane.setBottom(new TextField("Bottom"));
        borderPane.setLeft(new TextField("Left"));
        borderPane.setRight(new TextField("Right"));
        borderPane.setCenter(new TextField("Center"));

        stage.setTitle("borderPaneDemo");
        stage.setScene(scene);
        stage.setHeight(500);
        stage.setWidth(500);
        stage.show();
    }
}
