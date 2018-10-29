package com.afuschetto.datastructures;

import java.util.NoSuchElementException;

public class CircularLinkedList<E> {
    private Node<E> first;
    private Node<E> last;

    public CircularLinkedList() {
        first = null;
        last = null;
    }

    public void addFirst(E item) {
        Node newNode = new Node();
        newNode.data = item;
        newNode.next = first;

        if (isEmpty()) {
            last = newNode;
        }
        first = newNode;
    }

    public void addLast(E item) {
        Node newNode = new Node();
        newNode.data = item;
        newNode.next = null;

        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty linked list");
        }

        Node firstNode = first;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return (E) firstNode.data;
    }

    // The reference to the last node does not help to improve the computational cost
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty linked list");
        }

        // Iterate until "prevNode" is the penultimate node and "currNode" the last one
        Node prevNode = null;
        Node currNode = first;
        while (null != currNode.next) {
            prevNode = currNode;
            currNode = currNode.next;
        }

        if (null == prevNode) {
            // There is only one node, then empty the list
            first = null;
            last = null;
        } else {
            // There are two or more nodes, then set the penultimate node as last
            prevNode.next = null;
            last = prevNode;
        }

        return (E) currNode.data;
    }

    public boolean isEmpty() {
        return (null == first);
    }

    private class Node<E> {
        public E data;
        public Node next;

        public String toString() {
            return data.toString();
        }
    }
}
