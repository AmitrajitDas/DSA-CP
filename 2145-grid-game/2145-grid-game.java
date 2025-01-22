class Solution {
   public long gridGame(int[][] grid) {
       // Track minimum possible score robot 2 can get
       long res = Long.MAX_VALUE;
       // Grid width
       int n = grid[0].length;
       // Sum of remaining elements in first row
       long firstRowRemSum = grid[0][0];
       // Sum of elements collected in second row
       long secondRowRemSum = 0;
       
       // Calculate initial sum of first row
       for(int i = 1; i < n; i++) {
           firstRowRemSum += grid[0][i];
       }
       
       // For each possible turning point
       for(int i = 0; i < n; i++) {
           // Remove current element from first row sum
           firstRowRemSum -= grid[0][i];
           // Find max path robot 2 can take
           long r1MaxPath = Math.max(firstRowRemSum, secondRowRemSum);
           // Track minimum of all possible max paths
           res = Math.min(res, r1MaxPath);
           // Add current element to second row sum
           secondRowRemSum += grid[1][i];
       }
       
       return res;
   }
}