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
    private int calcSum(TreeNode root) {
        if(root == null) return 0;
        int leftSum = Math.max(0, calcSum(root.left));
        int rightSum = Math.max(0, calcSum(root.right));

        maxSum = Math.max(maxSum, root.val + leftSum + rightSum);
        System.out.println("maxSum: " + maxSum); 
        System.out.println("return val: " + (root.val + Math.max(leftSum, rightSum)));
        return root.val + Math.max(leftSum, rightSum);
    }

    public int maxPathSum(TreeNode root) {
        calcSum(root);
        return maxSum;
    }
}