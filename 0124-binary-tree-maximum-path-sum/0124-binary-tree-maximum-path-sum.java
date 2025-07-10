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
    // Global variable to track the maximum path sum found so far
    int maxSum = Integer.MIN_VALUE;
    
    /**
     * Recursive helper function that calculates the maximum path sum
     * and returns the maximum sum that can be extended upward from this node
     * @param root - current node being processed
     * @return maximum sum that can be contributed to the parent node
     */
    private int calculateSum(TreeNode root) {
        // Base case: if node is null, it contributes 0 to any path
        if(root == null) return 0;
        
        // Calculate maximum sum from left subtree
        // Use Math.max(0, ...) to ignore negative contributions
        int leftSum = Math.max(0, calculateSum(root.left));
        
        // Calculate maximum sum from right subtree  
        // Use Math.max(0, ...) to ignore negative contributions
        int rightSum = Math.max(0, calculateSum(root.right));
        
        // Update global maximum considering current node as the "peak" of the path
        // This represents a path that goes: left subtree -> current node -> right subtree
        maxSum = Math.max(maxSum, root.val + leftSum + rightSum);
        
        // Return the maximum sum that can be extended upward to the parent
        // We can only choose one direction (left or right) to maintain a valid path
        return root.val + Math.max(leftSum, rightSum);
    }
    
    /**
     * Main function to find the maximum path sum in the binary tree
     * @param root - root of the binary tree
     * @return maximum sum of any path in the tree
     */
    public int maxPathSum(TreeNode root) {
        // Start the recursive calculation from the root
        calculateSum(root);
        
        // Return the maximum path sum found
        return maxSum;
    }
}