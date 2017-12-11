import java.util.*;
import java.util.Scanner;

public class Main {
  public static void main(final String[] args) {
    Scanner input = new Scanner(System.in);
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
        System.out.println("\nHow many cards would you like to add to your custom deck?");
        String newDeckSize = input.nextLine();
        System.out.println("Ok. Let's create " + newDeckSize + " new cards.\n");
        newGame.createNewDeck(Integer.parseInt(newDeckSize), input);
        System.out.println(
            "Let's practice your custom flashcards! Type 'exit' at any time to leave the game early.\n");
        break;
      default:
        System.out.println("That is not an option. Exiting Game...");
        System.exit(0);
        break;
    }

    List<Card> cardList = newGame.getCardList();
    // Populate deck queue with the card list
    newGame.populateDeck(cardList);
    sc.createNewScoreCard(cardList.iterator());

    // Continue asking questions until all cards are answered correctly
    while (!newGame.getDeck().isEmpty()) {
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
}
