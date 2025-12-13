package org.alerick;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Assignment {
    private final String assignmentId;
    private String assignmentName;
    private double weight;
    private List<Integer> scores;
    private static int nextId = 1;

    public Assignment(String assignmentName, double weight, int existingStudents) {
        this.assignmentId = String.format("%02d", nextId++);
        this.assignmentName = Util.toTitleCase(assignmentName);
        this.weight = weight;
        this.scores = new ArrayList<>(existingStudents);
    }

    /**
     * Calculates the average of an assignment
     * @return the average of an assignment
     */
    public double calcAssignmentAvg() {
        double sum = 0;
        for (Integer integer : scores) {
            sum += integer;
        }
        return sum / scores.size();
    }

    /**
     * generates a random score for each student in the assignment
     */
    public void generateRandomScores() {
        if (scores == null) {
            return;
        }
        Random random = new Random();
        int idx = random.nextInt(0, 11);
        for (int i = 0; i < scores.size(); i++) {
            int score = 0;
            score = switch (idx) {
                case 1, 2 -> random.nextInt(60, 70);
                case 3, 4 -> random.nextInt(70, 80);
                case 5, 6, 7, 8 -> random.nextInt(80, 90);
                case 9, 10 -> random.nextInt(90, 101);
                default -> random.nextInt(0, 60);
            };
            scores.set(i, score);
        }
    }

    /**
     * Formats a list of assignments to a single string containing only the names.
     * Each element of the initial list has 15 spaces, and is right padded.
     * @param list the list of assignments
     * @return the formatted string
     */
    public static String formatNames(List<Assignment> list) {
        List<String> strList = new ArrayList<>();
        for (Assignment assignment : list) {
            strList.add(assignment.getAssignmentName());
        }
        String str = "";
        for (int i = 0; i < strList.size(); i++) {
            int idx = 15;
            idx -= strList.get(i).length();
            String pad = "";
            for (int j = 0; j < idx; j++) {
                pad += " ";
            }
            str += String.format("%s%s", strList.get(i), pad);
        }
        return str;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                '}';
    }
}
