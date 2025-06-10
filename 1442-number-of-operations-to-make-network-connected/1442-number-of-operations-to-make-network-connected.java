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

class Solution {
    /**
     * Calculate minimum operations to connect all computers
     * @param n - total number of computers (0 to n-1)
     * @param connections - 2D array where each row [u,v] represents cable between u and v
     * @return minimum cables to move, or -1 if impossible
     */
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);  // DSU to track connected components
        int extras = 0;      // Count of redundant cables (cycles)
        int components = 0;  // Count of separate components
        
        // Process all existing connections
        for(int[] edge : connections) {
            int u = edge[0], v = edge[1];  // Extract two computers connected by cable
            
            // Check if u and v are already in same component
            if(ds.findParent(u) == ds.findParent(v)) {
                // They're already connected - this cable creates a cycle
                // We can remove this cable and use it elsewhere
                extras++;
            } else {
                // They're in different components - unite them
                // This cable is useful for connecting components
                ds.unionBySize(u, v);
            }
        }
        
        // Count the number of separate components after processing all connections
        for(int i = 0; i < n; i++) {
            if(ds.parent[i] == i) {  // This computer is root of a component
                components++;
            }
        }
        
        // To connect 'components' separate groups, we need (components-1) cables
        // Check if we have enough extra cables to connect all components
        // If components = 3, we need 2 cables to connect them all
        // If components = 1, we need 0 cables (already connected)
        return extras >= components - 1 ? components - 1 : -1;
    }
}