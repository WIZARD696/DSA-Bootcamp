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
      public void reorderList(ListNode head) {
        if(head==null||head.next==null){
            return ;
        }
        ListNode mid=getMid(head);
        ListNode hs=inplaceReverse(mid);
        ListNode hf=head;

        while(hf!=null&&hs!=null){
            ListNode temp=hf.next;
            hf.next=hs;
            hf=temp;

            temp=hs.next;
            hs.next=hf;
            hs=temp;
        }
        if(hf!=null){
            hf.next=null;
        }
    }
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
}