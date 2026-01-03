class Solution {
    // Modulo value for the result to prevent integer overflow
    int MOD = 1_000_000_007;
    
    // All 12 possible valid color patterns for a single row
    // Each string represents colors for 3 columns: [col0, col1, col2]
    // R = Red, Y = Yellow, G = Green
    // Valid patterns ensure no two adjacent columns in the same row have the same color
    private String[] states = {
        "RYG", "RGY", "RYR", "RGR",
        "YRG", "YGR", "YGY", "YRY",
        "GRY", "GYR", "GRG", "GYG"
    };
    
    /**
     * Recursive function with memoization to count valid ways to paint remaining rows
     * @param n Number of remaining rows to paint
     * @param prev Index of the pattern used in the previous row
     * @param dp Memoization table where dp[n][prev] stores the count of ways
     * @return Number of valid ways to paint n rows starting from pattern prev
     */
    private int solve(int n, int prev, int[][] dp) {
        // Base case: if no more rows to paint, we found 1 valid way
        if(n == 0) return 1;

        // Return cached result if already computed
        if(dp[n][prev] != -1) return dp[n][prev];

        int res = 0;
        String lastPattern = states[prev];
        
        // Try all 12 possible patterns for the current row
        for(int curr = 0; curr < 12; curr++) {
            // Skip if using the same pattern as previous row (not necessary but optimization)
            if(curr == prev) continue;
            
            String currPattern = states[curr];
            boolean isConflict = false;
            
            // Check if current pattern conflicts with previous pattern
            // Conflict occurs when any column has the same color in both rows
            for(int col = 0; col < 3; col++) {
                if(currPattern.charAt(col) == lastPattern.charAt(col)) {
                    isConflict = true;
                    break;
                }
            }
            
            // If no conflict, recursively solve for remaining rows with current pattern
            if(!isConflict) {
                res = (res + solve(n - 1, curr, dp)) % MOD;
            }
        }

        // Cache and return the result
        return dp[n][prev] = res;
    }

    /**
     * Main function to calculate number of ways to paint n x 3 grid
     * @param n Number of rows in the grid
     * @return Total number of valid ways to paint the grid modulo MOD
     */
    public int numOfWays(int n) {
        // Initialize DP table: dp[rows_left][previous_pattern_index]
        int[][] dp = new int[n][12];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        int res = 0;
        
        // Try each of the 12 patterns as the first row
        // and sum up all valid ways starting from each pattern
        for(int i = 0; i < 12; i++) {
            res = (res + solve(n - 1, i, dp)) % MOD;
        }
        
        return res;
    }
}