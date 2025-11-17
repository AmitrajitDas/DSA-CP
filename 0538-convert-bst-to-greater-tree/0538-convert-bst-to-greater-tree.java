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
    private int convert(TreeNode curr, int sum) {
        if(curr == null) return sum;
        
        // Process right subtree first (larger values)
        sum = convert(curr.right, sum);
        
        // Update current node
        curr.val += sum;
        sum = curr.val;
        
        // Process left subtree (smaller values)
        sum = convert(curr.left, sum);
        
        return sum;
    }
    public TreeNode convertBST(TreeNode root) {
        convert(root, 0);
        return root;
    }
}