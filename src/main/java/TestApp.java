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
        assert 1 == myStack.pop();
        assert 2 == myStack.pop();
        assert 3 == myStack.pop();
        assert 4 == myStack.pop();
        assert 5 == myStack.pop();
        assert myStack.isEmpty();
    }

    private static void testQueue() {
        System.out.println(">> Testing Queue...");

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
        assert 1 == myQueue.dequeue();
        assert 2 == myQueue.dequeue();
        assert 3 == myQueue.dequeue();
        assert 4 == myQueue.dequeue();
        assert 5 == myQueue.dequeue();
        assert myQueue.isEmpty();
    }

    private static void testSinglyLinkedList() {
        System.out.println(">> Testing Singly Linked List...");

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
        assert 1 == myList.removeFirst();
        assert 2 == myList.removeFirst();
        assert 3 == myList.removeFirst();
        assert 5 == myList.removeLast();
        assert 4 == myList.removeLast();
        assert myList.isEmpty();
    }

    private static void testCircularLinkedList() {
        System.out.println(">> Testing Circular Linked List...");

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
        assert 1 == myList.removeFirst();
        assert 2 == myList.removeFirst();
        assert 3 == myList.removeFirst();
        assert 5 == myList.removeLast();
        assert 4 == myList.removeLast();
        assert myList.isEmpty();
    }

    private static void testDoublyLinkedList() {
        System.out.println(">> Testing Doubly Linked List...");

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
        assert 1 == myList.removeFirst();
        assert 2 == myList.removeFirst();
        assert 3 == myList.removeFirst();
        assert 5 == myList.removeLast();
        assert 4 == myList.removeLast();
        assert myList.isEmpty();
    }
}
