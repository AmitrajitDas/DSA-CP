class Pair<K, V> {
    public K first;
    public V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        // Queue to store rotten oranges and their time
        Queue<Pair<Pair<Integer, Integer>, Integer>> q = new LinkedList<>();
        int freshCount = 0; // Count of fresh oranges
        int minTime = 0;    // Track minimum time to rot all oranges

        // Initialize the queue and count fresh oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair<>(new Pair<>(i, j), 0)); // Rotten orange with time = 0
                } else if (grid[i][j] == 1) {
                    freshCount++; // Count fresh oranges
                }
            }
        }

        // Directions for adjacent cells (up, right, down, left)
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        // Track the number of fresh oranges that get rotten
        int rottenCount = 0;

        // BFS traversal
        while (!q.isEmpty()) {
            Pair<Pair<Integer, Integer>, Integer> ele = q.poll();
            int row = ele.first.first;
            int col = ele.first.second;
            int time = ele.second;

            // Update minimum time
            minTime = Math.max(minTime, time);

            // Explore all 4 adjacent cells
            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                // Check boundaries and if the cell contains a fresh orange
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1) {
                    grid[nrow][ncol] = 2; // Mark as rotten
                    q.offer(new Pair<>(new Pair<>(nrow, ncol), time + 1)); // Add to queue
                    rottenCount++; // Increment the count of rotten oranges
                }
            }
        }

        // If not all fresh oranges are rotten, return -1
        if (rottenCount != freshCount) return -1;

        return minTime; // Return the minimum time to rot all oranges
    }
}