class CustomStack {
    int top = -1;    // Keeps track of the index of the top element in the stack (initialized to -1 meaning stack is empty)
    int[] st;        // Array to hold the elements of the stack

    // Constructor to initialize the stack with a given maximum size
    public CustomStack(int maxSize) {
        st = new int[maxSize];  // Create a stack with a size of maxSize
    }

    // Pushes an element onto the stack
    public void push(int x) {
        // Check if the stack is not full before pushing the element
        if (top < st.length - 1) {  // Ensure we don't exceed the stack's size limit
            top++;                  // Increment the top index
            st[top] = x;            // Add the element to the top of the stack
        }
    }

    // Pops an element from the stack and returns it
    public int pop() {
        // If the stack is not empty, return the top element and decrease the top index
        if (top != -1) {
            return st[top--];  // Return the top element and decrement the top index
        }

        // If the stack is empty, return -1
        return -1;
    }

    // Increments the bottom k elements of the stack by val
    public void increment(int k, int val) {
        // Increment the first k elements or all elements (if k > number of elements in the stack)
        for (int i = 0; i < Math.min(k, top + 1); i++) {  // Loop through the minimum of k and the number of elements in the stack
            st[i] += val;  // Increment each of the bottom k elements by val
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);  
 * obj.push(x);                                 
 * int param_2 = obj.pop();                      
 * obj.increment(k, val);                       
 */
