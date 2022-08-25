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
    ListNode* reverseList(ListNode* head) {
        if(!head || !head->next) return head;
        ListNode *revHead = reverseList(head->next);
        head->next->next = head;
        head->next = NULL;
        return revHead;
    }
};

// class Solution {
// public:
//     ListNode* reverseList(ListNode* head) {
//         if(!head) return NULL;
        
//         ListNode *prev = NULL;
//         ListNode *curr = head, *temp = head;
        
//         while(curr) {
//             curr = curr->next;
//             temp->next = prev;
//             prev = temp;
//             temp = curr;
//         }
        
//         return prev;
        
//     }
// };
