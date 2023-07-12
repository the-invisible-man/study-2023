package main.java.com.example.Leet.Medium;

import main.java.com.example.DataStructures.LinkedList.ListNode;

import java.util.*;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1Digits = new Stack<>();
        Stack<Integer> l2Digits = new Stack<>();

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                l1Digits.add(l1.val);
                l1 = l1.next;
            }

            if (l2 != null) {
                l2Digits.add(l2.val);
                l2 = l2.next;
            }
        }

        int carry = 0;
        int currSum;
        int[] result = new int[Math.max(l1Digits.size(), l2Digits.size()) + 1];
        int count = 0;

        while (!l2Digits.isEmpty() || !l1Digits.isEmpty()) {
            currSum = (l1Digits.isEmpty() ? 0 : l1Digits.pop()) + (l2Digits.isEmpty() ? 0 : l2Digits.pop()) + carry;

            if (currSum > 10) {
                // We need to carry
                carry = 1;
                currSum = currSum - 10;
            } else {
                carry = 0;
            }

            result[count] = currSum;
            count++;
        }

        if (carry == 1) {
            result[result.length - 1] = 1;
        }

        ListNode tail = null;

        for (int i = result.length - 1; i >= 0; i--) {
            if (tail == null) {
                tail = new ListNode();
            } else {
                tail.next = new ListNode();
                tail = tail.next;
            }

            tail.val = result[i];
        }

        return tail;
    }
}
