package model;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> dealtCards = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public ArrayList<Card> getCardArray() {
        return dealtCards;
    }

    public void chosenCard(Card card) {
        dealtCards.add(card);
    }
}
