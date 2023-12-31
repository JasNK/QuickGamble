package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClUi {
    private final Scanner scanner;

    public ClUi() {
        this.scanner = new Scanner(System.in);
    }

    public int getNumberOfPlayers() {
        System.out.println("-----Hello Welcome to Pak-Tak-----");
        int numberOfPlayers;
        while (true) {
            System.out.print("Enter number of players (2-6): ");
            String input = scanner.nextLine();
            try {
                numberOfPlayers = Integer.parseInt(input);
                if (numberOfPlayers >= 2 && numberOfPlayers <= 6) {
                    break;
                } else {
                    System.out.println(input + " is not a valid input. Please enter a number between 2 and 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println(input + " is not a valid input. Please enter a valid number.");
            }
        }
        return numberOfPlayers;
    }

    public List<String> getPlayerNames(int numberOfPlayers) {
        List<String> playerNames = new ArrayList<>();
        for (int i = 1; i <= numberOfPlayers; i++) {
            while (true) {
                System.out.print("Enter name for Player " + i + ": ");
                String playerName = scanner.nextLine().trim();
                if (playerName.length() >= 4 && playerName.length() <= 20) {
                    playerNames.add(playerName);
                    break;
                } else {
                    System.out.println(playerName + " is not a valid name. Please enter a non-empty name between 4 and 20 characters.");
                }
            }
        }
        return playerNames;
    }

    public String choosePlayerToPickCard(List<String> playerNames) {
        System.out.println("-----Choose a player to pick the card-----");
        for (int i = 0; i < playerNames.size(); i++) {
            System.out.println((i + 1) + ". " + playerNames.get(i));
        }
        int choice = Integer.parseInt(scanner.nextLine());
        return playerNames.get(choice - 1);
    }

    private boolean isValidCardCode(String input) {
        if (input.length() != 2) {
            return false;
        }
        char rank = input.charAt(0);
        char suit = input.charAt(1);
        boolean isValidRank = (rank >= '2' && rank <= '9') || rank == '0' || rank == 'J' || rank == 'Q' || rank == 'K' || rank == 'A';
        boolean isValidSuit = suit == 'S' || suit == 'H' || suit == 'C' || suit == 'D';
        return isValidRank && isValidSuit;
    }

    public String chooseCardCode() {
        System.out.println("-----Enter the card code-----");
        System.out.println("Examples:");
        System.out.println("7S for 7 of Spades");
        System.out.println("0C for 10 of Clubs");
        System.out.println("AD for Ace of Diamonds");
        System.out.println("JH for Jack of Hearts");
        System.out.println("QD for Queen of Diamonds");
        System.out.println("KS for King of Spades");
        System.out.print("Your choice: ");
        String input = scanner.nextLine().toUpperCase();
        while (!isValidCardCode(input)) {
            System.out.println(input + " is not a valid input. Please enter a valid card code");
            System.out.print("Your choice: ");
            input = scanner.nextLine().toUpperCase();
        }
        return input;
    }

    public int displayOptions() {
        System.out.println("Options:");
        System.out.println("1. Continue playing");
        System.out.println("2. End Game");
        System.out.print("Enter your choice: ");
        return Integer.parseInt(scanner.nextLine());
    }
}
