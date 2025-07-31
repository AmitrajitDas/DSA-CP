class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        
        // next represents the row below current row (i+1)
        int[] next = new int[n];
        
        // Initialize next with the last row
        for(int j = 0; j < n; j++) {
            next[j] = matrix[m - 1][j];
        }
        
        // Fill from bottom to top
        for(int i = m - 2; i >= 0; i--) {
            int[] curr = new int[n];
            
            for(int j = 0; j < n; j++) {
                int down = matrix[i][j] + next[j];
                
                int diagLeft = Integer.MAX_VALUE;
                if(j - 1 >= 0) {
                    diagLeft = matrix[i][j] + next[j - 1];
                }
                
                int diagRight = Integer.MAX_VALUE;
                if(j + 1 < n) {
                    diagRight = matrix[i][j] + next[j + 1];
                }
                
                curr[j] = Math.min(down, Math.min(diagLeft, diagRight));
            }
            
            // Move curr to next for the next iteration
            next = curr;
        }
        
        // Find minimum from the first row (stored in next)
        int result = next[0];
        for(int j = 1; j < n; j++) {
            result = Math.min(result, next[j]);
        }
        
        return result;
    }
}