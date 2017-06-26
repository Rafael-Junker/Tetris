package de.Junker.Tetris;

import java.io.FileNotFoundException;
import java.util.Arrays;


public class Scores {

    static int[] scores = new int[25];

    public static void sortScores() {
        Arrays.sort(scores);
    }

    public static void addScore(int score) {
        if (scores[24] < score) {
            scores[24] = score;
            sortScores();
        }
    }

    public static void saveToFile() {

    }

    public static void loadFromFile() {
        try {

        } catch (FileNotFoundException e) {
            //GenerateDefaults
        }
    }
}
