package Functional;

import com.example.emsproject_final.Course;
import com.example.emsproject_final.Instructor;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.example.emsproject_final.Course.availableCourses;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestingInstructor {


    static Course SW = new Course("Software Testing");
    static Course OS = new Course("Operating Systems");
    static Course Testing = new Course("Software Testing");

    static Course GameDev = new Course("Game Development"); // This course will not be added to course List


    Instructor Fahim = new Instructor("-1", "Fahim Fawzy", "Fahim@gmail.com", "Fahim441!");


    @BeforeClass
    public static void setCourses() {
        availableCourses.add(SW);
        availableCourses.add(OS);
        availableCourses.add(Testing);

    }


    @Test
    public void testGetMethods()
    {
        assertEquals("Fahim Fawzy", Fahim.getInstructorName());
        assertEquals("-1", Fahim.getInstructorId());
        assertEquals("Fahim@gmail.com",Fahim.getInstructorEmail());
        assertEquals("Fahim441!",Fahim.getInstructorPassword());
    }

    @Test
    public void testCourseAddition() {
        assertTrue(Instructor.addCourse(GameDev));
        assertFalse(Instructor.addCourse(GameDev));
    }

    @Test
    public void testContentAddition()
    {
        assertTrue(Instructor.AddContent(OS, "Lecture 1 : MIPS Introduction"));
        assertFalse(Instructor.AddContent(OS, ""));
    }


}
