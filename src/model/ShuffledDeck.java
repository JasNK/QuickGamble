package model;

import java.util.List;

public class ShuffledDeck {
    private boolean success;
    private String deck_id;
    private List<Card> cards;
    private int remaining;

    public ShuffledDeck(boolean success, String deck_id, List<Card> cards, int remaining) {
        this.success = success;
        this.deck_id = deck_id;
        this.cards = cards;
        this.remaining = remaining;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getDeck_id() {
        return deck_id;
    }

    public void setDeck_id(String deck_id) {
        this.deck_id = deck_id;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }
}
