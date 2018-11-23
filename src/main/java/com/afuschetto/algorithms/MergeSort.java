package com.afuschetto.algorithms;

/*
 * The merge sort algorithm works on the principle of divide and conquer. It
 * repeatedly break down the array into two subparts until each part consists
 * of a single element and merging those subparts in a manner that results into
 * a sorted array.
 *
 * Time complexity: O(n*log(n))
 * Auxiliary space: O(n)
 */
public class MergeSort {
    private MergeSort() {
    }

    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int fromIdx, int toIdx) {
        if (fromIdx >= toIdx) {
            return;
        }

        int midIdx = (fromIdx + toIdx) / 2;
        sort(array, fromIdx, midIdx);
        sort(array, midIdx + 1, toIdx);
        merge(array, fromIdx, midIdx, toIdx);
    }

    private static void merge(int[] array, int fromIdx, int midIdx, int toIdx) {
        int[] sortedArray = new int[toIdx - fromIdx + 1];

        int leftRangeIdx = fromIdx;
        int rightRangeIdx = midIdx + 1;
        int k = 0;

        // Traverse both ranges and in each iteration add smaller of both
        // elements in the sorted array
        while (leftRangeIdx <= midIdx && rightRangeIdx <= toIdx) {
            if (array[leftRangeIdx] < array[rightRangeIdx]) {
                sortedArray[k++] = array[leftRangeIdx++];
            } else {
                sortedArray[k++] = array[rightRangeIdx++];
            }
        }

        // Copy remaining elements of left range (if any) in the sorted array
        while (leftRangeIdx <= midIdx) {
            sortedArray[k++] = array[leftRangeIdx++];
        }

        // Copy remaining elements of right range (if any) in the sorted array
        while (rightRangeIdx <= toIdx) {
            sortedArray[k++] = array[rightRangeIdx++];
        }

        // Copy the ordered array into the appropriate slots of the input array
        for (int i = 0; i < sortedArray.length; i++) {
            array[fromIdx + i] = sortedArray[i];
        }
    }
}
