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



}
