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

    @FXML
    void TakeExam(ActionEvent event) throws IOException
    {

        for(int i = 0; i < studentList.get(studentDX).StudentCourses.size(); i++)

        {
            if (Objects.equals(registeredCourses_choiceBox.getValue(), availableCourses.get(i).getCourseName())) {
                selectedCourseforExam = availableCourses.get(i).getCourseName();
                selectedCourseforExamIDX = i;
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("examPage.fxml")));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
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
