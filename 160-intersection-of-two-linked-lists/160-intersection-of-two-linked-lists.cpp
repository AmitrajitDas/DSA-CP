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
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
     
        if(headA == NULL || headB == NULL) return NULL;
        
        ListNode *dummy1 = headA, *dummy2 = headB;
        
        while(dummy1 != dummy2) { // we run the loop until dummy1 and dummy2 intersects
            
            if(dummy1 == NULL) dummy1 = headB; // if dummy1 goes null then we restart from the alternate linked list
            else dummy1 = dummy1->next;
            
            if(dummy2 == NULL) dummy2 = headA; // if dummy2 goes null then we restart from the alternate linked list
            else dummy2 = dummy2->next;
        }
        
        
        return dummy1;
    }
};