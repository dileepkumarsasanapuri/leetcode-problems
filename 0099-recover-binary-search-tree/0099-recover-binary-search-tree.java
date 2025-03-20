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
    TreeNode first,last,middle,prev;
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        inorderHelper(root);
        if(first!=null && last!=null){
            int it=first.val;
            first.val=last.val;
            last.val=it;
        }
        else if(first!=null && middle!=null){
            int it=first.val;
            first.val=middle.val;
            middle.val=it;
        }
    }
    public void inorderHelper(TreeNode root){
        if(root==null) return;
        inorderHelper(root.left);
        if(prev!=null && root.val<prev.val){
            if(first==null){
                first=prev;
                middle=root;
            }
            else{
                last=root;
            }
        }
        prev=root;
        inorderHelper(root.right);
    }
}