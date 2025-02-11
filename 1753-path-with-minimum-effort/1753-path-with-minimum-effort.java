class Solution {
    int[] drow = {-1, 0, 1, 0};
    int[] dcol = {0, 1, 0, -1};
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int[][] dist = new int[n][m];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        pq.add(new int[]{0, 0, 0});
        dist[0][0] = 0;

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int row = curr[0], col = curr[1], diff = curr[2];

            if(row == n - 1 && col == m - 1) {
                return diff;
            }

            for(int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                    int effort = Math.max(diff, Math.abs(heights[nrow][ncol] - heights[row][col]));
                    if(effort < dist[nrow][ncol]) {
                        dist[nrow][ncol] = effort;
                        pq.add(new int[]{nrow, ncol, effort});
                    }
                }
            }
        }

        return 0;
    }
}