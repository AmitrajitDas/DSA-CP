class Solution {
public:    
    double champagneTower(int poured, int query_row, int query_glass) {
        vector<vector<double>> dp(101, vector<double> (101, 0.0));
        dp[0][0] = (double)poured; // base case

        for(int i = 0; i <= query_row; i++) {
            for(int j = 0; j <= i; j++) {
                double extra = (dp[i][j] - 1) / 2.0;
                if(extra > 0) {
                    dp[i + 1][j + 1] += extra;
                    dp[i + 1][j] += extra;
                }
            }
        }

        return min(1.0, dp[query_row][query_glass]);
    }
};