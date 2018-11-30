package com.afuschetto.datastructures;

public class BinaryHeap {
    private int data[];
    private int size;

    public BinaryHeap(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public void insert(int item) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Full heap");
        }

        // Find the correct position for the new item by iterating the tree
        // until the root or the item larger than it
        int idx = size++;
        int parentIdx = getParentIdx(idx);
        while (idx > 0 && item > data[parentIdx]) {
            data[idx] = data[parentIdx];

            // Go up
            idx = parentIdx;
            parentIdx = getParentIdx(idx);
        }
        data[idx] = item;
    }

    public void remove() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Empty heap");
        }

        int lastItem = data[--size];

        // Find the correct position for the last item by iterating the tree
        // until the item larger than it
        int idx = 0;
        int childIdx = getLeftChildIdx(idx);
        while (childIdx < size) {
            // If the current node has two children, then choose the largest
            if ((childIdx + 1) < size && data[childIdx] < data[childIdx + 1]) {
                childIdx++;
            }

            // The current node is therefore larger than the last item
            if (data[childIdx] <= lastItem) {
                break;
            }

            data[idx] = data[childIdx];

            // Go down
            idx = childIdx;
            childIdx = getLeftChildIdx(idx);

        }
        data[idx] = lastItem;
    }

    private int getParentIdx(int idx) {
        return (idx - 1) / 2;
    }

    private int getLeftChildIdx(int idx) {
        return (2 * idx) + 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }
}
