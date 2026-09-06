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
    public ListNode sortList(ListNode head) {
        //we are performing this similar to merge sort but just simply with linked list and two pointers (slow,fast)
        if(head==null||head.next==null){
            return head;
        }

        ListNode mid=getMid(head);
        //now we have to split the list 
        ListNode rightHead=mid.next;
        mid.next=null;//list is now seperated
        ListNode left=sortList(head);
        ListNode right=sortList(rightHead);

        return merge(left,right);
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode();
        ListNode tail = ans;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }

        while (list1 != null) {
            tail.next = list1;
            list1 = list1.next;
            tail = tail.next;
        }
        while (list2 != null) {
            tail.next = list2;
            list2 = list2.next;
            tail = tail.next;
        }
        return ans.next;
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
}