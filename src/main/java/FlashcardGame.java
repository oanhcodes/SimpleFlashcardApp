import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlashcardGame {

  private static SimpleQueue<Card> deckQueue = new Deck<>(10);
  private static List<Card> cardList = new ArrayList<>();
  private static Scanner input = new Scanner(System.in);

  public static void main(final String[] args) {
    // Create a new flashcard game
    FlashcardGame newGame = new FlashcardGame();

    // Create a new scorecard
    Map<Card, Integer> theScoreCard = new HashMap<>();
    ScoreCard sc = new ScoreCard(theScoreCard);

    // Start Flashcard Game
    System.out.println(
        "Welcome to the flash card game. Do you want to practice state capitals or create your own deck?");
    System.out.println("1. State Capitals");
    System.out.println("2. Create New Deck");

    String selection = input.nextLine();

    // Generate cards with fake data or user input
    switch (selection) {
      case "1":
        newGame.createFakeCardData();
        System.out.println(
            "Let's practice your state capitals! Type 'exit' at any time to leave the game early.\n");
        break;
      case "2":
        System.out.println("How many cards would you like to add to your custom deck?");
        String newDeckSize = input.nextLine();
        System.out.println("Ok. Let's create " + newDeckSize + " new cards.");
        newGame.createNewDeck(Integer.parseInt(newDeckSize));
        System.out.println(
            "Let's practice your custom flashcards! Type 'exit' at any time to leave the game early.\n");
        break;
      default:
        System.out.println("That is not an option. Exiting Game...");
        System.exit(0);
        break;
    }

    // Populate deck queue with the card list
    newGame.populateDeck(cardList);
    sc.createNewScoreCard(cardList.iterator());

    // Continue asking questions until all cards are answered correctly
    while (!deckQueue.isEmpty()) {
      Card currCard = newGame.playCard();

      System.out.println(currCard.getQuestion());

      // Retrieve and check answer
      String response = input.nextLine().toLowerCase();

      if (response.equals("exit")) {
        System.out.println("Exiting Game...");
        System.exit(0);
      } else if (currCard.checkAnswer(response)) {
        sc.addAttempt(currCard);
        System.out.println("Nice Job! You got that right.\n");
      } else {
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

  public void createNewDeck(int size) {
    deckQueue = new Deck<>(size);
    for (int i = 0; i < size; i++) {
      createNewCard();
    }
  }

  public void createNewCard() {
    System.out.println("Enter a question");
    String question = input.nextLine();
    System.out.println("Enter the answer");
    String answer = input.nextLine();
    Card c = new Card(question, answer);
    cardList.add(c);
  }
}
