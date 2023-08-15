package test;

import api.DeckOfCards;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class APITest {
    @Test
    void testDrawCards() throws IOException {
        DeckOfCards apiClient = DeckOfCards.getInstance();
        String response = apiClient.drawCards("new", 5);
        assertNotNull(response);
    }

    @Test
    void testInvalidDrawCards() {
        DeckOfCards apiClient = DeckOfCards.getInstance();
        IOException exception = assertThrows(IOException.class, () -> {
            apiClient.drawCards("invalid", 5);
        });
        String expectedErrorMessage = "API request failed with response code: 404";
        assertEquals(expectedErrorMessage, exception.getMessage());
    }
}