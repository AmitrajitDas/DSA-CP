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
    ListNode* rotateRight(ListNode* head, int k) {
        
        if(k == 0 || !head || !head->next) return head;
        
        ListNode* curr = head;
        int len = 1;
        
        while(curr->next) { // length of LL
            len++;
            curr = curr->next;
        }
        
        curr->next = head;
        k = k % len; // if source LL gets repeated after multiple of K rotations
        k = len - k;
        
        while(k--) {
            curr = curr->next;
        }
        
        // making the new head and breaking connection
        head = curr->next;
        curr->next = NULL;
        
        return head;
    }
};