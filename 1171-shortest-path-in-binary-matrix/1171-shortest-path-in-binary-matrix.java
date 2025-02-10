class Solution {
    // Directions: 8 possible moves (up, up-right, right, down-right, down, down-left, left, up-left)
    int[] drow = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dcol = {0, 1, 1, 1, 0, -1, -1, -1};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        
        // Check if start or destination is blocked.
        if (grid[0][0] == 1 || grid[n-1][m-1] == 1)
            return -1;
        
        // Use a queue of int[] where each element holds {row, col, distance}
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[n][m];
        
        // Initialize distances with infinity
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        // Start at (0, 0) with distance 0
        q.offer(new int[]{0, 0, 0});
        dist[0][0] = 0;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0], col = curr[1], distance = curr[2];
            
            // If we've reached the destination, add one (to count the starting cell) and return
            if (row == n - 1 && col == m - 1) {
                return distance + 1;
            }
            
            // Explore all 8 directions
            for (int i = 0; i < 8; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                // Check if within bounds, not blocked, and if we can improve the distance
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                    grid[nrow][ncol] == 0 && distance + 1 < dist[nrow][ncol]) {
                    q.offer(new int[]{nrow, ncol, distance + 1});
                    dist[nrow][ncol] = distance + 1;
                }
            }
        }
        
        // Destination unreachable
        return -1;
    }
}
