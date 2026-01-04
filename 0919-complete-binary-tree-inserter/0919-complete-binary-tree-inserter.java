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
    private Deque<TreeNode> nodeQueue;

    public CBTInserter(TreeNode root) {
        this.root = root;
        this.nodeQueue = new LinkedList<>();
        if (root != null) {
            this.nodeQueue.offer(root);
            while (true) {
                TreeNode node = this.nodeQueue.peek();
                if (node.left != null) {
                    this.nodeQueue.offer(node.left);
                    if (node.right != null) {
                        this.nodeQueue.offer(node.right);
                        this.nodeQueue.poll();
                    }
                }
                if (node.left == null || node.right == null) {
                    break;
                }
            }
        }
    }
    
    public int insert(int val) {
        if (this.root == null) {
            this.root = new TreeNode(val);
            this.nodeQueue.offer(this.root);
            return -1;
        }
        TreeNode parent = this.nodeQueue.peekFirst();
        TreeNode node = new TreeNode(val);
        this.nodeQueue.offer(node);
        if (parent.left == null) {
            parent.left = node;
        } else {
            parent.right = node;
            this.nodeQueue.pollFirst();
        }
        return parent.val;
    }
    
    public TreeNode get_root() {
        return this.root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */