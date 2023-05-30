package com.example.emsproject_final;
import java.util.ArrayList;

public class Student {
    public static  int CourseCount;
    private int StudentId;
    private String StudentName ;
    private String StudentEmail;
    private double StudentGPA;
     public static ArrayList<Course> StudentCourses ;

    public static ArrayList<Student> studentList = new ArrayList<Student>();


    public Student() {
    }

    public Student(int studentId, String studentName,String studentEmail) {
        StudentId = studentId;
        StudentName = studentName;
        StudentEmail = studentEmail;
        StudentCourses = new ArrayList<>();
    }

    public void setStudentId(int studentId) {
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

    public int getStudentId() {
        return StudentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public double getStudentGPA() {
        return StudentGPA;
    }

    public boolean RegisteringCourse (Course course)
    {
//        if(this.StudentCourses.contains(course))
//            JOptionPane.showMessageDialog(null, "This course is registered", "Student", JOptionPane.INFORMATION_MESSAGE);
//        else
//            this.StudentCourses.add(course);

        return this.StudentCourses.contains(course);
    }
    public boolean TakingExam (Course course,double Grade)
    {
        CourseCount =  StudentCourses.indexOf(course);
        StudentCourses.set(CourseCount ,course).setGrade(Grade);
        StudentGPA += Grade ;
        if (StudentCourses.contains(course))
            return true;
        else
            return false;
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
}
