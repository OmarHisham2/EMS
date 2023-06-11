package Functional;

import com.example.emsproject_final.Course;
import com.example.emsproject_final.Student;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.example.emsproject_final.Course.availableCourses;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestingStudent

{
    static Course SW = new Course("Software Testing");
    static Course OS = new Course("Operating Systems");
    static Course Testing = new Course("Software Testing");

    static Student Ali = new Student("20P0001","Ali","Ali@eng.asu.edu.eg", "Ali123");
    static Student Belal = new Student("20P4129","Belal","Belal@gmail.com", "Belal4411!");
    static Student Eslam = new Student("20P3160","Eslam","Eslam@yahoo.com", "sad442happy!");




    @BeforeClass
    public static void setCoursesAndStudents()
    {
        availableCourses.add(SW);
        availableCourses.add(OS);
        availableCourses.add(Testing);

        Student.studentList.add(Ali);
        Student.studentList.add(Belal);
        Student.studentList.add(Eslam);
    }



    @Test
    public void testGetMethods()
    {
        assertEquals("20P0001",Ali.getStudentId());
        assertEquals("Eslam@yahoo.com",Eslam.getStudentEmail());
        assertEquals("Belal4411!",Belal.getStudentPassword());

    }

    @Test
    public void testCourseRegistration()
    {
        Ali.registerCourse(0,SW,0);
        assertTrue(Ali.IsRegistered(SW));
        assertFalse(Ali.IsRegistered(OS));

        Eslam.registerCourse(2,SW,0);
        Eslam.registerCourse(2,OS,1);
        Eslam.registerCourse(2,Testing,2);

        assertTrue(Eslam.IsRegistered(Testing));
    }



}
