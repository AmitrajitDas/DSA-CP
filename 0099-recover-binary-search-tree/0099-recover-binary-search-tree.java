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
    TreeNode firstNode = null, secondNode = null;
    TreeNode prevNode = new TreeNode(Integer.MIN_VALUE);

    private void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);

        if(firstNode == null && prevNode.val > root.val) {
            firstNode = prevNode;
        }

        if(firstNode != null && prevNode.val > root.val) {
            secondNode = root;
        }

        prevNode = root;

        inOrder(root.right);
    } 
    public void recoverTree(TreeNode root) {
        inOrder(root);

        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }
}