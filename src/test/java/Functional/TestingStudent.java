package Functional;

import com.example.emsproject_final.Course;
import com.example.emsproject_final.Student;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestingStudent {

    Course CS = new Course("Software Testing");
    Student Ali = new Student("1","Ali","Ali@eng.asu.edu.eg");
    @Test
    void registerCourse()
    {
        assertEquals("1",Ali.getStudentId());
    }
}
