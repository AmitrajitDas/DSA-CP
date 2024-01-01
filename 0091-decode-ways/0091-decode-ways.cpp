// class Solution {
// public:
//     int rec(int idx, string s, int n, vector<int> &dp) {
//         if(dp[idx] != -1) return dp[idx];
//         if(s[idx] == '0') return dp[idx] = 0;
//         if(idx == n) return dp[idx] = 1;
//         int res = rec(idx + 1, s, n, dp);
//         if(idx < n - 1 && (s[idx] == '1' || (s[idx] == '2' && s[idx + 1] < '7'))) res += rec(idx + 2, s, n, dp);
//         return dp[idx] = res;
//     }

//     int numDecodings(string s) {
//         int n = s.size();
//         vector<int> dp(n + 1, -1);
//         return s.empty() ? 0 : rec(0, s, n, dp);
//     }
// };

class Solution {
public:
    int numDecodings(string s) {
        int n = s.size();
        vector<int> dp(n + 1, -1);
        dp[n] = 1;

        for(int i = n - 1; i >= 0; i--) {
            if(s[i] == '0') dp[i] = 0;
            else {
                dp[i] = dp[i + 1];
                if(i < n - 1 && (s[i] == '1' || (s[i] == '2' && s[i + 1] < '7'))) dp[i] += dp[i + 2];
            }
        }

        return s.empty() ? 0 : dp[0];
    }
};