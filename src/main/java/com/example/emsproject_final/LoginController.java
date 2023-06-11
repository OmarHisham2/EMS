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
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static com.example.emsproject_final.Instructor.instructorList;
import static com.example.emsproject_final.Student.studentList;

public class LoginController {

    @FXML
    private Button button_login;

    @FXML
    private Button button_toRegister;

    @FXML
    private Label label_infoWrong;


    @FXML
    private TextField tf_ID;

    @FXML
    private PasswordField tf_Password;
    private Scene scene;
    private Parent root;

    private Stage stage;

    public static String loggedinID  = "";
    public static int studentDX  = -99;


    public void Login(ActionEvent event) throws IOException {

        int found = 0;

       for (int i =0; i < studentList.size(); i++)
       {
            if (Objects.equals(studentList.get(i).getStudentId(),tf_ID.getText()) && Objects.equals(studentList.get(i).getStudentPassword(),tf_Password.getText()))
            {
                found = 1;
                studentDX = i;
                break;
            }
       }

       if (found == 1)
       {

           Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("student_Loggedin.fxml")));
           stage = (Stage)((Node)event.getSource()).getScene().getWindow();
           Scene scene = new Scene(root);
           stage.setScene(scene);
           stage.show();
           loggedinID = studentList.get(studentDX).getStudentId();

       }
       else
       {
           for (int i =0; i < instructorList.size(); i++)
           {
               if (Objects.equals(instructorList.get(i).getInstructorId(),tf_ID.getText()) && Objects.equals(instructorList.get(i).getInstructorPassword(),tf_Password.getText()))
               {
                   found = 2;
                   break;
               }
           }
       }
       if (found == 2)
       {
           Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("instructor_Loggedin.fxml")));
           stage = (Stage)((Node)event.getSource()).getScene().getWindow();
           Scene scene = new Scene(root);
           stage.setScene(scene);
           stage.show();

       }
       else
       {
           label_infoWrong.setVisible(true);
       }
    }
    public void loadRegisterPage(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Registration.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();



    }

}
