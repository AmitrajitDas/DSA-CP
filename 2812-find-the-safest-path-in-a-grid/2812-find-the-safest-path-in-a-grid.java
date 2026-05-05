import java.util.*;

class Solution {
    private int[] drow = {0, 0, -1, 1};
    private int[] dcol = {-1, 1, 0, 0};

    private void bfs(List<List<Integer>> grid, int[][] safeness, int n) {
        Queue<int[]> q = new LinkedList<>();

        // entry point for multisource bfs should be the thieves
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    safeness[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0], col = curr[1];
            int currSafeness = safeness[row][col];

            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && safeness[nrow][ncol] > currSafeness + 1) {
                    safeness[nrow][ncol] = currSafeness + 1;
                    q.offer(new int[]{nrow, ncol});
                }
            }
        }
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }

        int[][] safeness = new int[n][n];
        for (int[] row : safeness) Arrays.fill(row, Integer.MAX_VALUE);
        bfs(grid, safeness, n);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.offer(new int[]{safeness[0][0], 0, 0});
        
        // Add a vis array to prevent infinite cycles
        boolean[][] vis = new boolean[n][n];

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currSafeness = curr[0];
            int row = curr[1], col = curr[2];
            
            // if it's the last cell, we've found the answer
            if (row == n - 1 && col == n - 1) {
                return currSafeness;
            }

            // Skip if we've already processed this cell with a higher or equal safeness
            if (vis[row][col]) {
                continue;
            }
            vis[row][col] = true;

            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && !vis[nrow][ncol]) {
                    int s = Math.min(currSafeness, safeness[nrow][ncol]);
                    pq.offer(new int[]{s, nrow, ncol});
                }
            }
        }

        return -1;
    }
}