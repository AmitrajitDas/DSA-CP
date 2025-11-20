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
    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>(); // required for level-order traversal
        q.offer(root);
        while(!q.isEmpty()){
            sum = 0;
            int n = q.size(); // reset sum when deeper level is reached and accumulate for that level
            for(int i = 0; i < n; i++){
                TreeNode top = q.poll();
                sum += top.val;
                if(top.left != null) q.offer(top.left);
                if(top.right != null) q.offer(top.right);
            }
        }
        return sum; // final value held by 'sum' will be sum of values of nodes at the deepest level
    }
}