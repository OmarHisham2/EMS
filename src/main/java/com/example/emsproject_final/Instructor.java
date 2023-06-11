package com.example.emsproject_final;



import java.util.ArrayList;

import static com.example.emsproject_final.Course.availableCourses;

public class Instructor {
    private String InstructorId;
    private String InstructorName ;

    private String InstructorEmail;

    private String InstructorPassword;

    public static ArrayList<Instructor> instructorList = new ArrayList<Instructor>();
    Course course;



    public Instructor(String instructorId, String instructorName, String instructorEmail, String instructorPassword) {
        InstructorId = instructorId;
        InstructorName = instructorName;
        InstructorEmail = instructorEmail;
        InstructorPassword = instructorPassword;
    }



    public void setInstructorId(String instructorId) {
        instructorId = instructorId;
    }

    public void setInstructorName(String instructorName) {
        InstructorName = instructorName;
    }
    public void setInstructorEmail(String instructorEmail) {
        InstructorEmail = instructorEmail;
    }
    public void setInstructorPassword(String instructorPassword) {
        InstructorPassword = instructorPassword;
    }

    public String getInstructorId() {
        return InstructorId;
    }

    public String getInstructorName() {
        return InstructorName;
    }

    public String getInstructorPassword() { return InstructorPassword;}

    public String getInstructorEmail() { return InstructorEmail; }

    public static  boolean AddContent (Course course , String content)
    {
            course.setContent(content);
        return !content.isEmpty();
    }

    public static boolean AddExam (Course course , Exam exam)
    {
        course.addExam(exam);
        return !course.getExams().isEmpty();
    }
    public static boolean addCourse(Course course)
    {
        boolean coursealreadyExists = false;
        if(!course.getCourseName().isEmpty()) {
            for (int i = 0; i < availableCourses.size(); i++) {
                if (course.getCourseName().trim().equals(availableCourses.get(i).getCourseName()))
                {
                    coursealreadyExists = true;
                    break;
                }
            }

            if (!coursealreadyExists) {
                availableCourses.add(course);
                return true;
            }
        }
        else
        {
            return false;
        }
        return false;

    }


}
