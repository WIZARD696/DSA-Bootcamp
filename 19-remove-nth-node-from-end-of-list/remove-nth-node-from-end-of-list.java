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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode dummy=new ListNode(0);
       dummy.next=head;

       ListNode slow=dummy;
       ListNode fast=dummy;
        //this will keep the fast pointer always n steps ahead of slow 
       for(int i=0;i<n;i++){
        fast=fast.next;
       }
        //then at the end of this loop we will have fast at end and slow at just before the node to be deleted
       while(fast.next!=null){
        slow=slow.next;
        fast=fast.next;
       }
        //performning actual deletion
        slow.next=slow.next.next;

        return dummy.next;//as dummy is pointing to head

    }
}