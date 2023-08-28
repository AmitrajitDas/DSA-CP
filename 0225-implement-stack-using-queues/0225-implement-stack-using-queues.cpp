/////// USING SINGLE QUEUE \U0001f60e ///////

class MyStack {
public:
    queue<int> q;  // Declare a queue to implement the stack behavior

    MyStack() {
        // Default constructor, no specific initialization required
    }
    
    void push(int x) {
        q.push(x);  // Add the new element to the back of the queue
        for(int i = 0; i < q.size() - 1; i++) {
            q.push(q.front()); // Rotate all elements in the queue by one position
            q.pop(); // Remove the element from the front to maintain the rotation
        }
    }
    
    int pop() {
        int res = q.front();  // Store the front element (top of the stack)
        q.pop();              // Remove the front element from the queue (top of the stack)
        return res;           // Return the stored front element (previous top of the stack)
    }
    
    int top() {
        return q.front();  // Return the front element of the queue (top of the stack)
    }
    
    bool empty() {
        return q.empty();  // Check if the queue is empty to determine if the stack is empty
    }
};

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack* obj = new MyStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * bool param_4 = obj->empty();
 */