class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n + 1];
        long share = 0, MOD = (long)1e9 + 7;

        dp[1] = 1;

        for(int days = 2; days <= n; days++) {
            if(days - delay > 0) {
                share = (share + dp[days - delay] + MOD) % MOD;
            }

            if(days - forget > 0) {
                share = (share - dp[days - forget] + MOD) % MOD;
            }

            dp[days] = share;
        }

        long pplKnow = 0;
        for(int i = n - forget + 1; i <= n; i++) {
            pplKnow = (pplKnow + dp[i]) % MOD;
        }

        return (int)pplKnow;
    }
}