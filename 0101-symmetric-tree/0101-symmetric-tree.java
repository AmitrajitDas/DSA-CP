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
    private boolean checkSymmetry(TreeNode leftNode, TreeNode rightNode) {
        if(leftNode == null || rightNode == null) return leftNode == rightNode;
        if(leftNode.val != rightNode.val) return false;
        return checkSymmetry(leftNode.left, rightNode.right) && checkSymmetry(leftNode.right, rightNode.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return checkSymmetry(root.left, root.right);
    }
}