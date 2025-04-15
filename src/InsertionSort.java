import java.util.Comparator;

public class InsertionSort<T extends Comparable<T>> {

    public MyQueue<T> sort(MyQueue<T> queue, Comparator<T> comparator) {

        // check if input is from a compatible type (of SingleLinkedList)
        if (!(queue instanceof SingleLinkedList)) {
            throw new IllegalArgumentException("This sorter only works with SingleLinkedListQueue!");
        }

        // Cast SingleLinkedList for direct access
        SingleLinkedList<T> listQueue = (SingleLinkedList<T>) queue;

        System.out.println("Original queue:");
        System.out.println(listQueue); // Uses toString()

        // Start with an empty sorted list
        SingleLinkedList<T>.Node sortedHead = null;
        SingleLinkedList<T>.Node current = listQueue.head;

        // Go through each node and insert it into the correct place in sorted part
        while (current != null) {
            SingleLinkedList<T>.Node next = current.next; // Save next
            current.next = null; // Detach current
            sortedHead = insertSorted(sortedHead, current, comparator); // Insert into sorted list
            current = next; // Move to the next node
        }

        // Update the head to point to the sorted list
        listQueue.head = sortedHead;

        // Update tail
        listQueue.tail = null;
        SingleLinkedList<T>.Node temp = sortedHead;
        while (temp != null && temp.next != null) {
            temp = temp.next;
        }
        listQueue.tail = temp;

        System.out.println("Sorted queue:");
        System.out.println(listQueue);

        return listQueue;
    }

    // Helper method to insert a node into the correct position in sorted list
    private SingleLinkedList<T>.Node insertSorted(SingleLinkedList<T>.Node sortedHead, SingleLinkedList<T>.Node node, Comparator<T> comparator) {
        // Insert at beginning if list is empty or node should go first
        if (sortedHead == null || compare(node.data, sortedHead.data, comparator) <= 0) {
            node.next = sortedHead;
            return node;
        }

        // Find insertion point
        SingleLinkedList<T>.Node current = sortedHead;
        while (current.next != null && compare(current.next.data, node.data, comparator) < 0) {
            current = current.next;
        }

        // Insert node
        node.next = current.next;
        current.next = node;
        return sortedHead;
    }

    /**
     * Compares two elements using the provided Comparator / if null it takes natural ordering
     */
    private int compare(T a, T b, Comparator<T> comparator) {
        return (comparator != null) ? comparator.compare(a, b) : a.compareTo(b);
    }
}
