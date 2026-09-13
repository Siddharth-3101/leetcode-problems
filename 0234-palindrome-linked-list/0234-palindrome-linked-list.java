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
    public boolean isPalindrome(ListNode head) {
        ListNode cop=new ListNode(0);
        ListNode copy=cop;
        ListNode temp=head;
        while(temp!=null){
            copy.next=new ListNode(temp.val);
            copy=copy.next;
            temp=temp.next;
        }
        ListNode prev=null;
        while(cop!=null){
            ListNode next=cop.next;
            cop.next=prev;
            prev=cop;
            cop=next;
        }
        ListNode rev=prev;
        while(head!=null && rev!=null){
            if(head.val!=rev.val){
                return false;
            }
            head=head.next;
            rev=rev.next;
        }
        return true;
    }
}