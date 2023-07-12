package main.java.com.example.Leet.Medium;

// https://leetcode.com/problems/minimum-penalty-for-a-shop/
public class MinPenaltyForShop {
    public static void main(String[] args) {
        MinPenaltyForShop s = new MinPenaltyForShop();

        System.out.println(s.bestClosingTime("NNNN"));
    }
    public int bestClosingTime(String customers) {
        int[] table = new int[customers.length()];
        int minPenalty;
        int minPenaltyHour = 0;
        int currentPenalty;

        // This wasn't actually necessary. I misunderstood the expected outcome
        // and focused on finding the min penalty, but we're looking for the hour
        // that results in the min penalty.
        for (int i = 0; i < customers.length(); i++) {
            table[i] = customers.charAt(i) == 'Y' ? 1 : 0;
        }

        minPenalty = sumArray(table);
        currentPenalty = minPenalty;

        for (int i = 0; i < table.length; i++) {
            if (table[i] == 1) {
                currentPenalty -= 1;
            } else {
                currentPenalty += 1;
            }

            if (currentPenalty < minPenalty) {
                minPenalty = currentPenalty;
                minPenaltyHour = i + 1;
            }
        }

        return minPenaltyHour;
    }

    // 0th hour should be entered as -1
    public int sumArray(int[] arr) {
        int out = 0;

        for (int i = 0; i < arr.length; i++) {
            out += arr[i];
        }

        return out;
    }
}
