/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
        Node *iter = head, *front = head;
        
        // creating & connecting the intermediate the dummy nodes
        while(iter) {
            front = iter->next;
            Node *copy = new Node(iter->val);
            iter->next = copy;
            copy->next = front;
            iter = front;
        }
        
        iter = head;
        
        // cloning the random pointers
        while(iter) {
            if(iter->random) iter->next->random = iter->random->next;
            iter = iter->next->next;
        }
        
        iter = head;
        Node *dummy = new Node(0);
        Node *curr = dummy;
        
        // seperating original and deep cloned LL
        while(iter) {
            front = iter->next->next;
            curr->next = iter->next;
            iter->next = front;
            curr = curr->next;
            iter = iter->next;
        }
        
        return dummy->next;
    }
};