package com.afuschetto.datastructures;

import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {
    private Node first = null;
    private Node last = null;

    public void addFirst(E item) {
        Node newNode = new Node();
        newNode.data = item;
        newNode.previous = null;
        newNode.next = first;

        if (isEmpty()) {
            last = newNode;
        } else {
            first.previous = newNode;
        }
        first = newNode;
    }

    public void addLast(E item) {
        Node newNode = new Node();
        newNode.data = item;
        newNode.previous = last;
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
        first = firstNode.next;
        if (first != null) {
            first.previous = null;
        } else {
            last = null;
        }
        return firstNode.data;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty linked list");
        }

        Node lastNode = last;
        last = lastNode.previous;
        if (last != null) {
            last.next = null;
        } else {
            first = null;
        }
        return lastNode.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    private class Node {
        E data;
        Node previous;
        Node next;

        @Override
        public String toString() {
            return data.toString();
        }
    }
}