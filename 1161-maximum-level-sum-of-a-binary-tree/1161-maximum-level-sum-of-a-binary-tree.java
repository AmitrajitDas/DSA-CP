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
    public int maxLevelSum(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        int maxLvlSum = Integer.MIN_VALUE, res = 1, lvl = 1;

        q.offer(root);

        while(!q.isEmpty()) {
            int currLvlSum = 0, size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                currLvlSum += node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right); 
            }
            if(currLvlSum > maxLvlSum) {
                maxLvlSum = currLvlSum;
                res = lvl;
            }
            lvl++;
        }

        return res;
    }
}