class Solution {
    private boolean dfsCycle(int node, int[] vis, List<List<Integer>> adj) {
        if (vis[node] == 2) {
            return true; // Cycle detected
        }
        vis[node] = 2; // Marking as visited in the current DFS path

        for (Integer neighbor : adj.get(node)) {
            if (vis[neighbor] != 1) { // If not completely processed
                if (dfsCycle(neighbor, vis, adj)) {
                    return true;
                }
            }
        }

        vis[node] = 1; // Marking as completely processed
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build adjacency list (prerequisite[1] → prerequisite[0])
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]); // b → a (b must be completed before a)
        }

        int[] vis = new int[numCourses]; // 0: unvisited, 1: fully processed, 2: in current DFS path

        // Run DFS to detect cycles
        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                if (dfsCycle(i, vis, adj)) {
                    return false; // If cycle exists, return false
                }
            }
        }

        return true; // No cycle detected, we can finish all courses
    }
}