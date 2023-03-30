//// KNAPSACK PATTERN ////

class Solution {
public:
    int maxSatisfaction(vector<int>& satisfaction) {
        int n = satisfaction.size();
        sort(satisfaction.begin(), satisfaction.end());
        
        vector<vector<long long>> dp(n + 1, vector<long long>(n + 1, -1e9));

        //dp[i][j] = max value till 0.....i food and time is j currently
        
        //at time 0, we have no value. i.e. 0 - COOKING NOT YET STARTED
        for(int i = 0;i <= n;i++){
            dp[i][0] = 0;
        }
        
        //COOKING STARTED AT TIME = 1 and le't start with 0th food : dp[0][1]
        dp[0][1] = satisfaction[0];

        for(int i = 1; i < n; i++){
            for(int t = 1; t <= n; t++){
                long long take = satisfaction[i] * t + dp[i - 1][t - 1];
                long long notTake = dp[i - 1][t];
                
                dp[i][t] = max(take,notTake);
            }
        }

        //Since the Qn doesn't ask the maximum value at time = n, but
        //it asks for the maximum value overall at any time. 
        //So, we check the values for all time for 0....n-1 food i.e. last row depicts 0...n-1 (t[n-1])
        long long res = 0;
        for(int t = 1; t <= n; t++){
            res = max(res, dp[n - 1][t]);
        }

        return res;
    }
};

// class Solution {
// private:
//     int rec(int i, int t, vector<int>& satisfaction, vector<vector<int>>& dp) {
//         if(i >= satisfaction.size()) return 0;
//         if(dp[i][t] != -1) return dp[i][t];

//         int take = satisfaction[i] * t + rec(i + 1, t + 1, satisfaction, dp);
//         int notTake = rec(i + 1, t, satisfaction, dp);
//         return dp[i][t] = max(take, notTake);    
//     }
// public:
//     int maxSatisfaction(vector<int>& satisfaction) {
//         int n = satisfaction.size();
//         sort(satisfaction.begin(), satisfaction.end());
//         vector<vector<int>> dp(n + 1, vector<int> (n + 1, -1));
//         return rec(0, 1, satisfaction, dp);
//     }
// };