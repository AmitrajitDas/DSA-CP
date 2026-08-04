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
    int maxSum = Integer.MIN_VALUE;
    
    private int recurse(TreeNode root) {
        if(root == null) return 0;

        int leftVal = Math.max(0, recurse(root.left));
        int rightVal = Math.max(0, recurse(root.right));
        int currSum = root.val + leftVal + rightVal;
        maxSum = Math.max(currSum, maxSum);
        return root.val + Math.max(leftVal, rightVal);
    }

    public int maxPathSum(TreeNode root) {
        recurse(root);
        return maxSum;
    }
}