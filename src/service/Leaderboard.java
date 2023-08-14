package service;

import model.Player;

import java.util.HashMap;
import java.util.List;

public class Leaderboard {
    private final HashMap<String, Integer> scores;

    public Leaderboard() {
        this.scores = new HashMap<>();
    }

    public void updateScore(String playerName) {
        scores.put(playerName, scores.getOrDefault(playerName, 0) + 1);
    }

    public void displayLeaderboard() {
        System.out.println("-----Leaderboard-----");
        for (HashMap.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " wins");
        }
    }

    public HashMap<String, Integer> getScores() {
        return scores;
    }
}
