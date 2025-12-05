package org.alerick;

import java.util.List;

public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private List<Course> registeredCourse;
    private static int nextId;




    public enum Gender {
        MALE, FEMALE
    }
}
