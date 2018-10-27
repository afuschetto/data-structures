package com.afuschetto.datastructures;

import java.util.NoSuchElementException;

public class Queue<T> {
    private int size;
    private T dataArray[];
    private int front;
    private int rear;
    private int nItems;

    public Queue(int size) {
        this.size = size;
        dataArray = (T[]) new Object[size];
        front = -1;
        rear = -1;
    }

    public void enqueue(T item) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Full queue");
        }

        front = (front + 1) % size;
        dataArray[front] = item;
        ++nItems;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty queue");
        }

        rear = (rear + 1) % size;
        T item = dataArray[rear];
        --nItems;
        return item;
    }

    public boolean isEmpty() {
        return (0 == nItems);
    }

    public boolean isFull() {
        return (size == nItems);
    }
}
