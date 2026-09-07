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
       public ListNode reverseKGroup(ListNode head,int k){
        
        if(k<=1||head==null){
            return head;
        }

        ListNode present=head;
        ListNode prev=null;
        //let us skip the elements before left
        while(true) {
            ListNode last = prev;
            ListNode newEnd = present;
            ListNode next = present.next;
            if(!groupAvailable(newEnd,k)){
                break;
            }
            for (int i = 0; present != null && i < k; i++) {
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
            if(present==null){
                break;
            }
            prev=newEnd;

        }
        return head;
    }
    public boolean groupAvailable(ListNode start,int k){
        while(start!=null&&k>0){
            start=start.next;
            k--;
        }
        if(k>0){
            return false;
        }
        return true;
    }
}