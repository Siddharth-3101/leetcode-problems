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
    public int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next==null){
            return head;
        }
        ListNode curr=head;
        while(curr!=null && curr.next!=null){
            int n=gcd(curr.val,curr.next.val);
            ListNode temp=new ListNode(n);
            temp.next=curr.next;
            curr.next=temp;
            curr=curr.next.next;
        }
        return head;

    }
}