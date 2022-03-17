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
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean l2r = true;
        
        while(!q.isEmpty())
        {   
            int size = q.size();
            List<Integer> ds = new ArrayList<>(size);
            
            for(int i = 0; i < size; i++)
            {                                
                if(q.peek().left != null)
                    q.offer(q.peek().left);
            
            
                if(q.peek().right != null)
                    q.offer(q.peek().right);
                
                // checking direction of traversal
                if(l2r == true) ds.add(q.poll().val);
                else ds.add(0, q.poll().val);
            }
            
            //after traversing each level
            l2r = !l2r;
            res.add(ds);
        }
        
        return res;
    }
}