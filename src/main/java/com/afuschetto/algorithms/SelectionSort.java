package com.afuschetto.algorithms;

public class SelectionSort {
    private SelectionSort() {
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            int tmpVal = array[i];
            array[i] = array[minIdx];
            array[minIdx] = tmpVal;
        }
    }
}
