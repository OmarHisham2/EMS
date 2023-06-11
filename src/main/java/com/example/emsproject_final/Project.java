package com.example.emsproject_final;

//import GUI.GUIFrames;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.emsproject_final.Course.availableCourses;
import static com.example.emsproject_final.Student.studentList;

public class Project extends Application {


    private static Stage stg;

    public void defaultCourses()

    {
        Course c1 = new Course("OS");
        Course c2 = new Course("Algo");
        Course c3 = new Course("Database");
        availableCourses.add(c1);
        availableCourses.add(c2);
        availableCourses.add(c3);

//        Student s1 = new Student("1","omar@gmail.com","omar@gmail.com", "1");
//        Student s2 = new Student("20P6484",	"felix",	"felix@hisham.com", "2");
//        Student s3 = new Student("21qe","jaiden","jaidenrr@eng.asu.edu.eg", "3");
//        Student s4 = new Student("441","jada","smith@will.com", "4");
//        studentList.add(s1);
//        studentList.add(s2);
//        studentList.add(s3);
//        studentList.add(s4);




    }

    @Override
    public void start(Stage stage) throws IOException {
        defaultCourses();
        stg=stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Title.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 760, 430);
        stage.setTitle("Learning Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
