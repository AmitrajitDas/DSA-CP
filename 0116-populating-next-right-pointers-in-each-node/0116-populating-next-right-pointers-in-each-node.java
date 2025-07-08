/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            Node nextNode = null;
            
            // Process all nodes at current level
            for(int i = 0; i < size; i++) {
                Node curr = q.poll();
                curr.next = nextNode;
                nextNode = curr;
                
                // Add children to queue for next level (right first, then left)
                // This ensures when we process them, we go from right to left
                if(curr.right != null) {
                    q.offer(curr.right);
                }
                if(curr.left != null) {
                    q.offer(curr.left);
                }
            }
        }
        
        return root;
    }
}