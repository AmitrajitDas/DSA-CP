class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 0) {
                    dist[i][j] = 0;
                    q.offer(new Pair(i, j));
                }
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.first, col = p.second;

            for(int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && dist[nrow][ncol] == -1) {
                    dist[nrow][ncol] = dist[row][col] + 1;
                    q.offer(new Pair(nrow, ncol));
                }
            }
        }

        return dist;
    }
}