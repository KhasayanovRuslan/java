//2. Создать класс для реализации дека.

import java.util.NoSuchElementException;

public class Deque {
    private int capacity;
    private int[] deque;
    private int first;
    private int last;
    private int items;

    public Deque(int capacity) {
        this.capacity = capacity;
        deque = new int[capacity];
        first = -1;
        last = capacity;
        items = 0;
    }

    public boolean isEmpty() {
        return items == 0;
    }

    public boolean isFull() {
        return items == capacity;
    }

    public int size() {
        return items;
    }

    public void insertFirst(int value) {
        if (isFull()) {
            capacity *= 2;
            int[] newDeque = new int[capacity];
            System.arraycopy(deque, 0, newDeque, 0, deque.length);
            deque = newDeque;
        }
        deque[++first] = value;
    }

    public void insertLast(int value) {
        if (isFull()) {
            capacity *= 2;
            int[] newDeque = new int[capacity];
            System.arraycopy(deque, 0, newDeque, 0, deque.length);
            deque = newDeque;
        }
        deque[--last] = value;
    }

    public int removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException("Deque is empty");
        int temp = deque[first--];
        if (first < -1) first = -1;
        items--;
        return temp;
    }

    public int removeLast() {
        if (isEmpty())
            throw new NoSuchElementException("Deque is empty");
        int temp = deque[last++];
        if (last > capacity) last = capacity;
        items--;
        return temp;
    }

    public int peekFirst() {
        return deque[first];
    }

    public int peekLast() {
        return deque[last];
    }
}
