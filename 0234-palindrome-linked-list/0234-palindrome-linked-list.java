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
        ArrayList<Integer> dumm=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            dumm.add(temp.val);
            temp=temp.next;
        }
        int left=0;
        int right=dumm.size()-1;
        while(left<=right){
            if(dumm.get(left)!=dumm.get(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}