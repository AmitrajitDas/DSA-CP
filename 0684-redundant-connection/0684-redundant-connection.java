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
    public boolean unionBySize(int u, int v) {
        int ulp_u = findParent(u);  // Find ultimate parent of u
        int ulp_v = findParent(v);  // Find ultimate parent of v
        
        // If both nodes already belong to same component, no union needed
        if(ulp_u == ulp_v) return false;
        
        // Union by size: attach smaller component to larger one
        if(size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;      // Make ulp_v parent of ulp_u
            size[ulp_v] += size[ulp_u]; // Update size of resulting component
        } else {
            parent[ulp_v] = ulp_u;      // Make ulp_u parent of ulp_v
            size[ulp_u] += size[ulp_v]; // Update size of resulting component
        }

        return true;
    }
}

class Solution {
    /**
     * Finds the redundant connection that creates a cycle in the graph
     * Uses Union-Find to detect when adding an edge would create a cycle
     * 
     * @param edges - array of edges, each edge is [u, v]
     * @return the redundant edge that should be removed
     */
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;  // n edges means n nodes (since it's a tree + 1 edge)
        DisjointSet ds = new DisjointSet(n);
        
        // Process edges one by one
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            
            // Try to union the two nodes
            // If they're already connected, this edge creates a cycle
            if(!ds.unionBySize(u, v)) {
                return edge;  // Return the redundant edge
            }
        }
        
        // This should never be reached if input is valid
        return new int[]{};
    }
}