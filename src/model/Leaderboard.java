package model;

import java.util.HashMap;

public class Leaderboard {
    private HashMap<String, Integer> scores = new HashMap<>();

    public void updateScore(String playerName) {
        scores.put(playerName, scores.getOrDefault(playerName, 0) + 1);
    }

    public void displayLeaderboard() {
        System.out.println("Leaderboard:");
        for (String playerName : scores.keySet()) {
            int score = scores.get(playerName);
            System.out.println(playerName + ": " + score + " wins");
        }
    }
}
