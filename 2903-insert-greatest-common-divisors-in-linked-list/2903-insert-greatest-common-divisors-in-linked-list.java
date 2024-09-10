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
    private int getGCD(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next == null) return head;
        ListNode first = head, second = head.next;

        while(second != null) {
            int gcdVal = getGCD(first.val, second.val);
            ListNode gcdNode = new ListNode(gcdVal);
            first.next = gcdNode;
            gcdNode.next = second;
            first = second;
            second = second.next;
        } 

        return head;
    }
}