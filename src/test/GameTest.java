package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import service.CLIUI;
import service.PakTak;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
//import src/Main;

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
        String input = "r\n10\n"; // Simulating user input of 10 characters (invalid), then 3 (valid)
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        CLIUI game = new CLIUI();
        int result = game.getNumberOfPlayers();

        assertEquals(10, result);
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

//    Test invalid usernames. 4 characters incluiding special characters worden geaccepteerd. Niet meer dan 20

    @Test
    void testChooseCardCode() {
        // Test input
        String input = "ABC\n1C\n"; // Choose 7 of Spades
        InputStream testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);

        CLIUI game = new CLIUI();

        String chosenCardCode = game.chooseCardCode();

        assertEquals("1C", chosenCardCode);
    }
//testChooseCardCode, testInvalidInputCardCode is hetzelfde, er moet 1 direct succees zijn en eentje waar de inputs worden getest, en eindigt met een succes
    @Test
    void testInvalidInputCardCode() {
        // Test input with an invalid card code
        String input = "ABC\n2z\n"; // Invalid input
        InputStream testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);

        CLIUI game = new CLIUI();

        String chosenCardCode = game.chooseCardCode();

        assertEquals("2Z", chosenCardCode);
    }

    @Test
//    void testInvalidInputCardCodes() {
//        // Test input with an invalid card code
//        String input = "ABC\n2c\n"; // Invalid input
//        InputStream testInput = new ByteArrayInputStream(input.getBytes());
//        System.setIn(testInput);
//
//        List<String> testPlayers= new ArrayList<>();
//        testPlayers.add("test1");
//        testPlayers.add("test2");
//
//        PakTak game = new PakTak(testPlayers);
//
//        String chosenCardCode = game.getCardByCode();
//
//        assertEquals("2Z3", chosenCardCode);
//    }

}




