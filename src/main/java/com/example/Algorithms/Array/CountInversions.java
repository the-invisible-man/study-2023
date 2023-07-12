package main.java.com.example.Algorithms.Array;

public class CountInversions {
    public static void main(String[] args) {

    }

    public int[] countInversions(int[] input, int start, int end, int invC) {
        // Conquer
        if (start == end - 1) {
            int[] sorted = new int[2];

            if (input[start] > input[end]) {
                invC++;
                sorted[0] = input[end];
                sorted[1] = input[start];
            } else {
                sorted[0] = input[start];
                sorted[1] = input[end];
            }

            return sorted;
        }

        if (start == end) {
            int[] sorted = new int[1];
            sorted[0] = input[start];
            return sorted;
        }

        // Divide
        int mid = ((end - start) / 2) + start;
        int[] left = countInversions(input, start, mid, invC);
        int[] right = countInversions(input, mid + 1, end, invC);

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
                output[i] = right[rightCursor];
                rightCursor++;
            }
        }

        return output;
    }
}
