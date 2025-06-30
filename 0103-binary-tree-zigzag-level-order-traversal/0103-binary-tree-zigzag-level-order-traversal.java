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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // Handle edge case: empty tree
        if (root == null) {
            return new ArrayList<>();
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        boolean flag = false; // false = left to right, true = right to left
        List<List<Integer>> res = new ArrayList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode currNode = q.poll();
                level.add(currNode.val);
                
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
            
            // Reverse the level if flag is true (right to left traversal)
            if (flag) {
                Collections.reverse(level);
            }
            res.add(level);
            flag = !flag; // Toggle direction for next level
        }
        
        return res;
    }
}