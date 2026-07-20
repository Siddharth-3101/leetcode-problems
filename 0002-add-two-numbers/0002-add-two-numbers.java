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
        int carry=0;
        ListNode l3=new ListNode(0);
        ListNode l4=l3;
        int x=0;
        int y=0;
        while(l1!=null ||l2!=null || carry!=0){
            if(l1!=null){
                x=l1.val;
            }
            else{
                x=0;
            }
            if(l2!=null){
                y=l2.val;
            }
            else{
                y=0;
            }
            int sum=x+y+carry;
            carry=sum/10;
            l4.next=new ListNode(sum%10);
            l4=l4.next;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        return l3.next;
    }
}