class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }

        return dp[n]; 
    }
}

// class Solution {
//     private int[] dp;
//     private int rec(int n) {
//         if (n == 0) return 0;
//         if (dp[n] != -1) return dp[n];

//         int minCount = Integer.MAX_VALUE;
//         for (int i = 1; i * i <= n; i++) {
//             int res = 1 + rec(n - i * i);
//             minCount = Math.min(minCount, res);
//         }

//         dp[n] = minCount;
//         return minCount;
//     }

//     public int numSquares(int n) {
//         dp = new int[n + 1];
//         Arrays.fill(dp, -1);
//         return rec(n);
//     }
// }