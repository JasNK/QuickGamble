import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import api.DeckOfCardsApiClient;
import com.google.gson.Gson;
import model.Card;
import model.ShuffledDeck;
import service.CLIUI;
import service.PakTak;

import static service.PakTak.getCardByCode;

public class Main {
    public static void main(String[] args) {
        DeckOfCardsApiClient apiClient = DeckOfCardsApiClient.getInstance();

        try {
            Gson gson = new Gson();
            String drawResponseJson = apiClient.drawCards("new", 52);
            ShuffledDeck shuffledDeck = gson.fromJson(drawResponseJson, ShuffledDeck.class);

            List<Card> cardss = shuffledDeck.getCards();

            CLIUI cliui = new CLIUI();
            int numberOfPlayers = cliui.getNumberOfPlayers();
            List<String> playerNames = cliui.getPlayerNames(numberOfPlayers);
            String pickerName = cliui.choosePlayerToPickCard(playerNames);
            String chosenCardCode = cliui.chooseCardCode();

            Card chosenCard = getCardByCode(cardss, chosenCardCode);
            if (chosenCard != null) {
                PakTak pakTak = new PakTak(playerNames);
                pakTak.startGame(cardss, pickerName, chosenCard);
            } else {
                System.out.println("Card with code " + chosenCardCode + " not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private static Card getCardByCode(ArrayList<Card> cards, String code) {
//        for (Card card : cards) {
//            if (card.getCode().equals(code)) {
//                return card; // Found the card with the matching code
//            }
//        }
//        return null; // Card with the given code not found
//    }

}