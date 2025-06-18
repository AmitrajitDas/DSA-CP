/**
 * Disjoint Set (Union-Find) data structure implementation
 * Optimized for lexicographically smallest equivalent string problem
 */
class DisjointSet {
    int[] parent, size;
    
    /**
     * Constructor to initialize the disjoint set
     * @param n - number of nodes (0 to n-1)
     */
    DisjointSet(int n) {
        // Create arrays with size n+1 to accommodate indices 0 to n
        parent = new int[n + 1];  // Parent array to store parent of each node
        size = new int[n + 1];    // Size array to store size of each component
        
        // Initialize each node as its own parent (separate component)
        // and each component size as 1
        for(int i = 0; i <= n; i++) {  // Include n to handle all valid indices
            parent[i] = i;  // Each node is initially its own parent (root)
            size[i] = 1;    // Each component initially has size 1
        }
    }
    
    /**
     * Find the ultimate parent (root) of a node with path compression
     * Path compression: makes the tree flatter by directly connecting 
     * nodes to their ultimate parent during traversal
     * This optimization makes future find operations much faster
     * @param node - the node whose ultimate parent we want to find
     * @return ultimate parent of the node
     */
    int findParent(int node) {
        // Base case: if node is its own parent, it's the root
        if(parent[node] == node) return node;
        
        // Path compression: update parent[node] to ultimate parent while recursing
        // This flattens the tree structure for better performance
        return parent[node] = findParent(parent[node]);
    }
    
    /**
     * Union by lexicographic order: merge two components by making the 
     * lexicographically smaller character the root
     * This is crucial for the "smallest equivalent string" problem
     * @param u - first node
     * @param v - second node
     */
    public void unionByLexOrder(int u, int v) {
        // Find the ultimate parents (roots) of both nodes
        int ulp_u = findParent(u);  // Ultimate parent of u
        int ulp_v = findParent(v);  // Ultimate parent of v
        
        // If both nodes already belong to same component, no union needed
        if(ulp_u == ulp_v) return;
        
        // Union by lexicographic order: always make the smaller character the parent
        // This ensures the lexicographically smallest character becomes the root
        if(ulp_u < ulp_v) {
            // ulp_u is smaller, make it the parent of ulp_v's component
            parent[ulp_v] = ulp_u;      
            size[ulp_u] += size[ulp_v]; // Update size of the merged component
        } else {
            // ulp_v is smaller, make it the parent of ulp_u's component
            parent[ulp_u] = ulp_v;      
            size[ulp_v] += size[ulp_u]; // Update size of the merged component
        }
    }
}

/**
 * Solution class for LeetCode 1061: Lexicographically Smallest Equivalent String
 * Problem: Given equivalence relationships between characters, find the lexicographically 
 * smallest string equivalent to the base string
 */
class Solution {
    /**
     * Main method to find the lexicographically smallest equivalent string
     * @param s1 - first string defining character equivalences
     * @param s2 - second string defining character equivalences (s1[i] == s2[i])
     * @param baseStr - the string to transform using the equivalences
     * @return lexicographically smallest equivalent string
     */
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // Initialize disjoint set for 26 lowercase English letters (a-z)
        // Use 25 since we need indices 0-25 for letters a-z
        DisjointSet ds = new DisjointSet(25);
        
        // Process all character equivalences from s1 and s2
        int n = s1.length();
        for(int i = 0; i < n; i++) {
            // Convert characters to indices: 'a'->0, 'b'->1, ..., 'z'->25
            int u = s1.charAt(i) - 'a';  // Character from first string
            int v = s2.charAt(i) - 'a';  // Character from second string
            
            // Union the two characters - they are equivalent
            // unionByLexOrder ensures the lexicographically smaller character becomes root
            ds.unionByLexOrder(u, v);
        }
        
        // Build the result string by replacing each character in baseStr
        // with its lexicographically smallest equivalent
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < baseStr.length(); i++) {
            // Convert current character to index
            int charIndex = baseStr.charAt(i) - 'a';
            
            // Find the lexicographically smallest equivalent character
            // This will be the root of the equivalence class
            int smallestEqChar = ds.findParent(charIndex);
            
            // Convert back to character and append to result
            sb.append((char)(smallestEqChar + 'a'));
        }
        
        return sb.toString();
    }
}