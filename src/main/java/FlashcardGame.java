import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlashcardGame {

  private SimpleQueue<Card> deckQueue = new Deck<>(10);
  private List<Card> cardList = new ArrayList<>();

  public SimpleQueue<Card> getDeck() {
    return deckQueue;
  }

  public List<Card> getCardList() {
    return cardList;
  }

  /** Add all cards to the deck */
  public void populateDeck(List<Card> cards) {
    for (Card c : cards) {
      deckQueue.offer(c);
    }
  }

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

  public void createNewDeck(int size, Scanner input) {
    deckQueue = new Deck<>(size);
    for (int i = 0; i < size; i++) {
      createNewCard(input);
    }
  }

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
