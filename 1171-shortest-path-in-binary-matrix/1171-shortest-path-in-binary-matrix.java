class Solution {
    int[] drow = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dcol = {0, 1, 1, 1, 0, -1, -1, -1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        if (grid[0][0] == 1 || grid[n-1][m-1] == 1) {
            return -1;
        }
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        q.offer(new int[]{0, 0, 0});
        dist[0][0] = 0;

        while(!q.isEmpty()) {
            int curr[] = q.poll();
            int distance = curr[0], row = curr[1], col = curr[2];

            if(row == n - 1 && col == m - 1) {
                return distance + 1;
            }

            for(int i = 0; i < 8; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 0 && distance + 1 < dist[nrow][ncol]) {
                    dist[nrow][ncol] = distance + 1;
                    q.offer(new int[]{distance + 1, nrow, ncol});
                }
            }
        }

        return -1;
    }
}