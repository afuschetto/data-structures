package com.afuschetto.algorithms;

/*
 * The linear search algorithm searches key comparing it with each element of
 * the array.
 *
 * Time complexity: O(n)
 * Auxiliary space: O(1)
 */
public class LinearSearch {
    private LinearSearch() {
    }

    public static int search(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }

        return -1;
    }
}
