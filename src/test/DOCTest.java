package test;

import api.DeckOfCards;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class DOCTest {
    @Test
    void testDrawCards() throws IOException {
        DeckOfCards apiClient = DeckOfCards.getInstance();
        String response = apiClient.drawCards("some_deck_id", 5);
        assertNotNull(response);
    }

    //enige input is new OF een existing card deck id(wat wij nooit hebben)
}