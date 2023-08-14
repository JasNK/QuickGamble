package service;

import java.util.ArrayList;
import java.util.List;
import model.Card;
import model.Player;

public class PakTak {
    private List<Player> players;
    private Leaderboard leaderboard;
    private CLIUI cliui;

    public PakTak(List<String> playerNames) {
        this.players = new ArrayList<>();
        for (String name : playerNames) {
            players.add(new Player(name));
        }
        this.leaderboard = new Leaderboard();
        this.cliui = new CLIUI();
    }

    public static Card getCardByCode(List<Card> cards, String code) {
        for (Card card : cards) {
            if (card.getCode().equals(code)) {
                return card; // Found the card with the matching code
            }
        }
        return null; // Card with the given code not found
    }

    public void startGame(List<Card> cards, String pickerName, Card chosenCard) {
        boolean cardChosen = false;
        Player picker = null;
        for (Player player : players) {
//            if (player.getName().equals(pickerName)) {
//                picker = player;
//                break;
//            }
        }

        for (Card card : cards) {
            for (Player player : players) {
                player.setDealtCards(card);
//                if (picker == player) {
//                    continue;
//                }

                if (!cardChosen) {
                    if (chosenCard.getCode().equals(card.getCode())) {
                        System.out.println(player.getName() + " wins!");
                        leaderboard.updateScore(player.getName());
                        cardChosen = true; // Mark that the card has been chosen
                    }
                }
            }
        }
        printDealtCards();
        leaderboard.displayLeaderboard();
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

}
