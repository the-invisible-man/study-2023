package main.java.com.example.Leet.Easy;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] map = new int[58];
        int len = 0;

        for (char c: s.toCharArray()) {
            map[c-'A']++;
        }

        

        return len;
    }
}
