package org.alerick;

import java.util.List;
import java.util.Random;

public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private List<Integer> scores;
    private static int nextId = 1;

    private void generateRandomScores() {
        Random random = new Random();
        int idx = random.nextInt(0, 11);

        Integer score = 0;
        score = switch (idx) {
            case 1, 2 -> random.nextInt(60, 70);
            case 3, 4 -> random.nextInt(70, 80);
            case 5, 6, 7, 8 -> random.nextInt(80, 90);
            case 9, 10 -> random.nextInt(90, 101);
            default -> random.nextInt(0, 60);
        };

    }
}
