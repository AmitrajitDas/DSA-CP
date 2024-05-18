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
    private int moves = 0;
    private int dfs(TreeNode root) {
        if(root == null) return 0;
        int leftDeficiency = dfs(root.left);
        int rightDeficiency = dfs(root.right);
        moves += Math.abs(leftDeficiency) + Math.abs(rightDeficiency);
        return root.val - 1 + leftDeficiency + rightDeficiency;
    }
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }
}