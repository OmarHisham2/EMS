package com.example.emsproject_final;

import java.util.ArrayList;
import java.util.Objects;

import static com.example.emsproject_final.Course.availableCourses;

public class Student {
    public static  int CourseCount;
    private String StudentId;
    private String StudentName ;
    private String StudentEmail;

    private String StudentPassword;
    private double StudentGPA;
     public static ArrayList<Course> StudentCourses ;

    public static ArrayList<Student> studentList = new ArrayList<Student>();



    public Student(String password) {
        this.StudentPassword = password;
    }

    public Student(String studentId, String studentName, String studentEmail, String password) {
        StudentId = studentId;
        StudentName = studentName;
        StudentEmail = studentEmail;
        this.StudentPassword = password;
        StudentCourses = new ArrayList<>();
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public void setStudentGPA(double studentGPA) {
        if (studentGPA >=0)
        StudentGPA = studentGPA;
        else
            StudentGPA = 0;
    }

    public String getStudentId() {
        return StudentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public String getStudentPassword() {
        return StudentPassword;
    }

    public double getStudentGPA() {
        return StudentGPA;
    }




    public void registerCourse (int studentDX, Course Course, int CourseDX)
    {
            studentList.get(studentDX).StudentCourses.add(availableCourses.get(CourseDX));
    }

    public boolean IsRegistered (Course Course)
    {
        return StudentCourses.contains(Course);
    }
    public double GenerateGPA()
    {
        return this.StudentGPA ;
    }

    public String getStudentEmail() {
        return StudentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        StudentEmail = studentEmail;
    }

    public String[] getRegisteredCourses()
    {
        String[] result = new String[StudentCourses.size()];

        int i = 0;
        for (Course obj : StudentCourses) {
            result[i] = String.valueOf(obj.getCourseName());
            i++;
        }
        return result;
    }

    public boolean Answer(String Answer, int QCounter, int selectedCourse)
    {
        ArrayList<Exam> exam = StudentCourses.get(selectedCourse).getExams();
        return Objects.equals(Answer, exam.get(QCounter).correctAnswer) && !Answer.isEmpty();
    }
}
