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
    
    void rev(ListNode *start, ListNode *end) {
        ListNode *prev = NULL, *curr = start, *next = start->next;
        
        while(prev != end) { // when prev reaches end curr gets out of boundary so we break the loop
            curr->next = prev;
            prev = curr;
            curr = next;
            if(next != NULL) next = next->next;
        }
    }
    
    ListNode* reverseKGroup(ListNode* head, int k) {
        
        if(k == 1 || head == NULL || head->next == NULL) return head;
        
        ListNode *start = head, *end = head;
        int len = k - 1;
        
        while(len--) {
            end = end->next;
            if(end == NULL) return head; // if end pointer reaches null then we return head as it'll not form k-group
        }
        
        ListNode *nextHead = reverseKGroup(end->next, k); // to get the head of node which is failing to form k-group
        rev(start, end); // reversing k-groups
        start->next = nextHead; // merging prev k-group with the head of next group
        return end; // we return end as it'll point to the reversed head
    }
};