import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedListTest {

    @Test
    void dequeue() {
        // Check that an error occurs when tries to dequeue an empty node
        SingleLinkedList<Integer> queue = new SingleLinkedList<>();
        queue.enqueue(1);
        queue.dequeue();

        Exception exception = assertThrows(NoSuchElementException.class, queue::dequeue);
        var actualMessage = exception.getMessage();
        assertTrue(exception.getMessage().contains(actualMessage));
    }

    @Test
    void peek() {
        SingleLinkedList<Integer> queue = new SingleLinkedList<>();

        // Check that it sees the correct head
        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(queue.size(), 2);
        assertEquals(queue.peek(), 1);
        assertFalse(queue.peek().equals(2));

        // Check that an error occurs when tries to peek an empty head
        queue.dequeue();
        queue.dequeue();

        Exception exception = assertThrows(NoSuchElementException.class, queue::peek);
        var actualMessage = exception.getMessage();
        assertTrue(exception.getMessage().contains(actualMessage));
    }

    @Test
    void isEmpty() {
        SingleLinkedList<Integer> queue = new SingleLinkedList<>();

        // check if the queue is not empty
        queue.enqueue(1);
        System.out.println("Is the queue empty? -> " + queue.isEmpty());
        assertFalse(queue.isEmpty());

        // check if the queue is empty
        queue.dequeue();
        System.out.println("Is the queue empty? -> " + queue.isEmpty());
        assertTrue(queue.isEmpty());
    }

    @Test
    void size() {
        SingleLinkedList<Integer> queue = new SingleLinkedList<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Check if the size != 0
        assertEquals(3, queue.size());
        assertFalse(queue.isEmpty());

        // Check if the size = 0
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }

    @Test
    void testToString() {
        SingleLinkedList<Integer> queue = new SingleLinkedList<>();

        queue.enqueue(4);
        queue.enqueue(2);
        queue.enqueue(6);

        System.out.println(queue);
        assertEquals("[4, 2, 6]", queue.toString());
    }
}