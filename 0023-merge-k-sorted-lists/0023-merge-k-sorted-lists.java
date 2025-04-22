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
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                temp.next=l1;
                l1=l1.next;
            }
            else{
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        }
        if(l1!=null) temp.next=l1;
        else if(l2!=null) temp.next=l2;
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        return helper(lists,0,lists.length-1);
    }
    public ListNode helper(ListNode []lists,int left,int right){
        if(left==right) return lists[left];
        int mid=(left+right)/2;
        ListNode l1=helper(lists,left,mid);
        ListNode l2=helper(lists,mid+1,right);
       return merge(l1,l2);
    }
}