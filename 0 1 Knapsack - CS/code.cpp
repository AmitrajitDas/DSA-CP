///// SPACE OPTIMIZATION /////

int knapsack(vector<int> wt, vector<int> val, int n, int maxWeight) 
{
    vector<int> prev(maxWeight + 1, 0);
    
    for(int i = wt[0]; i <= maxWeight; i++) prev[i] = val[0];
    
    for(int idx = 1; idx < n; idx++)
    {
        for(int w = maxWeight; w >= 0; w--)
        {
            int notTake = 0 + prev[w];
            int take = -1e9;
            if(wt[idx] <= w) 
                take = val[idx] + prev[w - wt[idx]];
            
            prev[w] = max(notTake, take);
        }
    }
    
    return prev[maxWeight];
}


///// TABULATION /////

// int knapsack(vector<int> wt, vector<int> val, int n, int maxWeight) 
// {
//     vector<vector<int>> dp(n, vector<int> (maxWeight + 1, 0));
    
//     for(int i = wt[0]; i <= maxWeight; i++) dp[0][i] = val[0];
    
//     for(int idx = 1; idx < n; idx++)
//     {
//         for(int w = 0; w <= maxWeight; w++)
//         {
//             int notTake = 0 + dp[idx - 1][w];
//             int take = -1e9;
//             if(wt[idx] <= w) 
//                 take = val[idx] + dp[idx - 1][w - wt[idx]];
            
//             dp[idx][w] = max(notTake, take);
//         }
//     }
    
//     return dp[n - 1][maxWeight];
// }


///// MEMOIZATION /////

// int recurse(int idx, int w, vector<int> &wt, vector<int> &val, vector<vector<int>> &dp) 
// {
//     if(idx == 0)
//     {
//         if(wt[0] <= w) return val[0];
//         else return 0;
//     }
    
//      if(dp[idx][w] != -1) return dp[idx][w];
    
//     int notTake = 0 + recurse(idx - 1, w, wt, val, dp);
//     int take = -1e9;
//     if(wt[idx] <= w)
//         take = val[idx] + recurse(idx - 1, w - wt[idx], wt, val, dp);
    
//     return dp[idx][w] = max(notTake, take);
// }

// int knapsack(vector<int> weight, vector<int> value, int n, int maxWeight) 
// {
//     vector<vector<int>> dp(n, vector<int> (maxWeight + 1, -1));
// 	   return recurse(n - 1, maxWeight, weight, value, dp);
// }
