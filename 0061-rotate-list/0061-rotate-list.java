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
    public ListNode KthNode(ListNode head,int k){
        k--;
        while(head!=null && k>0){
            head=head.next;
            k--;
        }
        return head;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k<=0) return head;
        ListNode tail=head;
        int len=1;
        while(tail.next!=null){
            tail=tail.next;
            len++;
        }
        k=k%len;
        if(k==0) return head;
        ListNode newTail=KthNode(head,k);
        tail.next=head;
        head=newTail.next;
        newTail.next=null;
        return head;
    }
}