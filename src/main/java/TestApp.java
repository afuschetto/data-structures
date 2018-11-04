import com.afuschetto.algorithms.LinearSearch;
import com.afuschetto.datastructures.*;

public class TestApp {
    public static void main(String args[]) {
        testStack();
        testQueue();
        testSinglyLinkedList();
        testCircularLinkedList();
        testDoublyLinkedList();

        testLinearSearch();
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
}
