## Insertion Sort Implementation in Java
This repository contains an implementation of the Insertion Sort algorithm in Java.

- **Insertion Sort**: gives a final sorted list by taking one element at a time and checks the next element, and if is smaller, the element is moved to the left until its in correct position among the sorted items.

### Project Structure

- MyQueue.java
  
  Interface defining the basic queue operations (`enqueue`, `dequeue`, `peek`, etc.).

- SingleLinkedList.java

  Implements MyQueue<T> using a single linked list. Provides the queue functionality used by the sorting algorithm.

- InsertionSort.java

  Implements the selection sort algorithm specifically made to work with SingleLinkedList<T>. It supports custom sorting using a Comparator, or default to natural ordering.

- Main.java

  Contains an example where a SingleLinkedList is filled with data, sorted using InsertionSort, and results are printed.

-  SingleLinkedListTest.java

  Provides unit tests to ensure correctness on SingleLinkedList implementation.

  ### How it works

  1. It detaches the current node from the unsorted list.
  2. Finds the correct position in the sorted part.
  3. Inserts the node there, maintaining sorted order.
