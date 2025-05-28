class Solution {
   // Build adjacency list representation of the tree from edges array
   private List<List<Integer>> buildGraph(int[][] edges) {
       int n = edges.length + 1; // Number of nodes = number of edges + 1 (tree property)
       List<List<Integer>> adj = new ArrayList<>(n);
       
       // Initialize adjacency list for each node
       for(int i = 0; i < n; i++) {
           adj.add(new ArrayList<>());
       }
       
       // Add edges to adjacency list (undirected graph)
       for(int[] edge : edges) {
           int u = edge[0], v = edge[1];
           adj.get(u).add(v); // Add v to u's adjacency list
           adj.get(v).add(u); // Add u to v's adjacency list
       }
       
       return adj;
   }
   
   // Count nodes reachable from currNode within k steps using DFS
   private int countReachableNodes(int currNode, int parentNode, int k, List<List<Integer>> adj) {
       // Base case: if k < 0, we've exceeded our step limit
       if(k < 0) return 0;
       
       // Count current node as reachable
       int count = 1;
       
       // Explore all adjacent nodes
       for(int adjNode : adj.get(currNode)) {
           // Avoid going back to parent node (prevents infinite recursion in tree)
           if(adjNode != parentNode) {
               // Recursively count reachable nodes from adjacent node with k-1 steps remaining
               count += countReachableNodes(adjNode, currNode, k - 1, adj);
           }
       }
       
       return count;
   }
   
   public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
       // Build adjacency lists for both trees
       List<List<Integer>> adj1 = buildGraph(edges1);
       List<List<Integer>> adj2 = buildGraph(edges2);
       
       // Find the maximum number of nodes reachable in tree2 within k-1 steps
       // We use k-1 because we need 1 step to cross from tree1 to tree2
       int m = adj2.size();
       int maxCount2 = 0;
       for(int i = 0; i < m; i++) {
           // Try each node in tree2 as potential connection point
           maxCount2 = Math.max(maxCount2, countReachableNodes(i, -1, k - 1, adj2));
       }
       
       // Calculate result for each node in tree1
       int n = adj1.size();
       int[] res = new int[n];
       for(int i = 0; i < n; i++) {
           // For each node in tree1: 
           // Total reachable = nodes reachable in tree1 + max nodes reachable in tree2
           res[i] = countReachableNodes(i, -1, k, adj1) + maxCount2;
       }
       
       return res;
   }
}