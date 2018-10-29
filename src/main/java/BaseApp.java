import com.afuschetto.datastructures.CircularLinkedList;
import com.afuschetto.datastructures.Queue;
import com.afuschetto.datastructures.SinglyLinkedList;
import com.afuschetto.datastructures.Stack;

public class BaseApp {
    public static void main(String args[]) {
        testStack();
        testQueue();
        testSinglyLinkedList();
        testCircularLinkedList();
    }

    private static void testStack() {
        System.out.println("*** Test Stack ***");

        Stack myStack = new Stack<Integer>(5);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        while (!myStack.isEmpty()) {
            System.out.println(myStack.pop());
        }
    }

    private static void testQueue() {
        System.out.println("*** Test Queue ***");

        Queue myQueue = new Queue<Integer>(5);
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.enqueue(5);

        while (!myQueue.isEmpty()) {
            System.out.println(myQueue.dequeue());
        }
    }

    private static void testSinglyLinkedList() {
        System.out.println("*** Test Singly Linked List ***");

        SinglyLinkedList myList = new SinglyLinkedList<Integer>();
        myList.addLast(1);
        myList.addLast(2);
        myList.addLast(3);
        myList.addLast(4);
        myList.addLast(5);

        while (!myList.isEmpty()) {
            System.out.println(myList.removeLast());
        }
    }

    static void testCircularLinkedList() {
        System.out.println("*** Test Circular Linked List ***");

        CircularLinkedList myList = new CircularLinkedList<Integer>();
        myList.addLast(1);
        myList.addLast(2);
        myList.addLast(3);
        myList.addLast(4);
        myList.addLast(5);

        while (!myList.isEmpty()) {
            System.out.println(myList.removeLast());
        }
    }
}
