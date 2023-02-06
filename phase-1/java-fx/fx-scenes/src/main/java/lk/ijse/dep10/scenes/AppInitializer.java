package lk.ijse.dep10.scenes;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
        System.out.println("jvm is about to exit");
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.show();
        mainScene(primaryStage);

    }

    private void mainScene(Stage stage){
        Label label = new Label("Main Scene");
        Button button1 = new Button("button 1");
        Button button2 = new Button("button 2");
        Button button3 = new Button("button 3");
        Button button4 = new Button("Platform exit");
        Button button5 = new Button("system exit");

        button1.setOnAction(actionEvent -> firstScene(stage));
        button2.setOnAction(actionEvent -> secondScene(stage));
        button3.setOnAction(actionEvent -> thirdScene(stage));

        button4.setOnAction(actionEvent -> {
            System.out.println("platform exit");
            Platform.exit();
        });

        button5.setOnAction(actionEvent -> {
            System.out.println("System exit");
            System.exit(10);

        });

        button1.setPrefWidth(240);
        stage.setMinWidth(250);
        stage.setMaxWidth(750);


//        Paint paint4btn4 = new Color(0.8,1,0,1);
//        Paint paint4btn4 = Color.rgb(255,0,0,1);
        Paint paint4btn4 = Color.web("lightBlue");
        Background background4btn4 = Background.fill(paint4btn4);
        button4.setBackground(background4btn4);

        VBox vBox = new VBox(label,button1,button2,button3,button4,button5);
        vBox.setBackground(Background.fill(Color.rgb(200,4,78,0.4)));
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));

        button1.setFont(new Font("ubuntu",14));
        Font tiltleFont = new Font("ubuntu",20);


        for (Node control : vBox.getChildren()) {
            if(!(control instanceof Labeled)) continue;
            Labeled lbl = (Labeled) control;
            lbl.setFont(tiltleFont);
            lbl.setMaxWidth(Double.MAX_VALUE);
        }

        label.setFont(tiltleFont);
        label.setAlignment(Pos.CENTER);


        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.centerOnScreen();
    }
    private void firstScene(Stage stage){
        Label label = new Label("First Scene");
        Button button = new Button("back");


        button.setOnAction(actionEvent -> mainScene(stage));
        VBox vBox = new VBox(label,button);
        vBox.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();

        System.out.println("first scene");
    }

    private void secondScene(Stage stage){
        Label label = new Label("Second Scene");
        Button button = new Button("back");


        button.setOnAction(actionEvent -> mainScene(stage));
        VBox vBox = new VBox(label,button);
        vBox.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
        System.out.println("second scene");
    }
    private void thirdScene(Stage stage){
        Label label = new Label("Third Scene");
        Button button = new Button("back");


        button.setOnAction(actionEvent -> mainScene(stage));
        VBox vBox = new VBox(label,button);
        vBox.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
        System.out.println("third scene");
    }
}
