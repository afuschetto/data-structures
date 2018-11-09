package com.afuschetto.algorithms;

/*
 * The selection sort algorithm sorts an array by repeatedly finding the
 * minimum element from unsorted part and putting it at the beginning.
 * In every iteration of selection sort, the minimum element from the unsorted
 * part (right side) is picked and moved to the sorted part (left side).
 *
 * Time complexity: O(n^2)
 * Auxiliary space: O(1)
 */
public class SelectionSort {
    private SelectionSort() {
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            // Find the minimum element in the array
            int minIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }

            // Swap the found minimum element with the current element
            int tmpVal = array[i];
            array[i] = array[minIdx];
            array[minIdx] = tmpVal;
        }
    }
}
