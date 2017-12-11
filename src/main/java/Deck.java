import java.util.ArrayList;
import java.util.List;

public class Deck<E> implements SimpleQueue<E> {

  private final int capacity;
  private int size;
  private int front;
  private int rear;
  private final E[] data;
  private List<E> cardList;

  @SuppressWarnings("unchecked")
  public Deck(final int capacity) {
    this.capacity = capacity;
    this.data = (E[]) new Object[capacity];
    this.size = 0;
    this.front = 0;
    this.rear = capacity - 1;
  }

  /**
   * Returns a boolean value based on whether or not the element was added successfully based on the
   * size and capacity of the deck
   *
   * @param obj a Card, or any other object
   * @return true or false
   */
  @Override
  public boolean offer(final E obj) {
    if (size < capacity) {
      size++;
      rear = (rear + 1) % capacity;
      data[rear] = obj;
      return true;
    }
    return false;
  }

  /**
   * Retreives the card at the head of the deck or null is the deck is empty
   *
   * @return the first card or element at the head of the deck queue or null
   */
  @Override
  public E peek() {
    if (size == 0) {
      return null;
    } else {
      return data[front];
    }
  }

  /**
   * Retreives and removes the card at the head of the deck or null is the deck is empty
   *
   * @return the first card or element at the head of the deck queue or null
   */
  @Override
  public E poll() {
    if (size == 0) {
      return null;
    } else {
      E result = data[front];
      front = (front + 1) % capacity;
      size--;
      return result;
    }
  }

  /**
   * Returns a boolean value based on whether or not the deck has the size greater than 0
   *
   * @return true or false
   */
  @Override
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    }
    return false;
  }

  /**
   * Returns the size of the deck
   *
   * @return the size
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Returns the deck as an ArrayList
   *
   * @return the deck elements in an ArrayList
   */
  @Override
  public List<E> asList() {
    // Done implement using an ArrayList preallocated with the right size
    cardList = new ArrayList<>(capacity);
    while (!isEmpty()) {
      cardList.add(data[front]);
      front = (front + 1) % capacity;
      size--;
    }
    return cardList;
  }
}
