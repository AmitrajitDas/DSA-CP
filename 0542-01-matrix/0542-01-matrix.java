// Helper class to represent a pair of integers (row, column)
class Pair {
    int first, second;

    // Constructor to initialize the pair
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        // Get dimensions of the matrix
        int n = mat.length, m = mat[0].length;

        // Queue to perform BFS
        Queue<Pair> q = new LinkedList<>();

        // Distance matrix initialized to -1 for unvisited cells
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1); // Fill each row with -1
        }

        // Add all '0' cells to the queue and set their distance to 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;    // Distance for '0' cells is 0
                    q.offer(new Pair(i, j)); // Add to the queue
                }
            }
        }

        // Direction arrays for moving up, right, down, and left
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        // Perform BFS to calculate distances
        while (!q.isEmpty()) {
            Pair p = q.poll();          // Get the next cell
            int row = p.first;          // Current row
            int col = p.second;         // Current column

            // Check all 4 neighboring cells
            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i]; // New row
                int ncol = col + dcol[i]; // New column

                // If within bounds and not visited
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && dist[nrow][ncol] == -1) {
                    // Update distance of the neighbor
                    dist[nrow][ncol] = dist[row][col] + 1;

                    // Add the neighbor to the queue for further BFS
                    q.offer(new Pair(nrow, ncol));
                }
            }
        }

        // Return the distance matrix
        return dist;
    }
}
