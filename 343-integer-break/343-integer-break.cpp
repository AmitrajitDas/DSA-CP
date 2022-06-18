class Solution {
public:
    
    int recurse(int n, int num, vector<int> &dp)
    {
        if(n == 1) return n;
        
        if(dp[n] != -1) return dp[n];
        
        int res;
        if(n == num) res = 0;
        else res = n;
        
        for(int i = 1; i < n; i++)
        {
            int val = recurse(i, num, dp) * recurse(n - i, num, dp);
            res = max(res, val);
        }
        
        return dp[n] = res;
    }
    
    int integerBreak(int n) 
    {
        vector<int> dp(n + 1, -1);
        return recurse(n, n, dp);   
    }
};