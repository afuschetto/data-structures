import com.afuschetto.algorithms.*;
import com.afuschetto.datastructures.*;

public class TestApp {
    public static void main(String args[]) {
        testStack();
        testQueue();
        testSinglyLinkedList();
        testCircularLinkedList();
        testDoublyLinkedList();
        testBinarySearchTree();
        testBinaryHeap();
        testHashTable();

        testLinearSearch();
        testBinarySearch();
        testSelectionSort();
        testInsertionSort();
        testMergeSort();
        testQuickSort();
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

    private static void testBinarySearchTree() {
        System.out.println(">> Data Structures >> Testing Binary Search Tree...");

        BinarySearchTree<String> myTree = new BinarySearchTree<>();
        assert myTree.isEmpty();

        myTree.add(6, "Six");
        myTree.add(3, "Three");
        myTree.add(5, "Five");
        myTree.add(1, "One");
        myTree.add(9, "Nine");
        myTree.add(7, "Seven");
        myTree.add(4, "Four");
        myTree.add(0, "Zero");
        myTree.add(2, "Two");
        myTree.add(8, "Eight");
        assert !myTree.isEmpty();

        assert myTree.findMin().equals("Zero");
        assert myTree.findMax().equals("Nine");

        assert myTree.remove(0);
        assert myTree.remove(9);
        assert !myTree.remove(10);
        assert myTree.remove(3);

        assert myTree.findMin().equals("One");
        assert myTree.findMax().equals("Eight");
    }

    private static void testBinaryHeap() {
        System.out.println(">> Data Structures >> Testing Binary Heap...");

        BinaryHeap myHeap = new BinaryHeap(5);
        assert myHeap.isEmpty();
        assert !myHeap.isFull();

        myHeap.insert(1);
        myHeap.insert(2);
        myHeap.insert(3);
        myHeap.insert(4);
        myHeap.insert(5);
        assert !myHeap.isEmpty();
        assert myHeap.isFull();

        myHeap.remove();
        assert !myHeap.isEmpty();
        assert !myHeap.isFull();

        myHeap.insert(6);
        assert !myHeap.isEmpty();
        assert myHeap.isFull();
    }

    private static void testHashTable() {
        System.out.println(">> Data Structures >> Testing Hash Table...");

        HashTable myTable = new HashTable(5);
        assert myTable.isEmpty();

        myTable.insert("One");
        myTable.insert("Two");
        myTable.insert("Three");
        myTable.insert("Four");
        myTable.insert("Five");
        myTable.insert("Six");
        assert !myTable.isEmpty();

        assert myTable.find("Three");
        assert myTable.find("Six");
        assert !myTable.find("Seven");
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

    private static void testMergeSort() {
        System.out.println(">> Algorithms >> Testing Merge Sort...");

        int[] array = {4, 3, 1, 5, 2, 8, 7, 0, 9, 6};
        MergeSort.sort(array);

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

    private static void testQuickSort() {
        System.out.println(">> Algorithms >> Testing Quick Sort...");

        int[] array = {4, 3, 1, 5, 2, 8, 7, 0, 9, 6};
        QuickSort.sort(array);

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
