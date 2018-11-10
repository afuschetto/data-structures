package com.afuschetto.algorithms;

/*
 * Given an ordered array, the binary search algorithm searches key by
 * repeatedly dividing the search interval in half. If key is less than the
 * element in the middle of the interval, the algorithm restrict the search
 * interval to the lower half. Otherwise it narrows the search interval to the
 * upper half. The algorithm checks repeatedly until key is found or the
 * interval is empty.
 *
 * Time complexity: O(log(n))
 * Auxiliary space: O(1) the iterative implementation, O(log(n)) the recursive
 *                  implementation (call stack space)
 */
public class BinarySearch {
    private BinarySearch() {
    }

    public static int searchIteratively(int[] array, int key) {
        int fromIdx = 0;
        int toIdx = array.length - 1;

        while (fromIdx <= toIdx) {
            int middleIdx = (fromIdx + toIdx) / 2;

            if (array[middleIdx] > key) {
                toIdx = middleIdx - 1;
            } else if (array[middleIdx] < key) {
                fromIdx = middleIdx + 1;
            } else {
                return middleIdx;
            }
        }

        return -1;
    }

    public static int searchRecursively(int[] array, int key) {
        return searchRangeRecursively(array, key, 0, array.length - 1);
    }

    private static int searchRangeRecursively(int[] array, int key, int fromIdx, int toIdx) {
        if (fromIdx > toIdx) {
            return -1;
        }

        int midIdx = (fromIdx + toIdx) / 2;
        if (array[midIdx] > key) {
            return searchRangeRecursively(array, key, fromIdx, midIdx - 1);
        } else if (array[midIdx] < key) {
            return searchRangeRecursively(array, key, midIdx + 1, toIdx);
        } else {
            return midIdx;
        }
    }
}
