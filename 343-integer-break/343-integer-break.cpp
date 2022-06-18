///// TABULATION /////

class Solution {
public:
    int integerBreak(int n) 
    {
        vector<int> dp(n + 1, 0);
        dp[1] = 1;
        for(int i = 2; i <= n; i++)
        {
            for(int j = 1; j <= i / 2; j++)
            {
                dp[i] = max(dp[i], max(j, dp[j]) * max(i - j, dp[i - j]));
            }
        }
            
        return dp[n];
    }
};

///// MEMOIZATION /////

// class Solution {
// public:
    
//     int recurse(int n, int num, vector<int> &dp)
//     {
//         if(n <= 1) return 1;
        
//         if(dp[n] != -1) return dp[n];
        
//         int res;
//         if(n == num) res = 0;
//         else res = n;
        
//         for(int i = 1; i < n; i++)
//         {
//             int val = recurse(i, num, dp) * recurse(n - i, num, dp);
//             res = max(res, val);
//         }
        
//         return dp[n] = res;
//     }
    
//     int integerBreak(int n) 
//     {
//         vector<int> dp(n + 1, -1);
//         return recurse(n, n, dp);   
//     }
// };