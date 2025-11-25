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
    private int index = 0;
    
    private TreeNode buildBST(int[] preorder, int min, int max) {
        // Base case: reached end of array
        if (index >= preorder.length) return null;
        
        int val = preorder[index];
        
        // Current value is outside valid range for this subtree
        if (val < min || val > max) return null;
        
        // This value is valid, consume it
        index++;
        TreeNode root = new TreeNode(val);
        
        // Build left subtree (values must be < val)
        root.left = buildBST(preorder, min, val);
        
        // Build right subtree (values must be > val)
        root.right = buildBST(preorder, val, max);
        
        return root;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}