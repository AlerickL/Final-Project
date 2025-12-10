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
     * Checks if the weights of all assignment of a course add to 100.
     * @return if the weights add to 100.
     */
    private boolean isAssignmentValid() {
        double sum = 0;
        for (Assignment assignment : assignments) {
            sum += assignment.getWeight();
        }
        return sum == 100;
    }
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

    /**
     * Calculates the student averages for a course
     * @return an array containing all the averages
     */
    public int[] calcStudentAvg() {
        int[] studentAvgs = new int[registeredStudents.size()];
        for (int i = 0; i < registeredStudents.size(); i++) {
            double avg = 0;
            for (Assignment assignment : assignments) {
                List<Integer> scores = assignment.getScores();
                avg += scores.get(i) * (1 / assignment.getWeight());
            }
            studentAvgs[i] = (int) avg;
        }
        return studentAvgs;
    }

    /**
     * Adds an assignment to the course
     * @param assignmentName the assignment's name
     * @param weight the assignment's weight
     * @return true
     */
    public boolean addAssignment(String assignmentName, double weight) {
        Assignment assignment = new Assignment(assignmentName, weight, registeredStudents.size());
        assignments.add(assignment);
        return true;
    }

    /**
     * Generates scores and final scores for each student
     */
    public void generateScores() {
        for (Assignment assignment : assignments) {
            assignment.generateRandomScores();
        }
        Assignment finalGrades = new Assignment("FinalGrade", 0, registeredStudents.size());
        for (Student student : registeredStudents) {
            int finalScore = 0;
            for (Assignment assignment : assignments) {
                for (int i = 0; i < assignments.size(); i++) {
                    finalScore += assignment.getScores().get(i);
                }
            }
            finalScore /= assignments.size();
            finalGrades.getScores().add(finalScore);
        }
    }

    public Course(String courseName, double credits, Department department) {
        this.courseId = String.format("C-%s-%02d", department.getDepartmentId(), nextId++);
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
    }

    public String toSimplifiedString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", department=" + department +
                '}';
    }

    @Override
    public String toString() {
        String str = "";
        for (Student student : registeredStudents) {
            str += student.toSimplifiedString();
        }
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", department=" + department +
                ", assignments=" + assignments +
                ", registeredStudents=" + str +
                '}';
    }
}
