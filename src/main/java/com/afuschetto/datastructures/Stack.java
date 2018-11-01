package com.afuschetto.datastructures;

import java.util.NoSuchElementException;

public class Stack<E> {
    private int size;
    private E dataArray[];
    private int top = -1;

    public Stack(int size) {
        this.size = size;
        dataArray = (E[]) new Object[size];
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
        return top == -1;
    }

    public boolean isFull() {
        return top == (size - 1);
    }
}
