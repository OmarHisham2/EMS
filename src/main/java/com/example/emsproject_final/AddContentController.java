package com.example.emsproject_final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.example.emsproject_final.Course.availableCourses;

public class AddContentController implements Initializable {

    @FXML
    private Button button_addContent;

    @FXML
    private ChoiceBox<String> course_choiceBox;

    @FXML
    private Label label_proTip;

    @FXML
    private TextArea tf_Content;



    private Scene scene;
    private Parent root;

    private Stage stage;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        for(int i =0; i < availableCourses.size(); i ++)
        {
            course_choiceBox.getItems().addAll(availableCourses.get(i).getCourseName());
        }
    }



    @FXML
    void addContent(ActionEvent event)
    {
        for(int i = 0; i < availableCourses.size(); i++) {
            if (Objects.equals(course_choiceBox.getValue(), availableCourses.get(i).getCourseName())) {
                availableCourses.get(i).setContent(tf_Content.getText());
                label_proTip.setText("Content added successfully!");
                label_proTip.setTextFill(Color.color(0.654, 0.8901, 0.603));
            }
        }


    }

    public void goBack(ActionEvent event) throws IOException
    {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("instructor_Loggedin.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }



}
