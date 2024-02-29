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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        /*
        Doing BFS right-to-left means we can simply return the 
        last node's value and don't have to keep track of the first node 
        in the current row or even care about rows at all.
        */
        while(!q.isEmpty()) {
            root = q.poll();
            if(root.right != null) {
                q.offer(root.right);
            }
            if(root.left != null) {
                q.offer(root.left);
            }
        }
        return root.val;
    }
}