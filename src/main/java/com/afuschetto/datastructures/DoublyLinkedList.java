package com.afuschetto.datastructures;

import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {
    private Node first;
    private Node last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

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
        if (null != first) {
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
        if (null != last) {
            last.next = null;
        } else {
            first = null;
        }
        return lastNode.data;
    }

    public boolean isEmpty() {
        return null == first;
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