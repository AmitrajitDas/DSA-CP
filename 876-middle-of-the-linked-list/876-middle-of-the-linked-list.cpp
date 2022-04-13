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
    ListNode* middleNode(ListNode* head) {
        
        ListNode* curr = head;
        int size = 0;
        
        while(curr) {
            curr = curr->next;
            size++;
        }
        
        ListNode* temp = head;
        int mid = size/2;
        int i = 0;
        
        while(temp && i < mid) {
            temp = temp->next;
            i++;
        }
            
        return temp;
    }
};