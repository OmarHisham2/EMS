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

import static com.example.emsproject_final.Course.availableCourses;
import static com.example.emsproject_final.Student.studentList;

public class addCourseController {

    @FXML
    private Button button_addCourse;

    @FXML
    private Label label_proTip;

    @FXML
    private TextField tf_courseName;

    private Scene scene;
    private Parent root;

    private Stage stage;

    @FXML
    void addCourse(ActionEvent event)
    {

        boolean coursealreadyExists = false;
        if(!tf_courseName.getText().trim().isEmpty()) {
            for (int i = 0; i < availableCourses.size(); i++) {
                if (tf_courseName.getText().trim() == availableCourses.get(i).getCourseName()) {
                    label_proTip.setText("Course already exists!");
                    label_proTip.setTextFill(Color.color(0.921, 0.1960, 0.270));
                    coursealreadyExists = true;
                    break;
                }
            }

            if (!coursealreadyExists) {
                Course course = new Course(tf_courseName.getText());
                availableCourses.add(course);
                label_proTip.setText("Course added successfully!");
                label_proTip.setTextFill(Color.color(0.654, 0.8901, 0.603));
            }
        }
        else
        {
            label_proTip.setText("Please enter a course name!");
            label_proTip.setTextFill(Color.color(0.921, 0.1960, 0.270));
        }

    }
    public void goBack(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("instructor_Loggedin.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
