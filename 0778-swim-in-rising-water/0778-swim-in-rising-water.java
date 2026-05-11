class Solution {
    int[] drow = {1, 0, -1, 0};
    int[] dcol = {0, 1, 0, -1};
    public int swimInWater(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int res = Integer.MIN_VALUE;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] vis = new boolean[n][m];

        pq.offer(new int[]{grid[0][0], 0, 0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int elevation = curr[0], row = curr[1], col = curr[2];

            if(vis[row][col]) continue;
            vis[row][col] = true;
            res = Math.max(res, elevation);

            if(row == n - 1 && col == m - 1) return res;

            for(int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol]) {
                    pq.offer(new int[]{grid[nrow][ncol], nrow, ncol});
                }
            }
        }

        return -1;
    }
}