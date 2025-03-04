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
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)   return result;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> levelElements = new ArrayList<>();
            while (!stack1.isEmpty()) {
                TreeNode curr = stack1.pop();
                levelElements.add(curr.val);

                if (curr.left != null) {
                    stack2.push(curr.left);
                }

                if (curr.right != null) {
                    stack2.push(curr.right);
                }
            }

            if (levelElements.size() > 0)
                result.add(levelElements);
            List<Integer> levelElements1 = new ArrayList<>();

            while (!stack2.isEmpty()) {
                TreeNode curr = stack2.pop();
                levelElements1.add(curr.val);

                if (curr.right != null) {
                    stack1.push(curr.right);
                }

                if (curr.left != null) {
                    stack1.push(curr.left);
                }
            }

            if (levelElements1.size() > 0)
                result.add(levelElements1);
        }
        return result;
    }
}