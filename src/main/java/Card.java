public class Card {

  private String question;
  private String answer;
  private Boolean isCorrect;

  public Card() {
    this.isCorrect = false;
  }

  public Card(String question, String answer) {
    this.isCorrect = false;
    this.question = question;
    this.answer = answer.toLowerCase();
  }

  /**
   * Get the current value of the question property. The question property controls the question
   * displayed to the user when the card is selected from Deck
   *
   * @return The question on the card
   */
  public String getQuestion() {
    return question;
  }

  /**
   * Get the current value of the answer property. The answer property controls the answer displayed
   * to the user when the card is selected from Deck
   *
   * @return The answer on the card
   */
  public String getAnswer() {
    return answer;
  }

  /**
   * Get the current value of the isCorrect property. The isCorrect property controls whether or not
   * the card will be returned to the Deck and replayed during a review session.
   *
   * @return the value of whether or not a user answered the current question correctly
   */
  public Boolean getIsCorrect() {
    return isCorrect;
  }

  /** Set the current value of the question property. */
  public void setQuestion(String question) {
    this.question = question;
  }

  /** Set the current value of the answer property. */
  public void setAnswer(String answer) {
    this.answer = answer;
  }

  /**
   * Sets current value of isCorrect to true when the user response is equal to current value of
   * answer property
   *
   * @return true is the user guessed right, returns false as a default value or if the user guessed
   *     wrong
   */
  public Boolean checkAnswer(String response) {
    if (answer.equals(response)) {
      isCorrect = true;
    } else {
      isCorrect = false;
    }
    return isCorrect;
  }
}
