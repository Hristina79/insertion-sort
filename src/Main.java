import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        SingleLinkedList<Integer> queue = new SingleLinkedList<>();
        queue.enqueue(4);
        queue.enqueue(1);
        queue.enqueue(5);
        queue.enqueue(2);
        queue.enqueue(3);

        InsertionSort<Integer> sorter = new InsertionSort<>();
        sorter.sort(queue, Comparator.naturalOrder());

        System.out.println("Final queue: " + queue);
    }
}
