package Algorithms;

import java.util.HashMap;
import java.util.Stack;

public class ValidPalindrome {
    public static void main(String[] args) {
        if (isValidPalindrome(" ")) {
            System.out.println("Valid");
        }
    }

    public static boolean isValidPalindrome(String s) {
        Stack<Character> str = new Stack<>();

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        for (char c: s.toCharArray()) {
            str.add(c);
        }

        for (char c: s.toCharArray()) {
            if (c != str.pop()) {
                return false;
            }
        }

        return str.size() == 0;
    }
}
