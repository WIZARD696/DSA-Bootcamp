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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        ListNode dummy=new ListNode();//or you can write it as ListNode dummy=new ListNode(0,head) where 0 denotes the value and head denotes the next node of dummy
        dummy.next=head;
        ListNode curr=dummy;
        while(curr.next!=null){
            if(set.contains(curr.next.val)){
                curr.next=curr.next.next;
            }
            else{
                curr=curr.next;
            }
        }
        return dummy.next;
    }
}