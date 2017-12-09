import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlashcardGame {

  // Create new Deck that will be played
  private static final SimpleQueue<Card> deckQueue = new Deck<>(10);

  public static void main(final String[] args) {
    final Scanner input = new Scanner(System.in);

    // Create test objects to test Deck queue implementation
    Card a = new Card("California", "Sacramento");
    Card b = new Card("Hawaii", "Honolulu");
    Card c = new Card("Wisconsin", "Madison");
    Card d = new Card("Illinois", "Springfield");
    Card e = new Card("Ohio", "Columbus");
    Card f = new Card("Illinois", "Springfield");
    Card g = new Card("Alabama", "Montgomery");
    Card h = new Card("Florida", "Tallahassee");
    Card i = new Card("Georgia", "Atlanta");
    Card j = new Card("Tennesse", "Nashville");

    // Add cards to an array list
    List<Card> cardSet = new ArrayList<Card>();
    cardSet.add(a);
    cardSet.add(b);
    cardSet.add(c);
    cardSet.add(d);
    cardSet.add(e);
    cardSet.add(f);
    cardSet.add(g);
    cardSet.add(h);
    cardSet.add(i);
    cardSet.add(j);

    // Create new instance of flashcard game
    FlashcardGame newGame = new FlashcardGame();

    // Prepare a new deck of cards for the game
    newGame.populateDeck(cardSet);

    // Create an empty scorecard for this game

    Map<Card, Integer> theScoreCard = new HashMap<>();
    ScoreCard sc = new ScoreCard(theScoreCard);
    sc.createNewScoreCard(cardSet.iterator());

    Map<Card, Integer> currScoreCard = sc.getNumOfAttempts();

    List<Map.Entry<Card, Integer>> scoreList = new ArrayList<>(deckQueue.size());

    for (Map.Entry<Card, Integer> pair : currScoreCard.entrySet()) {
      scoreList.add(pair);
    }

    System.out.println(
        "Welcome to the flash card game. Today you will practice your state and capitals. "
            + "Type exit to leave the game early");

    // Test question retrieval
    while (!deckQueue.isEmpty()) {
      Card currCard = newGame.playCard();
      System.out.println("What is the capital of " + currCard.getQuestion() + "?");

      // Add logic to retrieve and check answers
      String response = input.next().toLowerCase();
      if (currCard.checkAnswer(response)) {
        System.out.println("Nice Job");
      } else if (response.equals("exit")) {
        System.out.println("Exiting Game");
        System.exit(0);
      } else {
        System.out.println("Sorry that was incorrect");
        newGame.replayCard(currCard);
      }
    }
    System.out.println("Congrats you have answered all the questions");
  }

  /** Add all cards to the deck */
  public void populateDeck(List<Card> cards) {
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
}
