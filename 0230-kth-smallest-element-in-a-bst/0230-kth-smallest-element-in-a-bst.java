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
    List<Integer> ds = new ArrayList<>();
    private void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.left);
        ds.add(root.val);
        dfs(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        return ds.get(k - 1);
    }
}