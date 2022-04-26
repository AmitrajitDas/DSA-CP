## Topological sort is applicable only on DAG

### **Approach(DFS)**
1. For each node we'll do DFS traversal.
2. If the node is not visited we'll push it on to the stack and mark it as visited.
3. If there is any adjacent node for the parent node we'll do DFS on them & push them in the stack with visited marking if they're already not visited.
4. After the end of traversal we'll have all the nodes topologically sorted in the stack.

### **Approach(BFS)**: 
1. We store the indegrees for each node in an array.
2. We traverse through the array and check if any index has value 0, if there is we push that node in a queue and push the values in a list.
3. Now we check for the adjacent nodes of the front element of the queue, and reduce its indegrees by one & we repeat the same process of checking zero values.
4. If indegree becomes 0 we push it in the queue & repeat the above process until the queue becomes empty.

