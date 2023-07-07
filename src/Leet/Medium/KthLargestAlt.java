package Leet.Medium;

import java.util.Random;

public class KthLargestAlt {
    public static void main(String[] args){
        int[] numbs = new int[]{4, 2, 1, 5, 6, 3};

        KthLargestAlt i = new KthLargestAlt();

        System.out.println(i.kthLargest(numbs, 2));
    }
    public int kthLargest(int[] arr, int k) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;

        Random rand = new Random(0);

        while (left <= right) {
            int chosenPivotIndex = rand.nextInt(right - left + 1) + left;

            int finalIndexOfChosenPivot = partition(arr, left, right, chosenPivotIndex);

            // What does the 'finalIndexOfChosenPivot' tell us?
            if (finalIndexOfChosenPivot == n - k) {
                /*
                 * Found. The pivot is index on index n - k. This is literally its final
                 * position if the array we were given had been sorted. See how we saved work?
                 * We don't need to sort the whole array
                 */
                return arr[finalIndexOfChosenPivot];
            } else if (finalIndexOfChosenPivot > n - k) {
                /*
                 * k'th largest must be in the left partition. We "overshot" and need to go left
                 * (and we do this by narrowing the right bound)
                 */
                right = finalIndexOfChosenPivot - 1;
            } else {
                /*
                 * finalIndexOfChoosenPivot < n - k
                 *
                 * k'th largest must be in the right partition. We "undershot" and need to go
                 * right (and we do this by narrowing the left bound)
                 */
                left = finalIndexOfChosenPivot + 1;
            }
        }

        return -1;
    }

    private int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        int lesserItemsTailIndex = left;

        /*
         * Move the item at the 'pivotIndex' OUT OF THE WAY. We are about to bulldoze
         * through the partitioning space and we don't want it in the way
         */
        swap(arr, pivotIndex, right);

        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, i, lesserItemsTailIndex);
                lesserItemsTailIndex++;
            }
        }

        /*
         * Ok...partitioning is done. Swap the pivot item BACK into the space we just
         * partitioned at the 'lesserItemsTailIndex'...that's where the pivot item
         * belongs
         *
         * In the middle of the "sandwich".
         */
        swap(arr, right, lesserItemsTailIndex);

        return lesserItemsTailIndex;
    }

    private void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
