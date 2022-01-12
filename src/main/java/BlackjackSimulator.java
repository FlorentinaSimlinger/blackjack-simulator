import java.util.ArrayList;
import java.util.Collections;

public class BlackjackSimulator {

    private static ArrayList<Integer> deck;
    private static int numberOfPlayers;

    public static void main(String args) {
        System.out.println("Welcome to the Blackjack table! How many players are playing?");
        // TODO: add reading command line input and setting number of players
        deck = new ArrayList<Integer>(52);
        setUpDeck();
    }

    // generates a deck and randomizes it
    public static void setUpDeck() {
        // add number cards
        for (int i = 2; i <= 10; i++) {
            for (int j = 0; j <= 3; j++) {
                deck.add(i);
            }
        }

        // add value of four jacks, queens and kings each
        for (int k = 0; k <= 11; k++) {
            deck.add(10);
        }

        // add four aces
        for (int m = 0; m <= 3; m++) {
            deck.add(11);
        }

        // shuffle cards
        Collections.shuffle(deck);
        System.out.println("delete this for production");
        System.out.println(deck);
    }
}
