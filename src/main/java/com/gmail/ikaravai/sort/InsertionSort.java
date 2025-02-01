package com.gmail.ikaravai.sort;

public class InsertionSort {
    // O(n) = n log n on average, n^2 - worst case
    // Left to right iteratively pick the next element
    // and put it into the tight position among elements
    // to the left of the cursor
    // using binary search to get to n log n in best case
    public int[] sort(int[] input) {
        var length = input.length;
        for (int i = 1; i < length; i++) {
            var currentValue = input[i];
            var position = this.binarySearch(input, currentValue, i - 1);

            this.shiftElementsToRight(input, i, position);
            input[position] = currentValue;
        }

        return input;
    }

    private void shiftElementsToRight(int[] input, int currentIndex, int targetIndex) {
        while (currentIndex > targetIndex) {
            input[currentIndex] = input[currentIndex - 1];
            currentIndex--;
        }
    }

    // finds index where item before are <= and after are >=
    private int binarySearch(int[] input, int currentItem, int endIndex) {
        var startIndex = 0;
        while (startIndex <= endIndex) {
            var midIndex = startIndex + (endIndex - startIndex) / 2;
            if (input[midIndex] == currentItem) {
                return midIndex + 1;
            } else if (input[midIndex] < currentItem) {
                startIndex = midIndex + 1;
            } else if (input[midIndex] > currentItem) {
                endIndex = midIndex - 1;
            }
        }

        return startIndex;
    }
}
