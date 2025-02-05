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
    static ListNode getKthNode(ListNode temp,int k){
        k=k-1;
        while(temp!=null && k>0){
            k--;
            temp=temp.next;
        }
        return temp;
    }
    static ListNode reverse(ListNode head){
        ListNode temp=head,prev=null;
        while(temp!=null){
            ListNode front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head, prevNode=null;
        while(temp!=null){
            ListNode kthNode=getKthNode(temp,k);
            if(kthNode==null){
                if(prevNode!=null) prevNode.next=temp;
                break;
            }
            ListNode nextnode=kthNode.next;
            kthNode.next=null;
           kthNode= reverse(temp);
            if(temp==head){
                head=kthNode;
            }
            else{
                prevNode.next=kthNode;
            }
            prevNode=temp;
            temp=nextnode;
        }
        return head;
        
    }
}