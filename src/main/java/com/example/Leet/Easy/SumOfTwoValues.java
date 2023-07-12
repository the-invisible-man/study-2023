package main.java.com.example.Leet.Easy;

import java.util.HashMap;

public class SumOfTwoValues {
    // Given an array of integers and a value, determine if
    // there are any two integers in the array whose sum is equal to the given value.

    public static void main(String[] args) {
        int[] haystack = new int[]{1, 2, 4, 4};

        int[] result = (hasSum(8, haystack));

        if (result[0] != result[1]) {
            System.out.println("Keys: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("Sum was not found");
        }
    }

    public static int[] hasSum(int needle, int[] haystack)
    {
        HashMap<Integer, Integer> counter = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < haystack.length; i++) {
            int current = haystack[i];

            if (counter.containsKey(current)) {
                result[0] = counter.get(current);
                result[1] = i;

                return result;
            }

            // For this current integer to add up to the value of needle
            // we need this other integer to be in the array
            int diff = needle - current;

            counter.put(diff, i);
        }

        return result;
    }
}
