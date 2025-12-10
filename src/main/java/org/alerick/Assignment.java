package org.alerick;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private List<Integer> scores;
    private static int nextId = 1;

    /**
     * generates a random score for each student in the assignment
     */
    public void generateRandomScores() {
        if (scores == null) {
            return;
        }

        Random random = new Random();
        int idx = random.nextInt(0, 11);
        for (Integer integer : scores) {
            integer = switch (idx) {
                case 1, 2 -> random.nextInt(60, 70);
                case 3, 4 -> random.nextInt(70, 80);
                case 5, 6, 7, 8 -> random.nextInt(80, 90);
                case 9, 10 -> random.nextInt(90, 101);
                default -> random.nextInt(0, 60);
            };
        }
    }

    public Assignment(String assignmentName, double weight, int existingStudents) {
        this.assignmentId = String.format("%02d", nextId++);
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.scores = new ArrayList<>(existingStudents);
    }
}
