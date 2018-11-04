package com.afuschetto.algorithms;

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
        return searchRecursivelyInRange(array, key, 0, array.length - 1);
    }

    private static int searchRecursivelyInRange(int[] array, int key, int fromIdx, int toIdx) {
        if (fromIdx <= toIdx) {
            int middleIdx = (fromIdx + toIdx) / 2;

            if (array[middleIdx] > key) {
                return searchRecursivelyInRange(array, key, fromIdx, middleIdx - 1);
            } else if (array[middleIdx] < key) {
                return searchRecursivelyInRange(array, key, middleIdx + 1, toIdx);
            } else {
                return middleIdx;
            }
        }

        return -1;
    }
}
