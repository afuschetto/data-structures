package com.afuschetto.datastructures;

import java.util.NoSuchElementException;

public class Queue<E> {
    private E dataArray[];
    private int front = -1;
    private int rear = -1;
    private int nItems = 0;

    public Queue(int capacity) {
        dataArray = (E[]) new Object[capacity];
    }

    public void enqueue(E item) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Full queue");
        }

        front = (front + 1) % dataArray.length;
        dataArray[front] = item;
        ++nItems;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty queue");
        }

        rear = (rear + 1) % dataArray.length;
        E item = dataArray[rear];
        --nItems;
        return item;
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == dataArray.length;
    }
}
