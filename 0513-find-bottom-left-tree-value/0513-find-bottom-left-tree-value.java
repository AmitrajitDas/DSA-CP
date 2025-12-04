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
    private int maxDepth = -1, res = 0;
    private void dfs(TreeNode root, int depth) {
        if(root == null) return;
        dfs(root.left, depth + 1);
        if(depth > maxDepth) {
            maxDepth = depth;
            res = root.val;
        }
        dfs(root.right, depth + 1);
    }
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return res;
    }
}