package com.example.emsproject_final;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Objects;

import static com.example.emsproject_final.LoginController.studentDX;
import static com.example.emsproject_final.Student.StudentCourses;
import static com.example.emsproject_final.Student.studentList;
import static com.example.emsproject_final.takeExamController.selectedCourseforExamIDX;

public class Exam
{
    public String question;
    public String[] answers;
    public String correctAnswer;

    public Exam(String question, String[] answers, String correctAnswer)
    {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public Exam() {
    }

    public void calculateNewGPA(int ExamGrade,int nQuestions,Student S,int nTakenExams)
    {
        studentList.get(studentList.indexOf(S)).setStudentGPA(( studentList.get(studentList.indexOf(S)).getStudentGPA() +  ( (double) ExamGrade * 4 / (double)nQuestions ) ) / (nTakenExams+1) );
    }

    public boolean checkAnswer(String Answer, int QCounter, int selectedCourse) {
        ArrayList<Exam> exam = StudentCourses.get(selectedCourse).getExams();
        return Objects.equals(Answer, exam.get(QCounter).correctAnswer) && !Answer.isEmpty();
    }

}
