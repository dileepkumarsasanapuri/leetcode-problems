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
 */import java.util.*;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));  // Store (node, index)
        int maxWidth = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().index;  // Leftmost index of this level
            int first = 0, last = 0;
            
            for (int i = 0; i < size; i++) {
                Pair p = queue.poll();
                TreeNode node = p.node;
                int curIndex = p.index - minIndex;  // Normalize index to prevent overflow
                
                if (i == 0) first = curIndex;  // First node in the level
                if (i == size - 1) last = curIndex;  // Last node in the level
                
                if (node.left != null) queue.offer(new Pair(node.left, 2 * curIndex));
                if (node.right != null) queue.offer(new Pair(node.right, 2 * curIndex + 1));
            }
            
            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        
        return maxWidth;
    }
}

class Pair {
    TreeNode node;
    int index;
    
    Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}
