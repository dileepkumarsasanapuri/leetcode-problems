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
    int res=0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null || root.left==null && root.right==null) return 0;
        helper(root,false);
        return res;
    }
    public void helper(TreeNode root,boolean leftL){
        if(root==null) return;
        if(root.left==null && root.right==null && leftL){
            res+=root.val;
        }
        helper(root.left,true);
        helper(root.right,false);
    }
}