package com.afuschetto.datastructures;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {
    private Node first;

    public SinglyLinkedList() {
        first = null;
    }

    public void addFirst(E item) {
        Node newNode = new Node();
        newNode.data = item;
        newNode.next = first;

        first = newNode;
    }

    public void addLast(E item) {
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

    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty linked list");
        }

        Node firstNode = first;
        first = first.next;
        return firstNode.data;
    }

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
        } else {
            // There are two or more nodes, then set the penultimate node as last
            prevNode.next = null;
        }
        return currNode.data;
    }

    public boolean isEmpty() {
        return null == first;
    }

    private class Node {
        E data;
        Node next;

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
