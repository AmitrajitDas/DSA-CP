### **Approach**
​
Approach:
​
In the previous method, we were taking extra time to store the unique combination with the help of a set.  To make the solution efficient we will have to decide on a method that will consider only the unique combinations without the help of additional data structure.
​
Lets  understand  with an example where arr = [1,2,2 ].
​
Initially start with an empty data structure. In the first recursion, call make a subset of size one, in the next recursion call a subset of size 2, and so on. But first, in order to make a subset of size one what options do we have?
​
We can pick up elements from either the first index or the second index or the third index. However, if we have already picked up two from the second index, picking up two from the third index will make another duplicate subset of size one. Since we are trying to avoid duplicate subsets we can avoid picking up from the third index. This should give us an intuition that whenever there are duplicate elements in the array we pick up only the first occurrence.
​
The next recursion calls will continue from the point the previous one ended.
​
Let’s summarize:-
​
Sort the input array.Make a recursive function that takes the input array ,the current subset,the current index and  a list of list/ vector of vectors to contain the answer.
Try to make a subset of size n during the nth recursion call and consider elements from every index while generating the combinations. Only pick up elements that are appearing for the first time during a recursion call to avoid duplicates.
Once an element is picked up, move to the next index.The recursion will terminate when the end of array is reached.While returning backtrack by removing the last element that was inserted.
​
**Time Complexity**: **O(2^n)** for generating every subset and O(k)  to insert every subset in another data structure if the average length of every subset is k. Overall O(k * 2^n).
​
**Space Complexity**: **O(2^n * k)** to store every subset of average length k. Auxiliary space is O(n)  if n is the depth of the recursion tree.