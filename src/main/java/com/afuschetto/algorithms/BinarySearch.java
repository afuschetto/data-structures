package com.afuschetto.algorithms;

public class BinarySearch {
    private BinarySearch() {
    }

    public static int searchIteratively(int[] array, int key) {
        int fromIndex = 0;
        int toIndex = array.length - 1;

        while (fromIndex <= toIndex) {
            int middleIndex = (fromIndex + toIndex) / 2;

            if (array[middleIndex] > key) {
                toIndex = middleIndex - 1;
            } else if (array[middleIndex] < key) {
                fromIndex = middleIndex + 1;
            } else {
                return middleIndex;
            }
        }

        return -1;
    }

    public static int searchRecursively(int[] array, int key) {
        return searchRecursivelyInRange(array, key, 0, array.length - 1);
    }

    private static int searchRecursivelyInRange(int[] array, int key, int fromIndex, int toIndex) {
        if (fromIndex <= toIndex) {
            int middleIndex = (fromIndex + toIndex) / 2;

            if (array[middleIndex] > key) {
                return searchRecursivelyInRange(array, key, fromIndex, middleIndex - 1);
            } else if (array[middleIndex] < key) {
                return searchRecursivelyInRange(array, key, middleIndex + 1, toIndex);
            } else {
                return middleIndex;
            }
        }

        return -1;
    }
}
