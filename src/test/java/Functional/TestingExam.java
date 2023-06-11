package Functional;

import com.example.emsproject_final.Course;
import com.example.emsproject_final.Exam;
import com.example.emsproject_final.Instructor;
import com.example.emsproject_final.Student;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.example.emsproject_final.Course.availableCourses;
import static com.example.emsproject_final.Student.studentList;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestingExam {
    static Course SW = new Course("Software Testing");
    static Course OS = new Course("Operating Systems");
    static Course Testing = new Course("Software Testing");

    static int QuestionCounter = 0;

    static int ExamGrade = 0;

    static int examsTakenPreviously = 0;


    Instructor Fahim = new Instructor("-1", "Fahim Fawzy", "Fahim@gmail.com", "Fahim441!");

    static Student Ahmed = new Student("20P1234", "Ahmed", "Ahmed@outlook.com", "Ahm123ed");

    Exam q1 = new Exam("What is 2+2?", new String[]{"4", "25", "6", "0"}, "4");
    Exam q2 = new Exam("What is 51+49?", new String[]{"100", "200", "103", "104"}, "100");

    Exam examController = new Exam();


    @BeforeClass
    public static void setCourses() {
        availableCourses.add(SW);
        availableCourses.add(OS);
        availableCourses.add(Testing);
        studentList.add(Ahmed);

    }

    @Test
    public void testExamTaking() // Stubs for ExamGrade and QuestionCounter are needed.
    {
        Ahmed.registerCourse(0, SW, 0);

        Instructor.AddExam(SW, q1);
        Instructor.AddExam(SW, q2);

        assertTrue(Ahmed.Answer("4", QuestionCounter, 0));
        ExamGrade++; // Ahmed Answered correctly

        QuestionCounter++;

        assertFalse(Ahmed.Answer("103", QuestionCounter, 0));
        //Ahmed didn't answer correctly
        QuestionCounter++;


        examController.calculateNewGPA(ExamGrade, QuestionCounter, Ahmed, examsTakenPreviously);

        assertEquals(2.0, Ahmed.getStudentGPA());


    }
}
