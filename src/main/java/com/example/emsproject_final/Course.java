package com.example.emsproject_final;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Course {
    private String CourseName;
    private String Content = "";

    private ArrayList<String> ExamCorrectAnswer;

    private ArrayList<Exam> Exams = new ArrayList<>();
    private double Grade;

    public static ArrayList<Course> availableCourses = new ArrayList<Course>();


    public Course() {
    }


    public Course(String courseName) {
        CourseName = courseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public void setContent(String content) {
        Content += content;
    }


    public String getCourseName() {
        return CourseName;
    }

    public String getContent() {
        return Content;
    }

    public void addExam(Exam exam) {
        Exams.add(exam);
    }

    public ArrayList<Exam> getExams() {
        return Exams;
    }
}
