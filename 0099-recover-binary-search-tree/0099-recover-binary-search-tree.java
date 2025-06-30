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
    // Global variables to track the two nodes that need to be swapped
    TreeNode firstNode = null, secondNode = null;
    
    // Previous node in the inorder traversal - initialized with minimum value
    // to handle the edge case when the first node itself is out of place
    TreeNode prevNode = new TreeNode(Integer.MIN_VALUE);
    
    /**
     * Performs inorder traversal to identify the two nodes that are swapped
     * In a valid BST, inorder traversal should give nodes in ascending order
     * Any violation of this property indicates the swapped nodes
     */
    private void inOrder(TreeNode root) {
        // Base case: if current node is null, return
        if(root == null) {
            return;
        }
        
        // Traverse left subtree first (inorder: left -> root -> right)
        inOrder(root.left);
        
        // Process current node
        // Check if current node violates BST property (prevNode > currentNode)
        if(firstNode == null && prevNode.val > root.val) {
            // First violation found - mark the previous node as first misplaced node
            firstNode = prevNode;
        }
        
        // Check for second violation or update the second node
        if(firstNode != null && prevNode.val > root.val) {
            // Second violation found - mark current node as second misplaced node
            // This handles both cases:
            // 1. Two adjacent nodes swapped (only one violation)
            // 2. Two non-adjacent nodes swapped (two violations)
            secondNode = root;
        }
        
        // Update previous node for next iteration
        prevNode = root;
        
        // Traverse right subtree
        inOrder(root.right);
    }
    
    /**
     * Main function to recover the BST by swapping the values of two misplaced nodes
     * Uses inorder traversal to identify the nodes and then swaps their values
     */
    public void recoverTree(TreeNode root) {
        // Perform inorder traversal to identify the two misplaced nodes
        inOrder(root);
        
        // Swap the values of the two misplaced nodes to restore BST property
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }
}