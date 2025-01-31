package com.gmail.ikaravai.sort;

import java.util.Random;

public class QuickSort {
    // O(n) = n log n on average, n^2 - worst case
    // partition (choose pivot and place lower values before it, higher - after it) ->
    // split array around pivot ->
    // repeat recursively for parts of array around pivot
    public int[] sort(int[] input, int firstIndex, int lastIndex) {
        if (firstIndex >= lastIndex) {
            return input;
        }

        int pivotIndex = partition(input, firstIndex, lastIndex);

        this.sort(input, firstIndex, pivotIndex - 1);
        this.sort(input, pivotIndex + 1, lastIndex);

        return input;
    }

    private int partition(int[] input, int firstIndex, int lastIndex) {
        // to flatten complexity closer to average
        this.randomizePivot(input, firstIndex, lastIndex);
        int pivot = input[lastIndex];

        int i = firstIndex - 1;
        for (int j = firstIndex; j < lastIndex; j++) {
            if (input[j] < pivot) {
                i++;
                swap(input, i, j);
            }
        }

        swap(input, i + 1, lastIndex);
        return i + 1;
    }

    private void randomizePivot(int[] input, int firstIndex, int lastIndex) {
        // random index for average n log n
        int pivotIndex = new Random().nextInt(lastIndex - firstIndex) + firstIndex;
        // moving pivot element to the end
        this.swap(input, pivotIndex, lastIndex);
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
