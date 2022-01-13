import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BlackjackSimulator {

    private static ArrayList<Integer> deck;
    private static ArrayList<Player> players;
    private static Scanner in;

    public static void main(String[] args) {
        players = new ArrayList<Player>();
        System.out.println("Welcome to the Blackjack table! Please enter the number of players playing.");
        in = new Scanner(System.in);

        int numberOfPlayersPlaying = in.nextInt();
        // '\n' is not consumed by nextInt() therefore we need to consume it
        String throwaway = in.nextLine();
        System.out.println(throwaway);

        setUpPlayers(numberOfPlayersPlaying);
        System.out.println("Thank you, " + numberOfPlayersPlaying + " players are now playing.");

        System.out.println("We're mixing a new deck of cards.");
        deck = new ArrayList<Integer>(52);
        setUpDeck();

        System.out.println("Every player will now receive two initial cards.");
        for (Player p : players) {
            System.out.println(p.getName() + ", your turn.");
            addCardToPlayersHand(p);
            addCardToPlayersHand(p);
        }

        System.out.println("Now that everyone has two cards, we can start playing. Remember that you " +
                "want to be as close to 21 as possible!");

        while(numberOfPlayersPlaying > 0) {
            for (Player p : players) {
                // skip player if they are not playing anymore
                if (!p.getIsPlaying()) {
                    continue;
                }

                System.out.println(p.getName() + ", it is your turn.");
                System.out.println("Your current score is " + p.getScore() + ".");
                System.out.println("Would you like to draw another card? Please enter Y if you would like " +
                        "to draw another card.");
                String s = in.nextLine();
                if (s.equals("Y")) {
                    addCardToPlayersHand(p);
                } else {
                    System.out.println("You decided to not draw a card. Your score is now frozen at " + p.getScore()
                    + ".");
                    p.setIsPlaying(false);
                }
                System.out.println(" ");

                // update number of players playing
                if (!p.getIsPlaying()) {
                    numberOfPlayersPlaying--;
                }
            }
        }

        in.close();

        System.out.println("All players have either stopped drawing cards now or have lost!");
        System.out.println("The score of each player is: ");
        int minDiffSoFar = Integer.MAX_VALUE;
        Player winner = null;
        for (Player p : players) {
            System.out.println(p.getName() + ": " + p.getScore());
            // update winner
            if (21 - p.getScore() >= 0 && 21 - p.getScore() < minDiffSoFar) {
                winner = p;
                minDiffSoFar = 21 - p.getScore();
            }
        }

        if (winner == null) {
            System.out.println("Oh no! All players' scores are above 21. There is no winner this round!");
        } else {
            System.out.println("The winner is " + winner.getName() + " with a score of " + winner.getScore() + "!");
            System.out.println("Congratulations!");
        }

    }

    // adds a card to a players hand, handles logic of aces, and going above limit
    public static void addCardToPlayersHand(Player p) {
        int card = getAndRemoveNextCard();

        if (card == 11) {
            System.out.println("You drew an ace! You get to choose whether it has the value of 1 or 11. " +
                    "Please enter Y if you would like it to have the value 11.");
            String s = in.nextLine();
            if (s.equals("Y")) {
                p.updateScore(11);
            } else {
                p.updateScore(1);
            }
        } else {
            System.out.println("The value of the card you drew is " + card + ".");
            p.updateScore(card);
        }

        System.out.println("Your score is now " + p.getScore() + ".");
        if (p.isAboveLimit()) {
            System.out.println("Unfortunately, your score is above 21. You're out.");
            p.setIsPlaying(false);
        }
        System.out.println(" ");
    }

    // returns next card in deck and removes it from the deck
    private static int getAndRemoveNextCard() {
        int index = deck.size() - 1;
        int card = deck.get(index);
        deck.remove(index);
        return card;
    }

    // generates Player instances and adds them to the array
    public static void setUpPlayers(int numberOfPlayers) {
        for (int i = 1; i <= numberOfPlayers; i++) {
            players.add(new Player("player " + i));
        }
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
    }
}
