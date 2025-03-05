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
   
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode> Q=new Stack<>();
        Q.push(root);
        while(!Q.isEmpty()){
            root=Q.pop();
            ans.add(root.val);
            if(root.right!=null)
            Q.push(root.right);
            if(root.left!=null)
            Q.push(root.left);
        }
        return ans;
    }
}