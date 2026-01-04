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
class CBTInserter {
    private TreeNode root;
    private Deque<TreeNode> nodeQueue; // Queue of nodes that can still accept children

    public CBTInserter(TreeNode root) {
        this.root = root;
        this.nodeQueue = new LinkedList<>();
        
        if (root != null) {
            this.nodeQueue.offer(root);
            
            // Traverse the tree to find the first incomplete node
            while (true) {
                TreeNode node = this.nodeQueue.peek(); // Look at front node without removing
                
                if (node.left != null) {
                    this.nodeQueue.offer(node.left); // Add left child to queue
                    
                    if (node.right != null) {
                        this.nodeQueue.offer(node.right); // Add right child to queue
                        this.nodeQueue.poll(); // Node is complete, remove from queue
                    }
                }
                
                // Stop when we find a node missing at least one child
                if (node.left == null || node.right == null) {
                    break;
                }
            }
        }
    }
    
    public int insert(int val) {
        // Handle empty tree case
        if (this.root == null) {
            this.root = new TreeNode(val);
            this.nodeQueue.offer(this.root);
            return -1;
        }
        
        // Get the parent node (first incomplete node in queue)
        TreeNode parent = this.nodeQueue.peek();
        TreeNode node = new TreeNode(val);
        
        // New node will eventually be a parent, so add it to queue
        this.nodeQueue.offer(node);
        
        // Insert as left child if empty, otherwise as right child
        if (parent.left == null) {
            parent.left = node;
        } else {
            parent.right = node;
            this.nodeQueue.poll(); // Parent is now complete, remove from queue
        }
        
        return parent.val; // Return parent's value
    }
    
    public TreeNode get_root() {
        return this.root; // Return the root of the tree
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */