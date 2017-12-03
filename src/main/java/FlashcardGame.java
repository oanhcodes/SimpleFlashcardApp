import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlashcardGame {

    //Create new Deck that will be played
    final private static SimpleQueue<Card> deckQueue = new Deck<>(10);


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

        //Create new instance of flashcard game
        FlashcardGame newGame = new FlashcardGame();
        newGame.populateDeck(cardSet);

        //Test question retrieval
        while (!deckQueue.isEmpty()){
            Card currCard = newGame.playCard();
            System.out.println("What is the capital of " + currCard.getQuestion() + "?");
            //Add logic to retrieve and check answers
            String response = input.next();
            if(currCard.checkAnswer(response)){
                System.out.println("Nice Job");
            }
            else{
                System.out.println("Sorry that was incorrect");
                newGame.replayCard(currCard);
            }
        }
    }

    /**
     * Add all cards to the deck
     */
    public void populateDeck(List<Card> cards) {

        for (Card c : cards) {
            deckQueue.offer(c);
        }

    }

    /**
     * Retrieve a card from the deck
     */
    public Card playCard() {
        return deckQueue.poll();
    }

    public void replayCard(Card obj){
        deckQueue.offer(obj);
    }

}
