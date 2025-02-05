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
    static ListNode findKthNode(ListNode head,int k){
        int cnt=1;
        while(head!=null){
            if(cnt ==k) return head;
            cnt++;
            head=head.next;
        }
        return head;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0) return head;
        ListNode tail=head;
        int len=1;
        while(tail.next!=null){
           len++;
           tail=tail.next; 
        }
      
        if(k%len==0) return head;
        tail.next=head;
        k=k%len;
        ListNode newTail=findKthNode(head,len-k);
        head=newTail.next;
        newTail.next=null;
        return head;
    }
}