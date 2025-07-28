class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        
        // Base case: Fill the last row
        for(int j = 0; j < m; j++) {
            dp[m-1][j] = triangle.get(m-1).get(j);
        }
        
        // Fill from second last row to first row (bottom-up)
        for(int i = m-2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) { // Row i has i+1 elements (0 to i)
                int down = triangle.get(i).get(j) + dp[i+1][j];
                int diag = triangle.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(down, diag);
            }
        }
        
        return dp[0][0];
    }
}