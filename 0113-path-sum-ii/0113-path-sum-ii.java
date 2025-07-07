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
    /**
     * Recursively finds all root-to-leaf paths that sum to the target value.
     * Uses backtracking to explore all possible paths.
     * 
     * @param root Current node being processed
     * @param targetSum Remaining sum needed to reach target
     * @param currentPath Current path from root to current node
     * @param result List to store all valid paths
     */
    private void calculateSum(TreeNode root, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
        // Base case: if current node is null, return
        if(root == null) {
            return;
        }
        
        // Add current node's value to the path
        currentPath.add(root.val);
        
        // Check if we've reached a leaf node and the sum equals target
        if(root.left == null && root.right == null && root.val == targetSum) {
            // Create a new copy of the current path to avoid reference issues
            result.add(new ArrayList<>(currentPath));
        }
        
        // Recursively explore left and right subtrees with updated target sum
        calculateSum(root.left, targetSum - root.val, currentPath, result);
        calculateSum(root.right, targetSum - root.val, currentPath, result);
        
        // Backtrack: remove current node from path before returning
        currentPath.remove(currentPath.size() - 1);
    }
    
    /**
     * Finds all root-to-leaf paths where the sum of node values equals targetSum.
     * 
     * Time Complexity: O(N * H) where N is number of nodes and H is height
     * Space Complexity: O(H) for recursion stack and path storage
     * 
     * @param root Root of the binary tree
     * @param targetSum Target sum to find
     * @return List of all valid paths as lists of integers
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        calculateSum(root, targetSum, currentPath, result);
        return result;
    }
}