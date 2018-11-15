package com.afuschetto.datastructures;

import java.util.NoSuchElementException;

public class BinaryTree<E> {
    private Node root = null;

    public void insert(int key, E value) {
        Node newNode = new Node(key, value);

        if (isEmpty()) {
            root = newNode;
        } else {
            // Navigate the tree until the proper leaf
            Node parentNode = null;
            Node currentNode = root;
            while (currentNode != null) {
                parentNode = currentNode;
                currentNode = (currentNode.key > key ? currentNode.left : currentNode.right);
            }

            // Place the new node as a child of the found left
            if (parentNode.key > key) {
                parentNode.left = newNode;
            } else {
                parentNode.right = newNode;
            }
        }
    }

    public E findMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty tree");
        }

        // Navigate the tree until the extreme left leaf (minimum key)
        Node currNode = root;
        while (currNode.left != null) {
            currNode = currNode.left;
        }

        return currNode.value;
    }

    public E findMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty tree");
        }

        // Navigate the tree until the extreme right leaf (maximum key)
        Node currNode = root;
        while (currNode.right != null) {
            currNode = currNode.right;
        }

        return currNode.value;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private class Node {
        int key;
        E value;
        Node left = null;
        Node right = null;

        public Node(int key, E value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
