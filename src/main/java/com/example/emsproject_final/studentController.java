package com.example.emsproject_final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.example.emsproject_final.LoginController.loggedinID;
import static com.example.emsproject_final.examController.examDone;

public class studentController implements Initializable {

    @FXML
    private Button button_RegisterCourse;

    @FXML
    private Button button_checkCourse;

    @FXML
    private Button button_takeExam;

    @FXML
    private Button button_Logout;
    @FXML
    private Label label_proTip2;

    private Scene scene;
    private Parent root;

    private Stage stage;



    public void loadTakeExam(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("takeExam.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void loadCheckCourse(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("checkCourseContent.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void loadRegisterCourse(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("registerCourse.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void logOut(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Title.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        loggedinID = ""; // Reset Logged in ID
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(examDone)
        {
            examDone = false;
            label_proTip2.setVisible(true);
        }
    }
}
