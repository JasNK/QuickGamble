import java.io.IOException;
import java.util.List;
import api.DeckOfCards;
import com.google.gson.Gson;
import model.Card;
import model.ShuffledDeck;
import service.CLIUI;
import service.PakTak;
import static service.PakTak.getCardByCode;

public class Main {
    public static void main(String[] args) {
        DeckOfCards apiClient = DeckOfCards.getInstance();
        CLIUI cliui = new CLIUI();

        int numberOfPlayers = cliui.getNumberOfPlayers();
        List<String> playerNames = cliui.getPlayerNames(numberOfPlayers);
        PakTak pakTak = new PakTak(playerNames);
        boolean continuePlaying = true;

        while (continuePlaying) {
            try {
                Gson gson = new Gson();
                String drawResponseJson = apiClient.drawCards("new", 52);
                ShuffledDeck shuffledDeck = gson.fromJson(drawResponseJson, ShuffledDeck.class);
                List<Card> totalCards = shuffledDeck.getCards();

                String pickerName = cliui.choosePlayerToPickCard(playerNames);
                String chosenCardCode = cliui.chooseCardCode();
                Card chosenCard = getCardByCode(totalCards, chosenCardCode);
                continuePlaying = pakTak.startGame(totalCards, pickerName, chosenCard, cliui);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
