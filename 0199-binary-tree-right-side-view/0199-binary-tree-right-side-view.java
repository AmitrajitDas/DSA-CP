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
    private void dfs(TreeNode root, int level, List<Integer> ds) {
        if(root == null) return;
        if(level == ds.size()) ds.add(root.val);
        dfs(root.right, level + 1, ds);
        dfs(root.left , level + 1, ds);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ds = new ArrayList<>();
        dfs(root, 0, ds);
        return ds;
    }
}