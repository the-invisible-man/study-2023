package main.java.com.example.Algorithms;

import java.util.concurrent.atomic.AtomicInteger;

public class MergeSort {
    public static void main(String[] args) {
        int[] input = {10, 3, 5, 3, 7, 7, 34, -7, 20, 0, -234, 4, 1, 2};
        int[] output;
        AtomicInteger inversions = new AtomicInteger(0);

        output = mergeSort(input, 0, input.length - 1, inversions);

        for (int i: output) {
            System.out.println(i);
        }

        System.out.println("Total inversions " + inversions.get());
    }

    public static int[] mergeSort(int[] input, int start, int end) {
        return mergeSort(input, start, end, null);
    }

    public static int[] mergeSort(int[] input, int start, int end, AtomicInteger inversionCounter) {
        if (start == end) {
            int[] sorted = new int[1];
            sorted[0] = input[start];
            return sorted;
        }

        // Divide
        int mid = ((end - start) / 2) + start;
        int[] left = mergeSort(input, start, mid, inversionCounter);
        int[] right = mergeSort(input, mid + 1, end, inversionCounter);

        int outputSize = left.length + right.length;
        int[] output = new int[outputSize];
        int leftCursor = 0;
        int rightCursor = 0;

        // Merge
        for (int i = 0; i < outputSize; i++) {
            if (leftCursor < left.length && (rightCursor == right.length || left[leftCursor] < right[rightCursor])) {
                output[i] = left[leftCursor];
                leftCursor++;
            } else {
                if (leftCursor < left.length && inversionCounter != null) {
                    // By virtue of copying from the right subarray while still
                    // having items in the left subarray, we can infer split inversions
                    // as the number of items left to copy from the left subarray.
                    inversionCounter.set(inversionCounter.get() + left.length - leftCursor);
                }
                output[i] = right[rightCursor];
                rightCursor++;
            }
        }

        return output;
    }
}
