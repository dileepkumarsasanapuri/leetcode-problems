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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         Map<Integer,Integer> inMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
       TreeNode root=buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1,inMap);
       return root; 
    }
    public TreeNode buildTree(int []inorder,int inSt,int inEnd,int[] postorder,int pSt,int pEnd,Map<Integer,Integer> inMap){
        if(pSt>pEnd || inSt>inEnd) return null;
        TreeNode root=new TreeNode(postorder[pEnd]);
        int inRoot=inMap.get(root.val);
        int numsleft=inRoot-inSt;
        root.left=buildTree(inorder,inSt,inRoot-1,postorder,pSt,pSt+numsleft-1,inMap);
        root.right=buildTree(inorder,inRoot+1,inEnd,postorder,pSt+numsleft,pEnd-1,inMap);
        return root;
    }
}