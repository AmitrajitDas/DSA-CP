class Solution {
    private int solve(int currA, int clipA, int n, int[][] dp) {
        if (currA == n) {
            return 0;
        }
        if (currA > n) {
            return 1001;  // A large number representing an invalid path
        }

        // Check if the result for this state is already calculated
        if (dp[currA][clipA] != -1) {
            return dp[currA][clipA];
        }

        // Option 1: Copy All + Paste (2 steps)
        int copyAllPaste = Integer.MAX_VALUE;
        if (currA != clipA) {  // Avoid unnecessary copy-paste when already copied
            copyAllPaste = 2 + solve(currA + currA, currA, n, dp);
        }

        // Option 2: Paste only (1 step)
        int paste = Integer.MAX_VALUE;
        if (clipA > 0) {  // Ensure we have something to paste
            paste = 1 + solve(currA + clipA, clipA, n, dp);
        }

        // Take the minimum of both options
        dp[currA][clipA] = Math.min(copyAllPaste, paste);

        return dp[currA][clipA];
    }

    public int minSteps(int n) {
        if (n == 1) {
            return 0;  // No operations needed if n is 1
        }

        // Initialize the dp array with -1, indicating uncomputed states
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return 1 + solve(1, 1, n, dp);
    }
}