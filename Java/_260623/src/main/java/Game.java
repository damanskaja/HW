import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

class Game {
    private final int cardsForPlayer = 5;
    private int players;

    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("Enter the number of players: ");

            if (scanner.hasNextInt()) {
                players = scanner.nextInt();
                if (isValidNumberOfPlayers()) {
                    break;
                }
            } else {
                System.out.println("You have not entered a number, or your number is too large!");
            }
        }

        Deck deck = new Deck();
        deck.shuffle();
        deck.display(players, cardsForPlayer);
    }

    private boolean isValidNumberOfPlayers() {
        final int numberOfCards = Suit.values().length * Rank.values().length;
        if (cardsForPlayer * players <= numberOfCards) {
            return true;
        } else {
            if (players == 0) {
                System.out.println("The game has been terminated.");
                return true;
            } else if (players < 0) {
                System.out.println("The number of players cannot be less than 0");
            } else {
                System.out.println("Too many players!");
            }
        }
        return false;
    }
}

enum Suit {
    CLUBS, DIAMONDS, HEARTS, SPADES
}

enum Rank {
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
}

class Deck {
    private final List<String> cards = new ArrayList<>();

    public Deck() {
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                cards.add(rank + " " + suit);
            }
        }
    }

    public void shuffle() {
        Random random = new Random();
        int numberOfCards = cards.size();
        for (int i = 0; i < numberOfCards; i++) {
            int card = i + (random.nextInt(numberOfCards - i)); // random card in the deck
            String temp = cards.get(card);
            cards.set(card, cards.get(i));
            cards.set(i, temp);
        }
    }

    public void display(int players, int cardsForPlayer) {
        for (int i = 0; i < players * cardsForPlayer; i++) {
            System.out.println(cards.get(i));

            if (i % cardsForPlayer == cardsForPlayer - 1)
                System.out.println();
        }
    }
}
