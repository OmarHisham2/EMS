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
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.example.emsproject_final.LoginController.studentDX;
import static com.example.emsproject_final.Student.StudentCourses;
import static com.example.emsproject_final.Student.studentList;
import static com.example.emsproject_final.takeExamController.selectedCourseforExam;
import static com.example.emsproject_final.takeExamController.selectedCourseforExamIDX;

public class examController implements Initializable {

    @FXML
    private Button button_goBack;

    @FXML
    private Button button_submitAnswer;

    @FXML
    private Label label_Choice1;

    @FXML
    private Label label_Choice2;

    @FXML
    private Label label_Choice3;

    @FXML
    private Label label_Choice4;

    @FXML
    private Label label_Question;

    @FXML
    private Label label_proTip;

    @FXML
    private TextField tf_Answer;
    private Scene scene;
    private Parent root;

    private Stage stage;

    ArrayList<Exam> exam = StudentCourses.get(selectedCourseforExamIDX).getExams();
    boolean firstQ = false;
    boolean examDone = false;

    public static int QCounter = 0;
    public static int ExamGrade = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        label_Question.setText(exam.get(0).question);
        label_Choice1.setText(exam.get(0).answers[0]);
        label_Choice2.setText(exam.get(0).answers[1]);
        label_Choice3.setText(exam.get(0).answers[2]);
        label_Choice4.setText(exam.get(0).answers[3]);
            }


    public void checkAnswer(ActionEvent event) throws IOException {

            if(Objects.equals(tf_Answer.getText(), exam.get(QCounter).correctAnswer) && !tf_Answer.getText().trim().isEmpty())
            {
                label_proTip.setText("Question " + QCounter + " has been answered correctly!" );
                label_proTip.setTextFill(Color.color(0.654, 0.8901, 0.603));
                QCounter++;
                ExamGrade+=10;
                // Good job!
                updateQuestion();

            }
            else
            {
                label_proTip.setText("Question " + QCounter + " has been answered Incorrectly!");
                label_proTip.setTextFill(Color.color(0.921, 0.1960, 0.270));
                QCounter++;
                ExamGrade-=10;
                updateQuestion();
                //Bad job :(
            }

            if(examDone)
            {
                studentList.get(studentDX).setStudentGPA(((double) ExamGrade /QCounter));
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("student_Loggedin.fxml")));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

    }

    public void updateQuestion()
    {
        if(QCounter < exam.size()) {
            label_Question.setText(exam.get(QCounter).question);
            label_Choice1.setText(exam.get(QCounter).answers[0]);
            label_Choice2.setText(exam.get(QCounter).answers[1]);
            label_Choice3.setText(exam.get(QCounter).answers[2]);
            label_Choice4.setText(exam.get(QCounter).answers[3]);
        }
        else if (QCounter == exam.size())
        {
            examDone = true;
            // EXAM DONE!
        }
    }


    public void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("student_Loggedin.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


}
