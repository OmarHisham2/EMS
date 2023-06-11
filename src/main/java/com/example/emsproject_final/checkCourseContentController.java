

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
        import javafx.scene.paint.Color;
        import javafx.stage.Stage;

        import java.io.IOException;
        import java.net.URL;
        import java.util.Objects;
        import java.util.ResourceBundle;

        import static com.example.emsproject_final.Course.availableCourses;


public class checkCourseContentController implements Initializable {

    @FXML
    private Button button_CheckContent;

    @FXML
    private Button button_goBack;

    @FXML
    private Label label_proTip;

    @FXML
    private ChoiceBox<String> courses_choiceBox;

    @FXML
    private TextArea tf_CourseContent;

    private Scene scene;
    private Parent root;

    private Stage stage;

    public void goBack(ActionEvent event) throws IOException
    {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("student_Loggedin.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        for(int i =0; i < availableCourses.size(); i ++)
        {
            courses_choiceBox.getItems().addAll(availableCourses.get(i).getCourseName());
        }
    }




    public void checkContent(ActionEvent event)
    {
        boolean courseFound = false;
        for(int i = 0; i < availableCourses.size(); i++) {
            if (Objects.equals(courses_choiceBox.getValue(), availableCourses.get(i).getCourseName())) {
                courseFound = true;
                tf_CourseContent.setText(availableCourses.get(i).getContent());
                label_proTip.setVisible(false);
            }
        }

        if(!courseFound)
        {
            label_proTip.setText("Select a valid course!");
            label_proTip.setVisible(true);
            label_proTip.setTextFill(Color.color(0.921, 0.1960, 0.270));
        }


    }



}
