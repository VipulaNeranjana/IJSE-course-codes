package lk.ijse.dep10.animations;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AppInitializer extends Application {

    private  Stage stageTransition;
    private  Stage stageAnimation;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.show();
        mainScene(primaryStage);

    }

    public void mainScene(Stage stage){
        Button transitionButton = new Button("transition");
        Button animationButton = new Button("animation");
        Label label = new Label("Java fx animation model");
        Label lblTime = new Label(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")).toString());
        VBox vBox = new VBox(label,animationButton,transitionButton,lblTime);
        Scene scene = new Scene(vBox);

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), actionEvent -> {
            lblTime.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")).toString());
        });

        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.playFromStart();

        lblTime.setFont(new Font(18));
        lblTime.setMaxWidth(Double.MAX_VALUE);
        lblTime.setAlignment(Pos.CENTER);

        vBox.setMinHeight(800);
        vBox.setMinWidth(600);
        vBox.setPadding(new Insets(30));
        label.setAlignment(Pos.CENTER);
        label.setFont(new Font(30));
        label.setMaxWidth(Double.MAX_VALUE);
        animationButton.setMaxWidth(Double.MAX_VALUE);
        transitionButton.setMaxWidth(Double.MAX_VALUE);
        animationButton.setAlignment(Pos.CENTER);
        transitionButton.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);

        animationButton.setOnAction(actionEvent -> animationScene(new Stage()));
        transitionButton.setOnAction(actionEvent -> transitionScene(new Stage()));

        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();



    }

    private void transitionScene(Stage stage) {
        if(stageTransition != null) return;
        stageTransition = stage;
        stage.setOnCloseRequest(windowEvent -> {
            stageTransition = null;
        });

        Button btnPlay = new Button("PLAY");
        Button btnStop = new Button("STOP");
        Label lblPreview = new Label("Preview");

        lblPreview.setFont(new Font(30));
        VBox vBox = new VBox(btnPlay,btnStop);
        HBox root = new HBox(vBox,lblPreview);
        Scene scene = new Scene(root);

        vBox.setSpacing(10);
        vBox.setPadding(new Insets(0,10,0,0));
        btnPlay.setMaxWidth(Double.MAX_VALUE);
        btnStop.setMaxWidth(Double.MAX_VALUE);
        lblPreview.setAlignment(Pos.CENTER);
        lblPreview.setMaxWidth(Double.MAX_VALUE);
        lblPreview.setMaxHeight(Double.MAX_VALUE);
        HBox.setHgrow(lblPreview,Priority.ALWAYS);
        lblPreview.setBackground(Background.fill(Color.LIGHTBLUE));
        root.setPadding(new Insets(20));

        KeyFrame key1 = new KeyFrame(Duration.millis(500),actionEvent -> {
            lblPreview.setTextFill(Color.RED);
        });
        KeyFrame key2 = new KeyFrame(Duration.millis(750),actionEvent -> {
            lblPreview.setScaleX(1.5);
            lblPreview.setScaleY(1.5);
        });
        KeyFrame key3 = new KeyFrame(Duration.millis(1000),actionEvent -> {
            lblPreview.setTextFill(Color.BLACK);

        });
        KeyFrame key4 = new KeyFrame(Duration.millis(1250),actionEvent -> {
            lblPreview.setScaleX(1);
            lblPreview.setScaleY(1);
        });
        KeyFrame key5 = new KeyFrame(Duration.millis(1500),actionEvent -> {
            lblPreview.setTextFill(Color.PURPLE);

        });

        Timeline timeline = new Timeline(key1,key2,key3,key4,key5);
        timeline.setCycleCount(Animation.INDEFINITE);

        btnPlay.setOnAction(actionEvent -> {
            timeline.play();
        });

        btnStop.setOnAction(actionEvent -> {
            timeline.stop();
        });

        root.setMinWidth(900);
        root.setMinHeight(700);

        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    private void animationScene(Stage stage) {
        if(stageAnimation != null) return;
        stageAnimation =stage;
        stage.setOnCloseRequest(windowEvent -> {
            stageAnimation = null;
        });

        Button btnFadeIn = new Button("Fade In");
        Button btnFadeOut = new Button("Fade Out");
        Button btnScale = new Button("Scale");
        Button btnRotate = new Button("Rotate");
        Button btnTranslateX = new Button("Translate x");
        Button btnTranslateY = new Button("Translate y");

        HBox hBox = new HBox(btnFadeIn,btnFadeOut,btnScale,btnRotate,btnTranslateX,btnTranslateY);
        Label lblPreview = new Label("Preview");

        VBox root = new VBox(hBox,lblPreview);
        Scene scene = new Scene(root);

        root.setMinHeight(800);
        root.setMinWidth(600);

        hBox.setSpacing(10);
        Font font  = new Font(16);
        for (Node child : hBox.getChildren()) {
            child = (Button) child;
            ((Button) child).setFont(font);
            ((Button) child).setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(child, Priority.ALWAYS);
        }

        lblPreview.setMaxWidth(Double.MAX_VALUE);
        lblPreview.setAlignment(Pos.CENTER);
        lblPreview.setFont(new Font(44));
        root.setSpacing(150);

        btnFadeOut.setOnAction(actionEvent -> {
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(5),lblPreview);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.play();
            fadeOut.setAutoReverse(true);
        });

        btnRotate.setOnAction(actionEvent -> {
            RotateTransition rotate = new RotateTransition(Duration.seconds(5),lblPreview);
            rotate.setFromAngle(0);
            rotate.setToAngle(180);
            rotate.play();
            rotate.setAutoReverse(true);

        });

        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
