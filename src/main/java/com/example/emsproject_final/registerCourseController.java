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
import static com.example.emsproject_final.Student.StudentCourses;
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

    @FXML
    private Label label_proTip2;

    private Scene scene;
    private Parent root;

    private Stage stage;


    @FXML
    void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("student_Loggedin.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        boolean isRegistered = false;
        for (int i = 0; i < availableCourses.size(); i++) {
            {
                    isRegistered = false;
                    for(int j = 0; j < availableCourses.size(); j++)
                    {
                        try {
                            if (StudentCourses.get(j).getCourseName() == availableCourses.get(i).getCourseName()) {
                                isRegistered = true;
                                break;
                            }
                        }
                        catch(IndexOutOfBoundsException e)
                        {
                        }

                }

                if(!isRegistered)
                {
                    courses_choiceBox.getItems().addAll(availableCourses.get(i).getCourseName());
                }
                else
                {continue;}

            }
        }

    }




    @FXML
    void registerCourse(ActionEvent event) throws IOException {

        boolean courseFound = false;
        for (int i = 0; i < availableCourses.size(); i++) {
            if (Objects.equals(courses_choiceBox.getValue(), availableCourses.get(i).getCourseName()) )
            {
                courseFound = true;
                studentList.get(studentDX).registerCourse(studentDX,availableCourses.get(i),i);
                label_proTip.setText("Course registered successfully!");
                label_proTip.setTextFill(Color.color(0.654, 0.8901, 0.603));
                button_registerCourse.setDisable(true);
                label_proTip2.setVisible(true);

            }
        }

        if(!courseFound)
        {
            label_proTip.setText("Select a valid course!");
            label_proTip.setTextFill(Color.color(0.921, 0.1960, 0.270));
        }




    }

}
