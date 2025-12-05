package org.alerick;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private List<Course> registeredCourses;
    private static int nextId = 1;

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




    public enum Gender {
        MALE, FEMALE
    }
}
