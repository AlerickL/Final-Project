package org.alerick;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
public class Student {
    private final String studentId;
    @Setter private String studentName;
    @Setter private Gender gender;
    @Setter private Address address;
    @Setter private Department department;
    @Setter private List<Course> registeredCourses;
    private static int nextId = 1;

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = String.format("S%06d", nextId++);
        this.studentName = Util.toTitleCase(studentName);
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    /**
     * Registers a new course for a student:
     * i. adds the course to the student's registered courses.
     * ii. adds the student to the course's registered students.
     * iii. adds a null to each assignment in the course.
     * @param course the course.
     * @return if the student was registered in the course
     */
    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            return false;
        } else {
            registeredCourses.add(course);
            course.getRegisteredStudents().add(this);
            List<Assignment> assignments = course.getAssignments();
            for (int i = 0; i < assignments.size(); i++) {
                assignments.get(i).getScores().add(null);
            }
            return true;
        }
    }

    /**
     * Removes a course from a student course load and removes the student from that course
     * @param course the course
     * @return if the course was dropped
     */
    public boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            return false;
        } else {
            registeredCourses.remove(course);
            course.getRegisteredStudents().remove(this);
            return true;
        }
    }

    public String toSimplifiedString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", department=" + department +
                '}';
    }

    @Override
    public String toString() {
        String str = "";
        for (Course course : registeredCourses) {
            str += course.toSimplifiedString();
        }
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender=" + gender +
                ", address=" + address +
                ", department=" + department +
                ", registeredCourses=" + str +
                '}';
    }

    public enum Gender {
        MALE, FEMALE
    }
}
