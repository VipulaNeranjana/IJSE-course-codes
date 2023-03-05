package lk.ijse.dep10.controller;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import lk.ijse.dep10.shared.Dep10Header;
import lk.ijse.dep10.shared.Dep10Message;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ChatSceneViewController {

    @FXML
    private  TextField lstMessages;

    @FXML
    private ListView<String> lstUsers;

    @FXML
    private TextField txtMessage;
    Socket socket;

    public void initialize() {
        connect();
        readServerResponse();
        Platform.runLater(() -> {
            txtMessage.getScene().getWindow().setOnCloseRequest(windowEvent -> {closeSocket();});
        });

    }

    private void readServerResponse() {
        new Thread(() -> {
            try {
                InputStream inputStream = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

                Dep10Message msg = (Dep10Message) objectInputStream.readObject();
                if(msg.getHeader() == Dep10Header.MSG){
                    Platform.runLater(() -> {lstMessages.setText(msg.getBody().toString());});


                }else {
                    Platform.runLater(() -> {
                        ObservableList<String> userList = lstUsers.getItems();
                        userList.clear();
                        userList.addAll((ArrayList<String>) msg.getBody());
                    });
                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

    }

    private void connect() {
        try {
            socket = new Socket("127.0.0.1", 5050);
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"failed to connect with server, try again").showAndWait();
            Platform.exit();
        }
    }

    private void closeSocket(){
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void txtMessageOnAction(ActionEvent event) {
        try {
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            Dep10Message dep10Message = new Dep10Message(Dep10Header.MSG, txtMessage.getText());
            objectOutputStream.writeObject(dep10Message);
            objectOutputStream.flush();

            txtMessage.clear();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
