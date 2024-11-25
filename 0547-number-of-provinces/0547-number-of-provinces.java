class Solution {
    // Depth-First Search (DFS) to mark all nodes in the same connected component
    private void dfs(int node, boolean[] vis, List<List<Integer>> adj) {
        vis[node] = true; // Mark the current node as visited
        for (final int neighbor : adj.get(node)) { // Iterate through all neighbors of the current node
            if (!vis[neighbor]) { // If the neighbor hasn't been visited
                dfs(neighbor, vis, adj); // Recur for the neighbor
            }
        }
    }

    // Find the number of connected components (provinces) in the graph
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length; // Number of vertices
        boolean[] vis = new boolean[v]; // Track visited nodes
        List<List<Integer>> adj = new ArrayList<>(); // Adjacency list for the graph
        int count = 0; // To count the number of connected components (provinces)

        // Initialize adjacency list
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // Convert adjacency matrix to adjacency list
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (isConnected[i][j] == 1 && i != j) { // If there's an edge and it's not a self-loop
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        // Perform DFS for each unvisited node to count connected components
        for (int i = 0; i < v; i++) {
            if (!vis[i]) { // If the node is not visited
                count++; // Increment the count for a new connected component
                dfs(i, vis, adj); // Mark all nodes in this component
            }
        }

        return count; // Return the total number of connected components
    }
}
