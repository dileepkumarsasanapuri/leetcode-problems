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
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int level=0;
        Queue<TreeNode> Q=new LinkedList<>();
        Q.add(root);
        while(!Q.isEmpty()){
            int n=Q.size();
            
            for(int i=0;i<n;i++){
                root=Q.poll();
                if(root.left!=null){
                    Q.add(root.left);
                }
                if(root.right!=null){
                    Q.add(root.right);
                }
            }
            level++;
        }
        return level;
    }
}