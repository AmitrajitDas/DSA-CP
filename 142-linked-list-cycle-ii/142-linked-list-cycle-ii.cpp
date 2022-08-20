/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        if(head == NULL) return NULL;
        ListNode *slow = head, *fast = head;
        
        while(fast->next != NULL && fast->next->next != NULL) {
            slow = slow->next;
            fast = fast->next->next;
            if(slow == fast) {
                ListNode *entry = head;
                while(entry != slow) {
                    slow = slow->next;
                    entry = entry->next;
                }
                
                return entry;
            }
        }
        
        return NULL;
    }
};