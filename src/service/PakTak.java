package service;

import java.util.ArrayList;
import java.util.List;
import model.Card;
import model.Player;

public class PakTak {
    private final List<Player> players;
    private final Leaderboard leaderboard;

    public PakTak(List<String> playerNames, Leaderboard leaderboard) {
        this.players = new ArrayList<>();
        for (String name : playerNames) {
            players.add(new Player(name));
        }
        this.leaderboard = leaderboard;
    }

    public static Card getCardByCode(List<Card> cards, String code) {
        for (Card card : cards) {
            if (card.getCode().equals(code)) {
                return card;
            }
        }
        return null;
    }

    public void printDealtCards() {
        for (Player player : players) {
            System.out.println(player.getName() + "'s dealt cards:");
            for (Card card : player.getDealtCards()) {
                System.out.println(card.getCode() + " (" + card.getValue() + " of " + card.getSuit() + ")");
            }
            System.out.println();
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public boolean startGame(List<Card> cards, String pickerName, Card chosenCard, ClUi cliui) {
        int currentPlayerIndex = players.indexOf(players.stream().filter(player -> player.getName().equals(pickerName)).findFirst().orElse(null));
        boolean continuePlaying = true;
        for (Card card : cards) {
            Player currentPlayer = players.get(currentPlayerIndex);
            currentPlayer.setDealtCards(card);
            if (chosenCard.getCode().equals(card.getCode())) {
                System.out.println("\n--------------------------\n" + currentPlayer.getName() + " wins!" + "\n--------------------------\n");
                leaderboard.updateScore(currentPlayer.getName());
                break;
            }
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
        printDealtCards();
        leaderboard.displayLeaderboard();
        System.out.println("---------------------\n");
        int choice = cliui.displayOptions();
        switch (choice) {
            case 1 -> {
                for (Player player : players) {
                    player.clearDealtCards();
                }
            }
            case 2 -> {
                System.out.println("Thank you for playing!");
                continuePlaying = false;
            }
            default -> System.out.println("Invalid choice. Please enter a valid option.");
        }
        return continuePlaying;
    }
}
