import com.afuschetto.datastructures.*;

public class TestApp {
    public static void main(String args[]) {
        testStack();
        testQueue();
        testSinglyLinkedList();
        testCircularLinkedList();
        testDoublyLinkedList();
    }

    private static void testStack() {
        System.out.println(">> Testing Stack...");

        Stack myStack = new Stack<Integer>(5);
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
        assert 1 == (int) myStack.pop();
        assert 2 == (int) myStack.pop();
        assert 3 == (int) myStack.pop();
        assert 4 == (int) myStack.pop();
        assert 5 == (int) myStack.pop();
        assert myStack.isEmpty();
    }

    private static void testQueue() {
        System.out.println(">> Testing Queue...");

        Queue myQueue = new Queue<Integer>(5);
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
        assert 1 == (int) myQueue.dequeue();
        assert 2 == (int) myQueue.dequeue();
        assert 3 == (int) myQueue.dequeue();
        assert 4 == (int) myQueue.dequeue();
        assert 5 == (int) myQueue.dequeue();
        assert myQueue.isEmpty();
    }

    private static void testSinglyLinkedList() {
        System.out.println(">> Testing Singly Linked List...");

        SinglyLinkedList myList = new SinglyLinkedList<Integer>();
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
        assert 1 == (int) myList.removeFirst();
        assert 2 == (int) myList.removeFirst();
        assert 3 == (int) myList.removeFirst();
        assert 5 == (int) myList.removeLast();
        assert 4 == (int) myList.removeLast();
        assert myList.isEmpty();
    }

    static void testCircularLinkedList() {
        System.out.println(">> Testing Circular Linked List...");

        CircularLinkedList myList = new CircularLinkedList<Integer>();
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
        assert 1 == (int) myList.removeFirst();
        assert 2 == (int) myList.removeFirst();
        assert 3 == (int) myList.removeFirst();
        assert 5 == (int) myList.removeLast();
        assert 4 == (int) myList.removeLast();
        assert myList.isEmpty();
    }

    private static void testDoublyLinkedList() {
        System.out.println(">> Testing Doubly Linked List...");

        DoublyLinkedList myList = new DoublyLinkedList<Integer>();
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
        assert 1 == (int) myList.removeFirst();
        assert 2 == (int) myList.removeFirst();
        assert 3 == (int) myList.removeFirst();
        assert 5 == (int) myList.removeLast();
        assert 4 == (int) myList.removeLast();
        assert myList.isEmpty();
    }
}
