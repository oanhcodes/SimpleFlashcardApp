import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCard {
  private Card fixture;

  @Before
  public void setUp() {
    fixture = new Card();
  }

  @After
  public void tearDown() {
    fixture = null;
  }

  @Test
  public void testInitial() {
    fixture.setQuestion("What is the capital of Illinois");
    fixture.setAnswer("Springfield");
    assertEquals("What is the capital of Illinois", fixture.getQuestion());
    assertEquals("Springfield", fixture.getAnswer());
  }

  @Test
  public void testCheckAnswer() {
    fixture.setQuestion("What is the capital of Illinois");
    fixture.setAnswer("Springfield");
    assertEquals(false, fixture.getIsCorrect());
    assertEquals(true, fixture.checkAnswer("Springfield"));
    assertEquals(false, fixture.checkAnswer("Chicago"));
  }
}
