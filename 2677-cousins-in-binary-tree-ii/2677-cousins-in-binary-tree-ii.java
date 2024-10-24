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
    
    // Depth-First Search (DFS) to traverse each level and replace the value of each node
    private void dfs(TreeNode[] arr) {
        // Base case: if the array of nodes is empty, return (no more nodes to process)
        if (arr.length == 0) return;

        // Step 1: Calculate the total sum of all child nodes of the current level
        int sum = 0;
        for (TreeNode node : arr) {
            if (node == null) continue;  // Skip null nodes
            if (node.left != null) sum += node.left.val;  // Add left child value
            if (node.right != null) sum += node.right.val; // Add right child value
        }

        // Step 2: Prepare the array for the next level's child nodes
        TreeNode[] childArr = new TreeNode[arr.length * 2];  // Each node can have up to 2 children
        int index = 0;  // Index to track the position in childArr

        // Step 3: Iterate through each node of the current level
        for (TreeNode node : arr) {
            int curSum = 0;  // Store the sum of the node's children (sibling sum)

            // Calculate the current node's children's sum (left + right children)
            if (node.left != null) curSum += node.left.val;
            if (node.right != null) curSum += node.right.val;

            // Update the value of the left child (if exists) with the sum of cousins
            if (node.left != null) {
                node.left.val = sum - curSum;  // Cousins' sum = total child sum - sibling sum
                childArr[index++] = node.left;  // Add left child to the childArr for the next level
            }

            // Update the value of the right child (if exists) with the sum of cousins
            if (node.right != null) {
                node.right.val = sum - curSum;  // Cousins' sum = total child sum - sibling sum
                childArr[index++] = node.right;  // Add right child to the childArr for the next level
            }
        }

        // Recursive call to process the next level (children of the current level)
        // We use Arrays.copyOf to trim childArr to its actual size (since not all slots might be filled)
        dfs(java.util.Arrays.copyOf(childArr, index));
    }

    // Main method to replace values in the tree according to cousin sum rules
    public TreeNode replaceValueInTree(TreeNode root) {
        // Start DFS traversal from the root, passing it as the initial array
        dfs(new TreeNode[]{root});
        
        // Special case for the root: its value should always be 0, as it has no cousins
        root.val = 0;
        
        // Return the modified tree root
        return root;
    }
}