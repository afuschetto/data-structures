import com.afuschetto.algorithms.BinarySearch;
import com.afuschetto.algorithms.InsertionSort;
import com.afuschetto.algorithms.LinearSearch;
import com.afuschetto.algorithms.SelectionSort;
import com.afuschetto.datastructures.*;

public class TestApp {
    public static void main(String args[]) {
        testStack();
        testQueue();
        testSinglyLinkedList();
        testCircularLinkedList();
        testDoublyLinkedList();

        testLinearSearch();
        testBinarySearch();
        testSelectionSort();
        testInsertionSort();
    }

    private static void testStack() {
        System.out.println(">> Data Structures >> Testing Stack...");

        Stack<Integer> myStack = new Stack<>(5);
        assert myStack.isEmpty();

        myStack.push(5);
        myStack.push(4);
        myStack.push(3);
        myStack.push(2);
        myStack.push(1);
        myStack.pop();
        myStack.pop();
        myStack.push(2);
        myStack.push(1);

        assert !myStack.isEmpty();
        assert myStack.pop() == 1;
        assert myStack.pop() == 2;
        assert myStack.pop() == 3;
        assert myStack.pop() == 4;
        assert myStack.pop() == 5;
        assert myStack.isEmpty();
    }

    private static void testQueue() {
        System.out.println(">> Data Structures >> Testing Queue...");

        Queue<Integer> myQueue = new Queue<>(5);
        assert myQueue.isEmpty();

        myQueue.enqueue(4);
        myQueue.enqueue(5);
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.dequeue();
        myQueue.dequeue();
        myQueue.enqueue(4);
        myQueue.enqueue(5);

        assert !myQueue.isEmpty();
        assert myQueue.dequeue() == 1;
        assert myQueue.dequeue() == 2;
        assert myQueue.dequeue() == 3;
        assert myQueue.dequeue() == 4;
        assert myQueue.dequeue() == 5;
        assert myQueue.isEmpty();
    }

    private static void testSinglyLinkedList() {
        System.out.println(">> Data Structures >> Testing Singly Linked List...");

        SinglyLinkedList<Integer> myList = new SinglyLinkedList<>();
        assert myList.isEmpty();

        myList.addLast(1);
        myList.addLast(2);
        myList.addLast(3);
        myList.addLast(4);
        myList.addLast(5);
        myList.removeFirst();
        myList.removeLast();
        myList.addFirst(1);
        myList.addLast(5);

        assert !myList.isEmpty();
        assert myList.removeFirst() == 1;
        assert myList.removeFirst() == 2;
        assert myList.removeFirst() == 3;
        assert myList.removeLast() == 5;
        assert myList.removeLast() == 4;
        assert myList.isEmpty();
    }

    private static void testCircularLinkedList() {
        System.out.println(">> Data Structures >> Testing Circular Linked List...");

        CircularLinkedList<Integer> myList = new CircularLinkedList<>();
        assert myList.isEmpty();

        myList.addLast(1);
        myList.addLast(2);
        myList.addLast(3);
        myList.addLast(4);
        myList.addLast(5);
        myList.removeFirst();
        myList.removeLast();
        myList.addFirst(1);
        myList.addLast(5);

        assert !myList.isEmpty();
        assert myList.removeFirst() == 1;
        assert myList.removeFirst() == 2;
        assert myList.removeFirst() == 3;
        assert myList.removeLast() == 5;
        assert myList.removeLast() == 4;
        assert myList.isEmpty();
    }

    private static void testDoublyLinkedList() {
        System.out.println(">> Data Structures >> Testing Doubly Linked List...");

        DoublyLinkedList<Integer> myList = new DoublyLinkedList<>();
        assert myList.isEmpty();

        myList.addLast(1);
        myList.addLast(2);
        myList.addLast(3);
        myList.addLast(4);
        myList.addLast(5);
        myList.removeFirst();
        myList.removeLast();
        myList.addFirst(1);
        myList.addLast(5);

        assert !myList.isEmpty();
        assert myList.removeFirst() == 1;
        assert myList.removeFirst() == 2;
        assert myList.removeFirst() == 3;
        assert myList.removeLast() == 5;
        assert myList.removeLast() == 4;
        assert myList.isEmpty();
    }

    private static void testLinearSearch() {
        System.out.println(">> Algorithms >> Testing Linear Search...");

        int[] array = {00, 10, 20, 30, 40, 50, 60, 70, 80, 90};

        assert LinearSearch.search(array, 30) == 3;
        assert LinearSearch.search(array, 100) == -1;
    }

    private static void testBinarySearch() {
        System.out.println(">> Algorithms >> Testing Binary Search (Iterative)...");

        int[] array = {00, 10, 20, 30, 40, 50, 60, 70, 80, 90};

        assert BinarySearch.searchIteratively(array, 30) == 3;
        assert BinarySearch.searchIteratively(array, 100) == -1;

        System.out.println(">> Algorithms >> Testing Binary Search (Recursive)...");

        assert BinarySearch.searchRecursively(array, 30) == 3;
        assert BinarySearch.searchRecursively(array, 100) == -1;
    }

    private static void testSelectionSort() {
        System.out.println(">> Algorithms >> Testing Selection Sort...");

        int[] array = {4, 3, 1, 5, 2, 8, 7, 0, 9, 6};
        SelectionSort.sort(array);

        assert array[0] == 0;
        assert array[1] == 1;
        assert array[2] == 2;
        assert array[3] == 3;
        assert array[4] == 4;
        assert array[5] == 5;
        assert array[6] == 6;
        assert array[7] == 7;
        assert array[8] == 8;
        assert array[9] == 9;
    }

    private static void testInsertionSort() {
        System.out.println(">> Algorithms >> Testing Insertion Sort...");

        int[] array = {4, 3, 1, 5, 2, 8, 7, 0, 9, 6};
        InsertionSort.sort(array);

        assert array[0] == 0;
        assert array[1] == 1;
        assert array[2] == 2;
        assert array[3] == 3;
        assert array[4] == 4;
        assert array[5] == 5;
        assert array[6] == 6;
        assert array[7] == 7;
        assert array[8] == 8;
        assert array[9] == 9;
    }
}
