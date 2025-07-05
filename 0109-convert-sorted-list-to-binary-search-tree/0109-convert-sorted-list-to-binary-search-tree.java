/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    /**
     * Recursively builds a balanced BST from a sorted linked list segment.
     * Uses the two-pointer technique to find the middle element efficiently.
     * 
     * @param head The starting node of the current segment (inclusive)
     * @param tail The ending node of the current segment (exclusive)
     * @return The root of the BST constructed from the segment
     */
    private TreeNode buildTree(ListNode head, ListNode tail) {
        // Base case: empty segment
        if(head == tail) {
            return null;
        }
        
        // Find the middle node using Floyd's cycle detection algorithm (tortoise and hare)
        ListNode slow = head, fast = head;
        
        // Move slow pointer one step and fast pointer two steps
        // When fast reaches the end, slow will be at the middle
        while(fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Create root node with the middle element's value
        // This ensures the tree remains balanced
        TreeNode root = new TreeNode(slow.val);
        
        // Recursively build left subtree from elements before the middle
        root.left = buildTree(head, slow);
        
        // Recursively build right subtree from elements after the middle
        root.right = buildTree(slow.next, tail);
        
        return root;
    }
    
    /**
     * Converts a sorted singly-linked list to a height-balanced BST.
     * The algorithm maintains the BST property by using the middle element as root
     * and recursively building left and right subtrees.
     * 
     * Time Complexity: O(n log n) where n is the number of nodes
     * Space Complexity: O(log n) for the recursion stack
     * 
     * @param head The head of the sorted linked list
     * @return The root of the balanced BST
     */
    public TreeNode sortedListToBST(ListNode head) {
        // Start the recursive process with the entire list
        return buildTree(head, null);
    }
}