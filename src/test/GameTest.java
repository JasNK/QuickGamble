package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import service.ClUi;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public class GameTest {
    @Test
    public void testValidPlayerNumbers() {
        String input = "4\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ClUi game = new ClUi();
        int result = game.getNumberOfPlayers();
        assertEquals(4, result);
    }

    @Test
    public void testInvalidThenValidPlayerNumbers() {
        String input = "\n \nSD_\nr\n10\n1\n0\n4\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ClUi game = new ClUi();
        int result = game.getNumberOfPlayers();
        assertEquals(4, result);
    }

    @Test
    public void testValidPlayerNames() {
        String input = "User1\nUser2\nUser3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ClUi game = new ClUi();
        List<String> playerNames = game.getPlayerNames(3);
        assertEquals(3, playerNames.size());
        assertEquals("User1", playerNames.get(0));
        assertEquals("User2", playerNames.get(1));
        assertEquals("User3", playerNames.get(2));
    }

    @Test
    public void testInvalidPlayerNames() {
        String input = "\nMe\nMe12\n                                             \nUser123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ClUi game = new ClUi();
        List<String> playerNames = game.getPlayerNames(2);
        assertEquals(2, playerNames.size());
        assertEquals("Me12", playerNames.get(0));
        assertEquals("User123", playerNames.get(1));
    }

    @Test
    void testValidCardCode() {
        String input = "2s\n";
        InputStream testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);
        ClUi game = new ClUi();
        String chosenCardCode = game.chooseCardCode();
        assertEquals("2S", chosenCardCode);
    }

    @Test
    void testInvalidCardCode() {
        String input = "\nABC\n1C\n             \n24\nnn\n7S\n";
        InputStream testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);
        ClUi game = new ClUi();
        String chosenCardCode = game.chooseCardCode();
        assertEquals("7S", chosenCardCode);
    }

//    @Test
//    void testStartGameFlow() {
//        List<String> playerNames = List.of("Player1", "Player2", "Player3");
//        List<Card> cards = new ArrayList<>();
//        cards.add(new Card("7S", "", null, "7", "Spades"));
//        cards.add(new Card("AH", "", null, "Ace", "Hearts"));
//        cards.add(new Card("KD", "", null, "King", "Diamonds"));
//        Leaderboard leaderboard = new Leaderboard();
//        PakTak pakTak = new PakTak(playerNames, leaderboard);
//        ClUi testCliUi = new ClUi();
//        assertTrue(pakTak.startGame(cards, "Player1", cards.get(2), testCliUi));
//        String input = "1";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//    }
}




