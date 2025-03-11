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
  class Pair{
    TreeNode root;
    int n;
    Pair(TreeNode root,int n){
        this.root=root;
        this.n=n;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int ans=0;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            int min=q.peek().n;
            int first=0,last=0;
            for(int i=0;i<size;i++){
                Pair p=q.poll();
                TreeNode node=p.root;
                int curInd=p.n-min;
                if(i==0 )first=curInd;
                if(i==size-1) last=curInd;
                if(node.left!=null) q.offer(new Pair(node.left,2*curInd));
                if(node.right!=null) q.offer(new Pair(node.right,2*curInd+1 ));

            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}