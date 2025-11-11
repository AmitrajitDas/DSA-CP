class Solution {
    private int dfs(int idx, String[] strs, int m, int n, int[] zerosCount, int[] onesCount, int[][][] dp) {
        if(idx == strs.length) return 0;

        if(dp[idx][m][n] != -1) return dp[idx][m][n];

        int skip = dfs(idx + 1, strs, m, n, zerosCount, onesCount, dp);
        int take = 0;
        if(zerosCount[idx] <= m && onesCount[idx] <= n) {
            take = 1 + dfs(idx + 1, strs, m - zerosCount[idx], n - onesCount[idx], zerosCount, onesCount, dp);
        }

        return dp[idx][m][n] = Math.max(skip, take);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        // Pre-compute before recursion starts
        int len = strs.length;
        int[] zerosCount = new int[len];
        int[] onesCount = new int[len];

        for (int i = 0; i < len; i++) {
            for (char c : strs[i].toCharArray()) {
                if (c == '0') {
                    zerosCount[i]++;
                } else {
                    onesCount[i]++;
                }
            }
        }

        int[][][] dp = new int[strs.length][m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return dfs(0, strs, m, n, zerosCount, onesCount, dp);
    }
}