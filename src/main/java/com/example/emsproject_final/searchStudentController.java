package com.example.emsproject_final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class searchStudentController {

    @FXML
    private Button button_goBack;

    @FXML
    private Button button_searchStudent;

    @FXML
    private Label label_proTip;

    @FXML
    private TextField tf_studentID;


    private Scene scene;
    private Parent root;

    private Stage stage;

    public static String selectedStudentID = "";
    @FXML
    public void goBack(ActionEvent event) throws IOException
    {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("instructor_Loggedin.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void sendID(ActionEvent event) throws IOException {
        if(tf_studentID.getText().trim().isEmpty())
        {
            label_proTip.setText("Please enter a student ID!");
            label_proTip.setTextFill(Color.color(0.921, 0.1960, 0.270));
        }
        else {
            selectedStudentID = (tf_studentID.getText());
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("searchStudentResult.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

}
