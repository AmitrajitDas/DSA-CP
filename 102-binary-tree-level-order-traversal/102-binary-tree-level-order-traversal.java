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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> wrapperList = new ArrayList<>();
        
        if(root == null) return wrapperList; // parent array
        
        q.offer(root);
        
        while(!q.isEmpty())
        {
            int levelNum = q.size(); // to store the updated queue size
            
            List<Integer> subList = new ArrayList<>(); // to store subarrays
            
            for(int i = 0; i < levelNum; i++)
            {
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                subList.add(q.poll().val);
            }
            
            wrapperList.add(subList);
        }
        
        return wrapperList;
    }
}