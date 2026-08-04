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
    // Tracks the global maximum path sum across all evaluated nodes
    int maxSum = Integer.MIN_VALUE;
    
    private int recurse(TreeNode root) {
        // Base case: an empty subtree contributes 0 to the sum
        if(root == null) return 0;

        // Recursively calculate the max path sum from left and right subtrees.
        // Math.max(0, ...) ignores negative subtree sums (treating them as 0).
        int leftVal = Math.max(0, recurse(root.left));
        int rightVal = Math.max(0, recurse(root.right));

        // Calculate maximum sum of a path where 'root' is the highest peak (combining left + root + right)
        int currSum = root.val + leftVal + rightVal;

        // Update global max sum if this current local path is the largest found so far
        maxSum = Math.max(currSum, maxSum);

        // Return max path sum extending to parent node (can only pick the single best branch)
        return root.val + Math.max(leftVal, rightVal);
    }

    public int maxPathSum(TreeNode root) {
        recurse(root);
        return maxSum;
    }
}