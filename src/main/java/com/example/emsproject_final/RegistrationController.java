package com.example.emsproject_final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static com.example.emsproject_final.Instructor.instructorList;
import static com.example.emsproject_final.Student.studentList;


public class RegistrationController {


    @FXML
    private Label label_proTip;
    @FXML
    private Button button_back;

    @FXML
    private Button button_register;

    @FXML
    private TextField tf_Email;

    @FXML
    private TextField tf_Name;

    @FXML
    private PasswordField tf_Password;

    @FXML
    private TextField tf_studentID;

    private Scene scene;
    private Parent root;

    private Stage stage;

    public void Register(ActionEvent event) {

        long start = System.nanoTime();

        boolean alreadyExists = false;
        boolean allFilled = false;

        String student_Mail = tf_Email.getText().replaceAll("\\s+","");
        String student_ID = tf_studentID.getText().replaceAll("\\s+","");




        if (tf_Name.getText().trim().isEmpty() || tf_Email.getText().trim().isEmpty() || tf_studentID.getText().trim().isEmpty() || tf_Password.getText().isEmpty()) {
            label_proTip.setText("Please enter all the student's details");
            label_proTip.setTextFill(Color.color(0.921, 0.1960, 0.270));
        }
        else {
            allFilled = true;
            for (int i = 0; i < studentList.size(); i++) {
                if (Objects.equals(studentList.get(i).getStudentId(), (student_ID)) || (Objects.equals(studentList.get(i).getStudentEmail(), (student_Mail))) || (student_ID.equals("-1"))) {
                    alreadyExists = true;
                    break;
                }
            }

            for(int i = 0; i < instructorList.size();i++)
            {
                if (Objects.equals(instructorList.get(i).getInstructorId(), (student_ID)) || (Objects.equals(instructorList.get(i).getInstructorEmail(), (student_Mail)))) {
                    alreadyExists = true;
                    break;
                }
            }
        }
        if (alreadyExists) {
            label_proTip.setText("User is already registered!");
            label_proTip.setTextFill(Color.color(0.921, 0.1960, 0.270));
        }
         else if ( allFilled  && !student_ID.matches("^-.*$")){
            Student student = new Student(student_ID, tf_Name.getText(), student_Mail, tf_Password.getText());
            studentList.add(student);
            label_proTip.setText("Student registered successfully!");
            label_proTip.setTextFill(Color.color(0.654, 0.8901, 0.603));
        }
        else if ( allFilled  && student_ID.matches("^.*$")){
            Instructor instructor = new Instructor(student_ID, tf_Name.getText(), student_Mail, tf_Password.getText());
            instructorList.add(instructor);
            label_proTip.setText("Instructor registered successfully!");
            label_proTip.setTextFill(Color.color(0.5, 0.5, 0.9));
        }
        else
        {
            label_proTip.setText("Please enter all the person's details");
            label_proTip.setTextFill(Color.color(0.921, 0.1960, 0.270));
        }

        long end = System.nanoTime();
        long microseconds = (end - start) / 1000;
        System.out.println("Time taken to register : " + microseconds + " microseconds");
}

    public void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Title.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }




}
