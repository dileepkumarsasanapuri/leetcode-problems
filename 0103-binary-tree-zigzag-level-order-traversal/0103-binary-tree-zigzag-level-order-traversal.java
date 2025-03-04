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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root == null )return result;
        Queue<TreeNode> Q=new LinkedList<>();
        Q.add(root); 
        boolean leftToright=true;
        while(!Q.isEmpty()){
            int n=Q.size();
            List<Integer> subLvl=new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode curNode=Q.poll();
                subLvl.add(curNode.val);
                if(curNode.left!=null){
                        Q.add(curNode.left);
                }
                if(curNode.right!=null){
                    Q.add(curNode.right);
                }
            }
            if(leftToright==false){
                    Collections.reverse(subLvl);
                }
               result.add(subLvl);
               leftToright=!leftToright;
            }
              return result;
        }
      
    }
