package com.afuschetto.datastructures;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private Node<T> first;

    public SinglyLinkedList() {
        first = null;
    }

    public void addFirst(T item) {
        Node newNode = new Node();
        newNode.data = item;
        newNode.next = first;

        first = newNode;
    }

    public void addLast(T item) {
        Node newNode = new Node();
        newNode.data = item;
        newNode.next = null;

        if (isEmpty()) {
            first = newNode;
        } else {
            // Iterate until "currNode" is the last node
            Node currNode = first;
            while (null != currNode.next) {
                currNode = currNode.next;
            }

            currNode.next = newNode;
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty linked list");
        }

        Node firstNode = first;
        first = first.next;
        return (T) firstNode.data;
    }

    public T removeLast() {
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
        } else {
            // There are two or more nodes, then set the penultimate node as last
            prevNode.next = null;
        }
        return (T) currNode.data;
    }

    public boolean isEmpty() {
        return (null == first);
    }

    private class Node<T> {
        public T data;
        public Node next;

        public String toString() {
            return data.toString();
        }
    }
}
