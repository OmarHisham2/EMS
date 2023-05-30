package com.example.emsproject_final;

//import GUI.GUIFrames;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.emsproject_final.Course.availableCourses;

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

    }

    @Override
    public void start(Stage stage) throws IOException {
        defaultCourses();
        stg=stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Title.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 760, 430);
        stage.setTitle("Examination Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
