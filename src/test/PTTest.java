package test;

import model.Card;
import org.junit.jupiter.api.Test;
import service.CLIUI;
import service.Leaderboard;
import service.PakTak;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PTTest {

    @Test
    void testStartGamePlayerWins() {
        List<String> playerNames = List.of("Player1", "Player2", "Player3");
        PakTak pakTak = new PakTak(playerNames);

        List<Card> cards = new ArrayList<>();
        cards.add(new Card("7S", "", null, "7", "Spades"));
        cards.add(new Card("AH", "", null, "Ace", "Hearts"));
        cards.add(new Card("KD", "", null, "King", "Diamonds"));

        CLIUI testCliui = new CLIUI();
        Leaderboard leaderboard = new Leaderboard();

        assertTrue(pakTak.startGame(cards, "Player1", cards.get(1), testCliui));
        assertEquals(1, leaderboard.getScores().get("Player1"));
    }

    @Test
    void testStartGameContinuePlaying() {
        List<String> playerNames = List.of("Player1", "Player2", "Player3");
        PakTak pakTak = new PakTak(playerNames);

        List<Card> cards = new ArrayList<>();
        cards.add(new Card("7S", "", null, "7", "Spades"));
        cards.add(new Card("AH", "", null, "Ace", "Hearts"));
        cards.add(new Card("KD", "", null, "King", "Diamonds"));

        CLIUI testCliui = new CLIUI();

        assertTrue(pakTak.startGame(cards, "Player1", new Card("2C", "", null, "2", "Clubs"), testCliui));
    }
}

