import java.util.*;

public class ScoreCard {

  private final Map<Card, Integer> theScoreCard;
  private List<Map.Entry<Card, Integer>> scoreCardList;

  /**
   * Creates a score card map instance based on the given map. Creates a new array list of map key
   * value pairs to be printed
   *
   * @param theScoreCard map with Card and Integer pair
   */
  public ScoreCard(final Map<Card, Integer> theScoreCard) {
    this.theScoreCard = theScoreCard;
    this.scoreCardList = new ArrayList<>();
  }

  /**
   * Creates an empty score card by iterating through all the given flashcards. Each card has an
   * initial attempt count value of 0
   *
   * @param flashcards Iterator of the card arrayList
   */
  public void createNewScoreCard(final Iterator<Card> flashcards) {
    while (flashcards.hasNext()) {
      final Card card = flashcards.next();
      theScoreCard.put(card, 0);
    }
  }

  /**
   * Increments the number of attempts the user makes to answer a flashcard question by 1
   *
   * @param card the current card being played
   */
  public void addAttempt(final Card card) {
    Integer count = theScoreCard.get(card);
    theScoreCard.put(card, count + 1);
  }

  /**
   * Retrieve the map representing all count frequencies.
   *
   * @return the map containing all the card and integer pairs
   */
  public Map<Card, Integer> getScoreMap() {
    return Collections.unmodifiableMap(theScoreCard);
  }

  /**
   * Create ScoreCard as a list
   *
   * @return the scores as a list of Map entries
   */
  public List<Map.Entry<Card, Integer>> asList() {
    Map<Card, Integer> currScoreCard = getScoreMap();
    for (Map.Entry<Card, Integer> pair : currScoreCard.entrySet()) {
      scoreCardList.add(pair);
    }
    return scoreCardList;
  }

  /** Prints ScoreCard Pretty */
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
