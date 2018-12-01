package com.afuschetto.datastructures;

import java.util.ArrayList;
import java.util.List;

/*
 * A binary heap is a node-based binary tree data structure, with two
 * additional constraints: it is a complete tree (all levels are fully filled
 * except possibly the last one that is filled from left to right) and the key
 * stored in each node is either greater than or equal, or less than or equal,
 * to the keys in the node's children.
 *
 * Time complexity:
 *  - Insert: O(log(n))
 *  - Delete: O(log(n))
 *  - Search: O(n)
 */
public class BinaryHeap {
    private Node heap[];
    private int size;

    public BinaryHeap(int capacity) {
        heap = new Node[capacity];
        size = 0;
    }

    public void insert(int item) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Full heap");
        }

        Node newNode = new Node(item);

        // Find the correct position for the new node by iterating the tree
        // until the root or the node larger than it
        int idx = size++;
        int parentIdx = getParentIdx(idx);
        while (idx > 0 && newNode.key > heap[parentIdx].key) {
            heap[idx] = heap[parentIdx];

            // Go up
            idx = parentIdx;
            parentIdx = getParentIdx(idx);
        }
        heap[idx] = newNode;
    }

    public void remove() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Empty heap");
        }

        Node lastNode = heap[--size];

        // Find the correct position for the last node by iterating the tree
        // until the node larger than it
        int idx = 0;
        int childIdx = getLeftChildIdx(idx);
        while (childIdx < size) {
            // If the current node has two children, then choose the largest
            if ((childIdx + 1) < size && heap[childIdx].key < heap[childIdx + 1].key) {
                childIdx++;
            }

            // The current node is therefore larger than the last item
            if (heap[childIdx].key <= lastNode.key) {
                break;
            }

            heap[idx] = heap[childIdx];

            // Go down
            idx = childIdx;
            childIdx = getLeftChildIdx(idx);

        }
        heap[idx] = lastNode;
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
        return size == heap.length;
    }

    public void print() {
        if (isEmpty()) {
            return;
        }

        // Build a list of keys grouped by levels. Every missing node is
        // represented by null to obtain a full binary tree.
        List<List<Integer>> levels = buildLevels();

        // Calculate the box length for a single node (which includes left
        // side, key, and right side).
        int widestKeyLen = getWidestKeyLen();
        widestKeyLen += (widestKeyLen % 2 == 0 ? 4 : 5); // Must be divisible by 2
        int nodeBoxLen = widestKeyLen * levels.get(levels.size() - 1).size();

        for (int i = 0; i < levels.size(); i++) {
            List<Integer> level = levels.get(i);

            printEdges(i, level, nodeBoxLen);
            printNodes(level, nodeBoxLen);

            nodeBoxLen /= 2;
        }
    }

    private List<List<Integer>> buildLevels() {
        List<List<Integer>> levels = new ArrayList<>(); // Keys grouped by levels

        int nodeIdx = 0;
        int levelNo = 0;

        while (nodeIdx < size) {
            List<Integer> level = new ArrayList<>();

            int nNodes = (int) Math.pow(2, levelNo++);
            for (int i = 0; i < nNodes; i++) {
                level.add(nodeIdx < size ? heap[nodeIdx++].key : null);
            }

            levels.add(level);
        }

        return levels;
    }

    private int getWidestKeyLen() {
        return Integer.toString(heap[0].key).length();
    }

    private static void printEdges(int levelNo, List<Integer> level, int nodeBoxLen) {
        if (levelNo == 0) {
            return;
        }

        int lineLen = nodeBoxLen / 2;
        for (int i = 0; i < level.size(); i++) {
            if (i % 2 == 0) { // Even nodes
                if (level.get(i) != null) {
                    for (int j = 0; j < lineLen; j++) {
                        System.out.print(' ');
                    }
                    System.out.print('┌');
                    for (int j = 1; j < lineLen; j++) {
                        System.out.print('─');
                    }
                } else {
                    for (int j = 0; j < nodeBoxLen; j++) {
                        System.out.print(' ');
                    }
                }
            } else { // Odd nodes
                if (level.get(i) != null) {
                    System.out.print(level.get(i - 1) != null ? '┴' : '└');
                    for (int j = 1; j < lineLen; j++) {
                        System.out.print('─');
                    }
                    System.out.print('┐');
                    for (int j = 1; j < lineLen; j++) {
                        System.out.print(' ');
                    }
                } else {
                    System.out.print(level.get(i - 1) != null ? '┘' : ' ');
                    for (int j = 1; j < nodeBoxLen; j++) {
                        System.out.print(' ');
                    }
                }
            }
        }
        System.out.println();
    }

    private static void printNodes(List<Integer> level, int nodeBoxLen) {
        for (int i = 0; i < level.size(); i++) {
            Integer key = level.get(i);
            String keyStr = (key != null ? String.valueOf(key) : "");

            // Print the padding to the left side of the node
            int leftPadding = (int) Math.ceil(nodeBoxLen / 2f - keyStr.length() / 2f);
            for (int j = 0; j < leftPadding; j++) {
                System.out.print(" ");
            }

            System.out.print(keyStr);

            // Print the padding to the right side of the node
            int rightPadding = (int) Math.floor(nodeBoxLen / 2f - keyStr.length() / 2f);
            for (int j = 0; j < rightPadding; j++) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    private class Node {
        int key;

        public Node(int key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return Integer.toString(key);
        }
    }
}
