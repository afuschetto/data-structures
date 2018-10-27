package com.afuschetto.datastructures;

import java.util.NoSuchElementException;

public class Stack<T> {
    private int size;
    private T dataArray[];
    private int top;

    public Stack(int size) {
        this.size = size;
        dataArray = (T[]) new Object[size];
        top = -1;
    }

    public void push(T item) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Full stack");
        }

        dataArray[++top] = item;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty stack");
        }

        return dataArray[top--];
    }

    public boolean isEmpty() {
        return (-1 == top);
    }

    public boolean isFull() {
        return ((size - 1) == top);
    }
}
