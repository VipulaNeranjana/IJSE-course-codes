package lk.ijse.dep10.concurrency.controller;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class MainViewController {

    @FXML
    private Button btnRun;

    @FXML
    private Label lblProgress;

    @FXML
    private ProgressBar prg;

    @FXML
    void btnRunOnAction(ActionEvent event) {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                for (int i = 0; i < 400000; i++) {
                    System.out.println(i);
                    double progress = i/400000.0;
                    updateMessage((int)(i/400000.0 * 100)+ "% Complete");
                    updateProgress(i,400000.0);
                }
                return null;
            }
        };

        new Thread(task).start();

        prg.progressProperty().bind(task.progressProperty());
        lblProgress.textProperty().bind(task.messageProperty());
//        lblProgress.setText(progress+"% Complete");
//        prg.setProgress(progress);

    }

}
