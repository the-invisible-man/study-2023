package main.java.com.example.Leet.Medium;

public class KthLargestNumber {

    public static void main(String[] args) {
        int[] numbs = new int[]{4, 2, 1, 5, 6, 3};

        System.out.println(quickSelect(numbs, 0, numbs.length - 1, 2));
    }

    public static int quickSelect(int[] numbs, int start, int end, int k) {
        int lowerBound = start;
        int pivot = end;

        for (int j = start; j <= pivot - 1; j++) {
            if (numbs[j] < numbs[pivot]) {
                swap(numbs, lowerBound, j);
                lowerBound++;
            }
        }

        swap(numbs, lowerBound, pivot);

        if (lowerBound == (numbs.length - k)) {
            return numbs[pivot];
        }

        return lowerBound > (numbs.length - k) ? quickSelect(numbs, start, lowerBound - 1, k) : quickSelect(numbs, lowerBound + 1, end, k);
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
