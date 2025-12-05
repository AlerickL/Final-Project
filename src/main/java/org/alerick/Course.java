package org.alerick;

import lombok.Getter;

import java.util.List;

@Getter
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private List<Assignment> assignments;
    private List<Student> registeredStudents;
    private static int nextId;

    public boolean registerStudent(Student student) {

    }
}
