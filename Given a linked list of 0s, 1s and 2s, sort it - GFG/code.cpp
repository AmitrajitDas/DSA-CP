class Solution
{
    public:
    
    Node *merge(Node *l1, Node *l2) {
        Node *ptr = new Node(0);
        Node *curr = ptr;
        
        while(l1 && l2) {
            
            if(l1->data <= l2->data) {
                curr->next = l1;
                l1 = l1->next;
            } 
            else {
                curr->next = l2;
                l2 = l2->next;
            }
            
            curr = curr->next;
        }
        
        if(l1 != NULL) {
            curr -> next = l1;
            l1 = l1->next;
        }
        
        if(l2 != NULL) {
            curr -> next = l2;
            l2 = l2 ->next;
        }
        
        return ptr->next;
    }
    
    //Function to sort a linked list of 0s, 1s and 2s.
    Node* segregate(Node *head) {
        
        if(!head || !head->next) return head;
        
        Node *slow = head, *fast = head, *temp = NULL;
        
        while(fast && fast->next) {
            temp = slow;
            slow = slow->next;
            fast = fast->next->next;
        }
        
        temp->next = NULL;
        
        Node *l1 = segregate(head);
        Node *l2 = segregate(slow);
        
        return merge(l1, l2);
        
    }
};
