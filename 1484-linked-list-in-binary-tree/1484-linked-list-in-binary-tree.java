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
    private boolean dfs(ListNode curr, TreeNode root, ListNode head) {
        if(curr == null) return true;
        if(root == null) return false;

        // Try to continue matching from current position
        if(curr.val == root.val) {
            if(dfs(curr.next, root.left, head) || dfs(curr.next, root.right, head)) {
                return true;
            }
        }
        
        // Only try starting fresh if we're at the beginning of the list
        if(curr == head) {
            return dfs(head, root.left, head) || dfs(head, root.right, head);
        }
        
        return false;
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        return dfs(head, root, head);
    }
}