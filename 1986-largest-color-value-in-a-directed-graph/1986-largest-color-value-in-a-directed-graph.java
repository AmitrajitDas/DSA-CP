class Solution {
    /**
     * Find the largest path value in a directed graph where each node has a color.
     * Path value = maximum count of any single color along the path.
     * Uses topological sort + DP to detect cycles and find optimal solution.
     * 
     * Time: O(V + E) * 26 = O(26(V + E))
     * Space: O(V * 26) for DP table + O(V + E) for graph
     */
    public int largestPathValue(String colors, int[][] edges) {
        int V = colors.length();
        int[] indegree = new int[V];              // Track incoming edges for each node
        List<List<Integer>> adj = new ArrayList<>(); // Adjacency list representation
        Queue<Integer> q = new LinkedList<>();    // Queue for topological sort
        int[][] dp = new int[V][26];             // dp[node][color] = max count of color ending at node

        // Initialize adjacency list with empty lists
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the directed graph and calculate indegrees
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];  // Edge from u to v
            adj.get(u).add(v);             // Add v to u's adjacency list
            indegree[v]++;                 // Increment v's indegree
        }

        // Initialize: Add all nodes with indegree 0 to queue (starting points)
        // Set their color count to 1 for their own color
        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) {
                q.add(i);
                dp[i][colors.charAt(i) - 'a'] = 1;  // Node contributes 1 to its own color
            }
        }

        int countNode = 0;  // Count of processed nodes (for cycle detection)
        int res = 0;        // Maximum path value found so far
        
        // Kahn's algorithm for topological sort with DP
        while(!q.isEmpty()) {
            int u = q.poll();  // Process current node
            countNode++;       // Increment processed node count
            
            // Update global maximum with current node's best color count
            res = Math.max(res, dp[u][colors.charAt(u) - 'a']);

            // Process all neighbors of current node
            for(int v : adj.get(u)) {
                // Update DP values for neighbor v based on paths through u
                for(int i = 0; i < 26; i++) {
                    if(i == colors.charAt(v) - 'a') {
                        // If color i matches v's color, increment the count
                        dp[v][i] = Math.max(dp[v][i], dp[u][i] + 1);
                    } else {
                        // Otherwise, just propagate the count from u
                        dp[v][i] = Math.max(dp[v][i], dp[u][i]);
                    }
                }
                
                // Decrease indegree and add to queue if it becomes 0
                indegree[v]--;
                if(indegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        // Cycle detection: If we processed all nodes, no cycle exists
        if(countNode == V) {
            return res;  // Return the maximum path value found
        }

        return -1;  // Cycle detected, no valid solution
    }
}