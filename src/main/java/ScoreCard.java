import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/** A map-based class for counting attempts to answer flashcard question */
public class ScoreCard {

  /** The map for storing the word counts. */
  private final Map<Card, Integer> theScoreCard;

  /** Creates a score card instance based on the given map. */
  public ScoreCard(final Map<Card, Integer> theScoreCard) {
    this.theScoreCard = theScoreCard;
  }

  /** Creates an empty score card */
  public void createNewScoreCard(final Iterator<Card> flashcards) {
    while (flashcards.hasNext()) {
      final Card card = flashcards.next();
      theScoreCard.put(card, 0);
    }
  }

  /** Counts the number of attempts the user makes to answer a flashcard question */
  public void countAttempts(final Iterator<Card> flashcards) {

    while (flashcards.hasNext()) {
      final Card card = flashcards.next();
      Integer count = theScoreCard.get(card);
      if (count == null) {
        theScoreCard.put(card, 1);
      } else {
        theScoreCard.put(card, count + 1);
      }
    }
  }

  /** Retrieve the map representing all count frequencies. */
  public Map<Card, Integer> getNumOfAttempts() {
    return Collections.unmodifiableMap(theScoreCard);
  }
}
