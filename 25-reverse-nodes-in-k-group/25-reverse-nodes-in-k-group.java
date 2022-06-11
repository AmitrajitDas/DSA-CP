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
    
    public void rev(ListNode start, ListNode end) {
        ListNode prev = null, curr = start, next = start.next;
        
        while(prev != end) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null) next = next.next; 
        }
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(k == 1 || head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode beforeStart = dummy, end = head; // beforeStart is used to point previous of start
        int i = 0;
        
        while(end != null) {
            i++;
            if(i%k == 0) { // if i modulus k gives 0 that means we can make a group with k nodes
                ListNode start = beforeStart.next, afterEnd = end.next; // afetrEnd is for next of end
                rev(start, end);
                beforeStart.next = end; // after reversing we point beforeStart to end which is the start node of reversed group
                start.next = afterEnd; // and point start to afterEnd as start is the last node of reversed group
                beforeStart = start; // now beforeStart points to start so that we can deduce the new start therefore
                end = afterEnd;
            } else end = end.next;
        }
        
        return dummy.next;
    }
}