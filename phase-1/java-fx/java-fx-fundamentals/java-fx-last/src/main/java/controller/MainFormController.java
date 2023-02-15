package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainFormController {

    public Button btnListViewExer;
    @FXML
    private Button btnComboBox;

    @FXML
    private Button btnListView;

    @FXML
    private Button btnSceneToSceneCommunication;

    @FXML
    private Button btnTableView;

    @FXML
    void btnComboBoxOnAction(ActionEvent event) throws IOException {

        AnchorPane pane  = new FXMLLoader(getClass().getResource("/view/ComboBoxScene.fxml")).load();


        Scene scene = new Scene(pane);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(btnComboBox.getScene().getWindow());
        stage.setTitle("combo box demo");
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    void btnListViewOnAction(ActionEvent event) throws IOException {

        Stage stage = new Stage();

        URL resource = getClass().getResource("/view/ListViewScene.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        AnchorPane list = fxmlLoader.load();

        Scene scene = new Scene(list);
        stage.setScene(scene);

        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(btnListView.getScene().getWindow());
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    void btnSceneToSceneCommunicationOnAction(ActionEvent event) {

    }

    @FXML
    void btnTableViewOnAction(ActionEvent event) {

    }

    public void btnListViewExer(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("/view/ListExView.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        AnchorPane root = fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(btnListViewExer.getScene().getWindow());
        stage.show();
        stage.centerOnScreen();
    }
}
