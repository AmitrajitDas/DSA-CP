class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int res = 0;   
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++) {
            int highestVal = Integer.MIN_VALUE;
            for(int j = 0; j < m; j++) {
                dp[i][j] = nums1[i] * nums2[j];
                if(i > 0 && j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j] + dp[i - 1][j - 1]);
                }

                if(i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }

                if(dp[i][j] < highestVal) {
                    dp[i][j] = highestVal;
                } else {
                    highestVal = dp[i][j];
                }
            }

            res = highestVal;
        }

        return res;
    }
}