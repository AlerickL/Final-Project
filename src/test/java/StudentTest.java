import org.alerick.Address;
import org.alerick.Course;
import org.alerick.Department;
import org.alerick.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudentTest {

    @Test
    @DisplayName("add course to empty student")
    void testRegisterCourse1() {
        Student student = new Student("", Student.Gender.MALE,
                new Address(1, "", "", Address.Province.QC, "a1a2a3"),
                new Department(""));
        Course course = new Course("", 1, new Department(""));
        boolean expected = true;
        boolean actual = student.registerCourse(course);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("add course to student with other courses")
    void testRegisterCourse2() {
        Student student = new Student("", Student.Gender.MALE,
                new Address(1, "", "", Address.Province.QC, "a1a2a3"),
                new Department(""));
        Course course1 = new Course("", 1, new Department(""));
        Course course2 = new Course("", 1, new Department(""));
        student.registerCourse(course1);
        boolean expected = true;
        boolean actual = student.registerCourse(course2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("add course to student already taking course")
    void testRegisterCourse3() {
        Student student = new Student("", Student.Gender.MALE,
                new Address(1, "", "", Address.Province.QC, "a1a2a3"),
                new Department(""));
        Course course = new Course("", 1, new Department(""));
        student.registerCourse(course);
        boolean expected = false;
        boolean actual = student.registerCourse(course);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("remove student's only course")
    void testDropCourse1() {
        Student student = new Student("", Student.Gender.MALE,
                new Address(1, "", "", Address.Province.QC, "a1a2a3"),
                new Department(""));
        Course course = new Course("", 1, new Department(""));
        student.registerCourse(course);
        boolean expected = true;
        boolean actual = student.dropCourse(course);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("remove course from student with 2 courses")
    void testDropCourse2() {
        Student student = new Student("", Student.Gender.MALE,
                new Address(1, "", "", Address.Province.QC, "a1a2a3"),
                new Department(""));
        Course course1 = new Course("", 1, new Department(""));
        Course course2 = new Course("", 1, new Department(""));
        student.registerCourse(course1);
        student.registerCourse(course2);
        boolean expected = true;
        boolean actual = student.dropCourse(course1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("remove course from student not taking it")
    void testDropCourse3() {
        Student student = new Student("", Student.Gender.MALE,
                new Address(1, "", "", Address.Province.QC, "a1a2a3"),
                new Department(""));
        Course course1 = new Course("", 1, new Department(""));
        Course course2 = new Course("", 1, new Department(""));
        student.registerCourse(course1);
        boolean expected = false;
        boolean actual = student.dropCourse(course2);

        Assertions.assertEquals(expected, actual);
    }
}
