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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.example.emsproject_final.Course.availableCourses;
import static com.example.emsproject_final.LoginController.studentDX;
import static com.example.emsproject_final.Student.studentList;

public class addExamController implements Initializable {

    @FXML
    private Button button_addContent;

    @FXML
    private ChoiceBox<String> course_choiceBox;

    @FXML
    private Label label_proTip;

    @FXML
    private TextArea tf_Question;

    @FXML
    private TextField tf_answer1;

    @FXML
    private TextField tf_answer2;

    @FXML
    private TextField tf_answer3;

    @FXML
    private TextField tf_answer4;

    @FXML
    private TextField tf_answerCorrect;

    private Scene scene;
    private Parent root;

    private Stage stage;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        for(int i =0; i < availableCourses.size(); i ++)
        {
            course_choiceBox.getItems().add(availableCourses.get(i).getCourseName());
        }
    }

    public void goBack(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("instructor_Loggedin.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }



    public void addQuestion(ActionEvent event)
    {
        for(int i = 0; i < availableCourses.size(); i++) {
            if (Objects.equals(course_choiceBox.getValue(), availableCourses.get(i).getCourseName()))
            {
                Exam exam1 = new Exam(tf_Question.getText(),new String[] {tf_answer1.getText(),
                        tf_answer2.getText(),tf_answer3.getText(),tf_answer4.getText()},tf_answerCorrect.getText());
                availableCourses.get(i).addExam(exam1);
                label_proTip.setText("Question added successfully!");
                label_proTip.setTextFill(Color.color(0.654, 0.8901, 0.603));
            }
            }


    }
}
