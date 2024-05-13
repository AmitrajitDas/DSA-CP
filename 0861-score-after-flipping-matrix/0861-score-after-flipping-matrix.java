class Solution {
    public int matrixScore(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        // if the first column has all 0s converted to 1s (to maximize sum MSB must be 1)
        int maxScore = (int)(Math.pow(2, m - 1) * n); 

        for(int j = 1; j < m; j++) {
            int oneCount = 0;
            for(int i = 0; i < n; i++) {
                if(grid[i][j] == grid[i][0]) {
                    oneCount++;
                }
            }
            int zeroCount = n - oneCount;
            // if 1s are greater in count we take that else we convert the 0s to 1s so the count
            // this is a simulation for that
            int ones = Math.max(oneCount, zeroCount);
            maxScore += (int)(Math.pow(2, m - j - 1) * ones);
        }

        return maxScore;
    }
}