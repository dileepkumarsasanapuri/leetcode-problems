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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return max;
    }
    public int maxPathDown(TreeNode root){
        if(root==null) return 0;
        int lft=Math.max(0,maxPathDown(root.left));
        int rgt=Math.max(0,maxPathDown(root.right));
        max=Math.max(max,lft+rgt+root.val);
        return root.val+Math.max(lft,rgt);
    }
}