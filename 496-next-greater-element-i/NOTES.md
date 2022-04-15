### **Approach**
​
We use a stack to keep a decreasing sub-sequence, whenever we see a number i greater than top element of the stack we pop all elements less than i and for all the popped ones, their next greater element is i