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
    
    ListNode* rev(ListNode* head) {
        if(!head || !head->next) return head;
        ListNode *revhead = rev(head->next);
        head->next->next = head;
        head->next = NULL;
        return revhead;
    }
    
    bool isPalindrome(ListNode* head) {
        ListNode *slow = head, *fast = head;
        
        while(fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
        }
        
        ListNode *curr = slow, *start = head, *end;
        end = rev(curr);
        
        while(start && end) {
            if(start->val == end->val) {
                start = start->next;
                end = end->next;
            } else return false;
        }
        
        return true;
    }
};