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
    public boolean isEvenOddTree(TreeNode root) {
        // Queue for level-order traversal
        Queue<TreeNode> q = new LinkedList<>();
        // Add the root to the queue
        q.offer(root);
        // Flag to track whether the current level should have even or odd values
        boolean isEven = true;
        // Perform level-order traversal
        while (!q.isEmpty()) {
            // Initialize the previous value to be compared with current node's value
            int prev = isEven ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            // Get the size of the current level
            int size = q.size();
            // Process nodes at the current level
            while (size-- > 0) {
                // Get the current node from the queue
                TreeNode node = q.poll();
                // Check if the current node's value violates the even-odd pattern
                if ((isEven && (node.val % 2 == 0 || node.val <= prev)) ||
                    (!isEven && (node.val % 2 != 0 || node.val >= prev))) {
                    return false; // Violation found, return false
                }

                // Add the left child to the queue if exists
                if (node.left != null) {
                    q.offer(node.left);
                }
                // Add the right child to the queue if exists
                if (node.right != null) {
                    q.offer(node.right);
                }

                // Update the previous value for the next iteration
                prev = node.val;
            }
            // Toggle the flag for the next level
            isEven = !isEven;
        }
        // No violations found, return true
        return true;
    }
}