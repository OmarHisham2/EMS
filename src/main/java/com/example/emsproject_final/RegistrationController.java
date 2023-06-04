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
import java.util.ArrayList;
import java.util.Objects;

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
    private TextField tf_studentID;

    private Scene scene;
    private Parent root;

    private Stage stage;

    public void Register(ActionEvent event) {
        boolean alreadyExists = false;
        boolean allFilled = false;

        String student_Mail = tf_Email.getText().replaceAll("\\s+","");
        String student_ID = tf_studentID.getText().replaceAll("\\s+","");



        if (tf_Name.getText().trim().isEmpty() || tf_Email.getText().trim().isEmpty() || tf_studentID.getText().trim().isEmpty()) {
            label_proTip.setText("Please enter all the student's details");
            label_proTip.setTextFill(Color.color(0.921, 0.1960, 0.270));
        }
        else {
            allFilled = true;
            for (int i = 0; i < studentList.size(); i++) {
                if (Objects.equals(studentList.get(i).getStudentId(), (student_ID)) || (Objects.equals(studentList.get(i).getStudentEmail(), (student_Mail)))) {
                    alreadyExists = true;
                    break;
                }
            }

        }
        if (alreadyExists) {
            label_proTip.setText("User is already registered!");
            label_proTip.setTextFill(Color.color(0.921, 0.1960, 0.270));
        }
         else if ( allFilled ){
            Student student = new Student(student_ID, tf_Name.getText(), student_Mail);
            studentList.add(student);
            label_proTip.setText("Student registered successfully!");
            label_proTip.setTextFill(Color.color(0.654, 0.8901, 0.603));
        }
        else
        {
            label_proTip.setText("Please enter all the student's details");
            label_proTip.setTextFill(Color.color(0.921, 0.1960, 0.270));
        }
}

    public void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Title.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }




}
