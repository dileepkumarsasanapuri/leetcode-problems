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
    public ListNode getKthNode(ListNode head,int k){
        ListNode temp=head;
        k--;
        while(temp!=null && k>0){
            temp=temp.next;
            k--;
        }
        return temp;
    }
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head,prevNode=null;;
        while(temp!=null){
            ListNode KthNode=getKthNode(temp,k);
            if(KthNode==null){
                if(prevNode!=null){
                    prevNode.next=temp;
                    break;
                }
            }
            ListNode nextNode=KthNode.next;
            KthNode.next=null;
            KthNode=reverse(temp);
            if(temp==head){
                head=KthNode;
            }
            else{
                prevNode.next=KthNode;
            }
            prevNode=temp;
            temp=nextNode;

        }
        return head;
    }
}