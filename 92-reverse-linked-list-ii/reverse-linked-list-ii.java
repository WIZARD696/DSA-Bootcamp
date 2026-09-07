/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return head;
        }
        if (left == right) {
            return head;
        }

        ListNode present = head;
        ListNode prev = null;
        //let us skip the elements before left
        for (int i = 0; present != null && i < left - 1; i++) {
            prev = present;
            present = present.next;
        }
        ListNode last = prev;
        ListNode newEnd = present;
        ListNode next = present.next;
        for (int i = 0; present != null && i < right - left + 1; i++) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }
        newEnd.next = present;
        return head;
    }
}