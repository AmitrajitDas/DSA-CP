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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode slow = dummy, fast = dummy;
        
        while(n > 0) {         // moving the fast pointer n times 
            fast = fast.next;
            n--;
        }
        
        while(fast.next != null) { // moving slow and fast pointer by one step until fast reaches last node
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next; // slow is prev node of our target node so we break the link
        
        return dummy.next;
        
    }
}