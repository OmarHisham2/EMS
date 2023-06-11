package Functional;

import com.example.emsproject_final.Course;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.example.emsproject_final.Course.availableCourses;
import static junit.framework.TestCase.assertEquals;

public class TestingCourse {

    static Course Testing = new Course("Software Testing");

    static Course GameDev = new Course("Game Development");

    @BeforeClass
    public static void setUp() {
        availableCourses.add(GameDev);
        availableCourses.add(Testing);
    }

    @Test
    public void testGetMethods()
    {
        assertEquals("Game Development",GameDev.getCourseName());
        assertEquals("Software Testing",Testing.getCourseName());
    }
    @Test
    public void testCourseCheckContent()
    {
        GameDev.setContent("""
                Lecture 1 : Artificial Intelligence in Games
                Lecture 2 : Rendering Data
                Assignment 1 : Space Shooter""");

        assertEquals("""
                Lecture 1 : Artificial Intelligence in Games
                Lecture 2 : Rendering Data
                Assignment 1 : Space Shooter""",GameDev.getContent());
    }
}
