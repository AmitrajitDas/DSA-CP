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
    // Helper method to calculate the GCD of two numbers using the Euclidean algorithm
    private int getGCD(int a, int b) {
        // Repeat until b becomes zero
        while(b != 0) {
            int temp = b;  // Store the current value of b
            b = a % b;     // Update b to the remainder of a divided by b
            a = temp;      // Update a to the old value of b (stored in temp)
        }
        // When b becomes zero, a contains the GCD
        return a;
    }

    // Main method to insert GCD nodes between every two nodes in the linked list
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        // If the list has only one node, return it directly (no pairs to compare)
        if(head.next == null) return head;

        // Initialize two pointers: first (current node) and second (next node)
        ListNode first = head, second = head.next;

        // Loop through the list until the second pointer reaches the end
        while(second != null) {
            // Calculate GCD between the values of the first and second nodes
            int gcdVal = getGCD(first.val, second.val);
            
            // Create a new node to store the GCD value
            ListNode gcdNode = new ListNode(gcdVal);
            
            // Insert the GCD node between the first and second nodes
            first.next = gcdNode;  // Connect first node to the new GCD node
            gcdNode.next = second; // Connect GCD node to the second node
            
            // Move the first pointer to the second node (the original next node)
            first = second;
            
            // Move the second pointer to the next node in the original list
            second = second.next;
        } 

        // Return the head of the modified list
        return head;
    }
}
