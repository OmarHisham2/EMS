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
import static com.example.emsproject_final.LoginController.studentDX;
import static com.example.emsproject_final.Student.studentList;

public class takeExamController implements Initializable {

    @FXML
    private Button button_goBack;

    @FXML
    private Button button_takeExam;

    @FXML
    private Label label_proTip;

    @FXML
    private ChoiceBox<String> registeredCourses_choiceBox;

    private Scene scene;
    private Parent root;

    private Stage stage;

    public static String selectedCourseforExam;
    public static int selectedCourseforExamIDX;

    public static Course targetCourse;

    @FXML
    void TakeExam(ActionEvent event) throws IOException
    {


        boolean courseFound = false;
        for(int i = 0; i < availableCourses.size(); i++)

        {
            if (Objects.equals(registeredCourses_choiceBox.getValue(), availableCourses.get(i).getCourseName())) {
                courseFound = true;
                selectedCourseforExam = availableCourses.get(i).getCourseName();
                 targetCourse = availableCourses.get(i);
                selectedCourseforExamIDX = i;
                if (availableCourses.get(selectedCourseforExamIDX).getExams().size() == 0)
                {
                    label_proTip.setText("No Exam is available for this course.");
                    label_proTip.setTextFill(Color.color(0.600, 0.1960, 0.270));
                    break;
                }
                else {
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("examPage.fxml")));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
            }

            if(!courseFound)
            {
                label_proTip.setText("Select a valid course!");
                label_proTip.setTextFill(Color.color(0.921, 0.1960, 0.270));
            }
        }





    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        for(int i =0; i < studentList.get(studentDX).StudentCourses.size(); i ++)
        {
            registeredCourses_choiceBox.getItems().addAll(studentList.get(studentDX).StudentCourses.get(i).getCourseName());
        }
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("student_Loggedin.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

}
