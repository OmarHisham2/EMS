package com.example.emsproject_final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.example.emsproject_final.Course.availableCourses;
import static com.example.emsproject_final.LoginController.loggedinID;
import static com.example.emsproject_final.LoginController.studentDX;
import static com.example.emsproject_final.Student.studentList;

public class registerCourseController implements Initializable {

    @FXML
    private Button button_goBack;

    @FXML
    private Button button_registerCourse;

    @FXML
    private ChoiceBox<String> courses_choiceBox;

    @FXML
    private Label label_proTip;

    private Scene scene;
    private Parent root;

    private Stage stage;


    @FXML
    void goBack(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("student_Loggedin.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        for(int i =0; i < availableCourses.size(); i ++)
        {
            courses_choiceBox.getItems().addAll(availableCourses.get(i).getCourseName());
        }
    }


    @FXML
    void registerCourse(ActionEvent event)
    {
        for(int i = 0; i < availableCourses.size(); i++) {
            if (Objects.equals(courses_choiceBox.getValue(), availableCourses.get(i).getCourseName()))
            {
                studentList.get(studentDX).StudentCourses.add(availableCourses.get(i));
                label_proTip.setText("Course registered successfully!");
                label_proTip.setTextFill(Color.color(0.654, 0.8901, 0.603));
            }
        }


    }

}
