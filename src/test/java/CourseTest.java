import org.alerick.Course;
import org.alerick.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CourseTest {

    @Test
    @DisplayName("20 + 80 -> true")
    void testIsAssignmentValid() {
        Course course = new Course("", 1, new Department(""));
        course.addAssignment("Test1", 20);
        course.addAssignment("FinalTest", 80);
        boolean actual = course.isAssignmentValid();
        boolean expected = true;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    @DisplayName("20 + 60 -> false")
    void testIsAssignmentValid2() {
        Course course = new Course("", 1, new Department(""));
        course.addAssignment("Test1", 20);
        course.addAssignment("FinalTest", 60);
        boolean actual = course.isAssignmentValid();
        boolean expected = false;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    @DisplayName("0 + 0 -> false")
    void testIsAssignmentValid3() {
        Course course = new Course("", 1, new Department(""));
        course.addAssignment("Test1", 0);
        course.addAssignment("FinalTest", 0);
        boolean actual = course.isAssignmentValid();
        boolean expected = false;

        Assertions.assertEquals(actual, expected);
    }
}
