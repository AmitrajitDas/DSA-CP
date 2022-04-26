### **Approach**

Topological sort is applicable only on DAG

DFS:-
1. For each node we'll do DFS traversal.
2. If the node is not visited we'll push it on to the stack and mark it as visited.
3. If there is any adjacent node for the parent node we'll do DFS on them & push them in the stack with visited marking if they're already not visited.
4.After the end of traversal we'll have all the nodes topologically sorted in the stack.
