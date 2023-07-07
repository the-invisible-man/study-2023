package Leet.Easy;

public class MergeTwoLists {
    // You are given the heads of two sorted linked lists list1 and list2.
    // Merge the two lists in a one sorted list. The list should be made
    // by splicing together the nodes of the first two lists.
    // Return the head of the merged linked list.
    // LC: https://leetcode.com/problems/merge-two-sorted-lists/

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode tail = null;

        while ((list1 != null || list2 != null)) {
            ListNode current = new ListNode();

            if (list1 == null) {
                current.val = list2.val;
                list2 = list2.next;
            } else if (list2 == null) {
                current.val = list1.val;
                list1 = list1.next;
            } else {
                if (list1.val < list2.val) {
                    current.val = list1.val;
                    list1 = list1.next;
                } else {
                    current.val = list2.val;
                    list2 = list2.next;
                }
            }

            if (head == null) {
                head = current;
                tail = head;
            } else {
                tail.next = current;
                tail = current;
            }
        }

        return head;
    }
}

class ListNode {

    public int val;

    public ListNode next = null;
}
