package com.afuschetto.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BinaryTree<E> {
    private Node root = null;

    public void insert(int key, E value) {
        Node newNode = new Node(key, value);

        if (isEmpty()) {
            root = newNode;
        } else {
            // Navigate the tree until the proper leaf
            Node parNode = null;
            Node currNode = root;
            while (currNode != null) {
                parNode = currNode;
                currNode = (currNode.key > key ? currNode.left : currNode.right);
            }

            // Place the new node as a child of the found left
            if (parNode.key > key) {
                parNode.left = newNode;
            } else {
                parNode.right = newNode;
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

        return (E) currNode.value;
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

        return (E) currNode.value;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void print() {
        // Build a list of keys grouped by levels. Every missing node is
        // represented by null to obtain a full binary tree.
        List<List<Integer>> levels = buildLevels(root);

        // Calculate the box length of a single node (which includes left side,
        // key, and right side)
        int widestKeyLen = getWidestKeyLen(root);
        widestKeyLen += (widestKeyLen % 2 == 0 ? 4 : 5); // Must be divisible by 2
        int nodeBoxLen = widestKeyLen * levels.get(levels.size() - 1).size();

        for (int i = 0; i < levels.size(); i++) {
            List<Integer> level = levels.get(i);

            printEdges(i, level, nodeBoxLen);
            printNodes(level, nodeBoxLen);

            nodeBoxLen /= 2;
        }
    }

    private static List<List<Integer>> buildLevels(Node root) {
        List<List<Integer>> levels = new ArrayList<>(); // Keys grouped by levels
        List<Node> currNodes = new ArrayList<>(); // Nodes of current level

        currNodes.add(root);
        int nNodes = 1; // Number of nodes to visit

        while (nNodes != 0) {
            nNodes = 0;

            List<Integer> level = new ArrayList<>(); // Keys of current level
            List<Node> nextNodes = new ArrayList<>(); // Nodes of next level

            for (Node node : currNodes) {
                if (node != null) {
                    // Add current node key
                    level.add(node.key);

                    nextNodes.add(node.left);
                    nextNodes.add(node.right);

                    if (node.left != null) {
                        nNodes++;
                    }
                    if (node.right != null) {
                        nNodes++;
                    }
                } else {
                    // Add missing node
                    level.add(null);

                    nextNodes.add(null);
                    nextNodes.add(null);
                }
            }

            levels.add(level);

            currNodes.clear();
            currNodes.addAll(nextNodes);
        }

        return levels;
    }

    private static int getWidestKeyLen(Node root) {
        if (root == null) {
            return 0;
        }

        int nDigits = String.valueOf(root.key).length();
        return Math.max(nDigits, Math.max(getWidestKeyLen(root.left), getWidestKeyLen(root.right)));
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

    private static class Node<E> {
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
