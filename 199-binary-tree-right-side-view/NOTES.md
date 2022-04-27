### **Approach: **
​
Create an vector data structure inside both the left and the right side view function
Call for the recursive _left and recursive_right function respectively with the (root,level,vector). Here level will be initially passed as 0.
Return the vector.
Now in the recursive_left function
If vector size is equal to the level then push_back its node value to the vector data structure.
Otherwise call recursive_left for (node->left,level+1,vector)
Call recursive_left for (node->right,level+1,vector)
Now in the recursive_right function
If vector size is equal to the level then push_back its node value to the vector data structure.
Otherwise call recursive_right for (node->right,level+1,vector)
Call recursive_right for (node->left,level+1,vector)