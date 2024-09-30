class MyCircularDeque {
    int[] deq;
    int front, rear, count, k;

    public MyCircularDeque(int k) {
        deq = new int[k];  // Initialize the array with size k
        front = 0;         // Front starts at index 0
        rear = k - 1;      // Rear starts at the last index in a circular manner
        count = 0;         // Initially, there are no elements in the deque
        this.k = k;        // Save the capacity of the deque
    }

    // Insert an element at the front of the deque
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;  // If deque is full, insertion fails
        }
        front = (front - 1 + k) % k;  // Move the front pointer backward in a circular way
        deq[front] = value;           // Insert the value at the new front position
        count++;                      // Increment the number of elements
        return true;
    }

    // Insert an element at the rear of the deque
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;  // If deque is full, insertion fails
        }
        rear = (rear + 1) % k;  // Move the rear pointer forward in a circular way
        deq[rear] = value;      // Insert the value at the new rear position
        count++;                // Increment the number of elements
        return true;
    }

    // Delete an element from the front of the deque
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;  // If deque is empty, deletion fails
        }
        front = (front + 1) % k;  // Move the front pointer forward in a circular way
        count--;                  // Decrement the number of elements
        return true;
    }

    // Delete an element from the rear of the deque
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;  // If deque is empty, deletion fails
        }
        rear = (rear - 1 + k) % k;  // Move the rear pointer backward in a circular way
        count--;                    // Decrement the number of elements
        return true;
    }

    // Get the front item from the deque
    public int getFront() {
        return isEmpty() ? -1 : deq[front];  // Return -1 if empty, otherwise return front element
    }

    // Get the last item from the deque
    public int getRear() {
        return isEmpty() ? -1 : deq[rear];  // Return -1 if empty, otherwise return rear element
    }

    // Check whether the deque is empty
    public boolean isEmpty() {
        return count == 0;  // Deque is empty if count is 0
    }

    // Check whether the deque is full
    public boolean isFull() {
        return count == k;  // Deque is full if count equals the capacity k
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
