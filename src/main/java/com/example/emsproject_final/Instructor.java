package com.example.emsproject_final;



public class Instructor {
    private int InstructorId;
    private String InstructorName ;
    Course course;
    public Instructor() {
    }


    public Instructor(int instructorId, String instructorName, Course course) {
        InstructorId = instructorId;
        InstructorName = instructorName;
        this.course = course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public void setInstructorId(int instructorId) {
        InstructorId = instructorId;
    }

    public void setInstructorName(String instructorName) {
        InstructorName = instructorName;
    }

    public int getInstructorId() {
        return InstructorId;
    }

    public String getInstructorName() {
        return InstructorName;
    }

    public static  boolean AddContent (Course course , String content)
    {
            course.setContent(content);
        return !course.getContent().isEmpty();
    }

    public static boolean AddExam (Course course , Exam exam)
    {
        course.addExam(exam);
        return !course.getExams().isEmpty();
    }

//    public void GetStudentInfo (Student student, int id, JTextField name,JTextField course,JTextField grade,JTextField gpa)
//    {
//        name.setText(student.getStudentName());
//        String courses = " " ,garde = " ";
//
//        for (int i =0 ; i < student.StudentCourses.size(); i++)
//        {
//            courses +=  student.StudentCourses.get(i).getCourseName()+ "  ";
//            garde+= student.StudentCourses.get(i).getGrade()+ "  ";
//        }
//        course.setText(courses);
//        grade.setText(String.valueOf(garde));
//        gpa.setText(String.valueOf(student.GenerateGPA()));
//    }
}
