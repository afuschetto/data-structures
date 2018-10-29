package com.afuschetto.datastructures;

import java.util.NoSuchElementException;

public class Stack<E> {
    private int size;
    private E dataArray[];
    private int top;

    public Stack(int size) {
        this.size = size;
        dataArray = (E[]) new Object[size];
        top = -1;
    }

    public void push(E item) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Full stack");
        }

        dataArray[++top] = item;
    }

    public E pop() {
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
