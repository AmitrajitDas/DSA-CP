int frogJump(int n, vector<int> &heights)
{
    vector<int> dp(n, 0);
    dp[0] = 0;
    
    for(int i = 1; i < n; i++) {
        int jumpone = dp[i-1] + abs(heights[i] - heights[i-1]);
        int jumptwo = INT_MAX;
        if(i > 1)
        	jumptwo = dp[i-2] + abs(heights[i] - heights[i-2]);
        dp[i] = min(jumpone, jumptwo);
    }
    
    return dp[n - 1];
}

    
    
