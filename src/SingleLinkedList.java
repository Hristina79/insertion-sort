import java.util.NoSuchElementException;

public class SingleLinkedList<T extends Comparable<T>> implements MyQueue<T> {

    public Node head;
    public Node tail;
    private int size;

    public class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public SingleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Add to the end (enqueue)
    public void enqueue(T item) {
        Node newNode = new Node(item);
        if (tail == null) { // Empty queue
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }


    // Remove from the front (dequeue) -> one at a time
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty!");
        }
        T data = head.data;
        head = head.next;
        if (head == null) { // Last element removed
            tail = null;
        }
        size--;
        return data;
    }

    // Peek front element
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty!");
        }
        return head.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // toString() for debugging
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}