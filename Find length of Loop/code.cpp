
/*

struct Node {
    int data;
    struct Node *next;
    Node(int x) {
        data = x;
        next = NULL;
    }
};

*/

//Function to find the length of a loop in the linked list.
int countNodesinLoop(struct Node *head)
{
    Node *slow = head, *fast = head;
    
    while(fast && fast->next) {
        slow = slow->next;
        fast = fast->next->next;
        if(slow == fast) {
            Node *entry = slow->next;
            int count = 1;
            while(entry != slow) {
                count++;
                entry = entry->next;
            }
            
            return count;
        }
    }
    
    return 0;
}
