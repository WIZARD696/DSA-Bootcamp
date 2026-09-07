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
    public ListNode getMid(ListNode head){
        ListNode f=head;
        ListNode s=head;

        while(f.next!=null&&f.next.next!=null){
            f=f.next.next;
            s=s.next;
        }
        return s;
    }
    public ListNode inplaceReverse(ListNode head){
        if(head==null){
            return head; 
        }
        ListNode prev=null;
        ListNode present =head;
        ListNode next=present.next;

        while(present!=null){
            present.next=prev;
            prev=present;
            present=next;
            if(next!=null) {
                next = next.next;
            }
        }
        return prev;
    }
   public boolean isPalindrome(ListNode head) {
        ListNode mid=getMid(head);
        ListNode secondHead=inplaceReverse(mid);
        ListNode reReverse=secondHead;
        
        while(head!=null&&secondHead!=null){
            if(secondHead.val!=head.val){
                return false;
            }
            head=head.next;
            secondHead=secondHead.next;
        }
        if(head==null||secondHead==null){
            return true;
        }
        return false;

    }
}