package com.gmail.ikaravai.sort;

public class BubbleSort {
    // O(n) = n^2
    // Swap adjacent (input.length - 1) number of times
    public int[] sort(int[] input) {
        for (int i = input.length - 1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (input[j] > input[j + 1]) {
                    this.swap(input, j, j + 1);
                }
            }
        }
        return input;
    }

    private void swap(int[] input, int i, int j) {
        input[i] = input[i] ^ input[j];
        input[j] = input[i] ^ input[j];
        input[i] = input[i] ^ input[j];
    }
}
