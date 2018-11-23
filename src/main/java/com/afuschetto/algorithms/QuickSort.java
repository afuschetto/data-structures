package com.afuschetto.algorithms;

/*
 * The quick sort algorithm works on the principle of divide and conquer. It
 * picks an element as pivot and partitions the given array around the picked
 * pivot (placing all smaller elements to left of pivot and all greater ones to
 * right of pivot). The algorithm then recursively sorts the two subparts.
 *
 * Time complexity: O(n*log(n))
 * Auxiliary space: O(1)
 */
public class QuickSort {
    private QuickSort() {
    }

    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int fromIdx, int toIdx) {
        if (fromIdx >= toIdx) {
            return;
        }

        // Calculate the partitioning index
        int pIdx = partition(array, fromIdx, toIdx);

        sort(array, fromIdx, pIdx - 1);
        sort(array, pIdx + 1, toIdx);
    }

    // Takes last element as pivot, places the pivot element at its correct
    // position in sorted array, and places all smaller elements (smaller than
    // pivot) to left of pivot and all greater ones to right of pivot.
    private static int partition(int[] array, int fromIdx, int toIdx) {
        // The pivot is the element to be placed at correct position
        int pivot = array[toIdx];

        int i = fromIdx - 1;
        for (int j = fromIdx; j < toIdx; j++) {

            // If the current element is smaller than or equal to the pivot
            if (array[j] <= pivot) {
                i++;

                int tmpVal = array[i];
                array[i] = array[j];
                array[j] = tmpVal;
            }
        }

        // Put the pivot in the correct position
        int tmpVal = array[i + 1];
        array[i + 1] = pivot;
        array[toIdx] = tmpVal;

        return i + 1;
    }
}
