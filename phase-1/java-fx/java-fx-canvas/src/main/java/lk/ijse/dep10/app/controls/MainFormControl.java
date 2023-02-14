package lk.ijse.dep10.app.controls;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MainFormControl {

    public ColorPicker clrStrock;
    public ColorPicker clrFill;
    @FXML
    private Canvas cnvMain;

    double startX;
    double startY;
    double stopY;
    double stopX;

    double prevX;
    double prevY;
    GraphicsContext graphicsContext2D;

    String[] colours= new String[]{"ORANGE","RED"};

    public void initialize() {
        graphicsContext2D = cnvMain.getGraphicsContext2D();
//        graphicsContext2D.setFill(Color.BLUE);
//        graphicsContext2D.fillRoundRect(50,50,150,150,20,20);
//        graphicsContext2D.strokeRoundRect(210,50,150,150,20,20);
//
//        graphicsContext2D.setFont(new Font(32));
//        graphicsContext2D.setFill(Color.GREEN);
//        graphicsContext2D.fillText("IJSE",450,50);
//
//        graphicsContext2D.setFill(Color.RED);
//        graphicsContext2D.strokeText("IJSE",50,250);
//
//        graphicsContext2D.setFill(Color.ORANGE);
//        graphicsContext2D.fillOval(210,50,150,150);

    }

    public void onCnvPressed(MouseEvent mouseEvent) {
        startX = mouseEvent.getX();
        startY = mouseEvent.getY();

        prevX = startX;
        prevY = stopY;

    }

    public void onnvReleased(MouseEvent mouseEvent) {
        stopX = mouseEvent.getX();
        stopY = mouseEvent.getY();


        if (stopX - startX < 0.0) {
            double intermediate;
            intermediate = startX;
            startX = stopX;
            stopX = intermediate;
        }
        if (stopY - startY < 0.0) {
            double intermediate;
            intermediate = startY;
            startY = stopY;
            stopY = intermediate;
        }

//        graphicsContext2D.setFill(Color.ORANGE);

        graphicsContext2D.fillRect(startX, startY, stopX - startX, stopY - startY);

    }

    public void cnvOnMouseDragged(MouseEvent mouseEvent) {
//        if(!mouseEvent.isDragDetect()) return;

        stopX = mouseEvent.getX();
        stopY = mouseEvent.getY();


//        if (stopX - startX < 0.0) {
//            double intermediate;
//            intermediate = startX;
//            startX = stopX;
//            stopX = intermediate;
//            System.out.println(stopX);
//        }
//        if (stopY - startY < 0.0) {
//            double intermediate;
//            intermediate = startY;
//            startY = stopY;
//            stopY = intermediate;
//            System.out.println(stopY);
//        }

//        graphicsContext2D.setFill(Color.ORANGE);

//        graphicsContext2D.fillRect(startX, startY, stopX - startX, stopY - startY);
        if ((startX >= stopX && startY >= stopY)) {
            graphicsContext2D.clearRect(0, 0, cnvMain.getWidth(), cnvMain.getHeight());
            graphicsContext2D.strokeRect(stopX, stopY, startX - stopX, startY - stopY);
        } else if ((startX < stopX && startY < stopY)){
            graphicsContext2D.clearRect(0, 0, cnvMain.getWidth(), cnvMain.getHeight());
            graphicsContext2D.strokeRect(startX, startY, stopX - startX, stopY - startY);
        } else if ((startX < stopX && startY > stopY)) {
            graphicsContext2D.clearRect(0, 0, cnvMain.getWidth(), cnvMain.getHeight());
            graphicsContext2D.strokeRect(startX, stopY, stopX - startX, startY - stopY);
        } else if ((startX > stopX && startY < stopY)) {
            graphicsContext2D.clearRect(0, 0, cnvMain.getWidth(), cnvMain.getHeight());
            graphicsContext2D.strokeRect(stopX, startY, startX - stopX, stopY - startY);
        }

        prevX  = stopX;
        prevY = stopY;
    }

    public void clrFillOnAction(ActionEvent actionEvent) {
        GraphicsContext graphicsContext2D = cnvMain.getGraphicsContext2D();
        graphicsContext2D.setFill(clrFill.getValue());
    }

    public void clrStrockOnAction(ActionEvent actionEvent) {
        GraphicsContext graphicsContext2D = cnvMain.getGraphicsContext2D();
        graphicsContext2D.setStroke(clrStrock.getValue());
    }
}
