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
    public int maxLevelSum(TreeNode root) {
      
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int maxSum=Integer.MIN_VALUE;
        int maxLvl=1;
        int lvl=1;
        while(!q.isEmpty()){
            int curSum=0;
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode cur=q.poll();
                curSum+=cur.val;
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
            }
           if(curSum>maxSum){
            maxSum=curSum;
            maxLvl=lvl;            
           }
           lvl++;
        }
        return maxLvl;
    }

}