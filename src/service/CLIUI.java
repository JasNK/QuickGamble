package service;

import model.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CLIUI {
    private Scanner scanner;

    public CLIUI() {
        this.scanner = new Scanner(System.in);
    }

    public int getNumberOfPlayers() {
        System.out.print("Enter number of players (up to 6): ");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<String> getPlayerNames(int numberOfPlayers) {
        List<String> playerNames = new ArrayList<>();
        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.print("Enter name for Player " + i + ": ");
            playerNames.add(scanner.nextLine());
        }
        return playerNames;
    }

    public String choosePlayerToPickCard(List<String> playerNames) {
        System.out.println("Choose a player to pick the card:");
        for (int i = 0; i < playerNames.size(); i++) {
            System.out.println((i + 1) + ". " + playerNames.get(i));
        }
        int choice = Integer.parseInt(scanner.nextLine());
        return playerNames.get(choice - 1);
    }

    public String chooseCardCode() {
        System.out.print("Enter the card code (e.g., 3H for 3 of Hearts): ");
        return scanner.nextLine();
    }

    // Other input methods can be added here
}
