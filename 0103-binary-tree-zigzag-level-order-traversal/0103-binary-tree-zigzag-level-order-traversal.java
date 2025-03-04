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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        boolean leftToRight = true;

        while (!deque.isEmpty()) {
            int n = deque.size();
            List<Integer> subLvl = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (leftToRight) {
                    TreeNode curNode = deque.pollFirst(); // Remove from front
                    subLvl.add(curNode.val);

                    // Add left first, then right
                    if (curNode.left != null) deque.addLast(curNode.left);
                    if (curNode.right != null) deque.addLast(curNode.right);
                } else {
                    TreeNode curNode = deque.pollLast(); // Remove from back
                    subLvl.add(curNode.val);

                    // Add right first, then left (reverse order)
                    if (curNode.right != null) deque.addFirst(curNode.right);
                    if (curNode.left != null) deque.addFirst(curNode.left);
                }
            }
            result.add(subLvl);
            leftToRight = !leftToRight; // Toggle flag for zigzag
        }
        return result;
    }
}
