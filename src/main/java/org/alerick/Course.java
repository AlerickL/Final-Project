package org.alerick;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private List<Assignment> assignments;
    private List<Student> registeredStudents;
    private static int nextId = 1;

    /**
     * Registers a student to the course
     * @param student the student
     * @return if the student was registered.
     */
    public boolean registerStudent(Student student) {
        registeredStudents.add(student);
        for (int i = 0; i < assignments.size(); i++) {
            assignments.get(i).getScores().add(null);
        }
        return true;
    }

    public Course(String courseName, double credits, Department department) {
        this.courseId = String.format("C-%s-%02d", department.getDepartmentId(), nextId++);
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
    }
}
