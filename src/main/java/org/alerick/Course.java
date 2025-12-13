package org.alerick;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
public class Course {
    private final String courseId;
    @Setter private String courseName;
    @Setter private double credits;
    @Setter private Department department;
    @Setter private List<Assignment> assignments;
    @Setter private List<Student> registeredStudents;
    private static int nextId = 1;

    public Course(String courseName, double credits, Department department) {
        this.courseId = String.format("C-%s-%02d", department.getDepartmentId(), nextId++);
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
    }

    /**
     * Checks if the weights of all assignment of a course add to 100.
     * @return if the weights add to 100.
     */
    public boolean isAssignmentValid() {
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
     * Calculates the students' weighted averages for a course
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
     * @return if the assignment was added
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
        for (int i = 0; i < registeredStudents.size(); i++) {
            int finalScore = 0;
            double weights = 0;
            for (Assignment assignment : assignments) {
                finalScore += assignment.getScores().get(i) * assignment.getWeight();
                weights += assignment.getWeight();
            }
            finalScore /= weights;
            finalGrades.getScores().add(finalScore);
        }
        assignments.add(finalGrades);
    }

    /**
     * Displays the scores and final scores for each student and the average for each assignment
     */
    public void displayScores() {
        System.out.printf("Course: %s (%s)\n", courseName, courseId);
        System.out.printf("%-15s", "Assignment:");
        System.out.printf("%-15s\n", Assignment.formatNames(assignments));

        for (int i = 0; i < registeredStudents.size(); i++) {
            System.out.printf("%-15s", registeredStudents.get(i).getStudentName());
            for (int j = 0; j < assignments.size(); j++) {
                System.out.printf("%-15d", assignments.get(j).getScores().get(i));
            }
            System.out.print("\n");
        }
        System.out.printf("%-15s", "Avg");
        for (Assignment assignment : assignments) {
            System.out.printf("%-15.0f", assignment.calcAssignmentAvg());
        }
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
