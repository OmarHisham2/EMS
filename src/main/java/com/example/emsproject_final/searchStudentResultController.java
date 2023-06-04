package com.example.emsproject_final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.example.emsproject_final.Student.studentList;
import static com.example.emsproject_final.searchStudentController.selectedStudentID;

public class searchStudentResultController implements Initializable {

    @FXML
    private Button button_goBack;

    @FXML
    private TextArea tf_studentData;

    private Scene scene;
    private Parent root;

    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        setField();
    }

    @FXML
    public void goBack(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("searchStudent.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void setField()
    {
        boolean notFound = true;
        if(!(selectedStudentID != "") )
        {
            for(int i =0; i < studentList.size(); i++)
            {
                if( selectedStudentID == studentList.get(i).getStudentId()) {
                    notFound = false;
                    tf_studentData.setText("Student's Name : " + studentList.get(i).getStudentName()
                            + "\n" + "Student's Email : " + studentList.get(i).getStudentEmail() + "\n"
                            + "Student's ID :  " + studentList.get(i).getStudentId() + "\n"
                            + "Student's GPA :  " + studentList.get(i).getStudentGPA() + "\n"
                            + "Student's Registered Courses are : " + Arrays.toString(studentList.get(i).getRegisteredCourses()) + "\n"
                    );
                }
            }
        }
        if(notFound)
        {
            tf_studentData.setText("ID Not found.");
        }

    }


}
