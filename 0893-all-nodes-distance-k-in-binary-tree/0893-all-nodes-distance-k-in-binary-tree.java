/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    private void markParents(TreeNode root,Map<TreeNode,TreeNode> map){
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            if(cur.left!=null){ 
            map.put(cur.left,cur);
            q.offer(cur.left);
            }
            if(cur.right!=null){
                map.put(cur.right,cur);
                q.offer(cur.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
      Map<TreeNode,TreeNode> parent=new HashMap<>();
      markParents(root,parent);
      Map<TreeNode,Boolean> visited=new HashMap<>();
      Queue<TreeNode> q=new LinkedList<TreeNode>();
      q.offer(target);
      visited.put(target,true);
      int cur_lvl=0;
      while(!q.isEmpty()){
        if(cur_lvl==k) break;
        int size=q.size();
        cur_lvl++;
        for(int i=0;i<size;i++){
            TreeNode cur=q.poll();
            if(cur.left!=null && visited.get(cur.left)==null){
                q.offer(cur.left);
                visited.put(cur.left,true);
            }
            if(cur.right!=null && visited.get(cur.right)==null){
                q.offer(cur.right);
                visited.put(cur.right,true);
            }
            if(parent.get(cur)!=null && visited.get(parent.get(cur))==null){
                q.offer(parent.get(cur));
                visited.put(parent.get(cur),true);
            }

        }
      }
      List<Integer> res=new ArrayList<>();
      while(!q.isEmpty()){
        res.add(q.poll().val);
      }
      return res;
    }
}