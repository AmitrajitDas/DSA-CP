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
    private int dfs(TreeNode root, int sum) {
        if(root == null) return 0;
        int newSum = sum * 10 + root.val;
        if(root.left == null && root.right == null) return newSum;
        return dfs(root.left, newSum) + dfs(root.right, newSum);
    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
}