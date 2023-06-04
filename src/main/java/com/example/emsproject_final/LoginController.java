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
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

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

    private Scene scene;
    private Parent root;

    private Stage stage;

    public static String loggedinID  = "";
    public static int studentDX  = -99;


    public void Login(ActionEvent event) throws IOException {

        boolean found = false;

       for (int i =0; i < studentList.size(); i++)
       {
            if (Objects.equals(studentList.get(i).getStudentId(), Integer.parseInt(tf_ID.getText())))
            {
                found = true;
                studentDX = i;
                break;
            }
       }

       if (found)
       {

           Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("student_Loggedin.fxml")));
           stage = (Stage)((Node)event.getSource()).getScene().getWindow();
           Scene scene = new Scene(root);
           stage.setScene(scene);
           stage.show();
           loggedinID = studentList.get(studentDX).getStudentId();

       }
       else if (Objects.equals(tf_ID.getText(), "-1"))
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
