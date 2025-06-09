/**
 * Disjoint Set Union (DSU) / Union-Find data structure
 * Used to efficiently track connected components in a graph
 */
class DisjointSet {
    int[] parent, size;
    
    /**
     * Constructor to initialize the disjoint set
     * @param n - number of nodes (0 to n-1)
     */
    DisjointSet(int n) {
        parent = new int[n + 1];  // Parent array to store parent of each node
        size = new int[n + 1];    // Size array to store size of each component
        
        // Initialize each node as its own parent (separate component)
        // and each component size as 1
        for(int i = 0; i < n; i++) {
            parent[i] = i;  // Each node is initially its own parent
            size[i] = 1;    // Each component initially has size 1
        }
    }
    
    /**
     * Find the ultimate parent (root) of a node with path compression
     * Path compression: makes the tree flatter by directly connecting 
     * nodes to their ultimate parent during traversal
     * @param node - the node whose ultimate parent we want to find
     * @return ultimate parent of the node
     */
    int findParent(int node) {
        if(parent[node] == node) return node;  // Base case: node is its own parent
        // Path compression: update parent[node] to ultimate parent while recursing
        return parent[node] = findParent(parent[node]);
    }
    
    /**
     * Union by size: merge two components by attaching smaller component 
     * to the root of larger component to keep tree balanced
     * @param u - first node
     * @param v - second node
     */
    public void unionBySize(int u, int v) {
        int ulp_u = findParent(u);  // Find ultimate parent of u
        int ulp_v = findParent(v);  // Find ultimate parent of v
        
        // If both nodes already belong to same component, no union needed
        if(ulp_u == ulp_v) return;
        
        // Union by size: attach smaller component to larger one
        if(size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;      // Make ulp_v parent of ulp_u
            size[ulp_v] += size[ulp_u]; // Update size of resulting component
        } else {
            parent[ulp_v] = ulp_u;      // Make ulp_u parent of ulp_v
            size[ulp_u] += size[ulp_v]; // Update size of resulting component
        }
    }
}

/**
 * Solution class to find number of connected components (friend circles)
 * in an undirected graph represented by adjacency matrix
 */
class Solution {
    /**
     * Find the number of friend circles (connected components)
     * @param isConnected - 2D adjacency matrix where isConnected[i][j] = 1 
     *                     means person i and person j are directly connected
     * @return number of friend circles (connected components)
     */
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;  // Number of people/nodes
        int count = 0;               // Counter for number of components
        DisjointSet ds = new DisjointSet(V);  // Create DSU for V nodes
        
        // Process the adjacency matrix
        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                // If there's a connection between i and j (and they're different people)
                if(isConnected[i][j] == 1 && i != j) {
                    ds.unionBySize(i, j);  // Union them into same component
                }
            }
        }
        
        // Count the number of connected components
        // A node is a root of a component if it's its own parent
        for(int i = 0; i < V; i++) {
            if(ds.parent[i] == i) {
                count++;  // This node represents a separate component
            }
        }
        
        return count;  // Return total number of friend circles
    }
}