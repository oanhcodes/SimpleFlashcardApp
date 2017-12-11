import java.util.*;

/** A map-based class for counting attempts to answer flashcard question */
public class ScoreCard {

  /** The map for storing the answer attempts. */
  private final Map<Card, Integer> theScoreCard;

  private List<Map.Entry<Card, Integer>> scoreCardList;

  /** Creates a score card instance based on the given map. */
  public ScoreCard(final Map<Card, Integer> theScoreCard) {
    this.theScoreCard = theScoreCard;
    this.scoreCardList = new ArrayList<>();
  }

  /** Creates an empty score card */
  public void createNewScoreCard(final Iterator<Card> flashcards) {
    while (flashcards.hasNext()) {
      final Card card = flashcards.next();
      theScoreCard.put(card, 0);
    }
  }

  /** Counts the number of attempts the user makes to answer a flashcard question */
  public void addAttempt(final Card card) {
    Integer count = theScoreCard.get(card);
    theScoreCard.put(card, count + 1);
  }

  /** Retrieve the map representing all count frequencies. */
  public Map<Card, Integer> getScoreMap() {
    return Collections.unmodifiableMap(theScoreCard);
  }

  /** Create ScoreCard as a list */
  public List<Map.Entry<Card, Integer>> asList() {
    Map<Card, Integer> currScoreCard = getScoreMap();
    for (Map.Entry<Card, Integer> pair : currScoreCard.entrySet()) {
      scoreCardList.add(pair);
    }
    return scoreCardList;
  }

  /** Prints ScoreCard */
  public void printScoreCard() {
    asList();
    float numCorrect = 0;

    System.out.println(
        "\nHere are the results for the attempts you made to answer each question. ");

    for (Map.Entry<Card, Integer> pair : scoreCardList) {
      if (pair.getValue() == 1) {
        numCorrect = numCorrect + 1;
      }
      System.out.println(pair.getKey().getQuestion() + " = " + pair.getValue());
    }

    float score = (numCorrect / (float) scoreCardList.size()) * 100;

    System.out.println(
        "\nYou answered " + score + "% of the questions correctly on the first try.");
  }
}
