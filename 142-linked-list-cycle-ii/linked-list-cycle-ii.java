/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null){
            return null;
        }
        int length = 0;
        ListNode fast = head;
        ListNode slow = head;
        boolean cycleFound=false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                cycleFound=true;
                ListNode temp = slow;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                break;
            }
        }
        if(!cycleFound){
            return null;
        }

        //now we have length let us move our first pointer towards the length of the cycle 
        ListNode f = head;
        ListNode s = head;

        while (length > 0) {
            s = s.next;
            length--;
        }

        //now we find the start of the cycle node
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return s;
    }
}