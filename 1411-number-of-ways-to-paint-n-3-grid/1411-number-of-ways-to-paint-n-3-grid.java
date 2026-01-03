class Solution {
    int MOD = 1_000_000_007;
    private String[] states = {
        "RYG", "RGY", "RYR", "RGR",
        "YRG", "YGR", "YGY", "YRY",
        "GRY", "GYR", "GRG", "GYG"
    };
    private int solve(int n, int prev, int[][] dp) {
        if(n == 0) return 1;

        if(dp[n][prev] != -1) return dp[n][prev];

        int res = 0;
        String lastPattern = states[prev];
        
        for(int curr = 0; curr < 12; curr++) {
            if(curr == prev) continue;
            String currPattern = states[curr];
            boolean isConflict = false;
            for(int col = 0; col < 3; col++) {
                if(currPattern.charAt(col) == lastPattern.charAt(col)) {
                    isConflict = true;
                    break;
                }
            }
            if(!isConflict) {
                res = (res + solve(n - 1, curr, dp)) % MOD;
            }
        }

        return dp[n][prev] = res;
    }

    public int numOfWays(int n) {
        int[][] dp = new int[n][12];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int res = 0;
        for(int i = 0; i < 12; i++) {
            res = (res + solve(n - 1, i, dp)) % MOD;
        }
        return res;
    }
}
