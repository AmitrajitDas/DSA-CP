class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        Queue<Integer> q = new LinkedList<>();
        int[] colors = new int[V];
        Arrays.fill(colors, -1); // Initialize all nodes as uncolored

        for (int i = 0; i < V; i++) {
            if (colors[i] == -1) { // If the node is not colored, start BFS
                q.offer(i);
                colors[i] = 0; // Assign a color to the starting node

                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (int neighbor : graph[node]) {
                        if (colors[neighbor] == -1) { // If the neighbor is uncolored
                            q.offer(neighbor);
                            colors[neighbor] = 1 ^ colors[node]; // Assign opposite color
                        } else if (colors[neighbor] == colors[node]) {
                            // If the neighbor has the same color, it's not bipartite
                            return false;
                        }
                    }
                }
            }
        }

        return true; // All components are bipartite
    }
}
