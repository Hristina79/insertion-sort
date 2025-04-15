public interface MyQueue<T> {
    void enqueue(T item);  // Add to the back
    T dequeue();           // Remove from the front
    T peek();              // Check front element
    boolean isEmpty();
    int size();
}
