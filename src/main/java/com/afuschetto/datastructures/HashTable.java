package com.afuschetto.datastructures;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * A hash table (or hash map) is a data structure used to implement an
 * associative array, a structure that can map keys to values. It uses a hash
 * function to compute an index into an array of slots (or buckets), from which
 * the value can be stored. Potential collisions can be resolved using the
 * open-addressing (linear or quadratic probing) or the chaining technique
 * (linked list).
 *
 * Time complexity:
 *  - Insert: O(1) in average case, O(n) in worst case
 *  - Delete: O(1) in average case, O(n) in worst case
 *  - Search: O(1) in average case, O(n) in worst case
 */
public class HashTable {
    private String[] table;
    private int size = 0;

    public HashTable(int initialCapacity) {
        table = (isPrime(initialCapacity) ? new String[initialCapacity] : new String[getNextPrime(initialCapacity)]);
    }

    private static boolean isPrime(int value) {
        for (int i = 2; i * i <= value; i++) {
            if (value % 2 == 0) {
                return false;
            }
        }

        return true;
    }

    private static int getNextPrime(int value) {
        for (int i = value + 1; true; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
    }

    public void insert(String item) {
        int hashCode = hash1(item);
        int stepSize = hash2(item);

        while (table[hashCode] != null) {
            hashCode += stepSize;
            hashCode %= table.length;
        }

        table[hashCode] = item;

        if (++size == table.length) {
            resize(table.length * 2);
        }
    }

    public boolean find(String item) {
        if (isEmpty()) {
            return false;
        }

        int hashCode = hash1(item);
        int stepSize = hash2(item);

        while (table[hashCode] != null) {
            if (table[hashCode].equals(item)) {
                return true;
            }

            hashCode += stepSize;
            hashCode %= table.length;
        }

        return false;
    }

    private void resize(int newCapacity) {
        HashTable newHashTable = new HashTable(newCapacity);
        for (int i = 0; i < size; i++) {
            newHashTable.insert(table[i]);
        }

        table = newHashTable.table;
    }

    private int hash1(String item) {
        int code = item.hashCode() % table.length;
        if (code < 0) {
            code += table.length;
        }

        return code;
    }

    private int hash2(String item) {
        int code = hash1(item);
        return 3 - code % 3;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        System.out.print("[");
        System.out.print(Arrays.stream(table).filter(x -> x != null).collect(Collectors.joining(", ")));
        System.out.println("]");
    }
}
