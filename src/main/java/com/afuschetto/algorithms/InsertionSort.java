package com.afuschetto.algorithms;

/*
 * The insertion sort algorithm sorts an array in the same way that a human
 * would sort a deck of playing cards. In every iteration of insertion sort,
 * the current element is moved into the sorted part of the array.
 *
 * Time complexity: O(n^2)
 * Auxiliary space: O(1)
 */
public class InsertionSort {
    private InsertionSort() {
    }

    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            // Move elements of array[0..i-1] that are greater than key to one
            // position ahead of their current position
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
