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
    
     static void dfs(TreeNode root, List<Integer> preorder)
    {
        if(root == null) return;
        
        dfs(root.left, preorder);
        preorder.add(root.val);
        dfs(root.right, preorder);
        
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> preorder = new ArrayList<>();
        dfs(root, preorder);
        return preorder;
    }
}