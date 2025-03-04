/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sol=0;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return sol;
    }
    public void helper(TreeNode root,int cur){
        if(root==null){
            return;
        }
        cur=cur*10+root.val;
        if(root.left==null && root.right==null){
            sol+=cur;
            return;
        }
        helper(root.left,cur);
        helper(root.right,cur);
    }
}