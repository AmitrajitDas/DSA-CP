/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseBetween(ListNode* head, int left, int right) {
        // If the list is empty or left equals right, no reversal needed.
        if (!head || left == right) return head;

        // Create a dummy node to simplify edge cases where the reversal starts at the beginning.
        ListNode* dummy = new ListNode();
        dummy->next = head;
        ListNode* prev = dummy;

        // Move the 'prev' pointer to the node before the left boundary.
        for (int i = 0; i < left - 1; i++) {
            prev = prev->next;
        }

        ListNode* curr = prev->next; // 'curr' points to the left boundary node.

        // Reverse the sublist from left to right.
        for (int i = 0; i < right - left; i++) {
            ListNode* next = curr->next; // 'next' points to the node to be moved.
            curr->next = next->next; // Adjust 'curr->next' to skip 'next'.
            next->next = prev->next; // Update 'next->next' to point to the previous node's next.
            prev->next = next; // Update the previous node's next to point to 'next'.
        }

        return dummy->next;
    }
};
