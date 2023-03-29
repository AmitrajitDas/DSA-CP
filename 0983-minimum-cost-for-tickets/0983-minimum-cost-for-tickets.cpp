class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        int n = days.size();
        int lastDay = days.back();
        vector<int> dp(lastDay + 1, 0);
        unordered_set<int> st(days.begin(), days.end());

        dp[0] = 0;

        for(int i = 1; i <= lastDay; i++) {
            if(st.find(i) == st.end()) {
                dp[i] = dp[i - 1];
                continue;
            }

            dp[i] = INT_MAX;

            int oneDay = costs[0] + dp[max(i - 1, 0)];
            // 7 day pass
            int sevenDays = costs[1] + dp[max(i - 7, 0)];

            // 30 day pass
            int thirtyDays = costs[2] + dp[max(i - 30, 0)];

            dp[i] = min({oneDay, sevenDays, thirtyDays});
        }

        return dp[lastDay];
    }
};


// class Solution {
// public:
//     int mincostTickets(vector<int>& days, vector<int>& costs) {
//         int n = days.size();
//         vector<int> dp(365);
//         dp[n] = 0;

//         for(int i = n - 1; i >=0; i--) {
//             int oneDay = costs[0] + dp[i + 1];

//             int j = i;
//             // 7 day pass
//             while(j < n && days[j] - days[i] < 7) j++;
//             int sevenDays = costs[1] + dp[j];

//             j = i;
//             // 30 day pass
//             while(j < n && days[j] - days[i] < 30) j++;
//             int thirtyDays = costs[2] + dp[j];

//             dp[i] = min({oneDay, sevenDays, thirtyDays});
//         }

//         return dp[0];
//     }
// };
 
// class Solution {
// private:
//     int rec(int i, int n, vector<int>& days, vector<int>& costs, vector<int>& dp) {
//         if(i >= n) return 0;
//         if(dp[i] != -1) return dp[i];

//         // 1 day pass
//         int oneDay = costs[0] + rec(i + 1, n, days, costs, dp);

//         int j = i;
//         // 7 day pass
//         while(j < n && days[j] - days[i] < 7) j++;
//         int sevenDays = costs[1] + rec(j, n, days, costs, dp);

//         j = i;
//         // 30 day pass
//         while(j < n && days[j] - days[i] < 30) j++;
//         int thirtyDays = costs[2] + rec(j, n, days, costs, dp);

//         return dp[i] = min({oneDay, sevenDays, thirtyDays});
//     }
// public:
//     int mincostTickets(vector<int>& days, vector<int>& costs) {
//         int n = days.size();
//         vector<int> dp(365, -1);
//         return rec(0, n, days, costs, dp);
//     }
// };