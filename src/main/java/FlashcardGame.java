import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlashcardGame {

  private SimpleQueue<Card> deckQueue = new Deck<>(10);
  private List<Card> cardList = new ArrayList<>();

  /**
   * Get the deck queue which contains Cards. The cards in the deck will be played first in - first
   * out until all the cards are answered correctly.
   *
   * @return The deck queue
   */
  public SimpleQueue<Card> getDeck() {
    return deckQueue;
  }

  /**
   * Get the card list. Each card in a flashcard group is added this list before they are added to
   * the deck queue for playing.
   *
   * @return The card arraylist
   */
  public List<Card> getCardList() {
    return cardList;
  }

  /**
   * Add each card to be plated to the deck queue
   *
   * @param cards a Card array list
   */
  public void populateDeck(List<Card> cards) {
    for (Card c : cards) {
      deckQueue.offer(c);
    }
  }

  /**
   * Retrieve and remove a card from the deck. This card question will be displayed to the user. The
   * user's response will be checked with the card's answer.
   */
  public Card playCard() {
    return deckQueue.poll();
  }

  /**
   * Add card to the back for the deck if the user answers wrong
   *
   * @param obj the Card that was answered wrong
   */
  public void replayCard(Card obj) {
    deckQueue.offer(obj);
  }

  /**
   * Generate Fake Flashcard Data. This default data set creates a set of 10 flashcards to test the
   * functionality of the program. Each new card is added to the cardList array which is used to
   * populate the deck.
   */
  public List<Card> createFakeCardData() {
    Card a = new Card("What is the capital of California?", "Sacramento");
    Card b = new Card("What is the capital of Hawaii?", "Honolulu");
    Card c = new Card("What is the capital of Wisconsin?", "Madison");
    Card d = new Card("What is the capital of Illinois?", "Springfield");
    Card e = new Card("What is the capital of Ohio?", "Columbus");
    Card f = new Card("What is the capital of Arizona?", "Phoenix");
    Card g = new Card("What is the capital of Alabama?", "Montgomery");
    Card h = new Card("What is the capital of Florida?", "Tallahassee");
    Card i = new Card("What is the capital of Georgia?", "Atlanta");
    Card j = new Card("What is the capital of Tennessee?", "Nashville");

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

  /**
   * Create a new deck of a fixed capacity and create new flashcards to populate the deck
   *
   * @param size the size of the new deck
   * @param input user keyboard input to create new cards
   */
  public void createNewDeck(int size, Scanner input) {
    deckQueue = new Deck<>(size);
    for (int i = 0; i < size; i++) {
      createNewCard(input);
    }
  }

  /**
   * Get user input to set a new question and answer for each card
   *
   * @param input user keyboard input
   */
  public void createNewCard(Scanner input) {
    System.out.println("Enter a question");
    String question = input.nextLine();
    System.out.println("Enter the answer");
    String answer = input.nextLine();
    Card c = new Card(question, answer);
    cardList.add(c);
    System.out.println(" ");
  }
}
