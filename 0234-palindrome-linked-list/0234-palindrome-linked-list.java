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
    static ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode newNode=reverse(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newNode;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode newHead=reverse(slow.next),first=head,second=newHead;
        while(second!=null){
            if(first.val!=second.val){
                reverse(newHead);
                return false;
            }
            first=first.next;
            second=second.next;
        }
        reverse(newHead);
        return true;
    }
}