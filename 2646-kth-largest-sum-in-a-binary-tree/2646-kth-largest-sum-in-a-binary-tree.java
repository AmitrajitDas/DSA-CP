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
    public long kthLargestLevelSum(TreeNode root, int k) {
        // List to store the sum of each level of the tree
        List<Long> res = new ArrayList<>();
        
        // Queue to perform level-order traversal (Breadth-First Search) of the tree
        Queue<TreeNode> q = new LinkedList<>();
        
        // Start with the root node in the queue
        q.add(root);

        // Continue while there are still nodes to process in the queue
        while (!q.isEmpty()) {
            int n = q.size();  // Get the number of nodes at the current level
            long sum = 0;      // Variable to store the sum of values at the current level

            // Process all nodes at the current level
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();  // Remove and process the next node from the queue
                
                sum += node.val;  // Add the current node's value to the sum for this level
                
                // If the current node has a left child, add it to the queue to process at the next level
                if (node.left != null) q.add(node.left);
                
                // If the current node has a right child, add it to the queue to process at the next level
                if (node.right != null) q.add(node.right);
            }

            // After processing the entire level, store the level sum in the result list
            res.add(sum);
        }

        // Sort the level sums in descending order to get the largest sums at the start of the list
        res.sort(Collections.reverseOrder());

        // If k is larger than the number of levels, return -1 (invalid request)
        return k > res.size() ? -1 : res.get(k - 1);  // Return the k-th largest sum
    }
}