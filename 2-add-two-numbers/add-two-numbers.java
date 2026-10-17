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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1);//this is a simple list created for answers
        ListNode current=dummy;//this will take us to the end of the list;
        int carry=0;
        while(l1!=null||l2!=null||carry!=0){
            int sum=carry;//store the carry in the sum first
            if(l1!=null){
                sum+=l1.val;
            }
            if(l2!=null){
                sum+=l2.val;
            }
            //updating the digit to be stored in the new list and updating the carry
            int digit =sum%10;
            carry=sum/10;

            current.next=new ListNode(digit);//this creates a new node at the end of dummy Linked list
            current=current.next;//now we move current forward
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        return dummy.next;//we return next because dummy points to the -1 value node before head we can say
    }
}