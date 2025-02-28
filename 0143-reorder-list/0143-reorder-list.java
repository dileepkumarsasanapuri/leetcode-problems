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
    public ListNode reverse(ListNode head){
        ListNode cur=head,prev=null;
        while(cur!=null){
            ListNode front=cur.next;
            cur.next=prev;
            prev=cur;
            cur=front;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode first=head;
        ListNode second=slow.next;
        slow.next=null;
        second=reverse(second);
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(first!=null && second!=null){
            temp.next=first;
            first=first.next;
            temp=temp.next;
            temp.next=second;
            second=second.next;
            temp=temp.next;
        }
        if(first!=null){
            temp.next=first;
        }
        else if(second!=null){
            temp.next=second;
        }
        head=dummy.next;
        
    }
}