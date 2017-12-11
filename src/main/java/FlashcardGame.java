import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlashcardGame {

  // Deck instance that will be played
  private static final SimpleQueue<Card> deckQueue = new Deck<>(10);
  private static List<Card> cardList = new ArrayList<>();

  public static void main(final String[] args) {
    final Scanner input = new Scanner(System.in);

    // Create new instance of flashcard game
    FlashcardGame newGame = new FlashcardGame();

    // Prepare a new deck of cards for the game
    newGame.populateDeck();

    // Create an empty scorecard map for this game
    Map<Card, Integer> theScoreCard = new HashMap<>();
    ScoreCard sc = new ScoreCard(theScoreCard);
    sc.createNewScoreCard(cardList.iterator());

    // Start Flashcard Game
    System.out.println(
        "Welcome to the flash card game. Let's practice your state and capitals. Type exit to leave the game early.\n");

    // Continue asking questions until all cards are answered correctly
    while (!deckQueue.isEmpty()) {
      Card currCard = newGame.playCard();

      System.out.println("What is the capital of " + currCard.getQuestion() + "?");

      // Retrieve and check answer
      String response = input.nextLine().toLowerCase();
      if (currCard.checkAnswer(response)) {
        // Add attempt in scorecard
        sc.addAttempt(currCard);
        System.out.println("Nice Job! You got that right.\n");
      } else if (response.equals("exit")) {
        System.out.println("Exiting Game...");
        System.exit(0);
      } else {
        // Add attempt in scorecard
        sc.addAttempt(currCard);
        System.out.println(
            "Sorry that was incorrect. This card has been added back to the deck.\n");
        newGame.replayCard(currCard);
      }
    }
    System.out.println("\nCongrats! You've finished answering all the questions correctly!");

    // Print score card
    sc.printScoreCard();
  }

  /** Add all cards to the deck */
  public void populateDeck() {
    List<Card> cards = createFakeCardData();
    for (Card c : cards) {
      deckQueue.offer(c);
    }
  }

  /** Create an empty scorecard */
  public void createScoreCard(SimpleQueue<Card> currDeck) {}

  /** Retrieve a card from the deck */
  public Card playCard() {
    return deckQueue.poll();
  }

  /** Add card back to the deck if the user answers wrong */
  public void replayCard(Card obj) {
    deckQueue.offer(obj);
  }

  /** Generate Fake Flashcard Data */
  public List<Card> createFakeCardData() {
    Card a = new Card("California", "Sacramento");
    Card b = new Card("Hawaii", "Honolulu");
    Card c = new Card("Wisconsin", "Madison");
    Card d = new Card("Illinois", "Springfield");
    Card e = new Card("Ohio", "Columbus");
    Card f = new Card("Arizona", "Phoenix");
    Card g = new Card("Alabama", "Montgomery");
    Card h = new Card("Florida", "Tallahassee");
    Card i = new Card("Georgia", "Atlanta");
    Card j = new Card("Tennessee", "Nashville");

    cardList.add(a);
    cardList.add(b);
    cardList.add(c);
    cardList.add(d);
    cardList.add(e);
    cardList.add(f);
    cardList.add(g);
    cardList.add(h);
    cardList.add(i);
    cardList.add(j);

    return cardList;
  }
}
