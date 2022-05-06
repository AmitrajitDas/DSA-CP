### **Approach :**
​
We need to calculate prefix sum and deduce the remainder of the elements in prefix array. We'll simply check if they exist in the hashmap and increase count with the remainder key's value & increase their occurence in map but if rem was -ve then we'll add it with k and repeat the same process.
​
Lastly we'll return the count which will have the number of subarrays.