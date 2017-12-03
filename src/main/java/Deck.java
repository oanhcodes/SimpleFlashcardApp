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

    @Override
    public E peek() {
        if (size == 0) {
            return null;
        } else {
            return data[front];
        }
    }

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

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

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
