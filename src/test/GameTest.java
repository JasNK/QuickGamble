package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import service.CLIUI;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public class GameTest {

    @Test
    public void testValidInput() {
        String input = "4\n"; // Simulate user input of 4
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        CLIUI game = new CLIUI();
        int result = game.getNumberOfPlayers();

        assertEquals(4, result);
    }

    @Test
    public void testInvalidInputThenValidInput() {
        String input = "10\n3\n"; // Simulating user input of 10 characters (invalid), then 3 (valid)
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        CLIUI game = new CLIUI();
        int result = game.getNumberOfPlayers();

        assertEquals(3, result);
    }


    @Test
    public void testGetPlayerNames() {
        String input = "User1\nUser2\nUser3\n"; // Test user input for player names
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        CLIUI game = new CLIUI();
        List<String> playerNames = game.getPlayerNames(3);

        assertEquals(3, playerNames.size());
        assertEquals("User1", playerNames.get(0));
        assertEquals("User2", playerNames.get(1));
        assertEquals("User3", playerNames.get(2));
    }


    @Test
    void testChooseCardCode() {
        // Test input
        String input = "7S\n"; // Choose 7 of Spades
        InputStream testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);

        CLIUI game = new CLIUI();

        String chosenCardCode = game.chooseCardCode();

        assertEquals("7S", chosenCardCode);
    }

    @Test
    void testInvalidInput() {
        // Test input with an invalid card code
        String input = "ABC\n0C\n"; // Invalid input
        InputStream testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);

        CLIUI game = new CLIUI();

        String chosenCardCode = game.chooseCardCode();

        assertEquals("0C", chosenCardCode);
    }

}




