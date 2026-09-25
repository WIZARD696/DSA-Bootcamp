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
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        while (curr != null) {
            if (curr.val == val) {
                if(curr==head){
                    head=head.next;
                }
                prev.next = curr.next;
                curr = curr.next;//current moves forward and prev stays where it is and the middle node is deleted 
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;

    }
}