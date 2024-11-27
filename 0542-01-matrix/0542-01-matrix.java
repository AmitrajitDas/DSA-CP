class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    // Define directions for moving in rows and columns (up, right, down, left)
    int[] drow = {-1, 0, 1, 0};
    int[] dcol = {0, 1, 0, -1};
    
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] res = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        
        // Initialize the result matrix and populate the initial sources (0 cells)
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 0) {
                    q.offer(new Pair(i, j)); // Add source cell to the queue
                    res[i][j] = 0; // Distance to a 0 cell is 0
                } else {
                    res[i][j] = -1; // Initialize non-source cells to -1
                }
            }
        }

        while(!q.isEmpty()) {
            Pair p = q.poll(); // Get cell from the front of the queue
            for(int i = 0; i < 4; i++) {
                int nrow = p.first + drow[i]; // Calculate new row index
                int ncol = p.second + dcol[i]; // Calculate new column index

                // Check if the new indices are within bounds and the cell is not visited
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && res[nrow][ncol] == -1) {
                    q.offer(new Pair(nrow, ncol)); // Add cell to the queue
                    res[nrow][ncol] = res[p.first][p.second] + 1; // Update distance
                }
            }
        }

        return res;
    }
}