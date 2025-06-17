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
        for(int i = 0; i <= n; i++) {  // Fixed: changed < to <=
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
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] candidate1 = null;  // Fixed: proper initialization
        int[] candidate2 = null;  // Fixed: proper initialization
        DisjointSet ds = new DisjointSet(n);  // Fixed: pass n instead of n+1
        
        // parent array is already initialized to 0 by default
        
        // First pass: identify node with two parents
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if(parent[v] == 0) {
                parent[v] = u;
            } else {
                candidate1 = new int[]{parent[v], v};
                candidate2 = new int[]{u, v};
                edge[1] = 0;  // Mark this edge for skipping
            }
        }
        
        // Second pass: find cycle or confirm which candidate to remove
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if(v == 0) {  // Skip marked edge
                continue;
            }
            
            if(ds.findParent(u) == ds.findParent(v)) {
                // Cycle detected
                if(candidate1 == null) {
                    return new int[]{u, v};
                } else {
                    return candidate1;
                }
            } else {
                ds.unionBySize(u, v);
            }
        }
        
        return candidate2;
    }
}