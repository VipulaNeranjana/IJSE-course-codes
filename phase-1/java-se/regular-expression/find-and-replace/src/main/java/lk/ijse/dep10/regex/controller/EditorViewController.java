package lk.ijse.dep10.regex.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditorViewController {

    @FXML
    private Button btnDown;

    @FXML
    private Button btnReplace;

    @FXML
    private Button btnReplaceAll;

    @FXML
    private Button btnUp;

    @FXML
    private CheckBox chkMatchCase;

    @FXML
    private Label lblResult;

    @FXML
    private TextArea txtEditor;

    @FXML
    private TextField txtFind;

    @FXML
    private TextField txtReplace;

    Pattern pattern;
    Matcher matcher;
    boolean isMatched;
    String findText;
    ArrayList<Integer> startPoints =  new ArrayList<>();
    int now;

    int i;
    public void initialize(){


        txtFind.textProperty().addListener((observableValue, s, current) -> {
            findResultCount();

            findText = txtFind.getText();
            if(!chkMatchCase.isSelected()) findText= txtFind.getText().toLowerCase(); // avoid case

            pattern = Pattern.compile(findText);

            matcher = pattern.matcher(txtEditor.getText());
            if(!chkMatchCase.isSelected()) matcher = pattern.matcher(txtEditor.getText().toLowerCase()); // avoid case


            startPoints.clear();
            now =0;
            while (matcher.find()){
                System.out.println(matcher.start());
                startPoints.add(matcher.start());

            }
            now = startPoints.get(0);
            i = startPoints.indexOf(now);
        });
        txtEditor.textProperty().addListener((observableValue, s, current) -> {
            findResultCount();
        });
    }
    public void findResultCount(){
        String query =txtFind.getText();
        if(query.isEmpty()) {
            lblResult.setText("0 Result");
            return;
        }

        String[] split = txtEditor.getText().concat(" ").split(query);
        lblResult.setText((split.length-1)+ " Results.");


    }
    @FXML
    void btnDownOnAction(ActionEvent event) {


        findText = txtFind.getText();
        if(i == startPoints.size()-1){
            now = startPoints.get(0);
            i = startPoints.indexOf(now);
            txtEditor.selectRange(startPoints.get(i),startPoints.get(i)+ findText.length());
            return;
        }
        now = startPoints.get(i+1);
        i = startPoints.indexOf(now);
        txtEditor.selectRange(startPoints.get(i),startPoints.get(i)+ findText.length());



    }

    @FXML
    void btnReplaceAllOnAction(ActionEvent event) {

    }

    @FXML
    void btnReplaceOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpOnAction(ActionEvent event) {
        findText = txtFind.getText();
        if(i == 0){
            now = startPoints.get(startPoints.size()-1);
            i = startPoints.indexOf(now);
            txtEditor.selectRange(startPoints.get(i),startPoints.get(i)+ findText.length());
            return;
        }
        now = startPoints.get(i-1);
        i = startPoints.indexOf(now);
        txtEditor.selectRange(startPoints.get(i),startPoints.get(i)+ findText.length());

    }

    @FXML
    void chkMatchCaseOnAction(ActionEvent event) {

    }

}
