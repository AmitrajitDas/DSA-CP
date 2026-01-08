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
    private long maxProduct = 0;
    private long totalSum = 0;
    private static final int MOD = 1_000_000_007;
    
    public int maxProduct(TreeNode root) {
        // Step 1: Calculate the total sum of all nodes
        totalSum = calculateSum(root);
        
        // Step 2: Find the maximum product by trying all possible splits
        calculateSubtreeSum(root);
        
        // Return the result modulo 10^9 + 7
        return (int) (maxProduct % MOD);
    }
    
    // Helper method to calculate the total sum of the tree
    private long calculateSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + calculateSum(node.left) + calculateSum(node.right);
    }
    
    // Helper method to calculate subtree sums and find maximum product
    private long calculateSubtreeSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        // Calculate sum of left and right subtrees
        long leftSum = calculateSubtreeSum(node.left);
        long rightSum = calculateSubtreeSum(node.right);
        
        // Current subtree sum
        long currentSubtreeSum = node.val + leftSum + rightSum;
        
        // If we split at this edge, one subtree has sum = currentSubtreeSum
        // and the other has sum = totalSum - currentSubtreeSum
        // Calculate the product and update maximum
        long product = currentSubtreeSum * (totalSum - currentSubtreeSum);
        maxProduct = Math.max(maxProduct, product);
        
        return currentSubtreeSum;
    }
}