class Solution {
    // Directions for moving to adjacent cells: up, right, down, left
    int[] drow = {-1, 0, 1, 0};
    int[] dcol = {0, 1, 0, -1};

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length; // Number of rows
        int m = heights[0].length; // Number of columns

        // Priority queue to store cells based on the minimum effort (difference in heights)
        // Each element in the queue is an array: [row, column, current effort]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // 2D array to store the minimum effort required to reach each cell
        int[][] dist = new int[n][m];

        // Initialize all distances to infinity
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // Start from the top-left cell (0, 0) with an initial effort of 0
        pq.add(new int[]{0, 0, 0});
        dist[0][0] = 0;

        // Process the priority queue
        while (!pq.isEmpty()) {
            // Poll the cell with the smallest effort
            int[] curr = pq.poll();
            int diff = curr[0]; // Current effort to reach this cell
            int row = curr[1]; // Current row
            int col = curr[2]; // Current column
            

            // If we reach the bottom-right cell, return the effort
            if (row == n - 1 && col == m - 1) {
                return diff;
            }

            // Explore all 4 possible directions
            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i]; // New row
                int ncol = col + dcol[i]; // New column

                // Check if the new cell is within the grid boundaries
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                    // Calculate the effort to move to the new cell
                    // Effort is the maximum of the current effort and the height difference
                    int effort = Math.max(diff, Math.abs(heights[nrow][ncol] - heights[row][col]));

                    // If this effort is better than the previously recorded effort for this cell
                    if (effort < dist[nrow][ncol]) {
                        // Update the minimum effort for this cell
                        dist[nrow][ncol] = effort;
                        // Add the new cell to the priority queue
                        pq.add(new int[]{effort, nrow, ncol});
                    }
                }
            }
        }

        // If the loop ends without returning, return 0 (though this should not happen for valid inputs)
        return 0;
    }
}